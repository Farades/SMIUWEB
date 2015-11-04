package ru.entel.smiu.web.entity;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.entel.smiu.web.entity.util.HibernateUtil;
import ru.entel.smiu.web.settings.service.DeviceBlank;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by farades on 04.11.15.
 */
public class DeviceBlankDAO {

    public List<DeviceBlank> getAllStudents() throws SQLException {
        Session session = null;
        List<DeviceBlank> studs = new ArrayList<DeviceBlank>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from DeviceBlankEntity"); //You will get Weayher object
            studs = query.list(); //You are accessing  as list<WeatherModel>
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return studs;
    }
}
