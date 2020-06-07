package bitTorrent.peer.pwp.message;

public class HaveMessage extends PeerWireMessage {

    private int pieceIndex;

    public HaveMessage(int pieceIndex) {
        this.pieceIndex = pieceIndex;
        this.len = 5;
        this.id = PeerWireMessage.HAVE;
    }

    public int getPieceIndex() {
        return pieceIndex;
    }
}
