package bitTorrent.person;

import java.util.ArrayList;
import java.util.UUID;

class Peer extends Client{
    private String name;
    private UUID uuid;
    private ArrayList<UUID> uuids = new ArrayList<>();

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
        UUID temp = UUID.randomUUID();
        boolean valid = true;
        uuids.add(temp);
        for(UUID id : uuids){
            if(id==temp){
                valid = false;
                uuids.remove(id);
            }
        }
        if(valid){
            this.uuid = temp;
        }
        else{
            setUuid();
        }
    }
}