package com.carte;

import java.util.ArrayList;

public class Tirage {

	ArrayList<Carte> carte;
	Integer resultat;
	
	
	public Tirage() {
		
	}

	
	
	public Tirage(ArrayList<Carte> cartes,  Integer resultat) {
		setCarte(cartes);
		setResultat(resultat);
	}

	public ArrayList<Carte> getCartes() {
		return carte;
	}


	public void setCarte(ArrayList<Carte> carte) {
		this.carte = carte;
	}


	public Integer getResultat() {
		return resultat;
	}


	public void setResultat(Integer resultat) {
		this.resultat = resultat;
	}

	
	
}
