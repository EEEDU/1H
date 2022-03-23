package Ejercicio013;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangulo {

	public static final int ARRIBA = 0;
	public static final int ABAJO = 1;
	public static final int IZQUIERDA = 2;
	public static final int DERECHA = 3;
	int direccion = DERECHA;
	
	Color color;
	int posX, posY, anchura, altura;
	int posIX, posIY, posFX, posFY;

	public Rectangulo(int posX, int posY, int anc, int alt, Color col) {
		color = col;
		this.posX = posIX = posX;
		this.posY = posIY = posY;
		posFX = posIX + 50;
		posFY = posIY + 50;
		anchura = anc;
		altura = alt;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(posX, posY, anchura, altura);
	}
	
	public void actualizar() {
		switch (direccion) {
		case ARRIBA:
			posY--;
			if (posY == posIY) {
				direccion = DERECHA;

			}
			break;
		case ABAJO:
			posY++;
			if (posY == posFY) {
				direccion = IZQUIERDA;

			}
			break;
		case DERECHA:
			posX++;
			if (posX == posFX) {
				direccion = ABAJO;
			}
			break;
		case IZQUIERDA:
			posX--;
			if (posX == posIX) {
				direccion = ARRIBA;
			}
			break;
		}
	}
}
