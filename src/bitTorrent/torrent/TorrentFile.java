package bitTorrent.torrent;

import bitTorrent.peer.local.MyFile;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Formatter;

public class TorrentFile {

    String path;
    MyFile file;

    public TorrentFile(String path, MyFile file) {
        this.path = path;
        this.file = file;
    }

    public static String getPiecesSha(MyFile file, int pieceSizeKiB) throws NoSuchAlgorithmException{
        int pieceSize =  pieceSizeKiB * 1000;
        StringBuilder sha = new StringBuilder();
        int i = 0;
        for (; i < file.getContent().length; i += pieceSize) {
            byte[] piece = Arrays.copyOfRange(file.getContent(), i, i + pieceSize);
            sha.append(SHAsum(piece));
        }
        sha.append(SHAsum(Arrays.copyOfRange(file.getContent(), i, file.getContent().length)));
        return sha.toString();
    }

    public static String SHAsum(byte[] toConvert) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        return byteArray2Hex(md.digest(toConvert));
    }

    private static String byteArray2Hex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }
}
