package beavercoffee;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoClientInstance {
    private static MongoClient instance = null;

    protected MongoClientInstance () {}

    public static MongoClient getInstance() {
        if (instance == null) {
            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            instance = new MongoClient("localhost",
                    MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        }

        return instance;
    }
}
