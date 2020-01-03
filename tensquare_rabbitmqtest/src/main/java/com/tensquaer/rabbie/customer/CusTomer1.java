package com.tensquaer.rabbie.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author liuhuan
 * @date
 * @描述 消费者
 */
@Component
@RabbitListener(queues = "test")
public class CusTomer1 {

   /* @RabbitHandler
    public void getMsg(String mag){
        System.out.println("直接模式消费消息>>>>"+mag);
    }*/

    @RabbitHandler
    public void getMsg(Map map){
        System.out.println("消费消息>>>>"+map.get("mobile"));
        System.out.println("消费消息>>>>"+map.get("checkcode"));
    }
}
