package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ActionListeners.QueryAction;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};
	}
	

	public MainFrame() {
		setBounds(100, 100, 388, 250);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnArquivo.add(mntmSobre);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnArquivo.add(mntmSair);
		
		JMenu mnNewMenu = new JMenu("Query");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmQuery1 = new JMenuItem("Query 1");
		mnNewMenu.add(mntmQuery1);
		mntmQuery1.addActionListener(QueryAction.getQuery1());
		
		JMenuItem mntmQuery2 = new JMenuItem("Query 2");
		mnNewMenu.add(mntmQuery2);
		mntmQuery2.addActionListener(QueryAction.getQuery2());

		
		JMenuItem mntmQuery3 = new JMenuItem("Query 3");
		mnNewMenu.add(mntmQuery3);
		mntmQuery3.addActionListener(QueryAction.getQuery3());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		setVisible(true);
	}

}
