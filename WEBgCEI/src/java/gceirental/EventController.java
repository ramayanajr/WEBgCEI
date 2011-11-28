/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gceirental;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author reisneto
 */
@ManagedBean
@SessionScoped
public class EventController {
    DataModel allEvents;
    EventHelper helper;

    /** Creates a new instance of EventController */
    public EventController() {
        helper = new EventHelper();
    }
    
    public DataModel getAllEvents() {
    if (allEvents == null) {
        allEvents = new ListDataModel(helper.getAllEvents());
    }
    return allEvents;
}
}
