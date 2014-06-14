/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.}

kladsajjfsakflsadfk
 */


package sv.com.hmcr.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.com.hmcr.dominio.Usuario;
import sv.com.hmcr.util.HibernateUtil;
import sv.com.hmcr.util.MyUtil;

public class UsuarioDAO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    public boolean guarda(Usuario usuario) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session sesion = sessionFactory.openSession();
            Transaction tx = sesion.beginTransaction();
            sesion.save(usuario);
            tx.commit();
            sesion.flush();
            sesion.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean actualizar(Usuario usuario) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session sesion = sessionFactory.openSession();
            Transaction tx = sesion.beginTransaction();
            sesion.saveOrUpdate(usuario);
            tx.commit();
            sesion.flush();
            sesion.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean eliminar(Usuario usuario) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session sesion = sessionFactory.openSession();
            Transaction tx = sesion.beginTransaction();
            sesion.delete(usuario);
            tx.commit();
            sesion.flush();
            sesion.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Usuario obtenerUsuario(String user) throws HibernateException {
        Usuario usuario = null;
        Session session = null;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        usuario = (Usuario) session.get(Usuario.class, user);
        session.close();
        return usuario;

    }

    public List<Usuario> obtenListaUsuarios() throws HibernateException {
        List<Usuario> listaUsuarios;
        Session session = null;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        listaUsuarios = (List<Usuario>) session.createQuery("from Usuario").list();
        session.close();
        HibernateUtil.closeSessionFactory();
        return listaUsuarios;
    }

    public Usuario login(Usuario usuario) {
        Usuario model = this.obtenerUsuario(usuario.getUser());
        String pass = usuario.getPassword();      
        if (MyUtil.generateMD5Signature(pass + usuario.getUser()).equals(model.getPassword()) == false) {
            //Contraseña incorrecta
            model = null;
        }else{
            // Contraseña correcta se limpia la contraseña
            model.setPassword("");
        } 
        return model;
    }
}
