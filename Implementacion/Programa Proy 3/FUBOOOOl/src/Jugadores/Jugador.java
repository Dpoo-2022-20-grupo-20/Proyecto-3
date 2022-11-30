package Jugadores;
import java.util.ArrayList;
import java.util.List;
import Liga.Dream_Team;
import Liga_Real.Equipo;
import Liga_Real.Penalties;
import Liga_Real.Reporte_Partido;


// Implementación atributos y geters y setter, cambio a clase abstracta 
public abstract class Jugador  {
	
	public List<Penalties> getPenalties() {
		return penalties;
	}
	public List<Reporte_Partido> getReportes_previos() {
		return reportes_previos;
	}
	public Reporte_Partido getReporte() {
		return reporte;
	}
	public boolean isEnough() {
		return enough;
	}
	public boolean isPlus_60() {
		return plus_60;
	}
	public Equipo getReal() {
		return real;
	}

	public String Nombre;
	public String Posicion; 
	public float precio;
	public int goles; 
	public int puntaje;
	public List<Dream_Team> Dream_teams= new ArrayList<Dream_Team>();  
	public List<Penalties> penalties= new ArrayList<Penalties>();
	 
	public List<Reporte_Partido> reportes_previos = new ArrayList<Reporte_Partido>();
	public Reporte_Partido reporte; // nuevo
	public boolean enough; // Dice sí jugó suficente en el partido más reciente 
	public boolean plus_60; // Dice si jugó más de 60 minutos en el último partido
	
	
	public Equipo real; //nuevo
	
	
	
	
	public Jugador(String nombre, String posicion, float precio, Equipo real) {
		
		Nombre = nombre;
		Posicion = posicion;
		this.precio = precio;
		this.real = real;
		this.goles= 0; 
		this.puntaje= 0;
	}
	// Geters Y setters 
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public String getPosicion() 
	{
		return this.Posicion;
	}
	
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public int getGoles() {
		return goles;
	}
	public void setGoles(int goles) {
		this.goles = goles;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	//Consigue la cantidad de equipos a la que pertenece
	public int getDream_teams() 
	{
		return Dream_teams.size();
	}
	
	public void nuevo_reporte(Reporte_Partido report) 
	{
		this.reportes_previos.add(this.reporte);
		this.reporte= report;
		if (Math.abs(this.reporte.min_salida-this.reporte.min_entrada) > 1  || this.reporte.completo) 
		{
			this.enough = true ;
			if (Math.abs(this.reporte.min_salida-this.reporte.min_entrada) > 60) 
			{
				this.plus_60= true;
			}else 
			{
				this.plus_60 = false;
				}
		}
		else
		{
		this.enough= false; 
		this.plus_60= false;
		}
	}
	
	
	public boolean has_team(String name) {
		boolean ret = false; 
		for(Dream_Team Equipo : this.Dream_teams) {
			if (Equipo.getId().equals(name)) {
				ret=true;
			}
		}
		return ret;
	}
	
	
	public void add_penalty(Penalties penalty) 
	{
		this.penalties.add(penalty);
	}
	
	// Añade un equipo a la lsita de equipos del jugador
	
	public void add_team(Dream_Team Equipo) 
	{
		
		this.Dream_teams.add(Equipo);	
		
	}
	
	// Quita un equipo 
	public void quitar_team(String id) 
	{
		int i = 0;
		System.out.println(this.Dream_teams);
		for (Dream_Team team : this.Dream_teams) 
		{
			
			if (team.getId().equals(id)) 
			{
				
				Dream_teams.remove(i);
				
				break;
			}
			i++;
		}
	}

	public int caluclar_puntaje() 
	{
		return 0;
	}

}
