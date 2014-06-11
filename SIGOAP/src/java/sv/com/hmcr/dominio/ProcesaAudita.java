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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "procesa_audita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesaAudita.findAll", query = "SELECT p FROM ProcesaAudita p"),
    @NamedQuery(name = "ProcesaAudita.findByIdprocesaaudita", query = "SELECT p FROM ProcesaAudita p WHERE p.idprocesaaudita = :idprocesaaudita"),
    @NamedQuery(name = "ProcesaAudita.findByFechaprocesaaudita", query = "SELECT p FROM ProcesaAudita p WHERE p.fechaprocesaaudita = :fechaprocesaaudita"),
    @NamedQuery(name = "ProcesaAudita.findByHorainicio", query = "SELECT p FROM ProcesaAudita p WHERE p.horainicio = :horainicio"),
    @NamedQuery(name = "ProcesaAudita.findByHorafin", query = "SELECT p FROM ProcesaAudita p WHERE p.horafin = :horafin"),
    @NamedQuery(name = "ProcesaAudita.findByTipoprocesaaudita", query = "SELECT p FROM ProcesaAudita p WHERE p.tipoprocesaaudita = :tipoprocesaaudita")})
public class ProcesaAudita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPROCESAAUDITA")
    private Long idprocesaaudita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAPROCESAAUDITA")
    @Temporal(TemporalType.DATE)
    private Date fechaprocesaaudita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAINICIO")
    @Temporal(TemporalType.TIME)
    private Date horainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAFIN")
    @Temporal(TemporalType.TIME)
    private Date horafin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPOPROCESAAUDITA")
    private int tipoprocesaaudita;
    @JoinColumn(name = "IDEMPLEADO", referencedColumnName = "IDEMPLEADO")
    @ManyToOne
    private Empleado idempleado;
    @JoinColumn(name = "SPECIMEN", referencedColumnName = "SPECIMEN")
    @ManyToOne
    private Orden specimen;
    @OneToMany(mappedBy = "idprocesaaudita")
    private List<Razon> razonList;

    public ProcesaAudita() {
    }

    public ProcesaAudita(Long idprocesaaudita) {
        this.idprocesaaudita = idprocesaaudita;
    }

    public ProcesaAudita(Long idprocesaaudita, Date fechaprocesaaudita, Date horainicio, Date horafin, int tipoprocesaaudita) {
        this.idprocesaaudita = idprocesaaudita;
        this.fechaprocesaaudita = fechaprocesaaudita;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.tipoprocesaaudita = tipoprocesaaudita;
    }

    public Long getIdprocesaaudita() {
        return idprocesaaudita;
    }

    public void setIdprocesaaudita(Long idprocesaaudita) {
        this.idprocesaaudita = idprocesaaudita;
    }

    public Date getFechaprocesaaudita() {
        return fechaprocesaaudita;
    }

    public void setFechaprocesaaudita(Date fechaprocesaaudita) {
        this.fechaprocesaaudita = fechaprocesaaudita;
    }

    public Date getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Date horainicio) {
        this.horainicio = horainicio;
    }

    public Date getHorafin() {
        return horafin;
    }

    public void setHorafin(Date horafin) {
        this.horafin = horafin;
    }

    public int getTipoprocesaaudita() {
        return tipoprocesaaudita;
    }

    public void setTipoprocesaaudita(int tipoprocesaaudita) {
        this.tipoprocesaaudita = tipoprocesaaudita;
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

    @XmlTransient
    public List<Razon> getRazonList() {
        return razonList;
    }

    public void setRazonList(List<Razon> razonList) {
        this.razonList = razonList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprocesaaudita != null ? idprocesaaudita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesaAudita)) {
            return false;
        }
        ProcesaAudita other = (ProcesaAudita) object;
        if ((this.idprocesaaudita == null && other.idprocesaaudita != null) || (this.idprocesaaudita != null && !this.idprocesaaudita.equals(other.idprocesaaudita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.ProcesaAudita[ idprocesaaudita=" + idprocesaaudita + " ]";
    }
    
}
