package start;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import entity.DigitalVideoDisc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

public class ClientStart {

	private static final String EXCHANGE_NAME = "logs";
	private String message;
	private  static Channel channel;
	private  static Connection connection;
	private  static ConnectionFactory factory;
	public  static void main(String [] args) throws Exception {



//		DigitalVideoDisc dvd  = new DigitalVideoDisc("first", 2011,14.1);
//		DigitalVideoDisc dvd2  = new DigitalVideoDisc("second", 2014,7.7);
//		String messageToSend = "?" + dvd.getTitle() + "#" + dvd.getYear() + "#" + dvd.getPrice();
//		String messageToSend2 = "?" + dvd2.getTitle() + "#" + dvd2.getYear() + "#" + dvd2.getPrice();
//		//String message = getMessage(argv5);
//		//String message = getMessage(argv5);
//		channel.basicPublish(EXCHANGE_NAME, "", null, messageToSend.getBytes("UTF-8"));
//		System.out.println(" [x] Sent '" + messageToSend + "'");
//		channel.basicPublish(EXCHANGE_NAME, "", null, messageToSend2.getBytes("UTF-8"));

		//System.out.println(" [x] Sent '" + messageToSend2 + "'");

	}
	public static void makeConnection( ) throws IOException, TimeoutException {
		factory = new ConnectionFactory();
		factory.setHost("localhost");
		connection = factory.newConnection();
		channel = connection.createChannel();
	}

	public static void sendMessage(String messageToSend) throws IOException {
		//System.out.println("messagetosend: " + messageToSend);
		channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
		channel.basicPublish(EXCHANGE_NAME, "", null, messageToSend.getBytes("UTF-8"));
		System.out.println(" [x] Sent '" + messageToSend + "'");
	}
	public static void closeConection() throws IOException, TimeoutException {
		channel.close();
		connection.close();
	}

	private static String getMessage(String[] strings){
		if (strings.length < 1)
			return "info: Hello World!";
		return joinStrings(strings, " ");
	}

	private static String joinStrings(String[] strings, String delimiter) {
		int length = strings.length;
		if (length == 0) return "";
		StringBuilder words = new StringBuilder(strings[0]);
		for (int i = 1; i < length; i++) {
			words.append(delimiter).append(strings[i]);
		}
		return words.toString();
	}
}