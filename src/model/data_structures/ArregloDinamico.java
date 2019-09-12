package model.data_structures;

import model.logic.UBERTrip;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico implements IArregloDinamico {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private UBERTrip[] elementos;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = new UBERTrip[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void agregar( UBERTrip dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			UBERTrip [ ] copia = elementos;
			elementos = new UBERTrip[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	public void shellSort() 
	{ 
		int n = tamanoAct; 

		for (int intervalo = n/2; intervalo > 0; intervalo /= 2) 
		{ 
			for (int i = intervalo; i < n; i += 1) 
			{ 

				UBERTrip temp = elementos[i]; 
				int j; 
				for (j = i; j >= intervalo &&this.darElemento(j-intervalo).compareTo(temp)>0; j -= intervalo) {
					elementos[j] = elementos[j - intervalo]; 
				}

				elementos[j] = temp; 
			} 
		} 

	}
	public void mergeSort(ArregloDinamico a, int n) {
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		ArregloDinamico l = new ArregloDinamico(mid);
		ArregloDinamico r = new ArregloDinamico(n - mid);

		for (int i = 0; i < mid; i++) {
			l.agregar(a.darElemento(i));
		}
		for (int i = mid; i < n; i++) {
			r.agregar(a.darElemento(i));
		}
		mergeSort(l, mid);
		mergeSort(r, n - mid);

		merge(a, l, r, mid, n - mid);
	}
	public static void merge(ArregloDinamico a, ArregloDinamico l, ArregloDinamico r, int izquierda, int derecha) {

		int i = 0, j = 0, k = 0;
		while (i < izquierda && j < derecha) {
			if (l.darElemento(i).compareTo(r.darElemento(j))<=0) {
				a.darElementos()[k++] = l.darElementos()[i++];
			}
			else {
				a.darElementos()[k++] = r.darElementos()[j++];
			}
		}
		while (i < izquierda) {
			a.darElementos()[k++] = l.darElementos()[i++];
		}
		while (j < derecha) {
			a.darElementos()[k++] = r.darElementos()[j++];
		}
	}

	public void quickSort(ArregloDinamico arr, int incio, int finalArreglo) {
		if (incio < finalArreglo) {
			int partitionIndex = partition(arr, incio, finalArreglo);

			quickSort(arr, incio, partitionIndex-1);
			quickSort(arr, partitionIndex+1, finalArreglo);
		}
	}
	private int partition(ArregloDinamico arr, int inicio, int finalArreglo) {
		UBERTrip pivot = arr.darElemento(finalArreglo);
		int i = (inicio-1);
		for (int j = inicio; j < finalArreglo; j++) {
			if (arr.darElemento(j).compareTo(pivot)<=0) {
				i++;
				UBERTrip swapTemp = arr.darElemento(i);
				arr.darElementos()[i] = arr.darElementos()[j];
				arr.darElementos()[j] = swapTemp;
			}
		}

		UBERTrip swapTemp = arr.darElemento(i+1);
		arr.darElementos()[i+1] = arr.darElementos()[finalArreglo];
		arr.darElementos()[finalArreglo] = swapTemp;

		return i+1;
	}
	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public UBERTrip darElemento(int i) {

		return elementos[i];
	}

	public UBERTrip buscar(UBERTrip dato) {
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		UBERTrip rta = null;
		int comparacion = 0;
		for(int i=0;i<elementos.length&&comparacion==0;i++)
		{
			comparacion = elementos[i].compareTo(dato);
			if(comparacion==1)
			{
				rta = elementos[i];
			}
		}
		return rta;
	}



	@Override
	public UBERTrip eliminar(String dato) {
		// TODO Auto-generated method stub
		return null;
	}
	public UBERTrip[]darElementos(){
		return elementos;
	}


}
