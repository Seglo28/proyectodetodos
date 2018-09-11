
package actionforms;

import java.util.List;
import persistencias.Clientes;

public class ActionFormClientes extends org.apache.struts.action.ActionForm {
    private Integer idCliente;
    private String cliente;
    private String tipoPersona;
    private String direccion;
    private String telefono;
    private String action;
    private String error;
    private String mensaje;
    private List<Clientes> listaClientes;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
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

    public List<Clientes> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Clientes> listaClientes) {
        this.listaClientes = listaClientes;
    }

    @Override
    public String toString() {
        return "ActionFormClientes{" + "idCliente=" + idCliente + ", cliente=" + cliente + ", tipoPersona=" + tipoPersona + ", direccion=" + direccion + ", telefono=" + telefono + ", action=" + action + ", error=" + error + ", mensaje=" + mensaje + ", listaClientes=" + listaClientes + '}';
    }
    
    
}
