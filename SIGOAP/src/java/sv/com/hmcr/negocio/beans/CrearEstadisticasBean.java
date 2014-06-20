/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.negocio.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sv.com.hmcr.dao.EmpleadoDao;
import sv.com.hmcr.dao.TablasTempDAO;
import sv.com.hmcr.dominio.Empleado;

/**
 *
 * @author Luis
 */
@ManagedBean
@ViewScoped
public class CrearEstadisticasBean implements java.io.Serializable{

    private String idAgente;
    private List<Empleado> listaEmpleados;
    private int mes;
    private int anio;
    private EmpleadoDao dao;
    private TablasTempDAO daoTemp;

    @ManagedProperty(value = "#{parametrosReportes}")
    private ParametrosReportes parametrosReportes;

    public CrearEstadisticasBean() {
        dao = new EmpleadoDao();
        daoTemp = new TablasTempDAO();
        listaEmpleados=dao.obtenListaEmpleado();
    }

    public void generar() {

        parametrosReportes.setEncabezado("ESTADISTICAS DE AGENTE "+ recuperarAgente() + " DEL MES DE " + recuperarMes() + " DE " + anio);
        daoTemp.ejecutarProc("CALL estadisticas_agente(" + mes + "," + anio + ",'" + idAgente + "')");
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("EstadisticasAgente.xhtml");
        } catch (Exception e) {
        }
    }

    private String recuperarMes() {
        String mesStr="";
        switch (mes) {
            case 1:
                mesStr= "Enero";
                break;
            case 2:
                mesStr= "Febrero";
                break;
            case 3:
                mesStr= "Marzo";
                break;
            case 4:
                mesStr= "Abril";
                break;
            case 5:
                mesStr= "Mayo";
                break;
            case 6:
                mesStr= "Junio";
                break;
            case 7:
                mesStr= "Julio";
                break;
            case 8:
                mesStr= "Agosto";
                break;
            case 9:
                mesStr= "Septiembre";
                break;
            case 10:
                mesStr= "Octubre";
                break;
            case 11:
                mesStr= "Noviembre";
                break;
            case 12:
                mesStr= "Diciembre";
                break;
        }
        return mesStr.toUpperCase();
    }

    private String recuperarAgente() {
        Empleado e=dao.obtenerEmpleado(idAgente);
        return e.getNombreempleado().toUpperCase();
    }

    public String getIdAgente() {
        return idAgente;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    public EmpleadoDao getDao() {
        return dao;
    }

    public TablasTempDAO getDaoTemp() {
        return daoTemp;
    }

    public ParametrosReportes getParametrosReportes() {
        return parametrosReportes;
    }

    public void setIdAgente(String idAgente) {
        this.idAgente = idAgente;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setDao(EmpleadoDao dao) {
        this.dao = dao;
    }

    public void setDaoTemp(TablasTempDAO daoTemp) {
        this.daoTemp = daoTemp;
    }

    public void setParametrosReportes(ParametrosReportes parametrosReportes) {
        this.parametrosReportes = parametrosReportes;
    }
    
    
}
