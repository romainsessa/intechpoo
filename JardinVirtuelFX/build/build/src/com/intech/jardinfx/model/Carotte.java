package com.intech.jardinfx.model;

import java.util.HashMap;

public class Carotte extends Vegetal implements IRacePure {

	public Carotte() {
		super();
		dessin[3] = 'c';
		dessin[4] = 'C';
	}

	@Override
	public void seReproduire(HashMap<String, Integer> panier) {
		panier.put("Carotte", panier.get("Carotte") + 3);
	}

	@Override
	public String name() {
		return "Carotte";
	}



}