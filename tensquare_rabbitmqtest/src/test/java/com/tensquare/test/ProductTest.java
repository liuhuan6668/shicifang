package com.tensquare.test;

import com.tensquaer.rabbie.RabbitApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuhuan
 * @date 2019-12-25
 * @描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitApplication.class)
public class ProductTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 生产者直接
     */
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("test","333直接模式测试");
    }
    /**
     * 生产者分列
     */
    @Test
    public void sendMsg1(){
        rabbitTemplate.convertAndSend("ttt","","分列模式测试");
    }
    /**
     * 生产者主题
     */
    @Test
    public void sendMsg2(){
        rabbitTemplate.convertAndSend("zhuti","good.log","主题模式测试");
    }
}
