package client;

import java.io.*;
import java.net.*;

class TCPClient {

    public static void main(String argv[]) throws Exception {
        int porta = 6789;
        String servidor = "localhost";


        String comando;
        String modifiedSentence;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
                System.in));


        System.out.println("Conectando ao servidor " + servidor + ":" + porta);

        Socket clientSocket = new Socket(servidor, porta);

        DataOutputStream outToServer = new DataOutputStream(clientSocket
                .getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));

        System.out.println("Digite comando a ser enviado para o servidor");
        comando = inFromUser.readLine();

        outToServer.writeBytes(comando + '\n');

        modifiedSentence = inFromServer.readLine();

        System.out.println("Status: " + modifiedSentence);

        clientSocket.close();

    }
}