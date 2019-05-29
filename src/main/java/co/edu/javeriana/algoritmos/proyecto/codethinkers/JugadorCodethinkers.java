package co.edu.javeriana.algoritmos.proyecto.codethinkers;

import java.util.*;
import co.edu.javeriana.algoritmos.proyecto.ColorJugador;
import co.edu.javeriana.algoritmos.proyecto.Jugada;
import co.edu.javeriana.algoritmos.proyecto.JugadorHex;
import co.edu.javeriana.algoritmos.proyecto.Tablero;

public class JugadorCodethinkers implements JugadorHex {
	
	private int contJugadas;
	private GrafoTablero grafoTablero;
	public JugadorCodethinkers() {
		super();
		contJugadas=0;
		grafoTablero = new GrafoTablero();
	}
	@Override
	public Jugada jugar(Tablero tablero, ColorJugador color) {
		int fila1 = 0, columna1 = 0, fila2 = 0, columna2 = 0;
		int max=-9999, min=9999, aux;
		ColorJugador contrincante = ColorJugador.NEGRO;
		if(color == ColorJugador.NEGRO)
			contrincante = ColorJugador.BLANCO;
		if(contJugadas==0) {
			return primeraJugada(tablero, color);
		}
		else {
			actualizarJugada(tablero);
			for(int i=0; i<11; ++i) {
				for(int j=0; j<11; ++j) {
					if(tablero.casilla(i, j) == null){
						grafoTablero.simularJugada(i, j, color);
						for(int k=0; k<11; ++k) {
							for(int l=0; l<11; ++l) {
								if(k!=i && l!=j) {
									if(tablero.casilla(i, j)==null) {
										grafoTablero.simularJugada(k, l, contrincante);
										aux = grafoTablero.obtenerDistanciaBordes(contrincante);
										if(aux<min){
											min = aux;
											fila2 = i;
											columna2 = j;
										}
										grafoTablero.eliminarSimulacion(k, l);
									}
								}
							}	
						}
						aux = grafoTablero.obtenerDistanciaBordes(color);
						if(aux>max) {
							max = aux;
							fila1 = fila2;
							columna1 = columna2;
						}
						grafoTablero.eliminarSimulacion(i, j);
					}
				}
			}
		}
		contJugadas++;
		grafoTablero.aplicarJugada(fila1, columna1, color);
		return new Jugada(fila1, columna1);
	}

	@Override
	public String nombreJugador() {
		return "ElMejorJugadorDeHexDelUniversoEnteroProfePonganos5";
	}
	
	public Jugada primeraJugada(Tablero tablero, ColorJugador color) {
		List<ArrayList<Integer>> posiblesJugadas = new ArrayList<ArrayList<Integer>>();
		if(color==ColorJugador.NEGRO) { //inicia juego	
			for(int i=0; i<3; ++i) {
				posiblesJugadas.add(new ArrayList<Integer>(Arrays.asList(2,i)));
			}
			for(int i=0; i<4; ++i) {
				posiblesJugadas.add(new ArrayList<Integer>(Arrays.asList(3,i)));
			}
			for(int i=10; i>=7; --i) {
				posiblesJugadas.add(new ArrayList<Integer>(Arrays.asList(7,i)));
			}
			for(int i=10; i>=8; --i) {
				posiblesJugadas.add(new ArrayList<Integer>(Arrays.asList(8,i)));
			}
			int x = (int) (Math.random()*posiblesJugadas.size());
			return new Jugada(posiblesJugadas.get(x).get(0).intValue(), posiblesJugadas.get(x).get(1).intValue());
		}
		else {
			if(tablero.casilla(0,0)==ColorJugador.NEGRO || tablero.casilla(0,1)==ColorJugador.NEGRO || tablero.casilla(1,0)==ColorJugador.NEGRO 
					|| tablero.casilla(9,10)==ColorJugador.NEGRO || tablero.casilla(10,10)==ColorJugador.NEGRO || tablero.casilla(10,9)==ColorJugador.NEGRO) {
				return new Jugada(5, 5);
			}
			return new Jugada(true, 0, 0);
		}
	}
	
	public void actualizarJugada(Tablero tablero) {
		for(int i=0; i<11; ++i) {
			for(int j=0; j<11; ++j) {
				if(tablero.casilla(i, j)!=this.grafoTablero.casilla(i, j)) {
					this.grafoTablero.aplicarJugada(i, j, tablero.casilla(i, j));
				}
			}
		}
	}
}
