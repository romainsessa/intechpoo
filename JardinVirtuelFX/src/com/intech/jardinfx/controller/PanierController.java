package com.intech.jardinfx.controller;

import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PanierController {

	@FXML
	private Label ailLabel;
	@FXML
	private Label carotteLabel;
	@FXML
	private Label betteraveLabel;
	@FXML
	private Label tomateLabel;
	
	
	private HashMap<String, Integer> panier;
	
	public HashMap<String, Integer> getPanier() {
		return panier;
	}
	
	public PanierController() {
		panier = new HashMap<String, Integer>(); // Model init
		panier.put("Ail", 5);
		panier.put("Betterave", 5);
		panier.put("Carotte", 5);
		panier.put("Tomate", 5);
	}
	
	public void updatePanier() {
		ailLabel.setText(panier.get("Ail") + " graines d'Ail.");
		betteraveLabel.setText(panier.get("Betterave") + " graines de Betteraves.");
		carotteLabel.setText(panier.get("Carotte") + " graines de Carottes.");
		tomateLabel.setText(panier.get("Tomate") + " graines de Tomates.");
	}
	
	public void removeSeed(String vegetalName) {
		panier.put(vegetalName, panier.get(vegetalName) - 1);
	}
}
