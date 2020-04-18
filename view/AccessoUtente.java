package application.view;

//import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AccessoUtente {



	@FXML
	private Main main;
	@FXML
	private Stage stage;
	@FXML 
	private Button closeButton;
	
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
	@FXML	
	public void chiudi(ActionEvent event) {
			Stage stage = (Stage) closeButton.getScene().getWindow();

			System.out.println("Eseguito Logout Con Successo");
		    stage.close();
		   
	}
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
	}}
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
	}}


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
}
