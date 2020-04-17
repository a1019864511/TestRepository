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
public class Recv2 {
    private final static String QUEUE_NAME = "test_queue_work2";
    private final static String EXCHANGE_NAME = "test_exchange_fanout";
    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ClassUtils.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare( QUEUE_NAME, false, false, false, null );
        //绑定队列到服务器
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
        //同一时刻服务器只会发一条消息给消费者
        channel.basicQos( 1 );

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer( channel );
        // 监听队列，false表示手动返回完成状态，true表示自动
        channel.basicConsume( QUEUE_NAME, false, consumer );
        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String( delivery.getBody() );
            System.out.println( " [x] Received '" + message + "'" );
            // 休眠1秒
            Thread.sleep( 1000 );
            //下面这行注释掉表示使用自动确认模式
            //反馈消息的消费状态
            channel.basicAck( delivery.getEnvelope().getDeliveryTag(), false );
            System.out.println("消息消费转态"+ delivery.getEnvelope().getDeliveryTag());
        }
    }

}
