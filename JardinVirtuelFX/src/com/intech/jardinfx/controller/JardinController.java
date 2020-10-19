package com.intech.jardinfx.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.AbstractMap.SimpleEntry;

import com.intech.jardinfx.model.Ail;
import com.intech.jardinfx.model.Betterave;
import com.intech.jardinfx.model.Carotte;
import com.intech.jardinfx.model.Emplacement;
import com.intech.jardinfx.model.Etat;
import com.intech.jardinfx.model.IOgm;
import com.intech.jardinfx.model.IRacePure;
import com.intech.jardinfx.model.Tomate;
import com.intech.jardinfx.model.Vegetal;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class JardinController implements Initializable {

	/** Pour injection automatique du controller, le nom de l'attribut doit être :
	 *  valeur du fx:id de l'include (jardin.fxml ligne 94) + le mot Controller
	 *  donc [panierPane][Controller] -> panierPaneController
	 *  **/
	@FXML
	private PanierController panierPaneController;
	
	/** Model object **/	
	private Emplacement[][] emplacements;
	private int longueur = 5;
	private int largeur = 5;

	/** View object **/
	@FXML
	private ChoiceBox<String> vegetalChoice;
	@FXML
	private TextField xField;
	@FXML
	private TextField yField;
	@FXML
	private GridPane gridPane;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ObservableList<String> list = FXCollections.observableArrayList("Ail", "Betterave", "Carotte", "Tomate"); // Model
																													// init
		vegetalChoice.setItems(list); // View init

		emplacements = new Emplacement[longueur][largeur]; // Model init

		for (int i = 0; i < longueur; i++) { // View init
			for (int j = 0; j < largeur; j++) {
				Label node = new Label("o");
				gridPane.add(node, i, j);
			}
		}

		panierPaneController.updatePanier(); // View init
	}

	@FXML
	protected void handleQuit(ActionEvent e) {
		Platform.exit();
	}

	@FXML
	protected void handleSow(ActionEvent e) {
		try {
			int x = Integer.valueOf(xField.getText());
			int y = Integer.valueOf(yField.getText());

			switch (vegetalChoice.getValue()) {
			case "Ail":
				sow(new Ail(), x, y);
				break;
			case "Betterave":
				sow(new Betterave(), x, y);
				break;
			case "Carotte":
				sow(new Carotte(), x, y);
				break;
			case "Tomate":
				sow(new Tomate(), x, y);
				break;
			}
			// Form unfilled
			vegetalChoice.setValue(null);
			xField.setText("");
			yField.setText("");
		} catch (Exception exception) {
			// Display dialog alert in case of user input error
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erreur de saisie");
			alert.setContentText("Attention le formulaire pour semer n'a pas été rempli correctement");
			alert.showAndWait();
		}
	}

	@FXML
	protected void handleCollect(ActionEvent event) {
		for (int x = 0; x < longueur; x++) {
			for (int y = 0; y < largeur; y++) {
				Emplacement e = emplacements[x][y];
				if (e != null && e.getVeg().getEtat() == Etat.FLEUR) {
					Vegetal veg = e.getVeg();
					if (veg instanceof IRacePure) {
						IRacePure v = (IRacePure) veg;
						v.seReproduire(panierPaneController.getPanier()); // Model update
						panierPaneController.updatePanier(); // View update
						emplacements[x][y] = null; // Model update
						initCell(x, y); // View update
					} else if (veg instanceof IOgm) {
						emplacements[x][y] = null; // Model update
						initCell(x, y); // View update
						IOgm v = (IOgm) veg;
						SimpleEntry<Integer, Integer> simpleEntry = v.seDupliquer(5, 5);
						int newX = simpleEntry.getKey();
						int newY = simpleEntry.getValue();
						emplacements[newX][newY] = new Emplacement(veg); // Model update
						updateCell(veg.toString(), newX, newY); // View update
					}
				}
			}
		}
	}

	@FXML
	protected void handleNextSeason(ActionEvent event) {
		for (int i = 0; i < longueur; i++) {
			for (int j = 0; j < largeur; j++) {
				Emplacement e = emplacements[i][j];
				if (e != null) {
					if (e.getVeg().getEtat() == Etat.MORT) {
						emplacements[i][j] = null; // Model update
						initCell(i, j); // View udpate
					} else {
						e.getVeg().grandir(); // Model update
						updateCell(e.toString(), i, j); // View update
					}
				}
			}
		}

	}

	private void updateCell(String txt, int x, int y) {
		Label l = (Label) gridPane.getChildren().get(x * longueur + y);
		l.setText(txt);
	}

	private void initCell(int x, int y) {
		updateCell("o", x, y);
	}

	private void sow(Vegetal veg, int x, int y) {
		emplacements[x][y] = new Emplacement(veg); // Model update
		updateCell(veg.toString(), x, y); // View update
		
		panierPaneController.removeSeed(veg.name()); // Model update
		panierPaneController.updatePanier(); // View update
	}

}
