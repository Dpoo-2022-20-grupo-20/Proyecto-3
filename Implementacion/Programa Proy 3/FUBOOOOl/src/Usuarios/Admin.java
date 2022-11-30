package Usuarios;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import Jugadores.Arquero;
import Jugadores.Defensa;
import Jugadores.Delantero;
import Jugadores.Jugador;
import Jugadores.Mediocampista;
import Liga.Liga;
import Liga_Real.Equipo;
import Liga_Real.Partidos;
import Liga_Real.Penalties;
import Liga_Real.Reporte_Partido;

//Toca tener en cuenta mucho los datos y crear las funciones de la carga de datos 
public class Admin extends Usuario{
	
	// TODO 
	
	public Admin(String name, String password) {
		this.Nombre_Acceso=name ;
		this.Clave = password;	
	}
	
	public void fin() 
	{
		Liga.finalizar_liga();
	}
	
	public static Map<String,Admin> csvAdmin()
	{
		 Map<String,Admin> admins = new HashMap<String,Admin>();

		try {
			File archivo = new File("Data/Admins.csv");
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			
			String linea; 
			linea= br.readLine();
			while (linea != null)
			{
		 		linea= linea.replace("\n","");
				String[] admin = linea.split(",");
				String name = admin[0];
				String password = admin[1];
				Admin cAdmin =  new Admin(name,password);
				admins.put(name,cAdmin);
				linea = br.readLine();
				
		}
			}
			catch(IOException ioe) {
			      ioe.printStackTrace();}
		return admins;
	}
	
	public boolean verifyAdminPassword(String password) {
		return super.Clave.equals(password);
	}
	
	public static void CreateFunFact(String funFact) {
		File archivo = new File("Data/FunFact.txt");
		try {
			 
            // Again operating same operations by passing
            // file as
            // parameter to read it
			 BufferedWriter out = new BufferedWriter(
		                new FileWriter(archivo));
			
			
 
            // Writing on. file
            out.write(funFact);
		
            // Closing file connections
            out.close();
            
        }
		catch(IOException ioe) {
		      ioe.printStackTrace();}
   }

	
	public static void add_dats() throws IOException 
	{
		add_rlteam();
		add_players();
	}
	
	
	public static void add_rlteam() throws IOException 
	{
		try{
			String nombre1="";
			String ruta = "Data/equipos.csv";
		
			File file = new File(ruta);
			if (file.exists()) 
			{
				BufferedReader br;
				br = new BufferedReader(new FileReader(file));
				String linea;
				linea= br.readLine();
				linea=br.readLine();
				while(linea!=null){
					nombre1= linea.replace("\n","");
					Equipo eq = new Equipo(nombre1);
					Liga.reales.put(nombre1, eq);
					linea=br.readLine();		
				}
				br.close();
			   }
		}
		catch (IOException e) {
					e.printStackTrace();
					}
		}
		
	
	public static void add_players() throws IOException 
	{
		
	  try
	   {	
		String[] pos = "Delantero,Medio_Campista,Defensor,Arquero".split(",")  ;
		
		
		String ruta = "Data/players.csv";
		
		File file = new File(ruta);
		
		BufferedReader br;
		br = new BufferedReader(new FileReader(file));
		String linea;
		
		linea= br.readLine();
		linea= br.readLine();
		while(linea!= null) 
		{
			
			linea.replace("\n", "");
			linea.replace(" ", "");
			 
			linea.replace(";",  "");
			String[] pos1 = linea.split(",");
			String nom= pos1[0];
			String equipo=pos1[1];
			
			int presio=Integer.parseInt(pos1[3].replace(";;;;;", "").replace(" ", ""));
			String posi=pos1[2];
			
		    Equipo team= Liga.reales.get(equipo);
			Jugador jug;
			if (posi.equals("Forward")) 
			{jug= new Delantero(nom,"Delantero",presio,team); }
			else if (posi.equals("Midfielder"))
			{jug = new Mediocampista(nom,"Medio_Campista",presio,team);}
			else if (posi.equals("Defender"))
			{jug= new Defensa(nom,"Defensor",presio,team);}
			else 
			{jug= new Arquero(nom,"Arquero",presio,team);}
		
			team.Jugadores.add(jug);
			team.Map_Jugadores.put(jug.Posicion, jug);
			Map<String, Jugador> sin = Liga.getJugadores_sin();
			sin.put(jug.Nombre, jug);
			Map<String, Map<String, Jugador>> con = Liga.getJugadores();
			if (con.containsKey(jug.Posicion)) 
			{
				con.get(jug.Posicion).put(jug.Nombre, jug);
			}else 
			{
				Map<String, Jugador> nea = new HashMap<String, Jugador>();
				nea.put(jug.Nombre, jug);
				con.put(jug.Posicion, nea);
			}
			
			linea=br.readLine();
		}
		
		br.close(); 
	   }
	catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		}
	}
	  
	
	public void archv() 
	{
		System.out.println("Ingrse ruta archivo, sin el .csv");
		String ruta= App.input("Archivo ");
		try {
			create_match(ruta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// falta leer el csv pero ya añade los partidos 
	public void create_match(String ruta) throws IOException 
	{
		Map<String, Jugador> Jugadores = Liga.jugadores_sin;
		Map<String, Equipo > Real= Liga.reales;
		
		File file = new File("Data/"+(ruta.strip()));//SE QUITO CSV JIJIJIJ 
		
		BufferedReader br;
		br = new BufferedReader(new FileReader(file));
		String linea;
	
		linea= br.readLine();
		linea= br.readLine();
		linea= br.readLine();
		linea= br.readLine();
		
		System.out.println(linea+"1");
		System.out.println(linea+"2"); //Se imprime para saber en que andamos jejejenafdljnfdljsnfal
		System.out.println(linea+"3");
		System.out.println(linea+"4");
		String[] info= linea.replace("\n", "").split(",");
		
		int Gol_visitante=0;
		int Gol_local=0;
		Equipo local = Real.get(info[2]);
		Equipo visitante= Real.get(info[3]);
		String fecha= info [1];
		
		for (int i = 6; i < 8; i ++){ 
			int gol=0;
			if (info [i].equals("0")) {
			String [] Strjug = info[i].replace("(","").replace(")","").split("/");
			for (String Strj:Strjug) {
				Jugador Jug = Jugadores.get(Strj);
				gol++;
				}
			}
			if (i==6) {
				Gol_local=gol;
			}
			if (i==7) {
				Gol_visitante=gol;
			}
		}
		
		Partidos match = new Partidos(Gol_visitante,Gol_local,visitante,local,fecha); 
		Liga.add_partidos(match);
		String [] locala=(info[4].replace("(","").replace(")","").split("/"));
		String [] localb=(info[5].replace("(","").replace(")","").split("/"));
		String [] uwu=Stream.of(locala, localb).flatMap(Stream::of).toArray(String[]::new); 
		String [] amarillass=arreglar(info[12],info[13]);
		String [] rojass=arreglar(info[14],info[15]);
		String [] goless=arreglar(info[6],info[7]);
		String [] autogoless=arreglar(info[8],info[9]);
		String [] asistenciass=arreglar(info[10],info[11]);
		String [] anotadoss=arreglar(info[16],info[17]);
		String [] atajadoss=arreglar(info[18],info[19]);
		String [] erradoss=arreglar(info[20],info[21]);
		String [] noatajadoss=arreglar(info[22],info[23]);
		String [] cambioss=arreglar(info[24],info[25]);
		int duracion=Integer.parseInt (info[26]);
		List<String> principales=new ArrayList<String>();
		List<String> suplencia=new ArrayList<String>();
		List<String> minutosus=new ArrayList<String>();
		for (int i=0; i< cambioss.length; i ++) 
		{
			if (i%3==0)
			{
				principales.add(cambioss[i]);
			}
			if (i%3==1)
			{
				suplencia.add(cambioss[i]);
			}
			if (i%3==2)
			{
				minutosus.add(cambioss[i]);
			}
		}
		for (String owo:uwu) {
			
			Jugador jug =Jugadores.get(owo);
			int u_u=(jug.getReal().equals(visitante))?Gol_local:Gol_visitante;
			if (principales.contains(jug.Nombre))
			{
				int index= principales.indexOf(jug.Nombre);
				Jugador jug2 = Jugadores.get(suplencia.get(index));
				int minuto = Integer.parseInt (minutosus.get(index));
				int golesrecibidoss=(jug2.real.equals(visitante))?Gol_local:Gol_visitante;
				agregar_info(jug2,fecha,match,false,true,minuto,duracion,amarillass,rojass,goless,golesrecibidoss,autogoless,
						asistenciass,erradoss,anotadoss,noatajadoss,atajadoss);
				agregar_info(jug,fecha,match,false,false,minuto,duracion,amarillass,rojass,goless,u_u,autogoless,
						asistenciass,erradoss,anotadoss,noatajadoss,atajadoss);
			}
			else
			{
				agregar_info(jug,fecha,match,true,false,0,duracion,amarillass,rojass,goless,u_u,autogoless,
						asistenciass,erradoss,anotadoss,noatajadoss,atajadoss);
			}
		}
		//Lee la infor adecuadamente 
		//DATAAA
	
		br.close();
  }
	public String [] arreglar(String a, String b)
	{
		String [] c;
		String [] d;
		String [] uwu;
		if (a.equals("0")) 
		{
			c=null;
		}
		else 
		{
			c=a.replace("(","").replace(")","").split("/");
		}

		if (b.equals("0")) 
		{
			d=null;
		}
		else 
		{
			d=b.replace("(","").replace(")","").split("/");
		}
		if (c!=null & d!=null) 
		{
			 uwu=Stream.of(c, d).flatMap(Stream::of).toArray(String[]::new); 
		}
		else if (c!=(null) & d==null) 
		{
			uwu=c;
		}
		else if(c==null &  d!=null)
		{
			uwu=d;
		}
		else 
		{
			uwu=null;
		}
		return uwu;
	}
	
	
	public void agregar_info(Jugador jug, String fecha, Partidos match, boolean completo, boolean entro, int minuto, int duracion,
			String [] amarillass, String [] rojass, String [] goless, int gol_recibidos, String [] autogoless, String [] asistencias,
			String [] falladoss,String [] anotadoss,String [] noatajadoss,String [] detenidoss) 
	{
	float entrar;
	float salida;
	if (completo)
	{ 
		 entrar=-1;
         salida=-1;
	}
	else if (entro)
	{
		entrar=minuto;
		salida=duracion;
	}
	else {
		entrar=0;
		salida=minuto;
	}
	
	String nombre=jug.Nombre;
        int amarillas=(amarillass==(null))?0:contar(amarillass,nombre);
        int rojas =(rojass==(null))?0:contar(rojass,nombre);
        int goles =(goless==(null))?0:contar(goless,nombre); 
        int auto=(autogoless==(null))?0:contar(autogoless,nombre); 
        int asis=(asistencias==(null))?0:contar(asistencias,nombre);
        // Penalties 
        
        int fallados=(falladoss==(null))?0:contar(falladoss,nombre);
        int Anotados=(anotadoss==(null))?0:contar(anotadoss,nombre);
        int no_atj =(noatajadoss==(null))?0:contar(noatajadoss,nombre);
        int detenido=(detenidoss==(null))?0:contar(detenidoss,nombre);

        Penalties penalt = new Penalties(fallados,Anotados,no_atj,detenido);
        Reporte_Partido reporte = new Reporte_Partido(jug,entrar,salida,amarillas
                ,rojas,goles,gol_recibidos,auto,fecha,asis,match,penalt,completo);

        jug.nuevo_reporte(reporte);
        jug.add_penalty(penalt);	
		
	}
	public int contar(String [] ar, String jugg ) { 
	 int contador = 0;
	 for (int i = 0; i < ar.length; i++) {
	         if(ar[i] == jugg)
	             contador++;
	 }
	
	 return contador;
	 }
	
	public void fin_fecha() 
	{
		Liga.actualizar(); 
	}
}

