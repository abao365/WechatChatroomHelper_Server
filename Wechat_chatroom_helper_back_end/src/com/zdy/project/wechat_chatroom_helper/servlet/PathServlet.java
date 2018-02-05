package com.zdy.project.wechat_chatroom_helper.servlet;

import com.google.gson.JsonObject;
import com.zdy.project.wechat_chatroom_helper.db.DataBaseManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by zhudo on 2017/7/24.
 */
public class PathServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    /**
     * vmbt 字段已在2017年8月8日 21:02:01废弃
     *
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String versionCode = req.getParameter("versionCode");
        String isPlayVersion = req.getParameter("isPlayVersion") == null ? "0" : req.getParameter("isPlayVersion");

        Integer versionCodeNumber = Integer.valueOf(versionCode);

        JsonObject jsonObject = new JsonObject();
        JsonObject data = new JsonObject();

        HashMap<String, String> hashMap = DataBaseManager.getInstance().queryMatchInfo(versionCodeNumber, Integer.valueOf(isPlayVersion));

        try {
            String version_code = hashMap.get("version_code");
            String is_play_version = hashMap.get("is_play_version");
            String full_version_name = hashMap.get("full_version_name");
            String is_available = hashMap.get("is_available");
            String show_text_info = hashMap.get("show_text_info");

            if (is_available.equals("1")) {
                Class c = Class.forName("com.zdy.project.wechat_chatroom_helper.servlet.PathServlet");
                Method method = c.getDeclaredMethod("getConfig" + version_code + (is_play_version.equals("1") ? "playVersion" : ""), JsonObject.class);
                method.setAccessible(true);
                method.invoke(this, data);

                jsonObject.addProperty("code", 0);
                jsonObject.add("data", data);
                jsonObject.addProperty("msg", show_text_info);
            } else {
                jsonObject.addProperty("code", 1);
                jsonObject.addProperty("msg", show_text_info);
            }

        } catch (Throwable e) {
            e.printStackTrace();
            jsonObject.addProperty("code", 1);
            jsonObject.addProperty("msg", "微信版本 " + versionCode + (isPlayVersion.equals("1") ? "play版" : "") + " 尚未适配，请等待开发者适配");
        }
        writer.write(jsonObject.toString());
    }


    private void getConfig1240(JsonObject data) {
        data.addProperty("cclvan", "com.tencent.mm.ui.conversation.g");//主界面 listView 的 adapter
        data.addProperty("cclvapn", "com.tencent.mm.ui.f");//主界面 adapter 的实现类的父类
        data.addProperty("cclaon", "com.tencent.mm.ui.conversation.e");// 主界面 listView 的 onItemListener 的实现类

        data.addProperty("cclvas", "g");
        data.addProperty("cclvaps", "f");

        data.addProperty("mmsb", "i");//adapter 中绑定 itemView 的 model 获取方法
        data.addProperty("mago", "DC");//adapter 父类中（等同于） getObject 方法

        data.addProperty("vmsim1", "yXj");//adapter 中判断一个 item 是否为免打扰群消息的依据1
        data.addProperty("vmsim2", "tRV");//adapter 中判断一个 item 是否为免打扰群消息的依据2
        data.addProperty("vla", "yWw");//onItemListener 中 adapter 的变量名
        data.addProperty("vl", "yVR");//onItemListener 中 listView 的变量名

        data.addProperty("vlavt", "ynw");//adapter 中 itemView 中 显示 nickname 的 TextView
        data.addProperty("vlava", "iip");//adapter 中 itemView 中 显示 avatar 的 ImageView
        data.addProperty("vlavc", "yny");//adapter 中 itemView 中 显示 content 的 TextView

        data.addProperty("magos1", "xEs");//adapter 父类中获取 getObject 的第一步
        data.addProperty("magos2", "xCa");//adapter 父类中获取 getObject 的第二步
        data.addProperty("magos3", "DC");//adapter 父类中获取 getObject 的第三步

        data.addProperty("ctl", "com.tencent.mm.sdk.platformtools.x");//微信的日志打印类

        data.addProperty("dsa", "u6");//返回 drawable
        data.addProperty("dss", "and");//设置 drawable
        data.addProperty("dsca", "w5");//群头像的 drawable

        data.addProperty("vmbc", "yXb");//adapter 中获取 item 的 content 字段
        data.addProperty("vmbn", "nickName");//adapter 中获取 item 的 nickName 字段

        data.addProperty("vmbt", "yXa");//adapter 中获取 item 的 time 字段

        data.addProperty("mmtc", "b");//adapter 中获取 item 的 content 方法
        data.addProperty("vmtcp", "yXh");//adapter 中获取 item 的 content 方法中的参数
        data.addProperty("mmtt", "h");//adapter 中获取 item 的 time 方法

        data.addProperty("csa", "com.tencent.mm.pluginsdk.ui.a$b");//头像的处理生成方法
        data.addProperty("mclga", "a");//adapter 中获取 item 的 avatar 方法

        data.addProperty("vmsio1", "yXi");//判断一个 item 是否为公众号的依据1
        data.addProperty("vmsio2", "yXe");//判断一个 item 是否为公众号的依据2
        data.addProperty("vmsio3", "field_username");//判断一个 item 是否为公众号的依据3

        data.addProperty("mclvap", "com.tencent.mm.ui.f$a");//adapter 构造函数的参数

        data.addProperty("cthu", "com.tencent.mm.ui.d");
        data.addProperty("mhuiv", "ah");//HomeUI 中初始化 View 的方法
        data.addProperty("vhua", "xFE");//HomeUI 中 Activity 的变量名

    }


    private void getConfig1220playVersion(JsonObject data) {
        getConfig1220(data);
    }

    private void getConfig1220(JsonObject data) {
        data.addProperty("cclvan", "com.tencent.mm.ui.conversation.g");//主界面 listView 的 adapter
        data.addProperty("cclvapn", "com.tencent.mm.ui.g");//主界面 adapter 的实现类的父类
        data.addProperty("cclaon", "com.tencent.mm.ui.conversation.e");// 主界面 listView 的 onItemListener 的实现类

        data.addProperty("cclvas", "g");
        data.addProperty("cclvaps", "g");

        data.addProperty("mmsb", "j");//adapter 中绑定 itemView 的 model 获取方法
        data.addProperty("mago", "BV");//adapter 父类中（等同于） getObject 方法

        data.addProperty("vmsim1", "xXt");//adapter 中判断一个 item 是否为免打扰群消息的依据1
        data.addProperty("vmsim2", "sYG");//adapter 中判断一个 item 是否为免打扰群消息的依据2
        data.addProperty("vla", "xWG");//onItemListener 中 adapter 的变量名
        data.addProperty("vl", "xWd");//onItemListener 中 listView 的变量名

        data.addProperty("vlavt", "xov");//adapter 中 itemView 中 显示 nickname 的 TextView
        data.addProperty("vlava", "hEq");//adapter 中 itemView 中 显示 avatar 的 ImageView
        data.addProperty("vlavc", "xox");//adapter 中 itemView 中 显示 content 的 TextView

        data.addProperty("magos1", "wFX");//adapter 父类中获取 getObject 的第一步
        data.addProperty("magos2", "wDs");//adapter 父类中获取 getObject 的第二步
        data.addProperty("magos3", "BV");//adapter 父类中获取 getObject 的第三步

        data.addProperty("ctl", "com.tencent.mm.sdk.platformtools.x");//微信的日志打印类

        data.addProperty("dsa", "tm");//返回 drawable
        data.addProperty("dss", "amd");//设置 drawable
        data.addProperty("dsca", "vn");//群头像的 drawable

        data.addProperty("vmbc", "xXl");//adapter 中获取 item 的 content 字段
        data.addProperty("vmbn", "nickName");//adapter 中获取 item 的 nickName 字段

        data.addProperty("vmbt", "xXk");//adapter 中获取 item 的 time 字段

        data.addProperty("mmtc", "b");//adapter 中获取 item 的 content 方法
        data.addProperty("vmtcp", "xXr");//adapter 中获取 item 的 content 方法中的参数
        data.addProperty("mmtt", "i");//adapter 中获取 item 的 time 方法

        data.addProperty("csa", "com.tencent.mm.pluginsdk.ui.a$b");//头像的处理生成方法
        data.addProperty("mclga", "a");//adapter 中获取 item 的 avatar 方法

        data.addProperty("vmsio1", "xXs");//判断一个 item 是否为公众号的依据1
        data.addProperty("vmsio2", "xXo");//判断一个 item 是否为公众号的依据2
        data.addProperty("vmsio3", "field_username");//判断一个 item 是否为公众号的依据3

        data.addProperty("mclvap", "com.tencent.mm.ui.g$a");//adapter 构造函数的参数

        data.addProperty("cthu", "com.tencent.mm.ui.d");
        data.addProperty("mhuiv", "ah");//HomeUI 中初始化 View 的方法
        data.addProperty("vhua", "wFk");//HomeUI 中 Activity 的变量名
    }

    private void getConfig1200(JsonObject data) {
        data.addProperty("cclvan", "com.tencent.mm.ui.conversation.g");//主界面 listView 的 adapter
        data.addProperty("cclvapn", "com.tencent.mm.ui.g");//主界面 adapter 的实现类的父类
        data.addProperty("cclaon", "com.tencent.mm.ui.conversation.e");// 主界面 listView 的 onItemListener 的实现类

        data.addProperty("cclvas", "g");
        data.addProperty("cclvaps", "g");

        data.addProperty("mmsb", "j");//adapter 中绑定 itemView 的 model 获取方法
        data.addProperty("mago", "BO");//adapter 父类中（等同于） getObject 方法

        data.addProperty("vmsim1", "xSO");//adapter 中判断一个 item 是否为免打扰群消息的依据1
        data.addProperty("vmsim2", "sUu");//adapter 中判断一个 item 是否为免打扰群消息的依据2
        data.addProperty("vla", "xSb");//onItemListener 中 adapter 的变量名
        data.addProperty("vl", "xRy");//onItemListener 中 listView 的变量名

        data.addProperty("vlavt", "xjR");//adapter 中 itemView 中 显示 nickname 的 TextView
        data.addProperty("vlava", "hDL");//adapter 中 itemView 中 显示 avatar 的 ImageView
        data.addProperty("vlavc", "xjT");//adapter 中 itemView 中 显示 content 的 TextView

        data.addProperty("magos1", "wBE");//adapter 父类中获取 getObject 的第一步
        data.addProperty("magos2", "wza");//adapter 父类中获取 getObject 的第二步
        data.addProperty("magos3", "BO");//adapter 父类中获取 getObject 的第三步

        data.addProperty("ctl", "com.tencent.mm.sdk.platformtools.x");//微信的日志打印类

        data.addProperty("dsa", "te");//返回 drawable
        data.addProperty("dss", "am5");//设置 drawable
        data.addProperty("dsca", "vf");//群头像的 drawable

        data.addProperty("vmbc", "xSG");//adapter 中获取 item 的 content 字段
        data.addProperty("vmbn", "nickName");//adapter 中获取 item 的 nickName 字段

        data.addProperty("vmbt", "xSF");//adapter 中获取 item 的 time 字段

        data.addProperty("mmtc", "b");//adapter 中获取 item 的 content 方法
        data.addProperty("vmtcp", "xSM");//adapter 中获取 item 的 content 方法中的参数
        data.addProperty("mmtt", "i");//adapter 中获取 item 的 time 方法

        data.addProperty("csa", "com.tencent.mm.pluginsdk.ui.a$b");//头像的处理生成方法
        data.addProperty("mclga", "a");//adapter 中获取 item 的 avatar 方法

        data.addProperty("vmsio1", "xSN");//判断一个 item 是否为公众号的依据1
        data.addProperty("vmsio2", "xSJ");//判断一个 item 是否为公众号的依据2
        data.addProperty("vmsio3", "field_username");//判断一个 item 是否为公众号的依据3

        data.addProperty("mclvap", "com.tencent.mm.ui.g$a");//adapter 构造函数的参数

        data.addProperty("cthu", "com.tencent.mm.ui.d");
        data.addProperty("mhuiv", "ah");//HomeUI 中初始化 View 的方法
        data.addProperty("vhua", "wAS");//HomeUI 中 Activity 的变量名
    }

    private void getConfig1160playVersion(JsonObject data) {
        getConfig1180(data);
    }

    private void getConfig1180(JsonObject data) {
        data.addProperty("cclvan", "com.tencent.mm.ui.conversation.g");//主界面 listView 的 adapter
        data.addProperty("cclvapn", "com.tencent.mm.ui.f");//主界面 adapter 的实现类的父类
        data.addProperty("cclaon", "com.tencent.mm.ui.conversation.e");// 主界面 listView 的 onItemListener 的实现类

        data.addProperty("cclvas", "g");
        data.addProperty("cclvaps", "f");

        data.addProperty("mmsb", "j");//adapter 中绑定 itemView 的 model 获取方法
        data.addProperty("mago", "Bf");//adapter 父类中（等同于） getObject 方法

        data.addProperty("vmsim1", "xqR");//adapter 中判断一个 item 是否为免打扰群消息的依据1
        data.addProperty("vmsim2", "svM");//adapter 中判断一个 item 是否为免打扰群消息的依据2
        data.addProperty("vla", "xqf");//onItemListener 中 adapter 的变量名
        data.addProperty("vl", "xpy");//onItemListener 中 listView 的变量名

        data.addProperty("vlavt", "wIz");//adapter 中 itemView 中 显示 nickname 的 TextView
        data.addProperty("vlava", "htk");//adapter 中 itemView 中 显示 avatar 的 ImageView
        data.addProperty("vlavc", "wIB");//adapter 中 itemView 中 显示 content 的 TextView

        data.addProperty("magos1", "wao");//adapter 父类中获取 getObject 的第一步
        data.addProperty("magos2", "vXF");//adapter 父类中获取 getObject 的第二步
        data.addProperty("magos3", "Bf");//adapter 父类中获取 getObject 的第三步

        data.addProperty("ctl", "com.tencent.mm.sdk.platformtools.x");//微信的日志打印类

        data.addProperty("dsa", "sv");//返回 drawable
        data.addProperty("dss", "aln");//设置 drawable
        data.addProperty("dsca", "uw");//群头像的 drawable

        data.addProperty("vmbc", "xqJ");//adapter 中获取 item 的 content 字段
        data.addProperty("vmbn", "nickName");//adapter 中获取 item 的 nickName 字段

        data.addProperty("vmbt", "xqI");//adapter 中获取 item 的 time 字段

        data.addProperty("mmtc", "b");//adapter 中获取 item 的 content 方法
        data.addProperty("vmtcp", "xqP");//adapter 中获取 item 的 content 方法中的参数
        data.addProperty("mmtt", "i");//adapter 中获取 item 的 time 方法

        data.addProperty("csa", "com.tencent.mm.pluginsdk.ui.a$b");//头像的处理生成方法
        data.addProperty("mclga", "a");//adapter 中获取 item 的 avatar 方法

        data.addProperty("vmsio1", "xqQ");//判断一个 item 是否为公众号的依据1
        data.addProperty("vmsio2", "xqM");//判断一个 item 是否为公众号的依据2
        data.addProperty("vmsio3", "field_username");//判断一个 item 是否为公众号的依据3

        data.addProperty("mclvap", "com.tencent.mm.ui.f$a");//adapter 构造函数的参数

        data.addProperty("cthu", "com.tencent.mm.ui.d");
        data.addProperty("mhuiv", "ah");//HomeUI 中初始化 View 的方法
        data.addProperty("vhua", "vZn");//HomeUI 中 Activity 的变量名
    }

    private void getConfig1160(JsonObject data) {
        data.addProperty("cclvan", "com.tencent.mm.ui.conversation.g");//主界面 listView 的 adapter
        data.addProperty("cclvapn", "com.tencent.mm.ui.f");//主界面 adapter 的实现类的父类
        data.addProperty("cclaon", "com.tencent.mm.ui.conversation.e");// 主界面 listView 的 onItemListener 的实现类

        data.addProperty("cclvas", "g");
        data.addProperty("cclvaps", "f");

        data.addProperty("mmsb", "j");//adapter 中绑定 itemView 的 model 获取方法
        data.addProperty("mago", "AY");//adapter 父类中（等同于） getObject 方法


        data.addProperty("vmsim1", "xlR");//adapter 中判断一个 item 是否为免打扰群消息的依据1
        data.addProperty("vmsim2", "sqP");//adapter 中判断一个 item 是否为免打扰群消息的依据2
        data.addProperty("vla", "xlf");//onItemListener 中 adapter 的变量名
        data.addProperty("vl", "xky");//onItemListener 中 listView 的变量名

        data.addProperty("vlavt", "wDz");//adapter 中 itemView 中 显示 nickname 的 TextView
        data.addProperty("vlava", "hsy");//adapter 中 itemView 中 显示 avatar 的 ImageView
        data.addProperty("vlavc", "wDB");//adapter 中 itemView 中 显示 content 的 TextView

        data.addProperty("magos1", "vVq");//adapter 父类中获取 getObject 的第一步
        data.addProperty("magos2", "vSI");//adapter 父类中获取 getObject 的第二步
        data.addProperty("magos3", "AY");//adapter 父类中获取 getObject 的第三步

        data.addProperty("ctl", "com.tencent.mm.sdk.platformtools.x");//微信的日志打印类

        data.addProperty("dsa", "su");//返回 drawable
        data.addProperty("dss", "alm");//设置 drawable
        data.addProperty("dsca", "uv");//群头像的 drawable

        data.addProperty("vmbc", "xlJ");//adapter 中获取 item 的 content 字段
        data.addProperty("vmbn", "nickName");//adapter 中获取 item 的 nickName 字段

        data.addProperty("vmbt", "xlI");//adapter 中获取 item 的 time 字段

        data.addProperty("mmtc", "b");//adapter 中获取 item 的 content 方法
        data.addProperty("vmtcp", "xlP");//adapter 中获取 item 的 content 方法中的参数
        data.addProperty("mmtt", "i");//adapter 中获取 item 的 time 方法

        data.addProperty("csa", "com.tencent.mm.pluginsdk.ui.a$b");//头像的处理生成方法
        data.addProperty("mclga", "a");//adapter 中获取 item 的 avatar 方法

        data.addProperty("vmsio1", "xlQ");//判断一个 item 是否为公众号的依据1
        data.addProperty("vmsio2", "xlM");//判断一个 item 是否为公众号的依据2
        data.addProperty("vmsio3", "field_username");//判断一个 item 是否为公众号的依据3

        data.addProperty("mclvap", "com.tencent.mm.ui.f$a");//adapter 构造函数的参数

        data.addProperty("cthu", "com.tencent.mm.ui.d");
        data.addProperty("mhuiv", "ai");//HomeUI 中初始化 View 的方法
        data.addProperty("vhua", "vUq");//HomeUI 中 Activity 的变量名
    }

    private void getConfig1140(JsonObject data) {
        data.addProperty("cclvan", "com.tencent.mm.ui.conversation.g");//主界面 listView 的 adapter
        data.addProperty("cclvapn", "com.tencent.mm.ui.f");//主界面 adapter 的实现类的父类
        data.addProperty("cclaon", "com.tencent.mm.ui.conversation.e");// 主界面 listView 的 onItemListener 的实现类

        data.addProperty("cclvas", "g");
        data.addProperty("cclvaps", "f");

        data.addProperty("mmsb", "j");//adapter 中绑定 itemView 的 model 获取方法
        data.addProperty("mago", "AH");//adapter 父类中（等同于） getObject 方法


        data.addProperty("vmsim1", "wWY");//adapter 中判断一个 item 是否为免打扰群消息的依据1
        data.addProperty("vmsim2", "sdk");//adapter 中判断一个 item 是否为免打扰群消息的依据2
        data.addProperty("vla", "wWm");//onItemListener 中 adapter 的变量名
        data.addProperty("vl", "wVF");//onItemListener 中 listView 的变量名

        data.addProperty("vlavt", "woT");//adapter 中 itemView 中 显示 nickname 的 TextView
        data.addProperty("vlava", "hqG");//adapter 中 itemView 中 显示 avatar 的 ImageView
        data.addProperty("vlavc", "woV");//adapter 中 itemView 中 显示 content 的 TextView

        data.addProperty("magos1", "vGN");//adapter 父类中获取 getObject 的第一步
        data.addProperty("magos2", "vEh");//adapter 父类中获取 getObject 的第二步
        data.addProperty("magos3", "AH");//adapter 父类中获取 getObject 的第三步

        data.addProperty("ctl", "com.tencent.mm.sdk.platformtools.w");//微信的日志打印类

        data.addProperty("dsa", "sr");//返回 drawable
        data.addProperty("dss", "alg");//设置 drawable
        data.addProperty("dsca", "uq");//群头像的 drawable

        data.addProperty("vmbc", "wWQ");//adapter 中获取 item 的 content 字段
        data.addProperty("vmbn", "nickName");//adapter 中获取 item 的 nickName 字段

        data.addProperty("vmbt", "wWP");//adapter 中获取 item 的 time 字段

        data.addProperty("mmtc", "b");//adapter 中获取 item 的 content 方法
        data.addProperty("vmtcp", "wWW");//adapter 中获取 item 的 content 方法中的参数
        data.addProperty("mmtt", "i");//adapter 中获取 item 的 time 方法

        data.addProperty("csa", "com.tencent.mm.pluginsdk.ui.a$b");//头像的处理生成方法
        data.addProperty("mclga", "a");//adapter 中获取 item 的 avatar 方法

        data.addProperty("vmsio1", "wWX");//判断一个 item 是否为公众号的依据1
        data.addProperty("vmsio2", "wWT");//判断一个 item 是否为公众号的依据2
        data.addProperty("vmsio3", "field_username");//判断一个 item 是否为公众号的依据3

        data.addProperty("mclvap", "com.tencent.mm.ui.f$a");//adapter 构造函数的参数

        data.addProperty("cthu", "com.tencent.mm.ui.d");
        data.addProperty("mhuiv", "ai");//HomeUI 中初始化 View 的方法
        data.addProperty("vhua", "vFP");//HomeUI 中 Activity 的变量名
    }

    private void getConfig1101playVersion(JsonObject data) {
        data.addProperty("cclvan", "com.tencent.mm.ui.conversation.g");//主界面 listView 的 adapter
        data.addProperty("cclvapn", "com.tencent.mm.ui.f");//主界面 adapter 的实现类的父类
        data.addProperty("cclaon", "com.tencent.mm.ui.conversation.e");// 主界面 listView 的 onItemListener 的实现类

        data.addProperty("cclvas", "g");
        data.addProperty("cclvaps", "f");

        data.addProperty("mmsb", "j");//adapter 中绑定 itemView 的 model 获取方法
        data.addProperty("mago", "Ab");//adapter 父类中（等同于） getObject 方法

        data.addProperty("vmsim1", "wAf");//adapter 中判断一个 item 是否为免打扰群消息的依据1
        data.addProperty("vmsim2", "vZk");//adapter 中判断一个 item 是否为免打扰群消息的依据2
        data.addProperty("vla", "wzs");//onItemListener 中 adapter 的变量名
        data.addProperty("vl", "wyM");//onItemListener 中 listView 的变量名

        data.addProperty("vlavt", "vSr");//adapter 中 itemView 中 显示 nickname 的 TextView
        data.addProperty("vlava", "iiB");//adapter 中 itemView 中 显示 avatar 的 ImageView
        data.addProperty("vlavc", "vSt");//adapter 中 itemView 中 显示 content 的 TextView

        data.addProperty("magos1", "vkD");//adapter 父类中获取 getObject 的第一步
        data.addProperty("magos2", "vhW");//adapter 父类中获取 getObject 的第二步
        data.addProperty("magos3", "Ab");//adapter 父类中获取 getObject 的第三步

        data.addProperty("ctl", "com.tencent.mm.sdk.platformtools.w");//微信的日志打印类

        data.addProperty("dsa", "rz");//返回 drawable
        data.addProperty("dss", "ak2");//设置 drawable
        data.addProperty("dsca", "ty");//群头像的 drawable

        data.addProperty("vmbc", "wzX");//adapter 中获取 item 的 content 字段
        data.addProperty("vmbn", "nickName");//adapter 中获取 item 的 nickName 字段

        data.addProperty("vmbt", "wzW");//adapter 中获取 item 的 time 字段

        data.addProperty("mmtc", "b");//adapter 中获取 item 的 content 方法
        data.addProperty("vmtcp", "wAd");//adapter 中获取 item 的 content 方法中的参数
        data.addProperty("mmtt", "i");//adapter 中获取 item 的 time 方法

        data.addProperty("csa", "com.tencent.mm.pluginsdk.ui.a$b");//头像的处理生成方法
        data.addProperty("mclga", "a");//adapter 中获取 item 的 avatar 方法

        data.addProperty("vmsio1", "wAe");//判断一个 item 是否为公众号的依据1
        data.addProperty("vmsio2", "wAa");//判断一个 item 是否为公众号的依据2
        data.addProperty("vmsio3", "field_username");//判断一个 item 是否为公众号的依据3

        data.addProperty("mclvap", "com.tencent.mm.ui.f$a");//adapter 构造函数的参数

        data.addProperty("cthu", "com.tencent.mm.ui.d");
        data.addProperty("mhuiv", "aj");//HomeUI 中初始化 View 的方法
        data.addProperty("vhua", "vjF");//HomeUI 中 Activity 的变量名

    }

    private void getConfig1120(JsonObject data) {
        data.addProperty("cclvan", "com.tencent.mm.ui.conversation.g");//主界面 listView 的 adapter
        data.addProperty("cclvapn", "com.tencent.mm.ui.f");//主界面 adapter 的实现类的父类
        data.addProperty("cclaon", "com.tencent.mm.ui.conversation.e");// 主界面 listView 的 onItemListener 的实现类

        data.addProperty("cclvas", "g");
        data.addProperty("cclvaps", "f");

        data.addProperty("mmsb", "j");//adapter 中绑定 itemView 的 model 获取方法
        data.addProperty("mago", "Aa");//adapter 父类中（等同于） getObject 方法

        data.addProperty("vmsim1", "wAm");//adapter 中判断一个 item 是否为免打扰群消息的依据1
        data.addProperty("vmsim2", "vZr");//adapter 中判断一个 item 是否为免打扰群消息的依据2
        data.addProperty("vla", "wzz");//onItemListener 中 adapter 的变量名
        data.addProperty("vl", "wyT");//onItemListener 中 listView 的变量名

        data.addProperty("vlavt", "vSy");//adapter 中 itemView 中 显示 nickname 的 TextView
        data.addProperty("vlava", "iiL");//adapter 中 itemView 中 显示 avatar 的 ImageView
        data.addProperty("vlavc", "vSA");//adapter 中 itemView 中 显示 content 的 TextView

        data.addProperty("magos1", "vkI");//adapter 父类中获取 getObject 的第一步
        data.addProperty("magos2", "vic");//adapter 父类中获取 getObject 的第二步
        data.addProperty("magos3", "Aa");//adapter 父类中获取 getObject 的第三步

        data.addProperty("ctl", "com.tencent.mm.sdk.platformtools.w");//微信的日志打印类

        data.addProperty("dsa", "rz");//返回 drawable
        data.addProperty("dss", "ak2");//设置 drawable
        data.addProperty("dsca", "ty");//群头像的 drawable

        data.addProperty("vmbc", "wAe");//adapter 中获取 item 的 content 字段
        data.addProperty("vmbn", "nickName");//adapter 中获取 item 的 nickName 字段

        data.addProperty("vmbt", "wAd");//adapter 中获取 item 的 time 字段

        data.addProperty("mmtc", "b");//adapter 中获取 item 的 content 方法
        data.addProperty("vmtcp", "wAk");//adapter 中获取 item 的 content 方法中的参数
        data.addProperty("mmtt", "i");//adapter 中获取 item 的 time 方法

        data.addProperty("csa", "com.tencent.mm.pluginsdk.ui.a$b");//头像的处理生成方法
        data.addProperty("mclga", "a");//adapter 中获取 item 的 avatar 方法

        data.addProperty("vmsio1", "wAl");//判断一个 item 是否为公众号的依据1
        data.addProperty("vmsio2", "wAh");//判断一个 item 是否为公众号的依据2
        data.addProperty("vmsio3", "field_username");//判断一个 item 是否为公众号的依据3

        data.addProperty("mclvap", "com.tencent.mm.ui.f$a");//adapter 构造函数的参数

        data.addProperty("cthu", "com.tencent.mm.ui.d");
        data.addProperty("mhuiv", "ai");//HomeUI 中初始化 View 的方法
        data.addProperty("vhua", "vjK");//HomeUI 中 Activity 的变量名
    }

    private void getConfig1101(JsonObject data) {
        data.addProperty("cclvan", "com.tencent.mm.ui.conversation.g");//主界面 listView 的 adapter
        data.addProperty("cclvapn", "com.tencent.mm.ui.e");//主界面 adapter 的实现类的父类
        data.addProperty("cclaon", "com.tencent.mm.ui.conversation.e");// 主界面 listView 的 onItemListener 的实现类

        data.addProperty("cclvas", "g");
        data.addProperty("cclvaps", "e");

        data.addProperty("mmsb", "j");//adapter 中绑定 itemView 的 model 获取方法
        data.addProperty("mago", "yQ");//adapter 父类中（等同于） getObject 方法

        data.addProperty("vmsim1", "wcZ");//adapter 中判断一个 item 是否为免打扰群消息的依据1
        data.addProperty("vmsim2", "vCN");//adapter 中判断一个 item 是否为免打扰群消息的依据2
        data.addProperty("vla", "wcm");//onItemListener 中 adapter 的变量名
        data.addProperty("vl", "wbJ");//onItemListener 中 listView 的变量名

        data.addProperty("vlavt", "vvZ");//adapter 中 itemView 中 显示 nickname 的 TextView
        data.addProperty("vlava", "ipK");//adapter 中 itemView 中 显示 avatar 的 ImageView
        data.addProperty("vlavc", "vwb");//adapter 中 itemView 中 显示 content 的 TextView

        data.addProperty("magos1", "uOU");//adapter 父类中获取 getObject 的第一步
        data.addProperty("magos2", "uMW");//adapter 父类中获取 getObject 的第二步
        data.addProperty("magos3", "yQ");//adapter 父类中获取 getObject 的第三步

        data.addProperty("ctl", "com.tencent.mm.sdk.platformtools.w");//微信的日志打印类

        data.addProperty("dsa", "sk");//返回 drawable
        data.addProperty("dss", "ao1");//设置 drawable
        data.addProperty("dsca", "v0");//群头像的 drawable

        data.addProperty("vmbc", "wcR");//adapter 中获取 item 的 content 字段
        data.addProperty("vmbn", "nickName");//adapter 中获取 item 的 nickName 字段

        data.addProperty("vmbt", "wcQ");//adapter 中获取 item 的 time 字段

        data.addProperty("mmtc", "b");//adapter 中获取 item 的 content 方法
        data.addProperty("vmtcp", "wcX");//adapter 中获取 item 的 content 方法中的参数
        data.addProperty("mmtt", "i");//adapter 中获取 item 的 time 方法

        data.addProperty("csa", "com.tencent.mm.pluginsdk.ui.a$b");//头像的处理生成方法
        data.addProperty("mclga", "a");//adapter 中获取 item 的 avatar 方法

        data.addProperty("vmsio1", "wcY");//判断一个 item 是否为公众号的依据1
        data.addProperty("vmsio2", "wcU");//判断一个 item 是否为公众号的依据2
        data.addProperty("vmsio3", "field_username");//判断一个 item 是否为公众号的依据3

        data.addProperty("mclvap", "com.tencent.mm.ui.e$a");//adapter 构造函数的参数

        data.addProperty("cthu", "com.tencent.mm.ui.HomeUI");
        data.addProperty("mhuiv", "af");//HomeUI 中初始化 View 的方法
        data.addProperty("vhua", "uQy");//HomeUI 中 Activity 的变量名
    }

    private void getConfig1100(JsonObject data) {
        data.addProperty("cclvan", "com.tencent.mm.ui.conversation.g");
        data.addProperty("cclvapn", "com.tencent.mm.ui.e");
        data.addProperty("cclaon", "com.tencent.mm.ui.conversation.e");

        data.addProperty("cclvas", "g");
        data.addProperty("cclvaps", "e");

        data.addProperty("mmsb", "j");
        data.addProperty("mago", "yL");

        data.addProperty("vmsim1", "waz");
        data.addProperty("vmsim2", "vAw");
        data.addProperty("vla", "vZM");
        data.addProperty("vl", "vZj");

        data.addProperty("vlavt", "vtJ");
        data.addProperty("vlava", "ipb");
        data.addProperty("vlavc", "vtL");

        data.addProperty("magos1", "uMR");
        data.addProperty("magos2", "uKT");
        data.addProperty("magos3", "yL");


        data.addProperty("ctl", "com.tencent.mm.sdk.platformtools.v");

        data.addProperty("dsa", "sk");
        data.addProperty("dss", "ao1");
        data.addProperty("dsca", "v0");

        data.addProperty("vmbc", "war");
        data.addProperty("vmbn", "nickName");

        data.addProperty("vmbt", "waq");

        data.addProperty("mmtc", "b");
        data.addProperty("vmtcp", "wax");
        data.addProperty("mmtt", "i");

        data.addProperty("csa", "com.tencent.mm.pluginsdk.ui.a$b");
        data.addProperty("mclga", "a");

        data.addProperty("vmsio1", "way");
        data.addProperty("vmsio2", "wau");
        data.addProperty("vmsio3", "field_username");

        data.addProperty("mclvap", "com.tencent.mm.ui.e$a");

        data.addProperty("cthu", "com.tencent.mm.ui.HomeUI");
        data.addProperty("mhuiv", "af");
        data.addProperty("vhua", "uOv");
    }

    private void getConfig1081playVersion(JsonObject data) {
        data.addProperty("cclvan", "com.tencent.mm.ui.conversation.g");
        data.addProperty("cclvapn", "com.tencent.mm.ui.e");
        data.addProperty("cclaon", "com.tencent.mm.ui.conversation.e");

        data.addProperty("cclvas", "g");
        data.addProperty("cclvaps", "e");

        data.addProperty("mmsb", "j");
        data.addProperty("mago", "yQ");

        data.addProperty("vmsim1", "wcy");
        data.addProperty("vmsim2", "vCm");
        data.addProperty("vla", "wbL");
        data.addProperty("vl", "wbi");

        data.addProperty("vlavt", "vvy");
        data.addProperty("vlava", "ipv");
        data.addProperty("vlavc", "vvA");

        data.addProperty("magos1", "uOG");
        data.addProperty("magos2", "uMI");
        data.addProperty("magos3", "yQ");

        data.addProperty("ctl", "com.tencent.mm.sdk.platformtools.w");
        data.addProperty("dsa", "sk");
        data.addProperty("dss", "ao1");
        data.addProperty("dsca", "v0");

        data.addProperty("vmbc", "wcq");
        data.addProperty("vmbn", "nickName");

        data.addProperty("vmbt", "wcp");

        data.addProperty("mmtc", "b");
        data.addProperty("vmtcp", "wcw");
        data.addProperty("mmtt", "i");

        data.addProperty("csa", "com.tencent.mm.pluginsdk.ui.a$b");
        data.addProperty("mclga", "a");

        data.addProperty("vmsio1", "wcx");
        data.addProperty("vmsio2", "wct");
        data.addProperty("vmsio3", "field_username");

        data.addProperty("mclvap", "com.tencent.mm.ui.e$a");

        data.addProperty("cthu", "com.tencent.mm.ui.HomeUI");
        data.addProperty("mhuiv", "af");
        data.addProperty("vhua", "uQk");
    }

    private void getConfig1080playVersion(JsonObject data) {
        data.addProperty("cclvan", "com.tencent.mm.ui.conversation.g");
        data.addProperty("cclvapn", "com.tencent.mm.ui.e");
        data.addProperty("cclaon", "com.tencent.mm.ui.conversation.e");

        data.addProperty("cclvas", "g");
        data.addProperty("cclvaps", "e");

        data.addProperty("mmsb", "j");
        data.addProperty("mago", "yA");

        data.addProperty("vmsim1", "vJt");
        data.addProperty("vmsim2", "vjC");
        data.addProperty("vla", "vIG");
        data.addProperty("vl", "vId");

        data.addProperty("vlavt", "vda");
        data.addProperty("vlava", "iAJ");
        data.addProperty("vlavc", "vdc");

        data.addProperty("magos1", "uwz");
        data.addProperty("magos2", "uuA");
        data.addProperty("magos3", "yA");

        data.addProperty("ctl", "com.tencent.mm.sdk.platformtools.v");

        data.addProperty("dsa", "sb");
        data.addProperty("dss", "ao8");
        data.addProperty("dsca", "v2");

        data.addProperty("vmbc", "vJl");
        data.addProperty("vmbn", "nickName");
        data.addProperty("vmbt", "vJk");

        data.addProperty("mmtc", "b");
        data.addProperty("vmtcp", "vJr");
        data.addProperty("mmtt", "i");

        data.addProperty("csa", "com.tencent.mm.pluginsdk.ui.a$b");
        data.addProperty("mclga", "h");

        data.addProperty("vmsio1", "vJs");
        data.addProperty("vmsio2", "vJo");
        data.addProperty("vmsio3", "field_username");

        data.addProperty("mclvap", "com.tencent.mm.ui.e$a");

        data.addProperty("cthu", "com.tencent.mm.ui.HomeUI");
        data.addProperty("mhuiv", "af");
        data.addProperty("vhua", "uyd");
    }

    private void getConfig1080(JsonObject data) {
        data.addProperty("cclvan", "com.tencent.mm.ui.conversation.g");
        data.addProperty("cclvapn", "com.tencent.mm.ui.e");
        data.addProperty("cclaon", "com.tencent.mm.ui.conversation.e");

        data.addProperty("cclvas", "g");
        data.addProperty("cclvaps", "e");

        data.addProperty("mmsb", "j");
        data.addProperty("mago", "yv");

        data.addProperty("vmsim1", "vIL");
        data.addProperty("vmsim2", "viW");
        data.addProperty("vla", "vHY");
        data.addProperty("vl", "vHv");

        data.addProperty("vlavt", "vcu");
        data.addProperty("vlava", "iAt");
        data.addProperty("vlavc", "vcw");

        data.addProperty("magos1", "uvS");
        data.addProperty("magos2", "utT");
        data.addProperty("magos3", "yv");

        data.addProperty("ctl", "com.tencent.mm.sdk.platformtools.v");

        data.addProperty("dsa", "sb");
        data.addProperty("dss", "ao8");
        data.addProperty("dsca", "v2");

        data.addProperty("vmbc", "vID");
        data.addProperty("vmbn", "nickName");

        data.addProperty("vmbt", "vIC");

        data.addProperty("mmtc", "b");
        data.addProperty("vmtcp", "vIJ");
        data.addProperty("mmtt", "i");

        data.addProperty("csa", "com.tencent.mm.pluginsdk.ui.a$b");
        data.addProperty("mclga", "h");

        data.addProperty("vmsio1", "vIK");
        data.addProperty("vmsio2", "vIG");
        data.addProperty("vmsio3", "field_username");

        data.addProperty("mclvap", "com.tencent.mm.ui.e$a");

        data.addProperty("cthu", "com.tencent.mm.ui.HomeUI");
        data.addProperty("mhuiv", "af");
        data.addProperty("vhua", "uxw");
    }

    private void getConfig1060playVersion(JsonObject data) {
        data.addProperty("cclvan", "com.tencent.mm.ui.conversation.g");
        data.addProperty("cclvapn", "com.tencent.mm.ui.e");
        data.addProperty("cclaon", "com.tencent.mm.ui.conversation.e");

        data.addProperty("cclvas", "g");
        data.addProperty("cclvaps", "e");

        data.addProperty("mmsb", "j");
        data.addProperty("mago", "ew");

        data.addProperty("vmsim1", "uAO");
        data.addProperty("vmsim2", "vaf");
        data.addProperty("vla", "uZs");
        data.addProperty("vl", "uYP");

        data.addProperty("vlavt", "uup");
        data.addProperty("vlava", "iyA");
        data.addProperty("vlavc", "uur");

        data.addProperty("magos1", "tOb");
        data.addProperty("magos2", "hdN");
        data.addProperty("magos3", "ew");

        data.addProperty("ctl", "com.tencent.mm.sdk.platformtools.v");

        data.addProperty("dsa", "rj");
        data.addProperty("dss", "ang");
        data.addProperty("dsca", "u_");

        data.addProperty("vmbc", "uZX");
        data.addProperty("vmbn", "nickName");
        data.addProperty("vmbt", "uZW");

        data.addProperty("mmtc", "b");
        data.addProperty("vmtcp", "vad");
        data.addProperty("mmtt", "i");

        data.addProperty("csa", "com.tencent.mm.pluginsdk.ui.a$b");
        data.addProperty("mclga", "h");

        data.addProperty("vmsio1", "vae");
        data.addProperty("vmsio2", "vaa");
        data.addProperty("vmsio3", "field_username");

        data.addProperty("mclvap", "com.tencent.mm.ui.e$a");

        data.addProperty("cthu", "com.tencent.mm.ui.HomeUI");
        data.addProperty("mhuiv", "ad");
        data.addProperty("vhua", "tPE");
    }

    private void getConfig1060(JsonObject data) {
        data.addProperty("cclvan", "com.tencent.mm.ui.conversation.g");
        data.addProperty("cclvapn", "com.tencent.mm.ui.e");
        data.addProperty("cclaon", "com.tencent.mm.ui.conversation.e");

        data.addProperty("cclvas", "g");
        data.addProperty("cclvaps", "e");

        data.addProperty("mmsb", "j");
        data.addProperty("mago", "ev");

        data.addProperty("vmsim1", "uyI");
        data.addProperty("vmsim2", "uXX");
        data.addProperty("vla", "uXk");
        data.addProperty("vl", "uWH");

        data.addProperty("vlavt", "usj");
        data.addProperty("vlava", "iym");
        data.addProperty("vlavc", "usl");

        data.addProperty("magos1", "tMb");
        data.addProperty("magos2", "hdB");
        data.addProperty("magos3", "ev");

        data.addProperty("ctl", "com.tencent.mm.sdk.platformtools.v");
        data.addProperty("dsa", "rj");
        data.addProperty("dss", "ang");
        data.addProperty("dsca", "u_");

        data.addProperty("vmbc", "uXP");
        data.addProperty("vmbn", "nickName");
        data.addProperty("vmbt", "uXO");

        data.addProperty("mmtc", "b");
        data.addProperty("vmtcp", "uXV");
        data.addProperty("mmtt", "i");

        data.addProperty("csa", "com.tencent.mm.pluginsdk.ui.a$b");
        data.addProperty("mclga", "h");

        data.addProperty("vmsio1", "uXW");
        data.addProperty("vmsio2", "uXS");
        data.addProperty("vmsio3", "field_username");

        data.addProperty("mclvap", "com.tencent.mm.ui.e$a");

        data.addProperty("cthu", "com.tencent.mm.ui.HomeUI");
        data.addProperty("mhuiv", "ad");
        data.addProperty("vhua", "tNB");
    }

}
