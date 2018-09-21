package actionforms;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import persistencias.Clientes;
import persistencias.Facturas;
import persistencias.Productos;
import persistencias.Sucursales;
import persistencias.Usuario;
import persistencias.Ventas;

public class ActionFormVentas extends org.apache.struts.action.ActionForm {

    private Integer idVenta;
    private Clientes clientes;
    private Integer idCliente;
    private Productos productos;
    private Integer idProducto;
    private Usuario usuario;
    private Integer idUsuario;
    private Sucursales sucursales;
    private Integer idSucursal;
    private Integer cantidad;
    private Double monto;
    private String fechaVenta;
    private String action;
    private String error;
    private String mensaje;
    private List<Ventas> listaVen;
    private List<Productos> listaPro;
    private List<Clientes> listaCli;
    private List<Usuario> listaUsu;
    private List<Sucursales> listaSuc;

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
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

    public List<Ventas> getListaVen() {
        return listaVen;
    }

    public void setListaVen(List<Ventas> listaVen) {
        this.listaVen = listaVen;
    }

    public List<Productos> getListaPro() {
        return listaPro;
    }

    public void setListaPro(List<Productos> listaPro) {
        this.listaPro = listaPro;
    }

    public List<Clientes> getListaCli() {
        return listaCli;
    }

    public void setListaCli(List<Clientes> listaCli) {
        this.listaCli = listaCli;
    }

    public List<Usuario> getListaUsu() {
        return listaUsu;
    }

    public void setListaUsu(List<Usuario> listaUsu) {
        this.listaUsu = listaUsu;
    }

    public List<Sucursales> getListaSuc() {
        return listaSuc;
    }

    public void setListaSuc(List<Sucursales> listaSuc) {
        this.listaSuc = listaSuc;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "ActionFormVentas{" + "idVenta=" + idVenta + ", clientes=" + clientes + ", idCliente=" + idCliente + ", productos=" + productos + ", idProducto=" + idProducto + ", usuario=" + usuario + ", idUsuario=" + idUsuario + ", sucursales=" + sucursales + ", idSucursal=" + idSucursal + ", cantidad=" + cantidad + ", monto=" + monto + ", fechaVenta=" + fechaVenta + ", action=" + action + ", error=" + error + ", mensaje=" + mensaje + ", listaVen=" + listaVen + ", listaPro=" + listaPro + ", listaCli=" + listaCli + ", listaUsu=" + listaUsu + ", listaSuc=" + listaSuc + '}';
    }

   
}
