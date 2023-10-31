package src.pricipal.proiect_final;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Meniu extends JFrame implements ActionListener{
	
	private JMenuBar baraMeniu = new JMenuBar();
	private JMenu meniu;
	private JMenuItem adaugare, adoptie;
	private JFrame cadru = new JFrame();
	private PanouAdaugareAnimale panouAdauagreAnimale = new PanouAdaugareAnimale();
    private PanouAdoptieAnimale panouAdoptieAnimale = new PanouAdoptieAnimale();
    
    public Meniu() {
    	
    	cadru.setVisible(true);
    	cadru.setSize(800, 600);
    	cadru.setLocationRelativeTo(null);
    	cadru.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	cadru.setMinimumSize(new Dimension(800, 600));
    	
    	cadru.setLayout(new BoxLayout(cadru.getContentPane(), BoxLayout.X_AXIS));
		cadru.add(panouAdauagreAnimale);
		
		meniu = new JMenu("Meniu");
		
		adaugare = new JMenuItem("Adaugare animale");
		adoptie = new JMenuItem("Adoptie animale");
		
		adaugare.addActionListener(this);
		adoptie.addActionListener(this);
		
		baraMeniu.add(meniu);
		
		meniu.add(adaugare);
		meniu.add(adoptie);
		
		cadru.setJMenuBar(baraMeniu);
		cadru.pack();
		cadru.repaint();
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == adaugare) {
		    System.out.println("Ai apasat opsiunea adaugare animale");
		    cadru.remove(panouAdoptieAnimale);
		    cadru.add(panouAdauagreAnimale);
		    cadru.pack();
			cadru.repaint();
		    }
		if(e.getSource() == adoptie) {
			System.out.println("Ai apasat optiunea adoptie");
			cadru.remove(panouAdauagreAnimale);
			cadru.add(panouAdoptieAnimale);
		    cadru.pack();
			cadru.repaint();
			}
	}

}

