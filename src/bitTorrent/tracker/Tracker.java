package bitTorrent.tracker;

import bitTorrent.network.*;

import java.util.ArrayList;

public class Tracker extends NetworkClient {

    private int interval = 5000;

    ArrayList<TorrentInfo> torrents = new ArrayList<>();

    public Tracker(String address, int port, Network network) {
        super(address, port, network);

    }

    @Override
    protected void receiveSocket(NetworkSocket socket) {

    }

    private void processMessage(Message message) {
        if (message.getData() instanceof TrackerRequest) {
            TrackerRequest torrentInfo = (TrackerRequest) message.getData();
            boolean found = false;
            for (TorrentInfo torrent : torrents) {
                if (torrent.getInfoHash() == torrentInfo.getInfoHash()) {
                    torrent.updateInfo(torrentInfo);
                    found = true;
                    break;
                }
            }
            if (!found) {
                torrents.add(new TorrentInfo(torrentInfo));
            }
            try {
                sendResponse(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void sendResponse(Message message) throws Exception {
        TrackerRequest torrentInfo = (TrackerRequest) message.getData();
        TrackerResponse trackerResponse = null;
        for (TorrentInfo torrent : torrents) {
            if (torrent.getInfoHash() == torrentInfo.getInfoHash()) {
                trackerResponse = TrackerResponse.createResponse(interval, torrent.numberOfSeeders(),
                        torrent.numberOfPeers() - torrent.numberOfSeeders(), torrent.getPeers());
                break;
            }
        }
        if(trackerResponse == null) {
            trackerResponse = TrackerResponse.failureResponse("error");
        }
        Message response = new Message(getAddress(), message.getSourceAddress(), ((TrackerRequest) message.getData()).getPort(), trackerResponse);
        sendMessage(response);
    }

    public ArrayList<TorrentInfo> getTorrents() {
        return torrents;
    }

    @Override
    public void nextStep() {
        super.nextStep();
        currentMessages.forEach(message -> processMessage(message));
    }
}
