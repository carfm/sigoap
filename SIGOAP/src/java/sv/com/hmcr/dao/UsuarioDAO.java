/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.hmcr.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.com.hmcr.dominio.Usuario;
import sv.com.hmcr.util.HibernateUtil;


public class UsuarioDAO implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    private Session sesion;
    private SessionFactory sessionFactory;
    private Transaction tx;
    private HibernateUtil hibernateUtil = new HibernateUtil();

    public boolean guarda(Usuario usuario) {
        try {
            SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
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
            SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
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
            SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
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
        session = hibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        usuario = (Usuario) session.get(Usuario.class, user);
        session.close();
        return usuario;

    }

    public List<Usuario> obtenListaUsuarios() throws HibernateException {
        List<Usuario> listaUsuarios;
        Session session = null;
        session = hibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        listaUsuarios = (List<Usuario>) session.createQuery("from Usuario").list();
        session.close();
        return listaUsuarios;
    }

    public Usuario login(Usuario usuario) {
        Usuario model = this.obtenerUsuario(usuario.getUser());
        if (!model.getPassword().equals(usuario.getPassword())) {
            model = null;
        }
        return model;
    }
}
