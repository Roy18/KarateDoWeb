package com.universo7.Karatewebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersEntity extends BaseEntity{

    public UsersEntity() {
        super();
        setTableName("users");
    }

    public UsersEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public List<User> findByCriteria (String criteria, UserTypesEntity userTypesEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(User.from(rs,userTypesEntity));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findAll(UserTypesEntity userTypesEntity) {
        return findByCriteria("",userTypesEntity);
    }

    public User findById(int id,UserTypesEntity userTypesEntity) {
        return findByCriteria(String.format("WHERE id=%d",id),userTypesEntity).get(0);
    }

    public User findByUsername(String username, UserTypesEntity userTypesEntity) {
        return findByCriteria(String.format("WHERE username='%s'",username),userTypesEntity).get(0);
    }

    public boolean findByLogin(String username, String password, UserTypesEntity userTypesEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(String.format("SELECT id FROM %s WHERE username='%s' AND password='%s'",getTableName(),username,password));
            if(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean create(User user) {
        return executeUpdate(String.format(
                "INSERT INTO %s(username,password,name,lastname,email,birthdate,genre,phone,picture_url,user_type_id)"
                        .concat("VALUES('%s','%s','%s','%s','%s',STR_TO_DATE('%s','%%d-%%m-%%Y'),'%s',NULL,NULL,%d)"),
                getTableName(),user.getUsername(),user.getPassword(),user.getName(),user.getLastName(),user.getEmail(),
                user.getBirthDate(),user.getGenre(),user.getUserType().getId()));
    }

    public boolean create(String username,String password,String name,String lastName,String email,String birthDate,char genre,UserType userType) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setBirthDate(birthDate);
        user.setGenre(genre);
        user.setUserType(userType);
        return create(user);
    }

    public boolean update(int id,String name,String lastname,String phone) {
        return executeUpdate(String.format("UPDATE %s SET name='%s',lastname='%s',phone='%s' WHERE id=%d",getTableName(),name,lastname,phone,id));
    }
}
