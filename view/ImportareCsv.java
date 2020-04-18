package application.view;


import application.ImportoCsv;
import application.model.TipoFileCsv;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ImportareCsv {
	@FXML
	public Button closeButton;
	@FXML
	public TextField pathCsv;
	@FXML
	private ComboBox<TipoFileCsv> tipo;
	String fileCsv,path;
	@FXML
	private void initialize() {
		ObservableList<TipoFileCsv> tipo= FXCollections.observableArrayList(TipoFileCsv.values());
		this.tipo.setItems(tipo);
		this.tipo.valueProperty().addListener((observable, oldValue, newValue) -> 
			fileCsv = (newValue.toString()));
		
	}
	@FXML
    public void chiudi(ActionEvent event) {
		// implementazione del pulsante per chiudere la finestra attuale
	    Stage stage = (Stage) closeButton.getScene().getWindow();
		System.out.println("Pagina Chiusa con successo");
	    stage.close();
	}
	public void importa() {
	try {
		path =pathCsv.getText().toString();
		System.out.println(path);
		 ImportoCsv Csv = new ImportoCsv();
		Csv.scanCsv(fileCsv, path);
		System.out.println("CSV importato");
	    Stage stage = (Stage) closeButton.getScene().getWindow();
	    stage.close();
	}catch(Exception e) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("");
		alert.setHeaderText("Attenzione!");
		alert.setContentText("I dati inseriti non sono stati inseriti nella maniera adeguata");
		alert.showAndWait();
	}
	}
}
