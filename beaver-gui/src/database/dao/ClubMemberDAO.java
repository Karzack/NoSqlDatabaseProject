package database.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import database.DBInstance;
import database.model.ClubMember;

public class ClubMemberDAO {
    private static String MEMBERS_COLLECTION = "members";

    public static ClubMember getMember(String ssn) {
        MongoCollection<ClubMember> collection = DBInstance.connectDB().getCollection(MEMBERS_COLLECTION, ClubMember.class);
        return collection.find(Filters.eq("sSN", ssn)).first();
    }
}
