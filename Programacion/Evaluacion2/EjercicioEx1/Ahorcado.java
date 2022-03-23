package EjercicioEx1;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class Ahorcado extends Applet implements Runnable {

	Button[] botones;
	Thread animacion;
	Solucion solucion;
	
	String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q",
			"R",
			"S", "T", "U", "V", "W", "X", "Y", "Z" };

	int posX = 5, posY = 5;
	
	Image imagen;
	Graphics noSeVe;

	public void init() {
		imagen = this.createImage(600, 400);
		noSeVe = imagen.getGraphics();

		botones = new Button[letras.length];
		for (int i = 0; i < letras.length; i++) {
			botones[i] = new Button(letras[i]);
		}

		for (int i = 0; i < botones.length; i++) {
			this.add(botones[i]);
		}
		this.add(solucion);
		this.resize(600, 400);
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void run() {
		do {
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}

		} while (true);
	}

	public void paint(Graphics g) {
		noSeVe.setColor(Color.WHITE);
		noSeVe.fillRect(0, 0, 600, 400);

		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

}
