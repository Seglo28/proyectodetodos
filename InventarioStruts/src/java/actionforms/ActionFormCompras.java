package actionforms;

import java.util.List;
import persistencias.Compras;
import persistencias.Productos;
import persistencias.Proveedores;
import persistencias.Sucursales;

public class ActionFormCompras extends org.apache.struts.action.ActionForm {

    private Integer idCompra;
    private String nDocumento;
    private Productos productos;
    private Proveedores proveedores;
    private Sucursales sucursales;
    private Integer idProducto;
    private Integer idProveedor;
    private Integer idSucursal;
    private Integer cantidad;
    private Double monto;
    private String error;
    private String fechaCompra;
    private String action;
    private String mensaje;
    private List<Productos> listaProd;
    private List<Proveedores> listaProv;
    private List<Compras> listaCom;
    private List<Sucursales> listSuc;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getnDocumento() {
        return nDocumento;
    }

    public void setnDocumento(String nDocumento) {
        this.nDocumento = nDocumento;
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

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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

    public List<Compras> getListaCom() {
        return listaCom;
    }

    public void setListaCom(List<Compras> listaCom) {
        this.listaCom = listaCom;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompras(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public List<Sucursales> getListSuc() {
        return listSuc;
    }

    public void setListSuc(List<Sucursales> listSuc) {
        this.listSuc = listSuc;
    }

    @Override
    public String toString() {
        return "ActionFormCompras{" + "idCompra=" + idCompra + ", nDocumento=" + nDocumento + ", productos=" + productos + ", proveedores=" + proveedores + ", sucursales=" + sucursales + ", idProducto=" + idProducto + ", idProveedor=" + idProveedor + ", idSucursal=" + idSucursal + ", cantidad=" + cantidad + ", monto=" + monto + ", error=" + error + ", fechaCompra=" + fechaCompra + ", action=" + action + ", mensaje=" + mensaje + ", listaProd=" + listaProd + ", listaProv=" + listaProv + ", listaCom=" + listaCom + ", listSuc=" + listSuc + '}';
    }

}
