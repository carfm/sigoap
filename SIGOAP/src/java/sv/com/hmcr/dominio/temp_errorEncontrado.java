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
@Table(name = "temp_errorEncontrado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "temp_errorEncontrado.findAll", query = "SELECT a FROM temp_errorEncontrado a"),
    @NamedQuery(name = "temp_errorEncontrado.findByUsuario", query = "SELECT a FROM temp_errorEncontrado a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "temp_errorEncontrado.findByGrave", query = "SELECT a FROM temp_errorEncontrado a WHERE a.grave = :grave"),
    @NamedQuery(name = "temp_errorEncontrado.findByMediano", query = "SELECT a FROM temp_errorEncontrado a WHERE a.mediano = :mediano"),
    @NamedQuery(name = "temp_errorEncontrado.findByLeve", query = "SELECT a FROM temp_errorEncontrado a WHERE a.leve = :leve"),
    @NamedQuery(name = "temp_errorEncontrado.findByTotal", query = "SELECT a FROM temp_errorEncontrado a WHERE a.total = :total")})
public class temp_errorEncontrado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "grave")
    private Integer grave;
    @Column(name = "mediano")
    private Integer mediano;
    @Column(name = "leve")
    private Integer leve;
    @Column(name = "total")
    private Integer total;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    public temp_errorEncontrado() {
    }
    public temp_errorEncontrado(String usuario) {
        this.usuario = usuario;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public Integer getGrave() {
        return grave;
    }
    public void setGrave(Integer grave) {
        this.grave= grave;
    }
    public Integer getMediano() {
        return mediano;
    }
    public void setMediano(Integer mediano) {
        this.mediano= mediano;
    }
    public Integer getLeve() {
        return leve;
    }
    public void setLeve(Integer leve) {
        this.leve = leve;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
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
        if (!(object instanceof temp_errorEncontrado)) {
            return false;
        }
        temp_errorEncontrado other = (temp_errorEncontrado) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.temp_errorEncontrado[ usuario=" + usuario + " ]";
    }
    
}
