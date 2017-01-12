package tff.agventure;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/*
This class describes an agritourism destination
 */
public class Destination implements Serializable{
    private UUID mID;
    private String mName;
    private String mDescription;
    private String mAbout;
    private int mImageId;
    private Faqs mFaqs;
    private ContactInfo mContactInfo;
    private List<ThingToDo> mThingsToDo;

    public Destination()
    {
        mID = UUID.randomUUID();
        mFaqs = new Faqs();
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

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }

    public String getAbout() {
        return mAbout;
    }

    public void setAbout(String about) {
        mAbout = about;
    }

    public Faqs getFaqs() {
        return mFaqs;
    }

    public ContactInfo getContactInfo() {
        return mContactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        mContactInfo = contactInfo;
    }

    public List<ThingToDo> getThingsToDo() {
        return mThingsToDo;
    }

    public void setThingsToDo(List<ThingToDo> thingsToDo) {
        mThingsToDo = thingsToDo;
    }
}
