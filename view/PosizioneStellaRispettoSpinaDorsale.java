package application.view;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
//import application.bean.ContornoBean;
import application.bean.FilamentoBean;
import application.bean.StellaBean;
import application.control.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PosizioneStellaRispettoSpinaDorsale {

	@FXML
	private TextField Id;
	@FXML
	private Main main;
	@FXML
	private Stage stage;
	
	
	@FXML
	public Button closeButton;
	
	public  static ArrayList<StellaBean> valori= new ArrayList<StellaBean>();
	
	public void setMain(Main main) {
		this.main = main;
	}

	public void setStage(Stage loginStage) {
		this.stage = loginStage;
	}
	public void chiudi(ActionEvent event) {
		// implementazione del pulsante per chiudere la finestra attuale
	    Stage stage = (Stage) closeButton.getScene().getWindow();
	    stage.close();
}
	
	public void  ricercaDistanza(ActionEvent event) throws ClassNotFoundException {
		
		FilamentoBean filamento= new FilamentoBean();
		try {
			
		
		filamento.setIdFilamento(Integer.parseInt(Id.getText()));}
		catch(Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("Inserire i campi nella maniera adeguata.");
			alert.showAndWait();
			System.out.println("Gli elementi non sono stati inseriti nel modo corretto");	
			return;
		}
		if( Id.getText()==null  ) {
		
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("campi incompleti... inserire tutti i campi.");
			alert.showAndWait();
	}
				else {
			
		
		valori=Controller.RicercaDistanzaStelleSpinaDorsale(filamento.getIdFilamento());
		
				Stage stage = (Stage) closeButton.getScene().getWindow();
	    			stage.close();
	    			
		
	    				AnchorPane root;
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/SchermataPosizioneStellaRispettoSpinaDorsale.fxml"));
			Scene scene = new Scene(root);
			Stage stage1 = new Stage();
			stage1.setScene(scene);
			stage1.setTitle("Schermata Ricerca Distanza Stella Rispetto Spina Dorsale");
			stage1.show(); 
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
				}
		
}
public void  ricercaDistanza2(ActionEvent event) throws ClassNotFoundException, LoadException {
		
		FilamentoBean filamento= new FilamentoBean();
		try {
			
			
			filamento.setIdFilamento(Integer.parseInt(Id.getText()));}
			catch(Exception e) {Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("Inserire i campi nella maniera adeguata.");
			alert.showAndWait();
			System.out.println("Gli elementi non sono stati inseriti nel modo corretto");
			return;
			}
		if( Id.getText()==null ) {
		
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("campi incompleti... inserire tutti i campi.");
			alert.showAndWait();
	}
				else {
			
		valori=Controller.RicercaDistanzaStelleSpinaDorsale2(filamento.getIdFilamento());
		
				Stage stage = (Stage) closeButton.getScene().getWindow();
	    			stage.close();
	    				AnchorPane root;
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/SchermataPosizioneStellaRispettoSpinaDorsale.fxml"));
			Scene scene = new Scene(root);
			Stage stage1 = new Stage();
			stage1.setScene(scene);
			stage1.setTitle("Schermata Ricerca Distanza Stella Rispetto Spina Dorsale");
			stage1.show(); 
		} catch (IOException e) {
			
			System.out.println("Eccezione di IO");
		}	}
		
}	



	public static ArrayList<StellaBean> pushValori(){
		return valori;
	}







}
