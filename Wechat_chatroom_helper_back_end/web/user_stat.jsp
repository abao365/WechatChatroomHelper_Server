<%@ page import="com.zdy.project.wechat_chatroom_helper.db.DataBaseManager" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <title>😐</title>
</head>
<body>

<ul class="layui-nav">
    <li class="layui-nav-item"><a href="user_stat.jsp" style="font-size: large">WechatChatroomHelper</a></li>
    <li class="layui-nav-item"><a href="wechat_download.jsp">首页</a></li>
    <li class="layui-nav-item layui-this"><a href="user_stat.jsp">用户统计</a></li>
    <li class="layui-nav-item"><a href="thanks.jsp">鸣谢</a></li>
    <li class="layui-nav-item"><a href="https://github.com/zhudongya123/WechatChatroomHelper/issues/new">GitHub反馈</a>
    </li>
</ul>


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;max-width:1000px;">
    <legend>用户数量统计</legend>
</fieldset>


<div class="layui-form">
    <table class="layui-table" style="max-width:1000px">
        <%
            Calendar instance = Calendar.getInstance();
            instance.set(Calendar.HOUR_OF_DAY, 0);
            instance.set(Calendar.MINUTE, 0);
            instance.set(Calendar.SECOND, 0);

            long currentTime = System.currentTimeMillis();
            long time = instance.getTimeInMillis();
        %>
        <thead>
        <tr>
            <th>日期</th>
            <th>用户数量</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>今天</td>
            <td><%
                int todayCount = DataBaseManager.getInstance().queryUserCountByTime(time, currentTime);
                out.println(DataBaseManager.getInstance().queryUserCountByTime(time, currentTime)); %></td>
        </tr>
        <tr>
            <td>昨天</td>
            <td><%out.println(DataBaseManager.getInstance().queryUserCountByTime(time - 86400000, time)); %></td>
        </tr>
        <tr>
            <td>过去七天</td>
            <td><%out.println(DataBaseManager.getInstance().queryUserCountByTime(time - 86400000 * 7, time));%></td>
        </tr>
        </tbody>
    </table>
</div>


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;max-width:1000px;">
    <legend>今日微信版本统计</legend>
</fieldset>
<%
    HashMap<Integer, Integer> wechatMap = DataBaseManager.getInstance().queryWechatVersionPercent(time, currentTime);

%>
<table class="layui-table" style="max-width:1000px">

    <%
        ArrayList<String> wechatNameArray = new ArrayList<>();
        ArrayList<Integer> wechatCountArray = new ArrayList<>();
        ArrayList<Float> wechatFloatArray = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : wechatMap.entrySet()) {
            Integer value = entry.getValue();

            wechatNameArray.add(DataBaseManager.getInstance().queryWechatFullVersionName(entry.getKey()));
            wechatCountArray.add(value);
            wechatFloatArray.add(Float.valueOf(value) / todayCount);
        }
    %>
    <thead>
    <tr>
        <th>版本号</th>
        <th>用户数量</th>
        <th>百分比</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (int i = 0; i < wechatNameArray.size(); i++) {
    %>
    <tr>
        <td><% out.print(wechatNameArray.get(i));%></td>
        <td><% out.print(wechatCountArray.get(i));%></td>
        <td><% out.print(String.format(Locale.CHINESE, "%.2f", wechatFloatArray.get(i) * 100));%>%</td>
    </tr>
    <%
        }
    %>
    </tbody>

</table>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;max-width:1000px;">
    <legend>今日群助手版本统计</legend>
</fieldset>

<%
    HashMap<Integer, Integer> helperMap = DataBaseManager.getInstance().queryHelperVersionPercent(time, currentTime);
%>

<table class="layui-table" style="max-width:1000px">

    <%
        ArrayList<String> helperNameArray = new ArrayList<>();
        ArrayList<Integer> helperCountArray = new ArrayList<>();
        ArrayList<Float> helperFloatArray = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : helperMap.entrySet()) {
            Integer value = entry.getValue();

            helperNameArray.add(DataBaseManager.getInstance().queryHelperVersionName(entry.getKey()));
            helperCountArray.add(value);
            helperFloatArray.add(Float.valueOf(value) / todayCount);
        }
    %>
    <thead>
    <tr>
        <th>版本号</th>
        <td>用户数量</td>
        <td>百分比</td>
    </tr>
    </thead>

    <tbody>
    <%
        for (int i = 0; i < helperCountArray.size(); i++) {
    %>
    <tr>
        <td><% out.print(helperNameArray.get(i));%></td>
        <td><% out.print(helperCountArray.get(i));%></td>
        <td><% out.print(String.format(Locale.CHINESE, "%.2f", helperFloatArray.get(i) * 100));%>%</td>
    </tr>
    <%
        }
    %>
    </tbody>

</table>

</body>
</html>
