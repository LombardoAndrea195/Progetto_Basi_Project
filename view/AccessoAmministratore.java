package application.view;


import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class AccessoAmministratore {

	
	
	@FXML
	private Button closeButton;
	
	
	
	@FXML
	private Stage stage;
	


	public void logout(ActionEvent event) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		System.out.println("Eseguito Logout Con Successo");
	    stage.close();
	}
	
	public void registraUtente() {
	
			
			try {
				
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/RegistraUtente.fxml"));
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.setTitle("Registrazione Utente");
				stage.show();

			} catch(Exception e) {
				e.printStackTrace();
			}}
	
	
	public void ricercaStellaRispettoSpina() {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/PosizioneStellaRispettoSpinaDorsale.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Ricerca Posizione Stella Rispetto SpinaDorsale");
			stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}}
	public void registraStrumento() {
	try {
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/InserisciDatiStrumento.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Registrazione Strumento");
		stage.show();

	} catch(Exception e) {
		e.printStackTrace();
	}}
	public void ricercaSuRegione() {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/RicercaSuRegione.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Ricerca Su Regione");
			stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
		}
	public void ricercaStelle() {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/RicercaStelle.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Ricerca Stelle ");
			stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}}
	public void ricercaStelleInFilamento() {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/RicercaStelleInFilamento.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Ricerca Stelle in Filamento ");
			stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}}
	
	public void registraSatellite() {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/InserisciDatiSatellite.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Registrazione Satellite");
			stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}}
	
	public void importaFileCsv() {

		
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/ImportaFilesCsv.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Importazione CSV");
			stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
public void RicercaFilamento() {

		
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/RicercaFilamento.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Ricerca Filamento");
			stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}






public void RicercaBrillantezza() {

	
	try {
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/RicercaBrillantezza.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Ricerca Brillantezza");
		stage.show();

	} catch(Exception e) {
		e.printStackTrace();
	}
}
public void RicercaPerSegmento() {

	
	try {
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/RicercaFilamentoPerSegmento.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Ricerca Filamento per segmento");
		stage.show();

	} catch(Exception e) {
		e.printStackTrace();
	}
}
public void RicercaDistanzaVerticiSegmentoContorno() {

	
	try {
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/RicercaDistanzaVerticiSegmentoContorno.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Ricerca Distanza Vertici Dal Segmento scelto al contorno del filamento ");
		stage.show();

	} catch(Exception e) {
		e.printStackTrace();
	}
}
}
	
	
	

