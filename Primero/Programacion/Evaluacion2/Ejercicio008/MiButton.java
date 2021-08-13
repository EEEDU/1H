package Ejercicio008;

import java.awt.Button;
import java.awt.Event;
import java.awt.TextArea;

public class MiButton extends Button {
	TextArea texto;

	public MiButton(String borrar, TextArea texto) {
		super(borrar);
		this.texto = texto;
	}

	public boolean action(Event ev, Object ob) {
		texto.setText(" ");
		return true;
	}
}