package co.edu.javeriana.algoritmos.proyecto.codethinkers;

import java.util.*;
import co.edu.javeriana.algoritmos.proyecto.ColorJugador;
import co.edu.javeriana.algoritmos.proyecto.Jugada;
import co.edu.javeriana.algoritmos.proyecto.JugadorHex;
import co.edu.javeriana.algoritmos.proyecto.Tablero;

public class jugadorCodethinkers implements JugadorHex {
	private int contJugadas;
	public jugadorCodethinkers() {
		super();
		contJugadas=0;
	}
	@Override
	public Jugada jugar(Tablero tablero, ColorJugador color) {
		if(contJugadas==0) {
			return primeraJugada(tablero, color);
		}
		else {
			// plan Jhonny, plan
		}
		contJugadas++;
		return null;
	}

	@Override
	public String nombreJugador() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Jugada primeraJugada(Tablero tablero, ColorJugador color) {
		List<ArrayList<Integer>> posiblesJugadas = new ArrayList<ArrayList<Integer>>(14);
		if(color==ColorJugador.NEGRO) { //inicia juego	
			for(int i=0; i<2; ++i) {
				posiblesJugadas.add(new ArrayList<Integer>(Arrays.asList(2,i)));
			}
			for(int i=0; i<3; ++i) {
				posiblesJugadas.add(new ArrayList<Integer>(Arrays.asList(3,i)));
			}
			for(int i=11; i>7; --i) {
				posiblesJugadas.add(new ArrayList<Integer>(Arrays.asList(7,i)));
			}
			for(int i=11; i>8; --i) {
				posiblesJugadas.add(new ArrayList<Integer>(Arrays.asList(8,i)));
			}
			int x = (int) (Math.random()%15);
			return new Jugada(false, posiblesJugadas.get(x).get(0).intValue(), posiblesJugadas.get(x).get(1).intValue());
		}
		else {
			if(tablero.casilla(0,0)==ColorJugador.NEGRO || tablero.casilla(0,1)==ColorJugador.NEGRO || tablero.casilla(1,0)==ColorJugador.NEGRO) {
				return new Jugada(false, 7, 7);
			}
			if(tablero.casilla(10,11)==ColorJugador.NEGRO || tablero.casilla(11,11)==ColorJugador.NEGRO || tablero.casilla(11,10)==ColorJugador.NEGRO) {
				return new Jugada(false, 7, 7);
			}
			return new Jugada(true, 0, 0);
		}
	}

}
