package com.solveur;

public class Operation {

	String[] element = new String[4]; 

	public Operation(Integer op1, String operateur, Integer op2, Integer resultat) {
		element[0] = new String(op1.toString());
		element[1] = new String(operateur);
		element[2] = new String(op2.toString());
		element[3] = new String(resultat.toString());
	}
	
	public Operation(String[] element) {
		for (int i = 0; i < this.element.length; i++) {
			 this.element[i]=new String(element[i]);
		}
	}

	public void affiche(){
		for (int i = 0; i < element.length-1; i++) {
			System.out.print(element[i]+" ");
		}
		System.out.println("= "+element[3]);
		
	}
	
	public String getOperationText(){
		String operationText = new String();
		
		for (int i = 0; i < element.length-1; i++) {
			operationText = operationText + element[i]+" ";
		}
		operationText = operationText + "= "+element[3];
		
		return operationText;
	}
	
	public Operation clone(){
		Operation copy = new Operation(element);
		return copy;
	}
	
}
