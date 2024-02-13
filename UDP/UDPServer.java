package UDP;

import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        
        try {
            // Création d'un socket UDP sur le port 9876
            socket = new DatagramSocket(9876);
            
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            
            // Attente de la réception d'un message
            socket.receive(packet);
            
            // Conversion du message en String
            String receivedMessage = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Message reçu du client : " + receivedMessage);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}