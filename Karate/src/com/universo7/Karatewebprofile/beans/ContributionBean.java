package com.universo7.Karatewebprofile.beans;

import com.universo7.Karatewebprofile.models.Event;
import com.universo7.Karatewebprofile.models.Post;
import com.universo7.Karatewebprofile.models.KarateService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class ContributionBean extends ActionSupport implements SessionAware {
    private  Post post = new Post();
    private Map<String, Object> sessionMap;
    private List<Post> posts;
    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }


    @Override
    public String execute() throws Exception {
        KarateService service = new KarateService();
        if (sessionMap.containsKey("username")) {
            if((int)sessionMap.get("id")==1) {
                setPosts(service.findByUser((int)sessionMap.get("id")));
                setEvents(service.findEventByUser((int)sessionMap.get("id")));
            }

            return SUCCESS;
        } else return ERROR;
    }

}