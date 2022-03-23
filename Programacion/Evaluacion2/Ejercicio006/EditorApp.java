package Ejercicio006;

/*
 * Aplicacion de edicion de texto
 */

import java.awt.Event;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EditorApp extends Frame {
	TextArea texto;
	MenuBar menuBar;
	FileDialog abrirFichero;
	FileDialog guardarFichero;

	public static void main(String[] args) {
		EditorApp app = new EditorApp();
	}

	public EditorApp() {
		super("Editor de textoes");
		
		setup();

		pack();
		resize(texto.minimumSize());
		show();
	}

	private void setup() {
		texto = new TextArea(25, 50);
		add("Center", texto);
		setupMenuBar();
		abrirFichero = new FileDialog(this, "Abrir fichero", FileDialog.LOAD);
		guardarFichero = new FileDialog(this, "Guardar fichero", FileDialog.SAVE);
	}

	private void setupMenuBar() {
		menuBar = new MenuBar();
		Menu archivoMenu = new Menu("Archivo");
		archivoMenu.add(new MenuItem("Nuevo"));
		archivoMenu.add(new MenuItem("Abrir"));
		archivoMenu.addSeparator();
		archivoMenu.add(new MenuItem("Guardar"));
		archivoMenu.addSeparator();
		archivoMenu.add(new MenuItem("Salir"));
		menuBar.add(archivoMenu);
		this.setMenuBar(menuBar);
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
					texto.setText(" ");
					return true;
				} else if (ev.arg.equals("Abrir")) {
					abrirFichero.show();
					String inFile = abrirFichero.getFile();
					leerFichero(inFile);
					return true;
				} else if (ev.arg.equals("Guardar")) {
					guardarFichero.show();
					String outFile = guardarFichero.getFile();
					guardarFicher(outFile);
					return true;
				}
			}
		}
		return false;
	}

	private void guardarFicher(String outFile) {
		DataOutputStream outStream;
		try {
			outStream = new DataOutputStream(new FileOutputStream(outFile));
			outStream.writeBytes(texto.getText());
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	private void leerFichero(String inFile) {
		DataInputStream inStream;
		try {
			inStream = new DataInputStream(new FileInputStream(inFile));
			String nuevo_texto = "";
			String linea;
			while ((linea = inStream.readLine()) != null) {
				nuevo_texto += linea + "\n";
			}
			texto.setText(nuevo_texto);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
}
