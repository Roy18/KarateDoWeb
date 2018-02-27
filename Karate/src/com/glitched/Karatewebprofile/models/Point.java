package com.glitched.Karatewebprofile.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Point {
    private User origin;
    private User target;
    private int quantity;

    public Point(User origin, User target, int quantity) {
        this.origin = origin;
        this.target = target;
        this.quantity = quantity;
    }

    public Point() {
    }

    public User getOrigin() {
        return origin;
    }

    public void setOrigin(User origin) {
        this.origin = origin;
    }

    public User getTarget() {
        return target;
    }

    public void setTarget(User target) {
        this.target = target;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static Point from(ResultSet rs,UsersEntity usersEntity,UserTypesEntity userTypesEntity) {
        Point point=new Point();
        try {
            point.setOrigin(usersEntity.findById(rs.getInt("origin"),userTypesEntity));
            point.setTarget(usersEntity.findById(rs.getInt("target"),userTypesEntity));
            point.setQuantity(rs.getInt("quantity"));
            return point;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
