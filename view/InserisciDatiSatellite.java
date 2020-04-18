package application.view;

//import java.sql.Date;
//import java.time.format.DateTimeFormatter;

import application.bean.AgenziaSpazialeBean;
import application.bean.SatelliteBean;
import application.control.Controller;
import application.exception.CampiNonCompilati;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class InserisciDatiSatellite {

	@FXML
	private TextField nomeSatellite;
	@FXML
	private DatePicker dataInizio;
	@FXML
	private DatePicker dataFine;
	@FXML
	private TextField NomeAgenzia;
	@FXML
	private Stage stage;
	@FXML
	private Button closeButton;
	
	
	

	public void chiudi(ActionEvent event) {
		// implementazione del pulsante per chiudere la finestra attuale
	    Stage stage = (Stage) closeButton.getScene().getWindow();
		System.out.println("Pagina chiusa con Successo!");
	    stage.close();
	}
	
	
	public void inserisciDati(ActionEvent event) throws CampiNonCompilati, Exception {
	
	
			
		try {
		SatelliteBean sat=new SatelliteBean();
		AgenziaSpazialeBean Agenzia=new AgenziaSpazialeBean();
		Agenzia.setNome(NomeAgenzia.getText());
		sat.setNomeAgenzia(Agenzia);
		sat.setNome(nomeSatellite.getText());
		java.util.Date DataInizio = (java.util.Date) java.sql.Date.valueOf(this.dataInizio.getValue());
		sat.setDataInizio(DataInizio);
		
		String d=dataInizio.getEditor().getText();
		//java.util.Date DataFine = (java.util.Date) java.sql.Date.valueOf(this.dataFine.getValue());
		//sat.setDataFine(DataFine);
		if( nomeSatellite.getText()==null || NomeAgenzia.getText().isEmpty() || d.isEmpty()  ) {
			

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("campi incompleti... Attenzione inserire tutti i campi nella maniera corretta e nell'eventualità qualore  il valore di data fine non sia presente  può essere nullo.");
			alert.showAndWait();
			}
		else {
				
		String date = dataFine.getEditor().getText();
		if (date.isEmpty()) {
			sat.setDataString(null);
			
			Controller.InserisciDatiSat(sat.getDataInizio(),sat.getDataString(), sat.getNome(),Agenzia.getNome());
			Stage stage = (Stage) closeButton.getScene().getWindow();
		    stage.close();
		}
		else {
			
		
		sat.setDataString(date);

	
			
		//catch(NullPointerException ex) {
			//java.util.Date DataEccezionee = (java.util.Date) java.sql.Date.valueOf();
		
		
				 
				Controller.InserisciDatiSat(sat.getDataInizio(),sat.getDataString(), sat.getNome(),Agenzia.getNome());
				Stage stage = (Stage) closeButton.getScene().getWindow();
			    stage.close();
		 
			 	}
		 
}}catch(Exception e2) {
	Alert alert = new Alert(AlertType.ERROR);
	alert.setTitle("");
	alert.setHeaderText("Attenzione!");
	alert.setContentText("Inserire i campi nella maniera adeguata.");
	alert.showAndWait();
	System.out.println("Gli elementi non sono stati inseriti nel modo corretto");}
	}}