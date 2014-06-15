/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.hmcr.negocio.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Luis
 */
@ManagedBean
@SessionScoped
public class ParametrosReportes implements java.io.Serializable {
    private String fechaInicio;
    private String fechaFin;
    private String agente;
    private int top;
    private String encabezado;

    public ParametrosReportes() {
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getAgente() {
        return agente;
    }

    public int getTop() {
        return top;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }
}
