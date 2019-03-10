package com.a3_2;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class A32Application {

	public static void main(String[] args) {
		SpringApplication.run(A32Application.class, args);
		String queueName="logs";
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			channel.exchangeDeclare(queueName, "fanout");
			channel.close();
			connection.close();
		}catch (Exception e){
			System.out.println("EROARE LA CONEXIUNE !!!!");
		}

	}
}
