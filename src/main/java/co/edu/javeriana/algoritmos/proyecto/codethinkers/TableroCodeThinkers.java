package co.edu.javeriana.algoritmos.proyecto.codethinkers;

import co.edu.javeriana.algoritmos.proyecto.ColorJugador;
import co.edu.javeriana.algoritmos.proyecto.Jugada;
import co.edu.javeriana.algoritmos.proyecto.Tablero;

public class TableroCodeThinkers implements Tablero{

	
	ColorJugador [][] tablero;
	
	
	public TableroCodeThinkers(ColorJugador[][] tablero) {
		super();
		this.tablero = new ColorJugador[11][11];
	}

	@Override
	public void aplicarJugada(Jugada jugada, ColorJugador colorJugador) {
		
		if(!jugada.isCambioColores()) {
			tablero[jugada.getFila()][jugada.getColumna()] = colorJugador;	
		} else {
			tablero[jugada.getFila()][jugada.getColumna()] = colorJugador;	
		}
	}

	
	@Override
	public ColorJugador ganador() {
		
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				if(true) {
					
				}
			}
		}
		return null;
	}

	@Override
	public ColorJugador casilla(int fila, int columna) {
		
		if(fila <= 10 && columna <= 10 && fila >= 0 && columna >= 0)
			return tablero[fila][columna];
		else
			return null;
	}

}
