package flow;

import bitTorrent.network.Network;
import bitTorrent.peer.Peer;
import bitTorrent.tracker.Tracker;

import java.util.ArrayList;
import java.util.Random;


public class FlowController {

    int interval;

    private Network network;
    private ArrayList<Tracker> trackers = new ArrayList<>();
    private ArrayList<Peer> peers = new ArrayList<>();
    private static FlowController flowController;
    private static Random random = new Random();

    private FlowController() {
        network = Network.getInstance();
        for (int i = 0; i < 5; i++) {
            Tracker tracker = new Tracker(Network.getNewAddress(), random.nextInt(1000)+30,network);
            trackers.add(tracker);
        }
        for (int i = 0; i < 5; i++) {
            Peer peer = new Peer(Network.getNewAddress(), random.nextInt(1000)+30,network);
            peers.add(peer);
        }

    }

    public ArrayList<Tracker> getTrackers() {
        return trackers;
    }

    public ArrayList<Peer> getPeers() {
        return peers;
    }

    public static FlowController getInstance() {
        if (flowController == null) {
            flowController = new FlowController();
        }
        return flowController;
    }

}
