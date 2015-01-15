/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (HibernateException he) {
            System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

//    private static SessionFactory sessionFactory;
//
//    public static synchronized void buildSessionFactory() {
//        try {
//            if (sessionFactory == null) {
//                Configuration configuration = new Configuration();
//                configuration.configure();
//                configuration.setProperty("hibernate.current_session_context_class", "thread");
//                ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            }
//        } catch (Exception e) {
//            System.out.println("ERRORES DE CONEXION");
//        }
//
//    }
//
//    public static void openSessionAndBindToThread() {
//        Session session = sessionFactory.openSession();
//        ThreadLocalSessionContext.bind(session);
//    }
//
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            buildSessionFactory();
//        }
//        return sessionFactory;
//    }
//
//    public static void closeSessionAndUnbindFromThread() {
//        Session session = ThreadLocalSessionContext.unbind(sessionFactory);
//        if (session.isConnected()) {
//            session.close();
//        }
//    }
//
//    public static void closeSessionFactory() {
//        if ((sessionFactory != null) && (sessionFactory.isClosed() == false)) {
//            sessionFactory.close();
//        }
//    }
//    private static SessionFactory sessionFactory;
//    private static ServiceRegistry serviceRegistry;
//
//    public static ServiceRegistry getServiceRegistry() {
//        return serviceRegistry;
//    }
//
//    private static SessionFactory buildSessionFactory() {
//        try {
//            // Supply name of the configuration file to achieve dynamic configuration.
//            Configuration configuration = new Configuration().configure();
//
//            // Somehow the following lines will generate deprecate warning.
//            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            return sessionFactory;
//        } catch (Throwable ex) {
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null || sessionFactory.isClosed()) {
//            buildSessionFactory();
//        }
//        return sessionFactory;
//    }
//    
//    public static void closeSessionFactory() {
//        if ((sessionFactory != null) && (sessionFactory.isClosed() == false)) {
//            sessionFactory.close();
//        }
//    }
}
