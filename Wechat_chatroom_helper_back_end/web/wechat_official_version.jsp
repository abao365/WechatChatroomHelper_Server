<%@ page import="org.jsoup.nodes.Document" %>
<%@ page import="org.jsoup.Jsoup" %>
<%@ page import="org.jsoup.nodes.Element" %>
<%@ page import="org.jsoup.parser.Tag" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: zhudo
  Date: 2017/12/11
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    try {
        Document doc = Jsoup.connect("http://weixin.qq.com/cgi-bin/readtemplate?lang=zh_CN&t=weixin_faq_list").get();

        Element page_faq_list = doc.getElementsByClass("page_faq_list").get(0);


        Tag tag = page_faq_list.tag();

        Element ul = page_faq_list.children().tagName("ul").get(5);

        out.println(ul.toString());

    } catch (IOException e) {
        e.printStackTrace();
    }
%>
</body>
</html>
