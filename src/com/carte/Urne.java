package com.carte;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Urne {

	private ArrayList<Carte> setCarte = new ArrayList<Carte>();

	public Urne(Integer[] value){
		for (int i = 0; i < value.length; i++) {
			setCarte.add(new Carte(value[i]));
		}
	}

	public ArrayList<Carte> tirage(int nombreDeCarte){
		ArrayList<Carte> tirage = new ArrayList<Carte>();

		for (int i = 0; i <  nombreDeCarte && setCarte.size()>0; i++) {
			tirage.add( setCarte.remove( (int) (Math.random()*setCarte.size()) ));
		}
		
		for (int i = 0; i < tirage.size(); i++) {
			setCarte.add(tirage.get(i));
		}
	
		Collections.sort(tirage);
		
		return tirage;
	}	

}
