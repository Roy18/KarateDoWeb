package com.glitched.Karatewebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostulantsEntity extends BaseEntity {

    public PostulantsEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public PostulantsEntity() {
        super();
        setTableName("Postulants");
    }

    public List<Postulant> findByCriteria (String criteria, EventsEntity eventsEntity,UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<Postulant> postulant = new ArrayList<>();
            while (rs.next()) {
                postulant.add(Postulant.from(rs,eventsEntity,usersEntity,userTypesEntity));
            }
            return postulant;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Postulant> findByEvent(int eventId, EventsEntity eventsEntity,UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        return findByCriteria(String.format("WHERE event_id=%d",eventId),eventsEntity,usersEntity,userTypesEntity);
    }

    public boolean check(int eventId,int userId) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(String.format("SELECT * FROM %s WHERE event_id=%d AND user_id=%d",getTableName(),eventId,userId));
            if (rs.next()) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean create(int eventId, int userId,String date) {
        return executeUpdate(String.format("INSERT INTO %s VALUES(%d,%d,'%s')",getTableName(),eventId,userId,date));
    }
}
