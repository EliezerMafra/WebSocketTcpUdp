package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

public class UDPClient {

    public static void main(String args[]) throws Exception {

        while (true){

            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
                    System.in));

            DatagramSocket clientSocket = new DatagramSocket();

            String servidor = "localhost";
            int porta = 9876;

            InetAddress IPAddress = InetAddress.getByName(servidor);

            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            sendData[0] = 1;

            DatagramPacket sendPacket = new DatagramPacket(sendData,
                    sendData.length, IPAddress, porta);

            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData,
                    receiveData.length);

            clientSocket.receive(receivePacket);

            String modifiedSentence = new String(receivePacket.getData()).split(";")[0];

            System.out.println("Texto recebido do servidor:" + modifiedSentence);

            clientSocket.close();

            TimeUnit.SECONDS.sleep(2);
        }

    }
}
