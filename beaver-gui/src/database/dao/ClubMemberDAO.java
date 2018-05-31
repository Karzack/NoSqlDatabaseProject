package database.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import java.util.ArrayList;
import java.util.List;
import database.DBInstance;
import database.model.ClubMember;

/**
 * @author Ola Dahl
 */
public class ClubMemberDAO {
    private static String MEMBERS_COLLECTION = "members";

    public static ClubMember getMember(String ssn) {
        MongoCollection<ClubMember> collection = DBInstance.connectDB().getCollection(MEMBERS_COLLECTION, ClubMember.class);
        return collection.find(Filters.eq("sSN", ssn)).first();
    }

    public static void addMember(ClubMember member) {
        MongoCollection<ClubMember> collection = DBInstance.connectDB().getCollection(MEMBERS_COLLECTION, ClubMember.class);
        collection.insertOne(member);
    }

    public static List<ClubMember> getAllMembers() {
        MongoCollection<ClubMember> collection = DBInstance.connectDB().getCollection(MEMBERS_COLLECTION, ClubMember.class);
        return getMemberList(collection.find());
    }

    private static List<ClubMember> getMemberList(FindIterable<ClubMember> result) {
        List<ClubMember> members = new ArrayList<>();

        for (ClubMember member : result) {
            members.add(member);
        }
        return members;
    }
}
