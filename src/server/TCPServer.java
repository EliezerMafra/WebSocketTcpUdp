package server;

import java.io.*;
import java.net.*;


class TCPServer {
    public static void main( String argv[]) throws Exception
    {
        String comando;

        ServerSocket welcomeSocket = new ServerSocket(6789);

        while (true) {
            System.out.println("Iniciando conexão e aguardando cliente");
            Socket connectionSocket = welcomeSocket.accept();
            System.out.println("Conexão estabelecida");
            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(
                            connectionSocket.getInputStream()
                    )
            );
            DataOutputStream outToClient = new DataOutputStream(
                    connectionSocket.getOutputStream()
            );
            System.out.println("Aguardando pacote de dados do cliente");
            comando = inFromClient.readLine();
            System.out.println("Pacote recebido");
            //tratar comando------------------------------------------------------
            System.out.println("Comando: " + comando + " recebido");

            String status = "Mensagem de sucesso ou erro";

            outToClient.writeBytes(status);
            connectionSocket.close();
            System.out.println("Conexão Finalizada");
        }
    }
}