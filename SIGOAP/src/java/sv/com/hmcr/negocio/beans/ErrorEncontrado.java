/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.hmcr.negocio.beans;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import sv.com.hmcr.dao.TablasTempDAO;

import sv.com.hmcr.dominio.temp_errorEncontrado;

import sv.com.hmcr.negocio.beans.ParametrosReportes;

/**
 *
 * bean muy sencillo, debe tener la anotacion ManagedBean y ademas SessionScoped para poder enviar parametros
 * ademas debe implementar Serializable
 * debe tener los siguientes atributos: una lista para guardar la data de la tabla temporal,
 * el dao TablasTempDAO; deben crear sus propios metodos en dicho dao
 * String de encabezado del reporte, y los atributos correspondientes a los parametros
 * todos deben tener metodos get y set y un constructor sin parametros, 
 */
@ManagedBean
@ViewScoped
public class ErrorEncontrado implements java.io.Serializable {
    
       private List<temp_errorEncontrado> listado; 
    private TablasTempDAO dao;
    
    @ManagedProperty(value = "#{parametrosReportes}")
    private ParametrosReportes parametrosReportes;

    public ErrorEncontrado() {  
        
        dao=new TablasTempDAO ();
        listado=new ArrayList<temp_errorEncontrado>();
        
    }
    
    public void preProcessPDF(Object document) {
      Document pdf = (Document) document;
      
      pdf.setPageSize(PageSize.LETTER.rotate());
      pdf.open();
      pdf.addCreationDate();
      pdf.addHeader("hola", "como estas");
      pdf.addTitle("Analisis de eficiencia\nMio");
      pdf.leftMargin();
    }

    public List<temp_errorEncontrado> getListado() {
       // listado=dao.obtenerAnalisisEf(parametrosReportes.getTop());
        listado=dao.obtenerErrorEncontrado(parametrosReportes.getTop());
        return listado;
    }
    public TablasTempDAO getDao() {
        return dao;
    }
    public void setListado(List<temp_errorEncontrado> listado) {
        this.listado = listado;
    }
    public void setDao(TablasTempDAO dao) {
        this.dao = dao;
    }    
    public ParametrosReportes getParametrosReportes() {
        return parametrosReportes;
    }
    public void setParametrosReportes(ParametrosReportes parametrosReportes) {
        this.parametrosReportes = parametrosReportes;
    }
    
}
