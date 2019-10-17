package com.plateau;

import com.carte.Tirage;

public class Afficheur {

	public Afficheur() {
		// TODO Auto-generated constructor stub
	}

	
	public void affiche(Tirage tirage){
		
		
		for (int i = 0; i < tirage.getCartes().size(); i++) {
			System.out.print(tirage.getCartes().get(i).getValue()+" ");
		}
		System.out.println();
		System.out.println(tirage.getResultat());
		
	}
}
