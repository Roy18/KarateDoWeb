package com.universo7.Karatewebprofile.beans;


import com.universo7.Karatewebprofile.models.Post;
import com.universo7.Karatewebprofile.models.KarateService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class PostBean extends ActionSupport implements ModelDriven<Post>,SessionAware {
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
    public String execute() throws Exception
    {
        KarateService service=new KarateService();
        if (sessionMap.containsKey("username")) {
            String url=post.getUrl();
            if(url.contains("=")){
                String temp="";
                int cont=-1;
                for(int i=0;i<url.length();i++) {
                    if(cont>=0 && cont<11) {
                        temp+=url.charAt(i);
                        cont++;
                    }
                    if(url.charAt(i)=='=') {
                        cont=0;
                    }
                }
                url=String.format("https://www.youtube.com/embed/%s",temp);
                post.setUrl(url);
            }
            post.setUser(service.findUserById((int)sessionMap.get("id")));
            LocalDate localDate=LocalDate.now();
            post.setDate(localDate.toString());
            if(service.createPost(post)) {
                setPosts(service.findLastest());
                return SUCCESS;
            } else return ERROR;
        } else return ERROR;
    }

}
