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
    
    public EstadisticasAgente() {
        dao=new TablasTempDAO ();
        listado=dao.obtenerEstadisticasTemp();
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
    
    
}
