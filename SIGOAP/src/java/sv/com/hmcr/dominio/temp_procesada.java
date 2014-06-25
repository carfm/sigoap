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
 * @author Luis
 */
@Entity
@Table(name = "temp_procesada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "temp_procesada.findAll", query = "SELECT a FROM temp_procesada a"),
    @NamedQuery(name = "temp_procesada.findByUsuario", query = "SELECT a FROM temp_procesada a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "temp_procesada.findByTotalProcesadas", query = "SELECT a FROM temp_procesada a WHERE a.totalProcesadas = :totalProcesadas"),
    @NamedQuery(name = "temp_procesada.findByCompletas", query = "SELECT a FROM temp_procesada a WHERE a.completas = :completas"),
    @NamedQuery(name = "temp_procesada.findByIncompletas", query = "SELECT a FROM temp_procesada a WHERE a.incompletas = :incompletas"),
    @NamedQuery(name = "temp_procesada.findByNada", query = "SELECT a FROM temp_procesada a WHERE a.nada = :nada")})
public class temp_procesada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "totalProcesadas")
    private Integer totalProcesadas;
    @Column(name = "completas")
    private Integer completas;
    @Column(name = "incompletas")
    private Integer incompletas;
    @Column(name = "nada")
    private Integer nada;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation


    public temp_procesada() {
    }

    public temp_procesada(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getTotalProcesadas() {
        return totalProcesadas;
    }

    public void setTotalProcesadas(Integer totalProcesadas) {
        this.totalProcesadas= totalProcesadas;
    }

    public Integer getCompletas() {
        return completas;
    }

    public void setCompletas(Integer completas) {
        this.completas = completas;
    }

    public Integer getIncompletas() {
        return incompletas;
    }

    public void setIncompletas(Integer incompletas) {
        this.incompletas = incompletas;
    }

    public Integer getNada() {
        return nada;
    }

    public void setNada(Integer nada) {
        this.nada = nada;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario!= null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof temp_procesada)) {
            return false;
        }
        temp_procesada other = (temp_procesada) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.temp_procesada[ usuario=" + usuario + " ]";
    }
    
}
