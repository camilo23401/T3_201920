package data_structures;

public class NodoListaEncadenada<E> {

	protected E elemento;


	protected NodoListaEncadenada<E>siguiente;

	public NodoListaEncadenada(E elemento)
	{
		this.elemento=elemento;

	}

	/**
	 * M�todo que cambia el siguiente nodo.
	 * <b>post: </b> Se ha cambiado el siguiente nodo
	 * @param siguiente El nuevo siguiente nodo
	 */
	public void cambiarSiguiente(NodoListaEncadenada<E> siguiente)
	{
		this.siguiente=siguiente;

	}

	/**
	 * M�todo que retorna el elemento almacenado en el nodo.
	 * @return El elemento almacenado en el nodo.
	 */
	public E darElemento()
	{
		return elemento;
	}

	/**
	 * Cambia el elemento almacenado en el nodo.
	 * @param elemento El nuevo elemento que se almacenar� en el nodo.
	 */
	public void cambiarElemento(E elemento)
	{
		this.elemento = elemento;
	}


	/**
	 * M�todo que retorna el siguiente nodo.
	 * @return Siguiente nodo
	 */
	public NodoListaEncadenada<E> darSiguiente()
	{
		return siguiente;
	}

}
