package com.universo7.Karatewebprofile.beans;

import com.universo7.Karatewebprofile.models.Event;
import com.universo7.Karatewebprofile.models.KarateService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class RelatedEventsBean extends ActionSupport implements SessionAware {
    private Map<String, Object> sessionMap;
    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public String execute() {
        KarateService service=new KarateService();
        if(sessionMap.containsKey("username")) {
            setEvents(service.findEventByPostulant((int)sessionMap.get("id")));
            return SUCCESS;
        }
        return ERROR;
    }
}
