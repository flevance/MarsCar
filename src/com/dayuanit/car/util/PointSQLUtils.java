package com.dayuanit.car.util;

import com.dayuanit.car.map.Point;

import java.sql.*;

public class PointSQLUtils implements Utils {

    static final String  url = "jdbc:mysql://localhost:3306/MarsCar?useUnicode=true&characterEncoding=utf8";
    static final String userName = "root";
    static final String passWord = "ljt1127a";
    static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, userName, passWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void savePoint(int x, int y) {
        String saveSQL = "insert into Point(x,y) value (?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(saveSQL);
            preparedStatement.setInt(1,x);
            preparedStatement.setInt(2,y);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Point readLastPoint() {
        String readSQL = "select * from Point;";
        Point point = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(readSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (true == resultSet.last()){
                int x = resultSet.getInt(1);
                int y = resultSet.getInt(2);
                point = new Point(x,y);
                System.out.println("lastPoint=" + point.getX() + ","+point.getY());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return point;
    }
}
