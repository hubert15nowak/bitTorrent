package bitTorrent.peer.pwp.message;

public class ChokeMessage extends PeerWireMessage{

    public ChokeMessage() {
        this.len = 1;
        this.id = PeerWireMessage.CHOKE;
    }
}
