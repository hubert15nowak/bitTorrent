package bitTorrent.tracker;

import java.util.HashMap;
import java.util.UUID;

public class TrackerRequest {

    private int infoHash;
    private UUID peerId;
    private int port;
    private int uploaded;
    private int downloaded;
    private int left;
    private String ip;
    private int numWant;
    private String event;
    private HashMap<String, Object> dict = new HashMap<>();

    public TrackerRequest(int infoHash, String peerId, int port, int uploaded, int downloaded, int left, String ip, Integer numWant, String event) {
        dict.put("infoHash", infoHash);
        dict.put("peerId", peerId);
        dict.put("port", port);
        dict.put("uploaded", uploaded);
        dict.put("downloaded", downloaded);
        dict.put("left", left);
        if (ip != null)
            dict.put("ip", ip);
        if (numWant != null)
        dict.put("numWant", numWant);
        if (event != null)
            dict.put("event", event);
    }


    public int getInfoHash() {
        return infoHash;
    }

    public UUID getPeerId() {
        return peerId;
    }

    public int getPort() {
        return port;
    }

    public int getUploaded() {
        return uploaded;
    }

    public int getDownloaded() {
        return downloaded;
    }

    public int getLeft() {
        return left;
    }

    public String getIp() {
        return ip;
    }

    public int getNumWant() {
        return numWant;
    }

    public String getEvent() {
        return event;
    }

    public HashMap<String, Object> getDict() {
        return dict;
    }
}
