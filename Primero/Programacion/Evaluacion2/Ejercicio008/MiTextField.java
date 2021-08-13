package Ejercicio008;

import java.awt.Event;
import java.awt.TextField;

public class MiTextField extends TextField {

	public MiTextField(String frase, int columnas) {
		super(frase, columnas);
	}

	public boolean action(Event ev, Object ob) {
		String texto = this.getText();
		this.setText(texto.toUpperCase());
		return true;
	}
}