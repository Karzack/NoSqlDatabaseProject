package database.dao;

import com.mongodb.client.MongoCollection;
import database.DBInstance;
import database.model.Comment;
import database.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class CommentDAO {

    public static List<Comment> getComment(Employee employee){
        MongoCollection<Comment> collection = DBInstance.connectDB().getCollection("comment",Comment.class);
        List<Comment> comments = new ArrayList<Comment>();
        for (Comment comment: collection.find()) {
            comments.add(comment);
        }
        return comments;
    }

    public static void addComment(Comment comment){
        MongoCollection<Comment> collection = DBInstance.connectDB().getCollection("comment",Comment.class);
        collection.insertOne(comment);
    }
}
