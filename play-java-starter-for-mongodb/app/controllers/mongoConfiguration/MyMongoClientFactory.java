package controllers.mongoConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import configuration.MongoClientFactory;
import play.api.Configuration;

public class MyMongoClientFactory extends MongoClientFactory{
    public MyMongoClientFactory(Configuration config) {
        super(config);
        this.config = config;
    }
     public MongoClient createClient() throws Exception {
         return new MongoClient(new ServerAddress("localhost", 27017));
     }

}
