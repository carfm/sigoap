/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.hmcr.negocio.beans;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import sv.com.hmcr.dao.TablasTempDAO;
import sv.com.hmcr.dominio.Temporalordenesauditadas;

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
public class OrdenesAuditadas implements java.io.Serializable {
    private List<Temporalordenesauditadas> listado; 
    private TablasTempDAO dao;
    
    @ManagedProperty(value = "#{parametrosReportes}")
    private ParametrosReportes parametrosReportes;

    public OrdenesAuditadas() {  
        
        dao=new TablasTempDAO ();
        listado=new ArrayList<>();
        
    }
    
    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = new Document();
        pdf.open();
        pdf.setPageSize(PageSize.LETTER);
        pdf.addCreationDate();
        pdf.addHeader("hola", "como estas");
        pdf.addTitle("Analisis de eficiencia\nMio");
        pdf.add(new Chunk("This is sentence 1. "));
//        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
//        String logo = servletContext.getRealPath("") + File.separator + "resources"  + File.separator + "images" + File.separator + "LogoHMCR.png";        
//        pdf.add(Image.getInstance(logo));
    }
    
    @PostConstruct
    public void init() {
        listado = dao.obtenerOrdenesAuditadas(parametrosReportes.getTop());
    }

    public List<Temporalordenesauditadas> getListado() {
        return listado;
    }
    
    public Integer totalesAuditadas(){
        int total = 0;
        for (Temporalordenesauditadas listado1 : listado) {
            total += listado1.getAuditadas();
        }
        return total;
    }

    public Integer totalesConError(){
        int total = 0;
        for (Temporalordenesauditadas listado1 : listado) {
            total += listado1.getConerror();
        }
        return total;
    }
    public Integer totalesSinError(){
        int total = 0;
        for (Temporalordenesauditadas listado1 : listado) {
            total += listado1.getSinerror();
        }
        return total;
    }
    public TablasTempDAO getDao() {
        return dao;
    }

    public void setListado(List<Temporalordenesauditadas> listado) {
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
