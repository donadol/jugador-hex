package co.edu.javeriana.algoritmos.proyecto.codethinkers;

import java.util.List;

import co.edu.javeriana.algoritmos.proyecto.ColorJugador;

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
		
//		GrafoTablero grafo = new GrafoTablero();
//		long startTime = System.nanoTime();
///*
//		for (int i = 0; i< 40000; i++) {
//			grafo.simularJugada(5, 5, ColorJugador.BLANCO);
//			grafo.simularJugada(5, 6, ColorJugador.BLANCO);
//			grafo.obtenerDistanciaBordes(ColorJugador.BLANCO);*/
//
//		
//			grafo.simularJugada(8, 2, ColorJugador.BLANCO);
//			grafo.simularJugada(9, 8, ColorJugador.BLANCO);
//			grafo.simularJugada(3, 4, ColorJugador.BLANCO);
//			grafo.simularJugada(9, 5, ColorJugador.BLANCO);
//			
//			
//			
//			grafo.simularJugada(5, 3, ColorJugador.NEGRO);
//			
//			grafo.simularJugada(7, 6, ColorJugador.NEGRO);
//			
//			grafo.simularJugada(1, 2, ColorJugador.NEGRO);
//			
//			grafo.simularJugada(6, 6, ColorJugador.NEGRO);
//
//			
//		System.out.println(grafo.obtenerDistanciaBordes(ColorJugador.NEGRO));
//		System.out.println(grafo.obtenerDistanciaBordes(ColorJugador.BLANCO));
//			
//			//System.out.println(grafo.obtenerDistanciaBordes(ColorJugador.NEGRO));
//		
//		long endTime = System.nanoTime();
//		System.out.println("Duración: " + (endTime-startTime)/1e6 + " ms");
//

		System.out.println(" ");
		System.out.println("------------------------------------PRUEBAS SOBRE DISTANCIAS---------------------------------------------");
		System.out.println(" ");
	}

}
