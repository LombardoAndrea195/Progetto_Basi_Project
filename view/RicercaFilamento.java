package application.view;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
//import application.bean.ContornoBean;
import application.bean.FilamentoBean;
//import application.bean.SegmentoBean;
import application.control.Controller;
import application.exception.CampiNonCompilati;
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

public class RicercaFilamento {

	
	@FXML
	private TextField Id;
	@FXML
	private TextField Nome;
	@FXML
	private Main main;
	@FXML
	private Stage stage;
	@FXML
	public Button closeButton;
	
	public  static ArrayList<String> Valori= new ArrayList<String>();
	
	public void setMain(Main main) {
		this.main = main;
	}

	public void setStage(Stage loginStage) {
		this.stage = loginStage;
	}
	public void chiudi(ActionEvent event) {
		// implementazione del pulsante per chiudere la finestra attuale
	    Stage stage = (Stage) closeButton.getScene().getWindow();
	    System.out.println("Pagina chiusa con successo");
	    stage.close();
	}
	
	public void ricercaIdFilamento(ActionEvent event) {
		try {
		FilamentoBean filamento=new FilamentoBean();
		//ContornoBean contorno=new ContornoBean();
		//SegmentoBean segmento =new SegmentoBean();
		if( Id.getText()==null ) {
			

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("campi incompleti... inserire tutti i campi.");
			alert.showAndWait();}
		 else {
		filamento.setIdFilamento(Integer.parseInt(Id.getText()));
		Valori=Controller.PrendiDatiFilamentoId(filamento.getIdFilamento());
			Stage stage = (Stage) closeButton.getScene().getWindow();
		    stage.close();
			AnchorPane root;
			try {
				root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/SchermataRicercaFilamento.fxml"));
				Scene scene = new Scene(root);
				Stage stage1 = new Stage();
				stage1.setScene(scene);
				stage1.setTitle("Schermata Filamento");
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
	
	public  void ricercaNomeFilamento(ActionEvent event) {
		try {
		FilamentoBean filamento=new FilamentoBean();
		//ContornoBean contorno=new ContornoBean();
		//SegmentoBean segmento =new SegmentoBean();
		filamento.setNome(Nome.getText());
			
if(  Nome.getText().isEmpty()) {
			

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("campi incompleti... inserire tutti i campi.");
			alert.showAndWait();}
		 else {
		try {
			Valori=Controller.PrendiDatiFilamentoNome(filamento.getNome());
		} catch (CampiNonCompilati e1) {
			
			e1.printStackTrace();
		}
			
			
			Stage stage = (Stage) closeButton.getScene().getWindow();
		    stage.close();
			try {			
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/SchermataRicercaFilamento.fxml"));
				Scene scene = new Scene(root);
				Stage stage1 = new Stage();
				stage1.setScene(scene);
				stage1.setTitle("Schermata Filamento");
				stage1.show();
		}catch(IOException e){
			e.printStackTrace();
		}
		 }
		}catch(Exception e2) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("Inserire i campi nella maniera adeguata.");
			alert.showAndWait();
			System.out.println("Gli elementi non sono stati inseriti nel modo corretto");
}}
			
	
		 	
		public static ArrayList<String> pushValori(){
			return Valori;
		}
		    
		    
		
	
	
	 public void cancella() {
 		// utile per pulire i campi
     	Id.setText("");
 		Nome.setText("");
	 }
}
