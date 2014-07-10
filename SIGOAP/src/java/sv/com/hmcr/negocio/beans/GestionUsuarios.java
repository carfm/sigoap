/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.negocio.beans;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sv.com.hmcr.dao.UsuarioDAO;
import sv.com.hmcr.dominio.Tipousuario;
import sv.com.hmcr.dominio.Usuario;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Luis
 */
@ManagedBean
@ViewScoped
public class GestionUsuarios implements Serializable{
    private static final long serialVersionUID = 1L;

    private Usuario usuario;
    private UsuarioDAO dao;
    private List<Usuario> listaUsuarios;
    private String idTipoUsuario;

    public GestionUsuarios() {
        this.dao=new UsuarioDAO();
        this.usuario=new Usuario();
        usuario.setBloqueado((short)0);
        listaUsuarios=dao.obtenListaUsuarios();
    }
    
    public void agregarUsuario(){
        Tipousuario tipo=new Tipousuario();        
        switch (idTipoUsuario){
            case "administrador":
                tipo.setIdtipousuario(3);
                break;
            case "gerente":
                tipo.setIdtipousuario(2);
                break;
            case "supervisor":
                tipo.setIdtipousuario(1);
                break;
        }
        usuario.setIdtipousuario(tipo);
        if(dao.guarda(usuario)){
            FacesMessage msg = new FacesMessage("Registro Exitoso", "Se ha creado el usuario "
                    +usuario.getNombreusuario()+" "+usuario.getApellidousuario());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        else{
            FacesMessage msg = new FacesMessage("Error", "Hubo un problema al crear el usuario "
                    +usuario.getNombreusuario()+" "+usuario.getApellidousuario());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public void onRowEdit(RowEditEvent event) {
        usuario=(Usuario) event.getObject();
        
        switch (usuario.getIdtipousuario().getIdtipousuario()){
            case 3:
                usuario.getIdtipousuario().setNombretipousuario("Administrador");
                break;
            case 2:
                usuario.getIdtipousuario().setNombretipousuario("Gerente");
                break;
            case 1:
                usuario.getIdtipousuario().setNombretipousuario("Supervisor");
                break;
        }        
        if(dao.actualizar(usuario)){
            FacesMessage msg = new FacesMessage("Actualizado correctamente","Se ha modificado el usuario "
                    +((Usuario) event.getObject()).getNombreusuario()+" "+usuario.getApellidousuario());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        else{
            FacesMessage msg = new FacesMessage("Error","Hubo un problema al modificar el usuario");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((Usuario) event.getObject()).getUser());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void borrarUsuario() {
        FacesMessage msg1 = new FacesMessage("usuario seteado:",usuario.getUser());
            FacesContext.getCurrentInstance().addMessage(null, msg1);
        if(dao.eliminar(usuario)){
        FacesMessage msg=new FacesMessage("Usuario Eliminado",
                    "Se ha eliminado el usuario "+usuario.getNombreusuario()+" "+usuario.getApellidousuario());
        FacesContext.getCurrentInstance().addMessage(null,msg);
        listaUsuarios.remove(usuario);
        usuario=null;
        }
        else{
         FacesMessage msg= new FacesMessage("Error",
                    "Hubo un error al eliminar al usuario "+usuario.getNombreusuario()+" "+usuario.getApellidousuario());
         FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        listaUsuarios.remove(usuario);
        usuario = null;
    }

    

    public void setIdTipoUsuario(String idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setDao(UsuarioDAO dao) {
        this.dao = dao;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    public String getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public UsuarioDAO getDao() {
        return dao;
    }

    public List<Usuario> getListaUsuarios() {
        
        return listaUsuarios;
    }     
    
}
