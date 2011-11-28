/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author reisneto
 */
public class Evento2 implements Serializable { //Serialição do nosso objeto, é utilizado quando recuperamos um dados, será útil mas a frente que tivermos outras classes envolvidas.
    
   // @Id //Define que a variavel abaixo será nosso ID no banco
    private int eventid;
    private String presentation;
    private String objective;
    private String title;
    private String history;
    private String area;
    private String deadline;
    private String date;
    private String organization;
    private String partners;

    /**
     * @return the eventid
     */
    public int getEventid() {
        return eventid;
    }

    /**
     * @param eventid the eventid to set
     */
    public void setEventid(int eventid) {
        this.eventid = eventid;
    }
    

    /**
     * @return the presentation
     */
    public String getPresentation() {
        return presentation;
    }

    /**
     * @param presentation the presentation to set
     */
    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    /**
     * @return the objective
     */
    public String getObjective() {
        return objective;
    }

    /**
     * @param objective the objective to set
     */
    public void setObjective(String objective) {
        this.objective = objective;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the history
     */
    public String getHistory() {
        return history;
    }

    /**
     * @param history the history to set
     */
    public void setHistory(String history) {
        this.history = history;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the deadline
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * @param deadline the deadline to set
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the organization
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * @param organization the organization to set
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * @return the partners
     */
    public String getPartners() {
        return partners;
    }

    /**
     * @param partners the partners to set
     */
    public void setPartners(String partners) {
        this.partners = partners;
    }


    
}
