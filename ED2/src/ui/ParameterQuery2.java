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

public class ParameterQuery2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	public ActionListener confirmar(){
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						QueryAnswer2 resposta2 = new QueryAnswer2(textField.getText());
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
	
	
	public ParameterQuery2() {
		setBounds(100, 100, 390, 146);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(86, 36, 257, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNomeCurso = new JLabel("Matricula");
		lblNomeCurso.setBounds(10, 39, 76, 14);
		contentPanel.add(lblNomeCurso);
		
		JLabel lblRetornarOsNomes = new JLabel("Query 2: Retornar os nomes das disciplinas que um aluno tirou 10");
		lblRetornarOsNomes.setBounds(17, 11, 347, 14);
		contentPanel.add(lblRetornarOsNomes);
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
