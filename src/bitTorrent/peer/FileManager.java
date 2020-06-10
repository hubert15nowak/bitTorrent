package bitTorrent.peer;

import bitTorrent.peer.local.Directory;
import bitTorrent.peer.local.MyFile;

public class FileManager {

    Directory root;
    MyFile file;

    public FileManager(Directory root, String name, int fileSize) {
        this.root = root;
    }

    public String getName() {
        return file.getName();
    }

    public void setName(String name) {
        file.setName(name);
    }

    public byte[] getContent() {
        return file.getContent();
    }

    public void setContent(byte[] content) {
        file.setContent(content);
    }
}
