package co.edu.javeriana.algoritmos.proyecto.codethinkers;
import java.util.Scanner;

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
		teclado = new Scanner(System.in);
		cj1 = ColorJugador.NEGRO;
		cj2 = ColorJugador.BLANCO;
		startTime = System.nanoTime();
		j1 = new JugadorCodethinkers();
		endTime = System.nanoTime();
		System.out.println("Duración creando jugador: " + (endTime-startTime)/1e6 + " ms");
		j2 = new JugadorCodethinkers();
		Tablero tablero = new TableroCodeThinkers();
		while(tablero.ganador()==null) {
			pcVsPc(tablero);
		}
		System.out.println(tablero.ganador());
	}
	public static void pcVsPc(Tablero tablero) {
		Jugada j;
		startTime = System.nanoTime();
		j= j1.jugar(tablero, cj1);
		endTime = System.nanoTime();
		System.out.println("Duración buscando una jugada para "+cj1+": "+ (endTime-startTime)/1e6 + " ms");
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
	public static int charToNum(char n) {
		return n-65;
	}
	public static char numToChar(int n) {
		return (char)(n+65);
	}
}
