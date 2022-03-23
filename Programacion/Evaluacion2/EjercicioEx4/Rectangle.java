package EjercicioEx4;

public class Rectangle extends GameObject {

	double x, y;
	double anchura;
	double altura;

	double izquierda() {
		return x - anchura / 2.0;
	}

	double derecha() {
		return x + anchura / 2.0;
	}

	double arriba() {
		return y - altura / 2.0;
	}

	double abajo() {
		return y + altura / 2.0;
	}

}