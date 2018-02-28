package com.universo7.Karatewebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserTypesEntity extends BaseEntity{

    public UserTypesEntity() {
        super();
        setTableName("user_types");
    }

    public UserTypesEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public List<UserType> findByCriteria (String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<UserType> usertypes = new ArrayList<>();
            while (rs.next()) {
                usertypes.add(UserType.from(rs));
            }
            return usertypes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<UserType> findAll() {
        return findByCriteria("");
    }

    public UserType findById(int id) {
        return findByCriteria(
                String.format("WHERE id= %d",id)).get(0);
    }
}
