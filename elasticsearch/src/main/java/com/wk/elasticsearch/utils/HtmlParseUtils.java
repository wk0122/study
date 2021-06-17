package com.wk.elasticsearch.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author wangkang
 * @Date 2021/6/2 17:32
 */
public class HtmlParseUtils {
    public static void main(String[] args) throws IOException {
        //从京东搜索页面爬数据
        String url = "https://search.jd.com/Search?keyword=java";
        Document document = Jsoup.parse(new URL(url), 30000);
        Element element = document.getElementById("J_goodsList");
        Elements li = element.getElementsByTag("li");
        for (Element element1 : li){
            String img = element1.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = element1.getElementsByClass("p-price").eq(0).text();
            System.out.println("========");
            System.out.println(img);
            System.out.println(price);
        }
    }

}
