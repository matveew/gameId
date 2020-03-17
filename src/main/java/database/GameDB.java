package database;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.google.gson.Gson;
import warrior.Warrior;

public class GameDB {

    static ConnectionDAO connectionDAO;


    public void createNewUser(User user) {
        MongoCollection<Document> collection = getMongoDatabase().getCollection("Game");
        Document newUser = convertToDocument(user);
        collection.insertOne(newUser);
    }

    public Warrior getWarrior(String id) {
        MongoCollection<Document> collection = getMongoDatabase().getCollection("Game");
        Document filter = new Document("id", id);
        Document document = collection.find(filter).first();
        User user = convertToUser(document);
        return user.getWarrior();
    }

    public void updateWarrior(Warrior warrior) {
        MongoCollection<Document> collection = getMongoDatabase().getCollection("Game");
        Document filter = new Document("id", warrior.getId());
        Document document = collection.find(filter).first();
        User user = convertToUser(document);
        user.setWarrior(warrior);
        Document updated = convertToDocument(user);
        collection.updateOne(filter, new Document("$set", updated));
        closeDatabase();
    }


    static private void closeDatabase() {
        connectionDAO.closeDatabase();
    }

    static private MongoDatabase getMongoDatabase() {
        if (connectionDAO != null)
            return connectionDAO.getMongoDatabase();
        connectionDAO = new ConnectionDAO();
        return connectionDAO.getMongoDatabase();

    }

    static private User convertToUser(Document document) {
        Gson gson = new Gson();
        return gson.fromJson(document.toJson(), User.class);

    }

    static private Document convertToDocument(User user) {
        Gson gson = new Gson();
        String json = gson.toJson(user);
        return new Document(Document.parse(json));

    }


}
