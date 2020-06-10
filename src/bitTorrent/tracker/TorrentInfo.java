package bitTorrent.tracker;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class TorrentInfo {
    private int infoHash;
    private ArrayList<PeerTrackerInfo> peers = new ArrayList<>();

    public TorrentInfo(TrackerRequest torrentInfo) {
        infoHash = torrentInfo.getInfoHash();
        PeerTrackerInfo peerTrackerInfo = new PeerTrackerInfo();
        peerTrackerInfo.completed = torrentInfo.getLeft() == 0;
        peerTrackerInfo.peerId = torrentInfo.getPeerId();
        peerTrackerInfo.ip = torrentInfo.getIp();
        peerTrackerInfo.port = torrentInfo.getPort();
        peers.add(peerTrackerInfo);
    }


    public void updateInfo(TrackerRequest request) {
        if (request.getDict().containsKey("event")) {
            if (request.getDict().get("event").equals("completed")) {
                for (PeerTrackerInfo peer : peers) {
                    if (peer.peerId == request.getPeerId()) {
                        peer.completed = true;
                        break;
                    }
                }
            }
        }
    }



    public int getInfoHash() {
        return infoHash;
    }

    public int numberOfPeers() {
        return peers.size();
    }

    public int numberOfSeeders() {
        return (int) peers.stream().filter(peerTrackerInfo -> peerTrackerInfo.completed).count();
    }

    public ArrayList<PeerInfo> getPeers() {
        ArrayList<PeerInfo> peersInfo = new ArrayList<>();
        peersInfo = (ArrayList<PeerInfo>) peers.stream().map(peerTrackerInfo ->
                new PeerInfo(peerTrackerInfo.peerId, peerTrackerInfo.ip, peerTrackerInfo.port)
        ).collect(Collectors.toList());
        return peersInfo;
    }
}
