package controller;

import java.util.Scanner;

import model.data_structures.ListaEncadenada;
import model.logic.MVCModelo;
import model.logic.UBERTrip;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo*/
	private MVCModelo modelo;
	
	/* Instancia de la Vista*/
	private MVCView view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new MVCView();
		modelo = new MVCModelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";
		String mesDigitado = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					System.out.println("--------- \nCrear Arreglo \nDar capacidad inicial del arreglo: ");
				    int capacidad = lector.nextInt();
				    modelo = new MVCModelo(capacidad); 
					System.out.println("Arreglo Dinamico creado");
					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 2:
					System.out.println("--------- \nDar cadena (simple) a ingresar: ");
					dato = lector.next();
					modelo.agregar(dato);
					System.out.println("Dato agregado");
					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 3:
					System.out.println("--------- \nDar cadena (simple) a buscar: ");
					dato = lector.next();
					respuesta = modelo.buscar(dato);
					if ( respuesta != null)
					{
						System.out.println("Dato encontrado: "+ respuesta);
					}
					else
					{
						System.out.println("Dato NO encontrado");
					}
					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 4:
					System.out.println("--------- \nDar cadena (simple) a eliminar: ");
					dato = lector.next();
					respuesta = modelo.eliminar(dato);
					if ( respuesta != null)
					{
						System.out.println("Dato eliminado "+ respuesta);
					}
					else
					{
						System.out.println("Dato NO eliminado");							
					}
					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 5: 
					System.out.println("--------- \nContenido del Arreglo: ");
					view.printModelo(modelo);
					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;	
				
				case 6:
					try
					{
						String [] arregloRespuestas = modelo.cargarDatos();
						for(int i=0;i<arregloRespuestas.length;i++)
						{
							System.out.println("-------------------------------------------------------------");
							System.out.println(arregloRespuestas[i]);
							System.out.println("-------------------------------------------------------------");	
						}	
					}
					catch(Exception e)
					{
						System.out.println("Se presentó un error leyendo el archivo");
					}
					break;
					
				case 7:
					System.out.println("Digite la hora de los viajes a buscar");
					mesDigitado = lector.next();
					System.out.println("-------------------------------------------------------------");
					ListaEncadenada<UBERTrip> rta = modelo.consultarViajesHora(mesDigitado);
					System.out.println(rta.darTamano());
					System.out.println("-------------------------------------------------------------");
					break;
				
				case 8:
					
					break;
					
				case 9:
					System.out.println("Se ordenaran los datos del mes ingresado en el número 7 con el algoritmo de merge sort");
					ListaEncadenada<UBERTrip> viajesHora = modelo.consultarViajesHora(mesDigitado);
					modelo.ordenarViajesMergeSort(viajesHora.darNodoActual());
					System.out.println("Se ordenaron los datos");
					break;
					
				case 10:
					break;
					
				case 11:
					break;
					
				case 12: 
					System.out.println("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	

				default: 
					System.out.println("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
