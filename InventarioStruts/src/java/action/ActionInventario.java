
package action;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimientos.InventarioMantenimiento;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionforms.ActionFormInventario;
import persistencias.Inventario;
import persistencias.Productos;
import persistencias.Proveedores;
import persistencias.Sucursales;

public class ActionInventario extends org.apache.struts.action.Action{
    private static final String agregarINV = "agregarINV";
    private static final String consultarINV = "consultarINV";
    private static final String consultarIdINV = "consultarIdINV";
    private static final String modificarINV = "modificarINV";
    private static final String eliminarINV = "eliminarINV";
    private static final String errorINV = "errorINV";
    @Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
        throws Exception {
    
    
   ActionFormInventario formBean = (ActionFormInventario) form;
      int idInventario = formBean.getIdInventario();
      int idProducto = formBean.getProductos().getIdProducto();
      int idProveedor = formBean.getProveedores().getIdProveedor();
      int idSucursal = formBean.getSucursales().getIdSucursal();
      Integer cant = formBean.getCant();
      Integer stock = formBean.getStock();
      String estado = formBean.getEstado();
      String action = formBean.getAction();
      
       if (formBean == null || action == null) {
            return mapping.findForward(errorINV);
        }
    
    if (action.equals("Agregar")) {
            String adver = "";
             if (cant == null || cant.equals("")) {
                adver = "* Escriba la cantidad del producto";
            }
             if (stock == null || stock.equals("")) {
                adver = "* Escriba la cantidad del stock del producto";
            }
            if (estado == null || estado.equals("")) {
                adver = "* Escriba el estado del inventario";
            }
            if (!adver.equals("")) {
                formBean.setError("<div class='alert alert-danger'>" + adver + "</div>");
                return mapping.findForward(errorINV);
            }
            
            InventarioMantenimiento minv=new InventarioMantenimiento();
            Inventario inv=minv.consultarInventario(idInventario);
        
            if (inv != null) {
                formBean.setError("<div class='alert alert-danger'>Este Producto ya Existe</div>");
                return mapping.findForward(errorINV);
            }
            int inv1 = minv.guardarInventario(idInventario, idProducto, cant, stock, estado, idProveedor, idSucursal);
                    
            System.out.println("Si es 1 Funcionó " + inv1);
            return mapping.findForward(agregarINV);
        }

      if (action.equals("Consultar")) {
          InventarioMantenimiento inv = new InventarioMantenimiento();
          List<Inventario> listaInv = inv.consultarTodosInventario();
          if (listaInv == null) {
              formBean.setError("<div class='alert alert-danger'>No hay Datos Guardados EN EL INVENTARIO</div>");
              return mapping.findForward(errorINV);
          } else {
              formBean.setListaInv(listaInv);
              return mapping.findForward(consultarINV);
          }
      }

      if (action.equals("Eliminar")) {

          InventarioMantenimiento minv = new InventarioMantenimiento();
          minv.eliminarInventario(idInventario);

          return mapping.findForward(eliminarINV);
      }
     
    
        return mapping.findForward(agregarINV);
    }  
    
    
    
    
}
