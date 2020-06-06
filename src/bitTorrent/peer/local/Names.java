package bitTorrent.peer.local;


import java.util.ArrayList;
import java.util.Random;

public abstract class Names {
    private static ArrayList<String> names = new ArrayList<>();
    private static Random random = new Random();
    static {
        names.add("ZŁOTA RYBKA");
        names.add("PÓŁKA");
        names.add("PORZECZKA");
        names.add("BIEDA");
        names.add("ŻUK");
        names.add("FORMUŁA");
        names.add("SPAGHETTI");
        names.add("BŁOTO");
        names.add("MŁYN");
        names.add("PERKUSJA");
        names.add("STARUSZEK");
        names.add("KRZYK");
        names.add("PIĘKNA I BESTIA");
        names.add("BIBLIOTEKA");
        names.add("FLOTA");
        names.add("POMOC");
        names.add("LUNCH");
        names.add("BRUKSELKI");
        names.add("ATRAMENT");
        names.add("ZDERZENIE");
        names.add("LAMÓWKA");
        names.add("CURRY");
        names.add("CD");
        names.add("OSTRYGA");
        names.add("SUWAK");
        names.add("UCIECZKA");
        names.add("TŁUM");
        names.add("IMPERIUM");

    }

    public static String getRandomName() {
        return names.get(random.nextInt(names.size()));
    }
}
