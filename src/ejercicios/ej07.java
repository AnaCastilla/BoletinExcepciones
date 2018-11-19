package ejercicios;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ej07 {

	public static void main(String[] args) {

		/*
		 * -- BLACKJACK -- 
		 * 1. Los jugadores comienzan con 100€ cada uno para jugar. Antes de jugar, deciden cuánto dinero apostar que será la misma apuesta para los 2 
		 * 2. El programa asigna aleatoriamente 2 cartas a cada jugador 
		 *	2.1. Jugador 1: se le asignan 2 cartas e indican su totalidad. La máquina pregunta si quiere otra carta o plantarse 
		 * 		2.1.1. Si el jugador pide otra, se le da y se vuelve a contar su totalidad 
		 * 			2.1.1.1. Si tiene un As y no ha superado los 21 puntos, toma el As como 11, si no, como 1
		 * 		2.1.2. Si decide plantarse, se pasa al jugador 2 
		 * 	2.2. Jugador 2: se le asignan 2 cartas e indican su totalidad. La máquina pregunta si quiere otra carta o plantarse
		 *		 2.2.1. Si el jugador pide otra, se le da y se vuelve a contar su totalidad 
		 *			2.2.1.1. Si tiene un As y no ha superado los 21 puntos, toma el As como 11, si no, como 1 
		 * 3. Si los 2 se han plantado, se termina la mano y se indica el ganador y el dinero que les queda a cada uno 
		 * 	3.1. El ganador es quien haga blackjack o más se acerque a 21 puntos 
		 * 	3.2. El perdedor es quien tenga menos puntos que el otro o se haya pasado de 21
		 *    3.3. Se considera empate cuando: 
		 *  		3.3.1. Los 2 sacan blackjack 
		 *  		3.3.2. Sacan la misma puntuación 
		 *  		3.3.3. Si los 2 jugadores se pasan de 21
		 * 4. Quien haya ganado se lleva el dinero apostado del perdedor y el suyo
		 *  4.1. Si el ganador ha hecho blackjack, el perdedor le da el doble de lo apostado 
		 *  4.2. Si empatan, no hay movimientos de dinero
		 * 5. Si alguno de los 2 jugadores aún no se ha plantado, se sigue con la siguiente mano 
		 * 	5.1. Se seguirán jugando tantas manos como quieran hasta que no quieran seguir jugando o uno de los 2 se quede sin dinero 
		 *	 ***** hay que indicar el número de mano por el que van ***** 
		 * 6. El programa pregunta si quieren echar otra partida
		 */

		final int AS1 = 1, AS11 = 11, BLACKJACK = 21;
		int randomCard1, randomCard2, randomCard3, bet1, bet2, totalP1, totalP2, elec1, elec2, hand = 1, player1Money = 100, player2Money = 100;
		boolean keepPlaying = false, exit = false, nextHand = false;

		Random rnd = new Random();
		Scanner keyboard = new Scanner(System.in);

		System.out.println("******** BLACKJACK ********");
		System.out.println("Tenéis 100€ cada uno. ¡Hagan una apuesta!");

		do {
			try {
				do {
					System.out.println("Mano " + hand);
				// 1. Los jugadores comienzan con 100€ cada uno para jugar. Antes de jugar, deciden cuánto dinero apostar que será la misma apuesta para los 2
				System.out.println("Apuesta del Jugador 1: ");
				bet1 = keyboard.nextByte();
				System.out.println("Apuesta del Jugador 2:");
				bet2 = keyboard.nextByte();
				//Se le quita a los 100€ principales que tiene cada uno lo que hayan apostado cada vez que y se le irá restando lo que tienen
				//menos lo que vayan apostando a medida que se repita el bucle
				player1Money -= bet1;
				player2Money -= bet2;

				if (bet1 > 100 || bet2 > 100) {
					System.out.println("Error, no se puede apostar más dinero del que tienes");
					exit = true;
				} else if (bet1 != bet2 && bet2 < bet1) {
					System.out.println("Error, se tiene que apostar lo mismo o superar la apuesta del Jugador 1");
					exit = true;
				} else if (bet1 == 0 || bet2 == 0) {
					System.out.println("No se puede apostar 0€");
					exit = true;
				} else {
					// 2. El programa asigna aleatoriamente 2 cartas a cada jugador
					//// 2.1. Jugador 1: se le asignan 2 cartas e indican su totalidad. La máquina pregunta si quiere otra carta o plantarse
					
					System.out.println("Turno del Jugador 1");
					randomCard1 = rnd.nextInt(13) + 1;
					randomCard2 = rnd.nextInt(13) + 1;
					card(randomCard1);
					System.out.println();
					card(randomCard2);
					totalP1 = randomCard1 + randomCard2;
					System.out.println("\nTotal de puntos: " + totalP1);
					do {
						try {
							// 2.1.1. Si el jugador pide otra, se le da y se vuelve a contar su totalidad
							System.out.println("¿Quieres seguir (1) o plantarte (2)?");
							elec1 = keyboard.nextInt();
							if (elec1 == 1) {
								randomCard3 = rnd.nextInt(13) + 1;
								card(randomCard3);
								// 2.1.1.1. Si tiene un As y no ha superado los 21 puntos, toma el As como 11, si no, como 1
								if (randomCard3 == AS1 && totalP1 > 21) {
									randomCard3 = AS1;
									totalP1 += randomCard3;
								} else if (randomCard3 == AS1 && totalP1 < 21) {
									randomCard3 = AS11;
									totalP1 += randomCard3;
								} else {
									totalP1 += randomCard3;
								}
								System.out.println("\nTotal de puntos: " + totalP1);
								keepPlaying = true;
								// 2.1.2. Si decide plantarse, se pasa al jugador 2
							} else if (elec1 == 2) {
								keepPlaying = false;
							} else {
								System.out.println("Error, inténtalo de nuevo");
								keepPlaying = true;
								keyboard.nextLine();
							}
						} catch (InputMismatchException | NumberFormatException e) {
							System.out.println("Error, inténtalo de nuevo");
							keepPlaying = true;
							keyboard.nextLine();
						}
					} while (keepPlaying);
					//2.2. Jugador 2: se le asignan 2 cartas e indican su totalidad. La máquina pregunta si quiere otra carta o plantarse
					System.out.println("Turno del Jugador 2");
					randomCard1 = rnd.nextInt(13)+1; 
					randomCard2 = rnd.nextInt(13)+1;
					card(randomCard1);
					System.out.println();
					card(randomCard2);
					totalP2 = randomCard1 + randomCard2;
					System.out.println("\nTotal de puntos: " + totalP2);
					do {
						try {
							// 2.2.1. Si el jugador pide otra, se le da y se vuelve a contar su totalidad 
							System.out.println("¿Quieres seguir (1) o plantarte (2)?");
							elec2 = keyboard.nextInt();
							if (elec2 == 1) {
								randomCard3 = rnd.nextInt(13) + 1;
								card(randomCard3);
								// 2.2.1.1. Si tiene un As y no ha superado los 21 puntos, toma el As como 11, si no, como 1
								if (randomCard3 == AS1 && totalP2 > 21) {
									randomCard3 = AS1;
									totalP2 += randomCard3;
								} else if (randomCard3 == AS1 && totalP2 < 21) {
									randomCard3 = AS11;
									totalP2 += randomCard3;
								} else {
									totalP2 += randomCard3;
								}
								System.out.println("\nTotal de puntos: " + totalP2);
								keepPlaying = true;
								
							} else if (elec2 == 2) {
								keepPlaying = false;
							} else {
								System.out.println("Error, inténtalo de nuevo");
								keepPlaying = true;
								keyboard.nextLine();
							}
						} catch (InputMismatchException | NumberFormatException e) {
							System.out.println("Error, inténtalo de nuevo");
							keepPlaying = true;
							keyboard.nextLine();
						}
					} while (keepPlaying);
					
					/*
					 * 3. Si los 2 se han plantado, se termina la mano y se indica el ganador y el dinero que les queda a cada uno 
					 * 	3.1. El ganador es quien haga blackjack o más se acerque a 21 puntos 
					 * 	3.2. El perdedor es quien tenga menos puntos que el otro o se haya pasado de 21
					 *    3.3. Se considera empate cuando: 
					 *  		3.3.1. Los 2 sacan blackjack 
					 *  		3.3.2. Sacan la misma puntuación 
					 *  		3.3.3. Si los 2 jugadores se pasan de 21 
					 * 4. Quien haya ganado se lleva el dinero apostado del perdedor y el suyo
					 *  4.1. Si el ganador ha hecho blackjack, el perdedor le da el doble de lo apostado 
					 *  4.2. Si empatan, no hay movimientos de dinero
					 */
					if (totalP1 == BLACKJACK) {
						System.out.println("Ha ganado el Jugador 1 con un BlackJack!");
						player1Money += bet1 + (bet2 * 2);
						player2Money -= (bet2 * 2);
						showPlayersMoney(player1Money, player2Money);
					} else if (totalP1 > totalP2 && totalP1 < BLACKJACK) {
						System.out.println("Ha ganado el Jugador 1 con un total de " + totalP1 + " puntos");
						player1Money += bet2;
						showPlayersMoney(player1Money, player2Money);
					} else if (totalP2 > BLACKJACK && totalP1 < BLACKJACK) {
						System.out.println("Ha ganado el Jugador 1 con un total de " + totalP1 + " puntos");
						player1Money += bet2;
						showPlayersMoney(player1Money, player2Money);
					} else if (totalP1 > BLACKJACK && totalP2 < BLACKJACK) {
						System.out.println("Ha ganado el Jugador 2 con un total de " + totalP2 + " puntos");
						player2Money += bet1;
						showPlayersMoney(player1Money, player2Money);
					} else if (totalP2 == BLACKJACK) {
						System.out.println("Ha ganado el Jugador 2 con un BlackJack!");
						player2Money += bet2 + (bet1 * 2);
						player1Money -= (bet1 * 2);
						showPlayersMoney(player1Money, player2Money);
					} else if (totalP2 > totalP1 && totalP2 < BLACKJACK) {
						System.out.println("Ha ganado el Jugador 2 con un total de " + totalP2 + " puntos");
						player2Money += bet1;
						showPlayersMoney(player1Money, player2Money);
					} else if (totalP1 > BLACKJACK && totalP2 > BLACKJACK) {
						System.out.println("Empate! Los 2 habéis sacado más de 21 puntos");
						showPlayersMoney(player1Money, player2Money);
					} else if (totalP1 == BLACKJACK && totalP2 == BLACKJACK) {
						System.out.println("Empate! Los 2 habéis tenido BlackJack");
						showPlayersMoney(player1Money, player2Money);
					} else if (totalP1 == totalP2) {
						System.out.println("Empate! Los 2 habéis sacado la misma puntuación");
						showPlayersMoney(player1Money, player2Money);
					}
				
				
					// 5.1. Se seguirán jugando tantas manos como quieran hasta que no quieran seguir jugando o uno de los 2 se quede sin dinero
					if (player1Money == 0 || player2Money == 0) {
						System.out.println("Alguien se ha quedado sin dinero! no podéis jugar más");
						exit = false;
					} else {
						// * 6. El programa pregunta si quieren echar otra partida
						System.out.println("¿Queréis jugar otra mano (1) o se termina el juego (2)?");
						do {
							try {
								System.out.print("Jugador 1: ");
								elec1 = keyboard.nextInt();
								System.out.print("Jugador 2: ");
								elec2 = keyboard.nextInt();
								
								if (elec1 == 1 && elec2 == 1) {
									exit = false;
									nextHand = true;
									//***** hay que indicar el número de mano por el que van ***** 
									hand++;
								} else if ((elec1 == 1 && elec2 == 2) || elec1 == 2 && elec2 == 1) {
									System.out.println("Los jugadores se tienen que poner de acuerdo");
									exit = true;
									keyboard.nextLine();
								} else if (elec1 == 2 && elec2 == 2) {
									System.out.println("Se acabó el juego, espero que hayáis disfrutado!");
									nextHand = false;
									exit = false;
								} else if (elec1 != 1 || elec1 != 2 && elec2 != 1 || elec2 != 2) {
									System.out.println("Error, inténtalo de nuevo");
									exit = true;
									keyboard.nextLine();
								}
							} catch (InputMismatchException | NumberFormatException e) {
								System.out.println("Error, inténtalo de nuevo");
								exit = true;
								keyboard.nextLine();
							}
						} while(exit);
					}
					
				}
				} while (nextHand);
			} catch (NumberFormatException | InputMismatchException e) {
				System.out.println("Apuesta inválida, prueba de nuevo");
				exit = true;
				keyboard.nextLine();
			}
			
		} while (exit);

		keyboard.close();
	}
	
	public static void showPlayersMoney (int player1Money, int player2Money) {
		System.out.println("Dinero Jugador 1: " + player1Money);
		System.out.println("Dinero Jugador 2: " + player2Money);
	}

	// función que asigna cartas random del 1 al 13 introducidas por parámetro y un palo random
	public static void card(int randomCard) {
		int pale;
		final String ROJO = "\u001B[31m";
		final String RESET = "\u001B[0m";

		Random rnd = new Random();

		switch (randomCard) {
		case 1:
			System.out.print("As de ");
			break;
		case 2:
			System.out.print("2 de ");
			break;
		case 3:
			System.out.print("3 de ");
			break;
		case 4:
			System.out.print("4 de ");
			break;
		case 5:
			System.out.print("5 de ");
			break;
		case 6:
			System.out.print("6 de ");
			break;
		case 7:
			System.out.print("7 de ");
			break;
		case 8:
			System.out.print("8 de ");
			break;
		case 9:
			System.out.print("9 de ");
			break;
		case 10:
			System.out.print("10 de ");
			break;
		case 11:
			System.out.print("Jota de ");
			break;
		case 12:
			System.out.print("Reina de ");
			break;
		case 13:
			System.out.print("Rey de ");
			break;
		default:
			System.out.print("ERROR");
			break;
		}

		pale = rnd.nextInt(4) + 1;
		if (pale == 1) {
			System.out.print("Picas ♠");
		} else if (pale == 2) {
			System.out.print("Corazones " + ROJO + "♥" + RESET);
		} else if (pale == 3) {
			System.out.print("Diamantes " + ROJO + "♦" + RESET);
		} else if (pale == 4) {
			System.out.print("Tréboles ♣");
		}
	}
}
