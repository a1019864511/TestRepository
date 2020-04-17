package com.example.demo.TestRabbitMq;

import com.example.demo.utils.ClassUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/4/15
 */
public class send {
    private final static String QUEUE_NAME = "test_queue_work";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ClassUtils.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare( QUEUE_NAME, false, false, false, null );

        for (int i = 0; i < 100; i++) {
            // 消息内容
            String message = "" + i;
            channel.basicPublish( "", QUEUE_NAME, null, message.getBytes() );
            System.out.println( " [x] Sent '" + message + "'" );

            Thread.sleep( i * 10 );
        }

        channel.close();
        connection.close();
    }
}



