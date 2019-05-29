package co.edu.javeriana.algoritmos.proyecto.codethinkers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


import co.edu.javeriana.algoritmos.proyecto.ColorJugador;

public class GrafoTablero {
	private static int INF = 1000;
	
	private static int TAM_TABLERO = 11;
	
	private static int BORDE_BLANCO_IZQUIERDO = -1;
	private static int BORDE_BLANCO_DERECHO = 11;
	
	private static int BORDE_NEGRO_SUPERIOR = -1;
	private static int BORDE_NEGRO_INFERIOR = 11;
	
	private VerticeHex [][] tablero;
	
	
	private VerticeHex bordeNegroSuperior; 
	private VerticeHex bordeNegroInferior;
	private VerticeHex bordeBlancoIzquierda;
	private VerticeHex bordeBlancoDerecha;

	public GrafoTablero() {
		// TODO Auto-generated constructor stub
		//el tablero es representado como una matriz de 11 x 11
		
		tablero = new VerticeHex [11][11];
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				tablero[i][j] = new VerticeHex();
				tablero[i][j].setFila(i);
				tablero[i][j].setColumna(j);
			}
		}
		
		bordeNegroSuperior = new VerticeHex(ColorJugador.NEGRO);
		bordeNegroSuperior.setFila(BORDE_NEGRO_SUPERIOR);
		
		bordeNegroInferior = new VerticeHex(ColorJugador.NEGRO); 
		bordeNegroInferior.setFila(BORDE_NEGRO_INFERIOR);
		
		bordeBlancoIzquierda = new VerticeHex(ColorJugador.BLANCO);
		bordeBlancoIzquierda.setColumna(BORDE_BLANCO_IZQUIERDO);
		
		bordeBlancoDerecha = new VerticeHex(ColorJugador.BLANCO);
		bordeBlancoDerecha.setColumna(BORDE_BLANCO_DERECHO);
		
		
		
	}
	
	
	
	
	public int obtenerDistanciaBordes (ColorJugador color) {
		VerticeHex v;
		int costoAristavu;
		//Reinicia los valores de distancia de cada uno de los vertices
		reiniciarDistancias();
		reiniciarMarcas();


		VerticeHex inicio;
		if (color == ColorJugador.BLANCO) 
			inicio = bordeBlancoIzquierda;
		else 
			inicio = bordeNegroSuperior;
		
		
		inicio.setDistancia(0);		
		inicio.setMarcado(true);	

		PriorityQueue<VerticeHex> colaPrioridad = new PriorityQueue<VerticeHex>((11*11+4), new ComparadorVerticeHex());
		colaPrioridad.add(inicio);
		
		Map <VerticeHex, VerticeHex> previo = new HashMap <VerticeHex, VerticeHex>();
		previo.put(inicio, null);

		while (!colaPrioridad.isEmpty()) {
		
			v = colaPrioridad.remove();
			v.setMarcado(true);
			//System.out.println("Bueno: "+ v.getFila() +"  "+v.getColumna());
			for (VerticeHex u: obtenerVecinos(v, color)) {
				//System.out.println("	Vecino: " + u.getFila() +" "+ u.getColumna());
				if (!u.isMarcado()) {
					costoAristavu = obtenerCostoArista(v, u, color);
					if (u.getDistancia() > v.getDistancia() + costoAristavu) {
						//System.out.println("Costo: "+ costoAristavu);
						u.setDistancia(v.getDistancia() + costoAristavu);
						previo.put(u, v);
						colaPrioridad.offer(u);
					}
				}
			}
		}
		
		
		VerticeHex prueba;
		if (color == ColorJugador.BLANCO)
			prueba = bordeBlancoDerecha;
		else
			prueba = bordeNegroInferior;
		/*
		while (prueba != null) {
			prueba = previo.get(prueba);
			if (prueba != null)
				System.out.println (prueba.getFila() + "  " +prueba.getColumna());
		}*/
		
		
		if (color == ColorJugador.BLANCO) 
			return bordeBlancoDerecha.getDistancia() - 1;
		else
			return bordeNegroInferior.getDistancia() - 1;
		
	}
	
	private void reiniciarDistancias () {
		for (int i = 0; i < 11 ; i++) {
			for (int j = 0; j < 11; j++) {
				tablero [i][j].setDistancia(INF);
			}
		}
		
		bordeNegroSuperior.setDistancia(INF);
		bordeNegroInferior.setDistancia(INF);
		bordeBlancoIzquierda.setDistancia(INF);
		bordeBlancoDerecha.setDistancia(INF);
	}
	
	private void reiniciarMarcas () {
		
		for (int i = 0; i < 11 ; i++) {
			for (int j = 0; j < 11; j++) {
				tablero [i][j].setMarcado(false);
			}
		}
		
		bordeNegroSuperior.setMarcado(false);
		bordeNegroInferior.setMarcado(false);
		bordeBlancoIzquierda.setMarcado(false);
		bordeBlancoDerecha.setMarcado(false);
	}
	
	
	
	
	//OPTIMIZACIÓN MEMORIA: Crear lista como atributo y hacer clear? - menos memoria?
	//OPTIMIZACIÓN : RETORNAR ANTES
	List<VerticeHex> obtenerVecinos (VerticeHex v, ColorJugador color){
		List<VerticeHex> vecinos = new ArrayList<VerticeHex>();
		
		
		//Se retorna la primera columna
		if (v.getColumna() == BORDE_BLANCO_IZQUIERDO && color == ColorJugador.BLANCO) { 
			for (int i = 0; i < 11; i++) 
				vecinos.add(tablero[i][0]);
			return vecinos;
		}

		//Se retorna la última columna
		if (v.getColumna() == BORDE_BLANCO_DERECHO && color == ColorJugador.BLANCO) { 
			for (int i = 0; i < 11; i++) 
				vecinos.add(tablero[i][10]);
			return vecinos;
		}
			
		
		//Se retorna la primera fila
		if (v.getFila() == BORDE_NEGRO_SUPERIOR && color == ColorJugador.NEGRO) {
			for (int j = 0; j < 11; j++)
				vecinos.add(tablero[0][j]);
			return vecinos;
		}
		
		//Se retorna la última fila
		if (v.getFila() == BORDE_NEGRO_INFERIOR && color == ColorJugador.NEGRO) {
			for (int j = 0; j < 11; j++)
				vecinos.add(tablero[10][j]);
			return vecinos;
		}
		
		
		
		
		int i = v.getFila();
		int j = v.getColumna();
		
		//Se agregan los diferentes vecinos:
		if (esCasillaValida(i - 1, j)) 
			vecinos.add(tablero [i - 1][j]);
		
		if (esCasillaValida(i + 1, j)) 
			vecinos.add(tablero [i + 1][j]);
				
		if (esCasillaValida(i, j + 1)) 
			vecinos.add(tablero [i][j + 1]);
		
		if (esCasillaValida(i, j - 1)) 
			vecinos.add(tablero [i][j - 1]);
		
		if (esCasillaValida(i - 1, j + 1)) 
			vecinos.add(tablero [i - 1][j + 1]);
		
		if (esCasillaValida(i + 1, j - 1)) 
			vecinos.add(tablero [i + 1][j - 1]);
		
		
		
		
		//Agregar vecino de borde
		
		// borde superior
		if (i == 0 && color == ColorJugador.NEGRO)
			vecinos.add(bordeNegroSuperior);
		
		// borde inferior
		if (i == 10 && color == ColorJugador.NEGRO) 
			vecinos.add(bordeNegroInferior);
		
		// borde izquierdo
		if (j == 0 && color == ColorJugador.BLANCO)
			vecinos.add(bordeBlancoIzquierda);
		
		// borde derecho
		if (j == 10 && color == ColorJugador.BLANCO)
			vecinos.add(bordeBlancoDerecha);		
		
		return vecinos;
	}
	
	
	//(si es borde el costo debería ser 0 o restar 2)	
	private int obtenerCostoArista (VerticeHex u, VerticeHex v, ColorJugador color) {
		
		if (u == bordeBlancoIzquierda || u == bordeBlancoDerecha || u == bordeNegroInferior || u == bordeNegroSuperior)
			return 1;
		
		if (v == bordeBlancoIzquierda || v == bordeBlancoDerecha || v == bordeNegroInferior || v == bordeNegroSuperior)
			return 1;
		
		
		if (u.getColor() == null && v.getColor() == null) {
			return 1;
		}
		
		if (u.getColor() == ColorJugador.BLANCO && v.getColor() == ColorJugador.NEGRO)
			return INF;
		
		if (u.getColor() == ColorJugador.NEGRO && v.getColor() == ColorJugador.BLANCO)
			return INF;
		
		
		//Perspectiva del blanco
		if (color == ColorJugador.BLANCO) {
			
			if (u.getColor() == ColorJugador.NEGRO && v.getColor() == ColorJugador.NEGRO)
				return INF;
			
			if (u.getColor() == ColorJugador.BLANCO && v.getColor() == ColorJugador.BLANCO)
				return 0;
			
			if (u.getColor() == ColorJugador.BLANCO && v.getColor() == null)
				return 1;
			
			if (u.getColor() == null && v.getColor() == ColorJugador.BLANCO)
				return 0;
			
			if (u.getColor() == null && v.getColor() == ColorJugador.NEGRO) {
				//System.out.println("HOLAAA");
				return INF;
				
			}
			
			if (u.getColor() == ColorJugador.NEGRO && v.getColor() == null)
				return INF;
			
		}
		else { //Perspectiva del negro
			
			if (u.getColor() == ColorJugador.BLANCO && v.getColor() == ColorJugador.BLANCO)
				return INF;
			
			if (u.getColor() == ColorJugador.NEGRO && v.getColor() == ColorJugador.NEGRO)
				return 0;
			
			if (u.getColor() == ColorJugador.NEGRO && v.getColor() == null)
				return 1;
			
			if (u.getColor() == null && v.getColor() == ColorJugador.NEGRO)
				return 0;
			
			if (u.getColor() == null && v.getColor() == ColorJugador.BLANCO)
				return INF;
			
			if (u.getColor() == ColorJugador.BLANCO && v.getColor() == null)
				return INF;
		}
		
		return INF;			
		
	}
	
	private boolean esCasillaValida (int fila, int columna) {
		return (   (fila >= 0 && fila < TAM_TABLERO)  &&  (columna >= 0 && columna < TAM_TABLERO) );
	}
	
	//que pasa si la jugada está por fuera del tablero?? 
	public void simularJugada (int fila, int columna, ColorJugador color) {
		tablero[fila][columna].setColor(color);
	}
	
	public void eliminarSimulacion (int fila, int columna) {
		tablero[fila][columna].setColor(null);
	}
	
<<<<<<< HEAD
	public void imprimirTablero() {
		System.out.print("\n");
		for(int i = 0; i < 11; i++) {
			//System.out.print("Fila " + i + ": ");
			for(int j = 0; j < 11; j++) {
				if(tablero[i][j].getColor() == ColorJugador.BLANCO)
					System.out.print("b ");
				else if(tablero[i][j].getColor() == ColorJugador.NEGRO)
					System.out.print("n ");
				else
					System.out.print(". ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
=======
	public ColorJugador casilla(int fila, int columna) {
		return this.tablero[fila][columna].getColor();
	}
	
	public void aplicarJugada (int fila, int columna, ColorJugador color) {
		tablero[fila][columna].setColor(color);
	}
	
	
>>>>>>> b7e356c160d1b8a42828c49c871610d0c761e22b
	

}
