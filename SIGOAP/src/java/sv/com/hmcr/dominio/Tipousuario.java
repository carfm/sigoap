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
@Table(name = "tipousuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipousuario.findAll", query = "SELECT t FROM Tipousuario t"),
    @NamedQuery(name = "Tipousuario.findByIdtipousuario", query = "SELECT t FROM Tipousuario t WHERE t.idtipousuario = :idtipousuario"),
    @NamedQuery(name = "Tipousuario.findByNombretipousuario", query = "SELECT t FROM Tipousuario t WHERE t.nombretipousuario = :nombretipousuario")})
public class Tipousuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPOUSUARIO")
    private Integer idtipousuario;
    @Size(max = 20)
    @Column(name = "NOMBRETIPOUSUARIO")
    private String nombretipousuario;
    @OneToMany(mappedBy = "idtipousuario")
    private List<Usuario> usuarioList;

    public Tipousuario() {
    }

    public Tipousuario(Integer idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

    public Integer getIdtipousuario() {
        return idtipousuario;
    }

    public void setIdtipousuario(Integer idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

    public String getNombretipousuario() {
        return nombretipousuario;
    }

    public void setNombretipousuario(String nombretipousuario) {
        this.nombretipousuario = nombretipousuario;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipousuario != null ? idtipousuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipousuario)) {
            return false;
        }
        Tipousuario other = (Tipousuario) object;
        if ((this.idtipousuario == null && other.idtipousuario != null) || (this.idtipousuario != null && !this.idtipousuario.equals(other.idtipousuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.Tipousuario[ idtipousuario=" + idtipousuario + " ]";
    }
    
}
