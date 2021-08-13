package Ejercicio008;

import java.awt.Choice;
import java.awt.Event;
import java.awt.TextArea;

public class MiChoice extends Choice {
	TextArea textArea;

	public MiChoice(String[] elementos, TextArea texto) {
		super();
		for (int i = 0; i < elementos.length; i++) {
			this.add(elementos[i]);
		}
		textArea = texto;
	}

	public boolean action(Event ev, Object ob) {
		textArea.setText(this.getSelectedItem());
		return true;
	}
}
