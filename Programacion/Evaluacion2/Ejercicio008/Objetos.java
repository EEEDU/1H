/*
 * Manipular objetos con Java
 */

package Ejercicio008;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.TextArea;

public class Objetos extends Frame {

	TextArea textArea;

	public static void main(String[] args) {
		Objetos app = new Objetos();
	}

	public Objetos() {
		super("Trabajando con Objetos de Java");

		setup();
		pack();
		resize(1200, 900);
		show();
	}

	public void setup() {
		Panel principal = new Panel();
		principal.setLayout(new GridLayout(3, 3));
		Panel[][] paneles = new Panel[3][3];

		for (int i = 0; i < paneles.length; i++) {
			for (int j = 0; j < paneles[i].length; j++) {
				paneles[i][j] = new Panel();
				paneles[i][j].setLayout(new FlowLayout(FlowLayout.LEFT));
			}
		}
		paneles[0][0].add(new Label("Campo de texto: "));
		paneles[0][0].add(new MiTextField("", 15));
		
		textArea = new TextArea(20, 20);
		textArea.setBackground(Color.YELLOW);
		paneles[0][1].add(textArea);
		
		paneles[0][2].add(new MiButton("Limpiar", textArea));

		String opciones[] = { "Sí", "No", "Quizas" };
		Choice eleccion = new MiChoice(opciones, textArea);
		paneles[1][0].add(eleccion);

		String deportes[] = { "Atletismo", "Baloncesto", "Balonmanos", "Tenis", "Natacion" };
		paneles[1][1].add(new MiLista(deportes, textArea));

		paneles[1][2].add(new MiCanvas());

		String comidas[] = { "Patatas", "Cebollas", "Tomates", "Lechuga", "Aceitunas" };
		paneles[2][0].add(new MiCheckBoxGroup(comidas));

		paneles[2][1].add(new MiScrollbar(Scrollbar.VERTICAL, 50, 10, 0, 100, textArea));

		paneles[2][2].add(new MiScrollbar(Scrollbar.HORIZONTAL, 50, 10, 0, 100, textArea));

		for (int i = 0; i < paneles.length; i++) {
			for (int j = 0; j < paneles[i].length; j++) {
				principal.add(paneles[i][j]);
			}
		}

		this.add(principal);
	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.WINDOW_DESTROY) {
			System.exit(0);
			return true;
		}
		return false;
	}

}

