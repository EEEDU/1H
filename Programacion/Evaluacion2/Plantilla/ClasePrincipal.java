package Plantilla;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class ClasePrincipal extends Applet implements Runnable {

	// Creacion de pantalla
	Thread animacion;
	Image imagen;
	Graphics noSeVe;

	// Crear objetos


	// Crear variables


	// Incializar todas la variables
	public void init() {
		imagen = this.createImage(900, 600);
		noSeVe = imagen.getGraphics();

		this.resize(900, 600);
	}

	// Llama al metodo run
	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	// Se ejecuta todo el rato
	public void run() {
		do {
			// Todas las llamadas a los movimientos de los objetos

			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}

		} while (true);
	}

	// Dibujar, cuanto mas abajo mas superpuesto
	public void paint(Graphics g) {
		// Pintar pantalla
		noSeVe.setColor(Color.WHITE);
		noSeVe.fillRect(0, 0, 900, 600);
		// Todas las llamadas a los metodos dibujar de los objetos

		g.drawImage(imagen, 0, 0, this);
	}

	// Carga la pagina
	public void update(Graphics g) {
		paint(g);
	}

//	 Teclas 
//	 a = 97
//	 s = 115
//	 d = 100
//	 w = 119
//	 flecha arriba = 1004
//	 flecha abajo = 1005
//	 flecha derecha = 1007
//	 flecha izquierda = 1006
//	 espacio = 32

}