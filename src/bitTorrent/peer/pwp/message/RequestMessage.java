package bitTorrent.peer.pwp.message;

public class RequestMessage extends PeerWireMessage{

    private int pieceIndex;
    private int blockOffset;
    private int blockLength;

    public RequestMessage(int pieceIndex, int blockOffset, int blockLength) {
        this.pieceIndex = pieceIndex;
        this.blockOffset = blockOffset;
        this.blockLength = blockLength;
        this.len = 13;
        this.id = PeerWireMessage.REQUEST;
    }

    public int getPieceIndex() {
        return pieceIndex;
    }

    public int getBlockOffset() {
        return blockOffset;
    }

    public int getBlockLength() {
        return blockLength;
    }
}
