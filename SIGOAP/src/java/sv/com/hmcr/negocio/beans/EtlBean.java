/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.negocio.beans;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sv.com.hmcr.dao.TablasTempDAO;

/**
 *
 * @author Carlos y Jose
 */
@ManagedBean(name = "etlBean")
@ViewScoped
public class EtlBean implements Serializable {

    /**
     * Creates a new instance of EtlBean
     */
    private TablasTempDAO procedimiento;
    private Integer progress;

    public EtlBean() {
        progress = 0;
        procedimiento = new TablasTempDAO();
    }

    public void etl(ActionEvent action) {
        progress = 20;
        procedimiento.ejecutarProc("call etlEmpleado()");
        progress = 30;
        procedimiento.ejecutarProc("call etlOrden()");
        progress = 60;
        procedimiento.ejecutarProc("call etlProcesaAudita()");
        progress = 100;
    }

    /**
     * @return the procedimiento
     */
    public TablasTempDAO getProcedimiento() {
        return procedimiento;
    }

    /**
     * @param procedimiento the procedimiento to set
     */
    public void setProcedimiento(TablasTempDAO procedimiento) {
        this.procedimiento = procedimiento;
    }

    /**
     * @return the progress
     */
    public Integer getProgress() {
//        if (progress == null) {
//            progress = 0;
//        } else {
//            progress = progress + (int) (Math.random() * 35);
//
//            if (progress > 100) {
//                progress = 100;
//            }
//        }

        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

}
