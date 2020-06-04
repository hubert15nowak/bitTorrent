package network;

public class NetworkClient {
    String addres;
    int port;


    public void receive(Message message) throws Exception {
        if (message.port != port) throw new Exception("unsupported port");

    }


}
