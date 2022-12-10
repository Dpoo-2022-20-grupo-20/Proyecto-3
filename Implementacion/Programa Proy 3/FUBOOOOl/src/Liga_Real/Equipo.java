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
	public int ganados;
	public int perdidos;
	public int empatados; 
	
	public Equipo( String nombre) {
		
		this.Jugadores = new ArrayList<Jugador>();
		this.Nombre = nombre;
		this.Partidos_Jugados = 0;
		this.ganados=0;
		this.perdidos=0;
		this.empatados=0;
	} 
	
	public void Add_partido() 
	{
		this.Partidos_Jugados ++ ; 
	}
	
	
	public void Add_empate() 
	{
		this.empatados ++ ; 
	}
	
	
	public void Add_win() 
	{
		this.ganados ++ ; 
	}
	
	public void Add_loss() 
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
