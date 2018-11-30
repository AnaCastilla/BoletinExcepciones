package ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ej06 {

	public static void main(String[] args) {

		/*
		 * 1. Introducir 2 números enteros
		 * 2. Controlar que sean enteros
		 * 3. Se crea la función 'mcd' que calculará el máximo común divisor de esos 2 números
		 * 	 **el mcd es el entero más grande que es divisor exacto de los 2 números**
		 * 4. Llamada a la función
		 */
		int num1, num2;
		boolean exit = false;
		
		Scanner keyboard = new Scanner(System.in);
		
		do {
			try {
				//1. Pedir por teclado 2 números de tipo entero y un carácter
				System.out.println("Introduce 2 números enteros (n1 menor que n2): ");
				num1 = keyboard.nextInt();
				num2 = keyboard.nextInt();
				 if (num1 <= 0 || num2 <= 0) {
					 System.out.println("Número inválido, inténtalo de nuevo");
					 exit = true;
				} else if (num1 > num2) {
					 System.out.println("Error, n1 tiene que ser menor que n2");
					 exit = true;
				} else {
					//4. Llamada a la función
					mcd(num1, num2);
					exit = false; 
				}
				//2. Controlar que sean enteros
			} catch (NumberFormatException | InputMismatchException e) {
				System.out.println("Algún número se ha introducido mal, inténtalo de nuevo");
				exit = true;
				keyboard.nextLine();
			}
		} while (exit);
		
		keyboard.close();
	}
	
	/*
	 * 3. Se crea la función 'mcd' que calculará el máximo común divisor de esos 2 números
	 *  **el mcd es el entero más grande que es divisor exacto de los 2 números**
	 */
	public static void mcd(int num1, int num2) {
		
		int max1 = 0, max2 = 0, n1 = num1, n2 = num2;
		
		//MCD de num1 y sus factores
		for (int i = 1; i <= n1; i++) {
			if (n1 % i == 0) {
				if (i > max1) {
					max1 = i;
				}
				n1 /= i;
				i = 1;
			}
		}
		System.out.println(num1 + " = " + max1);
		
		//MCD de num2 y sus factores
		for (int j = 1; j <= n2; j++) {
			if (n2 % j == 0) {
				if (j > max2) {
					max2 = j;
				}
				n2 /= j;
				j = 1;
			}
		}
		System.out.println(num2 + " = " + max2);
		
		if (max1 != max2) {
			System.out.println("No existe MCD");
		} else if (max1 == max2) {
			System.out.printf("MCD(%d, %d) = %d", num1, num2, max1);
		}
	}

}
