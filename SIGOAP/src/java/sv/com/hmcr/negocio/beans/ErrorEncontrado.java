/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.negocio.beans;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import sv.com.hmcr.dao.DetalleDAO;
import sv.com.hmcr.dao.TablasTempDAO;
import sv.com.hmcr.dominio.DetalleOrden;
import sv.com.hmcr.dominio.temp_errorEncontrado;

/**
 *
 * bean muy sencillo, debe tener la anotacion ManagedBean y ademas SessionScoped
 * para poder enviar parametros ademas debe implementar Serializable debe tener
 * los siguientes atributos: una lista para guardar la data de la tabla
 * temporal, el dao TablasTempDAO; deben crear sus propios metodos en dicho dao
 * String de encabezado del reporte, y los atributos correspondientes a los
 * parametros todos deben tener metodos get y set y un constructor sin
 * parametros,
 */
@ManagedBean
@ViewScoped
public class ErrorEncontrado implements java.io.Serializable {

    private List<temp_errorEncontrado> listado;
    private TablasTempDAO dao;
    private List<DetalleOrden> listadoDetalle;
    private DetalleDAO daoDetalle;
    private temp_errorEncontrado seleccionado;

    @ManagedProperty(value = "#{parametrosReportes}")
    private ParametrosReportes parametrosReportes;

    public ErrorEncontrado() {

        dao = new TablasTempDAO();
        listado = new ArrayList<>();
        daoDetalle=new DetalleDAO();
        listadoDetalle=null;

    }

    public void preProcessPDF(Object documet) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document,
                    new FileOutputStream("Paragraph.pdf"));

            document.open();
            Paragraph paragraph = new Paragraph();

            for (int i = 0; i < 10; i++) {
                Chunk chunk = new Chunk(
                        "This is a sentence which is long " + i + ". ");
                paragraph.add(chunk);
            }

            document.add(paragraph);
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
//        Document pdf = (Document) document;
//
//        pdf.setPageSize(PageSize.LETTER.rotate());
//        pdf.open();
//        pdf.addCreationDate();
//        pdf.addHeader("hola", "como estas");
//        pdf.addTitle("Analisis de eficiencia\nMio");
//        pdf.leftMargin();

//}
    
    @PostConstruct
    public void init() {
        listado = dao.obtenerErrorEncontrado(parametrosReportes.getTop());
    }
    
    public void onRowSelect(SelectEvent event) {
        String id=daoDetalle.recuperarId(seleccionado.getUsuario());
        listadoDetalle=daoDetalle.obtenerDetalle(2, id,parametrosReportes.getFechaInicio(),
                parametrosReportes.getFechaFin()); 
    }
    
    public List<temp_errorEncontrado> getListado() {
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

    public List<DetalleOrden> getListadoDetalle() {
        return listadoDetalle;
    }

    public DetalleDAO getDaoDetalle() {
        return daoDetalle;
    }

    public temp_errorEncontrado getSeleccionado() {
        return seleccionado;
    }

    public void setListadoDetalle(List<DetalleOrden> listadoDetalle) {
        this.listadoDetalle = listadoDetalle;
    }

    public void setDaoDetalle(DetalleDAO daoDetalle) {
        this.daoDetalle = daoDetalle;
    }

    public void setSeleccionado(temp_errorEncontrado seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    

}
