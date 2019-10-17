package com.view.element;

import java.util.Observable;
import java.util.Observer;

import com.tools.Value;

public class ControlerText implements Observer{
	Value valText;
	
	PanelTextDisplay panelText;
	
	
	public ControlerText(Value val, PanelTextDisplay panelText) {
		valText = val;
		valText.addObserver(this);
		
		this.panelText= panelText;
	}


	@Override
	public void update(Observable o, Object arg) {
	
		panelText.appendText(valText.getValue().toString());
		
	}

	
	
	
}
