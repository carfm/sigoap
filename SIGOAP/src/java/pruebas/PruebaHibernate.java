/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import com.hmcr.model.clases.HibernateUtil;
import com.hmcr.model.clases.Tipousuario;
import com.hmcr.model.clases.Usuario;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Carlos y Jose
 */
public class PruebaHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Usuario u = (Usuario)session.createQuery("from Usuario where user='cfuentes'").uniqueResult();
        session.close();

            System.out.println(u.getNombreusuario());

    }
    
}
