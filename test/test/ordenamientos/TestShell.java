package test.ordenamientos;

import model.data_structures.ArregloDinamico;
import model.data_structures.ListaEncadenada;
import model.data_structures.NodoListaEncadenada;
import model.logic.MVCModelo;
import model.logic.UBERTrip;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestShell {

	private ListaEncadenada<UBERTrip> lista;
	private MVCModelo modelo;
	
	@Before
	public void setUp1() {
		lista=new ListaEncadenada<UBERTrip>();
		modelo=new MVCModelo();
		lista.agregarElemento(new UBERTrip(0, 0, 0, 4,0 , 0, 0, 0, 0));
		lista.agregarElemento(new UBERTrip(0, 0, 0, 7,0 , 0, 0, 0, 0));
		lista.agregarElemento(new UBERTrip(0, 0, 0, 3,0 , 0, 0, 0, 0));
		lista.agregarElemento(new UBERTrip(0, 0, 0, 8,0 , 0, 0, 0, 0));
		lista.agregarElemento(new UBERTrip(0, 0, 0, 6,0 , 0, 0, 0, 0));
		lista.agregarElemento(new UBERTrip(0, 0, 0, 5,0 , 0, 0, 0, 0));
		lista.agregarElemento(new UBERTrip(0, 0, 0, 6,0 , 0, 0, 0, 0));
		lista.agregarElemento(new UBERTrip(0, 0, 0, 12,0 , 0, 0, 0, 0));
		lista.agregarElemento(new UBERTrip(0, 0, 0, 9,0 , 0, 0, 0, 0));
		
		
	}
	
	@Test
	public void testMerge() {
		modelo.ShellSort(lista);
		NodoListaEncadenada<UBERTrip>actual=lista.darNodoActual();
		while(actual!=null) {
			System.out.println(actual.darElemento().darTiempoPromedio());
			actual=actual.darSiguiente();
		}
	}
	
	

}
