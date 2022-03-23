package Ejercicio008;

import java.awt.Event;
import java.awt.List;
import java.awt.TextArea;

public class MiLista extends List {
	TextArea area;

	public MiLista(String[] deportes, TextArea texto) {
		super(5, true);

		for (int i = 0; i < deportes.length; i++) {
			this.add(deportes[i]);
		}

		area = texto;
	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.ACTION_EVENT) {
			area.setText("Doble click");
			return true;
		} else if (ev.id == Event.LIST_SELECT) {
			area.setText("Seleccion un item");
			return true;
		} else if (ev.id == Event.LIST_DESELECT) {
			area.setText("Deselcciono un item");
			return true;
		}
		return false;
	}
}
