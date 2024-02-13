package TCP;

import java.net.*;
import java.io.*;

public class TCPClient {
    public static void main(String[] args) {
        Socket socket = null;
        
        try {
            // Adresse et port du serveur
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 12345;
            
            // Création d'un socket client TCP
            socket = new Socket(serverAddress, serverPort);
            
            // Flux d'écriture du message vers le serveur
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            // Message à envoyer au serveur
            String message = "Bonjour depuis le client!";
            
            // Envoi du message au serveur
            out.println(message);
            System.out.println("Message envoyé au serveur : " + message);
            
            // Fermeture des flux et du socket
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
