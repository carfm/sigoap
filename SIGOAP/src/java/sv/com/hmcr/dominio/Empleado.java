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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdempleado", query = "SELECT e FROM Empleado e WHERE e.idempleado = :idempleado"),
    @NamedQuery(name = "Empleado.findByNombreempleado", query = "SELECT e FROM Empleado e WHERE e.nombreempleado = :nombreempleado"),
    @NamedQuery(name = "Empleado.findByActivo", query = "SELECT e FROM Empleado e WHERE e.activo = :activo"),
    @NamedQuery(name = "Empleado.findByCorrelativo", query = "SELECT e FROM Empleado e WHERE e.correlativo = :correlativo")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IDEMPLEADO")
    private String idempleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "NOMBREEMPLEADO")
    private String nombreempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO")
    private short activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORRELATIVO")
    private int correlativo;
    @OneToMany(mappedBy = "idempleado")
    private List<ProcesaAudita> procesaAuditaList;
    @OneToMany(mappedBy = "idempleado")
    private List<RegistroError> registroErrorList;
    @JoinColumn(name = "USER", referencedColumnName = "USER")
    @ManyToOne
    private Usuario user;

    public Empleado() {
    }

    public Empleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public Empleado(String idempleado, String nombreempleado, short activo, int correlativo) {
        this.idempleado = idempleado;
        this.nombreempleado = nombreempleado;
        this.activo = activo;
        this.correlativo = correlativo;
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombreempleado() {
        return nombreempleado;
    }

    public void setNombreempleado(String nombreempleado) {
        this.nombreempleado = nombreempleado;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
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

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempleado != null ? idempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idempleado == null && other.idempleado != null) || (this.idempleado != null && !this.idempleado.equals(other.idempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.Empleado[ idempleado=" + idempleado + " ]";
    }
    
}
