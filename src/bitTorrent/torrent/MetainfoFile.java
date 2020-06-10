package bitTorrent.torrent;

import bitTorrent.peer.local.Directory;
import bitTorrent.peer.local.MyFile;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

public class MetainfoFile {
    String announce;
    String announceList;
    String comment;
    String createdBy;
    String creationDate;
    HashMap<String, Object> info;
    public static ArrayList<MetainfoFile> internetFiles;

    private MetainfoFile(String announce, String announceList, String comment, String createdBy) {
        this.announce = announce;
        this.announceList = announceList;
        this.comment = comment;
        this.createdBy = createdBy;
        info = new HashMap<>();
    }

    public static MetainfoFile createTorrent(String announce, String announceList, String comment, String createdBy, MyFile file, int pieceSizeKiB) throws NoSuchAlgorithmException {
        MetainfoFile metainfoFile = new MetainfoFile(announce, announceList, comment, createdBy);
        metainfoFile.info.put("length", file.getContent().length);
        //metainfoFile.info.put("md5sum", file.getMd5Sum()); TODO: create md5
        metainfoFile.info.put("name", file.getName());
        metainfoFile.info.put("piece length", pieceSizeKiB*1000);
        metainfoFile.info.put("pieces", TorrentFile.getPiecesSha(file, pieceSizeKiB));

        return metainfoFile;
    }

    public static MetainfoFile createTorrent(String announce, String announceList, String comment, String createdBy, Directory dir, int pieceSizeKiB) throws NoSuchAlgorithmException {
        MetainfoFile metainfoFile = new MetainfoFile(announce, announceList, comment, createdBy);
        ArrayList<TorrentFile> allFiles = new ArrayList<>();
        ArrayList<HashMap<String, Object>> files= new ArrayList<>();

        ArrayList<String> seperatePieces = new ArrayList<>();
        //Pojedyncze pliki w folderze
        iterDir(allFiles, dir, new StringBuilder(dir.getName()));
        for(TorrentFile f: allFiles){
            HashMap<String, Object> dict = new HashMap<>();
            dict.put("length", f.file.getContent().length);
            //metainfoFile.info.put("md5sum", f.getMd5Sum()); TODO: create md5
            dict.put("name", f.path + "/" + f.file.getName());
            dict.put("piece length", pieceSizeKiB);
            files.add(dict);
            seperatePieces.add(TorrentFile.getPiecesSha(f.file, pieceSizeKiB));
        }
        metainfoFile.info.put("files", files);
        StringBuilder pieces = new StringBuilder();
        seperatePieces.forEach(pieces::append);
        metainfoFile.info.put("pieces", pieces.toString());

        return metainfoFile;
    }

    static void iterDir(ArrayList<TorrentFile> files, Directory dir, StringBuilder path) {
        for (MyFile file : dir.getFiles()) {
            files.add(new TorrentFile(path.toString(), file));
        }
        for (Directory d : dir.getDirectories()) {
            iterDir(files, d, path.append("/").append(d.getName()));
        }
    }

    public HashMap<String, Object> getInfo() {
        return info;
    }


}