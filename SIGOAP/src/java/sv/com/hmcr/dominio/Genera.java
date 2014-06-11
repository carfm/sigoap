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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "genera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genera.findAll", query = "SELECT g FROM Genera g"),
    @NamedQuery(name = "Genera.findByIdGenera", query = "SELECT g FROM Genera g WHERE g.idGenera = :idGenera")})
public class Genera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idGenera")
    private Integer idGenera;
    @JoinColumn(name = "idreporte", referencedColumnName = "IDREPORTE")
    @ManyToOne(optional = false)
    private Reporte idreporte;
    @JoinColumn(name = "user", referencedColumnName = "USER")
    @ManyToOne(optional = false)
    private Usuario user;

    public Genera() {
    }

    public Genera(Integer idGenera) {
        this.idGenera = idGenera;
    }

    public Integer getIdGenera() {
        return idGenera;
    }

    public void setIdGenera(Integer idGenera) {
        this.idGenera = idGenera;
    }

    public Reporte getIdreporte() {
        return idreporte;
    }

    public void setIdreporte(Reporte idreporte) {
        this.idreporte = idreporte;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGenera != null ? idGenera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genera)) {
            return false;
        }
        Genera other = (Genera) object;
        if ((this.idGenera == null && other.idGenera != null) || (this.idGenera != null && !this.idGenera.equals(other.idGenera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.Genera[ idGenera=" + idGenera + " ]";
    }
    
}
