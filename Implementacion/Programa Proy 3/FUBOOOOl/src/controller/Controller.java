package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import Jugadores.Jugador;
import Usuarios.App;
import presentacion.Alineacion.draw_Team;

public class Controller  {

	App app;	
	
	public Controller ()  throws IOException{
		this.app= new App();
	}
	
	public boolean get_user(String Nombre, String Clave) 
	{
		return this.app.get_user(Nombre, Clave);
	
	}
	
	public boolean get_adming(String Nombre, String Clave) 
	{
		return this.app.get_admin(Nombre, Clave);
	}
	
	public boolean add_user(String Nombre, String Clave) {
		return this.app.new_user(Nombre, Clave);
	}
	public void save() {
		this.app.save();
	}
	
	public void close_user() {
		this.app.close_user();
	}

	public void close_admin() {
		this.app.close_admin();
	}

	public boolean no_team() {
		return (this.app.no_team());
	}

	public String new_team() {
		return this.app.new_team();
	}
	
	public int get_puntaje() {
		return this.app.puntaje();
	}
	
	public String get_id_Team() {
		return this.app.get_id_team();
	}
	
	public void cargarPartida(String Ruta) throws IOException,Error {
		this.app.cargarPartidos(Ruta);
	}
	
	public float vender_jugador(String pos, String name) {
		return this.app.sel_player(pos, name);
	}
	
	public float[] buy_jugador(String pos, String name) {
		return this.app.buy_player(pos, name);
	}
	
	public Map<String, Integer> get_dips() {
		return this.app.get_disp();
	}
	
	public float get_presupuesto() {
		return this.app.get_presupuesto();
	}
	
	public List<String> get_team_player(String pos) {
	    return this.app.get_team_player(pos);	
	}
	
	public List<String> available_players(String pos) {
	    return this.app.available_players(pos);	
	}
	
	public List<String> get_teams(){
		return this.app.get_teams();
	} 
	
	public void reomve_team() {
		this.app.remove_teams();
	}
	 public void set_dream(int pos) {
		 this.app.set_team(pos);
	 }
	
	public boolean empty_pos(String pos) {
		return this.app.empty_pos(pos);
	}
	
	public boolean check_pres(String player,String pos) {
		return this.app.check_pres(player,pos);	
	} 
	
	public void change_alnc(String pos,String nombre,String nuevo){
		this.app.change_alnc(pos,nombre,nuevo);
	}
	
	public Map<String,List<String>> nom_alnc(){
			return this.app.nom_alnc();
	}
	
	public List<String> nom_supl(){
			return this.app.nom_supl();
	}
	
	
	
	public String get_capi() {
		return this.app.get_capi();
	}
		
	public void set_capitan(String Nombre) {
		this.app.set_capitan(Nombre);
	}
	
	public void set_observers(draw_Team draw) {
		this.app.addObserver(draw);
	}
	
	public List<String> nom_tit(){
		
		return this.app.nom_tit();
	}
	public String sup_pos(String pos) {
		  return this.app.sup_pos(pos);
	}
}

