package cn.rumoss.fw.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MqTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage(){
        rabbitTemplate.convertAndSend("itcast","发个消息试试~");
    }

    @Test
    public void testSendFanoutMessage(){
        rabbitTemplate.convertAndSend("chuanzhi","","发个分列模式的消息试试~");
    }

    @Test
    public void testSendTopic1(){
        rabbitTemplate.convertAndSend("topictest","goods.aaa","主题模式：goods.aaa~");
    }

    @Test
    public void testSendTopic2(){
        rabbitTemplate.convertAndSend("topictest","article.content.log","主题模式：article.content.log~");
    }

    @Test
    public void testSendTopic3(){
        rabbitTemplate.convertAndSend("topictest","goods.log","主题模式：goods.log~");
    }

}
