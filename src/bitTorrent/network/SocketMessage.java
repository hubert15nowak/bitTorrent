package bitTorrent.network;

import java.util.UUID;

public class SocketMessage extends Message {
    UUID source;
    UUID destination;

    public SocketMessage(String sourceAddress, String destinationAddress, int port, Object data, UUID source, UUID destination) {
        super(sourceAddress, destinationAddress, port, data);
        this.source = source;
        this.destination = destination;
    }
}
