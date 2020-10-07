package jardin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;

import jardin.flore.Ail;
import jardin.flore.Betterave;
import jardin.flore.Carotte;
import jardin.flore.Etat;
import jardin.flore.IOgm;
import jardin.flore.IRacePure;
import jardin.flore.Tomate;
import jardin.flore.Vegetal;

public class Jardin {

	private int longueur; 
	private int largeur;
	private HashMap<String, Integer> panier;
	private Emplacement emplacement[][];
	
	public HashMap<String, Integer> getPanier() {
		return panier;
	}

	public Jardin(int longueur, int largeur) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.panier = new HashMap<String, Integer>();
		this.emplacement = new Emplacement[this.longueur][this.largeur];
	}

	public void ajouterPanier(String nom, Integer quantite) {
		if (this.panier.get(nom) == null) {
			this.panier.put(nom, quantite);
		} else {
			this.panier.put(nom, this.panier.get(nom) + quantite);
		}
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("Voici notre jardin\n");

		for (int x = 0; x < this.longueur; x++) {
			for (int y = 0; y < this.largeur; y++) {
				Emplacement e = emplacement[x][y];
				if (e == null) {
					sb.append("o");
				} else {
					sb.append(e);
				}
			}
			sb.append("\n");
		}
		
		sb.append("\nEt notre panier contient :");
		
		Set<String> keySet = panier.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String nom = it.next();
			Integer quantite = this.panier.get(nom);
			sb.append("\n");
			sb.append(nom);
			sb.append(" : ");
			sb.append(quantite);
			sb.append(" graine(s)");
		}
		return sb.toString();
	}

	public void semer() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Indiquer l'axe X");
		int x = sc.nextInt();

		System.out.println("Indiquer l'axe Y");
		int y = sc.nextInt();

		System.out.println("Quel vegetal? (1. Ail , 2. Betterave , 3. Carotte , 4. Tomate");
		int choiceVegetal = sc.nextInt();

		switch (choiceVegetal) {
		case 1:
			if (this.panier.get("Ail") > 0) {
				this.emplacement[x][y] = new Emplacement(new Ail());
				this.panier.put("Ail", this.panier.get("Ail") - 1);
			}
			break;
		case 2:
			if (this.panier.get("Betterave") > 0) {
				this.emplacement[x][y] = new Emplacement(new Betterave());
				this.panier.put("Betterave", this.panier.get("Betterave") - 1);
				break;
			}
		case 3:
			if (this.panier.get("Carotte") > 0) {
				this.emplacement[x][y] = new Emplacement(new Carotte());
				this.panier.put("Carotte", this.panier.get("Carotte") - 1);
				break;
			}
		case 4:
			if (this.panier.get("Tomate") > 0) {
				this.emplacement[x][y] = new Emplacement(new Tomate());
				this.panier.put("Tomtate", this.panier.get("Tomate") - 1);
				break;
			}
		}
	}

	public void passerSaisonSuivante() {
		for (int x = 0; x < this.longueur; x++) {
			for (int y = 0; y < this.largeur; y++) {
				Emplacement e = emplacement[x][y];
				if (e != null) {
					if (e.getVeg().getEtat() == Etat.MORT) {
						emplacement[x][y] = null;
					} else {
						e.getVeg().grandir();
					}
				}
			}
		}
	}

	public void recolter() {
		for (int x = 0; x < this.longueur; x++) {
			for (int y = 0; y < this.largeur; y++) {
				
				Emplacement e = emplacement[x][y];
				if (e != null && e.getVeg().getEtat() == Etat.FLEUR) {
					Vegetal veg = e.getVeg();
					if (veg instanceof IRacePure) {
						IRacePure v = (IRacePure) veg;
						v.seReproduire(this.panier);
					} else if (veg instanceof IOgm) {
						IOgm v = (IOgm) veg;
						SimpleEntry<Integer, Integer> simpleEntry = v.seDupliquer(this.longueur, this.largeur);
						emplacement[simpleEntry.getKey()][simpleEntry.getValue()] = new Emplacement(veg);
					}
					emplacement[x][y] = null;
				}
			}
		}
	}

}
