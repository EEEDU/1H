package Ejercicio008;

import java.awt.Checkbox;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

public class MiCheckBoxGroup extends Panel {
	Checkbox checkBoxes[];
	TextField resultado;

	public MiCheckBoxGroup(String[] elementos) {
		super();

		this.setLayout(new GridLayout(elementos.length + 1, 1));
		checkBoxes = new Checkbox[elementos.length];
		for (int i = 0; i < elementos.length; i++) {
			checkBoxes[i] = new Checkbox(elementos[i]);
			this.add(checkBoxes[i]);
		}

		resultado = new TextField("", 15);

		this.add(resultado);
	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.ACTION_EVENT) {
			String mostrar = "";
			if (ev.target instanceof Checkbox) {
				for (int i = 0; i < checkBoxes.length; i++) {
					if (checkBoxes[i].getState()) {
						mostrar += checkBoxes[i].getLabel() + " ";
					}
				}
				resultado.setText(mostrar);

				return true;
			}

		}
		return false;
	}
}
