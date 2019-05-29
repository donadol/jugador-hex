package co.edu.javeriana.algoritmos.proyecto.codethinkers;

import co.edu.javeriana.algoritmos.proyecto.ColorJugador;

public class VerticeHex {
	
	private ColorJugador color;
	private int distancia;
	private boolean marcado;
	
	private int fila;
	private int columna;

	public VerticeHex() {
		// TODO Auto-generated constructor stub
		color = null;
		distancia = 1000;
		marcado = false;
		
		fila = -11;
		columna = -11;
			
	}
	
	public VerticeHex(ColorJugador color) {
		color = color;
		distancia = 1000;
		marcado = false;
	}

	public ColorJugador getColor() {
		return color;
	}

	public void setColor(ColorJugador color) {
		this.color = color;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public boolean isMarcado() {
		return marcado;
	}

	public void setMarcado(boolean marcado) {
		this.marcado = marcado;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	
	
	
	

}
