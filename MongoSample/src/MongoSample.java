import com.mongodb.MongoClient;
import com.mongodb.DB;


public class MongoSample{
   public static void main( String args[] ){
      try{   
		 // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "192.168.5.122",27017 );
         // Now connect to your databases
         DB db = mongoClient.getDB( "te3115db" );
		 System.out.println("Connect to database successfully");
        
		boolean auth = db.authenticate("te3115","te3115".toCharArray());
		 System.out.println("Authentication: "+auth);
      }catch(Exception e){
	     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	  }
   }
}