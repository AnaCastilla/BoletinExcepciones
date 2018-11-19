package ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.Math.*;

public class ej03 {

	public static void main(String[] args) {

		/*
		 * 3a 
		 * 1. Introducir un número entero 
		 * 2. Controlar mediante excepciones que de verdad es un número entero 
		 * 3. Se crea una función que calculará si dicho número es primo o no 
		 * 4. Llamar a la función la cual mostrará el resultado de si es primo o no
		 * 
		 * 3b
		 * 6. Crear una función que muestre todos los números primos entre 1 y 10000
		 * 7. Llamada a la función que mostrará todos los números entre 1 y 10000
		 */
		boolean exit = false;
		int num;

		Scanner keyboard = new Scanner(System.in);
		
		 do { 
			 try {
				 System.out.println("Introduce un número entero: "); 
				 num = keyboard.nextInt(); 
				 System.out.println(esPrimo(num) ? "es primo":"no es primo"); 
				 exit = false; 
				 
				 } catch (NumberFormatException | InputMismatchException e) {
					System.out.println("Número inválido, inténtalo de nuevo"); 
					exit = true;
					keyboard.nextLine();
				}
			 keyboard.close();
		 } while (exit);
		 
		System.out.println("Números primos del 1 al 10000");
		//7. Llamada a la función que mostrará todos los números entre 1 y 10000
		primos();

		
	}

	public static boolean esPrimo(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	//6. Crear una función que muestre todos los números primos entre 1 y 10000
	public static void primos() {
		int i = 0, j = 0, div = 0, raiz = 0;
		for (i = 1; i <= 10000; i++) { // ciclo para recorrer los numeros hasta el num 10000
			div = 0; // variable para contar cuantas veces es el residuo de dividir es 0
			raiz = (int) sqrt(i);// la raiz del número a buscarle los primos
			for (j = 1; j <= raiz; j++) { // ciclo para recorrer los numeros hasta la raiz de i (estos seran los divisores)
				if (i % j == 0)// evalua la condicion de que el residuo de dividir i entre j es igual a cero
					div++;// si la condicion anterior se cumple entonces entonces suma 1 a esta variable
			}
			if (div <= 1)// Si existe más de un divisor, entonces el número no es primo
				System.out.println(i);
		}
	}
}
