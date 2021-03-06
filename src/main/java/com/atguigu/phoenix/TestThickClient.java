package com.atguigu.phoenix;

import java.sql.*;
import java.util.Properties;

public class TestThickClient {

    public static void main(String[] args) throws SQLException {

        String url="jdbc:phoenix:hadoop102,hadoop103,hadoop104:2181";

        Properties props = new Properties();

        props.put("phoenix.schema.isNamespaceMappingEnabled","true");

        Connection connection = DriverManager.getConnection(url,props);


        PreparedStatement ps = connection.prepareStatement("select * from \"test\"");

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()){
            System.out.println(resultSet.getString(1)+":"+resultSet.getString(2));
        }
    }
}
