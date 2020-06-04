package bitTorrent.peer.local;

import java.util.ArrayList;

public class Directory {
    String name;
    Directory parentDirectory;
    ArrayList<Directory> directories = new ArrayList<>();
    ArrayList<File> files = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Directory> getDirectories() {
        return directories;
    }

    public void setDirectories(ArrayList<Directory> directories) {
        this.directories = directories;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }
}
