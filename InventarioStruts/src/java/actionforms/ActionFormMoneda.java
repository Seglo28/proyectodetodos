/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionforms;

import java.util.List;
import persistencias.Monedas;

/**
 *
 * @author delmy.perezusam
 */
public class ActionFormMoneda extends org.apache.struts.action.ActionForm  {
    private Integer idMoneda;
    private String moneda;
    private String abreviatura;
    private String simbolo;
    private Double equivalencia;
    private String equivalente;
     private String action ;
     private String mensaje;
     private List<Monedas> listaMon; 

    public Integer getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public Double getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(Double equivalencia) {
        this.equivalencia = equivalencia;
    }

    public String getEquivalente() {
        return equivalente;
    }

    public void setEquivalente(String equivalente) {
        this.equivalente = equivalente;
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

    public List<Monedas> getListaMon() {
        return listaMon;
    }

    public void setListaMon(List<Monedas> listaMon) {
        this.listaMon = listaMon;
    }

    @Override
    public String toString() {
        return "ActionFormMoneda{" + "idMoneda=" + idMoneda + ", moneda=" + moneda + ", abreviatura=" + abreviatura + ", simbolo=" + simbolo + ", equivalencia=" + equivalencia + ", equivalente=" + equivalente + ", action=" + action + ", mensaje=" + mensaje + ", listaMon=" + listaMon + '}';
    }

}
