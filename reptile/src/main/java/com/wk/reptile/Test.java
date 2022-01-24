package com.wk.reptile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author wangkang
 * @Date 2022/1/7 09:58
 */
public class Test {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://sapa.szosc.cn/WechatApp/GetMermberInfo");
        httpGet.addHeader("User-Agent","Mozilla/5.0 (iPhone; CPU iPhone OS 11_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E217 MicroMessenger/6.8.0(0x16080000) NetType/WIFI Language/en Branch/Br_trunk MiniProgramEnv/Mac");
        httpGet.addHeader("Content-Type","application/json; charset=utf-8");
        httpGet.addHeader("token","yxfeud1diog1o4pev4v22yw5");
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            //4.判断状态码
            if(httpResponse.getStatusLine().getStatusCode()==200){
                HttpEntity entity = httpResponse.getEntity();
                //使用工具类EntityUtils，从响应中取出实体表示的内容并转换成字符串
                String string = EntityUtils.toString(entity, "utf-8");
                System.out.println(string);
                JSONObject jsonObject = JSONObject.parseObject(string);
                System.out.println(jsonObject);
                System.out.println(jsonObject.getString("data"));
//                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//                byte[] bytes = new byte[1024];
//                int len;
//                while ((len = entity.getContent().read(bytes)) != -1){
//                    outputStream.write(bytes,0,len);
//                }
            }
            //5.关闭资源
            httpGet.releaseConnection();
            httpResponse.close();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
