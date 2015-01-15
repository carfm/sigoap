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
import org.hibernate.Transaction;
import sv.com.hmcr.dominio.Usuario;
import sv.com.hmcr.util.HibernateUtil;
import sv.com.hmcr.util.MyUtil;

public class UsuarioDAO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    

    public boolean guarda(Usuario usuario) {
        //HibernateUtil.buildSessionFactory();
        try {
            //SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session sesion = HibernateUtil.getSessionFactory().openSession();
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
            //SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session sesion = HibernateUtil.getSessionFactory().openSession();
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
            //SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session sesion = HibernateUtil.getSessionFactory().openSession();
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

    public Usuario obtenerUsuario(String user)  {
        //HibernateUtil.buildSessionFactory();
        Usuario usuario;
        try {           
            //HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            usuario = (Usuario) session.get(Usuario.class, user);
            //session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            System.out.println(e);
            return null;
        } 
        finally {
           // HibernateUtil.closeSessionAndUnbindFromThread();
        }
        return usuario;

    }

    public List<Usuario> obtenListaUsuarios() throws HibernateException {
        //HibernateUtil.buildSessionFactory();
        List<Usuario> listaUsuarios;
        try {           
            //HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            listaUsuarios = (List<Usuario>) session.createQuery("from Usuario").list();
            session.close();
        } finally {
            //HibernateUtil.closeSessionAndUnbindFromThread();
        }
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
