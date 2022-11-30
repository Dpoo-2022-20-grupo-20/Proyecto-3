package Usuarios;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Liga.Liga;
import presentacion.Users_menu;



public class App extends Observable
{
// No sé ;) 
	public static Map<String,Cliente> usuarios = new HashMap<String,Cliente>() ;
	
	public static Map<String,Admin> admins = new HashMap<String,Admin>();

	private Cliente actual;
	
	private Admin jefe; 
	
	
	public App() throws IOException
	{
		System.out.println("adhasdasd");
		Admin.add_dats();		
		load_data();
		admins = Admin.csvAdmin();
    }

	public void save() 
	{
		DataManagement.csvCLiente();
		DataManagement.csvEquipo();
	}
		
	public static void load_data() 
	{
		DataManagement.load_csv();		
	}
	
	
	
	public boolean get_user(String Nombre_Acceso,String Clave) {
		boolean verification =false;
		boolean userExists = usuarios.containsKey(Nombre_Acceso);
		// si existe llamar cliente.verifypassword
		if (userExists) {
			this.actual = usuarios.get(Nombre_Acceso);
			verification = this.actual.verifyPassword(Clave);
		}
		return verification;

	}
	
	public void close_user() {
		usuarios.put(this.actual.getNombre_Acceso(), this.actual);
		this.actual= null;
	}
	
	public void close_admin() {
		this.jefe=null;
	}
	
	
	
	public boolean get_admin(String Nombre_Acceso,String Clave) {
		boolean adminExists = admins.containsKey(Nombre_Acceso);
		
		if (adminExists) {
			this.jefe = admins.get(Nombre_Acceso); 
			if (this.jefe.Clave.equals(Clave)) {
				return true;
			}
			else {return false;}
			}
		return false; 
	}
	
	public boolean no_team() {
		return (this.actual.getEquipos_fantasia()==null);
	}
	
	public boolean empty_pos(String pos) {
		return this.actual.empty_pos(pos);
	}
	
	public boolean new_user(String Nombre_Acceso,String Clave) {
		if (!usuarios.containsKey(Nombre_Acceso))
		{		
			Cliente client = new Cliente(Nombre_Acceso, Clave);
			usuarios.put(Nombre_Acceso, client );
			return true;
		}
		else {return false; }
	}
	
	public String new_team() {
		return this.actual.crearequipo();
	}
	
	public String get_id_team() {
		return this.actual.get_id_team();
	}
	
	public int puntaje() {
		return this.actual.getPuntaje();		
	}
	

	

	public float sel_player(String pos, String name) {
		return this.actual.vender_jugador(pos,name);
	}
	
	public float[] buy_player(String pos, String name) {
		return this.actual.conseguir_jugador(pos, name);
	}

	public Map<String, Integer> get_disp() {
		return this.actual.pos_disp();
	}
	
	public void cargarPartidos(String ruta) throws IOException {
		this.jefe.create_match(ruta);
	}
	
	public float get_presupuesto() {
		return this.actual.get_presupuesto();
	}
	
	public List<String> get_team_player(String pos) {
	    return this.actual.get_team_players(pos);	
	}
	
	public List<String> available_players(String pos) {
	    return Liga.disp_players(pos,this.actual.get_id_team());	
	}
	
	public boolean check_pres(String player,String pos) {
		return this.actual.check_pres(player,pos);	
	} 
	
	
	
	public void change_alnc(String pos,String nombre,String nuevo){
		this.actual.change_aln(pos,nombre,nuevo);
		this.setChanged();
		this.notifyObservers("a");
	}
	
	public Map<String,List<String>> nom_alnc(){
			return this.actual.nom_alnc();
	}
	
	public List<String> nom_supl(){
			return this.actual.nom_supl();
	}
	
	public String get_capi() {
		return this.actual.get_capi();
	}
	
	public void set_capitan(String Nombre) {
		this.actual.set_capitan(Nombre);
		this.setChanged();
		this.notifyObservers("a");
	}
	
	public List<String> nom_tit(){
		
		return this.actual.nom_tit();
	}
	
	public String sup_pos(String pos) {
		  return this.actual.sup_pos(pos);
	}
	
	//no
	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
    
	
	
	
	
	//si
	public static void print() 
	{
		try {
			Auxiliar.print();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//no
	public static void writeFunFact() {
		String funfact=App.input("Ingrese datos interesantes de la liga\n");
		Admin.CreateFunFact(funfact);
	}

}
