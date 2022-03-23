package Ejercicio011;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class MiCanvas extends Canvas {

	public List<DosPuntos> lista;

	DosPuntos dibujo;
	private int tipo;

	public MiCanvas() {
		super();

		this.resize(1000, 1000);
		this.setBackground(Color.WHITE);
		this.show();

		lista = new ArrayList<DosPuntos>();
	}

	public void paint(Graphics g) {
		if (dibujo != null) {
			dibujo.dibujar(g);
		}
		for (int i = 0; i < lista.size(); i++) {
			lista.get(i).dibujar(g);
		}
	}

	public boolean mouseDown(Event ev, int x, int y) {
		dibujo = new DosPuntos(x, y, tipo);
		return true;
	}

	public boolean mouseDrag(Event ev, int x, int y) {
		dibujo.setPosFinX(x);
		dibujo.setPosFinY(y);
		repaint();
		return true;
	}

	public boolean mouseUp(Event e, int x, int y) {
		lista.add(dibujo);
		dibujo = null;
		return true;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public List<DosPuntos> getLista() {
		return lista;
	}

	public void setLista(List<DosPuntos> lista) {
		this.lista = lista;
	}
}
