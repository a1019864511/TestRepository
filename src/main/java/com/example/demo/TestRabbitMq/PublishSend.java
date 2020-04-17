package com.example.demo.TestRabbitMq;

import com.example.demo.utils.ClassUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * RABBITMQ订阅模式服务发送器
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/4/16
 */
public class PublishSend {
    private final static String EXCHANGE_NAME="test_exchange_fanout";

    public static void main(String[] args) throws Exception {
        //获取连接以及MQ通道
        Connection connection = ClassUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明交换机
        //
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        String message ="Hello World";
        channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();

    }
}

