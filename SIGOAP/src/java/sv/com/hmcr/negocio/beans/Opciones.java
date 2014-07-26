/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.negocio.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sv.com.hmcr.dominio.Usuario;

/**
 *
 * @author Carlos y Jose
 */
@ManagedBean(name = "Opciones")
@SessionScoped
public class Opciones {

    /**
     * Creates a new instance of Opciones
     */
    private String nombreMenu;
    private Usuario usuario;

    public Opciones() {
        try {
            nombreMenu = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("opciones").toString();
            usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
        } catch (Exception e) {

        }
    }

    /**
     * @return the nombreMenu
     */
    public String getNombreMenu() {
        return nombreMenu;
    }

    /**
     * @param nombreMenu the nombreMenu to set
     */
    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
