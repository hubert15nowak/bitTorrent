package bitTorrent.network;


import java.util.ArrayList;


public class Network {
    static ArrayList<NetworkClient> clients = new ArrayList<>();

    static Network network = new Network();


    private Network(){}

    public static Network getInstance() {
        return network;
    }


    public static void receive(Message message) throws Exception{
        for (NetworkClient client : clients) {
            if (client.address.equals(message.destinationAddress)) {
                client.receiveMessage(message);
                break;
            }
        }
    }


    public void add(NetworkClient client) {
        clients.add(client);
    }



    private static int address1 = 0;
    private static int address2 = 1;
    public static String getNewAddress() {
        if(address2 == 255) {
            address1++;
            address2 = 0;
        }
        return "283.142."+address1+"."+address2++;
    }

}
