package com.tensquaer.rabbie.customer;

import com.aliyuncs.exceptions.ClientException;
import com.tensquaer.rabbie.utils.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author liuhuan
 * @date
 * @描述 消费者
 */
@Component
@RabbitListener(queues = "sms")
public class CusTomerSms {

    @Autowired
    private SmsUtil smsUtil;
    @Value("${aliyun.sms.template_code}")
    private String template_code;
    @Value("${aliyun.sms.sign_name}")
    private String sign_name;

    @RabbitHandler
    public void getMsg(Map<String,Object> map){
        String mobile = (String) map.get("mobile");
        String checkcode = (String) map.get("checkcode");
        String name = (String) map.get("name");
        System.out.println("手机号>>>>"+map.get("mobile"));
        System.out.println("验证码>>>>"+map.get("checkcode"));

        try {
            smsUtil.sendSms(mobile,template_code,sign_name,"{\"code\":\""+checkcode+"\"}");
            //smsUtil.sendSms(mobile,template_code,sign_name,"{\"name\":\""+name+"\",\"code\":\""+checkcode+"\"}");
            //smsUtil.sendSms(mobile,template_code,sign_name,"{\"name\":\""+name+"\", \"code\":\""+checkcode+"\"}");
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }
}
