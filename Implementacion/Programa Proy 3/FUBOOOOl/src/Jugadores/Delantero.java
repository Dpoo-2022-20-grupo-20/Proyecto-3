package Jugadores;

import java.util.List;

import Liga_Real.Equipo;
import Liga_Real.Penalties;


// Creacion metodo contructor y delclaraón métiodo especifico  

public class Delantero extends Jugador{

	public Delantero(String nombre, String posicion, float precio, Equipo real) {
		super(nombre, posicion, precio, real);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int caluclar_puntaje()
	{
		List<Penalties> al = penalties;
		
		int nuevo_punt=0; 
		
		if (this.enough) 
		{
			if (this.plus_60) 
			{
				nuevo_punt+=2;
			}	
			else 
			{
				nuevo_punt+=1;
			}
			nuevo_punt+= this.reporte.goles_scored*4 ;
			nuevo_punt+= this.reporte.asistencias *3;
			nuevo_punt+= this.reporte.auto_goles*-2;  
			nuevo_punt+= this.reporte.tarjetas_amarillas*-1;
			nuevo_punt+= this.reporte.Penalty.Fallados *-2;
			nuevo_punt+= this.reporte.tarjetas_rojas*-3; 
		}
		this.puntaje += nuevo_punt;
		return nuevo_punt;
	}
	
}
