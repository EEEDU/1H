/*
 * Comida de la carta
 */

package Ejercicio010;

import java.awt.Choice;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;

public class Restaurante extends Frame {

	String[] comidas = { "Desayuno", "Comida", "Cena" };
	String[][] platos = { { "Leche", "Cereales", "Cafe", "Colacao", "Tostadas", "Galletas", "Bizcocho" },
			{ "Paella", "Sopa", "Judias", "Macarrones", "Ensalada", "Chuleton", "Albondigas" },
			{ "Hamburgesa", "Salchichas", "Sopa", "Pizza", "Ensalada", "Pollo", "Pechugas" } };

	Choice chComidas;

	List[] listasPlatos;
	List presentar;

	TextField texto;
	TextField texto2;

	String mostrar = "";
	public static void main(String[] args) {
		Restaurante app = new Restaurante();
	}

	public Restaurante() {
		super("Restaurante Aplicación");
		setup();
		pack();
		resize(250, 250);
		show();
	}

	public void setup() {
		this.add("North", new Label("Elige tu comanda", Label.CENTER));

		chComidas = new Choice();
		for (int i = 0; i < comidas.length; i++) {
			chComidas.addItem(comidas[i]);
		}
		this.add("West", chComidas);

		listasPlatos = new List[comidas.length];
		for (int i = 0; i < comidas.length; i++) {
			listasPlatos[i] = new List(5, true);
			for (int j = 0; j < platos[i].length; j++) {
				listasPlatos[i].addItem(platos[i][j]);
			}
		}

		presentar = listasPlatos[0];
		this.add("East", presentar);

		texto = new TextField("", 40);
		this.add("South", texto);
		texto2 = new TextField("", 40);
		this.add("Center", texto2);

	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.WINDOW_DESTROY) {
			System.exit(0);
			return true;
		} else if (ev.id == Event.ACTION_EVENT) {
			if (ev.target instanceof Choice) {
				this.remove(presentar);
				presentar = listasPlatos[chComidas.getSelectedIndex()];
				this.add("East", presentar);
				this.show();
				return true;
			}
		} else if ((ev.id == Event.LIST_SELECT) || (ev.id == Event.LIST_DESELECT)) {
			String[] seleccionados = presentar.getSelectedItems();
			String peticion = chComidas.getSelectedItem() + ": ";
			String letra;
			for (int i = 0; i < seleccionados.length; i++) {
				if (seleccionados[i] == seleccionados[seleccionados.length - 1]) {
					peticion += seleccionados[i] + ".";
				} else {
					peticion += seleccionados[i] + ", ";
				}
			}
			texto.setText(peticion);
			letra = peticion.substring(peticion.length() - 2);
			texto2.setText(letra);
			return true;
		}
		return false;
	}
}
