package src.pricipal.proiect_final;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.Font;

public class PanouAdoptieAnimale extends JPanel{
	
	private JTable table;
    private DefaultTableModel tableModel;

	public PanouAdoptieAnimale() {
		
		this.setBackground(Color.blue);
        this.setLayout(new BorderLayout());

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nume");
        tableModel.addColumn("Caine/Pisica");
        tableModel.addColumn("Rasa");
        tableModel.addColumn("Varsta");

        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
		
	}
	
}

