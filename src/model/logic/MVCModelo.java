package model.logic;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.data_structures.*;
/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico datos;
	private ListaEncadenada<UBERTrip> datosTaller;
	private CSVReader lector;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		datos = new ArregloDinamico(7);
		datosTaller = new ListaEncadenada<UBERTrip>();

	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public MVCModelo(int capacidad)
	{
		datos = new ArregloDinamico(capacidad);
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(String dato)
	{	
		datos.agregar(dato);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public String buscar(String dato)
	{
		return datos.buscar(dato);
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public String eliminar(String dato)
	{
		return datos.eliminar(dato);
	}


	public ListaEncadenada<UBERTrip> consultarPorHora(ListaEncadenada<UBERTrip> inicial){
		ListaEncadenada<UBERTrip>nueva=new ListaEncadenada<UBERTrip>();
		NodoListaEncadenada<UBERTrip>actual=inicial.darNodoActual();
		return null;

	}
	public String[] cargarDatos() throws IOException
	{
		UBERTrip primerViaje = null;
		UBERTrip viaje = null;
		String[] respuesta = new String[3];
		int contador = 0;
		String rutaSemanal = "data/bogota-cadastral-2018-2-All-HourlyAggregate.csv";
		lector = new CSVReader(new FileReader(rutaSemanal));
		String [] siguiente;
		while ((siguiente = lector.readNext()) != null) 
		{
			if(contador!=0)
			{
				if(contador == 1)
				{
					primerViaje = new UBERTrip(Integer.parseInt(siguiente[0]),Integer.parseInt(siguiente[1]), Integer.parseInt(siguiente[2]), Double.parseDouble(siguiente[3]), Integer.parseInt("-1"), Integer.parseInt("-1"), Double.parseDouble(siguiente[4]), Double.parseDouble(siguiente[5]), Double.parseDouble(siguiente[6]));
					datosTaller.agregarElemento(primerViaje);
				}
				else
				{
					viaje = new UBERTrip(Integer.parseInt(siguiente[0]),Integer.parseInt(siguiente[1]), Integer.parseInt(siguiente[2]), Double.parseDouble(siguiente[3]), Integer.parseInt("-1"), Integer.parseInt("-1"), Double.parseDouble(siguiente[4]), Double.parseDouble(siguiente[5]), Double.parseDouble(siguiente[6]));;
					datosTaller.agregarElemento(viaje);
				}
			}
			contador++;
		}
		String totalViajes = "El número total de viajes fue de: " + contador;
		String infoPrimero = "Primer viaje \n Zona origen: " + primerViaje.darSourceid() + "\n Zona destino: " + primerViaje.darDstid() + "\n Hora: " + primerViaje.darHora() + "\n Tiempo promedio: " + primerViaje.darTiempoPromedio();
		String infoUltimo = "Ultimo viaje \n Zona origen: " + datosTaller.darUltimoAgregado().darElemento().darSourceid() + "\n Zona destino: " + datosTaller.darUltimoAgregado().darElemento().darDstid() + "\n Hora: " + datosTaller.darUltimoAgregado().darElemento().darHora() + "\n Tiempo promedio: " + datosTaller.darUltimoAgregado().darElemento().darTiempoPromedio();

		respuesta[0] = totalViajes;
		respuesta[1] = infoPrimero;
		respuesta[2] = infoUltimo;
		return respuesta;
	}
	public ListaEncadenada<UBERTrip> consultarViajesHora(String pHora)
	{
		int hora = Integer.parseInt(pHora);
		ListaEncadenada<UBERTrip> rta = new ListaEncadenada<UBERTrip>();
		NodoListaEncadenada<UBERTrip> actual = datosTaller.darNodoActual();
		while(actual!=null)
		{
			UBERTrip viajeUber = actual.darElemento();
			if(hora == viajeUber.darHora())
			{
				rta.agregarElemento(viajeUber);
			}
			actual = actual.darSiguiente();
		}
		return rta;
	}
	public void ShellSort(ListaEncadenada<UBERTrip>lista) {
	    int n = lista.darTamano();
	    for (int gap = n / 2; gap > 0; gap /= 2) {
	        for (int i = gap; i < n; i++) {
	            UBERTrip key = lista.darElemento(i);
	            int j = i;
	            while (j >= gap && lista.darElemento(j-gap).compareTo(key)>0) {
	            	lista.set(j, lista.darElemento(j-gap));
	                j -= gap;
	            }
	            
	            lista.set(j, key);
	            	
	        }
	    }
	}
	public void swap(int i, int j) {

	}
	public NodoListaEncadenada<UBERTrip>mergeSort(NodoListaEncadenada<UBERTrip> a) {
		NodoListaEncadenada<UBERTrip> cabezaVieja = a;
		int mid = this.darTamanio(a) / 2;
		if (a.darSiguiente()== null)
			return a;

		while (mid - 1 > 0) {
			cabezaVieja = cabezaVieja.darSiguiente();
			mid--;
		}
		NodoListaEncadenada<UBERTrip> nuevaCabeza = cabezaVieja.darSiguiente();
		cabezaVieja.cambiarSiguiente(null); 
		cabezaVieja = a;
		NodoListaEncadenada<UBERTrip> t1 = mergeSort(nuevaCabeza);
		NodoListaEncadenada<UBERTrip> t2 = mergeSort(cabezaVieja);
		return MergeList(t1, t2); 
	}

	public NodoListaEncadenada<UBERTrip> MergeList(NodoListaEncadenada<UBERTrip> a, NodoListaEncadenada<UBERTrip> b) {
		NodoListaEncadenada<UBERTrip> result = null;
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (a.darElemento().compareTo(b.darElemento())>0) {
			result = b;
			result.cambiarSiguiente( MergeList(a, b.darSiguiente()));
		} else {
			result = a;
			result.cambiarSiguiente(MergeList(a.darSiguiente(), b));
		}
		return result;
	}
	public int darTamanio(NodoListaEncadenada<UBERTrip> a) {
		int count = 0;
		NodoListaEncadenada<UBERTrip> h = a;
		while (h != null) {
			count++;
			h = h.darSiguiente();
		}
		return count;
	}




}
