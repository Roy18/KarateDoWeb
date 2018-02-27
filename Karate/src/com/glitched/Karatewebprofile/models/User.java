package com.glitched.Karatewebprofile.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String email;
    private String birthDate;
    private char genre;
    private String phone;
    private String pictureUrl;
    private UserType userType;

    public User() {
    }

    public User(int id, String username, String password, String name, String lastName, String email, String birthDate, char genre, String phone, String pictureUrl, UserType userType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.genre = genre;
        this.phone = phone;
        this.pictureUrl = pictureUrl;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public char getGenre() {
        return genre;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public static User from (ResultSet rs, UserTypesEntity userTypesEntity) {
        User user=new User();
        try {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setLastName(rs.getString("lastName"));
            user.setEmail(rs.getString("email"));
            user.setBirthDate(rs.getDate("birthdate").toString());
            user.setGenre(rs.getString("genre").charAt(0));
            user.setPhone(rs.getString("phone"));
            user.setPictureUrl(rs.getString("picture_url"));
            user.setUserType(userTypesEntity.findById(rs.getInt("user_type_id")));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
