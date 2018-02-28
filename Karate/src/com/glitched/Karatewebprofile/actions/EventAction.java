package com.glitched.Karatewebprofile.actions;

import com.glitched.Karatewebprofile.models.Event;
import com.glitched.Karatewebprofile.models.Post;
import com.glitched.Karatewebprofile.models.KarateService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class EventAction extends ActionSupport implements ModelDriven<Event>, SessionAware {
    private Event event= new Event();
    private Map<String, Object> sessionMap;
    private List<Event> events;
    private List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {this.events= events; }

    @Override
    public Event getModel(){return event;}

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public String execute() throws Exception {
        KarateService service = new KarateService();
        if (sessionMap.containsKey("username")) {
            event.setUser(service.findUserById((int)sessionMap.get("id")));
            if(event.getPictureUrl()==null) {
                event.setPictureUrl("default.jpg");
            }
            if (service.createEvent(event)) {
                setPosts(service.findLastest());
                return SUCCESS;
            }
            else return ERROR;
        } else return ERROR;
    }
}
