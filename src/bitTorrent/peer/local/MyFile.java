package bitTorrent.peer.local;

import java.awt.*;
import java.util.Random;

public class MyFile {
    String name;
    byte[] content;
    static Random random = new Random();

    private MyFile(String name, byte[] content) {
        this.name = name;
        this.content = content;
    }

    public static MyFile randomFile(int maxSizeKiB) {
        int fileSize = random.nextInt(maxSizeKiB);
        byte[] content = new byte[fileSize * 1000];
        random.nextBytes(content);
        return new MyFile(Names.getRandomName(), content);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }


}
