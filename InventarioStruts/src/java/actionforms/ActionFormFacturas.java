package actionforms;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import persistencias.Facturas;
import persistencias.Sucursales;
import persistencias.Ventas;

public class ActionFormFacturas extends org.apache.struts.action.ActionForm {

    private Integer idFactura;
    private Sucursales sucursales;
    private Ventas ventas;
    private String fechaVenta;
    private String action;
    private String error;
    private List<Facturas> ListaFac;
    private List<Sucursales> ListaSuc;
    private List<Ventas> ListaVen;

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Sucursales getSucursales() {
        return sucursales;
    }

    public void setSucursales(Sucursales sucursales) {
        this.sucursales = sucursales;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
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

    public List<Facturas> getListaFac() {
        return ListaFac;
    }

    public void setListaFac(List<Facturas> ListaFac) {
        this.ListaFac = ListaFac;
    }

    public List<Sucursales> getListaSuc() {
        return ListaSuc;
    }

    public void setListaSuc(List<Sucursales> ListaSuc) {
        this.ListaSuc = ListaSuc;
    }

    public List<Ventas> getListaVen() {
        return ListaVen;
    }

    public void setListaVen(List<Ventas> ListaVen) {
        this.ListaVen = ListaVen;
    }
}
