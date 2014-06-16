/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.negocio.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sv.com.hmcr.dao.TablasTempDAO;

/**
 *
 * @author Carlos y Jose
 */
@ManagedBean
@ViewScoped
public class CrearOrdenesProcNuevos implements java.io.Serializable{

    private Date fechaInicio;
    private Date fechaFin;
    private String mostrar;
    private TablasTempDAO dao;
    private String supervisor;

    @ManagedProperty(value = "#{parametrosReportes}")
    private ParametrosReportes parametrosReportes;

    public CrearOrdenesProcNuevos() {
        dao = new TablasTempDAO();
    }

    public void generar() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String fecIni = format.format(getFechaInicio());
        String fecFin = format.format(getFechaFin());
        getParametrosReportes().setFechaInicio(fecIni);
        getParametrosReportes().setFechaFin(fecFin);
        getParametrosReportes().setTop(Integer.parseInt(getMostrar()));
        parametrosReportes.setEncabezado("HMCR SOLUTIONS\nREPORTE DE ORDENES PROCESADAS DE AGENTES NUEVOS\nDEL PERIODO "+fecIni+" AL "+fecFin+"\n\nSUPERVISADOS POR:");
        getDao().ejecutarProc("CALL ordenesProcesadasNuevos('" + fecIni + "','" + fecFin + "','cramirez')");
        System.out.println("salio");
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("OrdenesProcesadasNuevos.xhtml");
        } catch (Exception e) {
        }
    }

    public void limpiar() {
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the mostrar
     */
    public String getMostrar() {
        return mostrar;
    }

    /**
     * @param mostrar the mostrar to set
     */
    public void setMostrar(String mostrar) {
        this.mostrar = mostrar;
    }

    /**
     * @return the dao
     */
    public TablasTempDAO getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(TablasTempDAO dao) {
        this.dao = dao;
    }

    /**
     * @return the parametrosReportes
     */
    public ParametrosReportes getParametrosReportes() {
        return parametrosReportes;
    }

    /**
     * @param parametrosReportes the parametrosReportes to set
     */
    public void setParametrosReportes(ParametrosReportes parametrosReportes) {
        this.parametrosReportes = parametrosReportes;
    }

    /**
     * @return the supervisor
     */
    public String getSupervisor() {
        return supervisor;
    }

    /**
     * @param supervisor the supervisor to set
     */
    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

}
