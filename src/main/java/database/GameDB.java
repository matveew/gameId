package database;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.google.gson.Gson;
import org.telegram.telegrambots.meta.api.objects.User;
import warrior.Warrior;


public class GameDB {

    static ConnectionDAO connectionDAO;


    static public void saveNewWarrior(Warrior warrior) {
        MongoCollection<Document> collection = getMongoDatabase().getCollection("Game");
        Document newWarrior = convertToDocument(warrior);
        collection.insertOne(newWarrior);
    }

    static public Warrior getWarrior(int id) {
        MongoCollection<Document> collection = getMongoDatabase().getCollection("Game");
        Document filter = new Document("id", id);
        Document document = collection.find(filter).first();
        Warrior warrior = convertToWarrior(document);
        return warrior;
    }

    static public void updateWarrior(Warrior warrior) {
        MongoCollection<Document> collection = getMongoDatabase().getCollection("Game");
        Document filter = new Document("id", warrior.getId());
        Document document = collection.find(filter).first();
        Warrior newWarrior = convertToWarrior(document);
        Document updated = convertToDocument(newWarrior);
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

    static private Warrior convertToWarrior(Document document) {
        Gson gson = new Gson();
        return gson.fromJson(document.toJson(), Warrior.class);

    }

    static private Document convertToDocument(Warrior warrior) {
        Gson gson = new Gson();
        String json = gson.toJson(warrior);
        return new Document(Document.parse(json));

    }


    public static void main(String[] args) {
        System.out.println(GameDB.getWarrior(160450965).getName());
    }

}
