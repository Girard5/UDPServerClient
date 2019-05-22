import java.io.*;
import java.net.*;

public class UDPClient {

    public static void main(String args[]){
        DatagramSocket socket = null;
        int port = 5432;
        String clientMessage;

        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

        try{
            socket = new DatagramSocket(5433);

            InetAddress host = InetAddress.getLocalHost();

                System.out.println("Enter message to send: ");
                clientMessage = cin.readLine();
                byte[] buff = clientMessage.getBytes();

                DatagramPacket packet = new DatagramPacket(buff, buff.length, host, port);
                socket.send(packet);

                byte[] buff2 = new byte[1024];
                DatagramPacket replyFromServer = new DatagramPacket(buff2, buff2.length);
                socket.receive((replyFromServer));

                byte[] output = replyFromServer.getData();
                clientMessage = new String(output, 0, replyFromServer.getLength());

                System.out.println(clientMessage);
        }

        catch(IOException e){
            e.printStackTrace();
        }
    }


}
