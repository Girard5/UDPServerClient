import java.io.*;
import java.net.*;


public class UDPServer {

    public static void main(String args[]){

        DatagramSocket socket = null;

        try{
            socket = new DatagramSocket(5432);

            byte[] buff = new byte[1024];
            DatagramPacket received = new DatagramPacket(buff,buff.length);

            while(true){
                socket.receive(received);
                byte[] data = received.getData();
                String inFromClient = new String(data, 0, received.getLength());

                inFromClient = inFromClient + " Mount Everest is covered in people that used to be extremely motivated." ;
                DatagramPacket outFromServer = new DatagramPacket(inFromClient.getBytes(), inFromClient.getBytes().length, received.getAddress(), received.getPort());
                socket.send(outFromServer);
            }

        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }



}
