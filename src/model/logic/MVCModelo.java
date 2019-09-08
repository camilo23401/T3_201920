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
					primerViaje = new UBERTrip(Integer.parseInt(siguiente[0]),Integer.parseInt(siguiente[1]), Short.parseShort(siguiente[2]), Double.parseDouble(siguiente[3]), Short.parseShort("-1"), Short.parseShort("-1"), Double.parseDouble(siguiente[4]), Double.parseDouble(siguiente[5]), Double.parseDouble(siguiente[6]));
					datosTaller.agregarElemento(primerViaje);
				}
				else
				{
					viaje = new UBERTrip(Integer.parseInt(siguiente[0]),Integer.parseInt(siguiente[1]), Short.parseShort(siguiente[2]), Double.parseDouble(siguiente[3]), Short.parseShort("-1"), Short.parseShort("-1"), Double.parseDouble(siguiente[4]), Double.parseDouble(siguiente[5]), Double.parseDouble(siguiente[6]));;
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
	public void ordenarViajesShellSort(ListaEncadenada<UBERTrip> pListaPorOrdenar)
	{
		
	}
	public NodoListaEncadenada<UBERTrip> ordenarViajesMergeSort(NodoListaEncadenada<UBERTrip> pNodo)
	{
		if(pNodo==null||pNodo.darSiguiente()==null)
		{
			return pNodo;
		}
		else
		{
			NodoListaEncadenada<UBERTrip> mitad = sacarMitad(pNodo);
			NodoListaEncadenada<UBERTrip> mitadMasUno = mitad.darSiguiente();
			
			mitad.cambiarSiguiente(null);
			
			NodoListaEncadenada<UBERTrip> ladoIzquierdo = ordenarViajesMergeSort(pNodo);
			NodoListaEncadenada<UBERTrip> ladoDerecho = ordenarViajesMergeSort(mitadMasUno);
			
			NodoListaEncadenada<UBERTrip> listaOrdenada = organizarDatos(ladoIzquierdo, ladoDerecho);
			return listaOrdenada;
		}
	}
	
	public NodoListaEncadenada<UBERTrip> sacarMitad(NodoListaEncadenada<UBERTrip> pNodo)
	{
		if (pNodo == null)
		{
			return pNodo;
		}
		else
		{
			NodoListaEncadenada<UBERTrip> adelante = pNodo.darSiguiente();
			NodoListaEncadenada<UBERTrip> detras = pNodo;
			while(adelante!=null)
			{
				adelante = adelante.darSiguiente();
				if(adelante!=null)
				{
					detras = detras.darSiguiente();
					adelante = adelante.darSiguiente();
				}
			}
			return detras;
		}
	}
	public NodoListaEncadenada<UBERTrip> organizarDatos(NodoListaEncadenada<UBERTrip> x, NodoListaEncadenada<UBERTrip> y)
	{
		NodoListaEncadenada<UBERTrip> rta = null;
		if(x==null)
		{
			return y;
		}
		else if(y==null)
		{
			return x;
		}
		System.out.println(x);
		System.out.println(y);
		if(x.darElemento().compareTo(y.darElemento())==-1 || x.darElemento().compareTo(y.darElemento())==0)
		{
			rta = x;
			NodoListaEncadenada<UBERTrip> nuevoSiguienteRecursion = organizarDatos(x.darSiguiente(), y);
			rta.cambiarSiguiente(nuevoSiguienteRecursion);
		}
		else
		{
			rta = y;
			NodoListaEncadenada<UBERTrip> nuevoSiguienteRecursion = organizarDatos(x, y.darSiguiente());
			rta.cambiarSiguiente(nuevoSiguienteRecursion);
		}
		return rta;
	}


}
