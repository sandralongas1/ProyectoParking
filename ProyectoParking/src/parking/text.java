package parking;

public class text {
	public static void main(String[] args) {
		Coche c1 = new Coche(Marca.AU, Color.AMA);
		Coche c2 = new Coche(Marca.CI, Color.AZ);
//		Coche c3 = new Coche();
		Coche c4 = new Coche(Marca.AU, Color.AZ);
		Coche c5 = new Coche(Marca.HO, Color.AZ);
		Coche c6 = new Coche(Marca.WV, Color.AZ);
		Coche c7 = new Coche(Marca.CI, Color.AZ);
		
		Parking p1 = new Parking("lolo", 10);
		
		p1.entraCoche(c1);
		p1.entraCoche(c1);
		p1.entraCoche(c2);
//		p1.entraCoche(c3);
		p1.reportParking();
		p1.saleCoche(c1);
		p1.saleCoche(c1);
		p1.entraCoche(c1);
		p1.reportParking();
//		p1.vaciaParking();
		p1.reportParking();
		p1.entraCoche(c4);
		p1.reportColores();
		p1.reportMarcas();
//		p1.saleCoche(c4);
		p1.entraCoche(c1);
		p1.entraCoche(c2);
		p1.entraCoche(c5);
		p1.entraCoche(c6);
		p1.entraCoche(c7);
		p1.reportColores();
		p1.reportMarcas();
		p1.reportCochesIguales();
		p1.reportSetCoches();
	}
}
