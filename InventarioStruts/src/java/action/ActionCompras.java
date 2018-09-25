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
    private static final String todasCom = "todasCom";
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
        String nDocumento = formBean.getNDocumento();
        Integer idProducto = formBean.getIdProducto();
        Integer idProveedor = formBean.getIdProveedor();
        Integer idSucursal = formBean.getIdSucursal();
        Integer cantidad = formBean.getCantidad();
        Double monto = formBean.getMonto();
        String fechaCompras = formBean.getFechaCompra();
        String estadoCompra = formBean.getEstadoCompra();
        String action = formBean.getAction();
        String mensaje = "";

        if (formBean == null || action == null) {
            mensaje = "Hay un problema en el Sistema";
            request.setAttribute("info", mensaje);
            return mapping.findForward(errorCOM);
        }

        if (action.equals("Ingresar")) {
            String adver = "";
            String adver1 = "";
            String adver2 = "";
            
            System.out.println("ND: "+nDocumento);

            if (nDocumento == null || nDocumento.equals("")) {
                adver = "- N° de Doc. <br>";
            }
            if (cantidad == null || cantidad == 0) {
                adver1 = "- Cantidad. <br>";
            }
            if (monto == null || monto == 0) {
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
                
                mensaje = "Por favor completar las casillas: <br>" + adver + adver1 + adver2 + "";
                request.setAttribute("error", mensaje);
                return mapping.findForward(errorInsertarCompra);
            }
            
            String fechaHoy = formatoFecha.format(new Date());
            ComprasMantenimiento mcom = new ComprasMantenimiento();
            
            Compras val = mcom.valNDoc(nDocumento);
            
            if(val != null){
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
                
                mensaje = "El N° de Factura ya Existe";
                request.setAttribute("error", mensaje);
                return mapping.findForward(errorInsertarCompra);
            }
            
            Double mont = monto*cantidad;
            
            int com2 = mcom.guardarCompras(nDocumento, idProducto, cantidad, mont, idProveedor, fechaHoy);
            List<Compras> listaCom = mcom.consultarComprasDisponibles();
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
            
            if(inv != null){
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
            List<Compras> listaCom = mcom.consultarComprasDisponibles();
            
            if (listaCom.isEmpty()) {
                mensaje = "No Se ha hecho ninguna Compra Aún";
                request.setAttribute("info", mensaje);
            } else {
                formBean.setListaCom(listaCom);
            }
            return mapping.findForward(consultarCOM);
        }

        if (action.equals("Cancelar")) {
            ComprasMantenimiento mcom = new ComprasMantenimiento();
            List<Compras> listaCom = mcom.consultarComprasDisponibles();

            if (listaCom.isEmpty()) {
                mensaje = "No Se ha hecho ninguna Compra Aún";
                request.setAttribute("info", mensaje);
            } else {
                formBean.setListaCom(listaCom);
                return mapping.findForward(consultarCOM);
            }
        }
        
        if (action.equals("Archivadas")) {
            ComprasMantenimiento mcom = new ComprasMantenimiento();
            List<Compras> listaCom = mcom.consultarComprasArchivadas();
            
            if (listaCom.isEmpty()) {
                mensaje = "No Se ha archivado ninguna Compra Aún";
                request.setAttribute("info", mensaje);
            } else {
                formBean.setListaCom(listaCom);
            }
            return mapping.findForward(todasCom);
        }

        if (action.equals("Ingresar Compra")) {
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

        if (action.equals("Actualizar")) {
            ComprasMantenimiento mcom = new ComprasMantenimiento();
            Compras com = mcom.consultarCompra(idCompra);

            if (com == null) {
                mensaje = "Hay un problema en el Sistema!";
                request.setAttribute("error", mensaje);
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
                
                SucursalesMantenimiento msuc = new SucursalesMantenimiento();
                List<Sucursales> listaSuc = msuc.consultarTodosSucursales();
                formBean.setListSuc(listaSuc);
                request.setAttribute("listaSuc", listaSuc);

                return mapping.findForward(modificarCOM);
            }
        }

        if (action.equals("Modificar")) {
            ComprasMantenimiento mcom = new ComprasMantenimiento();
            int r = mcom.actualizarCompras(idCompra, nDocumento, idProducto, cantidad, monto, idProveedor, fechaCompras, estadoCompra);
            
            if(r == 1){
                mensaje = "Se ha modificado con Éxito!";
                request.setAttribute("mensaje", mensaje);
            } else {
                mensaje = "Error al modificar!";
                request.setAttribute("error", mensaje);
            }
            
            List<Compras> listaCom = mcom.consultarComprasDisponibles();
            formBean.setListaCom(listaCom);
            return mapping.findForward(consultarCOM);
        }

        if (action.equals("Archivar")) {
            ComprasMantenimiento mcom = new ComprasMantenimiento();
            int key = Integer.parseInt(request.getParameter("id"));
            
            Compras arch = mcom.consultarCompra(key);
            String nD = arch.getNDocumento();
            int idPro = arch.getProductos().getIdProducto();
            int cant = arch.getCantidad();
            double mont = arch.getMonto();
            int idProv = arch.getProveedores().getIdProveedor();
            String fechaCom = arch.getFechaCompra();
            int r = mcom.archivarCompras(key, nD, idPro, cant, mont, idProv, fechaCom);
            
            if(r == 1){
                mensaje = "Se ha archivado con Éxito!";
                request.setAttribute("mensaje", mensaje);
            } else {
                mensaje = "Error al archivar!";
                request.setAttribute("error", mensaje);
            }
            
            List<Compras> listaCom = mcom.consultarComprasDisponibles();
            formBean.setListaCom(listaCom);
            return mapping.findForward(consultarCOM);
        }
        
        if (action.equals("Activar")) {
            ComprasMantenimiento mcom = new ComprasMantenimiento();
            int key = Integer.parseInt(request.getParameter("id"));
            
            Compras arch = mcom.consultarCompra(key);
            String nD = arch.getNDocumento();
            int idPro = arch.getProductos().getIdProducto();
            int cant = arch.getCantidad();
            double mont = arch.getMonto();
            int idProv = arch.getProveedores().getIdProveedor();
            String fechaCom = arch.getFechaCompra();
            int r = mcom.activarCompra(key, nD, idPro, cant, mont, idProv, fechaCom);
            
            if(r == 1){
                mensaje = "Se ha activado con Éxito!";
                request.setAttribute("mensaje", mensaje);
            } else {
                mensaje = "Error al activar!";
                request.setAttribute("error", mensaje);
            }
            
            List<Compras> listaCom = mcom.consultarComprasArchivadas();
            
            if (listaCom.isEmpty()) {
                mensaje = "No Se ha archivado ninguna Compra Aún";
                request.setAttribute("info", mensaje);
            } else {
                formBean.setListaCom(listaCom);
            }
            return mapping.findForward(todasCom);
        }

        return null;
    }

}
