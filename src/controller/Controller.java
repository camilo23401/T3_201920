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
					
				case 2:
					System.out.println("Digite la hora de los viajes a buscar");
					mesDigitado = lector.next();
					System.out.println("-------------------------------------------------------------");
					ListaEncadenada<UBERTrip> rta = modelo.consultarViajesHora(mesDigitado);
					System.out.println("El total de viajes a esa hora fueron: "+rta.darTamano());
					System.out.println("-------------------------------------------------------------");
					break;
					
				case 3:
					ListaEncadenada<UBERTrip> viajesHora = modelo.consultarViajesHora(mesDigitado);
					modelo.ShellSort(viajesHora);
					System.out.println("Se ordenaran los viajes de la hora ingresada en el número 2 con el algoritmo de shell sort");
					System.out.println(viajesHora.darTamano());
					break;
					
				case 10:
					break;
					
				case 11:
					break;
					
				case 7: 
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
