package action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimientos.InventarioMantenimiento;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionforms.ActionFormInventario;
import mantenimientos.ProductosMantenimiento;
import mantenimientos.ProveedorMantenimiento;
import mantenimientos.SucursalesMantenimiento;
import persistencias.Inventario;
import persistencias.Productos;
import persistencias.Proveedores;
import persistencias.Sucursales;

public class ActionInventario extends org.apache.struts.action.Action {

    private static final String agregarINV = "insertarINV";
    private static final String consultarINV = "consultarINV";
    private static final String consultarIdINV = "consultarIdINV";
    private static final String modificarINV = "modificarINV";
    private static final String eliminarINV = "eliminarINV";
    private static final String errorINV = "errorINV";
    private static final String errorIngresarINV = "errorIngresarINV";
    private static final String irFormInventario = "irFormInventario";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionFormInventario formBean = (ActionFormInventario) form;
        Integer idInventario = formBean.getIdInventario();
        Integer idProducto = formBean.getIdProducto();
        Integer idProveedor = formBean.getIdProveedor();
        Integer idSucursal = formBean.getIdSucursal();
        Integer cant = formBean.getCant();
        Integer stock = formBean.getStock();
        String estado = formBean.getEstado();
        String action = formBean.getAction();

        if (formBean == null || action == null) {
            return mapping.findForward(errorINV);
        }

        if (action.equals("Insertar")) {
            String adver = "";
            String adver2 = "";
            String mensaje = "";
            if (cant == null || cant.equals("")) {
                adver = "* Escriba la cantidad del producto <br>";
            }
            if (stock == null || stock.equals("")) {
                adver2 = "* Escriba la cantidad del stock del producto <br>";
            }
            if (!adver.equals("")) {
                mensaje = "Complete los campos: <br>" + adver + adver2 + "";
                request.setAttribute("mensaje", mensaje);
                return mapping.findForward(errorIngresarINV);
            }

            InventarioMantenimiento minv = new InventarioMantenimiento();
            System.out.println("Del JSP Producto: "+idProducto);
            Inventario inv = minv.consultarInventarioProducto(idProducto);
            System.out.println("Consulta Producto: "+inv);

            if (inv != null) {
            ProductosMantenimiento mprod = new ProductosMantenimiento();
            List<Productos> listaProd = mprod.consultarTodosProductos();
            formBean.setListProd(listaProd);
            request.setAttribute("listaProd", listaProd);

            ProveedorMantenimiento mprov = new ProveedorMantenimiento();
            List<Proveedores> listaProv = mprov.consultarTodosProveedores();
            formBean.setListProv(listaProv);
            request.setAttribute("listaProv", listaProv);

            SucursalesMantenimiento msuc = new SucursalesMantenimiento();
            List<Sucursales> listaSuc = msuc.consultarTodosSucursales();
            formBean.setListSuc(listaSuc);
            request.setAttribute("listaSuc", listaSuc);
                
            mensaje = "Este Producto ya tiene un Inventario";
            request.setAttribute("mensaje", mensaje);
            return mapping.findForward(errorIngresarINV);
            }
            
            int inv1 = minv.guardarInventario(idInventario, idProducto, cant, stock, estado, idProveedor, idSucursal);
            List<Inventario> listInv = minv.consultarTodosInventario();
            formBean.setListaInv(listInv);

            System.out.println("Si es 1 Funcionó " + inv1);
            return mapping.findForward(agregarINV);
        }

        if (action.equals("Consultar")) {
            InventarioMantenimiento minv = new InventarioMantenimiento();
            List<Inventario> listaInv = minv.consultarTodosInventario();
            
            if (listaInv == null) {
                formBean.setError("<div class='alert alert-danger'>No hay Datos Guardados EN EL INVENTARIO</div>");
                return mapping.findForward(errorINV);
            } else {
                formBean.setListaInv(listaInv);
                return mapping.findForward(consultarINV);
            }
        }

        if (action.equals("Agregar Inventario")) {
            ProductosMantenimiento mprod = new ProductosMantenimiento();
            List<Productos> listaProd = mprod.consultarTodosProductos();
            formBean.setListProd(listaProd);
            request.setAttribute("listaProd", listaProd);

            ProveedorMantenimiento mprov = new ProveedorMantenimiento();
            List<Proveedores> listaProv = mprov.consultarTodosProveedores();
            formBean.setListProv(listaProv);
            request.setAttribute("listaProv", listaProv);

            SucursalesMantenimiento msuc = new SucursalesMantenimiento();
            List<Sucursales> listaSuc = msuc.consultarTodosSucursales();
            formBean.setListSuc(listaSuc);
            request.setAttribute("listaSuc", listaSuc);

            return mapping.findForward(irFormInventario);
        }

        return null;
    }

}
