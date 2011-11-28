/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gceirental;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author reisneto
 */
public class EventHelper {
    Session session = null;

    public EventHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List getAllEvents(){
        List<Event> eventList = null;
        
        try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from Event as event");
        eventList = (List<Event>) q.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
        return eventList;
    }
}
