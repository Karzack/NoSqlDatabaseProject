package beavercoffee;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DBInstance {
    private static MongoDatabase instance = null;
    private static final String DB_NAME = "BeaverCoffeeDB";

    protected DBInstance() {}

    public static MongoDatabase getInstance() {
        if (instance == null) {
            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            MongoClient client = new MongoClient("localhost",
                    MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());

            instance = client.getDatabase(DB_NAME);
        }
        return instance;
    }
}
