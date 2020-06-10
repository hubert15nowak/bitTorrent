package bitTorrent.network;

public class Message {
    String sourceAddress;
    String destinationAddress;
    Object data;
    int port;

    public Message(String sourceAddress, String destinationAddress, int port, Object data) {
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.data = data;
        this.port = port;
    }

    public Object getData() {
        return data;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }
}
