package bitTorrent.peer.torrent;

import bitTorrent.peer.local.FileManager;
import bitTorrent.peer.Peer;
import bitTorrent.peer.local.Directory;
import bitTorrent.peer.pwp.PWPClient;
import bitTorrent.torrent.MetainfoFile;
import flow.NextAction;

import java.util.ArrayList;
import java.util.Hashtable;

public class Torrent implements NextAction {

    private int piecesAmount;
    private FileManager fileManager;
    private ArrayList<PWPClient> pwpClients = new ArrayList<>();
    private Peer peer;

    private ArrayList<Boolean> piecesDownloaded = new ArrayList<>();
    private String piecesHash;
    private Hashtable<Integer, Integer> availablePieces = new Hashtable<>();

    private Torrent(Peer peer) {
        this.peer = peer;
    }

    public static Torrent createTorrent(Peer peer, MetainfoFile metainfoFile, Directory root) throws Exception {
        if (metainfoFile.getInfo().containsKey("files")) {
            return null;
        } else {
            return singleFileTorrent(peer, metainfoFile, root);
        }
    }

    private static Torrent singleFileTorrent(Peer peer, MetainfoFile metainfoFile, Directory root) throws Exception {
        Torrent torrent = new Torrent(peer);
        torrent.piecesHash = (String) metainfoFile.getInfo().get("pieces");
        if (torrent.piecesHash.length() % 20 != 0) throw new Exception("wrong string hash");
        torrent.piecesAmount = torrent.piecesHash.length() / 20;
        torrent.fileManager = FileManager.createNewFile(root,
                (String) metainfoFile.getInfo().get("name"),
                (int) metainfoFile.getInfo().get("length"));
        return torrent;
    }

    private static Torrent multiFileTorrent(Peer peer, MetainfoFile metainfoFile, Directory root) throws Exception {
        Torrent torrent = new Torrent(peer); //TODO:
        return torrent;
    }


    @Override
    public void nextStep() {

    }
}
