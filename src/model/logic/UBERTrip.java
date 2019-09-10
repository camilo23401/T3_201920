package model.logic;



public class UBERTrip implements Comparable<UBERTrip>{
	private int sourceid;
	private int dstid;
	private int mes;
	private int dia;
	private int hora;
	private double tiempoPromedio;
	private double desviacionEstandarTiempo;
	private double tiempoPromedioGeometrico;
	private double desviacionEstandarTiempoGeometrico;


	public UBERTrip(int pSourceid, int pDstid, int pHora, double pTiempoPromedio, int pMes, int pDia, double pDesviacionEstandarTiempo, double pTiempoPromedioGeometrico, double pDesviacionEstandarTiempoGeometrico)
	{
		sourceid = pSourceid;
		dstid = pDstid;
		mes = pMes;
		dia = pDia;
		hora = pHora;
		tiempoPromedio = pTiempoPromedio;
		desviacionEstandarTiempo = pDesviacionEstandarTiempo;
		tiempoPromedioGeometrico = pTiempoPromedioGeometrico;
		desviacionEstandarTiempoGeometrico = pDesviacionEstandarTiempoGeometrico;
	}
	public void cambiarInfo(UBERTrip nuevo)
	{
		sourceid = nuevo.darSourceid();
		dstid = nuevo.darDstid();
		mes = nuevo.darMes();
		dia = nuevo.darDia();
		hora = nuevo.darHora();
		tiempoPromedio = nuevo.darTiempoPromedio();
		desviacionEstandarTiempo = nuevo.darDesviacionEstandarTiempo();
		tiempoPromedioGeometrico = nuevo.darTiempoPromedioGeometrico();
		desviacionEstandarTiempoGeometrico = nuevo.darDesviacionEstandarTiempoGeometrico();
	}
	public int darSourceid()
	{
		return sourceid;
	}
	public int darDstid()
	{
		return dstid;
	}
	public int darMes()
	{
		return mes;	
	}
	public int darDia()
	{
		return dia;
	}
	public int darHora()
	{
		return hora;
	}
	public double darTiempoPromedio()
	{
		return tiempoPromedio;
	}
	public double darDesviacionEstandarTiempo()
	{
		return desviacionEstandarTiempo;
	}
	public double darTiempoPromedioGeometrico()
	{
		return tiempoPromedioGeometrico;
	}
	public double darDesviacionEstandarTiempoGeometrico()
	{
		return desviacionEstandarTiempoGeometrico;
	}
	@Override
	public int compareTo(UBERTrip comp) {
		double comparacion = this.darTiempoPromedio()-comp.darTiempoPromedio();
		int compa=0;
		if(comparacion > 0){
			compa=1;
		}
		else if(comparacion < 0){
			compa=-1;
		}
		else{
			double comparacion2=this.darDesviacionEstandarTiempo()-comp.darDesviacionEstandarTiempo();
			if(comparacion2 > 0){
				compa=1;
			}
			else if(comparacion2 < 0){
				compa=-1;
			}
		}
		return compa;	
	}


}
