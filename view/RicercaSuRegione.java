package application.view;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
import application.bean.FilamentoBean;
import application.control.Controller;
import application.exception.CampiNonCompilati;
//import application.model.Filamento;
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

public class RicercaSuRegione {
	//REQUISITO 8

	
	@FXML
	private TextField Lato;
	@FXML
	private TextField Raggio;
	@FXML
	private TextField posizioneLat;
	@FXML
	private TextField posizioneLong;
	@FXML
	private Main main;
	@FXML
	private Stage stage;
	@FXML
	public Button closeButton;
	
	public  static ArrayList<FilamentoBean> Valori= new ArrayList<FilamentoBean>();
	

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
	
	public void ricercaConRaggio(ActionEvent event) {
		try {
		Double raggio=Double.parseDouble(Raggio.getText());
		Double latitudine=Double.parseDouble(posizioneLat.getText());
		Double longitudine=Double.parseDouble(posizioneLong.getText());
		 if( posizioneLong.getText()==null || posizioneLong.getText().isEmpty()|| Raggio.getText().isEmpty()) {
		

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("campi incompleti... inserire tutti i campi.");
			alert.showAndWait();}
		 else {
		Valori=Controller.RicercaSuCerchio(raggio,latitudine,longitudine);
			Stage stage = (Stage) closeButton.getScene().getWindow();
		    stage.close();
			AnchorPane root;
			try {
				root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/RicercaRegioneCerchio.fxml"));
				Scene scene = new Scene(root);
				Stage stage1 = new Stage();
				stage1.setScene(scene);
				stage1.setTitle("Schermata Ricerca Per Cerchio");
				stage1.show(); 
			} catch (IOException e) {
				
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
	    
	
	public  void ricercaFilamentoSuQuadrato(ActionEvent event) throws CampiNonCompilati {
		
		try {
		Double lato=Double.parseDouble(Lato.getText());
		Double latitudine=Double.parseDouble(posizioneLat.getText());
		Double longitudine=Double.parseDouble(posizioneLong.getText());
		if( posizioneLong.getText()==null || posizioneLong.getText().isEmpty()|| Lato.getText().isEmpty()) {
			

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("campi incompleti... inserire tutti i campi.");
			alert.showAndWait();}
		 else {
		Valori=Controller.RicercaSuQuadrato(lato,latitudine,longitudine);
			
			
			Stage stage = (Stage) closeButton.getScene().getWindow();
		    stage.close();
			try {			
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/RicercaRegioneQuadratica.fxml"));
				Scene scene = new Scene(root);
				Stage stage1 = new Stage();
				stage1.setScene(scene);
				stage1.setTitle("Schermata Ricerca per Quadrato");
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
								System.out.println("Gli elementi non sono stati inseriti nel modo corretto");}
}
			
	
		 	
		public static ArrayList<FilamentoBean> pushValori(){
			return Valori;
		}
		    
		    
		
	
	
	

}
