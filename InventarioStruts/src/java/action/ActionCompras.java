
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
    private static final String irFormCOM = "irFormCOM";
    
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
            
            if (idProducto == null || idProducto.equals("")) {
                adver2 = "* Elija el ID del producto";
               
            }
            if (idProveedor == null || idProveedor.equals("")) {
                adver = "* Elija el ID del proveedor";
               
            }
            if (cantidad == null || cantidad.equals("")) {
                adver3 = "* Escriba la cantidad del producto";
               
            }
            if (monto == null || monto.equals("")) {
                adver4 = "* Escriba el monto del producto";
               
            }
            if (!adver.equals("")) {
               formBean.setError("<div class='alert alert-danger'>Por favor completar las casillas: <br>" +adver +adver2+adver3+adver4+ "</div>");          
                return mapping.findForward(errorCOM);
            }
            ComprasMantenimiento mcom=new ComprasMantenimiento();
            Compras com=mcom.consultarCompra(idCompra);
            System.out.println(" consulatado compra"+com);
           
            if (com != null) {
                formBean.setError("<div class='alert alert-danger'>Estan compra ya ha sido regristrada.. </div>");             
                return mapping.findForward(errorCOM);
            }
            int prod2 = mprod.guardarProductos(idFabricante, idProveedor, producto);
            mensajeProd= "<div class='alert alert-success'>Guardando producto de manera exitosa<div>";
             request.setAttribute("mensajeProd", mensajeProd);
             
            System.out.println("Si es 1 Funcionó " + prod2);
            return mapping.findForward(agregarPROD);
        }
    
    
    return null;
    }
    
    
    
}
