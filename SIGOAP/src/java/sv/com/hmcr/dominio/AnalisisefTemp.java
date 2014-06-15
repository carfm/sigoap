/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.hmcr.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "analisisef_temp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnalisisefTemp.findAll", query = "SELECT a FROM AnalisisefTemp a"),
    @NamedQuery(name = "AnalisisefTemp.findByEmpleado", query = "SELECT a FROM AnalisisefTemp a WHERE a.empleado = :empleado"),
    @NamedQuery(name = "AnalisisefTemp.findByTotalerrores", query = "SELECT a FROM AnalisisefTemp a WHERE a.totalerrores = :totalerrores"),
    @NamedQuery(name = "AnalisisefTemp.findByTotalgraves", query = "SELECT a FROM AnalisisefTemp a WHERE a.totalgraves = :totalgraves"),
    @NamedQuery(name = "AnalisisefTemp.findByTotalmedianos", query = "SELECT a FROM AnalisisefTemp a WHERE a.totalmedianos = :totalmedianos"),
    @NamedQuery(name = "AnalisisefTemp.findByTotalleves", query = "SELECT a FROM AnalisisefTemp a WHERE a.totalleves = :totalleves"),
    @NamedQuery(name = "AnalisisefTemp.findByTotalordenes", query = "SELECT a FROM AnalisisefTemp a WHERE a.totalordenes = :totalordenes"),
    @NamedQuery(name = "AnalisisefTemp.findByTotalcompletas", query = "SELECT a FROM AnalisisefTemp a WHERE a.totalcompletas = :totalcompletas"),
    @NamedQuery(name = "AnalisisefTemp.findByTotalincompletas", query = "SELECT a FROM AnalisisefTemp a WHERE a.totalincompletas = :totalincompletas"),
    @NamedQuery(name = "AnalisisefTemp.findByTotalnada", query = "SELECT a FROM AnalisisefTemp a WHERE a.totalnada = :totalnada"),
    @NamedQuery(name = "AnalisisefTemp.findByErrororden", query = "SELECT a FROM AnalisisefTemp a WHERE a.errororden = :errororden"),
    @NamedQuery(name = "AnalisisefTemp.findByOrdenerror", query = "SELECT a FROM AnalisisefTemp a WHERE a.ordenerror = :ordenerror")})
public class AnalisisefTemp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "empleado")
    private String empleado;
    @Column(name = "totalerrores")
    private Integer totalerrores;
    @Column(name = "totalgraves")
    private Integer totalgraves;
    @Column(name = "totalmedianos")
    private Integer totalmedianos;
    @Column(name = "totalleves")
    private Integer totalleves;
    @Column(name = "totalordenes")
    private Integer totalordenes;
    @Column(name = "totalcompletas")
    private Integer totalcompletas;
    @Column(name = "totalincompletas")
    private Integer totalincompletas;
    @Column(name = "totalnada")
    private Integer totalnada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "errororden")
    private Float errororden;
    @Column(name = "ordenerror")
    private Float ordenerror;

    public AnalisisefTemp() {
    }

    public AnalisisefTemp(String empleado) {
        this.empleado = empleado;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public Integer getTotalerrores() {
        return totalerrores;
    }

    public void setTotalerrores(Integer totalerrores) {
        this.totalerrores = totalerrores;
    }

    public Integer getTotalgraves() {
        return totalgraves;
    }

    public void setTotalgraves(Integer totalgraves) {
        this.totalgraves = totalgraves;
    }

    public Integer getTotalmedianos() {
        return totalmedianos;
    }

    public void setTotalmedianos(Integer totalmedianos) {
        this.totalmedianos = totalmedianos;
    }

    public Integer getTotalleves() {
        return totalleves;
    }

    public void setTotalleves(Integer totalleves) {
        this.totalleves = totalleves;
    }

    public Integer getTotalordenes() {
        return totalordenes;
    }

    public void setTotalordenes(Integer totalordenes) {
        this.totalordenes = totalordenes;
    }

    public Integer getTotalcompletas() {
        return totalcompletas;
    }

    public void setTotalcompletas(Integer totalcompletas) {
        this.totalcompletas = totalcompletas;
    }

    public Integer getTotalincompletas() {
        return totalincompletas;
    }

    public void setTotalincompletas(Integer totalincompletas) {
        this.totalincompletas = totalincompletas;
    }

    public Integer getTotalnada() {
        return totalnada;
    }

    public void setTotalnada(Integer totalnada) {
        this.totalnada = totalnada;
    }

    public Float getErrororden() {
        return errororden;
    }

    public void setErrororden(Float errororden) {
        this.errororden = errororden;
    }

    public Float getOrdenerror() {
        return ordenerror;
    }

    public void setOrdenerror(Float ordenerror) {
        this.ordenerror = ordenerror;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleado != null ? empleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnalisisefTemp)) {
            return false;
        }
        AnalisisefTemp other = (AnalisisefTemp) object;
        if ((this.empleado == null && other.empleado != null) || (this.empleado != null && !this.empleado.equals(other.empleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.AnalisisefTemp[ empleado=" + empleado + " ]";
    }
    
}
