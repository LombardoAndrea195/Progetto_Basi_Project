package application.view;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
//import application.bean.FilamentoBean;
//import application.bean.StellaBean;
import application.control.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RicercaStelleInFilamento {
	//Requisito 9
	@FXML
	private TextField IdFilamento;
	@FXML
	private Main main;
	@FXML
	private Stage stage;
	@FXML
	public Button closeButton;
	
	public  static ArrayList<Double> Valori= new ArrayList<Double>();
	
	public void setMain(Main main) {
		this.main = main;
	}

	public void setStage(Stage loginStage) {
		this.stage = loginStage;
	}
	
	public void chiudi(ActionEvent event) {
		// implementazione del pulsante per chiudere la finestra attuale
	    Stage stage = (Stage) closeButton.getScene().getWindow();
	    System.out.println("Pagina chiusa nel modo corretto");
	    stage.close();
	
	}
	public void ricercaStelleInFilamento(ActionEvent event) throws ClassNotFoundException {
	try {
		Integer filamento=Integer.parseInt(IdFilamento.getText());
	if( IdFilamento.getText()==null ) {
		

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("");
		alert.setHeaderText("Attenzione!");
		alert.setContentText("campi incompleti... inserire tutti i campi.");
		alert.showAndWait();}
	 else {
	Valori=Controller.RicercaStelleInFilamento(filamento);
		Stage stage = (Stage) closeButton.getScene().getWindow();
	    stage.close();
		AnchorPane root;
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/SchermataRicercaStelleInFilamento.fxml"));
			Scene scene = new Scene(root);
			Stage stage1 = new Stage();
			stage1.setScene(scene);
			stage1.setTitle("Schermata Ricerca Stelle In Filamento");
			stage1.show(); 
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	 }}catch(Exception e2) {
		 Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("Inserire i campi nella maniera adeguata.");
			alert.showAndWait();
			System.out.println("Gli elementi non sono stati inseriti nel modo corretto");
	}
	}
	public static ArrayList<Double> pushValori(){
		return Valori;
	}
}
