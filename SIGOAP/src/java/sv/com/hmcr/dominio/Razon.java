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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "razon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Razon.findAll", query = "SELECT r FROM Razon r"),
    @NamedQuery(name = "Razon.findByIdrazon", query = "SELECT r FROM Razon r WHERE r.idrazon = :idrazon"),
    @NamedQuery(name = "Razon.findByNombrerazon", query = "SELECT r FROM Razon r WHERE r.nombrerazon = :nombrerazon")})
public class Razon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRAZON")
    private Integer idrazon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRERAZON")
    private String nombrerazon;
    @JoinColumn(name = "IDPROCESAAUDITA", referencedColumnName = "IDPROCESAAUDITA")
    @ManyToOne
    private ProcesaAudita idprocesaaudita;

    public Razon() {
    }

    public Razon(Integer idrazon) {
        this.idrazon = idrazon;
    }

    public Razon(Integer idrazon, String nombrerazon) {
        this.idrazon = idrazon;
        this.nombrerazon = nombrerazon;
    }

    public Integer getIdrazon() {
        return idrazon;
    }

    public void setIdrazon(Integer idrazon) {
        this.idrazon = idrazon;
    }

    public String getNombrerazon() {
        return nombrerazon;
    }

    public void setNombrerazon(String nombrerazon) {
        this.nombrerazon = nombrerazon;
    }

    public ProcesaAudita getIdprocesaaudita() {
        return idprocesaaudita;
    }

    public void setIdprocesaaudita(ProcesaAudita idprocesaaudita) {
        this.idprocesaaudita = idprocesaaudita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrazon != null ? idrazon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Razon)) {
            return false;
        }
        Razon other = (Razon) object;
        if ((this.idrazon == null && other.idrazon != null) || (this.idrazon != null && !this.idrazon.equals(other.idrazon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.Razon[ idrazon=" + idrazon + " ]";
    }
    
}
