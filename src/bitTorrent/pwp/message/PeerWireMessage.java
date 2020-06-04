package bitTorrent.pwp.message;

public abstract class PeerWireMessage {

    public static final int CHOKE = 0;
    public static final int UNCHOKE = 1;
    public static final int INTERESTED = 2;
    public static final int UNINTERESTED = 3;
    public static final int HAVE = 4;
    public static final int BITFIELD = 5;
    public static final int REQUEST = 6;
    public static final int PIECE = 7;
    public static final int CANCEL = 8;
}
