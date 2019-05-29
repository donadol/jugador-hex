package co.edu.javeriana.algoritmos.proyecto.codethinkers;

import co.edu.javeriana.algoritmos.proyecto.ColorJugador;
import co.edu.javeriana.algoritmos.proyecto.Jugada;

public class PRUEBAS_SOLITARIAS_F {

	public PRUEBAS_SOLITARIAS_F() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		GrafoTablero grafo = new GrafoTablero();
		//grafo.simularJugada(0, 1, ColorJugador.NEGRO);
		grafo.simularJugada(5, 1, ColorJugador.NEGRO);
		grafo.simularJugada(5, 2, ColorJugador.NEGRO);
		grafo.simularJugada(5, 3, ColorJugador.NEGRO);
		grafo.simularJugada(5, 4, ColorJugador.NEGRO);
		grafo.simularJugada(5, 5, ColorJugador.BLANCO);
		System.out.println("PRUEBA: "+ grafo.obtenerDistanciaBordes(ColorJugador.BLANCO));
		System.out.println("PRUEBA: "+ grafo.obtenerDistanciaBordes(ColorJugador.NEGRO));
		//grafo.simularJugada(0, 1, ColorJugador.NEGRO);
		


		
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
		
		
		
		
		
		
		JugadorCodeThinkers jugador = new JugadorCodeThinkers();
		
		TableroCodeThinkers tablero = new TableroCodeThinkers();
		
		
		tablero.getTablero()[0][1] = ColorJugador.NEGRO;
		System.out.println(tablero.casilla(0, 1));
		
		tablero.getTablero()[5][5] = ColorJugador.BLANCO;
		System.out.println(tablero.casilla(5, 5));
		
		jugador.setContJugadas(2);
		
		
		System.out.println("*********************");
		
		System.out.println(jugador.jugar(tablero, ColorJugador.NEGRO));
		//tablero.aplicarJugada(jugador.jugar(tablero, ColorJugador.NEGRO), ColorJugador.BLANCO);
		
		/*System.out.println("*********************");
		
		System.out.println(jugador.jugar(tablero, ColorJugador.BLANCO));

		
			
		/*System.out.println("NEGRO: "+grafo.obtenerDistanciaBordes(ColorJugador.NEGRO));
		System.out.println("BLANCO: "+grafo.obtenerDistanciaBordes(ColorJugador.BLANCO));*/

	}

}
