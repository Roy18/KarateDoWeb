package com.universo7.Karatewebprofile.models;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseEntity {
    private Connection connection;
    private String tableName;

    public BaseEntity(Connection connection, String tableName) {
        this.connection = connection;
        this.tableName = tableName;
    }

    public BaseEntity() {
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getBaseStatement() {
        return "SELECT * FROM ".concat(tableName).concat(" ");
    }

    public boolean executeUpdate(String sql) {
        try {
            int result = getConnection()
                    .createStatement()
                    .executeUpdate(sql);
            return result>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
