package ejercicios;

public class ej05_1 {

	public static void main(String[] args) {

		/*
		 * Utilizar las funciones de ej05 para mostrar todos los números entre 1 y 10000
		 * con sus correspondientes factores
		 */
		
		numPerfectFrom1();
		
	}
	
	public static void numPerfectFrom1() {
		final int MAX = 10000;
		
		for (int i = 1; i < MAX; i++) {
			if (ej05.perfecto(i) == true) {
				ej05.factoresPerfectos(i);
			}
		}
	}

}
