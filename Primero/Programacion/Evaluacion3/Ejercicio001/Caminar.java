package Ejercicio001;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Caminar extends Applet implements Runnable {

	// Crear de pantalla
	Thread animacion;
	Image imagen;
	Graphics noSeVe;

	Image[] dibujosGuerrillero;
	Image[] dibujosVaquero;
	Image[] dibujosHampon;
	Image[] dibujosKen;


	// Crear objetos

	DibujoAnimado guerrillero;
	DibujoAnimado vaquero;
	DibujoAnimado hampon;
	DibujoAnimado ken;

	// Crear variables
	public final int GUERRILLERO = 0;
	public final int VAQUERO = 1;
	public final int HAMPON = 2;
	public final int KEN = 3;

	int numDibujo;

	boolean liberar;

	// Incializar todas la variables
	public void init() {
		imagen = this.createImage(900, 600);
		noSeVe = imagen.getGraphics();

		dibujosGuerrillero = new Image[4];
		dibujosVaquero = new Image[4];
		dibujosHampon = new Image[4];
		dibujosKen = new Image[6];
		for (int i = 0; i < 4; i++) {

//			Si en lugar de crear una imagenes queremos cambiarla 
//			dibujo.setImage("Sprites/Guerrillero/g" + (i + 1) + ".gif");

			dibujosGuerrillero[i] = getImage(getDocumentBase(), "Sprites/Guerrillero/g" + (i + 1) + ".gif");
			dibujosVaquero[i] = getImage(getDocumentBase(), "Sprites/Vaquero/v" + (i + 1) + ".gif");
			dibujosHampon[i] = getImage(getDocumentBase(), "Sprites/Hampon/h" + (i + 1) + ".gif");
		}
		for (int i = 0; i < 6; i++) {
			dibujosKen[i] = getImage(getDocumentBase(), "Sprites/Ken/ken" + (i + 1) + ".gif");
		}

		guerrillero = new DibujoAnimado(dibujosGuerrillero);
		vaquero = new DibujoAnimado(dibujosVaquero);
		hampon = new DibujoAnimado(dibujosHampon);
		ken = new DibujoAnimado(dibujosKen);

		numDibujo = GUERRILLERO;

		liberar = false;

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
			guerrillero.actualizar();
			vaquero.actualizar();
			hampon.actualizar();
			ken.actualizar();

			if (liberar) {
				switch (numDibujo) {
				case GUERRILLERO:
					guerrillero.posX += guerrillero.anchura / 8;
					break;
				case VAQUERO:
					vaquero.posX += vaquero.anchura / 8;
					break;
				case HAMPON:
					hampon.posX += hampon.anchura / 8;
					break;
				case KEN:
					ken.posX += ken.anchura / 8;
					break;

				default:
					break;
				}
			}

			repaint();
			try {
				Thread.sleep(120);
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

		switch (numDibujo) {
		case GUERRILLERO:
			guerrillero.dibujar(noSeVe, this);
			break;
		case VAQUERO:
			vaquero.dibujar(noSeVe, this);
			break;
		case HAMPON:
			hampon.dibujar(noSeVe, this);
			break;
		case KEN:
			ken.dibujar(noSeVe, this);
			break;

		default:
			break;
		}

		noSeVe.setColor(Color.black);
		noSeVe.drawString("Espacio para liberar", 100, 80);
		noSeVe.drawString("+ para aumentar", 100, 120);
		noSeVe.drawString("- para reducir", 100, 140);
		noSeVe.drawString("g para guerrillero", 100, 180);
		noSeVe.drawString("v para vaquero", 100, 200);
		noSeVe.drawString("h para hampon", 100, 220);
		noSeVe.drawString("k para ken", 100, 240);
		g.drawImage(imagen, 0, 0, this);
	}

	// Carga la pagina
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public boolean keyDown(Event evt, int key) {
		switch (key) {
		case 103:
		case 71:
			liberar = false;
			numDibujo = GUERRILLERO;
			break;
		case 118:
		case 86:
			liberar = false;
			numDibujo = VAQUERO;
			break;
		case 104:
		case 72:
			liberar = false;
			numDibujo = HAMPON;
			break;
		case 107:
		case 75:
			liberar = false;
			numDibujo = KEN;
			break;
		case 45:
			guerrillero.altura -= 20;
			guerrillero.anchura -= 13;
			guerrillero.posY += 20;
			vaquero.altura -= 20;
			vaquero.anchura -= 13;
			vaquero.posY += 20;
			hampon.altura -= 20;
			hampon.anchura -= 13;
			hampon.posY += 20;
			ken.altura -= 20;
			ken.anchura -= 13;
			ken.posY += 20;
			break;
		case 43:
			guerrillero.altura += 20;
			guerrillero.anchura += 13;
			guerrillero.posY -= 20;
			vaquero.altura += 20;
			vaquero.anchura += 13;
			vaquero.posY -= 20;
			hampon.altura += 20;
			hampon.anchura += 13;
			hampon.posY -= 20;
			ken.altura += 20;
			ken.anchura += 13;
			ken.posY -= 20;
			break;
		case 32:
			liberar = true;
			break;

		default:
			break;
		}
		return true;
	}
}