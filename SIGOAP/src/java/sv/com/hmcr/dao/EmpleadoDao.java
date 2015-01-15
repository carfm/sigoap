package sv.com.hmcr.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import sv.com.hmcr.dominio.Empleado;
import sv.com.hmcr.util.HibernateUtil;

public class EmpleadoDao implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    
    public Empleado obtenerEmpleado(String idemp) throws HibernateException {
        Empleado empleado;
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        empleado = (Empleado) session.get(Empleado.class, idemp);
        session.close();
        return empleado;

    }
    
    public List<Empleado> obtenListaEmpleado() throws HibernateException {
        List<Empleado> listaEmpleado;
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        listaEmpleado = (List<Empleado>) session.createQuery("from Empleado order by nombreempleado").list();
        session.close();
        return listaEmpleado;
    }    
}
