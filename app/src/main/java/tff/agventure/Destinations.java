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
    private String[] mNames = new String[]{"Finca de Hermana",
            "Perfect Petals Farm",
            "S&K Farms",
            "Finca de la Estrella"
    };
    private String[] mDescriptions = new String[]{
            "Finca de Hermana is a 3 acre farm near the heart of Ecuador, offering guests a unique look at cacao production, alongside beautiful flowers being farmed year-round. This family owned and operated farm has been handed down through five generations of the Alvarado family, who take pride in what they produce. From this small crevice of the Ecuadorian countryside, come chocolate and flowers that make their way to consumers all over the world",
            "Perfect Petals Farm is a rose farm in the heart of Kenya’s flower producing region, growing beautiful buds year round. Visiting Perfect Petals Farm, you can easily see the care that goes into producing some of the most long-lasting flowers in the world, which owner Mosi Tinibu supplies to buyers worldwide. The vibrant colors at this 2-acre facility are a breathtaking sight for visitors to this unique area.",
            "S&K Farms is a farm producing rubber for a variety of products used every day by people around the world. Visit  to understand exactly how this versatile material makes its journey to your home. This family owned and operated farm, covering just 3 acres, is a memorable must-see, just ask Hathai Chaiprasit, farm owner and mother of 4.",
            "Finca de la Estrella, or Star Farm in English, is a 4-acre farm in beautiful Comayagua, Honduras, growing coffee and bananas. The coffee grown at Finca de la Estrella finds its way into the cups of coffee-drinkers all over the world. The Moncada family, who have farmed this land for generations, welcome you to their farm to experience the land, people, and processes that produce some of your favorite fruits and beverages."
    };

    private String[] mImages = new String[]{
            "finca_de_hermana",
            "perfect_petals_farm",
            "sk_farms",
            "finca_de_la_estrella",
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

    private String mAbout = "Visit this memorable destination, away from the bustle of resort and city life, and you’ll leave with great memories along with a dose of knowledge about the cacao and cut flower industries. Get up close and personal with cacao plants and follow the coffee “pods” as they make their way through harvesting, cleaning, processing, and packaging. After running your hands through the freshly roasted cacao beans and smelling their sweet, strong aroma, you’ll simply have to buy some of the world’s freshest and finest chocolate from the friendly staff and try a taste of their final product at a chocolate tasting.\n" +
            "\n" +
            "\tWhen you’ve had your fill of chocolate, step over to Finca de Hermana’s cut flower operation where you’ll see and smell thousands of flowers in a myriad of bright colors. The Alvarado’s picturesque flower farm features beautiful flowers like chrysanthemums, asthromelias, carnations, daisies, and baby’s breath, just to name a few. These buds bloom year-round in this climate, ensuring a magical experience- and photo opportunity- no matter when you choose to visit.\n" +
            "\n" +
            "\tFor even more adventure, the Alvarados provide the opportunity to ride horseback around their village, taking in the beauty of the flowers and coffee plants and the majesty of the surrounding forest. Spot local wildlife from horseback as you end the day on Finca de Hermana’s scenic riding trail. Spend a day at Finca de Hermana, and you may never want to leave. \n";

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
            destination.setContactInfo(new ContactInfo(mTimesOfOperation, "Ecuador", "765-664-0680", "fincadehermana@gmail.com"));
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