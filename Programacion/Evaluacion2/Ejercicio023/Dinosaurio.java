package Ejercicio023;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Dinosaurio extends Rectangle {

	Color color;

	boolean subir;

	int vel;

	public Dinosaurio() {
		super(100, 500, 50, 100);

		color = Color.DARK_GRAY;
		subir = true;

		vel = 20;

	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

	public void actualizar(int vel) {
		if (subir) {
			if (y <= 200) {
				subir = false;
			}
			y -= vel;
			
		} else {
			y += vel;
		}

	}

	public boolean isSubir() {
		return subir;
	}

	public void setSubir(boolean subir) {
		this.subir = subir;
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}
}