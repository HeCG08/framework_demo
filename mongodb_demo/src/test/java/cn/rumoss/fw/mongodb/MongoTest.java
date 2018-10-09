package cn.rumoss.fw.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BasicBSONObject;
import org.bson.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Mongo Java操作入门
 */
public class MongoTest {

    public static void main(String[] args) {

        // 1.创建连接
        MongoClient client = new MongoClient("192.168.195.136");
        //  2.打开数据库
        MongoDatabase database = client.getDatabase("spitdb");
        // 3.获取集合(表)
        MongoCollection<Document> spit = database.getCollection("spit");

        // 4.1查询记录
        FindIterable<Document> documents = spit.find();// 全量查询
        // 构建查询条件
        BasicDBObject bson = new BasicDBObject("userid","1");
        // 查询浏览量大于902的
        bson = new BasicDBObject("visits",new BasicBSONObject("$gt",665));
        documents = spit.find(bson);// 条件查询

        // 遍历打印
        for(Document document: documents){
            System.out.print("内容： " + document.getString("content"));
            System.out.print(", 用户ID： " + document.getString("userid"));
            System.out.println(", 浏览量： " + document.getInteger("visits"));
        }

        // 4.2 插入数据
        Map<String,Object> map = new HashMap<>();
        map.put("content","试着Java插入一条数据试试~");
        map.put("userid","1");
        map.put("visits",999);
        map.put("publish",new Date());
        // 使用Map构造Document
        Document document = new Document(map);
        // 4.2.1 插入数据
        spit.insertOne(document);

        // 5.关闭连接
        client.close();

    }

}
