/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.hmcr.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "orden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o"),
    @NamedQuery(name = "Orden.findBySpecimen", query = "SELECT o FROM Orden o WHERE o.specimen = :specimen"),
    @NamedQuery(name = "Orden.findByTipoorden", query = "SELECT o FROM Orden o WHERE o.tipoorden = :tipoorden")})
public class Orden implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "SPECIMEN")
    private String specimen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPOORDEN")
    private int tipoorden;
    @OneToMany(mappedBy = "specimen")
    private List<ProcesaAudita> procesaAuditaList;
    @OneToMany(mappedBy = "specimen")
    private List<RegistroError> registroErrorList;

    public Orden() {
    }

    public Orden(String specimen) {
        this.specimen = specimen;
    }

    public Orden(String specimen, int tipoorden) {
        this.specimen = specimen;
        this.tipoorden = tipoorden;
    }

    public String getSpecimen() {
        return specimen;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    public int getTipoorden() {
        return tipoorden;
    }

    public void setTipoorden(int tipoorden) {
        this.tipoorden = tipoorden;
    }

    @XmlTransient
    public List<ProcesaAudita> getProcesaAuditaList() {
        return procesaAuditaList;
    }

    public void setProcesaAuditaList(List<ProcesaAudita> procesaAuditaList) {
        this.procesaAuditaList = procesaAuditaList;
    }

    @XmlTransient
    public List<RegistroError> getRegistroErrorList() {
        return registroErrorList;
    }

    public void setRegistroErrorList(List<RegistroError> registroErrorList) {
        this.registroErrorList = registroErrorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specimen != null ? specimen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.specimen == null && other.specimen != null) || (this.specimen != null && !this.specimen.equals(other.specimen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.Orden[ specimen=" + specimen + " ]";
    }
    
}
