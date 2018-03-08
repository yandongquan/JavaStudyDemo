package com.javakz;

import com.google.gson.JsonObject;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 11:23 2018/3/8
 * @Modified By:
 */

public class AddIndexTest {
    /**
     * 服务地址
     */
    private static String host = "192.168.0.113";
    /**
     * 端口
     */
    private static int port = 9300;
    private static TransportClient client = null;

    /**
     * 获取连接
     * @throws Exception
     */
    @Before
    public void getCient() throws Exception {
        client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host),port));
    }

    /**
     * 关闭连接
     */
    @After
    public void close() {
        if (client!=null) {
            client.close();
        }
    }

    /**
     * 添加索引
     * @throws Exception
     */
    @Test
    public void testIndex() throws Exception {
        IndexResponse response = client.prepareIndex("三国演义","book","122")
                .setSource(XContentFactory.jsonBuilder().startObject()
                .field("title","sanguo").field("price",100)
                .field("author","罗贯中").endObject()).get();
        System.out.println("索引名称："+response.getIndex());
        System.out.println("类型："+response.getType());
        // 第一次使用是1
        System.out.println("文档ID："+response.getId());
        System.out.println("当前实例状态："+response.status());
    }

    /**
     * 添加索引
     * @throws Exception
     */
    @Test
    public void testIndex2() throws Exception {
        String json = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2018-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        IndexResponse response = client.prepareIndex("weibo", "tweet")
                .setSource(json, XContentType.JSON).get();
        System.out.println("索引名称："+response.getIndex());
        System.out.println("类型："+response.getType());
        System.out.println("文档ID："+response.getId());
        System.out.println("当前实例状态："+response.status());
    }

    /**
     * 添加索引
     */
    @Test
    public void testIndex3()throws Exception{
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("user","kimchy");
        json.put("postDate",new Date());
        json.put("message","trying out Elasticsearch");
        IndexResponse response = client.prepareIndex("qq", "tweet")
                .setSource(json).get();
        System.out.println("索引名称："+response.getIndex());
        System.out.println("类型："+response.getType());
        System.out.println("文档ID："+response.getId());
        System.out.println("当前实例状态："+response.status());
    }

    /**
     * 添加索引
     */
    @Test
    public void testIndex4()throws Exception{
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("user", "kimchy");
        jsonObject.addProperty("postDate", "1989-11-11");
        jsonObject.addProperty("message", "trying out Elasticsearch");

        IndexResponse response = client.prepareIndex("qq", "tweet")
                .setSource(jsonObject.toString(),XContentType.JSON).get();
        System.out.println("索引名称："+response.getIndex());
        System.out.println("类型："+response.getType());
        System.out.println("文档ID："+response.getId());
        System.out.println("当前实例状态："+response.status());
    }
}
