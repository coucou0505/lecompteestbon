package com.view.element;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.plateau.Model;

public class JPanelSolution extends JPanel {
	
	public JPanelSolution(Model model) {
		
		PanelLabelText nombre;
		PanelLabelText resultat;
		
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblSolution = new JLabel("Solution");
		add(lblSolution, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout());
		
		nombre = new PanelLabelText("Nombres");
		resultat = new PanelLabelText("Resultat");
		panel.add(nombre);
		panel.add(resultat);
		
		
		JButton btnSolution = new JButton("Solution");
		btnSolution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new ControleurSolution(model).searchSolution(nombre.getText(), resultat.getText());

			}
		});
		panel.add(btnSolution);
		// TODO Auto-generated constructor stub
	}



}
