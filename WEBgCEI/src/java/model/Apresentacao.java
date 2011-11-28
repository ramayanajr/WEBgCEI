/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramayana Júnior
 */
public class Apresentacao implements Cloneable{
    int ID, eventid;
    String title, subtitle, description, date, hour, speaker;

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Apresentacao(int ID, int eventid, String title, String subtitle, String description, String date, String horario, String speaker) {
        this.ID = ID;
        this.eventid =eventid;
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.date = date;
        this.hour = horario;
        this.speaker = speaker;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    
    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }       

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }  

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Apresentacao{" + "ID=" + ID + ", eventid=" + eventid + ", title=" + title + ", subtitle=" + subtitle + ", description=" + description + ", date=" + date + ", hour=" + hour + ", speaker=" + speaker + '}';
    }
    
    public static void InsertPresentation(Apresentacao ap){
        String sql = null;

        sql = "INSERT INTO `gcei`.`presentation` (`presentationid`, `eventid`, `title`, `subtitle`,"
            + "`description`, `speaker`, `day`, `hour`) "
            + "VALUES (NULL, '"+ ap.getEventid()+"', '"+ ap.getTitle()+"', '"
            + ap.getSubtitle()+"', '"+ap.getDescription()+"', '"+ap.getSpeaker()+"', '"
            + ap.getDate()+"', '"+ap.getHour()+"' )";

        controller.Database db = new Database();
        if( db.connect()) {
            db.QueryObject(sql);
        }
        db.desconnect();
    }    
    
    public static void DeletePresentation(int jtext_presentationid){
        String sql = null;

        sql = "DELETE FROM `gcei`.`presentation` WHERE `presentationid`='"+jtext_presentationid+"'";            

        controller.Database db = new Database();
        if( db.connect()) {
            db.QueryObject(sql);
        }
        db.desconnect();
    }
    
    public static void AlterPresentation(Apresentacao ap, int jtext_presentationid){
        String sql = null;  

        sql = "UPDATE `gcei`.`presentation` SET `presentationid`="+ ap.getID()+", `eventid`="+ap.getEventid()+","
            + " `title`='"+ ap.getTitle()+"', `subtitle`='"+ ap.getSubtitle()+"',"
            + " `description`='"+ap.getDescription()+"', `speaker`='"+ap.getSpeaker()+"',"
            + " `day`='"+ ap.getDate()+"', `hour`='"+ap.getHour()+"' WHERE `presentationid`='"+jtext_presentationid+"'";                        

        controller.Database db = new Database();
        if( db.connect()) {
            db.QueryObject(sql);
        }
        db.desconnect();
    }    
    
    public static Apresentacao[] SelectPresentations(){
        controller.Database db = new Database();
        Apresentacao ret[] = new Apresentacao[1000];
        if( db.connect()) {
            ResultSet rs = null;                        
            try{    
                rs = db.query_res("SELECT * FROM presentation");
                int c=0;               
                while( rs.next() )
                {  
                  Apresentacao a = new Apresentacao( rs.getInt("presentationid"), 
                          rs.getInt("eventid"), rs.getString("title"),
                          rs.getString("subtitle"), rs.getString("description"), 
                          rs.getString("day"), rs.getString("hour"), 
                          rs.getString("speaker") ); 
                  try{
                  ret[c] = (Apresentacao) a.clone();
                  }catch(CloneNotSupportedException err){
                      err.printStackTrace();
                  }
                  ++c;
                }                  
            }catch(SQLException err){
                err.printStackTrace();
                return null;
            }
        }        
        db.desconnect();
        return ret;                    
    }    
}
