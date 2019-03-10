package start;
import com.rabbitmq.client.*;
import service.MailService;
import service.PrintContentMessageService;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ClientStartC {
    private static final String EXCHANGE_NAME = "logs";

    public  static void  main(String [] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        File file = new File("../a3_2/consumer/intro.txt");
        Scanner sc = new Scanner(file);
        String email = sc.nextLine();
        System.out.println("email email "+ email);
        String password = sc.nextLine();
        //System.out.println("password password "+ password);

        //System.out.println(password);
        //while (sc.hasNextLine()){
        //	System.out.println(sc.nextLine());
        //}

        //String message;
         //pcs ;
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                PrintContentMessageService pcs = new PrintContentMessageService();
                System.out.println("Sending mail "+ message);
                String messageToEmail = "";
                File file = new File("../a3_2/consumer/intro.txt");
                Scanner sc = new Scanner(file);
                String email = sc.nextLine();
                System.out.println("email email "+ email);
                String password = sc.nextLine();
                MailService mailService = new MailService(email,password);
                if (message.charAt(0) == '?'){
                    int length = message.length();
                    String editedMessageToSend = message.substring(1,length );
                    System.out.println("editedMessageToSend: " + editedMessageToSend);
                    String segments[] = editedMessageToSend.split("#");
                    for(int i = 0; i < segments.length; i ++){
                        messageToEmail = messageToEmail + "       " + segments[i];
                    }
                    System.out.println("messageToEmail: " + messageToEmail);
                    mailService.sendMail("danbalus@gmail.com","DVD Mail ",messageToEmail);
                    pcs.setMessageToWrite(messageToEmail);
                    pcs.writeInText();


                }
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}