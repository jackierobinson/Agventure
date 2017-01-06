package tff.agventure;

import java.util.UUID;

/*
This class describes an agritourism destination
 */
public class Destination {
    private UUID mID;
    private String mName;
    private String mDescription;
    private int mImageId;
    private String[] mFaqsQuestions; //possible look into making this a hashmap
    private String[] mFaqsAnswers;

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

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }

    public String[] getFaqsQuestions() {
        return mFaqsQuestions;
    }

    public void setFaqsQuestions(String[] faqsQuestions) {
        mFaqsQuestions = faqsQuestions;
    }

    public String[] getFaqsAnswers() {
        return mFaqsAnswers;
    }

    public void setFaqsAnswers(String[] faqsAnswers) {
        mFaqsAnswers = faqsAnswers;
    }
}
