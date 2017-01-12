package tff.agventure;

import java.io.Serializable;
import java.util.List;

public class ThingToDo implements Serializable{
    private String mName;
    private String mDescription;
    private List<Price> mPrices;

    public ThingToDo(String name, String description, List<Price> prices){
        mName = name;
        mDescription = description;
        mPrices = prices;
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

    public List<Price> getPrices() {
        return mPrices;
    }

    public void setPrices(List<Price> prices) {
        mPrices = prices;
    }
}
