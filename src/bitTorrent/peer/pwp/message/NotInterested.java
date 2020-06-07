package bitTorrent.peer.pwp.message;

public class NotInterested extends PeerWireMessage {

    public NotInterested() {
        this.len = 1;
        this.id = PeerWireMessage.NOT_INTERESTED;
    }
}
