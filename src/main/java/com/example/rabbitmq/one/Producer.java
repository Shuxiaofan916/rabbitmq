package com.example.rabbitmq.one;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

//创建生产者
public class Producer {
    //定义队列名词
     public static final String QUEUE_NAME="hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        //新建工厂对象
        ConnectionFactory factory = new ConnectionFactory();
        //设置ip端口
        //factory.setHost("http://localhost/");
        //用户名
        factory.setUsername("guest");
        factory.setPassword("guest");
        //创建链接
        Connection connection = factory.newConnection();
        //获得信道
        Channel channel1 = connection.createChannel();
        //信道创建队列
        channel1.queueDeclare(QUEUE_NAME,false,false,false,null);
        //发消息
        String message="hello world";

        channel1.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("消息发送完毕");


    }
}
