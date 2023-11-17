package co.edu.unbosque.model;

import java.util.Scanner;

public class Dice {
	 
	//Variables principales
 
	//Array para guardar nombres de n Jugadores
	static String[] jugadores;
 
	//Por cada Jugador, habrán 5 lanzamientos.Dichas puntuaciones las podemos guardar en una matriz de n x 5
	static int[][] tablaPuntuaciones;
 
	//Metodos
 
	/*
	 * Simula el lanzamiento de tres dados y devuelve los
	 * tres resultados en un array de tres elementos. 
	 */
	static int[] lanzamiento() {
 
		int[] resultados = new int[3]; //Se tiran tres dados
 
		resultados[0] = (int)(Math.random()*6 + 1); //Primer dado
		resultados[1] = (int)(Math.random()*6 + 1); //Segundo dado
		resultados[2] = (int)(Math.random()*6 + 1); //Tercer dado
 
		return resultados;
	}
 
 
	public static void main(String[] args) {
 
		Scanner teclado = new Scanner(System.in);
		System.out.print("¿Cuantos jugadores serán?: ");
		int n = Integer.parseInt(teclado.nextLine());
 
		//Inicializamos los arrays con el numero de jugadores.
		jugadores = new String[n];
		tablaPuntuaciones = new int[n][5];
 
		//Pedimos nombres...
		System.out.println("\nIntroduzca nombres.");
		for (int i = 0; i < n; i++) {
			System.out.printf("Jugador #%d: ", (i+1));
			jugadores[i] = teclado.nextLine();
		}
 
		/*
		 * Comienza el juego.
		 * Son 5 turnos y cada jugador tirará los datos una vez.
		 * Si saca tres números iguales habrá ganado.
		 * Si no, se suma el valor de los dados, se guarda
		 * en la casilla correspondiente de la tablaPuntuaciones
		 * y lanza el siguiente jugador.
		 * 
		 * Con un booleano podemos detener el flujo del juego
		 * en el caso de que haya ganador por tres números iguales.
		 */
		boolean hayGanador = false;
 
		for (int i = 0; i < 5 && !hayGanador; i++) {
			System.out.print("\n\t\t\tTURNO #" + (i+1));
 
			//Ahora cada Jugador lanzará una vez
			for (int j = 0; j < jugadores.length && !hayGanador; j++) {
 
				System.out.printf("\n\nLanza el jugador %s --> ", jugadores[j]);
				//Pedimos a nuestro metodo que lance dados y recogemos resultado
				int[] dados = lanzamiento();
				System.out.printf("Dado1: %d\tDado2: %d\tDado3: %d", dados[0], dados[1], dados[2]);
				//Si ha sacado tres iguales, habrá ganado y los bucles finalizarán
				if (dados[0] == dados[1] && dados[1] == dados[2]) {
					System.out.println("\nHa ganado el Jugador " + jugadores[j]);
					hayGanador = true; //Esto pone fin al juego
				}
				else { //No ha ganado, sumamos y guardamos resultado
					tablaPuntuaciones[j][i] = dados[0] + dados[1] + dados[2];
				}
				//Ahora lanzará el siguente jugador...
			}
			System.out.println("\n\n\t\tPULSE INTRO PARA CONTINUAR");
			teclado.nextLine();
			//Ya han lanzado todos, comienza el siguiente turno..
		}
 
		/*
		 * Bucle de turnos finalizado.
		 * Si es porque hayGanador no hay que hacer nada, ya se informó en pantalla de quien ganó.
		 * De lo contrario, hay que evaluar la tablaPuntuaciones y ver quien ha ganado.
		 * 
		 * Podemos recorrer la tabla para ir mostrando los resultados y al mismo tiempo controlar
		 * cual ha sido la puntuacion mayor y a que jugador pertenece
		 */
		if (!hayGanador) {
			int mayorPunt = 0;
			String jugadorMayorPunt = new String();
			System.out.println("\n\n\t\tTABLA DE RESULTADOS");
			for (int i = 0; i < jugadores.length; i++) {
				System.out.print("\n" + jugadores[i]);
				for (int j = 0; j < 5; j++) {
					int puntos = tablaPuntuaciones[i][j]; //Recogemos puntuacion
					System.out.print("\t" + puntos); //Mostramos en pantalla
					if (puntos > mayorPunt) { //Controlamos si es la mayor puntuacion hasta ahora
						mayorPunt = puntos;
						jugadorMayorPunt = jugadores[i];
					}
				}
			}
 
			//TAbla mostrada y evaluada. Anunciamos ganador
 
			System.out.printf("\n\n***Ha ganado %s al conseguir un puntaje de %d***", jugadorMayorPunt, mayorPunt);
		}
		teclado.close();
		System.out.println("\n\n\t\t\tFIN DE PROGRAMA");
 
	}
 
}
