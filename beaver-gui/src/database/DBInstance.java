package database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * @author Ola Dahl
 */
public class DBInstance {
    private static MongoClient instance = null;
    private static MongoDatabase db = null;
    private static final String DB_NAME = "BeaverCoffeeDB";

    protected DBInstance() {
    }

    public static MongoDatabase connectDB() {
        if (db == null) {
            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            instance = new MongoClient("localhost",
                    MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
            db = instance.getDatabase(DB_NAME);
        }

        return db;
    }

    public static void disconnectDB() {
        if (instance != null)
            instance.close();
    }
}
