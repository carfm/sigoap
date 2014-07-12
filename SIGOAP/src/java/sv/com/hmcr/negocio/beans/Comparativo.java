/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.hmcr.negocio.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import sv.com.hmcr.dao.TablasTempDAO;
import sv.com.hmcr.dominio.ComparativonuevosTemp;

/**
 *
 * @author Luis
 */
@ManagedBean
@ViewScoped
public class Comparativo implements java.io.Serializable{
    private List<ComparativonuevosTemp> listado; 
    private TablasTempDAO dao;
    
    @ManagedProperty(value = "#{parametrosReportes}")
    private ParametrosReportes parametrosReportes;
    public Comparativo() {
        dao=new TablasTempDAO ();
        listado=new ArrayList<>();
    }
    
    @PostConstruct
    public void init() {
        listado = dao.obtenerComparativonuevosTemp(parametrosReportes.getTop());
    }

    public List<ComparativonuevosTemp> getListado() {
        return listado;
    }

    public TablasTempDAO getDao() {
        return dao;
    }

    public ParametrosReportes getParametrosReportes() {
        return parametrosReportes;
    }

    public void setListado(List<ComparativonuevosTemp> listado) {
        this.listado = listado;
    }

    public void setDao(TablasTempDAO dao) {
        this.dao = dao;
    }

    public void setParametrosReportes(ParametrosReportes parametrosReportes) {
        this.parametrosReportes = parametrosReportes;
    }
    
    
    
}
