package src.pricipal.proiect_final;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanouAdoptieAnimale extends JPanel {

	static MongoClient client = MongoClients.create("mongodb+srv://Dumi:0ok9ij8uh@cluster0.ytjeywp.mongodb.net/?retryWrites=true&w=majority");
	
	static MongoDatabase db = client.getDatabase("PetShop");
	
	static MongoCollection<Document> colA = db.getCollection("animale");
	
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton refresh = new JButton("Refresh");

    public static List<Document> dataFetchA(){
        List<Document> dateBD = new ArrayList<>();
        MongoCursor<Document> cursor = colA.find().iterator();
        while (cursor.hasNext()) {
            dateBD.add(cursor.next());
        }
        return dateBD;
    }
    
    public PanouAdoptieAnimale() {
        // Create the table model with column names
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nume");
        tableModel.addColumn("Caine/Pisica");
        tableModel.addColumn("Rasa");
        tableModel.addColumn("Varsta");

        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
       
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the updateTableData method to refresh the table data
                updateTableData();
            }
        });

        this.add(refresh);
        updateTableData();
    }

    public void updateTableData() {
        // Clear the existing data
        tableModel.setRowCount(0);

        // Fetch data from the MongoDB collection
       
        List<Document> date = dataFetchA();

        
        DefaultTableModel dataModel = (DefaultTableModel) table.getModel();
        // Populate the table with data
        for (Document doc : date) {
            Object nume = doc.get("Nume");
            Object cainePisica = doc.get("Caine/Pisica");
            Object rasa = doc.get("Rasa");
            Object varsta = doc.get("Varsta");
            Object[] rowData = new Object[]{nume, cainePisica, rasa, varsta};
            dataModel.addRow(rowData);
            //System.out.println(nume + cainePisica + rasa + varsta);
            System.out.println("DATE AFISATE IN TABEL");
        }
        table.setModel(dataModel);
    }
    
}
