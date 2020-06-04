package network;


import java.util.ArrayList;


public class Network {
    static ArrayList<NetworkClient> clients = new ArrayList<>();


    public static void receive(Message message) throws Exception{
        for (NetworkClient client : clients) {
            if (client.addres.equals(message.destinationAdrress)) {
                client.receive(message);
            }
        }
    }





}
