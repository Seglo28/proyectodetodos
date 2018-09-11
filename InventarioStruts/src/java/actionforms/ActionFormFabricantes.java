
package actionforms;

import java.util.List;
import persistencias.Fabricantes;


public class ActionFormFabricantes  extends org.apache.struts.action.ActionForm {
    private Integer idFabricante;
    private String fabricante;
    private String direccion;
    private String telefono;
    private String action;
    private String error;
    private String mensaje;
    private List<Fabricantes> listaFabricantes;

    public Integer getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Fabricantes> getListaFabricantes() {
        return listaFabricantes;
    }

    public void setListaFabricantes(List<Fabricantes> listaFabricantes) {
        this.listaFabricantes = listaFabricantes;
    }

    @Override
    public String toString() {
        return "ActionFormFabricantes{" + "idFabricante=" + idFabricante + ", fabricante=" + fabricante + ", direccion=" + direccion + ", telefono=" + telefono + ", action=" + action + ", error=" + error + ", mensaje=" + mensaje + ", listaFabricantes=" + listaFabricantes + '}';
    }
    
    
    
    
}
