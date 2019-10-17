package com.view.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.carte.Tirage;
import com.plateau.Model;
import com.solveur.Solution;
import com.solveur.Solveur;
import com.tools.Value;

public class ControleurSolution {

	Value message;
	Model model;

	public ControleurSolution(Model model) {
		this.model = model;
		this.message = model.getValue("MessagePanel"); 

	}

	public void searchSolution(Tirage tirage){
		Solveur solveur = (Solveur)model.getValue("Solveur").getValue();
		ArrayList<Solution> solutions = solveur.resoudre(tirage);
		
		
		//AFFICHAGE
//		message.setValue(valueListDisplay+"\n");
//		message.setValue(sResult+"\n");
		
		model.getValue("Solution").setValue(solutions);
	}
	
	public void searchSolution(String valueList, String sResult){
		String[] slist;
		ArrayList<Integer> nombreCandidate = new ArrayList<Integer>();
		ArrayList<Solution> solutions;
		
		Solveur solveur;
		
		int resultat;
		int[] carteliste;

		String valueListDisplay ="";
		
		try {

			solveur = (Solveur)model.getValue("Solveur").getValue();
			
			resultat = Integer.parseInt(sResult);

			slist = valueList.split("[, ]");

			
			for (int i = 0; i < slist.length; i++) {
				try {				
					nombreCandidate.add(Integer.parseInt(slist[i]));
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
			
			Collections.sort(nombreCandidate);
			
			if(nombreCandidate.size() > 0){
				carteliste = new int[nombreCandidate.size()];

				for (int i = 0; i < nombreCandidate.size(); i++) {
					carteliste[i] = nombreCandidate.get(i);
					valueListDisplay = valueListDisplay + carteliste[i] +" ";
				}
				
				
				solutions = solveur.resoudre(carteliste, resultat);


				
				//AFFICHAGE
				message.setValue(valueListDisplay+"\n");
				message.setValue(sResult+"\n");
				
				model.getValue("Solution").setValue(solutions);
			}

		} catch (Exception e) {
			message.setValue("Liste mal definie ou resultat non valide!");
		}



	}



	public void setMessage(Value message) {
		this.message = message;
	}



}
