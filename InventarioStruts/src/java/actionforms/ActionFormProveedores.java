
package actionforms;

import java.util.List;
import persistencias.Proveedores;

public class ActionFormProveedores  extends org.apache.struts.action.ActionForm  {
   private Integer idProveedor;
     private String proveedor;
     private String rubro;
     private String contacto;
     private String telefono;
     private String action;
     private String error;
     private List<Proveedores> listaPROV;

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
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

    public List<Proveedores> getListaPROV() {
        return listaPROV;
    }

    public void setListaPROV(List<Proveedores> listaPROV) {
        this.listaPROV = listaPROV;
    }

    @Override
    public String toString() {
        return "ActionFormProveedores{" + "idProveedor=" + idProveedor + ", proveedor=" + proveedor + ", rubro=" + rubro + ", contacto=" + contacto + ", telefono=" + telefono + ", action=" + action + ", error=" + error + ", listaPROV=" + listaPROV + '}';
    }
     
 
}
