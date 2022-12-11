package Liga_Real;

import java.util.ArrayList;
import java.util.List;

// Atributos, getters, cuidado con reporte partido
public class Partidos {

	public int Goles_visitante; 
	public int Goles_loca;
	public Equipo visitante; 
	public Equipo local; 
	public Equipo ganador; 
	public List<Reporte_Partido> info ; // Revisar Reporte Partido tener lo muy en cuenta, hay algo raro... 
    public String fecha; 
	
    
    //Constructor 
	
	// Getters 
	public int getGoles_visitante() {
		return Goles_visitante;
	}

	public Partidos(int goles_visitante, int goles_local, 
			Equipo visitante,Equipo local,String fecha)
	{
		Goles_visitante = goles_visitante;
		Goles_loca = goles_local;
		this.visitante = visitante;
		this.ganador = (goles_visitante==goles_local)?null:(goles_visitante>goles_local)?visitante:local;
		this.local = local;
		this.info = new ArrayList<Reporte_Partido>();
		this.fecha = fecha;
	}

	public int getGoles_loca() {
		return Goles_loca;
	}

	public Equipo getGanador() {
		return ganador;
	}

	public Equipo getVisitante() {
		return visitante;
	}

	public Equipo getLocal() {
		return local;
	}

	public List<Reporte_Partido> getInfo() {
		return info;
	}
	
	@Override
	public String toString() 
	{
		return "Fecha: "+this.fecha+ "\tVistante: "+this.visitante.Nombre+"\tLocal: "+this.local.Nombre; 
	}

}
