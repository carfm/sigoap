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
import sv.com.hmcr.dao.TablasTempDAO;
import sv.com.hmcr.dominio.AnalisisefTemp;

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
public class AnalisisEficiencia implements java.io.Serializable {

    private List<AnalisisefTemp> listado;
    private TablasTempDAO dao;
    private int totalE = 0;
    private int totalEG = 0;
    private int totalEM = 0;
    private int totalEL = 0;
    private int totalO = 0;
    private int totalOC = 0;
    private int totalOI = 0;
    private int totalON = 0;

    @ManagedProperty(value = "#{parametrosReportes}")
    private ParametrosReportes parametrosReportes;

    public AnalisisEficiencia() {

        dao = new TablasTempDAO();
        listado=new ArrayList<AnalisisefTemp>();
        

    }

    public void preProcessPDF(Object doc) throws BadElementException, IOException {
        Document document = (Document) doc;
        document.setPageSize(PageSize.LETTER.rotate());
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
                    + "ANALISIS DE EFICIENCIA\n"
                    + "DEL PERIODO "+parametrosReportes.getFechaInicio() +" AL  "
                    +parametrosReportes.getFechaFin(),
            new Font(Font.HELVETICA  , 14, Font.NORMAL,new Color(0, 0, 0)));
            Paragraph paragraph2 = new Paragraph("TE=Total de errores; EG=Errores Graves; EM=Errores Medianos;" +
"EL=Errores Leves\n\n OP=Ordenes Procesadas; OC=Ordenes Completas;" +
"ORI=Ordenes Regresadas Incompletas; ORN=Ordenes regresadas sin hacer nada\n\n" +
"E/O=Errores/Ordenes procesadas completas (%); O/E=Ordenes ingresadas completa s por error",
            new Font(Font.HELVETICA  , 9, Font.NORMAL,new Color(0, 0, 0)));
            paragraph1.setAlignment(Element.ALIGN_CENTER);           
            paragraph1.setSpacingAfter(20);
            paragraph2.setAlignment(Element.ALIGN_CENTER);           
            paragraph2.setSpacingAfter(10);
            document.add(fechaCre);
            document.add(paragraph1);
            document.add(paragraph2);
            document.setFooter(footer);
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String logo = servletContext.getRealPath("") + "/resources/images/LogoHMCR.jpg";
            Image imagen = Image.getInstance(logo);
            imagen.setAbsolutePosition(25f, 550f);
            imagen.scalePercent(40f);
            document.add(imagen);
            //document.close();

        } catch (DocumentException | FileNotFoundException e) {
        }
    }
    
    @PostConstruct
    public void init() {
        listado = dao.obtenerAnalisisEf(parametrosReportes.getTop());
        calcularTotales();
    }

    public List<AnalisisefTemp> getListado() {
        return listado;
    }

    public TablasTempDAO getDao() {
        return dao;
    }

    public void setListado(List<AnalisisefTemp> listado) {
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

    public void setTotalE(int totalE) {
        this.totalE = totalE;
    }

    public void setTotalEG(int totalEG) {
        this.totalEG = totalEG;
    }

    public void setTotalEM(int totalEM) {
        this.totalEM = totalEM;
    }

    public void setTotalEL(int totalEL) {
        this.totalEL = totalEL;
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

    public int getTotalE() {
        return totalE;
    }

    public int getTotalEG() {
        return totalEG;
    }

    public int getTotalEM() {
        return totalEM;
    }

    public int getTotalEL() {
        return totalEL;
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
    
    private void calcularTotales() {
        for (AnalisisefTemp listado1 : listado) {
            totalE += listado1.getTotalerrores();
            totalEG += listado1.getTotalgraves();
            totalEM += listado1.getTotalmedianos();
            totalEL += listado1.getTotalleves();
            totalO += listado1.getTotalordenes();
            totalOC += listado1.getTotalcompletas();
            totalOI += listado1.getTotalincompletas();
            totalON += listado1.getTotalnada();
        }
    }

}
