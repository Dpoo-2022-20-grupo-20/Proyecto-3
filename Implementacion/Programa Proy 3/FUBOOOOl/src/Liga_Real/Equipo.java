package Liga_Real;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Jugadores.Jugador;

//Completo, visto antes de la implementación final almenos.
public class Equipo 
{
	public List<Jugador> Jugadores; 
	public Map<String,Jugador> Map_Jugadores = new HashMap<String,Jugador>(); // Nuevooo
    public String Nombre; 
	public int Partidos_Jugados;
	
	public Equipo( String nombre) {
		
		Jugadores = new ArrayList<Jugador>();
		Nombre = nombre;
		Partidos_Jugados = 0;
	} 
	
	public void Add_partido() 
	{
		this.Partidos_Jugados ++ ; 
	}
	
	public void add_Player(Jugador player) 
	{
		String name= player.Nombre;
		Map_Jugadores.put(name, player);
		Jugadores.add(player);
	}
	
	public Jugador get_player(String name) 
	{
		return this.Map_Jugadores.get(name);		
	}

	
	public List<Jugador> getJugadores() {
		return Jugadores;
	}

	public String getNombre() {
		return Nombre;
	}

	public int getPartidos_Jugados() {
		return Partidos_Jugados;
	}
	
}
