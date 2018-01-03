package com.zdy.project.wechat_chatroom_helper.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DataBaseManager {

    private static final DataBaseManager INSTANCE = new DataBaseManager();

    private Connection c = null;


    public static final String url = "jdbc:mysql://116.62.247.71:3306/wechat_chatroom_helper";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "admin";

    private DataBaseManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static DataBaseManager getInstance() {
        return INSTANCE;
    }

    public void insertUserStatisticsData(String uuid, String model, String action, String version, String wechat_version) {
        String sql;
        try {
            Statement stmt = c.createStatement();

            sql = "INSERT INTO user_statistics " + "( uuid, model, action, time, version ,wechat_version) " + "VALUES (" + uuid +
                    ", '" + model + "', '" + action + "', " + System.currentTimeMillis() + ", '" + version + "', '" + wechat_version + "' );";
            stmt.executeUpdate(sql);

            stmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int queryUserCountByTime(long start, long end) {

        String sql;
        try {
            Statement stmt = c.createStatement();

            sql = "SELECT count(DISTINCT uuid) FROM user_statistics where time BETWEEN " + start + " AND " + end;

            ResultSet resultSet = stmt.executeQuery(sql);

            int count = 0;
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }

            stmt.close();

            return count;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }


    public HashMap<Integer, Integer> queryWechatVersionPercent(long start, long end) {

        LinkedHashMap<Integer, Integer> data = new LinkedHashMap<>();

        String sql;
        try {
            Statement stmt = c.createStatement();
            sql = "SELECT DISTINCT wechat_version FROM user_statistics where time BETWEEN " + start + " AND " + end;
            ResultSet resultSet = stmt.executeQuery(sql);

            ArrayList<Integer> versionCodeArray = new ArrayList<>();

            while (resultSet.next()) {
                int version = Integer.valueOf(resultSet.getString(1));

                int size = versionCodeArray.size();

                if (size == 0) {
                    versionCodeArray.add(version);
                    continue;
                }


                for (int i = 0; i < size; i++) {
                    Integer entry = versionCodeArray.get(i);
                    if (entry > version) {

                        for (int j = size; j > i; j--) {
                            if (j == size) versionCodeArray.add(versionCodeArray.get(j - 1));
                            else versionCodeArray.set(j, versionCodeArray.get(j - 1));
                        }
                        versionCodeArray.set(i, version);
                        break;
                    }

                    if (i == size - 1) {
                        versionCodeArray.add(version);
                    }
                }
            }

            for (Integer integer : versionCodeArray) {
                int versionCount = getUserCount(start, end, "wechat_version", String.valueOf(integer));
                data.put(integer, versionCount);
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return data;
    }

    public HashMap<Integer, Integer> queryHelperVersionPercent(long start, long end) {

        HashMap<Integer, Integer> data = new HashMap<>();

        String sql;
        try {
            Statement stmt = c.createStatement();
            sql = "SELECT DISTINCT version FROM user_statistics where time BETWEEN " + start + " AND " + end;
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                int version;
                String resultSetString = resultSet.getString(1);
                if (resultSetString.equals("< 16")) version = -1;
                else version = Integer.valueOf(resultSetString);

                int versionCount = getUserCount(start, end, "version", String.valueOf(version));

                System.out.println("versionCount = " + versionCount + ", version = " + version);

                data.put(version, versionCount);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return data;
    }


    public int getUserCount(long start, long end, String field, String value) {
        String sql;
        try {
            Statement stmt = c.createStatement();
            sql = "SELECT count(DISTINCT uuid) FROM user_statistics WHERE time BETWEEN " + start + " AND " + end + " AND " + field + " = " + value;
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;

    }
}
