package com.glitched.Karatewebprofile.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Post {
    private int id;
    private User user;
    private String title;
    private String date;
    private String description;
    private String url;

    public Post(int id, User user, String title, String date, String description, String url) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.date = date;

        this.description = description;
        this.url = url;
    }

    public Post() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static Post from(ResultSet rs,UsersEntity usersEntity,UserTypesEntity userTypesEntity) {
        Post post=new Post();
        try {
            post.setId(rs.getInt("id"));
            post.setUser(usersEntity.findById(rs.getInt("user_id"),userTypesEntity));
            post.setTitle(rs.getString("title"));
            post.setDate(rs.getString("date"));
            post.setDescription(rs.getString("description"));
            post.setUrl(rs.getString("url"));
            return post;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
