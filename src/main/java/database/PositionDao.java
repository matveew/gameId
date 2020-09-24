package database;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import scanerio.Position;

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
        position.setIdPositionWarriorAdversery(document.getInteger("positionWarriorAdversary"));
        position.setId(id);
        return position;

    }




    static public void setPosition(int id, String position, int positionWarriorAdversary) {
        MongoCollection<Document> collection = ConnectionDAO.getMongoDatabase().getCollection("Position");

        System.out.println("id: " + id);
        Document filter = new Document("id", id);

        Document document = collection.find(filter).first();

        if (document == null) {

            document = new Document();
            document.append("id", id);
            document.append("position", position);
            document.append("positionWarriorAdversary",positionWarriorAdversary);
            collection.insertOne(document);
            ConnectionDAO.closeDatabase();
            return;
        }
        document.append("position", position);
        document.append("positionWarriorAdversary",positionWarriorAdversary);
        collection.updateOne(filter, new Document("$set", document));

    }






    static public void setPosition(Position position) {
        setPosition(position.getId(), position.getPosition(), position.getIdPositionWarriorAdversery());
    }

private void deleteWrongPosition(Position position, int lvl){
    String[] str = position.getPosition().split("\\.");
    if (str.length >= lvl)
        position.goBack();
}

}

