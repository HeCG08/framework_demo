package cn.rumoss.fw.mongodb;

import cn.rumoss.fw.mongodb.pojo.Spit;
import com.mongodb.client.result.UpdateResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MongoSpringTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testQuery(){

        // 查询userid等于1的
        Query query = Query.query(Criteria.where("userid").is("1"));
        List<Spit> spits = mongoTemplate.find(query,Spit.class,"spit");
        System.out.println(spits);

    }

    @Test
    public void testUpdate(){

       // 查询userid等于1的
        Query query = Query.query(Criteria.where("userid").is("1"));
        Update update = new Update();
        update.inc("visits",1000);
        UpdateResult result = mongoTemplate.updateFirst(query,update,"spit");
        // AcknowledgedUpdateResult{matchedCount=1, modifiedCount=1, upsertedId=null}
        System.out.println(result);

    }

    @Test
    public void testInsert(){

        Spit spit = new Spit();
        spit.set_id("123456");// 主键
        spit.setPublishtime(new Date());// 发布日期
        spit.setVisits(666);// 浏览量
        spit.setShare(666);// 分享数
        spit.setThumbup(666);// 点赞数
        spit.setComment(666);// 回复数
        spit.setState("2");// 状态
        mongoTemplate.save(spit);

    }

}
