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
		for (int i = 0; i< 40000; i++) {
			grafo.simularJugada(5, 5, ColorJugador.BLANCO);
			grafo.simularJugada(5, 6, ColorJugador.BLANCO);
			grafo.obtenerDistanciaBordes(ColorJugador.BLANCO);
			
			//grafo.obtenerDistanciaBordes(ColorJugador.NEGRO);
		}
		long endTime = System.nanoTime();
		System.out.println("Duración: " + (endTime-startTime)/1e6 + " ms");
		
	}
	


}
