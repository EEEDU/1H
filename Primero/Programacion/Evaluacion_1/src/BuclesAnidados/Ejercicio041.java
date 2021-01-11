package BuclesAnidados;
/*
 * Array bidimensional con las edades de los 4 grados de informatica y en cada grupo hay cinco alumnos
 * mostrar la edad media por clase
 */

public class Ejercicio041 {

  public static void main(String[] args) {
  
    int tabla[][] = {{18, 21, 22, 19, 30},
                  	{22, 25, 18, 20, 27},
                  	{20, 19, 23, 18, 22},
                  	{25, 22, 19, 22, 21}};
    int media[] = new int[tabla.length];
      
    for(int i = 0; i < tabla.length; i++){
      for(int j = 0; j < tabla[i].length; j++){
        
        media[i] += tabla[i][j];
        
      }
       
      media[i] /= tabla[i].length;
      
    }
    
    for(int i = 0; i < tabla.length; i++){
         
       System.out.printf("La media de edad en la clase %d es: %d \n", (i + 1), media[i]);
         
    }
    
  }

}
