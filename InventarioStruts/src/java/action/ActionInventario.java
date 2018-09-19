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
    private static final String errorModINV = "errorModINV";

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
            if (cant == null || cant.equals("") || cant == 0) {
                adver = "* Escriba la cantidad del producto.";
            }
            if (stock == null || stock.equals("") || cant == 0) {
                adver2 = "* Escriba la cantidad del stock del producto.";
            }
            if (!adver.equals("")) {
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
            
                mensaje = "Complete los campos: " + adver + adver2 + "";
                request.setAttribute("mensaje", mensaje);
                return mapping.findForward(errorIngresarINV);
            }

            InventarioMantenimiento minv = new InventarioMantenimiento();
            Inventario inv = minv.consultarInventarioProducto(idProducto, idSucursal);

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
            if(inv1 == 1){
                mensaje = "El Inventario se ha añadido Exitosamente";
                request.setAttribute("mensaje", mensaje);
            } else {
                mensaje = "El Inventario no fue añadido Exitosamente";
                request.setAttribute("error", mensaje);
            }
            
            return mapping.findForward(agregarINV);
        }

        if (action.equals("Consultar")) {
            String mensaje = "";
            InventarioMantenimiento minv = new InventarioMantenimiento();
            List<Inventario> listaInv = minv.consultarTodosInventario();
            
            if (listaInv.isEmpty()) {
                mensaje = "No hay datos en el Inventario";
                request.setAttribute("info", mensaje);
                return mapping.findForward(errorINV);
            } else {
                formBean.setListaInv(listaInv);
                return mapping.findForward(consultarINV);
            }
        }
        
        if (action.equals("Actualizar")) {
            String mensaje = "";
            InventarioMantenimiento minv = new InventarioMantenimiento();
            Inventario inv = minv.consultarInventario(idInventario);

            if(inv == null){
                
                mensaje = "No hay datos en el Inventario";
                request.setAttribute("error", mensaje);
                return mapping.findForward(errorINV);
                
            }else{
                
                formBean.setIdInventario(inv.getIdInventario());
                formBean.setIdProducto(inv.getProductos().getIdProducto());
                formBean.setCant(inv.getCant());
                formBean.setStock(inv.getStock());
                formBean.setEstado(inv.getEstado());
                formBean.setIdProveedor(inv.getProveedores().getIdProveedor());
                formBean.setIdSucursal(inv.getSucursales().getIdSucursal());
                
                return mapping.findForward(modificarINV);
            }
        }
        
        if (action.equals("Modificar")) {
            String mensaje = "";
            InventarioMantenimiento minv = new InventarioMantenimiento();
            
            if (stock == null || stock.equals("") || cant == 0) {
                mensaje = "Escriba la cantidad del stock del producto.";
            }
            if (!mensaje.equals("")) {
                request.setAttribute("error", mensaje);
                return mapping.findForward(errorModINV);
            }
          
            int r = minv.ActualizarInventario(idInventario, idProducto, cant, stock, estado, idProveedor, idSucursal);
            
            List<Inventario> listInv = minv.consultarTodosInventario();
            formBean.setListaInv(listInv);
            if(r == 1){
                mensaje = "El Inventario se ha actualizado Exitosamente";
                request.setAttribute("mensaje", mensaje);
            } else {
                mensaje = "El Inventario no fue actualizado Exitosamente";
                request.setAttribute("error", mensaje);
            }
            return mapping.findForward(consultarINV);
        }

        return null;
    }

}
