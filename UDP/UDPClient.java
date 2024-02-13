package UDP;

import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        
        try {
            // Création d'un socket UDP
            socket = new DatagramSocket();
            
            // Adresse et port du serveur
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9876;
            
            // Message à envoyer au serveur
            String message = "Bonjour depuis le client!";
            byte[] buffer = message.getBytes();
            
            // Création d'un datagramme contenant le message à envoyer
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, serverPort);
            
            // Envoi du datagramme
            socket.send(packet);
            
            System.out.println("Message envoyé au serveur.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
