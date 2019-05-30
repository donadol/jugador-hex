package co.edu.javeriana.algoritmos.proyecto.codethinkers;

import java.util.List;
import java.util.Scanner;

import co.edu.javeriana.algoritmos.proyecto.ColorJugador;
import co.edu.javeriana.algoritmos.proyecto.Jugada;

public class PRUEBASPOPO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" ");
		System.out.println("-----------------------------------PRUEBAS SOBRE JUGADA---------------------------------------------");
		System.out.println(" ");			
		
		
		
		
		System.out.println(" ");
		System.out.println("-----------------------------------PRUEBAS SOBRE OBTENERVECINOS---------------------------------------------");
		System.out.println(" ");	
		
		GrafoTablero grafoAux = new GrafoTablero();
		VerticeHex verticeARevisar = new VerticeHex();
		verticeARevisar.setFila(0);
		verticeARevisar.setColumna(0);
		verticeARevisar.setColor(ColorJugador.BLANCO);
		
		
		grafoAux.simularJugada(0, 0, ColorJugador.BLANCO);
		grafoAux.simularJugada(0, 1, ColorJugador.BLANCO);
		grafoAux.simularJugada(1, 0, ColorJugador.NEGRO);
		grafoAux.simularJugada(1, 1, ColorJugador.BLANCO);
		
		List<VerticeHex> listaResultadosAProbar = grafoAux.obtenerVecinos(verticeARevisar, ColorJugador.BLANCO);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Para el vertice de: ");
		System.out.println("Color: " + verticeARevisar.getColor()+ ", Fila: " + verticeARevisar.getFila() + ", Columna: " + verticeARevisar.getColumna());
		System.out.println("tiene los Sig vecinos: ");
		System.out.println(" ");
		System.out.println(" ");
		for(VerticeHex v : listaResultadosAProbar) {
			System.out.println("Color: " + v.getColor()+ ", Fila: " + v.getFila() + ", Columna: " + v.getColumna());
			System.out.println(" ");
		}
		grafoAux.imprimirTablero();
		
		
		System.out.println(" ");
		System.out.println("----------------------------------------esquina superior der-----------------------------------------");
		System.out.println(" ");
		
		verticeARevisar.setFila(0);
		verticeARevisar.setColumna(10);
		verticeARevisar.setColor(ColorJugador.BLANCO);
		
		
		grafoAux.simularJugada(0, 10, ColorJugador.BLANCO);
		grafoAux.simularJugada(0, 9, ColorJugador.NEGRO);
		grafoAux.simularJugada(1, 9, ColorJugador.BLANCO);
		grafoAux.simularJugada(1, 10, ColorJugador.BLANCO);
		
		listaResultadosAProbar = grafoAux.obtenerVecinos(verticeARevisar, ColorJugador.BLANCO);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Para el vertice de: ");
		System.out.println("Color: " + verticeARevisar.getColor()+ ", Fila: " + verticeARevisar.getFila() + ", Columna: " + verticeARevisar.getColumna());
		System.out.println("tiene los Sig vecinos: ");
		System.out.println(" ");
		System.out.println(" ");
		for(VerticeHex v : listaResultadosAProbar) {
			System.out.println("Color: " + v.getColor()+ ", Fila: " + v.getFila() + ", Columna: " + v.getColumna());
			System.out.println(" ");
		}
		grafoAux.imprimirTablero();
		
		System.out.println(" ");
		System.out.println("---------------------------------------pared izq------------------------------------------");
		System.out.println(" ");
		
		verticeARevisar.setFila(5);
		verticeARevisar.setColumna(0);
		verticeARevisar.setColor(ColorJugador.BLANCO);
		
		
		grafoAux.simularJugada(5, 0, ColorJugador.BLANCO);
		grafoAux.simularJugada(5, 0, ColorJugador.NEGRO);
		grafoAux.simularJugada(6, 0, ColorJugador.BLANCO);
		grafoAux.simularJugada(5, 1, ColorJugador.NEGRO);
		grafoAux.simularJugada(4, 1, ColorJugador.BLANCO);
		grafoAux.simularJugada(6, 1, ColorJugador.NEGRO);
		grafoAux.simularJugada(4, 0, ColorJugador.NEGRO);
		
		listaResultadosAProbar = grafoAux.obtenerVecinos(verticeARevisar, ColorJugador.BLANCO);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Para el vertice de: ");
		System.out.println("Color: " + verticeARevisar.getColor()+ ", Fila: " + verticeARevisar.getFila() + ", Columna: " + verticeARevisar.getColumna());
		System.out.println("tiene los Sig vecinos: ");
		System.out.println(" ");
		System.out.println(" ");
		for(VerticeHex v : listaResultadosAProbar) {
			System.out.println("Color: " + v.getColor()+ ", Fila: " + v.getFila() + ", Columna: " + v.getColumna());
			System.out.println(" ");
		}
		grafoAux.imprimirTablero();
		
		System.out.println(" ");
		System.out.println("----------------------------------------Pared der-----------------------------------------");
		System.out.println(" ");
		
		verticeARevisar.setFila(5);
		verticeARevisar.setColumna(10);
		verticeARevisar.setColor(ColorJugador.BLANCO);
		
		
		grafoAux.simularJugada(5, 10, ColorJugador.BLANCO);
		grafoAux.simularJugada(4, 10, ColorJugador.NEGRO);
		grafoAux.simularJugada(6, 10, ColorJugador.NEGRO);
		grafoAux.simularJugada(6, 9, ColorJugador.NEGRO);
		grafoAux.simularJugada(4, 9, ColorJugador.NEGRO);
		grafoAux.simularJugada(5, 9, ColorJugador.NEGRO);
		
		listaResultadosAProbar = grafoAux.obtenerVecinos(verticeARevisar, ColorJugador.BLANCO);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Para el vertice de: ");
		System.out.println("Color: " + verticeARevisar.getColor()+ ", Fila: " + verticeARevisar.getFila() + ", Columna: " + verticeARevisar.getColumna());
		System.out.println("tiene los Sig vecinos: ");
		System.out.println(" ");
		System.out.println(" ");
		for(VerticeHex v : listaResultadosAProbar) {
			System.out.println("Color: " + v.getColor()+ ", Fila: " + v.getFila() + ", Columna: " + v.getColumna());
			System.out.println(" ");
		}
		grafoAux.imprimirTablero();		
		
		System.out.println(" ");
		System.out.println("------------------------------------esquina inferior izq---------------------------------------------");
		System.out.println(" ");
		
		verticeARevisar.setFila(10);
		verticeARevisar.setColumna(0);
		verticeARevisar.setColor(ColorJugador.NEGRO);
		
		
		grafoAux.simularJugada(10, 0, ColorJugador.NEGRO);
		grafoAux.simularJugada(9, 0, ColorJugador.BLANCO);
		grafoAux.simularJugada(10, 1, ColorJugador.NEGRO);
		grafoAux.simularJugada(9, 1, ColorJugador.NEGRO);
		
		
		listaResultadosAProbar = grafoAux.obtenerVecinos(verticeARevisar, ColorJugador.NEGRO);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Para el vertice de: ");
		System.out.println("Color: " + verticeARevisar.getColor()+ ", Fila: " + verticeARevisar.getFila() + ", Columna: " + verticeARevisar.getColumna());
		System.out.println("tiene los Sig vecinos: ");
		System.out.println(" ");
		System.out.println(" ");
		for(VerticeHex v : listaResultadosAProbar) {
			System.out.println("Color: " + v.getColor()+ ", Fila: " + v.getFila() + ", Columna: " + v.getColumna());
			System.out.println(" ");
		}
		grafoAux.imprimirTablero();			
		
		System.out.println(" ");
		System.out.println("---------------------------------------esquina inferior der------------------------------------------");
		System.out.println(" ");
		
		verticeARevisar.setFila(10);
		verticeARevisar.setColumna(10);
		verticeARevisar.setColor(ColorJugador.BLANCO);
		
		
		grafoAux.simularJugada(10, 10, ColorJugador.BLANCO);
		grafoAux.simularJugada(9, 9, ColorJugador.NEGRO);
		grafoAux.simularJugada(10, 9, ColorJugador.BLANCO);
		grafoAux.simularJugada(9, 10, ColorJugador.NEGRO);
		
		listaResultadosAProbar = grafoAux.obtenerVecinos(verticeARevisar, ColorJugador.BLANCO);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Para el vertice de: ");
		System.out.println("Color: " + verticeARevisar.getColor()+ ", Fila: " + verticeARevisar.getFila() + ", Columna: " + verticeARevisar.getColumna());
		System.out.println("tiene los Sig vecinos: ");
		System.out.println(" ");
		System.out.println(" ");
		for(VerticeHex v : listaResultadosAProbar) {
			System.out.println("Color: " + v.getColor()+ ", Fila: " + v.getFila() + ", Columna: " + v.getColumna());
			System.out.println(" ");
		}
		grafoAux.imprimirTablero();	
		
		System.out.println(" ");
		System.out.println("----------------------------------------pared de arriba-----------------------------------------");
		System.out.println(" ");
		
		verticeARevisar.setFila(0);
		verticeARevisar.setColumna(5);
		verticeARevisar.setColor(ColorJugador.NEGRO);
		
		
		grafoAux.simularJugada(0, 5, ColorJugador.NEGRO);
		grafoAux.simularJugada(0, 4, ColorJugador.NEGRO);
		grafoAux.simularJugada(0, 6, ColorJugador.NEGRO);
		grafoAux.simularJugada(1, 5, ColorJugador.BLANCO);
		grafoAux.simularJugada(1, 4, ColorJugador.NEGRO);
		grafoAux.simularJugada(1, 6, ColorJugador.NEGRO);
		
		listaResultadosAProbar = grafoAux.obtenerVecinos(verticeARevisar, ColorJugador.NEGRO);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Para el vertice de: ");
		System.out.println("Color: " + verticeARevisar.getColor()+ ", Fila: " + verticeARevisar.getFila() + ", Columna: " + verticeARevisar.getColumna());
		System.out.println("tiene los Sig vecinos: ");
		System.out.println(" ");
		System.out.println(" ");
		for(VerticeHex v : listaResultadosAProbar) {
			System.out.println("Color: " + v.getColor()+ ", Fila: " + v.getFila() + ", Columna: " + v.getColumna());
			System.out.println(" ");
		}
		grafoAux.imprimirTablero();	
		
		System.out.println(" ");
		System.out.println("----------------------------------------Centro-----------------------------------------");
		System.out.println(" ");
		
		verticeARevisar.setFila(5);
		verticeARevisar.setColumna(5);
		verticeARevisar.setColor(ColorJugador.BLANCO);
		
		
		grafoAux.simularJugada(5, 5, ColorJugador.BLANCO);
		grafoAux.simularJugada(4, 4, ColorJugador.NEGRO);
		grafoAux.simularJugada(6, 6, ColorJugador.NEGRO);
		grafoAux.simularJugada(6, 4, ColorJugador.BLANCO);
		grafoAux.simularJugada(4, 6, ColorJugador.NEGRO);
		grafoAux.simularJugada(5, 6, ColorJugador.NEGRO);
		grafoAux.simularJugada(6, 5, ColorJugador.NEGRO);
		grafoAux.simularJugada(5, 4, ColorJugador.BLANCO);
		grafoAux.simularJugada(4, 5, ColorJugador.NEGRO);
		
		listaResultadosAProbar = grafoAux.obtenerVecinos(verticeARevisar, ColorJugador.BLANCO);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Para el vertice de: ");
		System.out.println("Color: " + verticeARevisar.getColor()+ ", Fila: " + verticeARevisar.getFila() + ", Columna: " + verticeARevisar.getColumna());
		System.out.println("tiene los Sig vecinos: ");
		System.out.println(" ");
		System.out.println(" ");
		for(VerticeHex v : listaResultadosAProbar) {
			System.out.println("Color: " + v.getColor()+ ", Fila: " + v.getFila() + ", Columna: " + v.getColumna());
			System.out.println(" ");
		}
		grafoAux.imprimirTablero();	
		
		System.out.println(" ");
		System.out.println("------------------------------------Pared inferior---------------------------------------------");
		System.out.println(" ");
		
		verticeARevisar.setFila(10);
		verticeARevisar.setColumna(5);
		verticeARevisar.setColor(ColorJugador.NEGRO);
		
		
		grafoAux.simularJugada(10, 5, ColorJugador.NEGRO);
		grafoAux.simularJugada(9, 5, ColorJugador.BLANCO);
		grafoAux.simularJugada(9, 6, ColorJugador.BLANCO);
		grafoAux.simularJugada(9, 4, ColorJugador.NEGRO);
		grafoAux.simularJugada(10, 4, ColorJugador.NEGRO);
		grafoAux.simularJugada(10, 6, ColorJugador.NEGRO);
		
		listaResultadosAProbar = grafoAux.obtenerVecinos(verticeARevisar, ColorJugador.NEGRO);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Para el vertice de: ");
		System.out.println("Color: " + verticeARevisar.getColor()+ ", Fila: " + verticeARevisar.getFila() + ", Columna: " + verticeARevisar.getColumna());
		System.out.println("tiene los Sig vecinos: ");
		System.out.println(" ");
		System.out.println(" ");
		for(VerticeHex v : listaResultadosAProbar) {
			System.out.println("Color: " + v.getColor()+ ", Fila: " + v.getFila() + ", Columna: " + v.getColumna());
			System.out.println(" ");
		}
		grafoAux.imprimirTablero();	

		System.out.println(" ");
		System.out.println("------------------------------------PRUEBAS SOBRE JUAGAR---------------------------------------------");
		System.out.println(" ");
		
		JugadorCodeThinkers jugador = new JugadorCodeThinkers();
		JugadorCodeThinkers jugador2 = new JugadorCodeThinkers();
		TableroCodeThinkers tablero =new TableroCodeThinkers();
		
		
		boolean band = false;
		
		while(band == true) {
			
			tablero.aplicarJugada(jugador2.jugar(tablero, ColorJugador.BLANCO), ColorJugador.BLANCO);
			
			if(tablero.ganador() == ColorJugador.NEGRO) {
				System.out.println("Gano el negro! ");
				break;
			}else if(tablero.ganador() == ColorJugador.BLANCO) {
				System.out.println("Gano el blanco! ");
				break;
			}

			tablero.aplicarJugada(jugador.jugar(tablero, ColorJugador.NEGRO), ColorJugador.NEGRO);
			
			if(tablero.ganador() == ColorJugador.NEGRO) {
				System.out.println("Gano el negro! ");
				break;
			}else if(tablero.ganador() == ColorJugador.BLANCO) {
				System.out.println("Gano el blanco! ");
				break;
			} 
			tablero.imprimirTablero();
		}
		
		tablero.imprimirTablero();
		
		System.out.println("PRUEBA GANADOR------------------------------");
		Jugada j;
		int fila;
		int columna ;
		 Scanner teclado  = new Scanner(System.in);
		while(true) {
			
			
			System.out.println("ingrese filas y columnas: ");
			fila = teclado.nextInt();
			columna = teclado.nextInt();
			j= new Jugada (fila, (columna));
			tablero.aplicarJugada(j, ColorJugador.NEGRO);
			tablero.aplicarJugada(new Jugada( 0 , 5), ColorJugador.BLANCO);
			tablero.imprimirTablero();
			
			if(tablero.ganador() == ColorJugador.NEGRO) {
				System.out.println("Gano el negro! ");
				break;
			}else if(tablero.ganador() == ColorJugador.BLANCO) {
				System.out.println("Gano el blanco! ");
				break;
			} 
		}
		
		
	}
	public static int charToNum(char n) {
		return n-65;
	}
}
