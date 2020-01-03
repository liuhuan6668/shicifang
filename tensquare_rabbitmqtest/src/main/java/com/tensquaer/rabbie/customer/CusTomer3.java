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
@RabbitListener(queues = "dami")
public class CusTomer3 {

    @RabbitHandler
    public void getMsg(String mag){
        System.out.println("dami分列模式消费消息>>>>"+mag);
    }
}
