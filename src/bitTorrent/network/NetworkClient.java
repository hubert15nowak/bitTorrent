package bitTorrent.network;

import flow.NextAction;

import java.util.ArrayList;
import java.util.UUID;

public abstract class NetworkClient implements NetworkHandler, NextAction {
    String address;
    int port;
    Network network;
    ArrayList<Message> newMessages;
    protected ArrayList<Message> currentMessages;
    protected ArrayList<Message> allMessages;
    ArrayList<NetworkSocket> sockets = new ArrayList<>();

    public NetworkClient(String address, int port, Network network) {
        this.address = address;
        this.port = port;
        this.network = network;
        newMessages = new ArrayList<>();
        allMessages = new ArrayList<>();
        currentMessages = new ArrayList<>();

    }

    @Override
    public void sendMessage(Message message) throws Exception {
        if (message instanceof SocketMessage) {
            message.sourceAddress = address;
        }
        Network.receive(message);
    }

    @Override
    public void receiveMessage(Message message) throws Exception {
        newMessages.add(message);
    }

    private void computeSocketMessages() {
        for (Message message : allMessages) {
            try {
            if (message.port != port) throw new Exception("invalid port");
            if (message instanceof SocketMessage) {
                SocketMessage socketMessage = (SocketMessage) message;
                if (socketMessage.destination == null) {
                    openSocket(socketMessage);
                } else {
                    for (NetworkSocket socket : sockets) {
                        if (socket.id == socketMessage.destination) {
                            socket.receive(socketMessage.data);
                        }
                    }
                }

            } else {
                currentMessages.add(message);
            } }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void nextStep() {
        computeSocketMessages();
        currentMessages.clear();
        allMessages = newMessages;
        newMessages = new ArrayList<>();
        System.out.println("network client next step");
    }

    protected abstract void receiveSocket(NetworkSocket socket);


    private void openSocket(SocketMessage socketMessage) {
        NetworkSocket socket = new NetworkSocket(socketMessage.destinationAddress, (Integer) socketMessage.data, this);
        socket.active = true;
        try {
            socket.send(true);
            sockets.add(socket);
            receiveSocket(socket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void newSocket(String destination, int port, SocketHandler socketHandler) throws Exception {
        NetworkSocket socket = new NetworkSocket(destination, port, this);
        socket.setHandler(socketHandler);
        socketHandler.setSocket(socket);
        socket.send(this.port);
        sockets.add(socket);
    }

    public String getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public Network getNetwork() {
        return network;
    }
}
