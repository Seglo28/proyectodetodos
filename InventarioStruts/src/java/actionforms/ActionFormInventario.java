
package actionforms;

import java.util.List;
import persistencias.Inventario;
import persistencias.Productos;
import persistencias.Proveedores;
import persistencias.Sucursales;

public class ActionFormInventario extends org.apache.struts.action.ActionForm{
    private Integer idInventario;
    private Productos productos;
    private Integer idProducto;
    private Proveedores proveedores;
    private Integer idProveedor;
    private Sucursales sucursales;
    private Integer idSucursal;
    private Integer cant;
    private Integer stock;
    private String estado;
    private String error;
    private String action;
    private String errorIngresarInventario;
    private String mensaje;
    private List<Inventario> listaInv;
    private List<Productos> listProd;
    private List<Proveedores> listProv;
    private List<Sucursales> listSuc;

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

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Sucursales getSucursales() {
        return sucursales;
    }

    public void setSucursales(Sucursales sucursales) {
        this.sucursales = sucursales;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
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

    public List<Productos> getListProd() {
        return listProd;
    }

    public void setListProd(List<Productos> listProd) {
        this.listProd = listProd;
    }

    public List<Proveedores> getListProv() {
        return listProv;
    }

    public void setListProv(List<Proveedores> listProv) {
        this.listProv = listProv;
    }

    public List<Sucursales> getListSuc() {
        return listSuc;
    }

    public void setListSuc(List<Sucursales> listSuc) {
        this.listSuc = listSuc;
    }

    @Override
    public String toString() {
        return "ActionFormInventario{" + "idInventario=" + idInventario + ", productos=" + productos + ", idProducto=" + idProducto + ", proveedores=" + proveedores + ", idProveedor=" + idProveedor + ", sucursales=" + sucursales + ", idSucursal=" + idSucursal + ", cant=" + cant + ", stock=" + stock + ", estado=" + estado + ", error=" + error + ", action=" + action + ", errorIngresarInventario=" + errorIngresarInventario + ", mensaje=" + mensaje + ", listaInv=" + listaInv + ", listProd=" + listProd + ", listProv=" + listProv + ", listSuc=" + listSuc + '}';
    }

}
