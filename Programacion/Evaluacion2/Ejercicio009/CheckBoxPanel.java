package Ejercicio009;

import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class CheckBoxPanel extends Panel {

	Checkbox checkboxes[];

	public CheckBoxPanel(String[] opciones, String pregunta) {
		super();

		this.setLayout(new GridLayout(opciones.length + 1, 1));
		this.add(new Label(pregunta));

		checkboxes = new Checkbox[opciones.length];
		for (int i = 0; i < checkboxes.length; i++) {
			checkboxes[i] = new Checkbox(opciones[i]);
			this.add(checkboxes[i]);
		}
	}
}
