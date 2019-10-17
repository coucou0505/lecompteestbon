package com.carte;

public class CompteurResultat {

	private Integer min; 
	private Integer max;
	
	public CompteurResultat(int min, int max){
		this.min = min;
		this.max = max;
	}
	
	public Integer tirageResultat(){
		
		return min + (int)((max-min+1)*Math.random());
	}
	
}
