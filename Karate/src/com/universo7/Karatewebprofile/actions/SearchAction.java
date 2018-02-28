package com.universo7.Karatewebprofile.actions;

import com.universo7.Karatewebprofile.models.Post;
import com.universo7.Karatewebprofile.models.KarateService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class SearchAction extends ActionSupport implements ModelDriven<Post>,SessionAware {
    private Map<String, Object> sessionMap;
    private Post post= new Post();
    private List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public Post getModel()
    {
        return post;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public String execute() throws Exception {
        KarateService service = new KarateService();
        if (sessionMap.containsKey("username")) {
            String title = post.getTitle();
            setPosts(service.showSearch(title));
            return SUCCESS;
        } else return ERROR;
    }

}
