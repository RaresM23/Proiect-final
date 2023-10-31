package src.pricipal.proiect_final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PanouAdaugareAnimale extends JPanel {
	
	JTextField txtNume = new JTextField();
    JTextField txtCainePisica = new JTextField();
    JTextField txtRasa = new JTextField();
    JTextField txtVarsta = new JTextField();
    private BufferedImage backgroundImage;
    
        PanouAdaugareAnimale() {

        	try {
                backgroundImage = ImageIO.read(new File("D:\\Eclipse\\proiect final\\proiect-final\\PanouAdaugareAnimaleBackground.jpg"));
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

