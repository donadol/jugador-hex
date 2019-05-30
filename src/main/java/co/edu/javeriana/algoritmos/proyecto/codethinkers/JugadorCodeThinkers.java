package co.edu.javeriana.algoritmos.proyecto.codethinkers;

import java.util.*;
import co.edu.javeriana.algoritmos.proyecto.ColorJugador;
import co.edu.javeriana.algoritmos.proyecto.Jugada;
import co.edu.javeriana.algoritmos.proyecto.JugadorHex;
import co.edu.javeriana.algoritmos.proyecto.Tablero;

public class JugadorCodeThinkers implements JugadorHex {
	
	private int contJugadas;
	private GrafoTablero grafoTablero;
	
	private int [][] valoresCentro;
	
	private static int VALOR_AZULES = 2;
	private static int VALOR_AMARILLOS = 3;
	private static int VALOR_NARANJAS = 5;
	
	public JugadorCodeThinkers() {
		super();
		contJugadas=0;
		grafoTablero = new GrafoTablero();
		
		valoresCentro = new int [11][11];	
		
		valoresCentro[2][5] = VALOR_AZULES;
		valoresCentro[2][6] = VALOR_AZULES;
		valoresCentro[2][7] = VALOR_AZULES;
		valoresCentro[2][8] = VALOR_AZULES;
		valoresCentro[3][4] = VALOR_AZULES;
		valoresCentro[3][8] = VALOR_AZULES;
		valoresCentro[4][3] = VALOR_AZULES;
		valoresCentro[4][8] = VALOR_AZULES;
		
		valoresCentro[5][2] = VALOR_AZULES;
		valoresCentro[5][8] = VALOR_AZULES;
		valoresCentro[6][2] = VALOR_AZULES;
		valoresCentro[6][7] = VALOR_AZULES;
		
		valoresCentro[7][2] = VALOR_AZULES;
		valoresCentro[7][6] = VALOR_AZULES;
		valoresCentro[8][2] = VALOR_AZULES;
		valoresCentro[8][3] = VALOR_AZULES;
		valoresCentro[8][4] = VALOR_AZULES;
		valoresCentro[8][5] = VALOR_AZULES;
		
		
		valoresCentro[3][5] = VALOR_AMARILLOS;
		valoresCentro[3][6] = VALOR_AMARILLOS;
		valoresCentro[3][7] = VALOR_AMARILLOS;
		valoresCentro[4][4] = VALOR_AMARILLOS;
		valoresCentro[4][7] = VALOR_AMARILLOS;
		valoresCentro[5][3] = VALOR_AMARILLOS;
		valoresCentro[5][7] = VALOR_AMARILLOS;
		valoresCentro[6][3] = VALOR_AMARILLOS;
		valoresCentro[6][6] = VALOR_AMARILLOS;
		valoresCentro[7][3] = VALOR_AMARILLOS;
		valoresCentro[7][4] = VALOR_AMARILLOS;
		valoresCentro[7][5] = VALOR_AMARILLOS;
		
		
		valoresCentro[4][5] = VALOR_NARANJAS;
		valoresCentro[4][6] = VALOR_NARANJAS;
		valoresCentro[5][4] = VALOR_NARANJAS;
		valoresCentro[5][5] = VALOR_NARANJAS;
		valoresCentro[5][6] = VALOR_NARANJAS;
		valoresCentro[6][4] = VALOR_NARANJAS;
		valoresCentro[6][5] = VALOR_NARANJAS;
		
	}
	
	public int getContJugadas() {
		return contJugadas;
	}

	public void setContJugadas(int contJugadas) {
		this.contJugadas = contJugadas;
	}

	public GrafoTablero getGrafoTablero() {
		return grafoTablero;
	}

	public void setGrafoTablero(GrafoTablero grafoTablero) {
		this.grafoTablero = grafoTablero;
	}

	@Override
	public Jugada jugar(Tablero tablero, ColorJugador color) {
		int fila1 = 0, columna1 = 0;
		int min2=9999, min=9999, aux, aux2;
		ColorJugador contrincante = ColorJugador.NEGRO;
		actualizarGrafo(tablero);
		if(color == ColorJugador.NEGRO)
			contrincante = ColorJugador.BLANCO;
		if(contJugadas==0) {
			this.contJugadas++;
			return primeraJugada(tablero, color);
		}
		else {
			for(int i=0; i<11; ++i) {
				for(int j=0; j<11; ++j) {
					if(tablero.casilla(i, j) == null){
						grafoTablero.simularJugada(i, j, color);
						
						for(int k=0; k<11; ++k) {
							for(int l=0; l<11; ++l) {
								if(k!=i && l!=j) {
									if(tablero.casilla(k, l)==null) {
										grafoTablero.simularJugada(k, l, contrincante);

										aux =  grafoTablero.obtenerDistanciaBordes(contrincante) - grafoTablero.obtenerDistanciaBordes(color);
										if(aux<min){
											min = aux;
										}
										grafoTablero.eliminarSimulacion(k, l);
									}
								}
							}	
						}

						
						aux2 = grafoTablero.obtenerDistanciaBordes(color) - grafoTablero.obtenerDistanciaBordes(contrincante)-min;
						if (contJugadas < 5) 
							aux2 -= valoresCentro[i][j];
						
							
						
						if(aux2<min2) {
							min2 = aux2;
							fila1 = i;
							columna1 = j;
						}					
						

						grafoTablero.eliminarSimulacion(i, j);
						min = 99999;
					}
				}
			}
		}
		this.contJugadas++;
		grafoTablero.aplicarJugada(fila1, columna1, color);
		return new Jugada(fila1, columna1);
	}

	@Override
	public String nombreJugador() {
		return "HEXMEN";
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
			int[] pos = obtenerJugada(tablero);
			return new Jugada(true, pos[1], pos[0]);
		}
	}
	
	public void actualizarGrafo(Tablero tablero) {
		for(int i=0; i<11; ++i) {
			for(int j=0; j<11; ++j) {
				if(tablero.casilla(i, j)!=this.grafoTablero.casilla(i, j)) {
					this.grafoTablero.aplicarJugada(i, j, tablero.casilla(i, j));
				}
			}
		}
	}
	public int[] obtenerJugada(Tablero tablero) {
		int[] pos = new int[2];
		for(int i=0; i<11; ++i) {
			for(int j=0; j<11; ++j) {
				if(tablero.casilla(i, j)!=this.grafoTablero.casilla(i, j)) {
					pos[0]=i;
					pos[1]=j;
				}
			}
		}
		return pos;
	}
	

}
