
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimientos.MantenimientoUsuario;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionforms.ActionFormUser;
import java.util.List;
import persistencias.Usuario;

public class ActionUser extends org.apache.struts.action.Action{
    
    private static final String entrar = "entrarUser";
    private static final String insertar = "insertarUser";
    private static final String consultar = "consultarUser";
    private static final String consultarId = "consultarIdUser";
    private static final String modificar = "modificarUser";
    private static final String irEliminar = "irEliminarUser";
    private static final String eliminar = "eliminarUser";
    private static final String error = "errorUser";
    private static final String errorIngresar = "errorIngresarUser";
    private static final String errorModificar = "errorModificarUser";
    private static final String errorEliminar = "errorEliminarUser";
    
    @Override
    public ActionForward execute(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ActionFormUser formBean = (ActionFormUser) form;
        int idUsuario = formBean.getIdUsuario();
        String usuario = formBean.getUsuario();
        String correo = formBean.getCorreo();
        String contra = formBean.getContra();
        String cargo = formBean.getCargo();
        String action = formBean.getAction();
        String mensaje = "";

        if (formBean == null || action == null) {
            mensaje = "Hay un problema en el Sistema";
            request.setAttribute("info", mensaje);
            return map.findForward(error);
        }

        if (action.equals("Entrar")) {
            
            String adver = "";
            String adver2 = "";

            if (correo == null || correo.equals("")) {
                adver = "- Correo <br>";
            }
            if (contra == null || contra.equals("")) {
                adver2 = "- Contraseña <br>";
            }
            if (!adver.equals("")) {
                mensaje = "Por favor completar las casillas: <br>" + adver + adver2 +"";
                request.setAttribute("error", mensaje);
                return map.findForward(error);
            } else {
                MantenimientoUsuario mantUser = new MantenimientoUsuario();
                Usuario user = mantUser.entrar(correo, contra);
                if (user == null) {
                    mensaje = "Usuario y/o contraseña son incorrectas";
                    request.setAttribute("info", mensaje);
                    return map.findForward(error);
                } else {
                    return map.findForward(entrar);

                }

            }
        }
        
        if(action.equals("Insertar")){
            String adver = "";
            String adver2 = "";
            String adver3 = "";
            
            if(usuario == null || usuario.equals("")){
                adver = "- Nombre del Usuario <br>";
            }
            if(correo == null || correo.equals("")){
                adver2 = "- Correo del Usuario <br>";
            }
            if(contra == null || contra.equals("")){
                adver3 = "- Contraseña <br>";
            }
            if(!adver.equals("")){
                mensaje = "Por favor completar las casillas: <br>" + adver + adver2 + adver3 + "";
                request.setAttribute("error", mensaje);
                return map.findForward(errorIngresar);
            }
            
            MantenimientoUsuario mant = new MantenimientoUsuario();
            Usuario user = mant.consultaUserUsuario(correo);
            System.out.println("Consultar Correo: "+user);
            if(user != null){
                mensaje = "El correo ya Existe, Eliga Otro";
                request.setAttribute("info", mensaje);
                return map.findForward(errorIngresar);
            }
            mant.guardarUser(usuario, correo, contra, cargo);
            List<Usuario> listaUser = mant.consultarUser();
            formBean.setListaUser(listaUser);
            
            if(listaUser.isEmpty()){
                mensaje = "No hay usuarios en el sistema";
                request.setAttribute("info", mensaje);
                return map.findForward(insertar);
            } else {
                mensaje = "Guardado de Usuario Exitoso";
                request.setAttribute("mensaje", mensaje);
                
                return map.findForward(insertar);
            }
            
        }
        
        if(action.equals("Consultar")){
            MantenimientoUsuario mant = new MantenimientoUsuario();
            List<Usuario> listaUser = mant.consultarUser();
            
            if(listaUser.isEmpty()){
                mensaje = "No hay usuarios en el sistema";
                request.setAttribute("info", mensaje);
                return map.findForward(consultar);
            } else {
                formBean.setListaUser(listaUser);
                return map.findForward(consultar);
            }
        }
        
        if(action.equals("Modificar")){
            MantenimientoUsuario mant = new MantenimientoUsuario();
            Usuario user = (Usuario) mant.consultaUserId(idUsuario);
            
            if(user == null){
                mensaje = "No existe este usuarios en el sistema";
                request.setAttribute("info", mensaje);
                return map.findForward(consultar);
            }
                formBean.setIdUsuario(user.getIdUsuario());
                formBean.setUsuario(user.getUsuario());
                formBean.setCorreo(user.getCorreo());
                formBean.setContra(user.getContra());
                formBean.setCargo(user.getCargo());
                return map.findForward(consultarId);
            
        }
        
        if(action.equals("Actualizar")){
            MantenimientoUsuario mant = new MantenimientoUsuario();

            int r = mant.modificarUser(idUsuario, usuario, correo, contra, cargo);
            
            if(r == 1){
                mensaje = "Modificado de Usuario Exitoso";
                request.setAttribute("mensaje", mensaje);
            } else {
                mensaje = "Error al modificar el usuario";
                request.setAttribute("error", mensaje);
            }
            
            List<Usuario> listaUser = mant.consultarUser();
            formBean.setListaUser(listaUser);
            
            return map.findForward(modificar);
        }
        
        if(action.equals("Cancelar")){
            MantenimientoUsuario mant = new MantenimientoUsuario();
            List<Usuario> listaUser = mant.consultarUser();
            
            if(listaUser.isEmpty()){
                mensaje = "No hay usuarios en el sistema";
                request.setAttribute("info", mensaje);
                return map.findForward(consultar);
            } else {
                formBean.setListaUser(listaUser);
                return map.findForward(consultar);
            }
        }
        
        if(action.equals("Eliminar")){
            MantenimientoUsuario mant = new MantenimientoUsuario();
            Usuario user = (Usuario) mant.consultaUserId(idUsuario);
            
            if(user == null){
                mensaje = "No existe este usuarios en el sistema";
                request.setAttribute("info", mensaje);
                return map.findForward(consultar);
            }
                formBean.setIdUsuario(user.getIdUsuario());
                formBean.setUsuario(user.getUsuario());
                formBean.setCorreo(user.getCorreo());
                formBean.setContra(user.getContra());
                formBean.setCargo(user.getCargo());
                return map.findForward(irEliminar);
        }
        
        if (action.equals("Borrar")) {
            MantenimientoUsuario mant = new MantenimientoUsuario();
            mant.eliminarUser(idUsuario);
            formBean.setError(errorEliminar);
            List<Usuario> listaUser = mant.consultarUser();
            
            if(listaUser.isEmpty()){
                mensaje = "No hay usuarios en el sistema";
                request.setAttribute("info", mensaje);
                return map.findForward(consultar);
            } else {
                mensaje = "El Registro ha sido eliminado con Éxito";
                request.setAttribute("mensaje", mensaje);
                formBean.setListaUser(listaUser);
                return map.findForward(eliminar);
            }
        }
        
        return null;
    }
    
}
