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

public class ParameterQuery3 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField matriculaTxt;
	private JTextField anoTxt;
	private JTextField periodoTxt;
	
	public ActionListener confirmar(){
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						QueryAnswer3 resposta3 = new QueryAnswer3(matriculaTxt.getText(),anoTxt.getText(),periodoTxt.getText());
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

	public ParameterQuery3() {
		
		
		setBounds(100, 100, 390, 256);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		matriculaTxt = new JTextField();
		matriculaTxt.setBounds(86, 64, 257, 20);
		contentPanel.add(matriculaTxt);
		matriculaTxt.setColumns(10);
		
		JLabel lblNomeCurso = new JLabel("Matricula");
		lblNomeCurso.setBounds(10, 67, 76, 14);
		contentPanel.add(lblNomeCurso);
		
		JLabel lblRetornarOsNomes = new JLabel("Query 3: Retornar os nomes das disciplinas e suas respectivas notas");
		lblRetornarOsNomes.setBounds(10, 11, 347, 14);
		
		JLabel lblRetornarOsNomes2 = new JLabel("para um aluno em um determinado ano-período");
		lblRetornarOsNomes2.setBounds(60, 25, 233, 14);
		
		contentPanel.add(lblRetornarOsNomes);
		contentPanel.add(lblRetornarOsNomes2);
		
		anoTxt = new JTextField();
		anoTxt.setColumns(10);
		anoTxt.setBounds(86, 95, 257, 20);
		contentPanel.add(anoTxt);
		
		JLabel label = new JLabel("Ano");
		label.setBounds(10, 98, 76, 14);
		contentPanel.add(label);
		
		periodoTxt = new JTextField();
		periodoTxt.setColumns(10);
		periodoTxt.setBounds(86, 126, 257, 20);
		contentPanel.add(periodoTxt);
		
		JLabel label_1 = new JLabel("Período");
		label_1.setBounds(10, 129, 76, 14);
		contentPanel.add(label_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(confirmar());
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(cancelar());
			}
		}
		
		setVisible(true);
	}
}
