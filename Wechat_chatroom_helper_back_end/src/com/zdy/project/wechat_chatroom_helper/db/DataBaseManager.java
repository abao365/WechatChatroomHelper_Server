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

    private LinkedHashMap<Integer, Integer> queryWechatVersionPercentHashMap = new LinkedHashMap<>();
    private HashMap<Integer, Integer> queryHelperVersionPercent = new HashMap<>();

    private long queryWechatVersionPercentHashMapTime = 0;
    private long queryHelperVersionPercentTime = 0;


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

        if (System.currentTimeMillis() - queryWechatVersionPercentHashMapTime > 1800 * 1000) {
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
                    queryWechatVersionPercentHashMap.put(integer, versionCount);
                }


            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            queryWechatVersionPercentHashMapTime = System.currentTimeMillis();

        }

        return queryWechatVersionPercentHashMap;
    }


    public HashMap<String, String> queryMatchInfo(int versionCode, int is_play_version) {
        HashMap<String, String> hashMap = new HashMap<>();

        try {
            Statement statement = c.createStatement();
            String sql = "SELECT * FROM wechat_version_info WHERE version_code = " + versionCode + " AND is_play_version =" + is_play_version;
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();

            hashMap.put("id", String.valueOf(resultSet.getInt("id")));
            hashMap.put("version_code", String.valueOf(resultSet.getInt("version_code")));
            hashMap.put("is_play_version", String.valueOf(resultSet.getInt("is_play_version")));
            hashMap.put("full_version_name", resultSet.getString("full_version_name"));
            hashMap.put("is_available", String.valueOf(resultSet.getInt("is_available")));
            hashMap.put("show_text_info", resultSet.getString("show_text_info"));
            hashMap.put("download_url", resultSet.getString("download_url"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public ArrayList<HashMap<String, String>> queryWechatDownloadUrl(int is_play_version) {

        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();


        try {
            Statement statement = c.createStatement();
            String sql = "SELECT * FROM wechat_version_info WHERE  is_play_version =" + is_play_version;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("full_version_name", resultSet.getString("full_version_name"));
                hashMap.put("is_available", String.valueOf(resultSet.getInt("is_available")));
                hashMap.put("download_url", resultSet.getString("download_url"));

                arrayList.add(hashMap);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }


    public String queryHelperVersionName(int versionCode) {

        String sql;

        try {
            Statement stmt = c.createStatement();
            sql = "SELECT version_name FROM helper_version_info where version_code =" + versionCode;
            ResultSet resultSet = stmt.executeQuery(sql);


            while (resultSet.next()) {
                return resultSet.getString("version_name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "未识别版本";
    }

    public String queryWechatFullVersionName(int versionCode) {

        String sql;

        try {
            Statement stmt = c.createStatement();
            sql = "SELECT full_version_name FROM wechat_version_name_info where version_code = " + versionCode;
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                return resultSet.getString("full_version_name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "其他版本";
    }

    public HashMap<Integer, Integer> queryHelperVersionPercent(long start, long end) {

        if (System.currentTimeMillis() - queryHelperVersionPercentTime > 1800 * 1000) {
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

                    queryHelperVersionPercent.put(version, versionCount);
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            queryHelperVersionPercentTime = System.currentTimeMillis();
        }

        return queryHelperVersionPercent;
    }


    private int getUserCount(long start, long end, String field, String value) {
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
