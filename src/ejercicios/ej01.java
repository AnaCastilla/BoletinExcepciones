package ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ej01 {

	public static void main(String[] args) {

		/*
		 * EJERCICIO 1
		 * 1. Pedir por teclado 2 números de tipo entero y un carácter
		 * 2. Controlar que el usuario introduzca solamente +, -, * o /, si no se pedirán los datos de nuevo
		 * 3. Controlamos la excepcion de que se introduzcan obligatoriamente 2 números enteros
		 * 4. Creamos una función para realizar la operación deseada cuyos parámetros son los datos introducidos por teclado
		 * 5. Llamamos a la función
		 * 
		 * EJERCICIO 2
		 * 6. Crea una nueva función sobrecargando la del ejercicio 2 para que se pueda operar con decimales
		 */
		
		int num1, num2;
		String op;
		final String SUM = "+", RES = "-", MULT = "*", DIV = "/";
		boolean exit = false, characBool = false;
		
		Scanner keyboard = new Scanner(System.in);
		
		do {
			try {
				//1. Pedir por teclado 2 números de tipo entero y un carácter
				System.out.println("Introduce 2 números enteros: ");
				num1 = keyboard.nextInt();
				num2 = keyboard.nextInt();
				System.out.println("Introduce un carácter (+, -, *, /): ");
				op = keyboard.next();
				//2. Controlar que el usuario introduzca solamente +, -, * o /, si no se pedirán los datos de nuevo
				if (!op.equals(SUM) && !op.equals(RES) && !op.equals(MULT) && !op.equals(DIV)) {
					System.out.println("El carácter introducido es inválido, inténtalo de nuevo");
					characBool = true;
					exit = true;
					keyboard.nextLine();
				} else {
					//5. Llamamos a la función	
					System.out.println(num1 + " " + op + " " + num2 + " = " + operation(num1, num2, op));
					System.out.println("(FUNCIÓN SOBRECARGADA)" + num1 + " " + op + " " + num2 + " = " + operation(num1, num2, op));
					exit = false;
				}
			//3. Controlamos la excepcion de que se introduzcan obligatoriamente 2 números enteros
			} catch (NumberFormatException | InputMismatchException e) {
				System.out.println("Algún número se ha introducido mal, inténtalo de nuevo");
				exit = true;
				keyboard.nextLine();
			}
		} while (exit && characBool);
		
		
		keyboard.close();
	}
	//4. Creamos una función para realizar la operación deseada cuyos parámetros son los datos introducidos por teclado
	public static int operation(int num1, int num2, String op) {
		int result = 0; 
		final String SUM = "+", RES = "-", MULT = "*", DIV = "/";
		if (op.equals(SUM)) {
			result = num1 + num2;
			
		} else if (op.equals(RES)) {
			result = num1 - num2;
			
		} else if (op.equals(MULT)) {
			result = num1 * num2;
			
		} else if (op.equals(DIV)) {
			result = num1 / num2;
			
		}
		return result;
	}
	
	//6. Crea una nueva función sobrecargando la del ejercicio 2 para que se pueda operar con decimales
	public static double operation(double num1, double num2, String op) {
		double result = 0; 
		final String SUM = "+", RES = "-", MULT = "*", DIV = "/";
		if (op.equals(SUM)) {
			result = num1 + num2;
			
		} else if (op.equals(RES)) {
			result = num1 - num2;
			
		} else if (op.equals(MULT)) {
			result = num1 * num2;
			
		} else if (op.equals(DIV)) {
			result = num1 / num2;
			
		}
		return result;
		
	}

}
