/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import sv.com.hmcr.dominio.AnalisisefTemp;
import sv.com.hmcr.dominio.Temporalordenesauditadas;
import sv.com.hmcr.util.HibernateUtil;

public class TablasTempDAO implements java.io.Serializable {

    

    public List<AnalisisefTemp> obtenerAnalisisEf(int tipo) throws HibernateException {
        List<AnalisisefTemp> lista;
        Session session ;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        switch (tipo) {
            case 1:
                lista = (List<AnalisisefTemp>) session.createQuery("from AnalisisefTemp").list();
                break;
            case 2:
                lista = (List<AnalisisefTemp>) session.createQuery(
                        "from AnalisisefTemp a order by a.errororden asc").setMaxResults(5).list();
                break;
            case 3:
                lista = (List<AnalisisefTemp>) session.createQuery(
                        "from AnalisisefTemp a order by a.errororden desc").setMaxResults(5).list();
                break;
            default:
                lista = (List<AnalisisefTemp>) session.createQuery("from AnalisisefTemp").list();
                break;
        }
        session.close();
        return lista;
    }

    public List<Temporalordenesauditadas> obtenerOrdenesAuditadas(int tipo) throws HibernateException {
        List<Temporalordenesauditadas> lista;
        Session session ;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        switch (tipo) {
            case 1:
                lista = (List<Temporalordenesauditadas>) session.createQuery("from Temporalordenesauditadas").list();
                break;
//            case 2:
//                lista = (List<Temporalordenesauditadas>) session.createQuery(
//                        "from Temporalordenesauditadas a order by a.errororden asc").setMaxResults(5).list();
//                break;
//            case 3:
//                lista = (List<Temporalordenesauditadas>) session.createQuery(
//                        "from Temporalordenesauditadas a order by a.errororden desc").setMaxResults(5).list();
//                break;
            default:
                lista = (List<Temporalordenesauditadas>) session.createQuery("from Temporalordenesauditadas").list();
                break;
        }
        session.close();
        return lista;
    }
    public void ejecutarProc(String consulta) throws HibernateException {
        Session session;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createSQLQuery(consulta);
        query.executeUpdate();
        session.getTransaction().commit();
    }

}
