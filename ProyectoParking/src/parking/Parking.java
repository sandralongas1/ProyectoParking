package parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Parking {
	private String nombre;
	private int totalPlazas;
	private ArrayList<Coche> Listacoches;
	private Map<Color, Integer> mapColor;
	private Map<Marca, Integer> mapMarcas;
	private Map<Coche, Integer> mapCoches;
	private Set<Coche> setCoches;
	
	public Parking(String nombre, int totalPlazas) {
		this.nombre = nombre;
		this.totalPlazas = totalPlazas;
		Listacoches = new ArrayList<Coche>();
		mapColor = new HashMap<>();
		mapMarcas = new HashMap<>();
		mapCoches = new HashMap<>();
		setCoches = new HashSet<>();
	}
	
	public boolean entraCoche(Coche c) {
		if(totalPlazas == Listacoches.size()) {
			System.out.println("parking lleno");
			return false;
		}
		for (Coche coche : Listacoches) {
			if(coche == (c)) {
				System.out.println("coche ya existe en el parking");
				return false;
			}	
		}
		Listacoches.add(c);
		mapColor.put(c.getColor(), mapColor.get(c.getColor()) == null ? 1 : mapColor.get(c.getColor()) +1);
		mapMarcas.put(c.getMarca(), mapMarcas.get(c.getMarca()) == null ? 1 : mapMarcas.get(c.getMarca())+1);
		mapCoches.put(c, mapCoches.get(c) == null ? 1 : mapCoches.get(c) +1);
		setCoches.add(c);
		System.out.println("coche entra");
		return true;	
	}
	
	public boolean saleCoche(Coche c) {
		if(Listacoches.size() == 0) {
			System.out.println("el parking esta vacio");
			return false;
		}
//		para acceder al objeto de una lista utilizando un for ya que la i es un numro tenemos que acceder al objeto de dicha posicion mediante
//		el lista.get(i) y ahora si podemos preguntar si ese objeto es igual al coche c que recibimos.
		for (int i = 0; i < Listacoches.size(); i++) {
			if(Listacoches.get(i) == (c)) {
				Listacoches.remove(i);
				if(mapColor.get(c.getColor()) > 1) {
//					necesitas la clave dos veces, la primera se la paso para: hacer el put sobre esa clave que es el color. y la segunda vez
//					para obtener el valor de esa clave en el mapa.
					mapColor.put(c.getColor(), mapColor.get(c.getColor()) -1);
				}
				else {
					mapColor.remove(c.getColor());
				}
				
				if(mapMarcas.get(c.getMarca()) > 1) {
					mapMarcas.put(c.getMarca(), mapMarcas.get(c.getMarca())-1);
				}
				else {
					mapMarcas.remove(c.getMarca());
				}
				
//				el set coches debe estar antes del borrado del map ya que si queda un solo coche de unas caracteristicas, YA QUE SI ESTA DESPUES
//				y se borra el coche entonces su valor en el map sera de cero y no sera capaz de borrar el coche en el set ya que nuesztra condicion
//				depende de que sea igual que 1.
				if(mapCoches.get(c) == 1) {
					setCoches.remove(c);
				}

				if(mapCoches.get(c) > 1) {
					mapCoches.put(c, mapCoches.get(c) -1);
				}
				else {
					mapCoches.remove(c);
				}
				System.out.println("el coche ha salido correctamente");
				return true;
			}
		}
		System.out.println("El coche no esta dentro");
		return false;
		
	}
	public boolean saleCocheAleatrorio() {
		Random aleatorio = new Random();
		if(Listacoches.size() == 0) {
			System.out.println("El parking esta vacio");
			return false;
		}
		int indiceAleatorio = aleatorio.nextInt(Listacoches.size());
		Coche cocheBorrado = Listacoches.remove(indiceAleatorio);
		if(mapColor.get(cocheBorrado.getColor()) > 1) {
			mapColor.put(cocheBorrado.getColor(), mapColor.get(cocheBorrado.getColor()) -1);
		}
		else {
			mapColor.remove(cocheBorrado.getColor());
		}
		
		if(mapMarcas.get(cocheBorrado.getMarca()) > 1) {
			mapMarcas.put(cocheBorrado.getMarca(), mapMarcas.get(cocheBorrado.getMarca()) -1);
		}
		else {
			mapMarcas.remove(cocheBorrado.getMarca());
		}
		if(mapCoches.get(cocheBorrado) > 1) {
			mapCoches.put(cocheBorrado, mapCoches.get(cocheBorrado) -1);
		}
		else {
			mapCoches.remove(cocheBorrado);
		}
		if(mapCoches.get(cocheBorrado) == 0) {
			setCoches.remove(cocheBorrado);
		}
		return true;
	}
	
	public boolean vaciaParking() {
		if(Listacoches.size() == 0) {
			return false;
		}
		for (int i = 0; i < Listacoches.size(); i++) {
			Coche cocheBorrado = Listacoches.remove(i);
			mapColor.remove(cocheBorrado.getColor());
			mapMarcas.remove(cocheBorrado.getMarca());
			mapCoches.remove(cocheBorrado);
			setCoches.remove(cocheBorrado);
			i--;
		}
		return true;
	}
	
	
	public void reportParking() {
		System.out.println("LISTADO COCHES");
		System.out.println("==============");
		System.out.printf("Parking: %s%n", nombre);
		for (Coche coche : Listacoches) {
			System.out.printf("%s%n", coche);
		}
		System.out.printf("total coches: %d, plazas libres: %d%n", Listacoches.size(), totalPlazas-Listacoches.size());
		System.out.println("----------------------------------------");
	}
	public void reportColores() {
		String report = "El coche de color %s se repite %d %s.%n";
		System.out.println("REPORT DE COLORES");
		System.out.println("=================");
		System.out.printf("Parking: %s%n", nombre);
		for (Color color : mapColor.keySet()) {
			System.out.printf(report, color, mapColor.get(color), mapColor.get(color) == 1 ? "vez" : "veces");
		}
		System.out.printf("Total colores diferntes: %s%n", mapColor.size());
		System.out.printf("Total coches: %s%n", Listacoches.size());
		System.out.println("----------------------------------------");
	}
	public void reportMarcas() {
		String report = "El coche de marca %s se repite %d %s.%n";
		System.out.println("REPORT DE MARCAS");
		System.out.println("=================");
		System.out.printf("Parking: %s%n", nombre);
		for (Marca marca : mapMarcas.keySet()) {
			System.out.printf(report, marca, mapMarcas.get(marca), mapMarcas.get(marca) == 1 ? "vez" : "veces");
		}
		System.out.printf("Total marcas diferntes: %s%n", mapMarcas.size());
		System.out.printf("Total coches: %s%n", Listacoches.size());
		System.out.println("----------------------------------------");
	}
	public void reportCochesIguales() {
		String report = "El %s se repite %d %s.%n";
		System.out.println("REPORT DE COCHES IGUALES");
		System.out.println("=================");
		System.out.printf("Parking: %s%n", nombre);
		for (Coche coche : mapCoches.keySet()) {
			System.out.printf(report, coche, mapCoches.get(coche), mapCoches.get(coche) == 1 ? "vez" : "veces");
		}
		System.out.printf("Total coches: %s%n", mapCoches.size());
		System.out.println("----------------------------------------");
	}
	public void reportSetCoches() {
		String report = "%s%n";
		System.out.println("REPORT SET DE COCHES");
		System.out.println("=================");
		System.out.printf("Parking: %s%n", nombre);
		for (Coche coche : setCoches) {
			System.out.printf(report, coche);
		}
		System.out.printf("Total items: %s%n", setCoches.size());
		System.out.println("----------------------------------------");
	}
}
