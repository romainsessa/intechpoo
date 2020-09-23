package jardin.flore;

import java.util.HashMap;

public class Carotte extends Vegetal implements IRacePure {

	public Carotte() {
		super();
		dessin[3] = 'c';
		dessin[4] = 'C';
	}

	@Override
	public void seReproduire(HashMap<String, Integer> panier) {
		int nombreDeGrainesActuelles = panier.get("Carotte");
		panier.put("Carotte", nombreDeGrainesActuelles + 3);
	}



}