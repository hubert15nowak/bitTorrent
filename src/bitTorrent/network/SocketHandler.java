package bitTorrent.network;

public abstract class SocketHandler {

    private NetworkSocket socket;

    public void send(Object object) throws Exception {
        socket.send(object);
    }
    public abstract void receive(Object object);


    public void setSocket(NetworkSocket socket) {
        this.socket = socket;
    }
}
