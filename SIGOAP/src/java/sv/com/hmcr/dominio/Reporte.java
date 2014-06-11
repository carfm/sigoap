/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.hmcr.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "reporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporte.findAll", query = "SELECT r FROM Reporte r"),
    @NamedQuery(name = "Reporte.findByIdreporte", query = "SELECT r FROM Reporte r WHERE r.idreporte = :idreporte"),
    @NamedQuery(name = "Reporte.findByNombrereporte", query = "SELECT r FROM Reporte r WHERE r.nombrereporte = :nombrereporte"),
    @NamedQuery(name = "Reporte.findByFechainicio", query = "SELECT r FROM Reporte r WHERE r.fechainicio = :fechainicio"),
    @NamedQuery(name = "Reporte.findByFechafin", query = "SELECT r FROM Reporte r WHERE r.fechafin = :fechafin"),
    @NamedQuery(name = "Reporte.findByTop", query = "SELECT r FROM Reporte r WHERE r.top = :top")})
public class Reporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDREPORTE")
    private Integer idreporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBREREPORTE")
    private String nombrereporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafin;
    @Column(name = "TOP")
    private Integer top;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idreporte")
    private List<Genera> generaList;

    public Reporte() {
    }

    public Reporte(Integer idreporte) {
        this.idreporte = idreporte;
    }

    public Reporte(Integer idreporte, String nombrereporte, Date fechainicio, Date fechafin) {
        this.idreporte = idreporte;
        this.nombrereporte = nombrereporte;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

    public Integer getIdreporte() {
        return idreporte;
    }

    public void setIdreporte(Integer idreporte) {
        this.idreporte = idreporte;
    }

    public String getNombrereporte() {
        return nombrereporte;
    }

    public void setNombrereporte(String nombrereporte) {
        this.nombrereporte = nombrereporte;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    @XmlTransient
    public List<Genera> getGeneraList() {
        return generaList;
    }

    public void setGeneraList(List<Genera> generaList) {
        this.generaList = generaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreporte != null ? idreporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reporte)) {
            return false;
        }
        Reporte other = (Reporte) object;
        if ((this.idreporte == null && other.idreporte != null) || (this.idreporte != null && !this.idreporte.equals(other.idreporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.Reporte[ idreporte=" + idreporte + " ]";
    }
    
}
