package Liga_Real;

import Jugadores.Jugador;

// Ojo con está clase, esto es por jugador? Por partido? Toca revizar con cuidado 
// Getters, Setters, y atributos añadidos y algunos metodos aun faltan 

public class Reporte_Partido {

	public Jugador jugador ; 
	public float min_entrada ; 
	public float min_salida  ;
	public int tarjetas_amarillas;
	public int tarjetas_rojas    ;
	public int goles_scored;
	public int goles_recibidos;
	public int auto_goles; 
	public String date;
	public boolean completo; 
	public int asistencias;
	public Partidos Partido; 
	public Penalties Penalty; 
	public int tiros_libres;
	public int libres_metidos;
	public int manos; 
	
	



	public Reporte_Partido(Jugador jugador, float min_entrada, float min_salida, int tarjetas_amarillas,
			int tarjetas_rojas, int goles_scored, int goles_recibidos, int auto_goles, String date, boolean completo,
			int asistencias, Partidos partido, Penalties penalty, int tiros_libres, int libres_metidos, int manos) {
		
		this.jugador = jugador;
		this.min_entrada = min_entrada;
		this.min_salida = min_salida;
		this.tarjetas_amarillas = tarjetas_amarillas;
		this.tarjetas_rojas = tarjetas_rojas;
		this.goles_scored = goles_scored;
		this.goles_recibidos = goles_recibidos;
		this.auto_goles = auto_goles;
		this.date = date;
		this.completo = completo;
		this.asistencias = asistencias;
		Partido = partido;
		Penalty = penalty;
		this.tiros_libres = tiros_libres;
		this.libres_metidos = libres_metidos;
		this.manos = manos;
	}

	// Ojo si nunca sale, esto peta, toca revizar como manejar eso 
	
	public float min_game() 
	{
     	float game= this.min_salida- this.min_entrada ; 	
		return game;
	}
	
	public int total_tarjt()
	{
		int tarjt = this.tarjetas_amarillas + this.tarjetas_rojas;
		return tarjt;
	}

	 @Override
	 public String toString() 
	 {
		 return "Entrada: "+this.min_entrada+"\tSalida: "+this.min_salida +"\tGoles: "+ this.goles_scored
				 +"\tTarjetas" + (this.tarjetas_amarillas+this.tarjetas_rojas); 
	 }
		

}
