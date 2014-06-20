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
import sv.com.hmcr.dominio.ComparativonuevosTemp;
import sv.com.hmcr.dominio.EstadisticasTemp;
import sv.com.hmcr.dominio.Temporalordenesauditadas;
import sv.com.hmcr.dominio.Temporalordenesprocesadasnuevos;
import sv.com.hmcr.util.HibernateUtil;

public class TablasTempDAO implements java.io.Serializable {

    

     public List<AnalisisefTemp> obtenerAnalisisEf(int tipo) throws HibernateException {
        List<AnalisisefTemp> lista;
        Session session;
        session= HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        switch (tipo){
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
            case 2:
                lista = (List<Temporalordenesauditadas>) session.createQuery(
                        "from Temporalordenesauditadas a order by a.auditadas asc").setMaxResults(3).list();
                break;
            case 3:
                lista = (List<Temporalordenesauditadas>) session.createQuery(
                        "from Temporalordenesauditadas a order by a.auditadas desc").setMaxResults(3).list();
                break;
            default:
                lista = (List<Temporalordenesauditadas>) session.createQuery("from Temporalordenesauditadas").list();
                break;
        }
        session.close();
        return lista;
    }
    
    public List<Temporalordenesprocesadasnuevos> obtenerOrdenesProcesadasNuevos(int tipo) throws HibernateException {
        List<Temporalordenesprocesadasnuevos> lista;
        Session session ;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        switch (tipo) {
            case 1:
                // todos
                lista = (List<Temporalordenesprocesadasnuevos>) session.createQuery("from Temporalordenesprocesadasnuevos").list();
                break;
            case 2:
                // 3 con mas ordenes completas
                lista = (List<Temporalordenesprocesadasnuevos>) session.createQuery(
                        "from Temporalordenesprocesadasnuevos a order by a.completas desc").setMaxResults(3).list();
                break;
            case 3:
                // 3 con menos ordenes completas
                lista = (List<Temporalordenesprocesadasnuevos>) session.createQuery(
                        "from Temporalordenesprocesadasnuevos a order by a.completas asc").setMaxResults(3).list();
                break;
            case 4:
                // 3 con mas ordenes incompletas
                lista = (List<Temporalordenesprocesadasnuevos>) session.createQuery(
                        "from Temporalordenesprocesadasnuevos a order by a.incompletas desc").setMaxResults(3).list();
                break;
            case 5:
                // 3 con menos ordenes incompletas
                lista = (List<Temporalordenesprocesadasnuevos>) session.createQuery(
                        "from Temporalordenesprocesadasnuevos a order by a.incompletas asc").setMaxResults(3).list();
                break;
            case 6:
                // 3 con mas ordenes sin hacer nada
                lista = (List<Temporalordenesprocesadasnuevos>) session.createQuery(
                        "from Temporalordenesprocesadasnuevos a order by a.nada desc").setMaxResults(3).list();
                break;
            case 7:
                // 3 con mas ordenes sin hacer nada
                lista = (List<Temporalordenesprocesadasnuevos>) session.createQuery(
                        "from Temporalordenesprocesadasnuevos a order by a.nada asc").setMaxResults(3).list();
                break;
            default:
                lista = (List<Temporalordenesprocesadasnuevos>) session.createQuery("from Temporalordenesprocesadasnuevos").list();
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
    
    public List<ComparativonuevosTemp> obtenerComparativonuevosTemp(int tipo) throws HibernateException {
        List<ComparativonuevosTemp> lista;
        Session session=null;
        session= HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        switch (tipo){
            case 1:
                lista = (List<ComparativonuevosTemp>) session.createQuery("from ComparativonuevosTemp").list();
                break;
            case 2:
                lista = (List<ComparativonuevosTemp>) session.createQuery(
                        "from ComparativonuevosTemp a order by a.diferenciaTotal asc").setMaxResults(5).list();
                break;
            case 3:
                lista = (List<ComparativonuevosTemp>) session.createQuery(
                        "from ComparativonuevosTemp a order by a.diferenciaTotal desc").setMaxResults(5).list();
                break; 
            case 4:
                lista = (List<ComparativonuevosTemp>) session.createQuery(
                        "from ComparativonuevosTemp a where a.diferenciaTotal<0").list();
                break;
            default:
                lista = (List<ComparativonuevosTemp>) session.createQuery("from ComparativonuevosTemp").list();
                break;
        }
        session.close();
        session=null;
        return lista;
    }
    
    public List<EstadisticasTemp> obtenerEstadisticasTemp() throws HibernateException {
        List<EstadisticasTemp> lista;
        Session session=null;
        session= HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
                lista = (List<EstadisticasTemp>) session.createQuery("from EstadisticasTemp").list();
        session.close();
        session=null;
        return lista;
    }

}
