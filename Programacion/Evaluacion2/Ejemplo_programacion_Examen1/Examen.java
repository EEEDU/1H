package Ejemplo_programacion_Examen1;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class Examen extends Frame {
	TextField mensaje;
	Choice eleccion;

	Button boton;
	TextArea textarea;
	MiCanvas canvas;

	public static void main(String args[]) {
		Examen fap = new Examen();
	}

	public Examen() {
		super("Trabajo con Objetos");
		setup();
		pack();
		resize(400, 400);
		show();
	}

	public void setup() {
		Panel izquierda = new Panel();
		mensaje = new TextField("", 20);
		eleccion = new Choice();
		eleccion.addItem("Bot�n");
		eleccion.addItem("TextArea");
		eleccion.addItem("Canvas");
		izquierda.add(mensaje);
		izquierda.add(eleccion);
		add("North", izquierda);

		boton = new Button("    ");
		textarea = new TextArea("", 20, 20);

		add("South", boton);
	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.WINDOW_DESTROY) {
			System.exit(0);
			return true;
		} else if (ev.id == Event.ACTION_EVENT) {
			if (ev.target instanceof Choice) {
				if ("Bot�n".equals(ev.arg)) {
					this.remove(textarea);
					this.remove(canvas);
					boton = new Button(mensaje.getText());
					this.add("East", boton);
					this.show();
					return true;
				} else if ("TextArea".equals(ev.arg)) {
					this.remove(boton);
					this.remove(canvas);
					textarea.setText(mensaje.getText());
					this.add("East", textarea);
					this.show();
					return true;
				} else if ("Canvas".equals(ev.arg)) {
					this.remove(boton);
					this.remove(textarea);
					canvas = new MiCanvas(mensaje.getText());
					this.add("East", canvas);
					this.show();
					return true;
				}
			}
		}
		return false;
	}
}

class MiCanvas extends Canvas {
	int posx = 20;
	int posy = 20;
	String frase;

	public MiCanvas(String f) {
		super();
		resize(75, 75);
		setBackground(Color.yellow);
		setForeground(Color.red);
		frase = f;
		show();
	}

	public void paint(Graphics g) {
		g.drawString(frase, 1, 10);
	}

}

