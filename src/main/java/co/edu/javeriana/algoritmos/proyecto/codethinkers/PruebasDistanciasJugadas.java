package co.edu.javeriana.algoritmos.proyecto.codethinkers;

import co.edu.javeriana.algoritmos.proyecto.ColorJugador;

public class PruebasDistanciasJugadas {

	public PruebasDistanciasJugadas() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrafoTablero grafo = new GrafoTablero();
		long startTime = System.nanoTime();
		
			grafo.simularJugada(8, 0, ColorJugador.BLANCO);
			grafo.simularJugada(7, 2, ColorJugador.BLANCO);
			grafo.simularJugada(5, 4, ColorJugador.BLANCO);
			grafo.simularJugada(6, 3, ColorJugador.BLANCO);
			grafo.simularJugada(5, 5, ColorJugador.BLANCO);
			grafo.simularJugada(6, 7, ColorJugador.BLANCO);
			grafo.simularJugada(4, 9, ColorJugador.BLANCO);
			grafo.simularJugada(3, 9, ColorJugador.BLANCO);
			
			
			grafo.simularJugada(1, 2, ColorJugador.NEGRO);
			grafo.simularJugada(2, 3, ColorJugador.NEGRO);
			grafo.simularJugada(2, 4, ColorJugador.NEGRO);
			grafo.simularJugada(4, 4, ColorJugador.NEGRO);
			grafo.simularJugada(6, 2, ColorJugador.NEGRO);
			grafo.simularJugada(7, 4, ColorJugador.NEGRO);
			
			
			System.out.println("NEGRO: "+grafo.obtenerDistanciaBordes(ColorJugador.NEGRO));
			System.out.println("BLANCO: "+grafo.obtenerDistanciaBordes(ColorJugador.BLANCO));
			
			//System.out.println(grafo.obtenerDistanciaBordes(ColorJugador.NEGRO));
		
		long endTime = System.nanoTime();
		System.out.println("Duración: " + (endTime-startTime)/1e6 + " ms");
	

	}

}
