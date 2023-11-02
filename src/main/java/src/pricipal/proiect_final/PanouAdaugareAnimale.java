package src.pricipal.proiect_final;

import javax.swing.*;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class PanouAdaugareAnimale extends JPanel {
	
	//Andrei - initializez colectia pentru animale
	static MongoClient client = MongoClients.create("mongodb+srv://Dumi:0ok9ij8uh@cluster0.ytjeywp.mongodb.net/?retryWrites=true&w=majority");
	
	static MongoDatabase db = client.getDatabase("PetShop");
	
	static MongoCollection<Document> col = db.getCollection("animale");
	
	List<Document> dateBD = new ArrayList<>();
	
	JTextField txtNume = new JTextField();
    JTextField txtCainePisica = new JTextField();
    JTextField txtRasa = new JTextField();
    JTextField txtVarsta = new JTextField();
    private BufferedImage backgroundImage;
    
    
    	
    
        PanouAdaugareAnimale() {

        	try {
                backgroundImage = ImageIO.read(new File("C:\\Users\\scorp\\an\\poo\\pfinal\\Proiect-final-master\\PanouAdaugareAnimaleBackground.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        	
        	
		this.setLayout(null);
		
		JButton butonOK = new JButton("OK");
		JButton butonAnuleaza = new JButton("Anuleaza");
		
		butonOK.setToolTipText("Apasa OK pentru a aduga un nou animal in baza de date!");
		butonAnuleaza.setToolTipText("Apasa Anuleaza pentru a elimina din casuta datele despre animal!");
		
		JLabel etichetaDepartamentAdugareAnimale = new JLabel("Adugare animal nou");
	    JLabel etichetaNume = new JLabel("Nume");
	    JLabel etichetaCainePisica = new JLabel("Caine/Pisica");
	    JLabel etichetaRasa = new JLabel("Rasa");
	    JLabel etichetaVarsta = new JLabel("Varsta");
	    
	    this.add(etichetaDepartamentAdugareAnimale);
		this.add(etichetaNume);
		this.add(etichetaCainePisica);
		this.add(etichetaRasa);
		this.add(etichetaVarsta);
		
		this.add(butonOK);
		this.add(butonAnuleaza);
		
		this.add(txtNume);
		this.add(txtCainePisica);
		this.add(txtRasa);
		this.add(txtVarsta);
	    
		butonOK.setBounds(290,300,100,20);
		butonAnuleaza.setBounds(400,300,100,20);
		
		etichetaDepartamentAdugareAnimale.setBounds(320,150,150,20);
		etichetaNume.setBounds(290,180,100,20);
		etichetaCainePisica.setBounds(290,210,100,20);
		etichetaRasa.setBounds(290,240,100,20);
		etichetaVarsta.setBounds(290,270,100,20);
		
		txtNume.setBounds(400,180,100,20);
		txtCainePisica.setBounds(400,210,100,20);
		txtRasa.setBounds(400,240,100,20);
		txtVarsta.setBounds(400,270,100,20);
		
		butonOK.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent o) {
				String nume = txtNume.getText();
				String caiPis = txtCainePisica.getText();
				String rasa = txtRasa.getText();
				String varsta = txtVarsta.getText();
				
				Document doc = new Document();
				if(nume.isEmpty() || caiPis.isEmpty() || rasa.isEmpty() || varsta.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Completeaza toate spatiile!!!");
				}else {
					doc.append("Nume", nume);
					doc.append("Tip animal", caiPis);
					doc.append("Rasa:", rasa);
					doc.append("Varsta", varsta);
					
						col.insertOne(doc);
				
					txtNume.setText("");
					txtCainePisica.setText("");
					txtRasa.setText("");
					txtVarsta.setText("");
					
					JOptionPane.showMessageDialog(null, "Animal inregistrat cu succes!!");
						
					}
				}
			
			});
		
		butonAnuleaza.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ai apasat butonul anulaeaza");
				txtNume.setText("");
				txtCainePisica.setText("");
				txtRasa.setText("");
				txtVarsta.setText("");
			}
			
		});
		
	}

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }   
        
        
}

