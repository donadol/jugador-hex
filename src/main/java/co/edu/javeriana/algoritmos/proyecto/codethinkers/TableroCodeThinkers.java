package co.edu.javeriana.algoritmos.proyecto.codethinkers;

import co.edu.javeriana.algoritmos.proyecto.ColorJugador;
import co.edu.javeriana.algoritmos.proyecto.Jugada;
import co.edu.javeriana.algoritmos.proyecto.Tablero;

public class TableroCodeThinkers implements Tablero{

	
	public ColorJugador [][] tablero;
	private Boolean [][] tableroDeVisitado;
	private int numeroJugadas = 0;
	
	public ColorJugador[][] getTablero() {
		return tablero;
	}

	public void setTablero(ColorJugador[][] tablero) {
		this.tablero = tablero;
	}

	public Boolean[][] getTableroDeVisitado() {
		return tableroDeVisitado;
	}

	public void setTableroDeVisitado(Boolean[][] tableroDeVisitado) {
		this.tableroDeVisitado = tableroDeVisitado;
	}

	public int getNumeroJugadas() {
		return numeroJugadas;
	}

	public void setNumeroJugadas(int numeroJugadas) {
		this.numeroJugadas = numeroJugadas;
	}

	public TableroCodeThinkers() {
		super();
		this.tablero = new ColorJugador[11][11];
		this.tableroDeVisitado = new Boolean[11][11];
		
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				this.tablero[i][j] = null;
 				this.tableroDeVisitado[i][j] = false;
			}
		}
	}

	@Override
	public void aplicarJugada(Jugada jugada, ColorJugador colorJugador) {
		if(!violaReglas(jugada.getFila(), jugada.getColumna())) {
			if(!jugada.isCambioColores() && this.tablero[jugada.getFila()][jugada.getColumna()]==null) {
				tablero[jugada.getFila()][jugada.getColumna()] = colorJugador;	
				this.numeroJugadas++;
			}
			else if(jugada.isCambioColores() && this.numeroJugadas==1) {
				this.numeroJugadas++;
			}
			else {
				System.out.println("Jugada inválida");
			}
		}
		else {
			System.out.println("Jugada inválida");
		}
	}

	
	@Override
	public ColorJugador ganador() {
		
		boolean negro = false;
		boolean blanco = false;
		reiniciarTablervisitados();
		for(int columnas = 0; columnas < 11; columnas++) {
			
			if(!tableroDeVisitado[0][columnas] && tablero[0][columnas] != null && tablero[0][columnas] == ColorJugador.NEGRO) {
				negro = negro || revisarFlujoNegro(0, columnas);
			}
			if(negro == true) {
				reiniciarTablervisitados();
				return ColorJugador.NEGRO;
			}
			
		}
		
		 for(int filas = 0; filas < 11; filas++) {
			if(!tableroDeVisitado[filas][0] && tablero[filas][0] == ColorJugador.BLANCO && tablero[filas][0] != null) { 
				blanco = blanco || revisarFlujoBlanco(filas, 0); 
			} 
			if(blanco == true) {
				reiniciarTablervisitados(); 
				return ColorJugador.BLANCO; 
			}
		  
		  }
		 
		
		reiniciarTablervisitados();
		return null;
	}

	private boolean revisarFlujoNegro(int fila, int columna) {
		
		boolean band = false;
		//Revisar si llego
		
		if(fila == 10) {
			return true;
		}
		if(!violaReglas(fila, columna)) 
			tableroDeVisitado[fila][columna] = true;
		//Izquierda
		if(!violaReglas(fila, columna - 1)) {
			if(!tableroDeVisitado[fila][ columna - 1] && tablero[fila][ columna - 1] == ColorJugador.NEGRO && tablero[fila][ columna - 1] != null) {
		
				band = band || revisarFlujoNegro(fila, columna - 1);
				if(band == true) {
					return band;
				}
			}
			
		}
		//Derecha
		if(!violaReglas(fila, columna + 1)) {
			if(!tableroDeVisitado[fila][ columna + 1] && tablero[fila][ columna + 1]== ColorJugador.NEGRO && tablero[fila][ columna + 1] != null) {
				
				band = band || revisarFlujoNegro(fila, columna + 1);
				if(band == true) {
					return band;
				}
			}
		}
		//Arriba
		if(!violaReglas(fila - 1, columna)) {
			if(!tableroDeVisitado[fila - 1][ columna] && tablero[fila - 1][ columna]== ColorJugador.NEGRO && tablero[fila - 1][ columna]!= null) {
			
				band = band || revisarFlujoNegro(fila - 1, columna);
				if(band == true) {
					return band;
				}
			}
			
		}
		//Debajo
		if(!violaReglas(fila + 1, columna)) {
			if(!tableroDeVisitado[fila + 1][ columna] && tablero[fila + 1][ columna]== ColorJugador.NEGRO && tablero[fila + 1][ columna] != null) {
				
				band = band || revisarFlujoNegro(fila + 1, columna );
				if(band == true) {
					return band;
				}
			}
		}
		//Izq arriba
		/*
		 * if(!violaReglas(fila - 1, columna - 1) ) { if(!tableroDeVisitado[fila - 1][
		 * columna - 1]&& tablero[fila - 1][ columna - 1]== ColorJugador.NEGRO &&
		 * tablero[fila - 1][ columna - 1] != null) {
		 * 
		 * band = band || revisarFlujoNegro(fila - 1, columna - 1); if(band == true) {
		 * return band; } } }
		 */
		
		//Der arriba
		if(!violaReglas(fila - 1, columna + 1)) {
			if(!tableroDeVisitado[fila - 1][ columna + 1]  && tablero[fila - 1][ columna + 1]== ColorJugador.NEGRO && tablero[fila - 1][ columna + 1] != null) {
				
				band = band || revisarFlujoNegro(fila - 1, columna + 1);
				if(band == true) {
					return band;
				}
			}
		}
		//izq debajo
		if(!violaReglas(fila + 1, columna - 1) ) {
			if(!tableroDeVisitado[fila + 1][ columna - 1]  && tablero[fila + 1][ columna - 1]== ColorJugador.NEGRO  && tablero[fila + 1][ columna - 1] != null){
				
				band = band || revisarFlujoNegro(fila + 1, columna - 1);
				if(band == true) {
					return band;
				}
			}
		}
		//der debajo
		/*
		 * if(!violaReglas(fila + 1, columna + 1)&& tablero[fila + 1][ columna + 1] ==
		 * ColorJugador.NEGRO && tablero[fila + 1][ columna + 1] != null) {
		 * if(!tableroDeVisitado[fila + 1][ columna + 1]) {
		 * 
		 * band = band || revisarFlujoNegro(fila + 1, columna + 1); if(band == true) {
		 * return band; } } }
		 */
		
		return band;
		
	}

	private boolean revisarFlujoBlanco(int fila, int columna) {
		
		boolean band = false;
		//Revisar si llego
		
		if(columna == 10) {
			return true;
		}
		if(!violaReglas(fila, columna)) 
			tableroDeVisitado[fila][columna] = true;
		//Izquierda
		if(!violaReglas(fila, columna - 1)) {
			if(!tableroDeVisitado[fila][ columna - 1] && tablero[fila][ columna - 1] == ColorJugador.BLANCO && tablero[fila][ columna - 1] != null) {
		
				band = band || revisarFlujoBlanco(fila, columna - 1);
				if(band == true) {
					return band;
				}
			}
			
		}
		//Derecha
		if(!violaReglas(fila, columna + 1)) {
			if(!tableroDeVisitado[fila][ columna + 1] && tablero[fila][ columna + 1]== ColorJugador.BLANCO && tablero[fila][ columna + 1] != null) {
				
				band = band || revisarFlujoBlanco(fila, columna + 1);
				if(band == true) {
					return band;
				}
			}
		}
		//Arriba
		if(!violaReglas(fila - 1, columna)) {
			if(!tableroDeVisitado[fila - 1][ columna] && tablero[fila - 1][ columna]== ColorJugador.BLANCO && tablero[fila - 1][ columna]!= null) {
			
				band = band || revisarFlujoBlanco(fila - 1, columna);
				if(band == true) {
					return band;
				}
			}
			
		}
		//Debajo
		if(!violaReglas(fila + 1, columna)) {
			if(!tableroDeVisitado[fila + 1][ columna] && tablero[fila + 1][ columna]== ColorJugador.BLANCO && tablero[fila + 1][ columna] != null) {
				
				band = band || revisarFlujoBlanco(fila + 1, columna );
				if(band == true) {
					return band;
				}
			}
		}
		/*
		 * //Izq arriba if(!violaReglas(fila - 1, columna - 1) ) {
		 * if(!tableroDeVisitado[fila - 1][ columna - 1]&& tablero[fila - 1][ columna -
		 * 1]== ColorJugador.BLANCO && tablero[fila - 1][ columna - 1] != null) {
		 * 
		 * band = band || revisarFlujoBlanco(fila - 1, columna - 1); if(band == true) {
		 * return band; } } }
		 */
		//Der arriba
		if(!violaReglas(fila - 1, columna + 1)) {
			if(!tableroDeVisitado[fila - 1][ columna + 1]  && tablero[fila - 1][ columna + 1]== ColorJugador.BLANCO && tablero[fila - 1][ columna + 1] != null) {
				
				band = band || revisarFlujoBlanco(fila - 1, columna + 1);
				if(band == true) {
					return band;
				}
			}
		}
		//izq debajo
		if(!violaReglas(fila + 1, columna - 1) ) {
			if(!tableroDeVisitado[fila + 1][ columna - 1]  && tablero[fila + 1][ columna - 1]== ColorJugador.BLANCO  && tablero[fila + 1][ columna - 1] != null){
				
				band = band || revisarFlujoBlanco(fila + 1, columna - 1);
				if(band == true) {
					return band;
				}
			}
		}
		//der debajo
		/*
		 * if(!violaReglas(fila + 1, columna + 1)&& tablero[fila + 1][ columna + 1] ==
		 * ColorJugador.BLANCO && tablero[fila + 1][ columna + 1] != null) {
		 * if(!tableroDeVisitado[fila + 1][ columna + 1]) {
		 * 
		 * band = band || revisarFlujoBlanco(fila + 1, columna + 1); if(band == true) {
		 * return band; } } }
		 */	
		
		return band;
		
	}
	
	@Override
	public ColorJugador casilla(int fila, int columna) {
		
		if(!violaReglas(fila, columna))
			return tablero[fila][columna];
		else
			return null;
	}
	
	private boolean violaReglas(int fila, int columna) {
		if(fila < 11 && columna < 11 && fila >= 0 && columna >= 0)
			return false;
		else 
			return true;
	}
	
	public void imprimirTablero() {
		System.out.print("  ");
		for(int i = 0; i < 11; i++) {
			System.out.print("N ");
		}
		System.out.println();
		for(int i = 0; i < 11; i++) {
			for(int k = 0; k < i; k++) {
				System.out.print(" ");
			}
			System.out.print("B ");
			for(int j = 0; j < 11; j++) {
				if(tablero[i][j] == ColorJugador.BLANCO)
					System.out.print("b ");
				else if(tablero[i][j] == ColorJugador.NEGRO)
					System.out.print("n ");
				else
					System.out.print(". ");
			}
			System.out.println(" B");
		}
		System.out.print("            ");
		for(int i = 0; i < 11; i++) {
			System.out.print("N ");
		}
		System.out.println();
	}
	
	
	private void reiniciarTablervisitados() {

		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				tableroDeVisitado[i][j] = false;
			}
		}
	}

}
