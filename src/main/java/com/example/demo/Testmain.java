package com.example.demo;

import com.example.demo.utils.ClassUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;


/**
 * rabbitmq发送消息
 *
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/3/19
 */
public class Testmain {
    private final static String QUEUE_NAME = "q_test_02";

    public static void main(String[] args) throws Exception {
        Connection connection = ClassUtils.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();

        // 声明（创建）队列
        channel.queueDeclare( QUEUE_NAME, false, false, false, null );

        // 消息内容
        String message = "这个消息已经发送完毕";
        channel.basicPublish( "", QUEUE_NAME, null, message.getBytes() );
        System.out.println( " [x] Sent '" + message + "'" );
        //关闭通道和连接
        channel.close();
        connection.close();

    }
}
