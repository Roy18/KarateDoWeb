package com.glitched.Karatewebprofile.actions;

import com.glitched.Karatewebprofile.models.Comment;
import com.glitched.Karatewebprofile.models.Post;
import com.glitched.Karatewebprofile.models.KarateService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class NewCommentAction extends ActionSupport implements ModelDriven<Post>,SessionAware{
    private Map<String, Object> sessionMap;
    Post post;
    int postId;
    String description;
    private List<Comment> comments;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public Post getModel() {
        return post;
    }

    @Override
    public String execute() {
        KarateService service=new KarateService();
        if(sessionMap.containsKey("username")) {
            LocalDate localDate=LocalDate.now();
            if(service.createComment(postId,description,localDate.toString(),(int)sessionMap.get("id"))) {
                post=service.findPostById(postId);
                setComments(service.findCommentByPost(postId));
                return SUCCESS;
            }
        }
        return ERROR;
    }
}
