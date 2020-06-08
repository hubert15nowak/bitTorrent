package bitTorrent.tracker;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.HashMap;

public class TrackerResponse {


    private HashMap<String, Object> dict;

    private TrackerResponse() {
        dict = new HashMap<>();
    }

    public static TrackerResponse failureResponse(String reason) {
        TrackerResponse response = new TrackerResponse();
        response.put("failure reason", reason);
        return response;
    }

    /**
     *
     * @param interval the amount of time that a peer should wait between to consecutive regular requests
     * @param complete indicates the number of seeders
     * @param incomplete indicates the number of peers downloading the torrent
     * @param peers list of peers that must be contacted in order to download a file
     * @return response
     */
    public static TrackerResponse createResponse(int interval, Integer complete, Integer incomplete, ArrayList<PeerInfo> peers) {
        TrackerResponse response = new TrackerResponse();
        response.put("interval", interval);
        if (complete != null)
        response.put("complete", complete);
        if (incomplete != null)
        response.put("incomplete", incomplete);
        response.put("peers", peers);
        return response;
    }

    public Object put(String key, Object value) {
        return dict.put(key, value);
    }


}
