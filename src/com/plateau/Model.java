package com.plateau;

import java.util.Hashtable;

import com.solveur.Solveur;
import com.tools.Value;

public class Model {

	
	static public Integer NOMBRE_DE_CARTES_PAR_TIRAGE = 6; 
		
		static public Integer[] LISTE_CARTES = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,
												10,10,25,50,75,100}; 
//											10,10,25,25,50,50,75,75,100,100}; 
	static public Integer RESULTAT_VALEUR_MINIMUM = 100 ;
	static public Integer RESULTAT_VALEUR_MAXIMUM = 999 ;

	
	
//	static public Integer[] LISTE_CARTES = {1,1,2,3,6,9};
//	static public Integer RESULTAT = 264;
//	static public Integer RESULTAT_VALEUR_MINIMUM = RESULTAT ;
//	static public Integer RESULTAT_VALEUR_MAXIMUM = RESULTAT ;
	
	
	
	private Value vNombreCarteParTirage = new Value(NOMBRE_DE_CARTES_PAR_TIRAGE);
	private Value vListeCarte = new Value(LISTE_CARTES);
	private Value vResultatMinimum = new Value(RESULTAT_VALEUR_MINIMUM);
	private Value vResultatMaximum = new Value(RESULTAT_VALEUR_MAXIMUM);
	private Value vMessagePanel = new Value(new String());
	
	private Value vSolveur = new Value(new Solveur());
	
	private Value vSolution = new Value(null);
	
	private Value vTirage = new Value(null);
	
	private Hashtable<String, Object> hTable = new Hashtable<String, Object>();
	
	
	
	
	public Model() {
		// TODO Auto-generated constructor stub
		
		
		hTable.put("NombreCarteParTirage",vNombreCarteParTirage);
		
		hTable.put("ListeCarte",vListeCarte);
		hTable.put("ResultatMinimum",vResultatMinimum);
		hTable.put("ResultatMaximum",vResultatMaximum);
		
		
		hTable.put("Solveur",vSolveur);
		
		hTable.put("MessagePanel",vMessagePanel);
		
		
		hTable.put("Solution",vSolution);
		hTable.put("Tirage",vTirage);
		
		
		
		
	}


	
	
	/**
	 * return the content of value giving in parameters, according to the name
	 * @return Value
	 */
	public Value getValue(String sKey) {
		return ((Value)hTable.get(sKey));
	}
	
	
	/**
	 * return the content of value giving in parameters, according to the name
	 * @return Value
	 */
	public Object getValueObj(String sKey) {
		return ((Value)hTable.get(sKey)).getValue();
	}


	/**
	 * get the hashtable values
	 * @return Hashtable
	 */
	public Hashtable getHashTable() {
		return hTable;
	}
}
