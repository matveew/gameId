package database;

import com.mongodb.client.MongoCollection;
import javafx.geometry.Pos;
import org.bson.Document;
import scanerio.Position;
import warrior.Warrior;

public class PositionDao {

    static public Position getPosition(int id) {

        MongoCollection<Document> collection = ConnectionDAO.getMongoDatabase().getCollection("Position");
        Document filter = new Document("id", id);
        Document document = collection.find(filter).first();

        if (document == null) {
            Position position = new Position();
            position.setPosition("registration");
            position.setId(id);
            setPosition(position);
            return position;

        }

        Position position = new Position();
        position.setPosition(document.getString("position"));
        position.setId(id);
        return position;

    }

    static public void setPosition(int id, String position) {
        MongoCollection<Document> collection = ConnectionDAO.getMongoDatabase().getCollection("Position");

        System.out.println("id: "+id);
        Document filter = new Document("id", id);

        Document document = collection.find(filter).first();

        if (document == null) {

            document = new Document();
            document.append("id", id);
            document.append("position", position);
            collection.insertOne(document);
            ConnectionDAO.closeDatabase();
            return;
        }
        document.append("position", position);
        collection.updateOne(filter, new Document("$set", document));

    }


    static public void setPosition(Position position) {
        setPosition(position.getId(), position.getPosition());
    }


    public static void main(String[] args) {
        System.out.println(getPosition(160450965).getPosition());
    }


}
