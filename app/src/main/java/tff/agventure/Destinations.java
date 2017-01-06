package tff.agventure;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * list of all destinations in app
 */
public class Destinations {
    private static Destinations sDestinations;
    private List<Destination> mDestinations;
    private String[] mNames = new String[]{"Oasis Range",
            "Eastwood Nursery",
            "Rainbow Ridge Orchard",
            "Southwind Nursery",
            "Berry Crest Farm",
            "Small Paws Meadow"
    };
    private String[] mDescriptions = new String[]{
            "Oasis Range is an old farm that specializes in coffee. Oasis range provides guests lodging and meals as well as horseback rides",
            "Here is a random description",
            "Wow another random description",
            "Writing more descriptions so I can have a decent list",
            "This is Strawberry Shortcake's farm",
            "There are dogs...Obviously"
    };

    private String[] mImages = new String[]{
            "horse",
            "nursery2",
            "nursery2",
            "nursery2",
            "strawberry",
            "nursery2"
    };

    private String[] mQuestions = new String[]{
            "Is housing provided?",
            "Do you offer disability accommodations?",
            "What food options are available?"
    };

    private String[] mAnswers = new String[]{
            "No, but there is a nearby hotel.",
            "Yes, we can accommodate wheelchairs and service dogs.",
            "We have vegan, gluten free, and meat options"
    };

    public static Destinations get(Context context){
        if(sDestinations == null)
            sDestinations = new Destinations(context);
        return sDestinations;
    }

    private Destinations(Context context){
        mDestinations = new ArrayList<>();
        for(int i = 0; i < mNames.length; i++)
        {
            Destination destination = new Destination();
            destination.setName(mNames[i]);
            destination.setDescription(mDescriptions[i]);
            int imageId = context.getResources().getIdentifier(mImages[i], "drawable", context.getPackageName() );
            destination.setImageId(imageId);
            destination.setFaqsQuestions(mQuestions);
            destination.setFaqsAnswers(mAnswers);
            mDestinations.add(destination);
        }
    }

    public List<Destination> getDestinations(){
        return mDestinations;
    }

    public Destination getDestination(UUID id){
        for(int i = 0; i < mDestinations.size(); i++){
            Destination destination = mDestinations.get(i);
            if(destination.getID().equals(id))
                return destination;
        }
        return null;
    }

}