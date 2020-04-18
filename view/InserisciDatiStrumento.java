package application.view;

import application.Main;
import application.bean.BandaBean;
import application.bean.StrumentoBean;
//import application.bean.UtenteBean;
import application.control.Controller;
//import application.exception.CampiLoginVuotiException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class InserisciDatiStrumento {
	@FXML
	private TextField NomeStrumento;
	@FXML
	private TextField LunghezzaOnda;
	@FXML
	private Button closeButton;
	@FXML
	private Stage stage;
	@FXML
	private Main main;
	
	
	
	public void chiudi(ActionEvent event) {
		// implementazione del pulsante per chiudere la finestra attuale
	    Stage stage = (Stage) closeButton.getScene().getWindow();
	    System.out.println("Pagina chiusa con successo");
	    stage.close();
	}
	

public void setMain(Main main) {
	this.main = main;
}

public void setStage(Stage registraStage) {
	this.stage = registraStage;
}


 public void cancella() {
		// utile per pulire i campi
 	NomeStrumento.setText("");
		LunghezzaOnda.setText("");
		 }

 
 public void  registraStrumento(ActionEvent event) {
	 //collegare i bottoni e altre strutture fxml
	 StrumentoBean u=new StrumentoBean();
	 try {
		 Double LunghezzaOndaFloat = Double.valueOf(LunghezzaOnda.getText()).doubleValue(); 
		 
		 u.setNome(NomeStrumento.getText());
		 
		 BandaBean banda=new BandaBean();
		 banda.setLunghezzaonda(LunghezzaOndaFloat);
			
	 
	
	 if (NomeStrumento.getText()==null || LunghezzaOnda.getText()==null){
			
 		String message = "Errore: Inserire tutti i campi";
			
 		Alert alert = new Alert(AlertType.ERROR);
 		alert.setTitle("Errore");
	    alert.setHeaderText("Attenzione: errore credenziali.");
	    alert.setContentText(message);
	    alert.showAndWait();

 		System.out.println(message);
 }
	 
	 
	 else {
	
	
		Controller.InserisciDati(u.getNome(),banda.getLunghezzaonda());
		Stage stage = (Stage) closeButton.getScene().getWindow();
	    stage.close();
 
}}catch(Exception e2) {
	Alert alert = new Alert(AlertType.ERROR);
	alert.setTitle("");
	alert.setHeaderText("Attenzione!");
	alert.setContentText("Inserire i campi nella maniera adeguata.");
	alert.showAndWait();
	System.out.println("Gli elementi non sono stati inseriti nel modo corretto");
}
 }
 
 
 
}