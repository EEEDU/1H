package Ejercicio008;

import java.awt.Event;
import java.awt.Scrollbar;
import java.awt.TextArea;

public class MiScrollbar extends Scrollbar {
	TextArea textArea;

	public MiScrollbar(int orientacion, int posicion, int anchura, int inicio, int fin, TextArea texto) {
		super(orientacion, posicion, anchura, inicio, fin);
		textArea = texto;
	}

	public boolean handlEvent(Event ev) {
		if (ev.id == Event.SCROLL_LINE_UP) {
			textArea.setText("Posicion: " + this.getValue());
			return true;
		} else if (ev.id == Event.SCROLL_LINE_DOWN) {
			textArea.setText("Posicion: " + this.getValue());
			return true;
		} else if (ev.id == Event.SCROLL_PAGE_UP) {
			textArea.setText("Posicion: " + this.getValue());
			return true;
		} else if (ev.id == Event.SCROLL_PAGE_DOWN) {
			textArea.setText("Posicion: " + this.getValue());
			return true;
		} else if (ev.id == Event.SCROLL_ABSOLUTE) {
			textArea.setText("Posicion: " + this.getValue());
			return true;
		}
		return false;
	}
}
