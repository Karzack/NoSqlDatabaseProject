package helpers;

import com.mongodb.client.MongoCollection;
import database.DBInstance;
import database.model.ClubMember;
import database.model.Order;

import java.util.*;

public class AddMembersHelper {

    public static void addSampleMembers() {

        MongoCollection<ClubMember> collection = DBInstance.connectDB().getCollection("members", ClubMember.class);

        collection.drop();

        List<ClubMember> members = Arrays.asList(
                new ClubMember(
                        "Ola",
                        "123456-1234",
                        "Fakegatan 7 22634 Faketon",
                        new Date(),
                        "Utvecklare",
                        false,
                        Collections.emptyList(),
                        UUID.randomUUID().toString()
                ),
                new ClubMember(
                        "Björn",
                        "123456-2345",
                        "Fakegatan 1 22687 Fakeby",
                        new Date(),
                        "Utvecklare",
                        true,
                        Collections.emptyList(),
                        UUID.randomUUID().toString()
                )
        );

        collection.insertMany(members);

        for (ClubMember member : collection.find()) System.out.println(member);
    }
}
