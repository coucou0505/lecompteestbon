package com;

import java.util.ArrayList;

import com.carte.Tirage;
import com.plateau.Afficheur;
import com.plateau.Model;
import com.plateau.Plateau;
import com.solveur.Solution;
import com.solveur.Solveur;
import com.view.JFrameMain;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();		
		//Plateau plateau = new Plateau(model);	
		//Tirage tirage = plateau.tirer();
		//Afficheur afficheur  = new Afficheur();
		//Solveur solveur = new Solveur();
		//ArrayList<Solution> solutions = new ArrayList<Solution>();
		
//		int avecSolution = 0;
//		int totalTirage = 1000000;		
//		for (int i = 0; i < totalTirage; i++) {
//			tirage = plateau.tirer();
//			solutions = solveur.resoudre(tirage);
//			
//			if(solutions.size()>0){
//				avecSolution++;
//			}
//			
//			if((i+1)%5000 == 0){
//				System.out.println( (i+1)+","+avecSolution+","+(avecSolution/(double)(i+1)));
//			}
//			
//		}
//		System.out.println(avecSolution+"/"+totalTirage);
		
		
//		afficheur.affiche(tirage);
//		solutions = solveur.resoudre(tirage);
//		
//		
//		
//		System.out.println("-------------------------------");
//		System.out.println("Nombre de solutions trouvees : "+solutions.size());
//		for (int i = 0; i < solutions.size(); i++) {
//			System.out.println("-------------------------------");
//			solutions.get(i).affiche();
//		}
		
		new JFrameMain(model);
		
	}

}
