package bitTorrent.peer.local;

import java.util.ArrayList;

public class Directory {
    String name;
    Directory parent;
    ArrayList<Directory> directories = new ArrayList<>();
    ArrayList<MyFile> files = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public Directory() {
        this.name = Names.getRandomName();
    }

    public boolean add(Directory directory) {
        directory.parent = this;
        return directories.add(directory);
    }

    public boolean add(MyFile myFile) {
        return files.add(myFile);
    }

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

    public ArrayList<MyFile> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<MyFile> files) {
        this.files = files;
    }
}
