package com.view.element;

import java.util.Observable;
import java.util.Observer;

import com.carte.Tirage;
import com.tools.Value;

public class AfficheTirage implements Observer{
	Value tirage;
	Value message;
	
	public AfficheTirage(Value tirage, Value message) {
		this.tirage = tirage;
		this.message = message;
		tirage.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		Tirage tiragecrt = (Tirage) tirage.getValue();
		String cartes = new String();
		String resultat;

		
		if(tiragecrt != null){
			
			for (int i = 0; i < tiragecrt.getCartes().size(); i++) {
				cartes = cartes+tiragecrt.getCartes().get(i).getValue()+" ";
			}
			resultat = tiragecrt.getResultat().toString();
			
			message.setValue(cartes+"\n");
			message.setValue(resultat+"\n");
		}
		
		
	}
	
}
