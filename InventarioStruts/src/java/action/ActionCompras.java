
package action;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimientos.ComprasMantenimiento;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionforms.ActionFormCompras;
import mantenimientos.ProductosMantenimiento;
import mantenimientos.ProveedorMantenimiento;
import persistencias.Compras;
import persistencias.Productos;
import persistencias.Proveedores;

public class ActionCompras extends org.apache.struts.action.Action {
    private static final String agregarCOM = "insertarCOM";
    private static final String consultarCOM = "consultarCOM";
    private static final String consultarIdCOM = "consultarIdCOM";
    private static final String modificarCOM = "modificarCOM";
    private static final String eliminarCOM = "eliminarCOM";
    private static final String errorCOM = "errorCOM";
    private static final String borrarCOM = "borrarCOM";   
    private static final String irFormCOM = "irFormCompras";
    
     @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    
    ActionFormCompras formBean= (ActionFormCompras) form;
    Integer idCompra=formBean.getIdCompra();
    Integer idProducto=formBean.getIdProducto();
    Integer idProveedor=formBean.getIdProveedor();
    Integer cantidad=formBean.getCantidad();
    Double monto=formBean.getMonto();
    String fechaCompras=formBean.getFechaCompras();
    String action=formBean.getAction();
    String mensaje=formBean.getMensaje();
    
    if (formBean == null || action == null) {
              formBean.setError("<div class='alert alert-danger'>Lamentamos el inconveniente, Inténtelo más Tarde(ACTION)</div>");
            return mapping.findForward(errorCOM);
        }
    
    
       if (action.equals("Insertar")) {
            String adver = "";
            String adver2 = "";
            String adver3 = "";
            String adver4 = "";
            String adver5 = "";
            
            if (idProducto == null || idProducto.equals("")) {
                adver = "* Elija el ID del producto";
               
            }
            if (idProveedor == null || idProveedor.equals("")) {
                adver2 = "* Elija el ID del proveedor";
               
            }
            if (cantidad == null || cantidad.equals("")) {
                adver3 = "* Escriba la cantidad del producto";
               
            }
            if (monto == null || monto.equals("")) {
                adver4 = "* Escriba el monto del producto";
               
            }
            if (fechaCompras == null || fechaCompras.equals("")) {
                adver5 = "* Escriba el monto del producto";
               
            }
            if (!adver.equals("")) {
               formBean.setError("<div class='alert alert-danger'>Por favor completar las casillas: <br>" +adver +adver2+adver3+adver4+adver5+ "</div>");          
                return mapping.findForward(errorCOM);
            }
            
            ComprasMantenimiento mcom= new ComprasMantenimiento();  
            System.out.println("idProducto"+idProducto);
            System.out.println("idProveedor"+idProveedor);
            System.out.println("cantidad"+cantidad);
            System.out.println("monto"+monto);
            System.out.println("fechaCompras"+fechaCompras);
            int com2 = mcom.guardarCompras(idProducto, idProveedor, cantidad, monto, fechaCompras);
            mensaje= "<div class='alert alert-success'>Guardando la compra de manera exitosa<div>";
            request.setAttribute("mensaje", mensaje);
             
            System.out.println("Si es 1 Funcionó " + com2);
            return mapping.findForward(agregarCOM);
        }
       
    
       if (action.equals("Consultar")) {
           ComprasMantenimiento mcom= new ComprasMantenimiento();
           List<Compras>listaCom=mcom.consultarTodosCompras();
           System.out.println("lista es"+listaCom);
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
            
            ProductosMantenimiento mprod=new ProductosMantenimiento();
            List<Productos>listaProd =mprod.consultarTodosProductos();
            formBean.setListaProd(listaProd);
            request.setAttribute("listaProd", listaProd);
            
            return mapping.findForward(irFormCOM);
            }   
       
        if(action.equals("Eliminar")){
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
                 formBean.setFechaCompras(com.getFechaCompras());
                 
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

            if(com==null){
                formBean.setError("<div class='alert alert-danger'> No se puede realizar la consulta para actualizar...</div>");
                return mapping.findForward(errorCOM);
            }else{
                
                System.out.println("ID: "+com.getIdCompra());
                 formBean.setIdCompra(com.getIdCompra());
                 formBean.setIdProducto(com.getProductos().getIdProducto());
                 formBean.setIdProveedor(com.getProveedores().getIdProveedor());
                 formBean.setCantidad(com.getCantidad()); 
                 formBean.setMonto(com.getMonto());
                 formBean.setFechaCompras(com.getFechaCompras());
                 
                 ProductosMantenimiento mprod = new ProductosMantenimiento();
                 List<Productos> listaProd = mprod.consultarTodosProductos();
                 formBean.setListaProd(listaProd);
                 request.setAttribute("listaProd", listaProd);

                 ProveedorMantenimiento mprov = new ProveedorMantenimiento();
                 List<Proveedores> listaProv = mprov.consultarTodosProveedores();
                 formBean.setListaProv(listaProv);
                 request.setAttribute("listaProv", listaProv);
                 
                return mapping.findForward(modificarCOM);
            }
        }
       
        if (action.equals("Modificar")) {
            ComprasMantenimiento mcom = new ComprasMantenimiento();
            System.out.println("ID: "+idCompra);
            System.out.println("ID Producto: "+idProducto);
            System.out.println("ID Prov: "+idProveedor);
            System.out.println("Cant: "+cantidad);
            System.out.println("Monto: $"+monto);
            System.out.println("Fecha: "+fechaCompras);
            int r = mcom.ActualizarCompras(idCompra, idProducto, idProveedor, cantidad, monto, fechaCompras);
            System.out.println("Ya sabes 1: "+r);
            List<Compras> listaCom = mcom.consultarTodosCompras();
            formBean.setListaCom(listaCom);
            return mapping.findForward(consultarCOM);
        }
        
        if (action.equals("Volver")) {
           ComprasMantenimiento mcom= new ComprasMantenimiento();
           List<Compras>listaCom=mcom.consultarTodosCompras();
           System.out.println("lista es"+listaCom);
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
