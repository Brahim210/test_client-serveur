package TCP;

import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        
        try {
            // Création d'un socket serveur TCP sur le port 12345
            serverSocket = new ServerSocket(12345);
            
            System.out.println("Attente de connexion...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connecté.");
            
            // Flux de lecture du message du client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            // Lecture du message du client
            String message = in.readLine();
            System.out.println("Message reçu du client : " + message);
            
            // Fermeture des flux et des sockets
            in.close();
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

