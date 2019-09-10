package view;

import model.logic.MVCModelo;

public class MVCView 
{
	    /**
	     * Metodo constructor
	     */
	    public MVCView()
	    {
	    	
	    }
	    
		public void printMenu()
		{

			System.out.println("1. Cargar los datos");
			System.out.println("2. Consultar los viajes de una hora dada");
			System.out.println("3. Ordenar viajes de una hora dada utilizando shell sort");
			System.out.println("4. Ordenar viajes de una hora dada utilizando merge sort");
			System.out.println("5. Ordenar viajes de una hora dada utilizando quick sort");
			System.out.println("6. Comparar duración algoritmos de ordenamiento");
			System.out.println("7. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(MVCModelo modelo)
		{
			// TODO implementar
		}
}
