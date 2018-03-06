<%@ page import="com.zdy.project.wechat_chatroom_helper.db.DataBaseManager" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: zhudo
  Date: 2017/11/21
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css" media="all">

    <title>支持的微信版本</title>

    <style type="text/css">
        button {
            margin: 4px;
        }</style>
</head>
<body>
<div>
    <ul class="layui-nav">
        <li class="layui-nav-item">
            <a href="wechat_download.jsp" style="font-size:medium">WechatChatroomHelper</a></li>
        <li class="layui-nav-item layui-this"><a href="wechat_download.jsp">首页</a></li>
        <li class="layui-nav-item"><a href="user_stat.jsp">用户统计</a></li>
        <li class="layui-nav-item"><a href="thanks.jsp">鸣谢</a></li>
        <li class="layui-nav-item"><a
                href="https://github.com/zhudongya123/WechatChatroomHelper/issues/new">GitHub反馈</a></li>
    </ul>
</div>


<div>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend>公告</legend>
    </fieldset>

    <blockquote class="layui-elem-quote">
        算了懒得写更新公告了，直接在这里找吧，每次都在这里发  -><a href="https://github.com/zhudongya123/WechatChatroomHelper/releases">点我！</a><br>
    </blockquote>
</div>


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>目前支持的微信版本</legend>
</fieldset>

<div class="layui-collapse">

    <%
        ArrayList<HashMap<String, String>> normalWechatVersion = DataBaseManager.getInstance().queryWechatDownloadUrl(0);
        ArrayList<HashMap<String, String>> playWechatVersion = DataBaseManager.getInstance().queryWechatDownloadUrl(1);

    %>

    <div class="layui-colla-item">
        <h2 class="layui-colla-title">普通版本</h2>
        <div class="layui-colla-content layui-show">


            <%
                for (HashMap<String, String> hashMap : normalWechatVersion) {
                    if (!hashMap.get("is_available").equals("1")) continue;
            %>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href=<% out.print(hashMap.get("download_url")); %>>
                    <% out.print(hashMap.get("full_version_name")); %></a>
            </button>
            <br>
            <%
                }
            %>
        </div>
    </div>
    <div class="layui-colla-item">
        <h2 class="layui-colla-title">Google Play版本（ApkPure）</h2>
        <div class="layui-colla-content">

            <%
                for (HashMap<String, String> hashMap : playWechatVersion) {
                    if (!hashMap.get("is_available").equals("1")) continue;
            %>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href=<% out.print(hashMap.get("download_url")); %>>
                    <% out.print(hashMap.get("full_version_name")); %></a>
            </button>
            <br>
            <%
                }
            %>

        </div>
    </div>
</div>

<div>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;max-width:1000px;">
        <legend>反馈群</legend>
    </fieldset>

    <img src="feedback_pict.png" width="300" height="300">

</div>
<script src="layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['element', 'layer'], function () {
        var element = layui.element;
        var layer = layui.layer;

        //监听折叠
        element.on('collapse(test)', function (data) {
        });
    });
</script>

</body>
</html>

