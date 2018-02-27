package com.glitched.Karatewebprofile.models;

import java.sql.SQLException;
import java.sql.ResultSet;

public class Event {
    private int id;
    private String pictureUrl;
    private String title;
    private String ubication;
    private String date;
    private String dateLimit;
    private String description;
    private String tags;
    private String websites;
    private double salary;
    private User user;

    public Event() {
    }

    public Event(int id, String pictureUrl, String title, String ubication, String date, String dateLimit, String description, String tags, String websites, double salary, User user) {
        this.id = id;
        this.pictureUrl = pictureUrl;
        this.title = title;
        this.ubication = ubication;
        this.date = date;
        this.dateLimit = dateLimit;
        this.description = description;
        this.tags = tags;
        this.websites = websites;
        this.salary = salary;
        this.user = user;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getPictureUrl() { return pictureUrl; }

    public void setPictureUrl(String pictureUrl) { this.pictureUrl = pictureUrl; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getUbication() { return ubication; }

    public void setUbication(String ubication) { this.ubication = ubication; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getDateLimit() { return dateLimit; }

    public void setDateLimit(String dateLimit) { this.dateLimit = dateLimit; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getTags() { return tags; }

    public void setTags(String tags) { this.tags = tags; }

    public String getWebsites() { return websites; }

    public void setWebsites(String websites) { this.websites = websites; }

    public double getSalary() { return salary; }

    public void setSalary(double salary) { this.salary = salary; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public static Event from(ResultSet rs, UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        Event event=new Event();
        try {
            event.setId(rs.getInt("id"));
            event.setPictureUrl(rs.getString("picture_url"));
            event.setTitle(rs.getString("title"));
            event.setUbication(rs.getString("ubication"));
            event.setDate(rs.getString("date"));
            event.setDateLimit(rs.getString("date_limit"));
            event.setDescription(rs.getString("description"));
            event.setTags(rs.getString("tags"));
            event.setWebsites(rs.getString("websites"));
            event.setSalary(rs.getDouble("salary"));
            event.setUser(usersEntity.findById(rs.getInt("user_id"),userTypesEntity));
            return event;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
