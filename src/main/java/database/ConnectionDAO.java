package database;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.io.File;
import java.util.Arrays;


public class ConnectionDAO {

    static private MongoClient mongoClient;
    static private MongoCredential credential;
    static private MongoDatabase database = null;


    static public void closeDatabase() {
        // mongoClient.close();
    }

    static public MongoDatabase getMongoDatabase() {


        try {

            if (database != null) {
                return database;
            }


            mongoClient = new MongoClient("localhost", 27017);
            database = mongoClient.getDatabase("Game");


            return database;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
