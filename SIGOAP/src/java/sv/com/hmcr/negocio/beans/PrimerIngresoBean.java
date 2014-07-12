/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.negocio.beans;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import sv.com.hmcr.dao.UsuarioDAO;
import sv.com.hmcr.dominio.Usuario;
import sv.com.hmcr.util.MyUtil;

/**
 *
 * @author Carlos y Jose
 */
@ManagedBean
@RequestScoped
public class PrimerIngresoBean {

    /**
     * Creates a new instance of PrimerIngresoBean
     */
    private Usuario u;
    private UsuarioDAO uDAO;
    private String contraseña1;
    private String contraseña2;

    public PrimerIngresoBean() {
        u = new Usuario();
        uDAO = new UsuarioDAO();
    }

    public void actualizarContraseña(ActionEvent actionEvent) {
        FacesMessage msg;
        String ruta="";
        if (this.getContraseña1().equals(this.getContraseña2())) {
            u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
            u.setPassword(MyUtil.generateMD5Signature(contraseña1+u.getUser()));
            u.setPrimeravez(Short.parseShort("0"));
            if(uDAO.actualizar(u)){
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizacion", "La contraseña ha sido actualizada correctamente");
                switch (this.u.getIdtipousuario().getIdtipousuario()) {
                    case 1:
                        ruta = "views/supervisor/menu_supervisor.xhtml";
                        break;
                    case 2:
                        ruta = "views/gerente/menu_gerente.xhtml";
                        break;
                    case 3:
                        ruta = "views/admin/menu_admin.xhtml";
                        break;
                }
            }else{
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Actualizacion", "La contraseña no pudo ser actualizada");
            }
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las contraseñas no coinciden");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(ruta);
            //context.addCallbackParam("loggedIn", LoggedIn);
            //context.addCallbackParam("ruta", ruta);
        } catch (IOException ex) {
            Logger.getLogger(PrimerIngresoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the u
     */
    public Usuario getU() {
        return u;
    }

    /**
     * @param u the u to set
     */
    public void setU(Usuario u) {
        this.u = u;
    }

    /**
     * @return the contraseña1
     */
    public String getContraseña1() {
        return contraseña1;
    }

    /**
     * @param contraseña1 the contraseña1 to set
     */
    public void setContraseña1(String contraseña1) {
        this.contraseña1 = contraseña1;
    }

    /**
     * @return the contraseña2
     */
    public String getContraseña2() {
        return contraseña2;
    }

    /**
     * @param contraseña2 the contraseña2 to set
     */
    public void setContraseña2(String contraseña2) {
        this.contraseña2 = contraseña2;
    }

}
