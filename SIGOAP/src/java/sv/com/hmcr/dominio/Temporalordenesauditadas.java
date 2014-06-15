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
@Table(name = "temporalordenesauditadas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Temporalordenesauditadas.findAll", query = "SELECT t FROM Temporalordenesauditadas t"),
    @NamedQuery(name = "Temporalordenesauditadas.findByCorrelativo", query = "SELECT t FROM Temporalordenesauditadas t WHERE t.correlativo = :correlativo"),
    @NamedQuery(name = "Temporalordenesauditadas.findByAuditor", query = "SELECT t FROM Temporalordenesauditadas t WHERE t.auditor = :auditor"),
    @NamedQuery(name = "Temporalordenesauditadas.findByAuditadas", query = "SELECT t FROM Temporalordenesauditadas t WHERE t.auditadas = :auditadas"),
    @NamedQuery(name = "Temporalordenesauditadas.findBySinerror", query = "SELECT t FROM Temporalordenesauditadas t WHERE t.sinerror = :sinerror"),
    @NamedQuery(name = "Temporalordenesauditadas.findByConerror", query = "SELECT t FROM Temporalordenesauditadas t WHERE t.conerror = :conerror")})
public class Temporalordenesauditadas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORRELATIVO")
    private Integer correlativo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "AUDITOR")
    private String auditor;
    @Column(name = "AUDITADAS")
    private Integer auditadas;
    @Column(name = "SINERROR")
    private Integer sinerror;
    @Column(name = "CONERROR")
    private Integer conerror;

    public Temporalordenesauditadas() {
    }

    public Temporalordenesauditadas(Integer correlativo) {
        this.correlativo = correlativo;
    }

    public Temporalordenesauditadas(Integer correlativo, String auditor) {
        this.correlativo = correlativo;
        this.auditor = auditor;
    }

    public Integer getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(Integer correlativo) {
        this.correlativo = correlativo;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public Integer getAuditadas() {
        return auditadas;
    }

    public void setAuditadas(Integer auditadas) {
        this.auditadas = auditadas;
    }

    public Integer getSinerror() {
        return sinerror;
    }

    public void setSinerror(Integer sinerror) {
        this.sinerror = sinerror;
    }

    public Integer getConerror() {
        return conerror;
    }

    public void setConerror(Integer conerror) {
        this.conerror = conerror;
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
        if (!(object instanceof Temporalordenesauditadas)) {
            return false;
        }
        Temporalordenesauditadas other = (Temporalordenesauditadas) object;
        if ((this.correlativo == null && other.correlativo != null) || (this.correlativo != null && !this.correlativo.equals(other.correlativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.Temporalordenesauditadas[ correlativo=" + correlativo + " ]";
    }
    
}
