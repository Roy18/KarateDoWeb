package com.universo7.Karatewebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PointsEntity extends BaseEntity{

    public PointsEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public PointsEntity() {
        super();
        setTableName("points");
    }

    public List<Point> findByCriteria (String criteria, UsersEntity usersEntity,UserTypesEntity userTypesEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<Point> points = new ArrayList<>();
            while (rs.next()) {
                points.add(Point.from(rs,usersEntity,userTypesEntity));
            }
            return points;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Point> findAll (UsersEntity usersEntity,UserTypesEntity userTypesEntity) {
        return findByCriteria("",usersEntity,userTypesEntity);
    }

    public List<Point> findByOrigin(User origin,UsersEntity usersEntity,UserTypesEntity userTypesEntity) {
        return findByCriteria(String.format("WHERE origin=%d",origin.getId()),usersEntity,userTypesEntity);
    }

    public List<Point> findByTarget(User target,UsersEntity usersEntity,UserTypesEntity userTypesEntity) {
        return findByCriteria(String.format("WHERE origin=%d",target.getId()),usersEntity,userTypesEntity);
    }
    public boolean create(Point point) {
        return executeUpdate(String.format("INSERT INTO %s "
                        .concat("VALUES(%d,%d,%d)"),getTableName(),
                point.getOrigin().getId(),point.getTarget().getId(),point.getQuantity()));
    }

    public boolean create(int origin, int target, int quantity, UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        Point point = new Point();
        point.setOrigin(usersEntity.findById(origin,userTypesEntity));
        point.setTarget(usersEntity.findById(target,userTypesEntity));
        point.setQuantity(quantity);
        return create(point);
    }

    public boolean check(int origin,int target) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(String.format("SELECT * FROM %s WHERE origin=%d AND target=%d",getTableName(),origin,target));
            if(rs.next()) {
                return true;
            } return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(int origin,int target,int quantity) {
        return executeUpdate(String.format("UPDATE %s SET quantity=%d WHERE origin=%d AND target=%d",getTableName(),quantity,origin,target));
    }

    public int getQuantity(int origin,int target) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(String.format("SELECT quantity FROM %s WHERE origin=%d AND target=%d",getTableName(),origin,target));
            if (rs.next()) {
                return rs.getInt("quantity");
            } else return 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
