package EjercicioEx1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;

public class Boton extends Button {

	String letra;

	public Boton(int posX, int posY, String letra) {
		super();
		this.letra = letra;
	}

	public void dibujar(Graphics g) {
		g.setColor(Color.black);
		g.toString();
	}

}
