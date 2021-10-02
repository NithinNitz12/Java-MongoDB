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
            System.out.println("Connection.......");
            MongoClient mongo1 = new MongoClient("localhost",27017);
            DB db = mongo1.getDB("test_db");
            DBCollection coll = db.getCollection("test");
            
            System.out.println("Established");
            //--------//
            
          //Insertion   - Create
            System.out.println("Insert.......");
            BasicDBObject d1 = new BasicDBObject("Name","Joey").append("Rollno", "2");
            coll.insert(d1);
            //--------//
            
            //Retival   - Read
            System.out.println("Read......");
            DBCursor cursor = coll.find();
            while(cursor.hasNext())
            {
                System.out.println(cursor.next());
            }
            //--------//
            
            //Extraction
            System.out.println("Extraction......");
            cursor = coll.find();
            while(cursor.hasNext())
            {
                System.out.println(cursor.next().get("Name"));
            }
            //--------//
            
            //Update
            System.out.println("Update.....");
            BasicDBObject updatedoc = new BasicDBObject();
                //New Value
            updatedoc.append("$set", new BasicDBObject().append("Rollno","20"));
                //Old Document
            BasicDBObject olddoc = new BasicDBObject().append("Name","Joey");
            coll.update(olddoc, updatedoc,false,false);
            //--------//
            
            //Delete
            System.out.println("Delete.....");
            BasicDBObject del = new BasicDBObject("Rollno","2");
            coll.remove(del);
            DBCursor cursor3 = coll.find();
            while (cursor3.hasNext())
            {                
                System.out.println(cursor3.next());
            }
            //--------//
            
            //Search 
            System.out.println("Search.......");
            BasicDBObject d2 = new BasicDBObject("Name","Joey");
            DBCursor cursor2 = coll.find(d2);
            while (cursor2.hasNext())
            {                
                System.out.println(cursor2.next());
            }
            //--------//
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
