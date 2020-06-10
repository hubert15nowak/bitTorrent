package bitTorrent.peer.pwp;

import bitTorrent.network.NetworkSocket;
import bitTorrent.network.SocketHandler;
import bitTorrent.peer.Peer;
import flow.NextAction;

import java.util.UUID;

public class PWPClient extends SocketHandler implements NextAction {
    UUID id;
    private NetworkSocket socket;
    private Peer peer;
    boolean choked = true;
    boolean interested = false;

    public PWPClient(UUID id, NetworkSocket socket, Peer peer) {
        this.id = id;
        this.socket = socket;
        this.peer = peer;
    }

    public PWPClient(UUID id) {
        this.id = id;
    }

    public void setSocket(NetworkSocket socket) {
        this.socket = socket;
    }

    @Override
    public void nextStep() {

    }

    @Override
    public void send(Object object) throws Exception {
        socket.send(object);
    }

    @Override
    public void receive(Object object) {

    }
}
