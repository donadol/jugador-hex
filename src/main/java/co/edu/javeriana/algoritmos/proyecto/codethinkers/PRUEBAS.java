package co.edu.javeriana.algoritmos.proyecto.codethinkers;
import java.util.Scanner;



import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.algoritmos.proyecto.ColorJugador;
import co.edu.javeriana.algoritmos.proyecto.Jugada;

import co.edu.javeriana.algoritmos.proyecto.*;


import co.edu.javeriana.algoritmos.proyecto.*;


public class PRUEBAS {
	private static Scanner teclado;
	static JugadorHex j1, j2;
	static long startTime, endTime;
	static ColorJugador cj1, cj2;
	public PRUEBAS() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		playerVSPc2();
		// TODO Auto-generated method s
		teclado = new Scanner(System.in);
		cj1 = ColorJugador.NEGRO;
		cj2 = ColorJugador.BLANCO;
		startTime = System.nanoTime();
		j1 = new JugadorCodeThinkers();
		endTime = System.nanoTime();
		System.out.println("Duración creando jugador: " + (endTime-startTime)/1e6 + " ms");
		j2 = new JugadorCodeThinkers();
		Tablero tablero = new TableroCodeThinkers();
		while(tablero.ganador()==null) {
			pcVsPc(tablero);
			((TableroCodeThinkers) tablero).imprimirTablero();
			System.out.println();
		}
		if( cj1 == tablero.ganador())
			System.out.println(tablero.ganador()+" GANA");
		else
			System.out.println(tablero.ganador()+" :(");
	}
	public static void pcVsPc(Tablero tablero) {
		Jugada j;
		startTime = System.nanoTime();
		j= j1.jugar(tablero, cj1);
		endTime = System.nanoTime();
		System.out.println("Duración buscando una jugada para "+cj1+": "+ (endTime-startTime)/1e6 + " ms");
		//System.out.println(cj1.name()+ " jugada: ["+(j.isCambioColores() ? "cambioColores":"fila=" + numToChar(j.getFila()) + ", columna=" + (j.getColumna()+1)) + "]");
		//System.out.print(numToChar(j.getFila())+""+(j.getColumna()+1)+" ");
		tablero.aplicarJugada(j, cj1);
		if(tablero.ganador()==null) {
			startTime = System.nanoTime();
			j= j2.jugar(tablero, cj2);
			endTime = System.nanoTime();
			System.out.println("Duración buscando una jugada para "+cj2+": "+ (endTime-startTime)/1e6 + " ms");
			//System.out.println(cj2.name()+ " jugada: ["+(j.isCambioColores() ? "cambioColores":"fila=" + numToChar(j.getFila()) + ", columna=" + (j.getColumna()+1)) + "]");
			//System.out.print(numToChar(j.getFila())+""+(j.getColumna()+1)+" ");
			tablero.aplicarJugada(j, cj2);
			if(j.isCambioColores()) {
				cj1=ColorJugador.BLANCO;
				cj2=ColorJugador.NEGRO;
			}
		}
	}
	public static void playerVsPc(Tablero tablero) {
		Jugada j;
		int fila = teclado.nextInt();
		char columna = (char) teclado.next().charAt(0);
		j= new Jugada (fila-1, charToNum(columna));
		System.out.println(cj1.name()+ " jugada: ["+(j.isCambioColores() ? "cambioColores":"fila=" + (j.getFila()+1) + ", columna=" + numToChar(j.getColumna())) + "]");
		tablero.aplicarJugada(j, cj1);
		if(tablero.ganador()==null) {
			startTime = System.nanoTime();
			j= j2.jugar(tablero, cj2);
			endTime = System.nanoTime();
			System.out.println("Duración buscando una jugada para "+cj2+": "+ (endTime-startTime)/1e6 + " ms");
			System.out.println(cj2.name()+ " jugada: ["+(j.isCambioColores() ? "cambioColores":"fila=" + (j.getFila()+1) + ", columna=" + numToChar(j.getColumna())) + "]");
			tablero.aplicarJugada(j, cj2);
			if(j.isCambioColores()) {
				cj1=ColorJugador.BLANCO;
				cj2=ColorJugador.NEGRO;
			}
		}
	}
	public static void pcVsPlayer(Tablero tablero) {
		Jugada j;
		startTime = System.nanoTime();
		j= j1.jugar(tablero, cj1);
		endTime = System.nanoTime();
		System.out.println("Duración buscando una jugada para "+cj1+": "+ (endTime-startTime)/1e6 + " ms");
		System.out.println(cj1.name()+ " jugada: ["+(j.isCambioColores() ? "cambioColores":"fila=" + (j.getFila()+1) + ", columna=" + numToChar(j.getColumna())) + "]");
		tablero.aplicarJugada(j, cj1);
		if(tablero.ganador()==null) {
			int fila = teclado.nextInt();
			char columna = (char) teclado.next().charAt(0);
			int cambioColor = teclado.nextInt();
			if(cambioColor==1) {
				j= new Jugada (true, fila-1, charToNum(columna));
				System.out.println(cj2.name()+ " jugada: ["+(j.isCambioColores() ? "cambioColores":"fila=" + (j.getFila()+1) + ", columna=" + numToChar(j.getColumna())) + "]");
				tablero.aplicarJugada(j, cj2);
				cj1=ColorJugador.BLANCO;
				cj2=ColorJugador.NEGRO;
			}
			else{
				j= new Jugada (fila-1, charToNum(columna));
				System.out.println(cj2.name()+ " jugada: ["+(j.isCambioColores() ? "cambioColores":"fila=" + (j.getFila()+1) + ", columna=" + numToChar(j.getColumna())) + "]");
				tablero.aplicarJugada(j, cj2);
			}
		}
	}
	
	public static void playerVSPc2() {
		
		System.out.println("PRUEBA GANADOR------------------------------");
		
		JugadorCodeThinkers jugador = new JugadorCodeThinkers();
		Jugada j;
		int fila;
		int columna ;
		Scanner teclado  = new Scanner(System.in);
		TableroCodeThinkers tablero = new TableroCodeThinkers();
		
		while(true) {
			
			
			System.out.println("ingrese filas y columnas: ");
			fila = teclado.nextInt();
			columna = teclado.nextInt();
			j= new Jugada (fila, (columna));
			tablero.aplicarJugada(j, ColorJugador.NEGRO);
			tablero.imprimirTablero();
			if(tablero.ganador() == ColorJugador.NEGRO) {
				System.out.println("Gano el negro! ");
				break;
			}else if(tablero.ganador() == ColorJugador.BLANCO) {
				System.out.println("Gano el blanco! ");
				break;
			} 
			tablero.aplicarJugada(jugador.jugar(tablero, ColorJugador.BLANCO), ColorJugador.BLANCO);
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
	public static char numToChar(int n) {
		return (char)(n+65);
	}
}
