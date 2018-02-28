package com.glitched.Karatewebprofile.actions;

import com.glitched.Karatewebprofile.models.Post;
import com.glitched.Karatewebprofile.models.KarateService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class HomeAction extends ActionSupport implements SessionAware{
    private Map<String, Object> sessionMap;
    private List<Post> posts;

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
    public String execute() {
        KarateService service = new KarateService();
        if (sessionMap.containsKey("username")) {
            setPosts(service.findLastest());
            return SUCCESS;
        }
        return ERROR;
    }
}
