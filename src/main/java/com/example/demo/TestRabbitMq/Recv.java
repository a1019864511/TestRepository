package com.example.demo.TestRabbitMq;

import com.example.demo.utils.ClassUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/4/15
 */
public class Recv {
    private final static String QUEUE_NAME = "test_queue_work1";
    private final static String EXCHANGE_NAME = "test_exchange_fanout";
    public static void main(String[] args) throws Exception {
        //获取到连接以及MQ通道
        Connection connection = ClassUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare( QUEUE_NAME, false, false, false, null );
        //同一时刻 服务器只会发一条消息 给消费者
       channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
        channel.basicQos( 1 );
        //定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer( channel );
        //监听队列，false表示手动返回完成状态，true表示自动
        channel.basicConsume( QUEUE_NAME, false, consumer );
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String( delivery.getBody() );
            System.out.println( " [y] Received '" + message + "'" );
            //休眠
            Thread.sleep( 10 );
            //手动返回确认信息
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
            System.out.println("消息消费转态"+ delivery.getEnvelope().getDeliveryTag());
        }


    }
}
