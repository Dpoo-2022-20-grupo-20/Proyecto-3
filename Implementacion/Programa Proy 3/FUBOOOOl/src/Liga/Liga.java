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
	public static TreeMap<Integer, List<Dream_Team>> Posiciones = new TreeMap<Integer,List<Dream_Team>>();
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
	
	
	public static Jugador Cplay1;
	public static Jugador Cplay2;
	public static Jugador Cplay3;
	
	public static Jugador Vplay1;
	public static Jugador Vplay2;
	public static Jugador Vplay3;
	
	public static Map<String,Integer> venta = new HashMap<String,Integer>();
	public static Map<String,Integer> compra= new HashMap<String,Integer>();
	
	
	
	public static void set_up() {
		String[] pos= {"Delantero","Medio_Campista","Defensor","Arquero"};
		for(String posi:pos) {
			venta.put(posi, 0);
			compra.put(posi, 0);
		}
		
	}
	
	
	public static void venta(Jugador player) {
		Vplay3=Vplay2;
     	Vplay2=Vplay1;
		Vplay1=player;
		
		String posi=player.getPosicion();
		add_venta(posi);
	}
	
	
	public static void compra(Jugador player) {
		Cplay3=Cplay2;
     	Cplay2=Cplay1;
		Cplay1=player;
		
		String posi=player.getPosicion();
		add_compra(posi);
	}
	
	public static void add_compra(String posi) {
		int ar=compra.get(posi);
		ar++;
		compra.put(posi, ar);
	}
	
	public static void add_venta(String posi) {
		int ar=compra.get(posi);
		ar++;
		compra.put(posi, ar);
	}
	
	
	public static List<String> vent_rect(){
		List<String> ret = new ArrayList<String>();
		ret.add((Vplay1!=null)?Vplay1.getNombre():"None");
		ret.add((Vplay2!=null)?Vplay2.getNombre():"None");
		ret.add((Vplay3!=null)?Vplay3.getNombre():"None");		
		return ret; 
	}
	
	public static List<String> comp_rect(){
		List<String> ret = new ArrayList<String>();
		ret.add((Cplay1!=null)?Cplay1.getNombre():"None");
		ret.add((Cplay2!=null)?Cplay2.getNombre():"None");
		ret.add((Cplay3!=null)?Cplay3.getNombre():"None");		
		return ret; 
	}

	public static Map<String,Integer> get_ventas(){
		return venta;
	}
	
	public static Map<String,Integer> get_compra(){
		return compra;
	}
	
	public static Map<String,Integer> tea_info(){
		Map<String, Integer> ret = new HashMap<String,Integer>();
		for(Dream_Team equipo:equipos ) {
			ret.put(equipo.getId(), equipo.getPuntaje_act());
		}
		return ret;
	}
	
	public static Map<String,Integer> play_info(){
		Map<String, Integer> ret = new HashMap<String,Integer>();
		for(Jugador jugador: jugadores_sin.values()) {
			ret.put(jugador.getNombre(), jugador.getPuntaje());
		}
		return ret;
	}
	
	public static Map<String,Integer> team_players() {
		Dream_Team equip= Posiciones.lastEntry().getValue().get(0);
		Map<String, Integer> ret = new HashMap<String,Integer>();
		
		for(Jugador play : equip.get_team() ) {
			ret.put(play.getNombre(), play.getPuntaje());
		}
		return ret;
	}
	
	
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
	
	public static void adReales(String nombre1, Equipo eq) {
		reales.put(nombre1, eq);
	}
	
	
	public static Jugador get_jug(String nombre) {
		return jugadores_sin.get(nombre);		
	} 
	
	public static Equipo get_real(String nombre)throws Error {
		try {
			return reales.get(nombre);
		}
		catch (Error e){
			Error err= new Error("No existe el equipo");
			throw err;
		}
		
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
		int cont=0;
		List<Dream_Team> best= new ArrayList<Dream_Team>();
		int punt=0;
		for (Dream_Team equipo : equipos) 
		{
			punt=equipo.calc_puntaje();
			if(punt>cont) {
				best.clear();
				best.add(equipo);
			}else if (punt == cont) {
				best.add(equipo);
			}
			
			System.out.println(equipo.getId());
			List<Dream_Team> list=Posiciones.get(equipo.getPuntaje_act());
			if (list== null) {list= new ArrayList<Dream_Team>();}
			list.add(equipo);
			Posiciones.put(equipo.puntaje_act, list);
		}
		
		for(Dream_Team equipos: best) {
			equipos.add_punt(10);
		}
		
	}


	public static void add_comp(String[] jug) {
		Cplay1=(jug[0].equals("None"))?null:Liga.get_jug(jug[0]);
		Cplay2=(jug[1].equals("None"))?null:Liga.get_jug(jug[1]);
		Cplay3=(jug[2].equals("None"))?null:Liga.get_jug(jug[2]);
	} 
	
	public static void add_vend(String[] jug) {
		Vplay1=(jug[0].equals("None"))?null:Liga.get_jug(jug[0]);
		Vplay2=(jug[1].equals("None"))?null:Liga.get_jug(jug[1]);
		Vplay3=(jug[2].equals("None"))?null:Liga.get_jug(jug[2]);
	} 

}
