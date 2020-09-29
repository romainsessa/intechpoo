package jardin.flore;

import java.util.HashMap;

public class Ail extends Vegetal implements IRacePure {

	public Ail() {
		super(); // Appel du constructeur de la classe mère
		dessin[3] = 'a';
		dessin[4] = 'A';
	}

	@Override
	public void seReproduire(HashMap<String, Integer> panier) {
		panier.put("Ail", panier.get("Ail") + 3);
	}

}