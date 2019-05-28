package co.edu.javeriana.algoritmos.proyecto.codethinkers;

import java.util.Comparator;



public class ComparadorVerticeHex implements Comparator <VerticeHex>{

	@Override
	public int compare(VerticeHex v1, VerticeHex v2) {
		// TODO Auto-generated method stub
		if (v1.getDistancia() < v2.getDistancia()) return -1; 
        if (v1.getDistancia() > v2.getDistancia()) return 1; 
        else return 0;
	}

	

	
}


