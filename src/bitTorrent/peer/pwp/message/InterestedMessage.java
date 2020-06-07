package bitTorrent.peer.pwp.message;

public class InterestedMessage extends PeerWireMessage {

    public InterestedMessage() {
        this.len = 1;
        this.id = PeerWireMessage.INTERESTED;
    }
}
