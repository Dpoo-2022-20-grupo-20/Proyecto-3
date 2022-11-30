package Liga;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import Jugadores.Jugador;
import Liga_Real.Equipo;
import Liga_Real.Partidos;




/// Creacion atributos y getter y setters 
public final class Liga {
	
	public static List<Partidos> Historial_partidos   = new ArrayList<Partidos>();  
	public static List<Dream_Team> equipos            = new ArrayList<Dream_Team>();
	public static Map<String, Dream_Team>eq_map       = new HashMap<String,Dream_Team>();
	public static TreeMap<Integer, List<Dream_Team>> Posiciones ;
	public static List<String> Datos_curiosos          = new ArrayList<String>();
	public static List<Temporada_pasada> Temporadas    = new ArrayList<Temporada_pasada>();
	public static Map<String,Map<String,Jugador>> jugadores= 
												  new HashMap<String,Map<String,Jugador>>();
	
	public static Map<String,Jugador> jugadores_sin=  new HashMap<String,Jugador>();
	public static String fecha; 
	public static List<Temporada_pasada> pasadas = new ArrayList<Temporada_pasada>();  
	public static float presupuesto = 1000000; 
	
	public static List<String> fechas = new ArrayList<String>();			 ; 
	
	public static Map<String,Equipo> reales= new HashMap<String,Equipo>();
	// Getters Y Setters, Puede que no usemos todos :P 
	
	public  static List<Partidos> getHistorial_partidos() {
		return Historial_partidos;
	}
		
	public static List<Dream_Team> getEquiposnew() {
		return equipos;
	}
	
	public static Map<String, Jugador> getJugadores_sin() {
		return jugadores_sin;
	}

	public static Map<String, Map<String, Jugador>> getJugadores() {
		return jugadores;
	}
	
		
	public static TreeMap<Integer, List<Dream_Team>> getPosiciones() {
		return Posiciones;
	}
	
	public List<String> getDatos_curiosos() {
		return Datos_curiosos;
	}
	public void setDatos_curiosos(List<String> datos_curiosos) {
		Datos_curiosos = datos_curiosos;
	}
	
	
	public List<Temporada_pasada> getTemporadas() {
		return Temporadas;
	}
	
	
	// Fin geters y setters 
	
	public static void agregar_equipo(Dream_Team equiposs) {
	
		equipos.add(equiposs);
		eq_map.put(equiposs.id,equiposs);
	}

	
		
	public static Map<String,List<Jugador>> 
				  map_jugadores(Map<String,List<Jugador>> map ) 
	
	// Crea un mapa por posicion y después crea una lista vacia para que se guarden los jugadores
		  
	{
		String[] pos = "Delantero,Medio_Campista,Defensor,Arquero".split(",")  ;
		for (String posi :pos ) 
		{
			List<Jugador> lista= new ArrayList<Jugador>();
			map.put(posi, lista);
		}
		return map ; 
	}
	
	
	public static  List<Dream_Team> get_winner() 
	{
		Entry<Integer, List<Dream_Team>> primer = Posiciones.ceilingEntry(0);
		List<Dream_Team> ganador= primer.setValue(equipos);
		return ganador; 
	}
	
	public static List<Dream_Team> getEquipos() {
		return equipos;
	}

	public static void setEquipos(List<Dream_Team> equipos) {
		Liga.equipos = equipos;
	}

	public static Map<String, Dream_Team> getEq_map() {
		return eq_map;
	}

	public static void setEq_map(Map<String, Dream_Team> eq_map) {
		Liga.eq_map = eq_map;
	}

	public static void finalizar_liga() 
	{
	 Temporada_pasada psado= new Temporada_pasada(fecha,
			   new ArrayList<>(equipos),new ArrayList<>(Historial_partidos)
			   ,new ArrayList<>(Datos_curiosos),get_winner(),new HashMap<String,Map<String,Jugador>>(jugadores));
	 pasadas.add(psado);
	 //Falta elminar los datos....
	 System.out.println("En toería deberían borrarse, pero por seguridad no se borrará nada");
	}
		
	
	
	
	/// Sobreescribir las posiciones 
	public static void calc_posi() 
	
	{
	 Posiciones = new TreeMap<Integer,List<Dream_Team>>();
	 for (Dream_Team equipo : equipos) 
	 {
		 List<Dream_Team> teams = Posiciones.get(equipo.puntaje_act);
		 if (teams != null) 
		 {
			 teams= new ArrayList<Dream_Team>();
		 }
		 teams.add(equipo);
		 Posiciones.put(equipo.puntaje_act, teams);		 
	 }		
	}
			 
			 /// Muestra los jugadores disponibles para una posición
	
	public static ArrayList<String> disp_players(String pos,String name)
	{
		
		Map<String,Jugador>players=jugadores.get(pos);
		
		ArrayList<String> retorno= new ArrayList<String>();
		for (Jugador player : players.values()) 
		{
		    if (player.getDream_teams() < 2 && !player.has_team(name) ) 
			{
		    	retorno.add(player.getNombre()+","+String.valueOf(player.getPrecio()));
			}
		}
		return retorno; 
	}	
	
	public static Jugador get_Jugador(String pos, String name) {
		System.out.println(name);
		return jugadores.get(pos).get(name);
	}
	
	
	public static void setJugadores(Map<String, Map<String, Jugador>> jugadores) {
		Liga.jugadores = jugadores;
	}

	public static void setJugadores_sin(Map<String, Jugador> jugadores_sin) {
		Liga.jugadores_sin = jugadores_sin;
	}

	public static void add_partidos(Partidos partido) 
	{
		Historial_partidos.add(partido);
	}
	
	public static void actualizar() 
	{
		Posiciones.clear();		
		for (Dream_Team equipo : equipos) 
		{
			equipo.calc_puntaje();
			
			List<Dream_Team> list=Posiciones.get(equipo);
			if (list== null) {list= new ArrayList<Dream_Team>();}
			list.add(equipo);
			Posiciones.put(equipo.puntaje_act, list);
		}		
	} 
	
}
