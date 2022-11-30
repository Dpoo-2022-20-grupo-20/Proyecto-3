package Liga;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Jugadores.Jugador;
import Usuarios.App;
import Usuarios.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
// Creación atributos y getter y setters 
public class Dream_Team  extends JFrame implements ActionListener{
//public class Dream_Team {

	
	
	public String id ; 
	public float precio_nomina;
	public Cliente dueño; 
	public Jugador capitan; 
	private static final Toolkit pantalla = Toolkit.getDefaultToolkit();
	//private static final Image alineacion = pantalla.getImage("src/uniandes/dpoo/proyecto2/imagenes/Alineacion.jpg"); //nombre de la imagen del bombillo encendido
	//private static final Image panelsuperior = pantalla.getImage("src/uniandes/dpoo/taller4/imagenes/PanelSuperior.jpg"); //nombre de la imagen del bombillo apagado 
	private static final Image logo = pantalla.getImage("src/uniandes/dpoo/taller4/imagenes/FantasyLeagueLogo.png");//logo de la aplicacion 
	
	// Solo se tienen en cuenta los titulares en este mapa 
	public Map<String,List<Jugador>> alneacn_actual= 
										   new HashMap<String,List<Jugador>>();
	
	public Map<String,List<Jugador>> alneacn_previa= 
										   new HashMap<String,List<Jugador>>();
	
	public Map<String,List<Jugador>> Team = new HashMap<String,List<Jugador>>();
	public Map<String,Jugador> nom = new HashMap<String,Jugador>();
	public List<Jugador> Team_list = new ArrayList<Jugador>();
	
	public List<Jugador> titulares = new ArrayList<Jugador>();
	public List<Jugador> suplentes = new ArrayList<Jugador>();
	
	public int puntaje_act;
	public float presupuesto ; // Es del equipo 
	

	public Dream_Team() {
		setIconImage(logo);

		
		setTitle( "Fantasy League");//nombre del titulo del frame
		setSize( 820, 820 ); //tamaño del frame
		setResizable( false );// no permite que se agrande o minimice
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );//permite que se salga del ejecutable
		setVisible(true);//permite que el frame sea visible
		
		getContentPane().setBackground(Color.black);//cambia el color del background del frame 
		
		add("FantasyLeagueLogo.png", BorderLayout.NORTH);
		//add(reporteJugadas, BorderLayout.SOUTH);
		//add(tablerodeJuego, BorderLayout.CENTER);
		//add(opcionesJuego, BorderLayout.EAST); 


		//setVisible(true);
		
	}
	private void add(String name, String north) {
		// TODO Auto-generated method stub
		
	}
	
	public List<String> get_team_players(String pos) {
		ArrayList<String> ret = new ArrayList<String>();
		
		for(Jugador player :this.Team.get(pos)) {
			ret.add(player.getNombre()+ ","+ String.valueOf(player.getPrecio()));
		}
		return ret;
	}
	
	
	
	
	public String getId() {
		return id;
	}



	public Cliente getDueño() {
		return dueño;
	}



	public Map<String, List<Jugador>> getAlneacn_actual() {
		return alneacn_actual;
	}



	public Map<String, List<Jugador>> getAlneacn_previa() {
		return alneacn_previa;
	}



	public Map<String, List<Jugador>> getTeam() {
		return Team;
	}



	public List<Jugador> getTitulares() {
		return titulares;
	}



	public float getPresupuesto() {
		return presupuesto;
	}



	//Constructor Preliminar, creo que va cambiar y arto 
	public Dream_Team(Cliente dueño) 
	{
		this.id             = nueva_id(dueño);
		this.precio_nomina  = 0;
		this.dueño          = dueño;
		this.capitan        = null;
		this.alneacn_actual = Liga.map_jugadores(alneacn_actual);
		this.Team           = Liga.map_jugadores(Team);
		this.puntaje_act    = 0;
		this.presupuesto    = Liga.presupuesto;
    }
	
	
	
	private String nueva_id(Cliente dueño)
	{
		String id = dueño.Nombre_Acceso + String.valueOf(Liga.equipos.size()); 
		return id;
	}
		
	//Creacion getter Y setters  
	
	public float getPrecio_nomina() {
		return precio_nomina;
	}

	public List<Jugador> getTeam_list() {
		return Team_list;
	}
	public void setTeam_list(List<Jugador> team_list) {
		Team_list = team_list;
	}
	public void setPrecio_nomina(float precio_nomina) {
		this.precio_nomina = precio_nomina;
	}

	public Jugador getCapitan() {
		return capitan;
	}
		
	public String nom_cap() {
		if (this.capitan==null) {
			return "Ninguno";
		}
		else {
			return this.capitan.getNombre();
		}
	}

	public void setCapitan(String capitan) {
		this.capitan = this.nom.get(capitan);
	}

	public void setCapitan_jug(Jugador cap) {
		this.capitan= cap;
	}
	public int getPuntaje_act() {
		return puntaje_act;
	}

	public void setPuntaje_act(int puntaje_act) {
		this.puntaje_act = puntaje_act;
	} 
	
	public void setId(String id) {
		this.id = id;
	}

	public void setDueño(Cliente dueño) {
		this.dueño = dueño;
	}

	public void setAlneacn_actual(Map<String, List<Jugador>> alneacn_actual) {
		this.alneacn_actual = alneacn_actual;
	}

	public void setAlneacn_previa(Map<String, List<Jugador>> alneacn_previa) {
		this.alneacn_previa = alneacn_previa;
	}

	public void setSuplentes(List<Jugador> suplentes) {
		this.suplentes = suplentes;
	}
	public void setTeam(Map<String, List<Jugador>> team) {
		for(String pos:team.keySet()) {
			for(Jugador player : team.get(pos)) {
				this.nom.put(player.getNombre(),player);
				this.Team_list.add(player);
			}
		}
		
		this.Team = team;
	}

	public void setTitulares(List<Jugador> titulares) {
		this.titulares = titulares;
	}

	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	public Map<String,List<String>> nom_alnc(){
		Map<String, List<String>> ret= new HashMap<String, List<String>>();
		
		System.out.println(this.alneacn_actual);
		for(String pos :this.alneacn_actual.keySet()) {
			List<String> temp = new ArrayList<String>();
			for(Jugador player: this.alneacn_actual.get(pos)) {
				temp.add(player.getNombre());
				System.out.println(player.getNombre());
			}
			ret.put(pos, temp);
		}
		return ret;
	}

	public List<String> nom_tit(){
		List<String>ret= new ArrayList<String>();
		for(Jugador play: this.titulares) {
			ret.add(play.getNombre());
		}
		return ret;
	}
	
	public List<String> nom_supl(){
		List<String> ret= new ArrayList<String>();
		for(Jugador player : this.suplentes) {
			ret.add(player.getNombre());
		}
		return ret;
	}
	//FIn getters y setters 
	/// Prints 

public boolean check_pres(Jugador player) {
	
	return player.getPrecio()<=this.presupuesto;	
}  



public float[] add_player(Jugador player, String Pos) 
  {
	  
	  this.presupuesto -= player.getPrecio() ;
	  List<Jugador> lista= Team.get(Pos);
	  System.out.println(this.dueño.pos_disp().get(Pos));
	  if (this.dueño.pos_disp().get(Pos)-1 >0) {
		  List<Jugador> map = this.alneacn_actual.get(Pos);
		  map.add(player);
		  this.alneacn_actual.put(Pos, map);
		  this.titulares.add(player);
		  
	  }else {
		  this.suplentes.add(player);
		  System.out.println(suplentes);
	  }
	  lista.add(player);
	  this.nom.put(player.getNombre(), player);
	  this.Team.put(Pos,lista);
	  this.precio_nomina += player.precio;
	  this.Team_list.add(player);
	  float[] ret= {this.presupuesto,player.getPrecio()};
	  return  ret;
  }	
  /// Vender Jugador 	
  public float vender_jugador(Jugador vender) 
  {
	  float valor = vender.precio;
	  this.presupuesto += valor*0.97;
	  this.precio_nomina-= vender.precio;
	  vender.quitar_team(this.id); 
	  this.Team_list.remove(vender);
	  if (this.titulares.contains(vender)) 
	  {
		  this.titulares.remove(vender);
	  }
	  if (this.alneacn_actual.get(vender.getPosicion()).contains(vender))
	  {
		  this.alneacn_actual.get(vender.getPosicion()).remove(vender);
	  }
	  //if (this.alneacn_previa.get(vender.getPosicion()).contains(vender))
	//  {
	//	  this.alneacn_previa.get(vender.getPosicion()).remove(vender);
	 // }
	  if (this.Team.get(vender.getPosicion()).contains(vender))
	  {
		  this.Team.get(vender.getPosicion()).remove(vender);
	  }
	  if (this.suplentes.contains(vender)) {
		  this.suplentes.remove(vender);
	  }
	  if(this.nom.containsKey(vender.getNombre())) {
		  this.nom.remove(vender.getNombre());
	  }
	  if(this.capitan!=null) {
	  if (this.capitan.equals(vender)) {
		  this.capitan= null;
	  }}
	  return (float) (valor*0.97);
  }
  
  
  //Añade el jugador 	
  public void add_pos(Jugador player,String Pos) 
  {
   List<Jugador> map = this.alneacn_actual.get(Pos);   
   map.add(player);
   this.alneacn_actual.put(Pos,map);
  }
  // Cambia alineación 
  
  public void change_aln(String pos,String nombre,String nuevo) 
  {
	List<Jugador> players= this.alneacn_actual.get(pos);
	
	Jugador viejo= this.nom.get(nombre);
	Jugador recien= this.nom.get(nuevo);
	int i= -1;
	Jugador jug;
	boolean go=false;
	do {
		i++;
		jug= players.get(i);
		go=jug.getNombre().equals(nombre);
	}while(!go);
	players.remove(i);
	players.add(recien) ;
	this.alneacn_actual.put(pos, players);
	i=-1;
	go=false;
	do {
		i++;
		jug= this.suplentes.get(i);
		
		go=jug.getNombre().equals(nuevo);
	}while(!go);
	if (this.capitan!=null) {
		if (this.capitan.equals(viejo)) {
			this.capitan=null;
		}
	}
	this.suplentes.remove(i);
	this.suplentes.add(viejo);
			
	
	
	
  }
  
  
  public String sup_pos(String pos) {
	  String ret= null;
	  for(Jugador player : this.suplentes) {
		  if(player.getPosicion().equals(pos)) {
			  ret = player.getNombre();
	      }
	  }
	  return ret;
  }
  // Puede que necesite Cambios 
  // TODO 
  public void calc_puntaje() 
  {	
	Collection<List<Jugador>> playerss = this.alneacn_actual.values();
	int i= 0 ; 
	  
    for(List<Jugador> players : playerss) 
	  {
		  for (Jugador player : players) 
		  {
			int punt = player.caluclar_puntaje();
			
			if (punt > 0 )
			{
				this.puntaje_act += punt;
				if (player.equals(capitan)) 
				{
					if (player.reporte.Partido.ganador.equals(player.real)) 
					{
						this.puntaje_act += 5; 
						player.puntaje += 5; 
					} 
				}
			}
			else if (i == 0) 
			{
			  for (Jugador playerss1: this.Team.get(player.Posicion)) 
				{
				  if( ! this.titulares.contains(playerss1)) 
				  {
					  punt= playerss1.caluclar_puntaje();
					  if (punt != 0 ) 
					  {
						  this.puntaje_act += punt; 
					      i+=90;
					      break;
					  }
				  }				  
				}
			}
		 }
	  }
  }
  
  /// Respecto alineación default, pero tiene que implementarse con cerrar temporada para que pueda existir 
  public void alc_default() 
  {
	 this.alneacn_actual.putAll(alneacn_previa); 
  }
  
  public void cerrar() 
  {
	  this.alneacn_previa.putAll(this.alneacn_actual);
  }
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

  
}
