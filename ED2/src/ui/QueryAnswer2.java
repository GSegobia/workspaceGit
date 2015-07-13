package ui;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import principal.Querys;

public class QueryAnswer2 extends JFrame {
	private static final String endereco = "D:/GitHub/workspaceGit/ED2/src/respostas/";
	private JPanel contentPane;
	private JTable table;
	private JLabel lblListaDeProfessores;

	public QueryAnswer2(String parametro) throws IOException {
		Querys.query2(parametro);
		
		Scanner fileIn = new Scanner(new File(endereco + "query2.txt"));
		int count = 0;
		
		while (fileIn.hasNextLine()) {
		    count++;
		    fileIn.nextLine();
		}
		
		fileIn.close();
		fileIn=null;
		fileIn = new Scanner(new File(endereco + "query2.txt"));
		
		
		setTitle("Visualizador de Query");
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		table = new JTable(count,1);
		contentPane.setLayout(null);
		
		lblListaDeProfessores = new JLabel("Respostas da Query");
		lblListaDeProfessores.setBounds(408, 11, 250, 50);
		lblListaDeProfessores.setForeground(Color.DARK_GRAY);
		lblListaDeProfessores.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblListaDeProfessores);
		
		JScrollPane scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setViewportView(table);
		scroll.setBounds(27, 67, 967, 552);
		contentPane.add(scroll);
		
		
		table.getColumnModel().getColumn(0).setHeaderValue("Nome Disciplinas");
		
		int i =0;
		while (fileIn.hasNextLine()) {
		    String a[]= fileIn.nextLine().split("\t");
			table.setValueAt( a[0],i,0);
			i++;
		}
//		
		this.setResizable(false);	
		setVisible(true);
		
	}
}
