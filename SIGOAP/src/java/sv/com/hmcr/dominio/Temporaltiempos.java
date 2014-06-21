/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.hmcr.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos y Jose
 */
@Entity
@Table(name = "temporaltiempos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Temporaltiempos.findAll", query = "SELECT t FROM Temporaltiempos t"),
    @NamedQuery(name = "Temporaltiempos.findByAgente", query = "SELECT t FROM Temporaltiempos t WHERE t.agente = :agente"),
    @NamedQuery(name = "Temporaltiempos.findByPromedio", query = "SELECT t FROM Temporaltiempos t WHERE t.promedio = :promedio"),
    @NamedQuery(name = "Temporaltiempos.findByMinimo", query = "SELECT t FROM Temporaltiempos t WHERE t.minimo = :minimo"),
    @NamedQuery(name = "Temporaltiempos.findByMaximo", query = "SELECT t FROM Temporaltiempos t WHERE t.maximo = :maximo")})
public class Temporaltiempos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "AGENTE")
    private String agente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROMEDIO")
    @Temporal(TemporalType.TIME)
    private Date promedio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MINIMO")
    @Temporal(TemporalType.TIME)
    private Date minimo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MAXIMO")
    @Temporal(TemporalType.TIME)
    private Date maximo;

    public Temporaltiempos() {
    }

    public Temporaltiempos(String agente) {
        this.agente = agente;
    }

    public Temporaltiempos(String agente, Date promedio, Date minimo, Date maximo) {
        this.agente = agente;
        this.promedio = promedio;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public Date getPromedio() {
        return promedio;
    }

    public void setPromedio(Date promedio) {
        this.promedio = promedio;
    }

    public Date getMinimo() {
        return minimo;
    }

    public void setMinimo(Date minimo) {
        this.minimo = minimo;
    }

    public Date getMaximo() {
        return maximo;
    }

    public void setMaximo(Date maximo) {
        this.maximo = maximo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agente != null ? agente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Temporaltiempos)) {
            return false;
        }
        Temporaltiempos other = (Temporaltiempos) object;
        if ((this.agente == null && other.agente != null) || (this.agente != null && !this.agente.equals(other.agente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.Temporaltiempos[ agente=" + agente + " ]";
    }
    
}
