package top.lover.hyperlink.util;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author qinrq
 */
public class HtmlUtil {
    /**
     * 处理页面详情.
     * */
    public static Document getElement(String url)  {
        Connection conn = Jsoup.connect(url);
        conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        conn.header("Accept-Encoding", "gzip, deflate, sdch");
        conn.header("Accept-Language", "zh-CN,zh;q=0.8");
        conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
        Document doc = null;
        try{
            doc = conn.get();
        }catch (IOException iOException){
            System.out.println("报错了:"+iOException);
        }
        return doc;
    }
}
