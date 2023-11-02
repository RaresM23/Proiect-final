package src.pricipal.proiect_final;

import java.util.ArrayList;

import java.util.*;

import javax.swing.JOptionPane;

import org.bson.Document;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;

public class PetShop {
	
	static MongoClient client = MongoClients.create("mongodb+srv://Dumi:0ok9ij8uh@cluster0.ytjeywp.mongodb.net/?retryWrites=true&w=majority");
	
	static MongoDatabase db = client.getDatabase("PetShop");
	
	static MongoCollection<Document> col = db.getCollection("conturi");
	
	List<Document> dateBD = new ArrayList<>();
	
    
    
    public static void main(String[] args) {

        Meniu meniulMeu = new Meniu();

        while (true) {
            int optiune = afisareMeniu();

            if (optiune == 1) {
            	String enteredUsername = JOptionPane.showInputDialog("Introduceți username:");
                String enteredPassword = JOptionPane.showInputDialog("Introduceți parola:");
                
                date = dataFetch();
                
                if (isValidUser(enteredUsername, enteredPassword, date)) {
                    JOptionPane.showMessageDialog(null, "Autentificare reușită! Programul poate continua.");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Autentificare eșuată! Încercați din nou.");
                }
            } else if (optiune == 2) {
                createAccount();
            } else {
                JOptionPane.showMessageDialog(null, "Opțiune invalidă. Încercați din nou.");
            }
        }
}
    
    public static List<Document> dataFetch(){
        List<Document> dateBD = new ArrayList<>();
        MongoCursor<Document> cursor = col.find().iterator();
        while (cursor.hasNext()) {
            dateBD.add(cursor.next());
        }
        return dateBD;
    }
    
    static List<Document> date = dataFetch();
    
    private static boolean isValidUser(String enteredUsername, String enteredPassword, List<Document> date) {
        if (enteredUsername != null && enteredPassword != null) {
            for (Document doc : date) {
                String usedUsername = doc.getString("Username");
                String usedPassword = doc.getString("Parola");
                
                if (enteredUsername.equals(usedUsername) && enteredPassword.equals(usedPassword)) {
                    return true; // Authentication successful
                }
            }
        }
        return false; // Authentication failed
    }
    
    static String dataFetchUsername() {
        Document document = col.find(Filters.eq("fieldToMatch", "valueToMatch")).first();
        if (document != null) {
            String username = document.getString("Username");
            return username;
        }else {
        	
        	return null;
        	
        }
    }

    // Function to fetch the Parola from the database
    static String dataFetchPassword() {
        Document document = col.find(Filters.eq("fieldToMatch", "valueToMatch")).first();
        if (document != null) {
            String password = document.getString("Parola");
            return password;
        }else {
        	
        	return null;
        	
        }
    }
    
    // Funcția de Log In
    private static void signIn() {
        String username = JOptionPane.showInputDialog("Introduceți username:");
        String parola = JOptionPane.showInputDialog("Introduceți parola:");
        
        boolean validare = isValidUser(username, parola, date);
        
        if (validare) {
            JOptionPane.showMessageDialog(null, "Logare reușită!");
        } else {
            JOptionPane.showMessageDialog(null, "Logare eșuată. Username sau parolă incorecte.");
        }
//       return username != null && parola != null && username.equals(usernameCorect) && parola.equals(parolaCorecta);
    }
    public static void inserareCont(String username, String parola) {
    	Document contNou = new Document();
    	contNou.append("Username", username);
    	contNou.append("Parola", parola);
    	
    	col.insertOne(contNou);
    }

    //Rares-Funcția de Creare Cont Nou 
    //Andrei-Am updatat functia CreateAccount pentru a stoca conturile in baza de date
    private static void createAccount() {
        String usernameNou = JOptionPane.showInputDialog("Introduceți un nou username:");
        String parolaNoua = JOptionPane.showInputDialog("Introduceți o nouă parolă:");
        if (usernameNou != null && parolaNoua != null) {
        	Document docCont = new Document();
        	
        	docCont.append("Username", usernameNou);
        	docCont.append("Parola", parolaNoua);
        	
        	col.insertOne(docCont);
        	
//            usernameCorect = usernameNou;
//            parolaCorecta = parolaNoua;
            JOptionPane.showMessageDialog(null, "Cont creat cu succes!");
        } else {
            JOptionPane.showMessageDialog(null, "Crearea contului a eșuat. Asigurați-vă că ați introdus username și parolă valide.");
        }
    }

    // Funcție pentru afișarea meniului
    private static int afisareMeniu() {
        String[] optiuni = {"Log-in", "Creare Cont Nou"};
        int optiuneSelectata = JOptionPane.showOptionDialog(
                null,
                "Alegeți o opțiune:",
                "Log-in",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                optiuni,
                optiuni[0]
        );
        return optiuneSelectata + 1;
    }
}