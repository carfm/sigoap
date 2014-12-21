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
@ManagedBean
@ViewScoped

public class EtlBean implements Serializable{




    /**
     * Creates a new instance of EtlBean
     */
    
    private TablasTempDAO procedimiento;
    
    public EtlBean() {
        procedimiento = new TablasTempDAO();
    }

    
    public void etl(ActionEvent actionEvent){
        procedimiento.ejecutarProc("call etlEmpleado()");
        procedimiento.ejecutarProc("call etlOrden()");
        procedimiento.ejecutarProc("call etlProcesaAudita()");
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
    
}
