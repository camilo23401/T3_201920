package test.ordenamientos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.data_structures.ArregloDinamico;
import model.logic.MVCModelo;
import model.logic.UBERTrip;

public class TestQuickSort {
	private ArregloDinamico lista;
	private MVCModelo modelo;
	
	public void setUp1() {
		//datos desordenados
		lista=new ArregloDinamico(20);
		modelo=new MVCModelo();
		lista.agregar(new UBERTrip(0, 0, 0, 4,0 , 0, 0, 0, 0));
		lista.agregar(new UBERTrip(0, 0, 0, 7,0 , 0, 0, 0, 0));
		lista.agregar(new UBERTrip(0, 0, 0, 3,0 , 0, 0, 0, 0));
		lista.agregar(new UBERTrip(0, 0, 0, 8,0 , 0, 0, 0, 0));
		lista.agregar(new UBERTrip(0, 0, 0, 6,0 , 0, 0, 0, 0));
		lista.agregar(new UBERTrip(0, 0, 0, 5,0 , 0, 0, 0, 0));
		lista.agregar(new UBERTrip(0, 0, 0, 6,0 , 0, 0, 0, 0));
		lista.agregar(new UBERTrip(0, 0, 0, 12,0 , 0, 0, 0, 0));
		lista.agregar(new UBERTrip(0, 0, 0, 9,0 , 0, 0, 0, 0));
	}
	public void setUp2() {
		//datos ordenados ascendentemente
		lista=new ArregloDinamico(20);
		modelo=new MVCModelo();
		lista.agregar(new UBERTrip(0, 0, 0, 3,0 , 0, 0, 0, 0));
		lista.agregar(new UBERTrip(0, 0, 0, 4,0 , 0, 0, 0, 0));
		lista.agregar(new UBERTrip(0, 0, 0, 5,0 , 0, 0, 0, 0));
		lista.agregar(new UBERTrip(0, 0, 0, 6,0 , 0, 0, 0, 0));
		lista.agregar(new UBERTrip(0, 0, 0, 6,0 , 0, 0, 0, 0));
		lista.agregar(new UBERTrip(0, 0, 0, 7,0 , 0, 0, 0, 0));
		lista.agregar(new UBERTrip(0, 0, 0, 8,0 , 0, 0, 0, 0));
		lista.agregar(new UBERTrip(0, 0, 0, 9,0 , 0, 0, 0, 0));
        lista.agregar(new UBERTrip(0, 0, 0, 12,0 , 0, 0, 0, 0));
		
		
		
	}
	public void setUp3() {
		//datos ordenados descendentementes
		lista=new ArregloDinamico(20);
		modelo=new MVCModelo();	
        lista.agregar(new UBERTrip(0, 0, 0, 12,0 , 0, 0, 0, 0));
        lista.agregar(new UBERTrip(0, 0, 0, 9,0 , 0, 0, 0, 0));
        lista.agregar(new UBERTrip(0, 0, 0, 8,0 , 0, 0, 0, 0));
        lista.agregar(new UBERTrip(0, 0, 0, 7,0 , 0, 0, 0, 0));
        lista.agregar(new UBERTrip(0, 0, 0, 6,0 , 0, 0, 0, 0));
        lista.agregar(new UBERTrip(0, 0, 0, 6,0 , 0, 0, 0, 0));
        lista.agregar(new UBERTrip(0, 0, 0, 5,0 , 0, 0, 0, 0));
        lista.agregar(new UBERTrip(0, 0, 0, 4,0 , 0, 0, 0, 0));
        lista.agregar(new UBERTrip(0, 0, 0, 3,0 , 0, 0, 0, 0));
	}
	@Test
	public void testQuickSort() {
		setUp1();
		lista.quickSort(lista, 0, lista.darTamano()-1);
		assertEquals(3.0, lista.darElemento(0).darTiempoPromedio(), 0.001);
		assertEquals(4.0, lista.darElemento(1).darTiempoPromedio(), 0.001);
		assertEquals(5.0, lista.darElemento(2).darTiempoPromedio(), 0.001);
		assertEquals(6.0, lista.darElemento(3).darTiempoPromedio(), 0.001);
		assertEquals(6.0, lista.darElemento(4).darTiempoPromedio(), 0.001);
		assertEquals(7.0, lista.darElemento(5).darTiempoPromedio(), 0.001);
		assertEquals(8.0, lista.darElemento(6).darTiempoPromedio(), 0.001);
		assertEquals(9.0, lista.darElemento(7).darTiempoPromedio(), 0.001);
		assertEquals(12.0, lista.darElemento(8).darTiempoPromedio(), 0.001);
	}
	@Test
	public void testQuickSortAscendentemente() {
		setUp2() ;
		lista.quickSort(lista, 0, lista.darTamano()-1);
		assertEquals(3.0, lista.darElemento(0).darTiempoPromedio(), 0.001);
		assertEquals(4.0, lista.darElemento(1).darTiempoPromedio(), 0.001);
		assertEquals(5.0, lista.darElemento(2).darTiempoPromedio(), 0.001);
		assertEquals(6.0, lista.darElemento(3).darTiempoPromedio(), 0.001);
		assertEquals(6.0, lista.darElemento(4).darTiempoPromedio(), 0.001);
		assertEquals(7.0, lista.darElemento(5).darTiempoPromedio(), 0.001);
		assertEquals(8.0, lista.darElemento(6).darTiempoPromedio(), 0.001);
		assertEquals(9.0, lista.darElemento(7).darTiempoPromedio(), 0.001);
		assertEquals(12.0, lista.darElemento(8).darTiempoPromedio(), 0.001);
	}
	@Test
	public void testQucikSortDescendentemente() {
		setUp3() ;
		lista.quickSort(lista, 0, lista.darTamano()-1);
		assertEquals(3.0, lista.darElemento(0).darTiempoPromedio(), 0.001);
		assertEquals(4.0, lista.darElemento(1).darTiempoPromedio(), 0.001);
		assertEquals(5.0, lista.darElemento(2).darTiempoPromedio(), 0.001);
		assertEquals(6.0, lista.darElemento(3).darTiempoPromedio(), 0.001);
		assertEquals(6.0, lista.darElemento(4).darTiempoPromedio(), 0.001);
		assertEquals(7.0, lista.darElemento(5).darTiempoPromedio(), 0.001);
		assertEquals(8.0, lista.darElemento(6).darTiempoPromedio(), 0.001);
		assertEquals(9.0, lista.darElemento(7).darTiempoPromedio(), 0.001);
		assertEquals(12.0, lista.darElemento(8).darTiempoPromedio(), 0.001);
	}
		
}
