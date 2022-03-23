/*
 * Trabajando con objetos de la clase Checkbox
 */

package Ejercicio009;

import java.awt.Event;
import java.awt.Frame;
import java.awt.GridLayout;

public class CheckboxApp extends Frame {

	CheckBoxPanel cb1;
	CheckBoxPanelGroup cb2;

	public static void main(String[] args) {
		CheckboxApp app = new CheckboxApp();

	}

	public CheckboxApp() {
		super("Checkbox Aplicación");
		setup();
		pack();
		resize(300, 300);
		show();
	}

	public void setup() {
		this.setLayout(new GridLayout(1, 2));

		String[] deporte = {"Atletismo", "Judo", "Karate", "Gimnasia", "Baloncesto", "ping-pong", "padel"};
		String[] edades = {"Menos de 20", "De 20 a 39", "De 40 a 59", "De 60 a 89", "Mayor de 90"};

		cb1 = new CheckBoxPanel(deporte, "¿Qué deportes te gustan?");
		cb2 = new CheckBoxPanelGroup(edades, "¿Qué edad tienes?");

		this.add(cb1);
		this.add(cb2);
	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.WINDOW_DESTROY) {
			System.exit(0);
			return true;
		}
		return false;
	}
}
