/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionforms;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import persistencias.Facturas;
import persistencias.Sucursales;
import persistencias.Ventas;

/**
 *
 * @author gloria.sevillausam
 */
public class ActionFormFacturas extends org.apache.struts.action.ActionForm {
    
    private Integer idFactura;
    private Integer idSucursal;
    private Integer idVentas;
    private String fechaVenta;
    private String error;
    private String action;
    private String mensaje;
    private List<Facturas> lisFac;
    private List<Sucursales> lisSuc;
    private List<Ventas> lisVen;

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Integer getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
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

    public List<Facturas> getLisFac() {
        return lisFac;
    }

    public void setLisFac(List<Facturas> lisFac) {
        this.lisFac = lisFac;
    }

    public List<Sucursales> getLisSuc() {
        return lisSuc;
    }

    public void setLisSuc(List<Sucursales> lisSuc) {
        this.lisSuc = lisSuc;
    }

    public List<Ventas> getLisVen() {
        return lisVen;
    }

    public void setLisVen(List<Ventas> lisVen) {
        this.lisVen = lisVen;
    }

    @Override
    public String toString() {
        return "ActionFormFacturas{" + "idFactura=" + idFactura + ", idSucursal=" + idSucursal + ", idVentas=" + idVentas + ", fechaVenta=" + fechaVenta + ", error=" + error + ", action=" + action + ", mensaje=" + mensaje + ", lisFac=" + lisFac + ", lisSuc=" + lisSuc + ", lisVen=" + lisVen + '}';
    }

    
}
