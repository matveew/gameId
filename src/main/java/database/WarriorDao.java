package database;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.google.gson.Gson;
import org.telegram.telegrambots.meta.api.objects.User;
import scanerio.Position;
import warrior.*;
import database.PositionDao;

import javax.print.Doc;
import java.util.ArrayList;


public class WarriorDao {

    PositionDao positionDao = new PositionDao();


    static public void saveNewWarrior(Warrior warrior) {
        MongoCollection<Document> collection = ConnectionDAO.getMongoDatabase().getCollection("Warrior");
        Document filter = new Document();
        filter.append("id", warrior.getId());
        if (collection.find(filter).first() == null) {
            Document newWarrior = convertToDocument(warrior);
            collection.insertOne(newWarrior);
        } else {
            updateWarrior(warrior);
        }
    }

    static public Warrior getWarrior(int id) {
        MongoCollection<Document> collection = ConnectionDAO.getMongoDatabase().getCollection("Warrior");
        Document filter = new Document("id", id);
        Document document = collection.find(filter).first();
        Warrior warrior = convertToWarrior(document);
        return warrior;
    }

    public Position getPositionWarriorAdversary(Position position){
        MongoCollection<Document> collection = ConnectionDAO.getMongoDatabase().getCollection("Position");
        String positionString = position.getPosition();
        positionDao.setPosition(position.getId(),"any position", position.getIdPositionWarriorAdversery());
        Document filter = new Document("position",positionString);
        Document document = collection.find(filter).first();
        positionDao.setPosition(position.getId(),positionString, position.getIdPositionWarriorAdversery());
        Position positionWarriorAdversary = positionDao.getPosition(document.getInteger("id"));

        return  positionWarriorAdversary;

    }






    static private void updateWarrior(Warrior warrior) {
        MongoCollection<Document> collection = ConnectionDAO.getMongoDatabase().getCollection("Warrior");
        Document filter = new Document("id", warrior.getId());
        Document updated = convertToDocument(warrior);
        collection.updateOne(filter, new Document("$set", updated));
        ConnectionDAO.closeDatabase();
    }

    static private Warrior convertToWarrior(Document document) {


        if (document == null)
            return null;

        Gson gson = new Gson();


        if (document.getString("type").equals("Wizard"))
            return gson.fromJson(document.toJson(), Wizard.class);

        if (document.getString("type").equals("Robber"))
            return gson.fromJson(document.toJson(), Robber.class);


        return null;

    }

    static private Document convertToDocument(Warrior warrior) {
        Gson gson = new Gson();

        String json = gson.toJson(warrior);


        Document document = new Document(Document.parse(json));

        document.append("type", warrior.getClass().getName().replace("warrior.", ""));
        return document;
    }

    public static void main(String[] args) {


        Warrior warrior = getWarrior(433847754);

        warrior.setLevel(5);

        saveNewWarrior(warrior);

        System.out.println(warrior.getLevel());

    }





}
