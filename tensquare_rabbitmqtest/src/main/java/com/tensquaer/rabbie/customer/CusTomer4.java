package com.tensquaer.rabbie.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author liuhuan
 * @date
 * @描述 消费者
 */
@Component
@RabbitListener(queues = "xiaomi")
public class CusTomer4 {

    @RabbitHandler
    public void getMsg(String mag){
        System.out.println("xiaom分列模式消费消息>>>>"+mag);
    }
}
