package SustitucionesChar;
public class Ejercicio083 {
   public static void main(String[] args) {
       String frase = "Hola buenas tardes, una familiar cuatro quesos";
       int posicion = frase.indexOf(" ",  0);

       while(posicion != -1){
			// frase = frase.substring(0, posicion - 1).concat(frase.substring(posicion + 1,
			// frase.length() - 1);
           posicion = frase.indexOf(" ", 0);
       }

       System.out.println(frase);
       
   } 
}