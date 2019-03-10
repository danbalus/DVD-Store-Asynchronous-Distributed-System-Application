package service;

import java.io.FileWriter;
import java.io.IOException;

public class PrintContentMessageService {

    private String messageToWrite;
    private static int nrFile = 0 ;

    public void setMessageToWrite(String messageToWrite) {
        this.messageToWrite = messageToWrite;
    }

    public void writeInText(){
        //File file = new File("../assignment--three/consumer-client/intro.txt");
        //Scanner sc = new Scanner(file);
        try {
            FileWriter writer = new FileWriter("../a3_2/consumer/out" + nrFile + ".txt");
            writer.write("-------------------------------");
            writer.write("\r\n");   // write new line
            writer.write(messageToWrite);
            writer.close();
            nrFile++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
