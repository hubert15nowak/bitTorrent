package bitTorrent.peer.pwp.message;

public class BitFieldMessage extends PeerWireMessage{

    byte [] bitField;

    public BitFieldMessage(byte[] bitField) {
        this.bitField = bitField;
        this.len = 1+bitField.length;
        this.id = PeerWireMessage.BITFIELD;
    }
}
