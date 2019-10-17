package com.carte;

public class Carte implements Comparable<Carte>{
private Integer value;

public Carte(int value){
	this.value = value;
}

public Integer getValue() {
	return value;
}

public void setValue(int value) {
	this.value = value;
}

public int compareTo(Carte o){

	 return value-o.getValue();
}

}
