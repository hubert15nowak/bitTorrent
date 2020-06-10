package bitTorrent.tracker;

import bitTorrent.network.Network;
import bitTorrent.network.NetworkClient;
import bitTorrent.network.NetworkSocket;

import java.util.ArrayList;

public class Tracker extends NetworkClient {

    private int interval = 5000;

    ArrayList<TorrentInfo> torrents;

    public Tracker(String address, int port, Network network) {
        super(address, port, network);
    }

    @Override
    protected void receiveSocket(NetworkSocket socket) {

    }

    @Override
    public void nextStep() {
        super.nextStep();

    }
}
