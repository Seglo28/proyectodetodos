
package action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimientos.FabricantesMantenimiento;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionforms.ActionFormFabricantes;
import java.util.List;
import persistencias.Fabricantes;

public class ActionFabricantes extends org.apache.struts.action.Action {

    private static final String insertarFac = "insertarFac";
    private static final String consultarFac = "consultarFac";
    private static final String consultarIdFac = "consultarIdFac";
    private static final String modificarFac = "modificarFac";
    private static final String eliminarFac = "eliminarFac";
    private static final String borrarFac = "borrarFac";
  
    private static final String errorFac = "errorFac";
 @Override
    public ActionForward execute(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    
    ActionFormFabricantes formBean= (ActionFormFabricantes) form;
    Integer idFabricante=formBean.getIdFabricante();
    String fabricante= formBean.getFabricante();
    String direccion=formBean.getDireccion();
    String telefono=formBean.getTelefono();
    String action = formBean.getAction();
    String mensaje = formBean.getMensaje();
    
       if (formBean == null || action == null) {
            formBean.setError("<div class='alert alert-danger'>Lamentamos el inconveniente, Inténtelo más Tarde</div>");
            return map.findForward(errorFac);
        }
       
        if(action.equals("Insertar")){
            String adver = "";
            String adver2 = "";
            String adver3 = "";
            
            if(fabricante == null || fabricante.equals("")){
                adver = "* Nombre del fabricante <br>";
            }             
            if(direccion == null || direccion.equals("")){
                adver2 = "* Direccion del fabricante <br>";
            }
    
            if(telefono == null || telefono.equals("")){
                adver3 = "* Telefono del fabricante <br>";
            }
             if(!adver.equals("") || !adver2.equals("") || !adver3.equals("")){
               formBean.setError("<div class='alert alert-danger'>Por favor completar las casillas: <br>" + adver + adver2 + adver3 + "<div>") ;
          
                return map.findForward(errorFac);
            }
            FabricantesMantenimiento manf = new FabricantesMantenimiento();
            System.out.println("Nombre del fabricante: "+fabricante);
            Fabricantes fac = manf.consultarNombreFabricante(fabricante);
            System.out.println("consultar fabricante: "+fac);
            if (fac != null) {
                formBean.setError("<div class='alert alert-danger'>El fabricante ya Existe, Ingrese otro no regristrado :<div>");
                return map.findForward(errorFac);
            }
            manf.guardarFabricantes(fabricante, direccion, telefono);
            mensaje = "<div class='alert alert-success'>Guardado  el fabricante de manera exitosa<div>";
            request.setAttribute("mensaje", mensaje);
            return map.findForward(insertarFac);
 
            
        }
       
        if (action.equals("Consultar")) {
            FabricantesMantenimiento manf = new FabricantesMantenimiento();
            //Sucursales suc = sucMan.consultarSucursal(idSucursal);
            List<Fabricantes> listaFabricantes =  manf.consultarTodosFabricantes();
            System.out.println("Lista es: "+listaFabricantes);
            if (listaFabricantes == null) {
                formBean.setError("<div class='alert alert-danger'>Lista vacia - sin datos.</div>");
                System.out.println("esto esta fallando esta lista");
                return map.findForward(consultarFac);
            } else {
                formBean.setListaFabricantes(listaFabricantes);
                return map.findForward(consultarFac);
            }
        }
       
        if(action.equals("Eliminar")){
            FabricantesMantenimiento manf = new FabricantesMantenimiento();
            Fabricantes fab=manf.consultarFabricante(idFabricante);
            if(fab==null){
                formBean.setError("<div class='alert alert-danger'>error  de actualización </div>");
                return map.findForward(errorFac);
            }else{
                formBean.setIdFabricante(fab.getIdFabricante());
                formBean.setFabricante(fab.getFabricante());
                formBean.setDireccion(fab.getDireccion());
                formBean.setTelefono(fab.getTelefono());
                return map.findForward(eliminarFac);
            }
        }
        
         if (action.equals("Borrar")) {
              FabricantesMantenimiento manf = new FabricantesMantenimiento();
             manf.eliminarFabricante(idFabricante);
             formBean.setError(borrarFac);
             List<Fabricantes> listaFabricantes = manf.consultarTodosFabricantes();
             formBean.setListaFabricantes(listaFabricantes);
             return map.findForward(borrarFac);
   
        }
    
       if(action.equals("Actualizar")){
            FabricantesMantenimiento manf = new FabricantesMantenimiento();
            Fabricantes fab=manf.consultarFabricante(idFabricante);
            System.out.println("Actualizar "+fab);
            System.out.println("id: "+idFabricante);
            System.out.println("fab: "+fab.getFabricante());
            System.out.println("direccion "+direccion);
            if(fab==null){
                formBean.setError("<div class='alert alert-danger'>error  de actualización  Fabricante</div>");
                return map.findForward(errorFac);
            }else{
                formBean.setIdFabricante(fab.getIdFabricante());
                formBean.setFabricante(fab.getFabricante());
                formBean.setDireccion(fab.getDireccion());
                formBean.setTelefono(fab.getTelefono());
                return map.findForward(modificarFac);
            }
        }
       
       if (action.equals("Modificar")) {
           FabricantesMantenimiento manf = new FabricantesMantenimiento();
           manf.ActualizarFabricantes(idFabricante, fabricante, direccion, telefono);
           List<Fabricantes>listaFabricantes=manf.consultarTodosFabricantes();
           formBean.setListaFabricantes(listaFabricantes);
            return map.findForward(consultarFac);
        }
        if (action.equals("Volver")) {
             FabricantesMantenimiento manf = new FabricantesMantenimiento();
             List<Fabricantes>listaFabricantes=manf.consultarTodosFabricantes();
             System.out.println("Lista es: " + listaFabricantes);
            if (listaFabricantes == null) {
                formBean.setError("<div class='alert alert-danger'>Lista vacia - sin datos.</div>");
                return map.findForward(consultarFac);
            } else {
                formBean.setListaFabricantes(listaFabricantes);
                return map.findForward(consultarFac);
            }
        }
       
       
       
       
       
    return null;
    }
      
}
