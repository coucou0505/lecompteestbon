package com.view.element;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import com.solveur.Solution;
import com.tools.Value;

public class AfficheurSolution implements Observer{

	private final String SEPARATOR = "------------------------------";
	
	Value message;
	Value solution;

	public AfficheurSolution(Value message, Value solution) {
		this.message = message;
		this.solution = solution;
		solution.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		ArrayList<Solution> solutionList = (ArrayList<Solution> ) solution.getValue();

		message.setValue(SEPARATOR+"\n");
		message.setValue("Nombre de solutions : "+solutionList.size()+"\n");
		if(solutionList != null){

			for (int i = 0; i < solutionList.size(); i++) {
				message.setValue(SEPARATOR+"\n");
				message.setValue(solutionList.get(i).getSolution());
			}
			message.setValue(SEPARATOR+"\n");


		}

	}

}
