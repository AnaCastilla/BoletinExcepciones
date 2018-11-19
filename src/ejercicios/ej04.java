package ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ej04 {

	public static void main(String[] args) {

		/*
		 * 1. Pedir un número por teclado
		 * 2. Controlar si es un número entero con excepciones 
		 * 3. Se crea una función que devolverá la descomposición en factores primos del número introducido
		 * 4. Llamada de la función
		 */
		
		boolean exit = false;
		int num;

		Scanner keyboard = new Scanner(System.in);
		
		 do { 
			 try {
				 //1. Pedir un número por teclado
				 System.out.println("Introduce un número entero: "); 
				 num = keyboard.nextInt(); 
				 //4. Llamada de la función
				 System.out.println(descPrimo(num));
				 if (num <= 0) {
					 System.out.println("Número inválido, inténtalo de nuevo");
					 exit = true;
				} else {
				 exit = false; 
				}
				// 2. Controlar si es un número entero con excepciones
				 } catch (NumberFormatException | InputMismatchException e) {
					System.out.println("Número inválido, inténtalo de nuevo"); 
					exit = true;
					keyboard.nextLine();
				}
			
		 } while (exit);
		 keyboard.close();
	}
	//3. Se crea una función que devolverá la descomposición en factores primos del número introducido
	public static int descPrimo(int num) {
		for (int i = 2; i <= num; i++) {
			if (num % i == 0) {
				System.out.println(i);
				num /= i;
			}
		}
		return num;
		
	}
}
