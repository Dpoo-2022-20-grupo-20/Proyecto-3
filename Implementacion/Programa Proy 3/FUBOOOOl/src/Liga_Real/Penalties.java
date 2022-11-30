package Liga_Real;

// Getters, setter  y constructor con atributos 
public class Penalties {
	
	public int Fallados  ; 
	public int Anotados  ; 
	public int no_atajado;
	public int detenido  ;
	
	
	// Getters y Setters 
	
	public Penalties(int fallados, int anotados, int no_atajado, int detenido) {
	
		this.Fallados = fallados;
		this.Anotados = anotados;
		this.no_atajado = no_atajado;
		this.detenido = detenido;
	}

	public int getFallados() {
		return Fallados;
	}

	public void setFallados(int fallados) {
		Fallados = fallados;
	}

	public int getAnotados() {
		return Anotados;
	}

	public void setAnotados(int anotados) {
		Anotados = anotados;
	}

	public int getNo_atajado() {
		return no_atajado;
	}

	public void setNo_atajado(int no_atajado) {
		this.no_atajado = no_atajado;
	}

	public int getDetenido() {
		return detenido;
	}

	public void setDetenido(int detenido) {
		this.detenido = detenido;
	}
	
	
}
