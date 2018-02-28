package com.glitched.Karatewebprofile.actions;

import com.glitched.Karatewebprofile.models.Event;
import com.glitched.Karatewebprofile.models.Postulant;
import com.glitched.Karatewebprofile.models.KarateService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class showPostulantsAction extends ActionSupport implements ModelDriven<Event>,SessionAware {
    private Map<String, Object> sessionMap;
    private List<Postulant> postulants;
    private Event event;
    int eventId;

    public List<Postulant> getPostulants() {
        return postulants;
    }

    public void setPostulants(List<Postulant> postulants) {
        this.postulants = postulants;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public Event getModel() {
        return event;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public String execute(){
        KarateService service=new KarateService();
        if(sessionMap.containsKey("username")) {
            event=service.findEventById(eventId);
            setPostulants(service.findPostulantByEvent(eventId));
            return SUCCESS;
        }
        return ERROR;
    }
}
