/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil implements java.io.Serializable {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static ServiceRegistry getServiceRegistry() {
        return serviceRegistry;
    }

    private static SessionFactory buildSessionFactory() {
        try {
            // Supply name of the configuration file to achieve dynamic configuration.
            Configuration configuration = new Configuration().configure();

            // Somehow the following lines will generate deprecate warning.
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null || sessionFactory.isClosed()) {
            buildSessionFactory();
        }
        return sessionFactory;
    }
}
