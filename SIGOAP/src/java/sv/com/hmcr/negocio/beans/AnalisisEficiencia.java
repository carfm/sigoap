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
        listado = dao.obtenerAnalisisEf(1);
        calcularTotales();

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
        listado = dao.obtenerAnalisisEf(parametrosReportes.getTop());
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
        for (int i = 0; i < listado.size(); i++) {
            totalE += listado.get(i).getTotalerrores();
            totalEG += listado.get(i).getTotalgraves();
            totalEM += listado.get(i).getTotalmedianos();
            totalEL += listado.get(i).getTotalleves();
            totalO += listado.get(i).getTotalordenes();
            totalOC += listado.get(i).getTotalcompletas();
            totalOI += listado.get(i).getTotalincompletas();
            totalON += listado.get(i).getTotalnada();
        }
    }

}
