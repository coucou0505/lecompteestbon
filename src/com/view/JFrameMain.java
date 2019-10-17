package com.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.plateau.Model;
import com.view.element.AfficheTirage;
import com.view.element.AfficheurSolution;
import com.view.element.ControlerText;
import com.view.element.JPanelJouer;
import com.view.element.JPanelSolution;
import com.view.element.PanelTextDisplay;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JFrameMain extends JFrame{

	Model model;
	AfficheurSolution affiSol;
	ControlerText controlText;
	
	public JFrameMain(Model model) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
		PanelTextDisplay panelDisplay;
		
		this.model = model;
		
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JPanel panelJeu = new JPanel();
		panel.add(panelJeu);
		panelJeu.setLayout(new BorderLayout(0, 0));
		panelJeu.add(new JPanelJouer(model),BorderLayout.CENTER);
		
		
		JPanel panelSol = new JPanel();
		panel.add(panelSol);
		panelSol.setLayout(new BorderLayout(0, 0));
		panelSol.add(new JPanelSolution(model),BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		panelDisplay = new PanelTextDisplay();
		panel_1.add(panelDisplay, BorderLayout.CENTER);
		
		
		// TODO Auto-generated constructor stub
		
		controlText = new ControlerText(model.getValue("MessagePanel") , panelDisplay);
		affiSol = new AfficheurSolution(model.getValue("MessagePanel"), model.getValue("Solution"));
		new AfficheTirage(model.getValue("Tirage"), model.getValue("MessagePanel"));
		
		
		setSize(400, 400);
		setVisible(true);
	}

}
