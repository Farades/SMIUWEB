package ru.entel.smiu.web.db.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static  synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                //creates the session factory from hibernate.cfg.xml
                sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}