package com.universo7.Karatewebprofile.actions;

import com.universo7.Karatewebprofile.models.Post;
import com.universo7.Karatewebprofile.models.KarateService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class DeleteVideoAction extends ActionSupport implements SessionAware {
    private Map<String, Object> sessionMap;
    private List<Post> posts;
    int postId;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String execute() throws Exception {
        KarateService service = new KarateService();
        if (sessionMap.containsKey("username")) {
            if (service.deleteCommentByPost(postId)) {
                if(service.deletePostById(postId)) {
                    setPosts(service.findByUser(postId));
                    return SUCCESS;
                }
            }
        }
        return ERROR;
    }
}
