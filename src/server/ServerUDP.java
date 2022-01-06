package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerUDP {

    public static void main(String args[]) throws Exception {

        int porta = 9876;
        int numConn = 1;

        DatagramSocket serverSocket = new DatagramSocket(porta);

        byte[] receiveData = new byte[10];
        byte[] sendData = new byte[1024];

        double saldoBanco = 5000;

        while (true) {
            saldoBanco += 50;

            String saldoBancoString = String.valueOf(saldoBanco);
            saldoBancoString += ";";

            DatagramPacket receivePacket = new DatagramPacket(receiveData,
                    receiveData.length);

            serverSocket.receive(receivePacket);

            InetAddress IPAddress = receivePacket.getAddress();

            int port = receivePacket.getPort();

            sendData = saldoBancoString.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData,
                    sendData.length, IPAddress, port);

            serverSocket.send(sendPacket);
        }
    }
}
