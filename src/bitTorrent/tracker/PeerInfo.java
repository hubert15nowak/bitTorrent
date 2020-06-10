package bitTorrent.tracker;

import java.util.UUID;

public class PeerInfo {
    UUID peerId;
    String ip;
    int port;

    public PeerInfo() {
    }

    public PeerInfo(UUID peerId, String ip, int port) {
        this.peerId = peerId;
        this.ip = ip;
        this.port = port;
    }
}
