package com.glitched.Karatewebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InformationsEntity extends BaseEntity{

    public InformationsEntity() {
        super();
        setTableName("informations");
    }
    public InformationsEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public List<Information> findByCriteria (String criteria,UsersEntity usersEntity,UserTypesEntity userTypesEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<Information> information = new ArrayList<>();
            while (rs.next()) {
                information.add(Information.from(rs,usersEntity,userTypesEntity));
            }
            return information;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Information> findAll(UsersEntity usersEntity,UserTypesEntity userTypesEntity) {
        return findByCriteria("",usersEntity,userTypesEntity);
    }

    public Information findById(int id,UsersEntity usersEntity,UserTypesEntity userTypesEntity) {
        return findByCriteria(
                String.format("WHERE id=%d",id),usersEntity,userTypesEntity).get(0);
    }

    public Information findByUserId(int userId,UsersEntity usersEntity,UserTypesEntity userTypesEntity) {
        return findByCriteria(
                String.format("WHERE user_id=%d",userId),usersEntity,userTypesEntity).get(0);
    }

    public Information findByUserUsername(String username, UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        return findByCriteria(String.format("WHERE user_id=(SELECT id FROM users WHERE username='%s')",username),usersEntity,userTypesEntity).get(0);
    }

    public boolean create(Information information) {
        return executeUpdate(String.format("INSERT INTO %s(description,average_points,vote_quantity,user_id) VALUES ('%s',%.2f,%d,%d)",
                getTableName(),information.getDescription(),information.getAveragePoints(),
                information.getVoteQuantity(),information.getUser().getId()));
    }

    public boolean create(String description,double averagePoints, int voteQuantity, User user) {
        Information information=new Information();
        information.setDescription(description);
        information.setAveragePoints(averagePoints);
        information.setVoteQuantity(voteQuantity);
        information.setUser(user);
        return create(information);
    }

    public boolean update(int userId) {
        return executeUpdate(String.format("UPDATE %s SET vote_quantity=(SELECT COUNT(target) FROM points WHERE target=%d)," +
                "average_points=(SELECT AVG(quantity) FROM points WHERE target=%d) " +
                "WHERE user_id=%d",getTableName(),userId,userId,userId));
    }
}
