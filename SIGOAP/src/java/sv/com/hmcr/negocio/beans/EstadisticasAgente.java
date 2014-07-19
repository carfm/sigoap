/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.hmcr.negocio.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sv.com.hmcr.dao.TablasTempDAO;
import sv.com.hmcr.dominio.EstadisticasTemp;

/**
 *
 * @author Luis
 */
@ManagedBean
@ViewScoped
public class EstadisticasAgente implements java.io.Serializable{
private List<EstadisticasTemp> listado; 
private TablasTempDAO dao;
private Double errorOrden=0.0;
private int ordenError=0;
    
    public EstadisticasAgente() {
        dao=new TablasTempDAO ();
        listado=dao.obtenerEstadisticasTemp();
        if (listado.get(0).getMes()!=0){
            errorOrden=(listado.get(3).getMesE()*1.0)/listado.get(0).getMes();
        }
        ordenError=listado.get(0).getMes()/(listado.get(3).getMesE()+1);
    }

    public List<EstadisticasTemp> getListado() {
        return listado;
    }

    public TablasTempDAO getDao() {
        return dao;
    }

    public void setListado(List<EstadisticasTemp> listado) {
        this.listado = listado;
    }

    public void setDao(TablasTempDAO dao) {
        this.dao = dao;
    }

    public Double getErrorOrden() {
        return errorOrden;
    }

    public int getOrdenError() {
        return ordenError;
    }

    public void setErrorOrden(Double errorOrden) {
        this.errorOrden = errorOrden;
    }

    public void setOrdenError(int ordenError) {
        this.ordenError = ordenError;
    }
    
    
}
