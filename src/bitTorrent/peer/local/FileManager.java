package bitTorrent.peer.local;

import java.nio.file.NoSuchFileException;
import java.util.Optional;

public class FileManager {
    MyFile file;

    private FileManager(Directory root, String name, int fileSize) {
        file = new MyFile(name, new byte[fileSize]);
        file.parent = root;
    }

    public FileManager(MyFile file) {
        this.file = file;
    }

    public static FileManager createNewFile(Directory root, String name, int fileSize) throws NoSuchFileException {
        if (root == null) throw new NoSuchFileException("root");
        return new FileManager(root, name, fileSize);
    }

    public static FileManager getFileManager(Directory root, String name) throws NoSuchFileException {
        Optional<MyFile> file = root.getFiles().stream().filter(myFile -> myFile.getName().equals(name)).findFirst();
        if(file.isEmpty()) throw new NoSuchFileException(name);
        return new FileManager(file.get());
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
