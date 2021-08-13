package Ejercicio012;

import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;

class Animacion1 extends Frame implements Runnable {

	Thread animacion;
	String[] frames = { "*", "**", "***", "****", "*****", "******", "*****", "****", "***", "**", "*" };
	int actual = 0;

	public static void main(String[] args) {
		Animacion1 app = new Animacion1();
	}

	public Animacion1() {
		super("Animación sencilla");
		pack();
		resize(1000, 1000);
		show();

		animacion = new Thread(this);
		animacion.start(); // Desde start() llamas a run()
	}

	public void paint(Graphics g) {
		g.drawString(frames[actual], 80, 100);
	}

	public void run() {
		do {
			actual = (actual + 1) % frames.length;
			repaint();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
			}
		} while (true);
	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.WINDOW_DESTROY) {
			System.exit(0);
			return true;
		}
		return false;
	}
}
