package bitTorrent.peer.local;

import java.util.ArrayList;
import java.util.Random;

public class Disk extends Directory{
    private static Random random = new Random();
    public static int maxSizeKiB = 10;
    public static int maxFiles = 5;
    public static int maxLevel = 10;
    public static int maxDirectories = 10;

    public static Disk randomDisk() {

        Disk disk = new Disk();
        generate(disk, maxLevel, maxDirectories, maxFiles, maxSizeKiB);
        return disk;
    }

    private static void generate(Directory dir, int maxLevel, int maxDirectories, int maxFiles, int maxSizeKiB) {
        if(maxLevel-- == 0 || Math.abs(random.nextGaussian()) > 0.8 )
            return;
        int directories = random.nextInt(maxDirectories);
        for (int i = 0; i < directories; i++) {
            Directory d = new Directory();
            dir.add(d);
            generate(d, maxLevel, maxDirectories, maxFiles, maxSizeKiB);
        }
        dir.setFiles(randomFiles(maxFiles, maxSizeKiB));
        dir.files.forEach(myFile -> myFile.parent = dir);
    }

    private static ArrayList<MyFile> randomFiles(int maxFiles, int maxSizeKiB) {
        ArrayList<MyFile> files = new ArrayList<>();
        int filesNumber = random.nextInt(maxFiles);
        for (int i = 0; i < filesNumber; i++) {
            files.add(MyFile.randomFile(maxSizeKiB));
        }

        return files;
    }

    public static void main(String[] args) {
        Disk disk = Disk.randomDisk();
        System.out.println(disk);
    }

}
