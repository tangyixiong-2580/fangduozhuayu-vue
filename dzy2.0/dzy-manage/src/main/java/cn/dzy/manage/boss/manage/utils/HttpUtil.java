package cn.dzy.manage.boss.manage.utils;

import cn.dzy.manage.boss.manage.bean.book.Book;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Slf4j
public class HttpUtil {

    public static String client(String url) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.getForEntity(url, String.class);
        return response.getBody();
    }

    public static Book clientUrl(String url){
        RestTemplate template = new RestTemplate();

        try{
            ResponseEntity<String> response = template.getForEntity(url, String.class);
            String str = response.getBody();
            JSONObject json = JSONObject.fromObject(str);
            Integer code = json.getInt("code");
            if (code == 0) {
                JSONObject bookResult = json.optJSONObject("data");
                String title = bookResult.getString("title");
                String isbn13 = bookResult.getString("isbn13");
                String isbn10 = bookResult.getString("isbn10");
                String price = bookResult.getString("price");
                String binding = bookResult.getString("binding");
                String publisher = bookResult.getString("publisher");
                String pubdate = bookResult.getString("pubdate");
                String summary = bookResult.getString("summary");
                String pic = bookResult.getString("image");
                JSONArray author = bookResult.getJSONArray("author");
                JSONObject rating = bookResult.optJSONObject("rating");
                String authors = StringUtils.join(author.toArray(), "/");
                String score = rating.getString("average");
/*
                // todo:分类
                JSONArray tags = bookResult.getJSONArray("tags");
                List<Classify> cf = JSONArray.toList(tags, new Classify(), new JsonConfig());
                System.out.println(cf);
*/
//                price = price.substring(0,price.length()-1);

                Pattern pattern = Pattern.compile("(\\d+(\\.\\d+)?)");
                Matcher matcher = pattern.matcher(price);
                if (matcher.find()) {
                    price = matcher.group(1);
                }
                Book book = new Book();
                book.setTitle(title);
                book.setBinding(binding);
                book.setPic(pic);
                book.setAuthor(authors);
                book.setIsbn13(isbn13);
                book.setIsbn10(isbn10);
                book.setScore(score);
                book.setPrice(price);
                book.setPubdate(pubdate);
                book.setPublisher(publisher);
                book.setSummary(summary);
                return book;
            }
            log.warn("远程数据异常 - >" + code);
        } catch (Exception e) {
            MDC.put( "远程服务器存在问题 -> ", url);
            log.error("远程服务器存在问题" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}