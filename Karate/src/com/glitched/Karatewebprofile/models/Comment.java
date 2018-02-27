package com.glitched.Karatewebprofile.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Comment {
    int id;
    String description;
    String date;
    Post post;
    User user;

    public Comment(int id, String description, String date, Post post, User user) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.post = post;
        this.user = user;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static Comment from (ResultSet rs, PostsEntity postsEntity, UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        Comment comment=new Comment();
        try {
            comment.setPost(postsEntity.findById(rs.getInt("post_id"),usersEntity,userTypesEntity));
            comment.setId(rs.getInt("id"));
            comment.setDescription(rs.getString("description"));
            comment.setDate(rs.getString("date"));
            comment.setUser(usersEntity.findById(rs.getInt("user_id"),userTypesEntity));
            return comment;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
