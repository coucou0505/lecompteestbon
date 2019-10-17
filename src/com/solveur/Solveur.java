package com.solveur;

import java.util.ArrayList;

import com.carte.Carte;
import com.carte.Tirage;

public class Solveur {

	int resultat;

	ArrayList<Solution> solutionList;

	//boolean bCont = true;

	public Solveur() {		
	}

	public ArrayList<Solution> resoudre(Tirage tirage){
		Solution solution = new Solution();
		ArrayList<Carte> carte = tirage.getCartes();
		this.resultat = tirage.getResultat();
		solutionList = new ArrayList<Solution>();

		//bCont = true;

		evaluation(carte,solution);

		return solutionList;
	}

	
	public ArrayList<Solution> resoudre(int[] carteliste,int resultat){
		Solution solution = new Solution();
		
		ArrayList<Carte> carte = new ArrayList<Carte>();
		
		this.resultat =  resultat;
		solutionList = new ArrayList<Solution>();
	
		for (int i = 0; i < carteliste.length; i++) {
			carte.add(new Carte(carteliste[i]));
		}
		
		
		//bCont = true;

		evaluation(carte,solution);

		return solutionList;
	}
	
	
	private void evaluation(ArrayList<Carte> cartes, Solution solution){

		Carte[] carteOperation = new Carte[4];
		Operation[] operation = new Operation[4];
		Carte operande1;
		Carte operande2;


		for (int i = 0; i < cartes.size()-1 //&& bCont
				; i++) {

			if( i== 0 || (i>0 &&  (cartes.get(i-1).getValue() != cartes.get(i).getValue() )   ) ){

				for (int j = i+1; j < cartes.size() //&& bCont
						; j++) {

					///////////////////
					// ADD
					///////////////////
					carteOperation[0] = new Carte(cartes.get(i).getValue() + cartes.get(j).getValue());
					operation[0]=new Operation(cartes.get(i).getValue(), "+", cartes.get(j).getValue(),carteOperation[0].getValue());

					///////////////////
					// SUB
					////////////////////
					if(cartes.get(i).getValue() != cartes.get(j).getValue() ){
						carteOperation[1] = new Carte(cartes.get(i).getValue() - cartes.get(j).getValue());						
						operation[1]=new Operation(cartes.get(i).getValue(), "-", cartes.get(j).getValue(),carteOperation[1].getValue());

						if(carteOperation[1].getValue() < 0){
							carteOperation[1].setValue(-carteOperation[1].getValue());
							operation[1]=new Operation(cartes.get(j).getValue(), "-", cartes.get(i).getValue(),carteOperation[1].getValue());
						}

						// resultat idem a une operande
						if(cartes.get(i).getValue() == carteOperation[1].getValue() || cartes.get(j).getValue() == carteOperation[1].getValue()){
							carteOperation[1] = null;
							operation[1] = null;
						}



					}else{
						carteOperation[1] = null;
					}



					///////////////////
					// MUL
					///////////////////
					if(cartes.get(i).getValue()!=1 && cartes.get(j).getValue() != 1){
						carteOperation[2] = new Carte(cartes.get(i).getValue() * cartes.get(j).getValue());
						operation[2]=new Operation(cartes.get(i).getValue(), "*", cartes.get(j).getValue(),carteOperation[2].getValue());
					}else{
						carteOperation[2] = null;
					}

					///////////////////
					// DIV
					///////////////////
					carteOperation[3] = null;
					if( cartes.get(i).getValue() != 1 && cartes.get(j).getValue() != 1 && 
							cartes.get(i).getValue() != 0 && cartes.get(j).getValue() != 0 	){

						if(cartes.get(i).getValue() % cartes.get(j).getValue() == 0 ){
							carteOperation[3] = new Carte(cartes.get(i).getValue() / cartes.get(j).getValue());
							operation[3] = new Operation(cartes.get(i).getValue(), "/", cartes.get(j).getValue(),carteOperation[3].getValue());
						}
						if(cartes.get(j).getValue() % cartes.get(i).getValue() == 0 ){
							carteOperation[3] = new Carte(cartes.get(j).getValue() / cartes.get(i).getValue());
							operation[3] = new Operation(cartes.get(j).getValue(), "/", cartes.get(i).getValue(),carteOperation[3].getValue());
						}	

						// resultat idem a une operande
						if(carteOperation[3]!=null){
							if(cartes.get(i).getValue() == carteOperation[3].getValue() || cartes.get(j).getValue() == carteOperation[3].getValue()){
								carteOperation[3] = null;
								operation[3] = null;
							}
						}

					}

					//////////////////////////////////////////


					operande2 = cartes.remove(j);
					operande1 = cartes.remove(i);

					for (int j2 = 0; j2 < carteOperation.length //&& bCont 
							;j2++) {



						if(carteOperation[j2] != null){
							solution.addOperation(operation[j2]);

							if(carteOperation[j2].getValue()==resultat){

								solutionList.add(solution.clone());

								//bCont = false; 

							}else{


								cartes.add(carteOperation[j2]);
								evaluation(cartes,solution);
								cartes.remove(carteOperation[j2]);
							}

							solution.removeLastOperation();
						}

					}
					cartes.add(i, operande1);
					cartes.add(j, operande2);

				}
			}
		}
	}

}
