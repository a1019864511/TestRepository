package com.example.demo;

import com.example.demo.utils.ClassUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/4/14
 */
public class Recv {
    private final static String QUEUE_NAME = "q_test_02";
    public static void main(String[] args) throws  Exception{
        // 获取到连接以及mq通道
        Connection connection = ClassUtils.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);

        // 监听队列
        channel.basicConsume(QUEUE_NAME, true, consumer);

        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
        }


    }
}
