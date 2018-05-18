package database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import database.model.ClubMember;

public class ClubMemberDAO {

    public static ClubMember getMember(String ssn) {
        MongoCollection<ClubMember> collection = DBInstance.connectDB().getCollection("members", ClubMember.class);
        return collection.find(Filters.eq("sSN", ssn)).first();
    }
}
