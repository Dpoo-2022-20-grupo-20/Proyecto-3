package Usuarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Jugadores.Jugador;
import Liga.Dream_Team;
import Liga.Liga;


//Ojo presupuesto, es del cliente o del equipo? ???? 

public class Cliente extends Usuario
{
	
	public Dream_Team equipo_fantasia = null; 
	public List<Dream_Team> equipos ;
	
	public int puntaje = 0 ;
	private int pos; 
	//public float presupuesto; 
	//public int posicion; //Es del equipo?? 
	
	public Cliente(String name, String Clave) {
		this.Nombre_Acceso=name ;
		this.Clave = Clave;
		this.equipos= new ArrayList<Dream_Team>();
	}
	
	
	
	public void add_dt(Dream_Team equipo) {
		this.equipos.add(equipo);
	}
	
	public float get_presupuesto(){
		return this.equipo_fantasia.getPresupuesto();
	}
	public boolean verifyPassword(String password) {
		System.out.println(Clave);
		System.out.println(password);
		return super.Clave.equals(password);
	}
	
	
	public void show_team() 
	{
		for(String pos:this.equipo_fantasia.getTeam().keySet()) 
		{
			int i=0;
			
			System.out.println("Posición "+pos);
			for(Jugador jug:this.equipo_fantasia.getTeam().get(pos)) 
			{
				System.out.println(i+") "+jug.getNombre() );
			}
		}
	}
	// Getters y Setter, toca adaptarlos bien 
	
	public Dream_Team getEquipos_fantasia() {
		return equipo_fantasia;
	}

	public int getPuntaje() {
		return this.equipo_fantasia.getPuntaje_act();
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	public void setEquipo_fantasia(int pos) {
		this.pos= pos; 
		for(Dream_Team team : this.equipos) {
			System.out.println(team.getId());
		}
		this.equipo_fantasia = this.equipos.get(pos);
		
	}
	
	public void remove_team() {
		
		this.equipo_fantasia= null;
	}
	
	public List<String> get_teams(){
		List<String>ret= new ArrayList<String>();
		for(Dream_Team team: this.equipos) {
			ret.add(team.getId());			
		}
		return ret;
	}
	
	
	public String get_id_team(){
		return this.equipo_fantasia.getId();
	}
	
	public List<String> get_team_players(String pos) {
		return this.equipo_fantasia.get_team_players(pos);
	}
	public boolean empty_pos(String pos) {
		return this.equipo_fantasia.getTeam().get(pos).isEmpty();
	}

	
	public String crearequipo() 
	{
		Dream_Team equipo = new Dream_Team(App.usuarios.get(this.Nombre_Acceso)) ;
		this.equipo_fantasia= equipo; 
		this.equipos.add(equipo);
		Liga.agregar_equipo(equipo);
		return equipo.id;
	}
	
	
	
	
	public void calcular_puntaje() 
	{
			int puntj= this.equipo_fantasia.puntaje_act;
			this.puntaje = puntj;
		
	}
	
	//COnsige la posición deseada 
	
	
	/// Vender jugador 
	public float vender_jugador (String pos,String name) 
	{
		Dream_Team equipo = this.equipo_fantasia;
		Jugador vender= Liga.get_Jugador(pos, name);
		Liga.venta(vender);
		return equipo.vender_jugador(vender);
		//List<Jugador> jugadore = new ArrayList<Jugador>(); 
		//int h = 0;
		//for (Jugador jugador : jugadores) 
		//{
			//System.out.print(h+") "+jugador.Nombre);
			//jugadore.add(h,jugador);
			//h ++; 
				
		//}
		//if (h>0) {
		//String sel = App.input("Su seleción: ");
		//int posi = Integer.parseInt(sel);
		
		
	}
		
	/// Fin vender Jugador 
	public void agregar_capitán(String nom) 
		// Permite al cliente agregar un capitán a su equipo partir de sus jugadores actuales... 
	{
				this.equipo_fantasia.setCapitan(nom);
	}
	
	// Configurar alineación 
	
	public void configuracion_actual() 
	// Muestra la config actual de un equipo
	{
		Dream_Team equipo= this.equipo_fantasia;
		Map<String, List<Jugador>> aalnc =equipo.alneacn_actual;
		for (String pos: aalnc.keySet()) 
		{
			System.out.println("Para "+pos+" están los siguientes jugadores: " );
			for (Jugador jugador: aalnc.get(pos)) 
			{
				System.out.println("\t -"+jugador.Nombre);
			}
		}
	}
	// Permite al ususario cambiar so config actual.. 
	public void change_aln(String pos,String nombre,String nuevo) 
	{
		this.equipo_fantasia.change_aln(pos, nombre, nuevo);
	}
	
	public Map<String,List<String>> nom_alnc(){
			return this.equipo_fantasia.nom_alnc();
	}
	
	public List<String> nom_supl(){
			return this.equipo_fantasia.nom_supl();
	}
	
	public String get_capi() {
		return this.equipo_fantasia.nom_cap();
	}
	
	public void set_capitan(String Nombre) {
		this.equipo_fantasia.setCapitan(Nombre);
	}
	public List<String> nom_tit(){
		
		return this.equipo_fantasia.nom_tit();
	}
	
	
	
	
	
	// Muesta las poisiciones diponibles para nuevos jugadores 
	public Map<String,Integer> pos_disp() 
	{
		Map<String, List<Jugador>> alnc = this.equipo_fantasia.getTeam();
		Map<String,Integer> disp = new HashMap<String,Integer>(); 
		for (String pos:alnc.keySet())
		{
			int num;
			if (pos.equals("Arquero")){num=2;}
			else if (pos.equals("Defensor") | pos.equals("Medio_Campista")){num= 5;}
			else {num=3;}
			
			List<Jugador> jug = alnc.get(pos);
			int size= Math.abs(jug.size()-num);
			disp.put(pos,size);
			
		}
		return disp; 
	}
	
	public String sup_pos(String pos) {
		  return this.equipo_fantasia.sup_pos(pos);
	}
	// ######## Respecto añadir jugador al equipo, siento que puede ser mejor, pero a la vez no.... #####
	//Consigue el jugador para añadir 
	public boolean check_pres(String player,String pos) {
		Jugador Player = Liga.get_Jugador(pos, player);
		return this.equipo_fantasia.check_pres(Player);	
	} 
	
	public float[] conseguir_jugador(String pos,String name) 
		{
		       //ArrayList<Jugador> jug= Liga.disp_players(pos);		
		       //boolean seguir = true ; 
		      //System.out.println("Estos son los jugadores disponibles: ");
		     //for (int i=0; i < jug.size(); i++ ) 
		    //{
		   //	    System.out.println(i+"." + jug.get(i).getNombre()+": "+jug.get(i).getPrecio());		   
		  //  }
		 //while (seguir)
	//   \\{
	//	  \\	System.out.println("Su presupuesto " +equipo.getPresupuesto());
			//String sel =App.input("Su selección ");   		   
			//if (sel.equals("Fad")) {seguir=false;}
			//else 
			//{
				//int sele = Integer.parseInt(sel);
			//	if (sele < jug.size()) 
			//{
				 
			//	 Jugador Player = jug.get(sele); 
				 
		//		 if (Player.precio <= equipo.getPresupuesto()) 
			//	 { 	
				Jugador Player = Liga.get_Jugador(pos, name);
				
				Liga.compra(Player);
				
				Player.add_team(this.equipo_fantasia);
				return this.equipo_fantasia.add_player(Player,pos);
				//seguir=false;
				// }
				// else {System.out.println("No hay suficiente presupuesto");}
			//	}
			//	else 
			//	{
			//	 System.out.println("Escoja una opción válida");	
			//	}
			//} 
		  
		//   }
		  }
		   
		
	
	/// Añade un jugador al equipo por petición del ususario este es el menú 
	//public void menu_añdir_jugador()
	//{
		//Dream_Team equipo= this.equipo_fantasia;
		//Map<String,List<Jugador>> alnc = equipo.getTeam();
		//Map<String, Integer> disp = this.pos_disp(alnc);
		//String pos = this.get_pos();
		//if (disp.get(pos) > 0) 
		//	{ 
		//	 conseguir_jugador(pos,equipo);
		//	}
	//	
	//}
	

}

	


