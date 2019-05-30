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
		ColorJugador cj1 =ColorJugador.NEGRO, cj2 =ColorJugador.BLANCO;
		int f, c;
		while(tablero.ganador()==null) {
			jug=j1.jugar(tablero, cj1);
			System.out.println(cj1+" "+jug);
			tablero.aplicarJugada(jug, cj1);
			do {
				f=(int) (Math.random()*11);
				c=(int) (Math.random()*11);
			}while(tablero.casilla(f, c)!=null);
			tablero.aplicarJugada(new Jugada(f,c), cj2);
			System.out.println("aleatorio "+cj2+" "+ new Jugada(f,c));
//			if(jug.isCambioColores()) {
//				cj1=ColorJugador.BLANCO;
//				cj2=ColorJugador.NEGRO;
//			}
			((TableroCodeThinkers)tablero).imprimirTablero();
		}
		
		if( cj2 == tablero.ganador())
			System.out.println(tablero.ganador()+" GANA");
		else
			System.out.println(tablero.ganador()+" :(");
		
		for(int i=0; i<11; ++i) {
			for(int j=0; j<11; ++j) {
				System.out.print(((JugadorCodeThinkers)j1).getGrafoTablero().getTablero()[i][j].getColor()+ " ");
			}
			System.out.println();
		}
	}

}
