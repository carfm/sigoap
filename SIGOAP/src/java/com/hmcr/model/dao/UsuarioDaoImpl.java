/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmcr.model.dao;

import com.hmcr.model.clases.Usuario;
import org.hibernate.Session;
import com.hmcr.model.clases.HibernateUtil;

/**
 *
 * @author Carlos y Jose
 */
public class UsuarioDaoImpl implements UsuarioDao {

    @Override
    public Usuario findByUsuario(Usuario usuario) {
        Session session = null;
        Usuario u = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            u = (Usuario) session.createQuery("from Usuario where user='" + usuario.getUser() + "'").uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return u;
    }

    @Override
    public Usuario login(Usuario usuario) {
        Usuario model = this.findByUsuario(usuario);
        if(!model.getPassword().equals(usuario.getPassword())){
            model= null;
        }
        return model;
    }

}
