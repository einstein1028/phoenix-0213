package com.atguigu.phoenix;

import org.apache.phoenix.queryserver.client.ThinClientUtil;

import java.sql.*;

public class TestThinClient {

    public static void main(String[] args) throws SQLException {

        String url= ThinClientUtil.getConnectionUrl("hadoop102",8765);
        System.out.println(url);




        Connection connection = DriverManager.getConnection(url);

        PreparedStatement ps = connection.prepareStatement("select * from \"test\"");

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()){
            System.out.println(resultSet.getString(1)+":"+resultSet.getString(2));
        }
    }
}
