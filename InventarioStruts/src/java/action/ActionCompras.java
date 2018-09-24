package action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimientos.ComprasMantenimiento;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionforms.ActionFormCompras;
import java.text.SimpleDateFormat;
import java.util.Date;
import mantenimientos.InventarioMantenimiento;
import mantenimientos.ProductosMantenimiento;
import mantenimientos.ProveedorMantenimiento;
import mantenimientos.SucursalesMantenimiento;
import persistencias.Compras;
import persistencias.Inventario;
import persistencias.Productos;
import persistencias.Proveedores;
import persistencias.Sucursales;

public class ActionCompras extends org.apache.struts.action.Action {

    private static final String agregarCOM = "insertarCom";
    private static final String consultarCOM = "consultarCOM";
    private static final String consultarIdCOM = "consultarIdCOM";
    private static final String modificarCOM = "modificarCOM";
    private static final String eliminarCOM = "eliminarCOM";
    private static final String errorCOM = "errorCOM";
    private static final String borrarCOM = "borrarCOM";
    private static final String irFormCOM = "irFormCompras";
    private static final String errorInsertarCompra = "errorInsertarCom";
    
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy '-' hh:mm a");

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionFormCompras formBean = (ActionFormCompras) form;
        Integer idCompra = formBean.getIdCompra();
        Integer idProducto = formBean.getIdProducto();
        Integer idProveedor = formBean.getIdProveedor();
        Integer idSucursal = formBean.getIdSucursal();
        Integer cantidad = formBean.getCantidad();
        Double monto = formBean.getMonto();
        String fechaCompras = formBean.getFechaCompra();
        String action = formBean.getAction();
        String mensaje = "";

        if (formBean == null || action == null) {
            mensaje = "Hay un problema en el Sistema";
            request.setAttribute("info", mensaje);
            return mapping.findForward(errorCOM);
        }

        if (action.equals("Insertar")) {
            String adver = "";
            String adver2 = "";

            if (cantidad == null || cantidad.equals("") || cantidad == 0) {
                adver = "- Cantidad. <br>";
            }
            if (monto == null || monto.equals("") || monto == 0) {
                adver2 = "- Monto.";
            }
            if (!adver.equals("")) {
                ProveedorMantenimiento mprov = new ProveedorMantenimiento();
                List<Proveedores> listaProv = mprov.consultarTodosProveedores();
                formBean.setListaProv(listaProv);
                request.setAttribute("listaProv", listaProv);

                ProductosMantenimiento mprod = new ProductosMantenimiento();
                List<Productos> listaProd = mprod.consultarTodosProductos();
                formBean.setListaProd(listaProd);
                request.setAttribute("listaProd", listaProd);
                
                SucursalesMantenimiento msuc = new SucursalesMantenimiento();
                List<Sucursales> listaSuc = msuc.consultarTodosSucursales();
                formBean.setListSuc(listaSuc);
                request.setAttribute("listaSuc", listaSuc);
                
                mensaje = "Por favor completar las casillas: <br>" + adver + adver2 + "";
                request.setAttribute("error", mensaje);
                return mapping.findForward(errorInsertarCompra);
            }
            
            String fechaHoy = formatoFecha.format(new Date());
            System.out.println("Fecha: "+fechaHoy);
            ComprasMantenimiento mcom = new ComprasMantenimiento();
            
            Double mont = monto*cantidad;
            
            int com2 = mcom.guardarCompras(idProducto, idProveedor, cantidad, mont, fechaHoy);
            List<Compras> listaCom = mcom.consultarTodosCompras();
            formBean.setListaCom(listaCom);
            if(com2 == 1){
                mensaje = "La Compra ha sido registrada con Éxito";
                request.setAttribute("mensaje", mensaje);
            } else {
                mensaje = "La Compra NO ha sido registrada con Éxito";
                request.setAttribute("error", mensaje);
            }
            
            // --- Insertar Inventario de la Compra ---
            InventarioMantenimiento minv = new InventarioMantenimiento();
            Inventario inv = minv.consultarInventarioProducto(idProducto, idSucursal);
            System.out.println("inv: "+inv);
            
            if(inv != null){
                System.out.println("Hola Mundo");
                System.out.println("Producto: "+inv.getProductos().getIdProducto());
                Integer idInventario = inv.getIdInventario();
                Integer idProduc = inv.getProductos().getIdProducto();
                Integer cant = inv.getCant() + cantidad;
                Integer stock = inv.getStock();
                String estado = "";
                Integer idProv = inv.getProveedores().getIdProveedor();
                Integer idSuc = inv.getSucursales().getIdSucursal();
                if(cant > stock){
                    estado = "Disponible";
                } else if(cant < stock && cant > 0 || cant == stock && cant > 0){
                    estado = "Stock";
                } else {
                    estado = "Sin Existencias";
                }
                int r = minv.actualizarInventario(idInventario, idProduc, cant, stock, estado, idProv, idSuc);
                if(r == 1){
                    System.out.println("El Inventario ha sido modificado Exitosamente");
                } else {
                    System.out.println("El Inventario falló al modificar");
                }
            } else {
                Integer cant = cantidad;
                Integer stock = 5;
                String estado = "";
                if(cant > stock){
                    estado = "Disponible";
                } else if(cant < stock && cant > 0 || cant == stock && cant > 0){
                    estado = "Stock";
                } else {
                    estado = "Sin Existencias";
                }
                int inv1 = minv.guardarInventario(0, idProducto, cant, stock, estado, idProveedor, idSucursal);
                if(inv1 == 1){
                    System.out.println("Se ha creado el inventario de la compra");
                } else {
                    System.out.println("No se ha podido crear el inventario de la compra");
                }
            }
            
            //--- FIN DEL INVENTARIO --
            
            return mapping.findForward(agregarCOM);
        }

        if (action.equals("Consultar")) {
            ComprasMantenimiento mcom = new ComprasMantenimiento();
            List<Compras> listaCom = mcom.consultarTodosCompras();
            
            if (listaCom.isEmpty()) {
                mensaje = "No Se ha hecho ninguna Compra Aún";
                System.out.println("Mensaje: "+mensaje);
                request.setAttribute("info", mensaje);
            } else {
                formBean.setListaCom(listaCom);
            }
            return mapping.findForward(consultarCOM);
        }

        if (action.equals("Cancelar")) {
            ComprasMantenimiento mcom = new ComprasMantenimiento();
            List<Compras> listaCom = mcom.consultarTodosCompras();

            if (listaCom == null) {
                formBean.setError("<div class='alert alert-danger'>No hay Datos Guardados en la base de Compras </div>");
                return mapping.findForward(consultarCOM);
            } else {
                formBean.setListaCom(listaCom);
                return mapping.findForward(consultarCOM);
            }
        }

        if (action.equals("Agregar Compra")) {
            ProveedorMantenimiento mprov = new ProveedorMantenimiento();
            List<Proveedores> listaProv = mprov.consultarTodosProveedores();
            formBean.setListaProv(listaProv);
            request.setAttribute("listaProv", listaProv);

            ProductosMantenimiento mprod = new ProductosMantenimiento();
            List<Productos> listaProd = mprod.consultarTodosProductos();
            formBean.setListaProd(listaProd);
            request.setAttribute("listaProd", listaProd);
            
            SucursalesMantenimiento msuc = new SucursalesMantenimiento();
            List<Sucursales> listaSuc = msuc.consultarTodosSucursales();
            formBean.setListSuc(listaSuc);
            request.setAttribute("listaSuc", listaSuc);

            return mapping.findForward(irFormCOM);
        }

        if (action.equals("Eliminar")) {
            ComprasMantenimiento mcom = new ComprasMantenimiento();
            Compras com = mcom.consultarCompra(idCompra);
            if (com == null) {
                formBean.setError("<div class='alert alert-danger'>No se pudo realizar la consulat par poder eliminar el ID</div>");
                return mapping.findForward(errorCOM);
            } else {
                formBean.setIdCompra(com.getIdCompra());
                formBean.setIdProducto(com.getProductos().getIdProducto());
                formBean.setIdProveedor(com.getProveedores().getIdProveedor());
                formBean.setCantidad(com.getCantidad());
                formBean.setMonto(com.getMonto());
                formBean.setFechaCompras(com.getFechaCompra());

                ProductosMantenimiento mprod = new ProductosMantenimiento();
                List<Productos> listaProd = mprod.consultarTodosProductos();
                formBean.setListaProd(listaProd);
                request.setAttribute("listaProd", listaProd);

                ProveedorMantenimiento mprov = new ProveedorMantenimiento();
                List<Proveedores> listaProv = mprov.consultarTodosProveedores();
                formBean.setListaProv(listaProv);
                request.setAttribute("listaProv", listaProv);

                return mapping.findForward(eliminarCOM);

            }
        }
        if (action.equals("Borrar")) {
            ComprasMantenimiento mcom = new ComprasMantenimiento();
            mcom.eliminarCompra(idCompra);
            formBean.setError(borrarCOM);
            List<Compras> listaCom = mcom.consultarTodosCompras();
            formBean.setListaCom(listaCom);
            return mapping.findForward(borrarCOM);
        }

        if (action.equals("Actualizar")) {
            ComprasMantenimiento mcom = new ComprasMantenimiento();
            Compras com = mcom.consultarCompra(idCompra);

            if (com == null) {
                formBean.setError("<div class='alert alert-danger'> No se puede realizar la consulta para actualizar...</div>");
                return mapping.findForward(errorCOM);
            } else {

                System.out.println("ID: " + com.getIdCompra());
                formBean.setIdCompra(com.getIdCompra());
                formBean.setIdProducto(com.getProductos().getIdProducto());
                formBean.setIdProveedor(com.getProveedores().getIdProveedor());
                formBean.setCantidad(com.getCantidad());
                formBean.setMonto(com.getMonto());
                formBean.setFechaCompras(com.getFechaCompra());

                ProductosMantenimiento mprod = new ProductosMantenimiento();
                List<Productos> listaProd = mprod.consultarTodosProductos();
                formBean.setListaProd(listaProd);
                request.setAttribute("listaProd", listaProd);

                ProveedorMantenimiento mprov = new ProveedorMantenimiento();
                List<Proveedores> listaProv = mprov.consultarTodosProveedores();
                formBean.setListaProv(listaProv);
                request.setAttribute("listaProv", listaProv);
                
                SucursalesMantenimiento msuc = new SucursalesMantenimiento();
                List<Sucursales> listaSuc = msuc.consultarTodosSucursales();
                formBean.setListSuc(listaSuc);
                request.setAttribute("listaSuc", listaSuc);

                return mapping.findForward(modificarCOM);
            }
        }

        if (action.equals("Modificar")) {
            ComprasMantenimiento mcom = new ComprasMantenimiento();
            System.out.println("ID: " + idCompra);
            System.out.println("ID Producto: " + idProducto);
            System.out.println("ID Prov: " + idProveedor);
            System.out.println("Cant: " + cantidad);
            System.out.println("Monto: $" + monto);
            System.out.println("Fecha: " + fechaCompras);
            int r = mcom.ActualizarCompras(idCompra, idProducto, idProveedor, cantidad, monto, fechaCompras);
            System.out.println("Ya sabes 1: " + r);
            List<Compras> listaCom = mcom.consultarTodosCompras();
            formBean.setListaCom(listaCom);
            return mapping.findForward(consultarCOM);
        }

        if (action.equals("Volver")) {
            ComprasMantenimiento mcom = new ComprasMantenimiento();
            List<Compras> listaCom = mcom.consultarTodosCompras();
            System.out.println("lista es" + listaCom);
            if (listaCom == null) {
                formBean.setError("<div class='alert alert-danger'>No hay Datos Guardados en la base de Compras </div>");
                return mapping.findForward(consultarCOM);
            } else {
                formBean.setListaCom(listaCom);
                return mapping.findForward(consultarCOM);
            }
        }

        return null;
    }

}
