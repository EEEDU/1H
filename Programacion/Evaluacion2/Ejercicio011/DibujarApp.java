/*
 * Aplicacion para dibujar lineas, cuadrados y ovalos 
 * Cambiando los colres
 */
package Ejercicio011;

import java.awt.Event;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class DibujarApp extends Frame {

	MiCanvas canvas;

	public static void main(String[] args) {
		DibujarApp app = new DibujarApp();
	}

	public DibujarApp() {
		super("Aplicación para dibujar");
		setup();
		pack();
		resize(1000, 1000);
		show();
	}

	public void setup() {
		setupMenuBar();
		canvas = new MiCanvas();
		this.add("Center", canvas);
	}

	public void setupMenuBar() {
		MenuBar menuBar = new MenuBar();
		Menu menu1 = new Menu("Fichero");
		menu1.add(new MenuItem("Nuevo"));
		menu1.addSeparator();
		menu1.add(new MenuItem("Salir"));
		menuBar.add(menu1);

		Menu menu2 = new Menu("Dibujo");
		menu2.add(new MenuItem("Línea"));
		menu2.addSeparator();
		menu2.add(new MenuItem("Óvalo"));
		menu2.addSeparator();
		menu2.add(new MenuItem("Rectangulo"));
		menuBar.add(menu2);

		this.setMenuBar(menuBar);
	}

	public void ovalo() {

	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.WINDOW_DESTROY) {
			System.exit(0);
			return true;
		} else if (ev.id == Event.ACTION_EVENT) {
			if (ev.target instanceof MenuItem) {
				if (ev.arg.equals("Salir")) {
					System.exit(0);
					return true;
				} else if (ev.arg.equals("Nuevo")) {
					canvas.getLista().clear();
					canvas.repaint();
				} else if (ev.arg.equals("Línea")) {
					canvas.setTipo(DosPuntos.LINEA);
				} else if (ev.arg.equals("Óvalo")) {
					canvas.setTipo(DosPuntos.OVALO);
				} else if (ev.arg.equals("Rectangulo")) {
					canvas.setTipo(DosPuntos.RECTANGULO);
				}
			}
		}
		return false;
	}
}
