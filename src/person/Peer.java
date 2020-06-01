package person;

import java.util.UUID;

class Peer extends Client{

    private String name;
    private UUID uuid;

    Peer(String name){
        this.name = name;
        setUuid();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    private void setUuid() {
        this.uuid = UUID.randomUUID();
    }
}