package Usuarios;

// Atributos, aun ni idea métodos 

public abstract class Usuario {

	public String Nombre_Acceso ; 
	protected String Clave ; 
	public String permisos;
	
	public String getNombre_Acceso() {
		return Nombre_Acceso;
	}
	public String getClave() {
		return Clave;
	}
	public String getPermisos() {
		return permisos;
	} 
	
		
}
