package database.dao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import database.DBInstance;
import database.model.Location;
import database.model.Order;

/**
 * @author Ola Dahl
 */
public class LocationDAO {
    private static final String LOCATIONS_COLLECTION = "locations";

    public static Location getLocationByName(String locationName) {
        MongoCollection<Location> collection = DBInstance.connectDB().getCollection(LOCATIONS_COLLECTION, Location.class);

        return collection.find(Filters.eq("name", locationName)).first();
    }

    public static List<Location> getAllLocations() {
        MongoCollection<Location> collection = DBInstance.connectDB().getCollection(LOCATIONS_COLLECTION, Location.class);
        return getLocationList(collection.find());
    }

    private static List<Location> getLocationList(FindIterable<Location> locationsRes) {
        if (locationsRes != null) {
            List<Location> locations = new ArrayList<>();
            for (Location location : locationsRes) {
                locations.add(location);
            }
            return locations;
        }
        return null;
    }
}
