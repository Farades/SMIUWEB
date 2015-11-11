package ru.entel.smiu.datadealer.engine;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.entel.smiu.datadealer.protocols.registers.AbstractRegister;
import ru.entel.smiu.datadealer.protocols.service.ProtocolMaster;
import ru.entel.smiu.datadealer.protocols.service.ProtocolSlave;
import ru.entel.smiu.web.db.entity.Tag;
import ru.entel.smiu.web.db.util.DataHelper;

import java.util.Date;
import java.util.Map;
import java.util.TimerTask;

/**
 * Created by farades on 08.11.15.
 */
public class DataSaver extends TimerTask {
    private static final Logger logger = Logger.getLogger(DataSaver.class);

    private Map<String, ProtocolMaster> protocolMasterMap;


    public DataSaver(Map<String, ProtocolMaster> protocolMasterMap) {
        this.protocolMasterMap = protocolMasterMap;
    }

    @Override
    public synchronized void run() {
        Date start = new Date();

        Session session = DataHelper.getInstance().getSession();
        Transaction tx = session.beginTransaction();

        int count = 0;
        try {
            for (ProtocolMaster protocolMaster : protocolMasterMap.values()) {
                for (ProtocolSlave protocolSlave : protocolMaster.getSlaves().values()) {
                    count++;

                    Tag tag = new Tag();
                    tag.setTagTime(new Date());
                    tag.setDevice(protocolSlave.getDevice());
                    tag.setTagBlank(protocolSlave.getTagBlank());
                    tag.setValue(protocolSlave.getData().toString());

                    session.save(tag);
                    if (count % 20 == 0 ) { //20, same as the JDBC batch size
                        //flush a batch of inserts and release memory:
                        session.flush();
                        session.clear();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session!= null && session.isOpen()) {
                tx.commit();
                session.close();
            }
        }

        long ellapsedTime = new Date().getTime() - start.getTime();
        logger.debug("Save all channel to database. Ellapsed Time: " + ellapsedTime + " ms.");
    }

}
