package com.javazk.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 9:59 2018/1/17
 * @Modified By:
 */
public class HttpClientTool {
    private static final Logger LOG = LogManager
            .getLogger(HttpClientTool.class.getName());

    public static String sendPostRequest(String url, String param) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" url:").append(url).append("==");
        stringBuilder.append(" param:").append(param);
        LOG.info("request ==> "+stringBuilder.toString());
        stringBuilder.setLength(0);

        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        httpclient = HttpClients.createDefault();
        try {

            HttpPost httpPost = new HttpPost(new URL(url).toURI());
            StringEntity dataEntity = new StringEntity(param, ContentType.APPLICATION_JSON);
            httpPost.setEntity(dataEntity);
            response = httpclient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        entity.getContent()));
                String tempStr;
                while ((tempStr = reader.readLine()) != null)
                    stringBuilder.append(tempStr);
            } else {
                LOG.error("=============http请求异常===="+response.getStatusLine().getStatusCode());
                return String.valueOf(response.getStatusLine().getStatusCode());
            }

        }catch(Exception e){
            LOG.error(e.getMessage(),e);
        } finally {
            try {
                if(response != null ){
                    response.close();
                }
                if(httpclient != null ){
                    httpclient.close();
                }
            } catch (IOException e) {
                LOG.error(e.getMessage(),e);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        sendPostRequest("", "");
    }

}
