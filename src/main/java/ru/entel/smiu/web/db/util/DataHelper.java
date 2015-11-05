package ru.entel.smiu.web.db.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.entel.smiu.web.db.entity.DeviceBlank;

import java.util.List;

/**
 * Created by farades on 05.11.15.
 */
public class DataHelper {
    private SessionFactory sessionFactory = null;
    private static DataHelper dataHelper;

    private DataHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public static synchronized DataHelper getInstance() {
        if (dataHelper == null){
            dataHelper = new DataHelper();
        }
        return dataHelper;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<DeviceBlank> getAllDeviceBlanks() {
//        Session session = getSession();
//        Transaction tx = session.beginTransaction();
        List<DeviceBlank> res = getSession().createCriteria(DeviceBlank.class).list();
//        tx.commit();
        return res;
    }
}
