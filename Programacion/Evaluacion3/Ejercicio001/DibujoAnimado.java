package Ejercicio001;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class DibujoAnimado {

	// Variables del objeto
	Image[] dibujos;
	int numImagen;

	int anchura, altura, posX, posY;

	public DibujoAnimado(Image[] dib) {
		dibujos = new Image[dib.length];
		for (int i = 0; i < dib.length; i++) {
			dibujos[i] = dib[i];
		}

		numImagen = 0;

		anchura = 300;
		altura = 500;
		posX = 300;
		posY = 100;
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujos[numImagen], posX, posY, anchura, altura, applet);
	}

	// Movimeinto del objeto
	public void actualizar() {
		numImagen = (numImagen + 1) % dibujos.length;
	}
}
