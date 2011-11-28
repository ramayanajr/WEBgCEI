/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Database;
import controller.Sessao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramayana Júnior
 */
public class Evento implements Cloneable{
    int ID;
    String presentation, objective, title, history, area, deadline, date, organization, partners;

    public String getImportant_dates() {
        return important_dates;
    }

    public void setImportant_dates(String important_dates) {
        this.important_dates = important_dates;
    }
    String important_dates;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Evento() {
    }
    
    
    public Evento(int ID, String presentation, String objective, String title, 
            String history, String area, String deadline, String date, 
            String organization, String partners, String important_dates) {
        this.ID = ID;
        this.presentation = presentation;
        this.objective = objective;
        this.title = title;
        this.history = history;
        this.area = area;
        this.deadline = deadline;
        this.date = date;
        this.organization = organization;
        this.partners = partners;
        this.important_dates = important_dates;
    }

    @Override
    public String toString() {
        return "Evento{" + "ID=" + ID + ", presentation=" + presentation + ", objective=" + objective + ", title=" + title + ", history=" + history + ", area=" + area + ", deadline=" + deadline + ", date=" + date + ", organization=" + organization + ", partners=" + partners + ", important_dates=" + important_dates + '}';
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPartners() {
        return partners;
    }

    public void setPartners(String partners) {
        this.partners = partners;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static void Ins_title(String t){
        String sql = null;

        sql = "INSERT INTO `gcei`.`event` (`eventid`, `userid`, `title`) VALUES (NULL,"
                +Sessao.getInstance().getID()+" ,'"+t+"')" ;

        controller.Database db = new Database();
        if( db.connect()) {
            db.QueryObject(sql);
        }
        db.desconnect();
    }

    public static void InsertEvent(Evento ev){
        String sql = null;

        sql = "INSERT INTO `gcei`.`event` (`eventid`, `userid`, `title`, `presentation`, "
                + "`history`, `objective`, `themes`, `deadline`, `important_dates`,"
                + " `schedule`, `organization`, `partners`) VALUES (NULL, '"
                + Sessao.getInstance().getID()+"' '"+ ev.getTitle()+"', '"+ ev.getPresentation()
                + "', '"+ev.getHistory()+"', '"+ev.getObjective()+"', '"+ ev.getArea()
                + "', '"+ev.getDeadline()+"', '"+ev.getImportant_dates()+"', '"
                + ev.getDate()+"', '"+ev.getOrganization()+"', '"+ ev.getPartners()+"' )" ;

        controller.Database db = new Database();
        if( db.connect()) {
            db.QueryObject(sql);
        }
        db.desconnect();
    }

    public static Evento[] SelectEvents(){
        controller.Database db = new Database();
        Evento ret[] = new Evento[1000];
        if( db.connect()) {
            ResultSet rs = null;                        
            try{    
                rs = db.query_res("SELECT * FROM event");
                int c=0;               
                while( rs.next() )
                {  
                   Evento e = new Evento( rs.getInt("eventid"), 
                          rs.getString("presentation"), rs.getString("objective"),
                          rs.getString("title"), rs.getString("history"), 
                          rs.getString("themes"), rs.getString("deadline"), 
                          rs.getString("schedule"), rs.getString("organization"), 
                          rs.getString("partners"), rs.getString("important_dates") ); 
                  try{
                    ret[c] = (Evento) e.clone();
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
    
    public static void AlterEvent(Evento ev, int jtext_eventid){
        String sql = null;

        sql = "UPDATE `gcei`.`event` SET `eventid`="+ ev.getID()+", `title`='"+ ev.getTitle()+"',"
                + " `presentation`='"+ ev.getPresentation()+"',`history`='"+ev.getHistory()+"',"
                + " `objective`='"+ev.getObjective()+"', `themes`='"+ ev.getArea()+"', `deadline`='"+ev.getDeadline()+"',"
                + " `important_dates`='"+ev.getImportant_dates()+"', `schedule`='"+ ev.getDate()+"', `organization`='"+ev.getOrganization()+"',"
                + " `partners`='"+ ev.getPartners()+"' WHERE `eventid`='"+ jtext_eventid+"'";                

        controller.Database db = new Database();
        if( db.connect()) {
            db.QueryObject(sql);
        }
        db.desconnect();
    }
    
    public static void DeleteEvent(int jtext_eventid){
        String sql = null;

        sql = "DELETE FROM `gcei`.`event` WHERE `eventid`='"+ jtext_eventid+"'";                

        controller.Database db = new Database();
        if( db.connect()) {
            db.QueryObject(sql);
        }
        db.desconnect();
    }
    
        public static String getUserEvent(int userid,String category,String title){       
        String result = null;
        controller.Database db = new Database();
        if(db.connect()){
            ResultSet rs = null;
            String sql = "SELECT "+category+" FROM event WHERE userid="+userid+
                 " and title='"+title+"'";
            rs = db.query_res(sql);
            try {
                while(rs.next()){
                  result = rs.getString(1);                  
                }
            } catch (SQLException ex) {
                Logger.getLogger(Evento.class.getName()).log(Level.SEVERE, null, ex);
               }           
           }
          return result;
        }

        public static String getUserEvent(int userid,String category,int id_new_event){
        String result = null;
        controller.Database db = new Database();
        if(db.connect()){
            ResultSet rs = null;
            String sql = "SELECT "+category+" FROM event WHERE userid="+userid+
                 " and title='"+id_new_event+"'";
            rs = db.query_res(sql);
            try {
                while(rs.next()){
                  result = rs.getString(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Evento.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
          return result;
        }
        
        public static List getTitleEvent(int userid){            
            controller.Database db = new Database();
            List<String> titles = new ArrayList<String>();
            if(db.connect()){
                ResultSet rs = null;
                String sql = "SELECT title FROM event WHERE userid='"+userid+"'";
                rs = db.query_res(sql);
            try {
                while(rs.next()){
                    titles.add(rs.getString(1));                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Evento.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
            return titles;
        }
        
        public static void alterReg(String title,String column,String text){
            controller.Database db = new Database();
            if(db.connect()){                            
                String sql = "UPDATE event SET "+column+"='"+text+"' where title='"+title+"'";
                  db.QueryObject(sql);                                    
            }
        }
        
         public static void alterReg(String title,String column,String text,boolean msg){
            controller.Database db = new Database();
            if(db.connect()){                            
                String sql = "UPDATE event SET "+column+"='"+text+"' where title='"+title+"'";
                  db.QueryObject(sql,msg);                                    
            }
        }
        
}
