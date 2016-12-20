package com.gyf.gyf.Utils;

import com.gyf.googleplay.utils.LogUtils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/10/27.
 */
public class HttpUtil {
    /**
     * 执行get请求，返回json字符串
     * @param url
     * @return
     */
    public static String get(String url){
        String result = "";
        HttpClient httpClient = new DefaultHttpClient();
        LogUtils.d("HttpUtil","请求的Url" + url);
        HttpGet httpGet = new HttpGet(url);
            try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if(httpResponse.getStatusLine().getStatusCode() == 200){
                HttpEntity entity = httpResponse.getEntity();//获取响应体
                InputStream is = entity.getContent();//获取输入流
                ByteArrayOutputStream  baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];//1k的缓存区
                int len = -1;
                while ((len = is.read(buffer))!=-1){
                    baos.write(buffer, 0, len);
                }

                is.close();;
                httpClient.getConnectionManager().closeExpiredConnections();//关闭闲置的链接，释放资源
                result = new String(baos.toByteArray(), "UTF-8");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        LogUtils.d("HttpUtil", "响应的数据："+result);
        return result;
    }
}
