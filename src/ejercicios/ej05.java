package ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ej05 {

	public static void main(String[] args) {

		/*
		 * 1. Pedir un número
		 * 2. Controlar si dicho número es entero
		 * 3. Crear la función 'perfecto' que determinará si el número introducido es perfecto o no
		 * 		** un número es perfecto cuando la suma de sus divisores (incluyendo el 1 y a sí mismo) da como 
		 * 		   resultado el mismo número**
		 * 4. Crear una función que dado un perfecto introducido por parámetro
		 * 	4.1. Imprimir sus factores para confirmar que el número es perfecto
		 * 	4.2. Si no es perfecto, que no haga nada  
		 * 5. Utilizar ambas funciones para mostrar todos los números perfectos entre 1 y 10000 con sus factores
		 */
		
		boolean exit = false;
		int num;

		Scanner keyboard = new Scanner(System.in);
		
		 do { 
			 try {
				 //1. Pedir un número
				 System.out.println("Introduce un número entero: "); 
				 num = keyboard.nextInt(); 
				 System.out.println(perfecto(num)?"es perfecto":"no es perfecto");
				 
				 factoresPerfectos(num);
				 if (num <= 0) {
					 System.out.println("Número inválido, inténtalo de nuevo");
					 exit = true;
				} else {
				 exit = false; 
				}
				// 2. Controlar si dicho número  es entero
				 } catch (NumberFormatException | InputMismatchException e) {
					System.out.println("Número inválido, inténtalo de nuevo"); 
					exit = true;
					keyboard.nextLine();
				}
			
		 } while (exit);
		 keyboard.close();
		 
	}
	
	 
	 /*
	  * 3. Crear la función 'perfecto' que determinará si el número introducido es perfecto o no
	  * ** un número es perfecto cuando la suma de sus divisores (incluyendo el 1 y a sí mismo) da como 
	  *    resultado el mismo número**
	  */
	 	public static boolean perfecto(int num) {
	 		boolean isPerfect = true;
	 		int sum = 0;
	 		
	 		for (int i = 1; i < num; i++) { //i son los divisores
				if (num % i == 0) {
					sum += i; //si es divisor, se van sumando
				}
			}
	 		if (sum == num) { //si el número es igual a la suma de sus divisores, num es perfecto
				return isPerfect;
			} else {
				return !isPerfect;
			}
	 	}
	 	
	 	//4. Crear una función que dado un perfecto introducido por parámetro
	 	/*
	 	 * 	4.1. Imprimir sus factores para confirmar que el número es perfecto
		 * 	4.2. Si no es perfecto, que no haga nada  
	 	 */
	 	public static void factoresPerfectos(int num) {
	 		if (perfecto(num) == true) {
	 			System.out.println("\nFactores del número perfecto " + num);
	 			for (int i = 1; i < num; i++) { //i son los divisores de  num
					if (num % i == 0) {
						System.out.print(i + " ");
					}
				}
			}
	 	}

}
