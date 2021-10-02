package javamongo;
import com.mongodb.*;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import java.util.logging.Level;
import java.util.logging.Logger;
public class JavaMongo {

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            //Logger off
            Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
            mongoLogger.setLevel(Level.SEVERE); 
            
            //Connection
            MongoClient mongo1 = new MongoClient("localhost",27017);
            DB db = mongo1.getDB("test_db");
            DBCollection coll = db.getCollection("test");
            
            System.out.println("Established");
            
          //Insertion   - Create
            BasicDBObject d1 = new BasicDBObject("Name","Joey").append("Rollno", "2");
            coll.insert(d1);
            //Retival   - Read
            DBCursor cursor = coll.find();
            while(cursor.hasNext())
            {
                System.out.println(cursor.next());
            }
            //Extraction
            cursor = coll.find();
            while(cursor.hasNext())
            {
                System.out.println(cursor.next().get("Name"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
