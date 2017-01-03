package tff.agventure;

import java.util.UUID;

/*
This class describes an agritourism destination
 */
public class Destination {
    private UUID mID;
    private String mName;
    private String mDescription;

    public Destination()
    {
        mID = UUID.randomUUID();
    }

    public UUID getID() {
        return mID;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
