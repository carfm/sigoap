/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.negocio.beans;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import sv.com.hmcr.dominio.Usuario;
import sv.com.hmcr.dao.UsuarioDAO;
import sv.com.hmcr.util.MyUtil;

/**
 *
 * @author Carlos y Jose
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private Usuario usuario;
    private UsuarioDAO usuarioDao;
    private int numero;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        this.usuarioDao = new UsuarioDAO();
        if (this.usuario == null) {
            this.usuario = new Usuario();
        }
    }

    public void login(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        FacesMessage msg;
        boolean LoggedIn;
        this.usuario = this.getUsuarioDao().login(this.getUsuario());
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", this.usuario);
        String ruta = "";
        if (this.usuario != null) {
            switch (this.usuario.getIdtipousuario().getIdtipousuario()) {
                    case 1:
                        ruta = MyUtil.loginUrl() + "views/supervisor/menu_supervisor.xhtml";
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("opciones", "opciones_supervisor.xhtml");
                        break;
                    case 2:
                        ruta = MyUtil.loginUrl() + "views/gerente/menu_gerente.xhtml";
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("opciones", "opciones_gerente.xhtml");
                        break;
                    case 3:
                        ruta = MyUtil.loginUrl() + "views/admin/menu_admin.xhtml";
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("opciones", "opciones_admin.xhtml");
                        break;
                }
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getNombreusuario());
            LoggedIn = true;
            if (this.usuario.getPrimeravez() == 1) {
                //ingreso a pagina de actualizar contraseña 
                ruta = MyUtil.loginUrl() + "primer_ingreso.xhtml";
            }
        } else {

            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Usuario o contraseña invalido(s)");

            //int n = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numeroIncorrecto").toString());
            //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numeroIncorrecto",1);
            LoggedIn = false;
            if (this.usuario == null) {
                this.usuario = new Usuario();
                try {
                    int n = numero;
                    n = n++;
                    //Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numeroIncorrecto").toString());
                    //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numeroIncorrecto", Integer.toString(n + 1));
                    if ((n + 1) > 4) {
                        ruta = MyUtil.loginUrl() + "error.xhtml";
                        context = RequestContext.getCurrentInstance();
                        FacesContext facesContext = FacesContext.getCurrentInstance();
                        HttpSession sesion = (HttpSession) facesContext.getExternalContext().getSession(false);
                        starTimer(sesion);
                    } else {
                        //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numeroIncorrecto").toString()
                    }
                    numero = n;
//                    if ((n + 1) == 5) {
//                        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//                        starTimer(sesion);                       
//                    }
                    //context.addCallbackParam("num", n + 1);
                } catch (Exception e) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numeroIncorrecto", "0");
                }
                System.out.println(numero);
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", LoggedIn);
        context.addCallbackParam("ruta", ruta);

    }

    protected void starTimer(final HttpSession sesion) {
        //Tarea que se lanzará cuando el Timer la ejecute
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                sesion.invalidate();
            }
        };

        Timer timer = new Timer();
        //El tiempo esta en milisegundos y se lanza la tarea que definimos anteriormente 10 seg
        timer.schedule(timerTask, 10000);
    }

    public String logout() {
        try {
            String ruta = MyUtil.baseurl() + "index.xhtml";
            RequestContext context = RequestContext.getCurrentInstance();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession sesion = (HttpSession) facesContext.getExternalContext().getSession(false);
            sesion.invalidate();
            this.usuario = null;
            context.addCallbackParam("loggetOut", true);
            context.addCallbackParam("ruta", ruta);
        } catch (Exception e) {
            System.out.println(e);
            try {
                FacesContext contex = FacesContext.getCurrentInstance();
                contex.getExternalContext().redirect("index.xhtml");
            } catch (Exception ex) {
                System.out.println(e);
            }
        }
        return "index?faces-redirect=true";
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
    public UsuarioDAO getUsuarioDao() {
        return usuarioDao;
    }

    /**
     * @param usuarioDao the usuarioDao to set
     */
    public void setUsuarioDao(UsuarioDAO usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
}
