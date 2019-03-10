package start;
//
//import com.rabbitmq.client.BuiltinExchangeType;
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
public class ReceiveLogs {
//    private static final String EXCHANGE_NAME = "logs";
//    private String message;
//    private  static Channel channel;
//    private  static Connection connection;
//    public void startLogs() throws IOException, TimeoutException {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("localhost");
//        connection = factory.newConnection();
//        channel = connection.createChannel();
//
//        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
//    }
//    public static void sendMessage(String messageToSend) throws IOException {
//        channel.basicPublish(EXCHANGE_NAME, "", null, messageToSend.getBytes("UTF-8"));
//        System.out.println(" [x] Sent '" + messageToSend + "'");
//    }
//    public static void closeConection() throws IOException, TimeoutException {
//        channel.close();
//        connection.close();
//    }
}
