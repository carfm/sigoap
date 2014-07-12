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
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import sv.com.hmcr.dao.TablasTempDAO;
import sv.com.hmcr.dominio.Temporalordenesprocesadasnuevos;

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
public class OrdenesProcNuevos implements java.io.Serializable {
    private List<Temporalordenesprocesadasnuevos> listado; 
    private TablasTempDAO dao;
    
    @ManagedProperty(value = "#{parametrosReportes}")
    private ParametrosReportes parametrosReportes;

    public OrdenesProcNuevos() {  
        
        dao=new TablasTempDAO ();
        listado=new ArrayList<>();
        
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
    @PostConstruct
    public void init() {
        listado = dao.obtenerOrdenesProcesadasNuevos(parametrosReportes.getTop());
    }

    public List<Temporalordenesprocesadasnuevos> getListado() {
        return listado;
    }
    
    public Integer totalesProcesadas(){
        int total = 0;
        for (Temporalordenesprocesadasnuevos listado1 : listado) {
            total += listado1.getTotal();
        }
        return total;
    }
    
    public Integer totalesCompletas(){
        int total = 0;
        for (Temporalordenesprocesadasnuevos listado1 : listado) {
            total += listado1.getCompletas();
        }
        return total;
    }
    
    public Integer totalesIncompletas(){
        int total = 0;
        for (Temporalordenesprocesadasnuevos listado1 : listado) {
            total += listado1.getIncompletas();
        }
        return total;
    }

    public Integer totalesNada(){
        int total = 0;
        for (Temporalordenesprocesadasnuevos listado1 : listado) {
            total += listado1.getNada();
        }
        return total;
    }
    public TablasTempDAO getDao() {
        return dao;
    }

    public void setListado(List<Temporalordenesprocesadasnuevos> listado) {
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
