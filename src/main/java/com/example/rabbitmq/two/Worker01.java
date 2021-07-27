package com.example.rabbitmq.two;

import com.example.rabbitmq.rabbitmqUtil.RabbitMqUtil;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

//这是一个工作线程
public class Worker01 {
    private static final  String QUEUE_NAME="hello";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtil.getChannel();



        DeliverCallback deliverCallback=(var1,var2)->{
            String s = new String(var2.getBody());
            System.out.println("接受的消息 = " + s);
        };
        CancelCallback cancelCallback = (var1)->{
            System.out.println(var1+"消费者取消消费接口回调逻辑");
        };

        System.out.println("c1等待接受消息.......");
        channel.basicConsume(QUEUE_NAME,deliverCallback,cancelCallback);

    }
}
