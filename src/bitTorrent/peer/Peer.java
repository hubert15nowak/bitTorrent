package bitTorrent.peer;

import bitTorrent.network.*;
import bitTorrent.peer.local.Disk;
import bitTorrent.peer.pwp.PWPClient;
import bitTorrent.peer.torrent.Torrent;
import flow.NextAction;

import java.util.ArrayList;
import java.util.UUID;

public class Peer extends NetworkClient implements NextAction {
    private int fixedBlockSizeB = 256;
    private UUID id = UUID.randomUUID();
    private Disk disk = Disk.randomDisk();

    private ArrayList<Torrent> torrents = new ArrayList<>();
    private ArrayList<PWPClient> newPWP = new ArrayList<>();

    public Peer(String address, int port, Network network) {
        super(address, port, network);

    }


    @Override
    public void nextStep() {
        super.nextStep();
        for (Torrent torrent : torrents) {
            torrent.nextStep();
        }
    }

    @Override
    protected void receiveSocket(NetworkSocket socket) {
        PWPClient pwpClient = new PWPClient(id, socket);
        socket.setHandler(pwpClient);
        newPWP.add(pwpClient);
    }


    public int getFixedBlockSizeB() {
        return fixedBlockSizeB;
    }

    public void setFixedBlockSizeB(int fixedBlockSizeB) {
        this.fixedBlockSizeB = fixedBlockSizeB;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ArrayList<Torrent> getTorrents() {
        return torrents;
    }

    public void setTorrents(ArrayList<Torrent> torrents) {
        this.torrents = torrents;
    }

    public ArrayList<PWPClient> getNewPWP() {
        return newPWP;
    }

    public void setNewPWP(ArrayList<PWPClient> newPWP) {
        this.newPWP = newPWP;
    }

    public Disk getDisk() {
        return disk;
    }
}
