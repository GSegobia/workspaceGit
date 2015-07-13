package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import principal.Querys;

public class ParameterQuery1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final JTextField 	cursoTxt = new JTextField();
	private final JButton okButton = new JButton("OK");
	private final JButton cancelButton = new JButton("Cancel");

	public ActionListener confirmar(){
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						QueryAnswer1 resposta1 = new QueryAnswer1(cursoTxt.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					dispose();
			}
		};
	}
	public ActionListener cancelar(){
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};
	}
	
	
	public ParameterQuery1() {
		setBounds(100, 100, 390, 146);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		

		cursoTxt.setBounds(86, 36, 257, 20);
		contentPanel.add(cursoTxt);
		cursoTxt.setColumns(10);
		
		JLabel lblNomeCurso = new JLabel("Nome Curso");
		lblNomeCurso.setBounds(10, 39, 76, 14);
		contentPanel.add(lblNomeCurso);
		
		JLabel lblRetornarOsNomes = new JLabel("Query 1: Retornar os nomes e as matr\u00EDculas dos alunos de um curso");
		lblRetornarOsNomes.setBounds(17, 11, 347, 14);
		contentPanel.add(lblRetornarOsNomes);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		okButton.addActionListener(confirmar());
		cancelButton.addActionListener(cancelar());
		buttonPane.add(cancelButton);

		
	setVisible(true);
	}
}
