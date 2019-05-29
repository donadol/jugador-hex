package co.edu.javeriana.algoritmos.proyecto.codethinkers;

import java.util.List;

import co.edu.javeriana.algoritmos.proyecto.ColorJugador;

public class PRUEBAS_SOLITARIAS_F {

	public PRUEBAS_SOLITARIAS_F() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		
		GrafoTablero grafo = new GrafoTablero();
		long startTime = System.nanoTime();


		
		grafo.simularJugada(1, 4, ColorJugador.NEGRO);
		grafo.simularJugada(2, 3, ColorJugador.NEGRO);
		grafo.simularJugada(2, 7, ColorJugador.NEGRO);
		grafo.simularJugada(3, 4, ColorJugador.NEGRO);
		grafo.simularJugada(3, 5, ColorJugador.NEGRO);
		grafo.simularJugada(3, 6, ColorJugador.NEGRO);
		
		
		grafo.simularJugada(5, 5, ColorJugador.NEGRO);		
		grafo.simularJugada(6, 5, ColorJugador.NEGRO);		
		grafo.simularJugada(7, 4, ColorJugador.NEGRO);
		grafo.simularJugada(8, 4, ColorJugador.NEGRO);
		grafo.simularJugada(9, 4, ColorJugador.NEGRO);
		
		
		grafo.simularJugada(2, 0, ColorJugador.BLANCO);
		grafo.simularJugada(1, 10, ColorJugador.BLANCO);
		grafo.simularJugada(3, 7, ColorJugador.BLANCO);
		grafo.simularJugada(3, 10, ColorJugador.BLANCO);
		grafo.simularJugada(4, 3, ColorJugador.BLANCO);
		
		grafo.simularJugada(4, 4, ColorJugador.BLANCO);
		grafo.simularJugada(4, 5, ColorJugador.BLANCO);
		grafo.simularJugada(4, 6, ColorJugador.BLANCO);
		
		grafo.simularJugada(5, 2, ColorJugador.BLANCO);
		
		grafo.simularJugada(7, 8, ColorJugador.BLANCO);
		
		JugadorCodethinkers jugador =new JugadorCodethinkers();
		

		
			
		System.out.println("NEGRO: "+grafo.obtenerDistanciaBordes(ColorJugador.NEGRO));
		System.out.println("BLANCO: "+grafo.obtenerDistanciaBordes(ColorJugador.BLANCO));

	}

}
