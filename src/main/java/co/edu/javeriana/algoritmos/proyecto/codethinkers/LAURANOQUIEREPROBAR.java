package co.edu.javeriana.algoritmos.proyecto.codethinkers;

import co.edu.javeriana.algoritmos.proyecto.ColorJugador;
import co.edu.javeriana.algoritmos.proyecto.Jugada;
import co.edu.javeriana.algoritmos.proyecto.JugadorHex;
import co.edu.javeriana.algoritmos.proyecto.Tablero;

public class LAURANOQUIEREPROBAR {

	public static void main(String[] args) {
		Tablero tablero = new TableroCodeThinkers();
		JugadorHex j1 = new JugadorCodeThinkers();
		Jugada jug;
		((TableroCodeThinkers)tablero).tablero[0][0]=ColorJugador.NEGRO;
		jug=j1.jugar(tablero, ColorJugador.BLANCO);
		System.out.println(jug);
		tablero.aplicarJugada(jug, ColorJugador.BLANCO);
		((TableroCodeThinkers)tablero).tablero[4][3]=ColorJugador.NEGRO;
		jug=j1.jugar(tablero, ColorJugador.BLANCO);
		System.out.println(jug);
		tablero.aplicarJugada(jug, ColorJugador.BLANCO);
		((TableroCodeThinkers)tablero).imprimirTablero();
		for(int i=0; i<11; ++i) {
			for(int j=0; j<11; ++j) {
				System.out.print(((JugadorCodeThinkers)j1).getGrafoTablero().getTablero()[i][j].getColor()+ " ");
			}
			System.out.println();
		}
	}

}
