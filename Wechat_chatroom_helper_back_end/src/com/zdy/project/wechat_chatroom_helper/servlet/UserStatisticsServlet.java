package com.zdy.project.wechat_chatroom_helper.servlet;

import com.zdy.project.wechat_chatroom_helper.db.DataBaseManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Mr.Zdy on 2017/9/24.
 */
public class UserStatisticsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String action = req.getParameter("action");
        String uuidCode = req.getParameter("uuidCode");
        String model = req.getParameter("model");
        String version = req.getParameter("version");
        String wechat_version = req.getParameter("wechat_version");

        if (version == null)
            version = "< 16";
        if (wechat_version == null)
            wechat_version = "-1";


       // if (action.equals("open") || action.equals("close"))
            DataBaseManager.getInstance().insertUserStatisticsData(uuidCode, model, action, version, wechat_version);

        writer.write("感谢每个用户，给了我很多自信以至于我不觉得自己是一个废柴。。");
    }
}
