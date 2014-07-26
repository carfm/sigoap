/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import sv.com.hmcr.dominio.AnalisisefTemp;
import sv.com.hmcr.dominio.ComparativonuevosTemp;
import sv.com.hmcr.dominio.EstadisticasTemp;
import sv.com.hmcr.dominio.Estandar;
import sv.com.hmcr.dominio.Temporalordenesauditadas;
import sv.com.hmcr.dominio.Temporalordenesprocesadasnuevos;
import sv.com.hmcr.dominio.Temporalrazones;
import sv.com.hmcr.dominio.Temporaltiempos;
import sv.com.hmcr.dominio.temp_errorEncontrado;
import sv.com.hmcr.dominio.temp_procesada;
import sv.com.hmcr.util.HibernateUtil;

public class TablasTempDAO implements java.io.Serializable {

    private ResultSet resultado;
    private Statement sentencia;
    private Connection conexion;
    String Conexion = "jdbc:mysql://localhost:3306/pruebadsi?user=root";
    String Driver1 = "com.mysql.jdbc.Driver";

    public List<AnalisisefTemp> obtenerAnalisisEf(int tipo) throws HibernateException {
        List<AnalisisefTemp> lista;
        Session session;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        switch (tipo) {
            case 1:
                lista = (List<AnalisisefTemp>) session.createQuery("from AnalisisefTemp a order by a.errororden desc").list();
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
                lista = (List<AnalisisefTemp>) session.createQuery("from AnalisisefTemp a order by a.errororden desc").list();
                break;
        }
        session.close();
        return lista;
    }

    public List<Temporalordenesauditadas> obtenerOrdenesAuditadas(int tipo) throws HibernateException {
        List<Temporalordenesauditadas> lista;
        Session session;
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
        Session session;
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
        Session session = null;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        switch (tipo) {
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
        session = null;
        return lista;
    }

    public List<EstadisticasTemp> obtenerEstadisticasTemp() throws HibernateException {
        List<EstadisticasTemp> lista;
        Session session = null;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        lista = (List<EstadisticasTemp>) session.createQuery("from EstadisticasTemp").list();
        session.close();
        session = null;
        return lista;
    }

    public List<Temporaltiempos> obtenerTiemposPromedios(int tipo) throws HibernateException {
        List<Temporaltiempos> lista;
        Session session;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        switch (tipo) {
            case 1:
                lista = (List<Temporaltiempos>) session.createQuery("from Temporaltiempos").list();
                break;
            case 2:
                lista = (List<Temporaltiempos>) session.createQuery(
                        "from Temporaltiempos a order by a.promedio asc").setMaxResults(3).list();
                break;
            case 3:
                lista = (List<Temporaltiempos>) session.createQuery(
                        "from Temporaltiempos a order by a.promedio desc").setMaxResults(3).list();
                break;
            default:
                lista = (List<Temporaltiempos>) session.createQuery("from Temporaltiempos").list();
                break;
        }
        session.close();
        return lista;
    }

    public List<Temporalrazones> obtenerRazones(int tipo) throws HibernateException {
        List<Temporalrazones> lista;
        Session session;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        switch (tipo) {
            case 1:
                lista = (List<Temporalrazones>) session.createQuery("from Temporalrazones").list();
                break;
            case 2:
                lista = (List<Temporalrazones>) session.createQuery(
                        "from Temporalrazones a order by a.promedio asc").setMaxResults(3).list();
                break;
            case 3:
                lista = (List<Temporalrazones>) session.createQuery(
                        "from Temporalrazones a order by a.promedio desc").setMaxResults(3).list();
                break;
            default:
                lista = (List<Temporalrazones>) session.createQuery("from Temporalrazones").list();
                break;
        }
        session.close();
        return lista;
    }

    public ResultSet obtenrLocation() {
        ResultSet lista = null;

        try {
            Class.forName(Driver1).newInstance();
            conexion = DriverManager.getConnection(Conexion);
            sentencia = conexion.createStatement();
            lista = sentencia.executeQuery("SELECT * FROM location");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 1 " + e.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error 2 " + e.getMessage());
        } catch (InstantiationException | IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Error 3 " + e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "no retorna nada ");

        return lista;
    }

    public List<temp_procesada> obtenerOrdenProcesada(int tipo) throws HibernateException {
        List<temp_procesada> lista;
        Session session;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        switch (tipo) {
            case 1:
                lista = (List<temp_procesada>) session.createQuery("from temp_procesada").list();
                break;
            case 2:
                lista = (List<temp_procesada>) session.createQuery(
                        "from temp_procesada a order by a.totalProcesadas asc").setMaxResults(5).list();
                break;
            case 3:
                lista = (List<temp_procesada>) session.createQuery(
                        "from temp_procesada a order by a.totalProcesadas desc").setMaxResults(5).list();
                break;
            default:
                lista = (List<temp_procesada>) session.createQuery("from temp_procesada").list();
                break;
        }
        session.close();
        return lista;
    }

    public List<temp_errorEncontrado> obtenerErrorEncontrado(int tipo) throws HibernateException {
        List<temp_errorEncontrado> lista;
        Session session;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        switch (tipo) {
            case 1:
                lista = (List<temp_errorEncontrado>) session.createQuery("from temp_errorEncontrado").list();
                break;
            case 2:
                lista = (List<temp_errorEncontrado>) session.createQuery(
                        "from temp_errorEncontrado a order by a.total asc").setMaxResults(5).list();
                break;
            case 3:
                lista = (List<temp_errorEncontrado>) session.createQuery(
                        "from temp_errorEncontrado a order by a.total desc").setMaxResults(5).list();
                break;
            default:
                lista = (List<temp_errorEncontrado>) session.createQuery("from temp_errorEncontrado").list();
                break;
        }
        session.close();
        return lista;
    }
    
    //--------metodos para llenar los footer de las tablas
    public int recuperarAuditadas(String fechaIni,String fechaFin) {
        int total=0;
        HibernateUtil.buildSessionFactory();
        try {           
            HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
                total = (Integer) session.createQuery("select count(*) from ProcesaAudita where tipoprocesaaudita=2 and fechaprocesaaudita between '"+fechaIni+"' AND '"+fechaFin+"'").list().get(0);
            System.out.println("total: "+total);
                session.close();
        } finally {
            HibernateUtil.closeSessionAndUnbindFromThread();
        }
        return total;

    }
    
    public int recuperarOP(String fechaIni,String fechaFin) {
        int total=0;
        HibernateUtil.buildSessionFactory();
        try {           
            HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
                total = (int) session.createQuery("select count(*) from ProcesaAudita where tipoprocesaaudita=1 fechaprocesaaudita between '"+fechaIni+"' AND '"+fechaFin+"'").list().get(0);
            System.out.println("total: "+total);
                session.close();
        } finally {
            HibernateUtil.closeSessionAndUnbindFromThread();
        }
        return total;

    }
    
    public List<Estandar> recuperarEstandar() {
        List<Estandar> total;
        HibernateUtil.buildSessionFactory();
        try {           
            HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
                total = (List<Estandar>) session.createQuery("from Estandar").list();
                session.close();
        } finally {
            HibernateUtil.closeSessionAndUnbindFromThread();
        }
        return total;

    }
    

    public Connection getConexion() {
        return conexion;
    }

    public ResultSet getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }

    /**
     * @return the sentencia
     */
    public Statement getSentencia() {
        return sentencia;
    }

    /**
     * @param sentencia the sentencia to set
     */
    public void setSentencia(Statement sentencia) {
        this.sentencia = sentencia;
    }

    /**
     * @param conexion the conexion to set
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void cerrarConexion() {
        try {
            getSentencia().close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
