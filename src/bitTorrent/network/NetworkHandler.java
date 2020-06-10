package bitTorrent.network;

public interface NetworkHandler {

    void sendMessage(Message message) throws Exception;

    void receiveMessage(Message message) throws Exception;
}
