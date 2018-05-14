package beavercoffee.helpers;

import beavercoffee.DBInstance;
import beavercoffee.models.clubmember.Address;
import beavercoffee.models.clubmember.ClubMember;
import com.mongodb.client.MongoCollection;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AddSampleCustomerHelper {

    public static void addSampleCustomers() {
        MongoCollection<ClubMember> collection = DBInstance.getInstance().getCollection("club_members", ClubMember.class);

        collection.drop(); //TODO Inte bra lösning, fixa.

        List<ClubMember> members = Arrays.asList(
                new ClubMember(
                        "123456-1234",
                        new Address("Fake Street 1", "Faketown", "Sweden", "98765"),
                        new Date(),
                        "Student",
                        false,
                        null,
                        UUID.randomUUID().toString()
                ),
                new ClubMember(
                        "234567-2345",
                        new Address("Fake Street 2", "Faketown", "Sweden", "98765"),
                        new Date(),
                        "Teacher",
                        false,
                        null,
                        UUID.randomUUID().toString()
                ),
                new ClubMember(
                        "345678-3456",
                        new Address("Fake Street 3", "Faketown", "Sweden", "98765"),
                        new Date(),
                        "App developer",
                        false,
                        null,
                        UUID.randomUUID().toString()
                )
        );

        collection.insertMany(members);
    }
}
