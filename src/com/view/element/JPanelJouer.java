package com.view.element;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.carte.Tirage;
import com.plateau.Model;
import com.plateau.Plateau;

public class JPanelJouer extends JPanel {

	public JPanelJouer(Model model) {
		setLayout(new BorderLayout(0, 0));

		JLabel lblTitre = new JLabel("Jeu");
		add(lblTitre, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);

		JButton btnTirage = new JButton("Tirage");
		btnTirage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.getValue("Tirage").setValue(new Plateau(model).tirer());
			}
		});
		panel.add(btnTirage);

		JButton btnSolution = new JButton("Solution");
		btnSolution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////////
				if(model.getValue("Tirage").getValue() != null){

					new ControleurSolution(model).searchSolution((Tirage)model.getValue("Tirage").getValue());
				}
			}
		});
		panel.add(btnSolution);

	}

	public JPanelJouer(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public JPanelJouer(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public JPanelJouer(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
