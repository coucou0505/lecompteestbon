package com.plateau;

import java.util.ArrayList;

import com.carte.Carte;
import com.carte.CompteurResultat;
import com.carte.Tirage;
import com.carte.Urne;

public class Plateau {

	private Urne urne;
	private CompteurResultat compteur;

	public Plateau(Model model) {
		urne  = new Urne(Model.LISTE_CARTES); 
		compteur = new CompteurResultat(Model.RESULTAT_VALEUR_MINIMUM,Model.RESULTAT_VALEUR_MAXIMUM);

	}


	public Tirage tirer(){
		ArrayList<Carte> tirageCarte = urne.tirage(Model.NOMBRE_DE_CARTES_PAR_TIRAGE);
		Integer resultat = compteur.tirageResultat();

		Tirage tirage = new Tirage(tirageCarte,resultat);

		return tirage;
	}



}
