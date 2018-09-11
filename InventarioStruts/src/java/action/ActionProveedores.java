
package action;

import actionforms.ActionFormProveedores;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimientos.ProveedorMantenimiento;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import persistencias.Proveedores;
public class ActionProveedores extends org.apache.struts.action.Action {
   private static final String agregarPROV = "insertarPROV";
    private static final String consultarPROV = "consultarPROV";
    private static final String consultarIdPROV = "consultarIdPROV";
    private static final String modificarPROV = "modificarPROV";
    private static final String borrarPROV = "borrarPROV";
    private static final String eliminarPROV = "eliminarPROV";
    private static final String errorPROV = "errorPROV";

    @Override
    public ActionForward execute(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionFormProveedores af = (ActionFormProveedores) form;
        Integer idProveedor = af.getIdProveedor();
        String proveedor = af.getProveedor();
        String rubro = af.getRubro();
        String contacto = af.getContacto();
        String telefono = af.getTelefono();
        //String error = af.getError();
        String action = af.getAction();

        if (af == null || action == null) {
            return map.findForward(errorPROV);
        }

        if (action.equals("Agregar")) {
            String advertencia = "";
            if (proveedor == null || proveedor.equals("")) {
                advertencia = "<b>Nombre de proveedor requerido.</b><br>";
            }
            if (rubro == null || rubro.equals("")) {
                advertencia = "<b>Rubro del proveedor es requerido</b><br>";
            }
            if (contacto == null || contacto.equals("")) {
                advertencia = "<b>Contacto requerido</b><br>";
            }
            if (telefono == null || telefono.equals("")) {
                advertencia = "<b>Telefono requerido</b><br>";
            }
            if(!advertencia.equals("")){
                af.setError("<span style = 'color:red'>Por favor rellene los espacios vacions"+"<br>"+advertencia+"</span>");
                return map.findForward(errorPROV);
            }
            
            ProveedorMantenimiento proMan = new ProveedorMantenimiento();
            Proveedores pro = proMan.consultarProveedor2(proveedor);
            if(pro!=null){
                af.setError("<div class='alert alert-danger'>Proveedor existente</div>");
                return map.findForward(errorPROV);
            }
            int pro2 = proMan.guardarProveedores(0, proveedor, rubro, contacto, telefono);
            List<Proveedores> lp = proMan.consultarTodosProveedores();
            af.setListaPROV(lp);
            return map.findForward(agregarPROV);
        }
        
        if(action.equals("Eliminar")){
            ProveedorMantenimiento proMan = new ProveedorMantenimiento();
            Proveedores pro = proMan.consultarProveedor(idProveedor);
            if (pro==null){
                af.setError("<div class='alert alert-danger'>Error al consultar</div>");
                return map.findForward(errorPROV);
            }else{
                af.setIdProveedor(pro.getIdProveedor());
                af.setProveedor(pro.getProveedor());
                af.setRubro(pro.getRubro());
                af.setContacto(pro.getContacto());
                af.setTelefono(pro.getTelefono());
                return map.findForward(eliminarPROV);
            }
        }
        
        if(action.equals("Borrar")){
            ProveedorMantenimiento proMan = new ProveedorMantenimiento();
            proMan.eliminarProveedor(idProveedor);
            af.setError(borrarPROV);
            List<Proveedores> listaPROV = proMan.consultarTodosProveedores();
            af.setListaPROV(listaPROV);
            return map.findForward(borrarPROV);
        }
        
        if(action.equals("Consultar")){
            ProveedorMantenimiento proMan = new ProveedorMantenimiento();
            List<Proveedores> pro = proMan.consultarTodosProveedores();
            System.out.println("Lista es: "+pro);
            if(pro==null){
            af.setError("<div class='alert alert-danger'>Lista vacia - sin datos.</div>");
                        return map.findForward(consultarPROV);
            } else {
                af.setListaPROV(pro);
                return map.findForward(consultarPROV);
            }
        }
        
        if(action.equals("Actualizar")){
            ProveedorMantenimiento proMan = new ProveedorMantenimiento();
            Proveedores pro = proMan.consultarProveedor(idProveedor);
            if(pro == null){
                af.setError("<div class='alert alert-danger'>No se puede realizar la consulta.</div>");
                return map.findForward(errorPROV);
            }else{
                af.setIdProveedor(pro.getIdProveedor());
                af.setProveedor(pro.getProveedor());
                af.setRubro(pro.getRubro());
                af.setContacto(pro.getContacto());
                af.setTelefono(pro.getTelefono());
                return map.findForward(modificarPROV);
            }
        }
        
        if(action.equals("Modificar")){
            ProveedorMantenimiento proMan = new ProveedorMantenimiento();
            proMan.ActualizarProveedores(idProveedor, proveedor, rubro, contacto, telefono);
            List<Proveedores> pro = proMan.consultarTodosProveedores();
            af.setListaPROV(pro);
            return map.findForward(consultarPROV);
            }
        
        if(action.equals("Volver")){
            ProveedorMantenimiento proMan = new ProveedorMantenimiento();
            List<Proveedores> pro = proMan.consultarTodosProveedores();
            System.out.println("Su lista: "+ pro);
            if(pro==null){
                af.setError("<div class='alert alert-danger'>Lista vacia - sin datos.</div>");
                return map.findForward(consultarPROV);
            }else{
                af.setListaPROV(pro);
                return map.findForward(consultarPROV);
            }
        }
        
        return null;
    }  
}
