
package actionforms;

import java.util.List;
import persistencias.Compras;
import persistencias.Productos;
import persistencias.Proveedores;

public class ActionFormCompras extends org.apache.struts.action.ActionForm {
     private Integer idCompra;
     private Productos productos;
     private Proveedores proveedores;
     private Integer idProducto;    
     private Integer idProveedor;
     private Integer cantidad;
     private Double monto;
     private String error;
     private String fechaCompras;
    private String action;
    private String mensaje;
    private List<Productos> listaProd;
    private List<Proveedores> listaProv;
    private List<Compras> listaCom;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
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

    public String getFechaCompras() {
        return fechaCompras;
    }

    public void setFechaCompras(String fechaCompras) {
        this.fechaCompras = fechaCompras;
    }

    @Override
    public String toString() {
        return "ActionFormCompras{" + "idCompra=" + idCompra + ", productos=" + productos + ", proveedores=" + proveedores + ", idProducto=" + idProducto + ", idProveedor=" + idProveedor + ", cantidad=" + cantidad + ", monto=" + monto + ", error=" + error + ", fechaCompras=" + fechaCompras + ", action=" + action + ", mensaje=" + mensaje + ", listaProd=" + listaProd + ", listaProv=" + listaProv + ", listaCom=" + listaCom + '}';
    }

    
    
}
