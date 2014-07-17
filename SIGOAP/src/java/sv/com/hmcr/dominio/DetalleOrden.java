/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.hmcr.dominio;

import java.io.Serializable;

/**
 *
 * @author Luis
 */
public class DetalleOrden implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String specimen;
    private String tipoOrden;

    public DetalleOrden(String specimen, String tipoOrden) {
        this.specimen = specimen;
        this.tipoOrden = tipoOrden;
    }

    public DetalleOrden() {
    }

    public String getSpecimen() {
        return specimen;
    }

    public String getTipoOrden() {
        return tipoOrden;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    public void setTipoOrden(String tipoOrden) {
        this.tipoOrden = tipoOrden;
    }
    
    
    
    
}
