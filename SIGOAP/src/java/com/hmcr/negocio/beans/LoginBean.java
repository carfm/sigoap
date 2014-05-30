/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmcr.negocio.beans;

import com.hmcr.model.clases.Usuario;
import com.hmcr.model.dao.UsuarioDao;
import com.hmcr.model.dao.UsuarioDaoImpl;
import com.hmcr.util.MyUtil;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Carlos y Jose
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private Usuario usuario;
    private UsuarioDao usuarioDao;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        this.usuarioDao = new UsuarioDaoImpl();
        if (this.usuario == null) {
            this.usuario = new Usuario();
        }
    }

    public void login(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean LoggedIn;
        this.usuario = this.getUsuarioDao().login(this.getUsuario());
        String ruta = "";
        if (this.usuario != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", this.usuario.getUser());
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getNombreusuario());
            ruta = MyUtil.loginUrl() + "views/page1.xhtml";
            LoggedIn = true;
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Usuario o contraseña invalido(s)");
            LoggedIn = false;
            if (this.usuario == null) {
                this.usuario = new Usuario();
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", LoggedIn);
        context.addCallbackParam("ruta", ruta);
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

    /**
     * @return the usuarioDao
     */
    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    /**
     * @param usuarioDao the usuarioDao to set
     */
    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
}
