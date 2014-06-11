/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.hmcr.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "estandar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estandar.findAll", query = "SELECT e FROM Estandar e"),
    @NamedQuery(name = "Estandar.findByIdestandar", query = "SELECT e FROM Estandar e WHERE e.idestandar = :idestandar"),
    @NamedQuery(name = "Estandar.findByValor", query = "SELECT e FROM Estandar e WHERE e.valor = :valor"),
    @NamedQuery(name = "Estandar.findByInicio", query = "SELECT e FROM Estandar e WHERE e.inicio = :inicio"),
    @NamedQuery(name = "Estandar.findByFin", query = "SELECT e FROM Estandar e WHERE e.fin = :fin")})
public class Estandar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDESTANDAR")
    private Integer idestandar;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Column(name = "FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fin;

    public Estandar() {
    }

    public Estandar(Integer idestandar) {
        this.idestandar = idestandar;
    }

    public Estandar(Integer idestandar, BigDecimal valor) {
        this.idestandar = idestandar;
        this.valor = valor;
    }

    public Integer getIdestandar() {
        return idestandar;
    }

    public void setIdestandar(Integer idestandar) {
        this.idestandar = idestandar;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestandar != null ? idestandar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estandar)) {
            return false;
        }
        Estandar other = (Estandar) object;
        if ((this.idestandar == null && other.idestandar != null) || (this.idestandar != null && !this.idestandar.equals(other.idestandar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.Estandar[ idestandar=" + idestandar + " ]";
    }
    
}
