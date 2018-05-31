package helpers;

import com.mongodb.client.MongoCollection;
import database.DBInstance;
import database.model.Location;

import java.util.Arrays;
import java.util.List;

public class AddLocationsHelper {

    public static void addLocations() {
        MongoCollection<Location> collection = DBInstance.connectDB().getCollection("locations", Location.class);

        collection.drop();

        List<Location> locations = Arrays.asList(
                new Location("Malmö", "SEK", "Swedish"),
                new Location("Stockholm", "SEK", "Swedish"),
                new Location("Chicago", "USD", "English")
        );

        collection.insertMany(locations);
    }
}
