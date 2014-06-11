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
@Table(name = "registro_error")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroError.findAll", query = "SELECT r FROM RegistroError r"),
    @NamedQuery(name = "RegistroError.findByIdregistroerror", query = "SELECT r FROM RegistroError r WHERE r.idregistroerror = :idregistroerror"),
    @NamedQuery(name = "RegistroError.findByCategoriaerror", query = "SELECT r FROM RegistroError r WHERE r.categoriaerror = :categoriaerror"),
    @NamedQuery(name = "RegistroError.findByTipoerror", query = "SELECT r FROM RegistroError r WHERE r.tipoerror = :tipoerror")})
public class RegistroError implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDREGISTROERROR")
    private Integer idregistroerror;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATEGORIAERROR")
    private int categoriaerror;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPOERROR")
    private int tipoerror;
    @JoinColumn(name = "IDEMPLEADO", referencedColumnName = "IDEMPLEADO")
    @ManyToOne
    private Empleado idempleado;
    @JoinColumn(name = "SPECIMEN", referencedColumnName = "SPECIMEN")
    @ManyToOne
    private Orden specimen;

    public RegistroError() {
    }

    public RegistroError(Integer idregistroerror) {
        this.idregistroerror = idregistroerror;
    }

    public RegistroError(Integer idregistroerror, int categoriaerror, int tipoerror) {
        this.idregistroerror = idregistroerror;
        this.categoriaerror = categoriaerror;
        this.tipoerror = tipoerror;
    }

    public Integer getIdregistroerror() {
        return idregistroerror;
    }

    public void setIdregistroerror(Integer idregistroerror) {
        this.idregistroerror = idregistroerror;
    }

    public int getCategoriaerror() {
        return categoriaerror;
    }

    public void setCategoriaerror(int categoriaerror) {
        this.categoriaerror = categoriaerror;
    }

    public int getTipoerror() {
        return tipoerror;
    }

    public void setTipoerror(int tipoerror) {
        this.tipoerror = tipoerror;
    }

    public Empleado getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Empleado idempleado) {
        this.idempleado = idempleado;
    }

    public Orden getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Orden specimen) {
        this.specimen = specimen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregistroerror != null ? idregistroerror.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroError)) {
            return false;
        }
        RegistroError other = (RegistroError) object;
        if ((this.idregistroerror == null && other.idregistroerror != null) || (this.idregistroerror != null && !this.idregistroerror.equals(other.idregistroerror))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.RegistroError[ idregistroerror=" + idregistroerror + " ]";
    }
    
}
