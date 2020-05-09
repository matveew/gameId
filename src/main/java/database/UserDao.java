package database;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.bson.Document;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;

public class UserDao {


    static public void saveNewUser(User user) {

        MongoCollection<Document> collection = ConnectionDAO.getMongoDatabase().getCollection("User");

        int id = user.getId();
        Document filter = new Document("id", id);
        Document document = collection.find(filter).first();

        if (document == null) {
            Document newUser = convertToDocument(user);
            collection.insertOne(newUser);
        }
    }

    static public User getUser(int id) {

        MongoCollection<Document> collection = ConnectionDAO.getMongoDatabase().getCollection("User");

        Document filter = new Document("id", id);
        Document document = collection.find(filter).first();

        if (document == null)
            return null;

        User user = convertToUser(document);

        return user;
    }


    static private Document convertToDocument(User user) {

        Gson gson = new Gson();

        String json = gson.toJson(user);

        Document document = new Document(Document.parse(json));


        return document;
    }

    static private User convertToUser(Document document) {

        if (document == null)
            return null;

        Gson gson = new Gson();

        return gson.fromJson(document.toJson(), User.class);


    }

}



