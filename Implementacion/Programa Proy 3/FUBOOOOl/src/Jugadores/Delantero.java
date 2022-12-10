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
			nuevo_punt+= this.reporte.getAsistencias() *3;
			nuevo_punt+= this.reporte.getAuto_goles()*-2;  
			nuevo_punt+= this.reporte.getTarjetas_amarillas()*-1;
			nuevo_punt+= this.reporte.getPenalty().Fallados *-2;
			nuevo_punt+= this.reporte.getTarjetas_rojas()*-3; 
			nuevo_punt+= this.reporte.getManos()*-1;
			nuevo_punt+= this.reporte.getTiros_libres()*1;
			nuevo_punt+= this.reporte.getLibres_metidos()*2;
			if(this.seguido>3) {
				nuevo_punt+=10;
			}
			if(this.more>5) {
				nuevo_punt+=5;
				this.more=0;
			}
			
		}
		this.puntaje += nuevo_punt;
		return nuevo_punt;
	}
	
}
