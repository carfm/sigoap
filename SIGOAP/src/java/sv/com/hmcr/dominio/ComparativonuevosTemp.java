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
@Table(name = "comparativonuevos_temp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComparativonuevosTemp.findAll", query = "SELECT c FROM ComparativonuevosTemp c"),
    @NamedQuery(name = "ComparativonuevosTemp.findByEmpleado", query = "SELECT c FROM ComparativonuevosTemp c WHERE c.empleado = :empleado"),
    @NamedQuery(name = "ComparativonuevosTemp.findByTotalordenes", query = "SELECT c FROM ComparativonuevosTemp c WHERE c.totalordenes = :totalordenes"),
    @NamedQuery(name = "ComparativonuevosTemp.findByDiferenciaTotal", query = "SELECT c FROM ComparativonuevosTemp c WHERE c.diferenciaTotal = :diferenciaTotal"),
    @NamedQuery(name = "ComparativonuevosTemp.findByTotalcompletas", query = "SELECT c FROM ComparativonuevosTemp c WHERE c.totalcompletas = :totalcompletas"),
    @NamedQuery(name = "ComparativonuevosTemp.findByDiferenciaCompletas", query = "SELECT c FROM ComparativonuevosTemp c WHERE c.diferenciaCompletas = :diferenciaCompletas"),
    @NamedQuery(name = "ComparativonuevosTemp.findByTotalincompletas", query = "SELECT c FROM ComparativonuevosTemp c WHERE c.totalincompletas = :totalincompletas"),
    @NamedQuery(name = "ComparativonuevosTemp.findByDiferenciaIncompletas", query = "SELECT c FROM ComparativonuevosTemp c WHERE c.diferenciaIncompletas = :diferenciaIncompletas"),
    @NamedQuery(name = "ComparativonuevosTemp.findByTotalnada", query = "SELECT c FROM ComparativonuevosTemp c WHERE c.totalnada = :totalnada"),
    @NamedQuery(name = "ComparativonuevosTemp.findByDiferenciaNada", query = "SELECT c FROM ComparativonuevosTemp c WHERE c.diferenciaNada = :diferenciaNada")})
public class ComparativonuevosTemp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "empleado")
    private String empleado;
    @Column(name = "totalordenes")
    private Integer totalordenes;
    @Column(name = "diferenciaTotal")
    private Integer diferenciaTotal;
    @Column(name = "totalcompletas")
    private Integer totalcompletas;
    @Column(name = "diferenciaCompletas")
    private Integer diferenciaCompletas;
    @Column(name = "totalincompletas")
    private Integer totalincompletas;
    @Column(name = "diferenciaIncompletas")
    private Integer diferenciaIncompletas;
    @Column(name = "totalnada")
    private Integer totalnada;
    @Column(name = "diferenciaNada")
    private Integer diferenciaNada;

    public ComparativonuevosTemp() {
    }

    public ComparativonuevosTemp(String empleado) {
        this.empleado = empleado;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public Integer getTotalordenes() {
        return totalordenes;
    }

    public void setTotalordenes(Integer totalordenes) {
        this.totalordenes = totalordenes;
    }

    public Integer getDiferenciaTotal() {
        return diferenciaTotal;
    }

    public void setDiferenciaTotal(Integer diferenciaTotal) {
        this.diferenciaTotal = diferenciaTotal;
    }

    public Integer getTotalcompletas() {
        return totalcompletas;
    }

    public void setTotalcompletas(Integer totalcompletas) {
        this.totalcompletas = totalcompletas;
    }

    public Integer getDiferenciaCompletas() {
        return diferenciaCompletas;
    }

    public void setDiferenciaCompletas(Integer diferenciaCompletas) {
        this.diferenciaCompletas = diferenciaCompletas;
    }

    public Integer getTotalincompletas() {
        return totalincompletas;
    }

    public void setTotalincompletas(Integer totalincompletas) {
        this.totalincompletas = totalincompletas;
    }

    public Integer getDiferenciaIncompletas() {
        return diferenciaIncompletas;
    }

    public void setDiferenciaIncompletas(Integer diferenciaIncompletas) {
        this.diferenciaIncompletas = diferenciaIncompletas;
    }

    public Integer getTotalnada() {
        return totalnada;
    }

    public void setTotalnada(Integer totalnada) {
        this.totalnada = totalnada;
    }

    public Integer getDiferenciaNada() {
        return diferenciaNada;
    }

    public void setDiferenciaNada(Integer diferenciaNada) {
        this.diferenciaNada = diferenciaNada;
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
        if (!(object instanceof ComparativonuevosTemp)) {
            return false;
        }
        ComparativonuevosTemp other = (ComparativonuevosTemp) object;
        if ((this.empleado == null && other.empleado != null) || (this.empleado != null && !this.empleado.equals(other.empleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.ComparativonuevosTemp[ empleado=" + empleado + " ]";
    }
    
}
