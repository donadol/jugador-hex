package co.edu.javeriana.algoritmos.proyecto.codethinkers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import co.edu.javeriana.algoritmos.proyecto.ColorJugador;

public class GrafoTableroTest {
	 
	@Rule
	public ErrorCollector colector = new ErrorCollector();
	@Test
	public void testObtenerDistanciaBordes() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerVecinos() {
		
		GrafoTablero grafoAux = new GrafoTablero();
		VerticeHex verticeARevisar = new VerticeHex();
		verticeARevisar.setFila(0);
		verticeARevisar.setColumna(0);
		verticeARevisar.setColor(ColorJugador.BLANCO);
		
		VerticeHex verticeAux1 = new VerticeHex();
		verticeAux1.setFila(0);
		verticeAux1.setColumna(1);
		verticeAux1.setColor(ColorJugador.BLANCO);
		
		VerticeHex verticeAux2 = new VerticeHex();
		verticeAux2.setFila(1);
		verticeAux2.setColumna(0);
		verticeAux2.setColor(ColorJugador.BLANCO);
		
		VerticeHex verticeAux3 = new VerticeHex();
		verticeAux3.setFila(1);
		verticeAux3.setColumna(1);
		verticeAux3.setColor(ColorJugador.BLANCO);
		
		
		grafoAux.simularJugada(0, 0, ColorJugador.BLANCO);
		grafoAux.simularJugada(0, 1, ColorJugador.BLANCO);
		grafoAux.simularJugada(1, 0, ColorJugador.BLANCO);
		grafoAux.simularJugada(1, 1, ColorJugador.BLANCO);
		
		List<VerticeHex> listaAux = new ArrayList<VerticeHex>();
		List<VerticeHex> listaResultadosAProbar = grafoAux.obtenerVecinos(verticeARevisar, ColorJugador.BLANCO);
		
		listaAux.add(verticeAux1);
		listaAux.add(verticeAux2);
		listaAux.add(verticeAux3);
		
		colector.checkThat(listaAux.size(), CoreMatchers.equalTo(listaResultadosAProbar.size()));
		for(int i = 0; i < listaAux.size(); i++) {
			//colector.checkThat(listaAux.get(i).getColor(), CoreMatchers.equalTo(listaResultadosAProbar.get(i).getColor()));
			//colector.checkThat( listaAux.get(i).getFila(), CoreMatchers.equalTo(listaResultadosAProbar.get(i).getFila()));
			colector.checkThat( listaAux.get(i).getColumna(),CoreMatchers.equalTo(listaResultadosAProbar.get(i).getColumna()));
		}
		
	}
	
	@Test
	public void testObtenerVecinos2() {
		
		GrafoTablero grafoAux = new GrafoTablero();
		VerticeHex verticeAux = new VerticeHex();
		List<VerticeHex> listaResultados = grafoAux.obtenerVecinos(verticeAux, ColorJugador.BLANCO);
		assertEquals(listaResultados, 3);
		fail("Not yet implemented");
	}
	
	@Test
	public void testObtenerVecinos3() {
		
		GrafoTablero grafoAux = new GrafoTablero();
		VerticeHex verticeAux = new VerticeHex();
		List<VerticeHex> listaResultados = grafoAux.obtenerVecinos(verticeAux, ColorJugador.BLANCO);
		assertEquals(listaResultados, 3);
		fail("Not yet implemented");
	}

}
