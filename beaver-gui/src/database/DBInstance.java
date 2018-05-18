package database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DBInstance {
    private static MongoClient instance = null;
    private static final String DB_NAME = "BeaverCoffeeDB";

    protected DBInstance() {}

    public static MongoClient getInstance() {
        if (instance == null) {
            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            MongoClient client = new MongoClient("localhost",
                    MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());

            instance = client;
//            instance = client.getDatabase(DB_NAME);
        }
        return instance;
    }

    public static MongoDatabase connectDB() {
        getInstance();
        return instance.getDatabase(DB_NAME);
    }

    public static void disconnectDB() {
        getInstance();
        instance.close();
    }


}
