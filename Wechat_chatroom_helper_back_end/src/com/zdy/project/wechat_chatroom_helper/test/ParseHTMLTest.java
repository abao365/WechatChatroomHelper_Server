package com.zdy.project.wechat_chatroom_helper.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by zhudo on 2017/12/11.
 */
public class ParseHTMLTest {

    public static void main(String[] args) {


        try {
            Document doc = Jsoup.connect("http://weixin.qq.com/cgi-bin/readtemplate?lang=zh_CN&t=weixin_faq_list").get();

            Element page_faq_list = doc.getElementsByClass("page_faq_list").get(0);


            Tag tag = page_faq_list.tag();

            Element ul = page_faq_list.children().tagName("ul").get(5);

            ul.toString();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
