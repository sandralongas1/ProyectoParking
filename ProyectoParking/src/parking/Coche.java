package parking;

import java.util.Objects;
import java.util.Random;

public class Coche {
	private Marca marca;
	private Color color;
	
	
	public Coche(Marca marca, Color color) {
		this.marca = marca;
		this.color = color;
	}

	public Coche() {
		Random aleatorio = new Random();
		int aleatorioMarca = aleatorio.nextInt(Marca.values().length);
		this.marca = Marca.values()[aleatorioMarca];
		
		int aleatorioColor = aleatorio.nextInt(Color.values().length);
		this.color = Color.values()[aleatorioColor];
	}

	@Override
	public String toString() {
		return "Coche: [" + marca + " " + color + "]";
	}

	public Color getColor() {
		return color;
	}

	public Marca getMarca() {
		return marca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, marca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return this.color == other.color &&  this.marca == other.marca;
	}
	
	
	
	
}
