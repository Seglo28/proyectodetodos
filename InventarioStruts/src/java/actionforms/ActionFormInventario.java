/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionforms;

import java.util.List;
import persistencias.Inventario;
import persistencias.Productos;
import persistencias.Proveedores;
import persistencias.Sucursales;

public class ActionFormInventario extends org.apache.struts.action.ActionForm{
    private Integer idInventario;
    private Productos productos;
    private Proveedores proveedores;
    private Sucursales sucursales;
    private Integer cant;
    private Integer stock;
    private String estado;
    private String error;
    private String action;
    private String errorIngresarInventario;
    private String mensaje;
    private List<Inventario> listaInv;

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public Sucursales getSucursales() {
        return sucursales;
    }

    public void setSucursales(Sucursales sucursales) {
        this.sucursales = sucursales;
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Inventario> getListaInv() {
        return listaInv;
    }

    public void setListaInv(List<Inventario> listaInv) {
        this.listaInv = listaInv;
    }

    public String getErrorIngresarInventario() {
        return errorIngresarInventario;
    }

    public void setErrorIngresarInventario(String errorIngresarInventario) {
        this.errorIngresarInventario = errorIngresarInventario;
    }

   

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "ActionFormInventario{" + "idInventario=" + idInventario + ", productos=" + productos + ", proveedores=" + proveedores + ", sucursales=" + sucursales + ", cant=" + cant + ", stock=" + stock + ", estado=" + estado + ", error=" + error + ", action=" + action + ", errorIngresarInventario=" + errorIngresarInventario + ", mensaje=" + mensaje + ", listaInv=" + listaInv + '}';
    }

   
   
   
      
}
