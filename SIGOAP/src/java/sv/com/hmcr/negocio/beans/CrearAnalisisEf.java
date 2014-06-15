/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.negocio.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sv.com.hmcr.dao.TablasTempDAO;
import javax.faces.application.FacesMessage;

/**
 *
 * @author Luis
 */
@ManagedBean
@ViewScoped
public class CrearAnalisisEf implements java.io.Serializable {
    private Date fechaInicio;
    private Date fechaFin;
    private String mostrar;
    private TablasTempDAO dao;

    @ManagedProperty(value = "#{parametrosReportes}")
    private ParametrosReportes parametrosReportes;

    /**
     * Creates a new instance of CrearAnalisisEf
     */
    public CrearAnalisisEf() {
        dao = new TablasTempDAO();
    }

    public void generar() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String fecIni=format.format(fechaInicio);
        String fecFin=format.format(fechaFin);
        parametrosReportes.setFechaInicio(fecIni);
        parametrosReportes.setFechaFin(fecFin);
        parametrosReportes.setTop(Integer.parseInt(mostrar));
        parametrosReportes.setEncabezado("HMCR SOLUTIONS\nANALISIS DE EFICIENCIA\nDEL PERIODO "+fecIni+" AL "+fecFin);
        dao.ejecutarProc("CALL analisis_eficiencia('" + fecIni + "','" + fecFin + "')");
       try {
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("AnalisisEficiencia.xhtml");
        } catch (Exception e) {
        }
    }

    public void limpiar() {
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public String getMostrar() {
        return mostrar;
    }

    public TablasTempDAO getDao() {
        return dao;
    }

    public ParametrosReportes getParametrosReportes() {
        return parametrosReportes;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setMostrar(String mostrar) {
        this.mostrar = mostrar;
    }

    public void setDao(TablasTempDAO dao) {
        this.dao = dao;
    }

    public void setParametrosReportes(ParametrosReportes parametrosReportes) {
        this.parametrosReportes = parametrosReportes;
    }

}
