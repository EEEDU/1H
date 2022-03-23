package Plantilla;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Objeto extends Rectangle {

	// Variables del objeto
	Color color;

	Random random;

//	Hacer un numero random
//	(int) (Math.random() * {numero maximo al que quieres llegar ( - numero del que empiezas)}) + {numero del que quieres partir}
//	random.nextInt({numero maximo al que quieres llegar ( - numero del que empiezas)}) + {numero del que quieres partir}

	public Objeto() {
		super((int) (Math.random() * 250), (int) (Math.random() * 250), 30, 30);

		random = new Random();
		color();

	}

	// Randomizar color
	public Color color() {
		return color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}

	// Dibujar objeto
	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

	// Movimeinto del objeto
	public void actualizar() {

	}
}