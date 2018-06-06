package configuration;

import java.lang.reflect.Constructor;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import play.api.Configuration;
import play.api.Environment;
import play.inject.ApplicationLifecycle;

public class PlayMorphia {

	    MongoClient mongo = null;
	    Datastore datastore = null;
	    Morphia morphia = null;

	    @Inject
	    public PlayMorphia(ApplicationLifecycle lifecycle, Environment env, Configuration config) {
	        try {
	            configure(config, env.classLoader());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        lifecycle.addStopHook(()->{
	            return CompletableFuture.completedFuture(null);
	        });
	    }


	    PlayMorphia(Configuration config, ClassLoader classLoader) throws Exception {
	        configure(config,classLoader);
	    }


	    private void configure(Configuration config, ClassLoader classLoader) throws Exception {

	        //String clientFactoryName = config.getString("playmorphia.mongoClientFactory");
	        MongoClientFactory factory = getMongoClientFactory("controllers.mongoConfiguration.MyMongoClientFactory", config);
	        System.out.println("Factory is ==================:"+factory);
	        mongo = factory.createClient();

	        if (mongo == null) {
	            throw new IllegalStateException("No MongoClient was created by instance of "+ factory.getClass().getName());
	        }

	        morphia = new Morphia();

	        // Tell Morphia where to find our models
	        //morphia.mapPackage(factory.getModels());

	        datastore = morphia.createDatastore(
	                mongo, factory.getDBName());
	        
	        System.out.println("Datastore is ===========================>>>>>>>>> :" + datastore);

	    }

	    @SuppressWarnings({ "rawtypes", "unchecked" })
	    protected MongoClientFactory getMongoClientFactory(String className, Configuration config) throws Exception {

	        if (className != null) {
	            try {
	                Class factoryClass = Class.forName(className, true, Thread.currentThread().getContextClassLoader());
	                if (!MongoClientFactory.class.isAssignableFrom(factoryClass)) {
	                    throw new IllegalStateException("mongoClientFactory '" + className +
	                            "' is not of type " + MongoClientFactory.class.getName());
	                }

	                Constructor constructor = null;
	                try {
	                    constructor = factoryClass.getConstructor(Configuration.class);
	                } catch (Exception e) {
	                    // can't use that one
	                }
	                if (constructor == null) {
	                    return (MongoClientFactory) factoryClass.newInstance();
	                }
	                return (MongoClientFactory) constructor.newInstance(config);
	            } catch (ClassNotFoundException e) {
	                throw e;
	            }
	        }
	        return new MongoClientFactory(config);
	    }


	    public Mongo mongo() {
	        return mongo;
	    }
	    public Datastore datastore() { return datastore; }
	    public Morphia morphia() { return morphia; }
}
