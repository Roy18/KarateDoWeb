package com.universo7.Karatewebprofile.beans;

import com.universo7.Karatewebprofile.models.Post;
import com.universo7.Karatewebprofile.models.KarateService;
import com.universo7.Karatewebprofile.models.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class LoginBean extends ActionSupport implements ModelDriven<User>,SessionAware {
    private Map<String, Object> sessionMap;
    private User user= new User();
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
    public User getModel() {
        return user;
    }

    @Override
    public String execute() throws Exception {
        KarateService service = new KarateService();
        if (sessionMap.containsKey("username")) {
            setPosts(service.findLastest());
            return SUCCESS;
        }
        if (service.findUserByLogin(user.getUsername(), user.getPassword())) {
            user=service.findUserByUsername(user.getUsername());
            sessionMap.put("username", user.getUsername());
            sessionMap.put("id", user.getId());
            sessionMap.put("userType",user.getUserType().getId());
            setPosts(service.findLastest());
            return SUCCESS;
        }
        else return INPUT;
    }
}
