package src.pricipal.proiect_final;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Objects;

public class TabelAnimale extends AbstractTableModel {
	
	static MongoClient client = MongoClients.create("mongodb+srv://Dumi:0ok9ij8uh@cluster0.ytjeywp.mongodb.net/?retryWrites=true&w=majority");
	
	static MongoDatabase db = client.getDatabase("PetShop");
	
	static MongoCollection<Document> col = db.getCollection("animale");
	
    private List<Document> date;
    

	public TabelAnimale(List<Document> date){
        this.date = date;
    }

    @Override
    public int getRowCount(){
        return date.size();
    }

    @Override
    public int getColumnCount(){
        return 4;
    }
    
    public Document getDocumentById(String collectionName, String documentId) {
        // Create a MongoClient and connect to your MongoDB server
            MongoCollection<Document> collection = db.getCollection(collectionName);

            // Convert the documentId to ObjectId
            ObjectId objectId = new ObjectId(documentId);

            // Search for the document by its _id field (ObjectId)
            Document query = new Document("_id", objectId);

            // Find the document
            FindIterable<Document> result = collection.find(query);
            Document document = result.first();

            return document;
        
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "Nume";
            case 1:
                return "Tip animal";
            case 2:
            	return "Rasa";
            case 3:
            	return "Varsta";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int row, int column){
        Document docc = date.get(row);
        switch (column){
            case 0:
                return docc.get("Nume");
            case 1:
                return docc.get("Tip animal");
            case 2:
            	return docc.get("Rasa");
            case 3:
            	return docc.get("Varsta");
            default:
                return null;
        }
    }
}
