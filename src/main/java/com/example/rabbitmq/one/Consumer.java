package com.example.rabbitmq.one;

import com.example.rabbitmq.rabbitmqUtil.RabbitMqUtil;
import com.rabbitmq.client.*;

//消费者
public class Consumer {
        //队列名称
        public static final String QUEUE_NAME="hello";

    public static void main(String[] args) throws Exception {
        //ConnectionFactory factory = new ConnectionFactory();
        //factory.setUsername("guest");
        //factory.setPassword("guest");
        //Connection connection = factory.newConnection();
        //Channel channel = connection.createChannel();
        Channel channel = RabbitMqUtil.getChannel();

        //声明 接受消息
        DeliverCallback deliverCallback=(var1,var2) ->{
            System.out.println(new String(var2.getBody()));
        };

        //取消消息的回调
        CancelCallback cancelCallback=(var1) ->{
            System.out.println("消息消费中断");
        };
        //消费哪个队列
        //消费成功后是否要自动应答
        //消费者未成功消费的回调
        //消费这取消消费的回调
        channel.basicConsume(QUEUE_NAME,deliverCallback,cancelCallback);
    }

}
