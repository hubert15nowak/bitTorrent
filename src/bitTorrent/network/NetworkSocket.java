package bitTorrent.network;

import java.util.ArrayList;
import java.util.UUID;

public class NetworkSocket {
    UUID id = UUID.randomUUID();
    UUID destinationID = null;
    String destination;
    int port;
    boolean active = false;
    NetworkClient client;
    SocketHandler handler;

    public NetworkSocket(String destination, int port, NetworkClient client) {
        this.destination = destination;
        this.port = port;
        this.client = client;
    }

    public NetworkSocket(UUID id, UUID destinationID, String destination, int port, boolean active, NetworkClient client) {
        this.id = id;
        this.destinationID = destinationID;
        this.destination = destination;
        this.port = port;
        this.active = active;
        this.client = client;
    }


    ArrayList<SocketMessage> newMessages = new ArrayList<>();
    ArrayList<SocketMessage> currentMessages = new ArrayList<>();

    public void send(Object object) throws Exception {
        SocketMessage socketMessage = new SocketMessage(null, destination, port, object, id, destinationID);
        client.sendMessage(socketMessage);
    }


    public void receive(Object data) {
        handler.receive(data);
    }

    public void setHandler(SocketHandler handler) {
        this.handler = handler;
    }
}
