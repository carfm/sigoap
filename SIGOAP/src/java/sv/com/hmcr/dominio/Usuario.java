/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.hmcr.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUser", query = "SELECT u FROM Usuario u WHERE u.user = :user"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password"),
    @NamedQuery(name = "Usuario.findByNombreusuario", query = "SELECT u FROM Usuario u WHERE u.nombreusuario = :nombreusuario"),
    @NamedQuery(name = "Usuario.findByApellidousuario", query = "SELECT u FROM Usuario u WHERE u.apellidousuario = :apellidousuario"),
    @NamedQuery(name = "Usuario.findByBloqueado", query = "SELECT u FROM Usuario u WHERE u.bloqueado = :bloqueado")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "USER")
    private String user;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBREUSUARIO")
    private String nombreusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "APELLIDOUSUARIO")
    private String apellidousuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLOQUEADO")
    private short bloqueado;
    @Column(name = "PRIMERAVEZ  ")
    private short primeravez;
    @OneToMany(mappedBy = "user")
    private List<Empleado> empleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Genera> generaList;
    @JoinColumn(name = "IDTIPOUSUARIO", referencedColumnName = "IDTIPOUSUARIO")
    @ManyToOne
    private Tipousuario idtipousuario;

    public Usuario() {
    }

    public Usuario(String user) {
        this.user = user;
    }

    public Usuario(String user, String password, String nombreusuario, String apellidousuario, short bloqueado) {
        this.user = user;
        this.password = password;
        this.nombreusuario = nombreusuario;
        this.apellidousuario = apellidousuario;
        this.bloqueado = bloqueado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getApellidousuario() {
        return apellidousuario;
    }

    public void setApellidousuario(String apellidousuario) {
        this.apellidousuario = apellidousuario;
    }

    public short getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(short bloqueado) {
        this.bloqueado = bloqueado;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @XmlTransient
    public List<Genera> getGeneraList() {
        return generaList;
    }

    public void setGeneraList(List<Genera> generaList) {
        this.generaList = generaList;
    }

    public Tipousuario getIdtipousuario() {
        return idtipousuario;
    }

    public void setIdtipousuario(Tipousuario idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (user != null ? user.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.user == null && other.user != null) || (this.user != null && !this.user.equals(other.user))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.Usuario[ user=" + user + " ]";
    }

    /**
     * @return the primeravez
     */
    public short getPrimeravez() {
        return primeravez;
    }

    /**
     * @param primeravez the primeravez to set
     */
    public void setPrimeravez(short primeravez) {
        this.primeravez = primeravez;
    }
    
}
