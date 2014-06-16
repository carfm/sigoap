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
 * @author Carlos y Jose
 */
@Entity
@Table(name = "temporalordenesprocesadasnuevos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Temporalordenesprocesadasnuevos.findAll", query = "SELECT t FROM Temporalordenesprocesadasnuevos t"),
    @NamedQuery(name = "Temporalordenesprocesadasnuevos.findByCorrelativo", query = "SELECT t FROM Temporalordenesprocesadasnuevos t WHERE t.correlativo = :correlativo"),
    @NamedQuery(name = "Temporalordenesprocesadasnuevos.findByAgente", query = "SELECT t FROM Temporalordenesprocesadasnuevos t WHERE t.agente = :agente"),
    @NamedQuery(name = "Temporalordenesprocesadasnuevos.findByTotal", query = "SELECT t FROM Temporalordenesprocesadasnuevos t WHERE t.total = :total"),
    @NamedQuery(name = "Temporalordenesprocesadasnuevos.findByCompletas", query = "SELECT t FROM Temporalordenesprocesadasnuevos t WHERE t.completas = :completas"),
    @NamedQuery(name = "Temporalordenesprocesadasnuevos.findByIncompletas", query = "SELECT t FROM Temporalordenesprocesadasnuevos t WHERE t.incompletas = :incompletas"),
    @NamedQuery(name = "Temporalordenesprocesadasnuevos.findByNada", query = "SELECT t FROM Temporalordenesprocesadasnuevos t WHERE t.nada = :nada")})
public class Temporalordenesprocesadasnuevos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORRELATIVO")
    private Integer correlativo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "AGENTE")
    private String agente;
    @Column(name = "TOTAL")
    private Integer total;
    @Column(name = "COMPLETAS")
    private Integer completas;
    @Column(name = "INCOMPLETAS")
    private Integer incompletas;
    @Column(name = "NADA")
    private Integer nada;

    public Temporalordenesprocesadasnuevos() {
    }

    public Temporalordenesprocesadasnuevos(Integer correlativo) {
        this.correlativo = correlativo;
    }

    public Temporalordenesprocesadasnuevos(Integer correlativo, String agente) {
        this.correlativo = correlativo;
        this.agente = agente;
    }

    public Integer getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(Integer correlativo) {
        this.correlativo = correlativo;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCompletas() {
        return completas;
    }

    public void setCompletas(Integer completas) {
        this.completas = completas;
    }

    public Integer getIncompletas() {
        return incompletas;
    }

    public void setIncompletas(Integer incompletas) {
        this.incompletas = incompletas;
    }

    public Integer getNada() {
        return nada;
    }

    public void setNada(Integer nada) {
        this.nada = nada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correlativo != null ? correlativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Temporalordenesprocesadasnuevos)) {
            return false;
        }
        Temporalordenesprocesadasnuevos other = (Temporalordenesprocesadasnuevos) object;
        if ((this.correlativo == null && other.correlativo != null) || (this.correlativo != null && !this.correlativo.equals(other.correlativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.Temporalordenesprocesadasnuevos[ correlativo=" + correlativo + " ]";
    }
    
}
