package bitTorrent.network;

public interface NetworkHandler {

    void sendMessage(Message message);

    Message receiveMessage();
}