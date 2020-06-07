package bitTorrent.peer.pwp.message;

public class UnchokeMessage extends PeerWireMessage {

    public UnchokeMessage() {
        this.len = 1;
        this.id = PeerWireMessage.UNCHOKE;
    }
}
