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
import java.math.BigDecimal;
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
import sv.com.hmcr.dominio.ComparativonuevosTemp;
import sv.com.hmcr.dominio.Estandar;

/**
 *
 * @author Luis
 */
@ManagedBean
@ViewScoped
public class Comparativo implements java.io.Serializable{
    private List<ComparativonuevosTemp> listado; 
    private TablasTempDAO dao;
    private List<Estandar> estandar;
    private BigDecimal eComp;
    private BigDecimal eIn;
    private BigDecimal eNada;
    
    
    @ManagedProperty(value = "#{parametrosReportes}")
    private ParametrosReportes parametrosReportes;
    
    @ManagedProperty(value = "#{opciones}")
    private Opciones opciones;
    
    public Comparativo() {
        dao=new TablasTempDAO ();
        listado=new ArrayList<>();
        estandar = dao.recuperarEstandar();
        eComp = estandar.get(0).getValor();
        eIn = estandar.get(1).getValor();
        eNada = estandar.get(2).getValor();
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
                    + "REPORTE DE PROMEDIOS DE ÓRDENES PROCESADAS DE AGENTES NUEVOS\n"
                    + "DEL PERIODO "+parametrosReportes.getFechaInicio() +" AL  "
                    +parametrosReportes.getFechaFin()+"\n\n SUPERVISADOS POR: "+
                    opciones.getUsuario().getNombreusuario()+" "+opciones.getUsuario().getApellidousuario(),
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
    
    public void postProcessPDF(Object doc) throws IOException {
    Document document = (Document) doc;    
        try {
            //PdfWriter.getInstance(document,new FileOutputStream("temp_errorencontrado.pdf"));
            //document.open();
            Paragraph paragraph1 = new Paragraph("PROMEDIO EMPRESARIAL: PROCESADAS: "
                    + "999 INCOMPLETAS: 999 SIN HACER NADA: 999",
                            new Font(Font.HELVETICA  , 11, Font.NORMAL,new Color(0, 0, 0)));
            paragraph1.setAlignment(Element.ALIGN_CENTER);           
            paragraph1.setSpacingBefore(15);
            document.add(paragraph1);
            document.close();
        } catch (DocumentException ex){
        }

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

    public List<Estandar> getEstandar() {
        return estandar;
    }

    public BigDecimal geteComp() {
        return eComp;
    }

    public BigDecimal geteIn() {
        return eIn;
    }

    public BigDecimal geteNada() {
        return eNada;
    }

    public Opciones getOpciones() {
        return opciones;
    }

    public void setEstandar(List<Estandar> estandar) {
        this.estandar = estandar;
    }

    public void seteComp(BigDecimal eComp) {
        this.eComp = eComp;
    }

    public void seteIn(BigDecimal eIn) {
        this.eIn = eIn;
    }

    public void seteNada(BigDecimal eNada) {
        this.eNada = eNada;
    }

    public void setOpciones(Opciones opciones) {
        this.opciones = opciones;
    }  
    
    
}
