package configuration;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import play.api.Configuration;

public class MongoClientFactory {
	protected Configuration config;
    protected boolean isTest;

    public MongoClientFactory(Configuration config) {
        this.config = config;
    }

    protected MongoClientFactory(Configuration config, boolean isTest) {
        this.config = config;
        this.isTest = isTest;
    }

/**
     * Creates and returns a new instance of a MongoClient.
     *
     * @return a new MongoClient
     * @throws Exception
     */
    public MongoClient createClient() throws Exception {
        MongoClientURI uri = getClientURI();

        MongoClient mongo = new MongoClient(uri);
        DB db = new DB(mongo, uri.getDatabase());

        return mongo;
    }


/**
     * Returns the database name associated with the current configuration.
     *
     * @return The database name
     */
    public String getDBName() {
    	System.out.println("DB name is :" +getClientURI().getDatabase());
        return getClientURI().getDatabase();
    }

    protected MongoClientURI getClientURI() {
        MongoClientURI uri = new MongoClientURI("mongodb://127.0.0.1:27017/studentDB");
        return uri;
    }

}
