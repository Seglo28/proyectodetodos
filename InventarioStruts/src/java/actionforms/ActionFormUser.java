
package actionforms;

import java.util.List;
import persistencias.Usuario;

public class ActionFormUser extends org.apache.struts.action.ActionForm{
    
    private int idUsuario;
    private String usuario;
    private String correo;
    private String contra;
    private String cargo;
    private String action;
    private String error;
    private String errorIngresarUser;
    private String mensaje;
    private List<Usuario> listaUser;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getErrorIngresarUser() {
        return errorIngresarUser;
    }

    public void setErrorIngresarUser(String errorIngresarUser) {
        this.errorIngresarUser = errorIngresarUser;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Usuario> getListaUser() {
        return listaUser;
    }

    public void setListaUser(List<Usuario> listaUser) {
        this.listaUser = listaUser;
    }
    
}
