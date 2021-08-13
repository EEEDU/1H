package EjercicioEx003;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Cabeza extends Rectangle {

	// Variables del objeto
	Image[] dibujo;

	Image elegirDibujo;

	int posicionX, posicionY;
	int numeroCarta;
	int velocidad;

	public final int DERECHA = 0;
	public final int ABAJO = 1;
	public final int IZQUIERDA = 2;
	public final int ARRIBA = 3;

	public Cabeza(int posX, int posY, Image[] dib) {
		super(posX, posY, 50, 50);

		velocidad = 6;

		dibujo = new Image[4];
		for (int i = 0; i < dib.length; i++) {
			dibujo[i] = dib[i];
		}

		elegirDibujo = dibujo[0];
	}

	public void mover(int direccion) {
		switch (direccion) {
			case DERECHA :
				x += velocidad;
				elegirDibujo = dibujo[DERECHA];
				break;
			case ABAJO :
				y += velocidad;
				elegirDibujo = dibujo[ABAJO];
				break;
			case IZQUIERDA :
				x -= velocidad;
				elegirDibujo = dibujo[IZQUIERDA];
				break;
			case ARRIBA :
				y -= velocidad;
				elegirDibujo = dibujo[ARRIBA];
				break;

			default :
				break;
		}
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(elegirDibujo, x, y, width, height, applet);
	}
}
