package torrent;

import client.local.Directory;
import client.local.File;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class MetainfoFile {
    String announce;
    String announceList;
    String comment;
    String createdBy;
    String creationDate;
    Dictionary info;

    private MetainfoFile(String announce, String announceList, String comment, String createdBy) {
        this.announce = announce;
        this.announceList = announceList;
        this.comment = comment;
        this.createdBy = createdBy;
        info = new Hashtable();
    }

    static MetainfoFile createTorrent(String announce, String announceList, String comment, String createdBy, File file, int pieceSizeKiB) throws NoSuchAlgorithmException {
        MetainfoFile metainfoFile = new MetainfoFile(announce, announceList, comment, createdBy);
        metainfoFile.info.put("length", file.getContent().length);
        //metainfoFile.info.put("md5sum", file.getMd5Sum()); TODO: create md5
        metainfoFile.info.put("name", file.getName());
        metainfoFile.info.put("pice length", pieceSizeKiB);
        metainfoFile.info.put("pieces", TorrentFile.getPiecesSha(file, pieceSizeKiB));

        return metainfoFile;
    }

    static MetainfoFile createTorrent(String announce, String announceList, String comment, String createdBy, Directory dir, int pieceSizeKiB) throws NoSuchAlgorithmException {
        MetainfoFile metainfoFile = new MetainfoFile(announce, announceList, comment, createdBy);


        return metainfoFile;
    }
}