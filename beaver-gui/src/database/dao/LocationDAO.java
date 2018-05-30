package database.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import database.DBInstance;
import database.model.Location;

/**
 * @author Ola Dahl
 */
public class LocationDAO {

    public static Location getLocationByName(String locationName) {
        MongoCollection<Location> collection = DBInstance.connectDB().getCollection("locations", Location.class);

        return collection.find(Filters.eq("name", locationName)).first();
    }
}
