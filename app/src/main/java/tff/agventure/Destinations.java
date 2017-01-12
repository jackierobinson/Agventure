package tff.agventure;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
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

    private String mAbout = "Oasis Range is a family owned farm founded in 1902. It is dedicated to producing high quality cocoa products. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce cursus et odio non interdum. Aenean sit amet diam enim. Vivamus pretium purus sapien, sit amet tristique orci ullamcorper at. Nunc fringilla fringilla malesuada. Cras vitae nisl orci. Donec ac ullamcorper neque. Praesent molestie ornare purus, quis ultricies dolor hendrerit vel. Nulla gravida, lectus id tincidunt tincidunt, tortor quam sagittis lacus, ac malesuada lacus sapien eget erat. In accumsan ligula porttitor velit volutpat, eu vehicula justo lobortis. Nunc eu tristique lorem, id cursus elit. Morbi condimentum, est at faucibus pellentesque, magna justo pellentesque risus, eget dictum risus dui eget tellus. Nam maximus quam dui, eget semper leo tempor at. Donec pretium sollicitudin ex.\n" +
            "\n" +
            "Interdum et malesuada fames ac ante ipsum primis in faucibus. Vestibulum iaculis ex vitae nibh faucibus pulvinar. Morbi volutpat purus eget lectus tincidunt vestibulum. Nullam aliquam vel tortor eget consectetur. Fusce mattis neque id sapien imperdiet, ac euismod leo sodales. Nam et varius arcu. Aenean pulvinar justo quis magna accumsan, interdum sollicitudin augue sollicitudin. Phasellus laoreet sollicitudin odio at iaculis. Nunc molestie sem a ante porta gravida. Aenean a diam id dolor vehicula hendrerit id sit amet nisi. Duis ultrices aliquam tempus. Quisque molestie erat et sodales consectetur. Mauris non nunc quis leo volutpat placerat.";

    private List<TimeOfOperation> mTimesOfOperation;

    private List<ThingToDo> mThingsToDo;

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
            addQuestions(destination);
            addAnswers(destination);
            destination.setAbout(mAbout);
            setTimesOfOperation();
            destination.setContactInfo(new ContactInfo(mTimesOfOperation, "3338 Winifred Way, South Hadley, Massachusetts, 01075", "765-664-0680", "oasisrange@gmail.com"));
            createThingsToDo();
            destination.setThingsToDo(mThingsToDo);
            mDestinations.add(destination);
        }
    }

    private void setTimesOfOperation (){
        mTimesOfOperation = new ArrayList<>();
        mTimesOfOperation.add(new TimeOfOperation("Sunday", "Closed"));
        mTimesOfOperation.add(new TimeOfOperation("Monday", "8 AM - 5 PM"));
        mTimesOfOperation.add(new TimeOfOperation("Tuesday", "8 AM - 5 PM"));
        mTimesOfOperation.add(new TimeOfOperation("Wednesday", "8 AM - 5 PM"));
        mTimesOfOperation.add(new TimeOfOperation("Thursday", "8 AM - 5 PM"));
        mTimesOfOperation.add(new TimeOfOperation("Friday", "8 AM - 7 PM"));
        mTimesOfOperation.add(new TimeOfOperation("Saturday", "8 AM - 7 PM"));
    }

    private void addQuestions (Destination destination){
        for(int i = 0; i < mQuestions.length; i++){
            destination.getFaqs().addQuestion(mQuestions[i]);
        }
    }

    private void addAnswers (Destination destination){
        for(int i = 0; i < mAnswers.length; i++){
            destination.getFaqs().addAnswer(mQuestions[i], mAnswers[i]);
        }
    }

    private void createThingsToDo(){
        mThingsToDo = new ArrayList<>();
        List<Price> prices = new ArrayList<>();
        prices.add(new Price("Seniors 55+", new BigDecimal(35.00)));
        prices.add(new Price("Children 0-12", new BigDecimal(35.00)));
        prices.add(new Price("Adults 13-54", new BigDecimal(45.00)));
        mThingsToDo.add(new ThingToDo("Horse Ride", "Guests will be able enjoy a horse ride around the farm. Smaller children can ride ponies. Staff onsite will teach guests how to ride the horses.", prices));
        prices = new ArrayList<>();
        prices.add(new Price("Seniors 55+", new BigDecimal(40.00)));
        prices.add(new Price("Children 0-12", new BigDecimal(40.00)));
        prices.add(new Price("Adults 13-54", new BigDecimal(50.00)));
        mThingsToDo.add(new ThingToDo("Plantation Tour", "Guests will be able to visit the plantation and learn about the foods produced.. Lunch will be provided.", prices));

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