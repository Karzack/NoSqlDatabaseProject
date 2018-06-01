package database.dao;

import com.mongodb.Block;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import database.DBInstance;
import database.model.ClubMember;
import database.model.Order;
import database.model.product.Product;
import org.bson.Document;

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

    public static void updateMemberOrders(String ssn, Order order) {
        MongoCollection<ClubMember> collection = DBInstance.connectDB().getCollection(MEMBERS_COLLECTION, ClubMember.class);
        collection.updateOne(Filters.eq("sSN", ssn), Updates.push("listOfOrders", order));
    }

    public static int getNumberOfEligibleOrders(String ssn) {
        MongoCollection<ClubMember> collection = DBInstance.connectDB().getCollection(MEMBERS_COLLECTION, ClubMember.class);
        ClubMember member = collection.find(Filters.eq("sSN", ssn)).first();

        int sum = 0;
        for (Order order : member.getListOfOrders()) {
            for (Product product : order.getOrderItems()) {
                if ( !(product.getName().getEnglish().equals("Whole Bean Coffee") ) ) {
                    sum++;
                }
            }
        }

        return sum;
    }

    private static List<ClubMember> getMemberList(FindIterable<ClubMember> result) {
        List<ClubMember> members = new ArrayList<>();

        for (ClubMember member : result) {
            members.add(member);
        }
        return members;
    }
}
