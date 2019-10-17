package com.solveur;

import java.util.ArrayList;

public class Solution {

	ArrayList<Operation> operations = new ArrayList<Operation>();

	public Solution() {
		// TODO Auto-generated constructor stub
	}


	public void addOperation(Operation op){
		operations.add(op);
	}


	public void removeOperation(Operation op){
		operations.remove(op);
	}

	public void removeLastOperation(){
		operations.remove(operations.size()-1);
	}

	public Solution clone(){
		Solution copy = new Solution();

		for (int i = 0; i < operations.size(); i++) {
			copy.addOperation(operations.get(i).clone());
		}
		return copy;
	}
	
	public void affiche(){
		for (int i = 0; i < operations.size(); i++) {
			operations.get(i).affiche();
		}
		
	}
	
	public String getSolution(){
		String solutionTxt = new String();
		
		for (int i = 0; i < operations.size(); i++) {
			solutionTxt = solutionTxt + operations.get(i).getOperationText()+"\n";
		}
		return solutionTxt;
	}
	
	
}
