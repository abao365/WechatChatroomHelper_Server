<%--
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
        6.6.2[play]和6.6.3已经支持啦~<br>
        目前最新版本：<a href="https://github.com/zhudongya123/WechatChatroomHelper/releases">1.3.12beta</a><br>
        更新日期：21 Dec 2017
        更新公告：现在已经提供群助手已经提供修改UI颜色功能。
    </blockquote>
</div>


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>目前支持的微信版本</legend>
</fieldset>

<div class="layui-collapse" lay-accordion="">
    <div class="layui-colla-item">
        <h2 class="layui-colla-title">普通版本</h2>
        <div class="layui-colla-content layui-show">
            <button class="layui-btn layui-btn-primary layui-btn-sm"><a
                    href="http://dldir1.qq.com/weixin/android/weixin658android1060.apk">6.5.8（1060）</a>
            </button>
            <br>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="http://dldir1.qq.com/weixin/android/weixin6510android1080.apk">6.5.10（1080）</a>
            </button>
            <br>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="http://dldir1.qq.com/weixin/android/weixin6513android1100.apk">6.5.13（1100）</a>
            </button>
            <br>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="http://dldir1.qq.com/weixin/android/weixin6514android1120.apk">6.5.14（1100）</a>
            </button>
            <br>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="http://dldir1.qq.com/weixin/android/weixin6516android1120.apk">6.5.16（1120）</a>
            </button>
            <br>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="http://dldir1.qq.com/weixin/android/weixin6519android1140.apk">6.5.19（1140）</a>
            </button>
            <br>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="http://dldir1.qq.com/weixin/android/weixin6522android1160.apk">6.5.22（1160）</a>
            </button>
            <br>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="http://dldir1.qq.com/weixin/android/weixin6523android1180.apk">6.5.23（1180）</a>
            </button>
            <br>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="http://dldir1.qq.com/weixin/android/weixin660android1200.apk">6.6.0（1200）</a>
            </button>
            <br>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="http://dldir1.qq.com/weixin/android/weixin661android1220_1.apk">6.6.1（1220）</a>
            </button>
            <br>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="http://dldir1.qq.com/weixin/android/weixin662android1240.apk">6.6.2（1240）</a>
            </button>
            <br>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="http://dldir1.qq.com/weixin/android/weixin663android1260.apk">6.6.3（1260）</a>
            </button>
        </div>
    </div>
    <div class="layui-colla-item">
        <h2 class="layui-colla-title">Google Play版本（ApkPure）</h2>
        <div class="layui-colla-content">
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="https://download.apkpure.com/b/apk/Y29tLnRlbmNlbnQubW1fMTA2MF9kMDBmZTI3Mg?_fn=V2VDaGF0X3Y2LjUuOF9hcGtwdXJlLmNvbS5hcGs%3D&k=6a2eb41638ae21c1a157587107242d4d59e94ffb&as=7280c6bbd1784e9066c7258a5681849659e6ad73&_p=Y29tLnRlbmNlbnQubW0%3D&c=1%7CCOMMUNICATION">6.5.8（1060）play版本</a>
            </button>
            <br>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="https://download.apkpure.com/b/apk/Y29tLnRlbmNlbnQubW1fMTA4MF8yMzM4MDc1Mg?_fn=V2VDaGF0X3Y2LjUuMTBfYXBrcHVyZS5jb20uYXBr&k=5b050b1c88d5bb7056ef151ecf1521ce59e94fb9&as=4a7cc7b836c9fb684886db1c5827ecef59e6ad31&_p=Y29tLnRlbmNlbnQubW0%3D&c=1%7CCOMMUNICATION">6.5.10（1080）play版本</a>
            </button>
            <br>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="https://download.apkpure.com/b/apk/Y29tLnRlbmNlbnQubW1fMTA4MV85ZmY0YTFkYQ?_fn=V2VDaGF0X3Y2LjUuMTNfYXBrcHVyZS5jb20uYXBr&k=3d26336b745d372202732a72d2cd17d259e94f8c&as=bc741ac0664a238d66b4c25a089aed7359e6ad04&_p=Y29tLnRlbmNlbnQubW0%3D&c=1%7CCOMMUNICATION">6.5.13（1081）play版本</a>
            </button>
            <br>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="https://download.apkpure.com/b/apk/Y29tLnRlbmNlbnQubW1fMTEwMV8xZGFhOWU3?_fn=V2VDaGF0X3Y2LjUuMTZfYXBrcHVyZS5jb20uYXBr&k=a79e588c9a79e789959541d5b045079359e94ec9&as=950e90e629dda0953fd2d07ea574b23259e6ac41&_p=Y29tLnRlbmNlbnQubW0%3D&c=1%7CCOMMUNICATION">6.5.16（1101）play版本</a>
            </button>
            <br>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="https://download.apkpure.com/b/apk/Y29tLnRlbmNlbnQubW1fMTE2MF8yY2UyNjAxZA?_fn=V2VDaGF0X3Y2LjUuMjNfYXBrcHVyZS5jb20uYXBr&k=0f33ce5459c7fd25e93cc57fbc3f00735a3cb9fe&as=6ad3da5f04ca3f3a7d0b2c67e97945555a3a1776&_p=Y29tLnRlbmNlbnQubW0&c=1%7CCOMMUNICATION">6.5.23（1160）play版本</a>
            </button>
            <br>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="https://download.apkpure.com/b/apk/Y29tLnRlbmNlbnQubW1fMTIyMF9iNTI0M2FkYQ?_fn=V2VDaGF0X3Y2LjYuMV9hcGtwdXJlLmNvbS5hcGs&k=54ffe2f2f5826415e422488e7ded0bd25a5a1705&as=b889e59154d7d3ac4c0dd88044b518305a57747d&_p=Y29tLnRlbmNlbnQubW0&c=1%7CCOMMUNICATION">6.6.1（1220）play版本</a>
            </button>
            <br>
            <button class="layui-btn layui-btn-primary layui-btn-sm">
                <a href="https://d-01.winudf.com/b/apk/Y29tLnRlbmNlbnQubW1fMTI0MF9iNTFlY2NjZA?_fn=V2VDaGF0X3Y2LjYuMl9hcGtwdXJlLmNvbS5hcGs&_p=Y29tLnRlbmNlbnQubW0&as=f055628dbbdb42fe4e067236d8d281d95a80f957&c=1%7CCOMMUNICATION&k=2ccb7008ad66ac9a6977a7012152d1795a84a798">6.6.2（1240）play版本</a>
            </button>

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

