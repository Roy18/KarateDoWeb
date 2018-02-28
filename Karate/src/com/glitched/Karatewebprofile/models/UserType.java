package com.glitched.Karatewebprofile.models;
	
	import java.sql.ResultSet;
	import java.sql.SQLException;
	
	public class UserType {
	    private int id;
	    private String name;
	
	    public UserType(int id, String name) {
	        this.id = id;
	        this.name = name;
	    }
	    public UserType() {
	    }
	    public int getId() {
	        return id;
	    }
	
	    public void setId(int id) {
	        this.id = id;
	    }
	
	    public String getName() {
	        return name;
	    }
	
	    public void setName(String name) {
	        this.name = name;
	    }
	
	    public static UserType from (ResultSet rs) {
	        try {
	            return new UserType(
	                    rs.getInt("id"),
	                    rs.getString("name"));
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	}

