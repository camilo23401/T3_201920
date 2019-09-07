package model.logic;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.data_structures.*;
import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.ListaEncadenada;

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
		
	}
	public String[] cargarDatos() throws IOException
	{
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
					UBERTrip primerViaje = null;
					datosTaller.agregarElemento(primerViaje);
				}
				else
				{
					UBERTrip viaje = null;
					datosTaller.agregarElemento(viaje);
				}
			}
			contador++;
		}
		String totalViajes = "El número total de viajes fue de: " + contador;
		String infoPrimero = "Primer viaje \n Zona origen: " + primerViaje.darSourceid() + "\n Zona destino: " + primerViaje.darDstid() + "\n Hora: " + primerViaje.darHora() + "\n Tiempo promedio: " + primerViaje.darTiempoPromedio();
		String infoUltimo = "Ultimo viaje \n Zona origen: " + datosTaller.darUltimoAgregado().darElemento().darSourceid() + "\n Zona destino: " + datosTaller.darUltimoAgregado().darElemento().darDstid() + "\n Hora: " + datosTaller.darUltimoAgregado().darHora() + "\n Tiempo promedio: " + datosTaller.darUltimoAgregado().darTiempoPromedio();
		
		respuesta[0] = totalViajes;
		respuesta[1] = infoPrimero;
		respuesta[2] = infoUltimo;
		return respuesta;
	}


}
