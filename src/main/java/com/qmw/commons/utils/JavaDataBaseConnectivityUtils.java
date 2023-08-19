package com.qmw.commons.utils;

import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JavaDataBaseConnectivityUtils {

    public static List<Map<String, Object>> query(
            String url,
            String username,
            String password,
            String sql,
            DataBase dataBase
    ) {
        try {
            Class.forName(dataBase.driverClassName);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            List<Map<String, Object>> list = new ArrayList<>();
            while (result.next()) {
                Map<String, Object> map = new LinkedHashMap<>();
                ResultSetMetaData data = result.getMetaData();
                for (int i = 1; i <= data.getColumnCount(); i++)
                    map.put(data.getColumnName(i), result.getObject(data.getColumnName(i)));
                list.add(map);
            }
            result.close();
            statement.close();
            connection.close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Getter
    public enum DataBase {

        MySQL("com.mysql.cj.jdbc.Driver"),
        SQLServer("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        private final String driverClassName;

        DataBase(String driverClassName) {
            this.driverClassName = driverClassName;
        }

    }

}
