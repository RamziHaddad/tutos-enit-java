import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.BsonField;
import com.mongodb.client.result.DeleteResult;

public class PersonsDAOImpl implements PersonsDAO {
	/*
	 * si avec auth
	 * MongoClient mongoClient = new MongoClient();
	 * DB database = mongoClient.getDB("myMongoDb");
	 * boolean auth = database.authenticate("username", "pwd".toCharArray());
	 */
	private static MongoClient mongoClient = new MongoClient("localhost", 27017);
	private static MongoDatabase db = mongoClient.getDatabase("08-formation-mongodb");
	public Optional<Person> findById() {
		db.getCollection("persons").find();
		return null;
	}

	public void save(Person p) {
		Document r = new Document("_id", new ObjectId());
		r.append("name", p.getName());
		r.append("age", p.getAge());
		db.getCollection("persons").insertOne(r);
		
	}

	public List<Person> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Person> findByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Person> findByAgeBetween(int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeById(String id) {
		// TODO Auto-generated method stub
		
	}

	public void update(Person p) {
		// TODO Auto-generated method stub
		
	}

	public void removeAll() {
		DeleteResult res = db.getCollection("persons").deleteMany(new BasicDBObject());		
	}

	public List<Person> findAll() {
		List<Person>l = new ArrayList<Person>();
		FindIterable<Document> res = db.getCollection("persons").find();		
		for(Document p:res) {
			System.out.println(p);
			System.out.println("-----------------------");

		}
		return l;
	}
	
	


}
