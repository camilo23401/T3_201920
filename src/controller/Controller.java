package controller;

import java.util.Scanner;
import java.util.Stack;

import model.data_structures.ArregloDinamico;
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
				ArregloDinamico viajesHora = modelo.consultarViajesHoraDinamico(mesDigitado);
				long startTime = System.currentTimeMillis(); // medición tiempo actual
				viajesHora.shellSort();
				long endTime = System.currentTimeMillis(); // medición tiempo actual
				long duration = endTime - startTime; // duracion de ejecucion del algoritmo
				System.out.println("Se ordenaran los viajes de la hora ingresada en el número 2 con el algoritmo de shell sort");
				System.out.println("El algoritmo se demoro "+duration+" milisegundos en ordenar los datos");
				System.out.println("10 primeros viajes");
				for(int i=0;i<10;i++)
				{
					System.out.println("-------------------------------------------------------------");
					System.out.println(" \n Zona origen: " + viajesHora.darElemento(i).darSourceid()+ "\n Zona destino: " + viajesHora.darElemento(i).darDstid() + "\n Hora: " + viajesHora.darElemento(i).darHora()+ "\n Tiempo Promedio: "+viajesHora.darElemento(i).darTiempoPromedio());
					System.out.println("-------------------------------------------------------------");	
				}
				Stack<UBERTrip>stack=this.pasarAStack(viajesHora);
				System.out.println("10 ultimos viajes");
				for (int i = 0; i <10; i++) {
					System.out.println("-------------------------------------------------------------");
					System.out.println(" \n Zona origen: " + stack.pop().darSourceid()+ "\n Zona destino: " + stack.pop().darDstid() + "\n Hora: " + stack.pop().darHora()+"\n Tiempo Promedio: "+stack.pop().darTiempoPromedio());
					System.out.println("-------------------------------------------------------------");	

				}

				break;

			case 4:
				ArregloDinamico viajesHora1 = modelo.consultarViajesHoraDinamico(mesDigitado);

				long startTime1 = System.currentTimeMillis(); // medición tiempo actual
				viajesHora1.mergeSort(viajesHora1, viajesHora1.darTamano());
				long endTime1 = System.currentTimeMillis(); // medición tiempo actual
				long duration1 = endTime1 - startTime1; // duracion de ejecucion del algoritmo
				System.out.println("Se ordenaran los viajes de la hora ingresada en el número 2 con el algoritmo de merge sort");
				System.out.println("El algoritmo se demoro "+duration1+" milisegundos en ordenar los datos");
				System.out.println("10 primeros viajes");
				for(int i=0;i<10;i++)
				{
					System.out.println("-------------------------------------------------------------");
					System.out.println(" \n Zona origen: " + viajesHora1.darElemento(i).darSourceid()+ "\n Zona destino: " + viajesHora1.darElemento(i).darDstid() + "\n Hora: " + viajesHora1.darElemento(i).darHora()+ "\n Tiempo Promedio: "+viajesHora1.darElemento(i).darTiempoPromedio());
					System.out.println("-------------------------------------------------------------");	
				}
				Stack<UBERTrip>stack1=this.pasarAStack(viajesHora1);
				System.out.println("10 ultimos viajes");
				for (int i = 0; i <10; i++) {
					System.out.println("-------------------------------------------------------------");
					System.out.println(" \n Zona origen: " + stack1.pop().darSourceid()+ "\n Zona destino: " + stack1.pop().darDstid() + "\n Hora: " + stack1.pop().darHora()+"\n Tiempo Promedio: "+stack1.pop().darTiempoPromedio());
					System.out.println("-------------------------------------------------------------");	

				}
				break;

			case 5:
				ArregloDinamico viajesHora2 = modelo.consultarViajesHoraDinamico(mesDigitado);

				long startTime2 = System.currentTimeMillis(); // medición tiempo actual
				viajesHora2.quickSort(viajesHora2, 0, viajesHora2.darTamano()-1);
				long endTime2 = System.currentTimeMillis(); // medición tiempo actual
				long duration2 = endTime2 - startTime2; // duracion de ejecucion del algoritmo
				System.out.println("Se ordenaran los viajes de la hora ingresada en el número 2 con el algoritmo de merge sort");
				System.out.println("El algoritmo se demoro "+duration2+" milisegundos en ordenar los datos");
				System.out.println("10 primeros viajes");
				for(int i=0;i<10;i++)
				{
					System.out.println("-------------------------------------------------------------");
					System.out.println(" \n Zona origen: " + viajesHora2.darElemento(i).darSourceid()+ "\n Zona destino: " + viajesHora2.darElemento(i).darDstid() + "\n Hora: " + viajesHora2.darElemento(i).darHora()+ "\n Tiempo Promedio: "+viajesHora2.darElemento(i).darTiempoPromedio());
					System.out.println("-------------------------------------------------------------");	
				}
				Stack<UBERTrip>stack2=this.pasarAStack(viajesHora2);
				System.out.println("10 ultimos viajes");
				for (int i = 0; i <10; i++) {
					System.out.println("-------------------------------------------------------------");
					System.out.println(" \n Zona origen: " + stack2.pop().darSourceid()+ "\n Zona destino: " + stack2.pop().darDstid() + "\n Hora: " + stack2.pop().darHora()+"\n Tiempo Promedio: "+stack2.pop().darTiempoPromedio());
					System.out.println("-------------------------------------------------------------");	

				}
				break;

			case 6: 
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
	public Stack<UBERTrip>pasarAStack(ArregloDinamico convertir){
		Stack<UBERTrip>lista=new Stack<UBERTrip>();
		for (int i = 0; i < convertir.darTamano(); i++) {
			lista.push(convertir.darElemento(i));
		}
		return lista;
	}
}
