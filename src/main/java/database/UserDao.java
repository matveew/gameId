package database;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.bson.Document;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;

public class UserDao {


    static public void saveNewUser(User user) {
        MongoCollection<Document> collection = ConnectionDAO.getMongoDatabase().getCollection("User");
        Document newUser = convertToDocument(user);
        collection.insertOne(newUser);
    }


    static private Document convertToDocument(User user) {

        Gson gson = new Gson();

        String json = gson.toJson(user);

        Document document = new Document(Document.parse(json));

        document.append("id", user);

        return document;
    }

}



