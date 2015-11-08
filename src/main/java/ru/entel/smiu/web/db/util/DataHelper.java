package ru.entel.smiu.web.db.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import ru.entel.smiu.web.db.entity.DeviceBlank;
import ru.entel.smiu.web.db.entity.Properties;
import ru.entel.smiu.web.db.entity.Protocol;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {
    private SessionFactory sessionFactory = null;
    private static DataHelper dataHelper;

    private DataHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public static synchronized DataHelper getInstance() {
        if (dataHelper == null) {
            dataHelper = new DataHelper();
        }
        return dataHelper;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Возвращает все шаблоны устройств, находящиеся в БД
     * @return List Шаблонов устройств
     */
    public List<DeviceBlank> getAllDeviceBlanks() {
        return getSession().createCriteria(DeviceBlank.class).list();
    }

    public List<Protocol> getAllProtocols() {
        Session session = sessionFactory.openSession();
        List<Protocol> res = new ArrayList<>(0);
        try {
            res = session.createCriteria(Protocol.class).list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session!= null && session.isOpen()) {
                session.close();
            }
        }
        return res;
    }

    public String getProperty(String prop) {
        Session session = sessionFactory.openSession();
        String res = "";
        try {
            Properties property = (Properties)session.createCriteria(Properties.class).add(Restrictions.ilike("name", prop)).list().get(0);
            res = property.getValue();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session!= null && session.isOpen()) {
                session.close();
            }
        }
        return res;
    }
}
