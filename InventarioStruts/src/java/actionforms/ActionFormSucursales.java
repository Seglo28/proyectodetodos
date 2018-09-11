/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionforms;

import java.util.List;
import persistencias.Sucursales;

/**
 *
 * @author delmy.perezusam
 */
public class ActionFormSucursales extends org.apache.struts.action.ActionForm{
    private Integer idSucursal;
   private String sucursal;
    private String direccion;
    private String municipio;
    private String departamento;
    private String telefono;
    private String error;
    private String action;
    private List<Sucursales> listaSUC;

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public List<Sucursales> getListaSUC() {
        return listaSUC;
    }

    public void setListaSUC(List<Sucursales> listaSUC) {
        this.listaSUC = listaSUC;
    }

    @Override
    public String toString() {
        return "ActionFormSucursales{" + "idSucursal=" + idSucursal + ", sucursal=" + sucursal + ", direccion=" + direccion + ", municipio=" + municipio + ", departamento=" + departamento + ", telefono=" + telefono + ", error=" + error + ", action=" + action + ", listaSUC=" + listaSUC + '}';
    }

   
    
    
    
    
}
