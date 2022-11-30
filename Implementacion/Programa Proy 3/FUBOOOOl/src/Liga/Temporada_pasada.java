package Liga;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Jugadores.Jugador;
import Liga_Real.Partidos;


//Creacion atributos y método constructor 

public class Temporada_pasada {

	public String fecha ; 
	public List<Dream_Team> equipos; 
	public List<Partidos>   partiods; 
	public List<String>     datos_curiosos; 
	public List<Dream_Team> Ganador ;
	public Map<String,Map<String,Jugador>> jugadores;
	
	public Temporada_pasada(String fecha, 
							List<Dream_Team> equipos,
							List<Partidos> partiods, 
							List<String> datos_curiosos,
							List<Dream_Team> ganador,Map<String,Map<String,Jugador>>jugadores)
	{
		this.fecha = fecha;
		this.equipos = equipos;
		this.partiods = partiods;
		this.datos_curiosos = datos_curiosos;
		this.Ganador = ganador;
		this.jugadores=jugadores;
	}
	
	
	public void equipos() 
	{
		for(Dream_Team equipo : equipos)
		{
			System.out.println("- "+ equipo.id );
		}
	}
	
	public void partido()
	{
		for(Partidos partido : partiods)
		{
			System.out.println("- "+ partido );
		}
	}
	
	
	public List<Dream_Team> get_winner_s() 
	{
		for (Dream_Team equipo : this.Ganador) 
		{
			System.out.println("- " +equipo.id);
		}
		return this.Ganador;
	}

	
	
	
}
