package bitTorrent.peer.pwp.message;

public class PieceMessage extends PeerWireMessage{

    private int pieceIndex;
    private int blockOffset;
    private byte[] blockData;

    public PieceMessage(int pieceIndex, int blockOffset, byte[] blockData) {
        this.pieceIndex = pieceIndex;
        this.blockOffset = blockOffset;
        this.blockData = blockData;
        this.len = 9+blockData.length;
        this.id = PeerWireMessage.PIECE;
    }

    public int getPieceIndex() {
        return pieceIndex;
    }

    public int getBlockOffset() {
        return blockOffset;
    }

    public byte[] getBlockData() {
        return blockData;
    }
}
