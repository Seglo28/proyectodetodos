/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionforms;

import java.util.List;
import persistencias.Fabricantes;
import persistencias.Productos;
import persistencias.Proveedores;

public class ActionFormProductos extends org.apache.struts.action.ActionForm {

    private int idProducto;
    private Fabricantes fabricantes;
    private int idFabricante;
    private Proveedores proveedores;
    private int idProveedor;
    private String producto;
    private String error;
    private String action;
    private String errorIngresarProducto;
    private String mensaje;
    private List<Productos> listaProd;
    private List<Proveedores> listaProv;
    private List<Fabricantes> listaFab;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Fabricantes getFabricantes() {
        return fabricantes;
    }

    public void setFabricantes(Fabricantes fabricantes) {
        this.fabricantes = fabricantes;
    }
    
    public int getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(int idFabricante) {
        this.idFabricante = idFabricante;
    }
    
    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }
    
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
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

    public List<Productos> getListaProd() {
        return listaProd;
    }

    public void setListaProd(List<Productos> listaProd) {
        this.listaProd = listaProd;
    }

    public List<Proveedores> getListaProv() {
        return listaProv;
    }

    public void setListaProv(List<Proveedores> listaProv) {
        this.listaProv = listaProv;
    }

    public List<Fabricantes> getListaFab() {
        return listaFab;
    }

    public void setListaFab(List<Fabricantes> listaFab) {
        this.listaFab = listaFab;
    }

    public String getErrorIngresarProducto() {
        return errorIngresarProducto;
    }
    

    public void setErrorIngresarProducto(String errorIngresarProducto) {
        this.errorIngresarProducto = errorIngresarProducto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "ActionFormProductos{" + "idProducto=" + idProducto + ", fabricantes=" + fabricantes + ", idFabricante=" + idFabricante + ", proveedores=" + proveedores + ", idProveedor=" + idProveedor + ", producto=" + producto + ", error=" + error + ", action=" + action + ", errorIngresarProducto=" + errorIngresarProducto + ", mensaje=" + mensaje + ", listaProd=" + listaProd + ", listaProv=" + listaProv + ", listaFab=" + listaFab + '}';
    }

   

}
