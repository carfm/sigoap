/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.negocio.beans;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.SelectEvent;
import sv.com.hmcr.dao.DetalleDAO;
import sv.com.hmcr.dao.TablasTempDAO;
import sv.com.hmcr.dominio.DetalleOrden;
import sv.com.hmcr.dominio.temp_procesada;

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
public class OrdenProcesada implements java.io.Serializable {

    private List<temp_procesada> listado;
    private TablasTempDAO dao;
    private List<DetalleOrden> listadoDetalle;
    private DetalleDAO daoDetalle;
    private temp_procesada seleccionado;
    private int totalO = 0;
    private int totalOC = 0;
    private int totalOI = 0;
    private int totalON = 0;

    @ManagedProperty(value = "#{parametrosReportes}")
    private ParametrosReportes parametrosReportes;

    public OrdenProcesada() {

        dao = new TablasTempDAO();
        listado = new ArrayList<>();
        daoDetalle=new DetalleDAO();
        listadoDetalle=null;

    }

    public void preProcessPDF(Object doc) throws BadElementException, IOException {
        Document document = (Document) doc;
        document.setPageSize(PageSize.LETTER);
        Date now = new Date();
        DateFormat df =  DateFormat.getDateInstance(DateFormat.MEDIUM);

        try {
            PdfWriter.getInstance(document,new FileOutputStream("temp_errorencontrado.pdf"));
            document.open();
            Paragraph fechaCre = new Paragraph("Fecha de creacion:"+df.format(now),
                    new Font(Font.HELVETICA  , 10, Font.NORMAL,new Color(0, 0, 0)));
            fechaCre.setAlignment(Element.ALIGN_RIGHT);
            HeaderFooter footer = new HeaderFooter(new Phrase("Pagina - "), true);
            footer.setAlignment(HeaderFooter.ALIGN_RIGHT);
            Paragraph paragraph1 = new Paragraph("HMCR SOLUTIONS\n"
                    + "REPORTE DE ORDENES PROCESADAS\n"
                    + "DEL PERIODO "+parametrosReportes.getFechaInicio() +" AL  "
                    +parametrosReportes.getFechaFin(),
            new Font(Font.HELVETICA  , 14, Font.NORMAL,new Color(0, 0, 0)));
            paragraph1.setAlignment(Element.ALIGN_CENTER);           
            paragraph1.setSpacingAfter(30);
            document.add(fechaCre);
            document.add(paragraph1);
            document.setFooter(footer);
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String logo = servletContext.getRealPath("") + "/resources/images/LogoHMCR.jpg";
            Image imagen = Image.getInstance(logo);
            imagen.setAbsolutePosition(10f, 735f);
            imagen.scalePercent(40f);
            document.add(imagen);
            //document.close();

        } catch (DocumentException | FileNotFoundException e) {
        }

    }

    @PostConstruct
    public void init() {
        listado = dao.obtenerOrdenProcesada(parametrosReportes.getTop());
        calcularTotales();
    }
    
    public void onRowSelect(SelectEvent event) {
        String id=daoDetalle.recuperarId(seleccionado.getUsuario());
        listadoDetalle=daoDetalle.obtenerDetalle(1, id,parametrosReportes.getFechaInicio(),
                parametrosReportes.getFechaFin()); 
    }

    public List<temp_procesada> getListado() {
        return listado;
    }

    public TablasTempDAO getDao() {
        return dao;
    }

    public void setListado(List<temp_procesada> listado) {
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

    public temp_procesada getSeleccionado() {
        return seleccionado;
    }

    public void setListadoDetalle(List<DetalleOrden> listadoDetalle) {
        this.listadoDetalle = listadoDetalle;
    }

    public void setDaoDetalle(DetalleDAO daoDetalle) {
        this.daoDetalle = daoDetalle;
    }

    public void setSeleccionado(temp_procesada seleccionado) {
        this.seleccionado = seleccionado;
    }

    public int getTotalO() {
        return totalO;
    }

    public int getTotalOC() {
        return totalOC;
    }

    public int getTotalOI() {
        return totalOI;
    }

    public int getTotalON() {
        return totalON;
    }

    public void setTotalO(int totalO) {
        this.totalO = totalO;
    }

    public void setTotalOC(int totalOC) {
        this.totalOC = totalOC;
    }

    public void setTotalOI(int totalOI) {
        this.totalOI = totalOI;
    }

    public void setTotalON(int totalON) {
        this.totalON = totalON;
    }
    
    private void calcularTotales() {
        for (temp_procesada listado1 : listado) {
            totalO += listado1.getTotalProcesadas();
            totalOC += listado1.getCompletas();
            totalOI += listado1.getIncompletas();
            totalON += listado1.getNada();
        }
    }

}
