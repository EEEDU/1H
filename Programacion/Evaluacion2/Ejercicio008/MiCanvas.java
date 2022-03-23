package Ejercicio008;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;

public class MiCanvas extends Canvas {
	int posX;
	int posY;

	public MiCanvas() {
		super();
		this.resize(100, 100);
		this.setBackground(Color.BLUE);
		this.setForeground(Color.red);
		this.show();
	}

	public void paint(Graphics g) {
		g.fillRect(posX, posY, 5, 5);
	}

	public boolean mouseDown(Event ev, int x, int y) {
		posX = x;
		posY = y;
		repaint();
		return true;
	}

}
