package parking;

public enum Marca {
	WV("Volskswagen"), SE("seat"), RE("renol"), CI("Citroen"), HO("Honda"), AU("audi"); 
	
	private String nombreCompleto;

	private Marca(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	
}
