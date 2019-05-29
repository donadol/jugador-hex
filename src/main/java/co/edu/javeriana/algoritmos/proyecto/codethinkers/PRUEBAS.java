package co.edu.javeriana.algoritmos.proyecto.codethinkers;

import co.edu.javeriana.algoritmos.proyecto.ColorJugador;

public class PRUEBAS {

	public PRUEBAS() {
		// TODO Auto-generated constructor stub
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrafoTablero grafo = new GrafoTablero();
		long startTime = System.nanoTime();
		for (int i = 0; i< 121; i++) {
			grafo.simularJugada(8, 2, ColorJugador.BLANCO);
			grafo.simularJugada(5, 3, ColorJugador.NEGRO);
			grafo.simularJugada(9, 8, ColorJugador.BLANCO);
			grafo.simularJugada(7, 6, ColorJugador.NEGRO);
			grafo.simularJugada(3, 4, ColorJugador.BLANCO);
			grafo.simularJugada(1, 2, ColorJugador.NEGRO);
			grafo.simularJugada(9, 5, ColorJugador.BLANCO);
			grafo.simularJugada(6, 6, ColorJugador.NEGRO);
			
			System.out.println(grafo.obtenerDistanciaBordes(ColorJugador.NEGRO));
			
			//System.out.println(grafo.obtenerDistanciaBordes(ColorJugador.NEGRO));
		}
		long endTime = System.nanoTime();
		System.out.println("Duración: " + (endTime-startTime)/1e6 + " ms");
		
	}
	


}
