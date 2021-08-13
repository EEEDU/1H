package Ejercicio017;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class PalabrasMoviendose extends Applet implements Runnable{

	List<Palabra> palabras;
	
	String[] listaPalabras = { "Hola", "me", "llamo", "Edu", "que", "tal", "?" };

	boolean[] tocado;

	Thread animacion;

	Image imagen;
	Graphics noSeVe;

	public void init() {
		imagen = this.createImage(900, 900);
		noSeVe = imagen.getGraphics();

		palabras = new ArrayList<Palabra>();

		for (int i = 0; i < listaPalabras.length; i++) {
			palabras.add(new Palabra(i * 100 + 100, listaPalabras[i]));
		}

		tocado = new boolean[listaPalabras.length];
		for (int i = 0; i < listaPalabras.length; i++) {
			tocado[i] = false;
		}

		this.resize(900, 900);
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void run() {
		do {
			repaint();
			for (int i = 0; i < palabras.size(); i++) {
				palabras.get(i).actualizar();
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}

		} while (true);

	}

	public void paint(Graphics g) {
		noSeVe.setColor(Color.WHITE);
		noSeVe.fillRect(0, 0, 900, 900);

		for (int i = 0; i < palabras.size(); i++) {
			palabras.get(i).dibujar(noSeVe);
		}

		for (int i = 0; i < palabras.size(); i++) {
			if (palabras.get(i).x <= 0) {
				noSeVe.drawString("Has perido", 400, 450);
			}
		}
		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public boolean mouseDown(Event evt, int x, int y) {
		for (int i = 0; i < palabras.size(); i++) {
			if (palabras.get(i).contains(x, y)) {
				if (tocado[i] == true) {
					palabras.remove(i);
					tocado[i] = false;
				} else {
					palabras.get(i).color = Color.red;
					tocado[i] = true;
				}
			}
		}

		return true;
	}


}
