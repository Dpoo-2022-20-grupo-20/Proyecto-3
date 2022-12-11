package Usuarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Jugadores.Jugador;
import Liga.Dream_Team;
import Liga.Liga;
import Liga_Real.Equipo;
import Liga_Real.Penalties;

public class DataManagement {
	
	public static void csvPenalties(Penalties penalty,String id_reporte){
		
			try {
				String ruta = "Data/Penalties.csv";
						
				File file = new File(ruta);
				
				String fallados=String.valueOf(penalty.Fallados);
				
				String anotados=String.valueOf(penalty.Anotados);
				
				String detenidos = String.valueOf(penalty.detenido);
				
				String no_atajado =String.valueOf(penalty.no_atajado);
				
				
				
				if (!file.exists()) 
	            {
	                file.createNewFile();
	            }
	            
				
	            FileWriter fw = new FileWriter(file);
	            BufferedWriter bw = new BufferedWriter(fw);
	            bw.write(id_reporte+","+fallados+","+anotados+","+detenidos+","+no_atajado+"\n");
	            bw.close();
	            
	        	} 
			catch (Exception e) 
			{
	            e.printStackTrace();
			}
		}
	
	public static void csv_jugadores()  {
		try {
			String ruta= "Data/Player_act.csv";
			File file = new File(ruta);
			FileWriter fw= new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			if (file.exists()) 
            {
                file.delete();
            }
			file.createNewFile();
			
			String linea= "Nombre,Equipo,Posicion,Precio,Puntaje\n";
			bw.write(linea);
			for(Jugador jug:Liga.jugadores_sin.values())
			{
				linea="";
				linea+= jug.getNombre()+","+jug.getReal().getNombre()+","+jug.getPosicion()+","+String.valueOf(jug.getPrecio())+","+String.valueOf(jug.getPuntaje())+"\n";
				bw.write(linea);
			}
			bw.close();
		}
		catch(Error e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public static void info_liga() {
		try {
			String ruta= "Data/Liga_data.csv";
			File file = new File(ruta);
			FileWriter fw= new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			if (file.exists()) 
	        {
	            file.delete();
	        }
				file.createNewFile();
			Map<String, Integer> compra = Liga.get_compra();
			String linea="";
			for(Entry<String, Integer> add:compra.entrySet()) {
				linea+=add.getKey()+"-"+add.getValue()+",";
			}	
			linea= linea.substring(0,linea.length()-1);
			linea+="\n";	
			bw.write(linea);
			
			Map<String, Integer> venta = Liga.get_ventas();
			linea="";
			
			for(Entry<String, Integer> add:compra.entrySet()) {
				linea+=add.getKey()+"-"+add.getValue()+",";
			}	
			linea= linea.substring(0,linea.length()-1);
			linea+="\n";	
			bw.write(linea);
			
			List<String> compr = Liga.comp_rect();
			linea="";
			for(String jug:compr) {
				linea+=jug+",";
			}
			linea= linea.substring(0,linea.length()-1);
			linea+= "\n";
			bw.write(linea);
			
			List<String> vent = Liga.comp_rect();
			linea="";
			for(String jug:vent) {
				linea+=jug+",";
			}
			linea= linea.substring(0,linea.length()-1);
			linea+= "\n";
			bw.write(linea);
			
			bw.close();
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	
	public static void add_liga_dat(File arch) throws IOException {
		try {
			BufferedReader br;
			br = new BufferedReader(new FileReader(arch));
			String linea; 
			linea= br.readLine();
			String[] comprar= linea.split(",");
			for(String dat : comprar) {
				
				String[] info=dat.split("-");
				
				for(int i = 0; i<Integer.parseInt(info[1]);i++) {
					Liga.add_compra(info[0]);
				}
			}
			

			linea= br.readLine();
			String[] vender= linea.split(",");
			for(String dat : vender) {
				
				String[] info=dat.split("-");
				
				for(int i = 0; i<Integer.parseInt(info[1]);i++) {
					Liga.add_venta(info[0]);
				}
			}
			
			
			linea= br.readLine();
			String[] jug_comp= linea.split(",");
			Liga.add_comp(jug_comp);
			
			linea= br.readLine();
			String[] jug_vend= linea.split(",");
			Liga.add_vend(jug_vend);
			
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void csvEquipo() {
		
		try {
			String ruta = "Data/Dream_Team.csv";
					
			File file = new File(ruta);
			FileWriter fw = new FileWriter(file);
        	BufferedWriter bw = new BufferedWriter(fw);
			
			if (file.exists()) 
            {
                file.delete();
            }
			file.createNewFile();
			for (Dream_Team equipo : Liga.equipos) 
			{
				String act = " "; 
				String team=" ";
				String previa= " ";
				String titulares=" "; 
				String suplentes=" ";
				for (List<Jugador> play11 : equipo.getAlneacn_actual().values()) 
				{
					for(Jugador play1 :play11) 
					{act+= play1.getNombre() +"-";}
				}
				for (List<Jugador> play21 : equipo.getAlneacn_actual().values()) 
				{
					for(Jugador play2 :play21)
					{previa+= play2.getNombre() +"-";}
				}
			
				for (List<Jugador> play31 : equipo.getTeam().values()) 
				{
					for(Jugador play3 :play31) {team+= play3.getNombre() +"-";}
				}
			
				for (Jugador play4 : equipo.getTitulares()) 
				{
					titulares+= play4.Nombre + "-"; 
				}
				for(String play5 :equipo.nom_supl()) {
					suplentes+=play5+"-";
				}
			    String nombreee= equipo.getCapitan()==null?" ":equipo.getCapitan().getNombre();      	
            	
			    bw.write(equipo.getDueño().getNombre_Acceso()+","+equipo.getId()+","+equipo.getPrecio_nomina()+","+equipo.getPuntaje_act()+","+
            		 equipo.getPresupuesto()+","+nombreee+","+act+","+team+","+previa+","+titulares+","+suplentes+"\n");
            
			}
            
            bw.close();
            
        	} 
		catch (Exception e) 
		{
            e.printStackTrace();
		}
		
	}
	
	
	/// Crea o actualiza el csv, creo que simplemente s
	public static void csvCLiente() 
	{
		try {
			Map<String, Cliente> clientes = App.usuarios;
			String ruta = "Data/Cliente.csv";
					
			File file = new File(ruta);
					
			if (file.exists()) 
            {
                file.delete();
            }
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (Cliente client: clientes.values() ) 
            {
            	bw.write(client.Nombre_Acceso+","+client.Clave+","+client.puntaje+"\n");
            }
            
            bw.close();
            
        	} 
		catch (Exception e) 
		{
            e.printStackTrace();
		}
	}
	
	
	public static void load_csv() 
	{
		String ruta1 = "Data/Cliente.csv";
		File file1   = new File(ruta1);
		String ruta2 = "Data/Dream_Team.csv";
		String ruta3 = "Data/Liga_data.csv";
		File file2 = new File(ruta2);
		File file3= new File(ruta3);
		if (file2.exists() && file1.exists()) 
		{
			if(file1.canRead() && file2.canRead()) 
			{
				try {
					read_Client(file1);
					read_teams(file2);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		if (file3.exists() ) 
		{
			if(file3.canRead()) 
			{
				try {
					add_liga_dat(file3);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
	}
	
	
	
	
	public static void read_teams(File arch) throws IOException 
	{
		
		try 
		{
			BufferedReader br;
			 
			br = new BufferedReader(new FileReader(arch));
			String linea;
			linea= br.readLine();
			while(linea!=null) {
				;
				linea= linea.replace("\n", "");
				String[] info = linea.split(",");
				String clien  = info[0];
				String id = info[1];
				float nomina = Float.valueOf(info[2]);
				int punt   = Integer.parseInt(info[3]);
				float pres   = Float.valueOf(info[4]);
				String cap = info[5];
				String act = info[6];
				String team= info[7];
				String prev= info[8];
				String titulares =info[9];
				String suplentes=info[10];
				Cliente client   = App.usuarios.get(clien);
				
				Dream_Team equipo= new Dream_Team(client);
						
				equipo.setId(id);
				equipo.setPrecio_nomina(nomina);
				equipo.setPuntaje_act(punt);
				equipo.setPresupuesto(pres);
				Jugador capi;
				if (!cap.equals(" ")) {
				capi = Liga.jugadores_sin.get(cap);
				}else 
				{
				 capi=null;
				}
				equipo.setCapitan_jug(capi);
				
				Map<String,List<Jugador>> alneacn_actual = new HashMap<String,List<Jugador>>();
				Map<String,List<Jugador>> alneacn_previa = new HashMap<String,List<Jugador>>();
				Map<String,List<Jugador>> Team = new HashMap<String,List<Jugador>>();
				List<Jugador> titul= new ArrayList<Jugador>();
				List<Jugador> supl= new ArrayList<Jugador>();
				alneacn_actual=Liga.map_jugadores(alneacn_actual);
				
			    alneacn_previa=Liga.map_jugadores(alneacn_previa);
			    Team=Liga.map_jugadores(Team);
			    
			    if (!act.equals(" ")) {
			    for( String pre : act.split("-"))
				{
			    	Jugador actual = Liga.getJugadores_sin().get(pre.strip());
			    	if (actual != null) {
			    		System.out.println("INa"+actual.getNombre());
			    	List<Jugador> list = alneacn_actual.get(actual.Posicion);
					list.add(actual);				
					alneacn_actual.put(actual.Posicion, list);}
				}}
			    
			    if (!prev.equals(" ")) {
				for (String actu : prev.split("-")) 
				{
					Jugador previo = Liga.getJugadores_sin().get(actu.strip());
					if (previo != null) {
					List<Jugador> list = alneacn_previa.get(previo.Posicion);
					list.add(previo);				
					alneacn_previa.put(previo.Posicion, list);}
				}}
			    
			    if (!team.equals(" ")) {
				for (String play_t : team.split("-") ) 
				{
					
					Jugador tea = Liga.jugadores_sin.get(play_t.strip());
					if (tea != null) {
					tea.add_team(equipo);
					equipo.getTeam_list().add(tea);
					List<Jugador> list = Team.get(tea.Posicion);
					list.add(tea);				
					Team.put(tea.Posicion, list);
					}
				}}
				
			    if (!titulares.equals(" ")) {
				for(String inse : titulares.split("-")) 
				{
					System.out.println(inse);
					Jugador juga = Liga.jugadores_sin.get(inse.strip());
					System.out.println(juga.getNombre()+"Tit");
					if (juga != null) {
						
					titul.add(juga);}
				}}
				
			    if (!suplentes.equals(" ")) {
					for(String inse : suplentes.split("-")) 
					{
						System.out.println(inse);
						Jugador jugar = Liga.jugadores_sin.get(inse.strip());
						System.out.println(jugar.getNombre()+"Tit");
						if (jugar != null) {
							
						supl.add(jugar);}
					}}
				
				equipo.setAlneacn_actual(alneacn_actual);
				equipo.setAlneacn_previa(alneacn_previa);

				equipo.setSuplentes(supl);
				equipo.setTitulares(titul);
				equipo.setTeam(Team);
				
				client.add_dt(equipo);
				
				List<Dream_Team> eq = Liga.getEquipos();
				eq.add(equipo);
				Map<String, Dream_Team> map = Liga.getEq_map();
				map.put(equipo.id, equipo);
				Liga.setEq_map(map);
				Liga.setEquipos(eq);
				
				linea=br.readLine();
			}
			br.close();
		} 
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		}
		
	}
	
	
	public static void read_Client(File arch) throws IOException 
	{
		
		try {
			BufferedReader br;
			br = new BufferedReader(new FileReader(arch));
			String linea; 
			linea= br.readLine();
			while(linea!= null)
			{
				linea= linea.replace("\n", "");	
				String[] info = linea.split(",");
				String nombre= info[0];
				String clave = info[1];
				int punt = Integer.parseInt(info[2]);
				Cliente client = new Cliente(nombre,clave);
				client.setPuntaje(punt);;
				App.usuarios.put(nombre, client);		
				linea= br.readLine();
			}
			
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
