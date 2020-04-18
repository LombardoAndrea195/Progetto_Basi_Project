package application.view;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SchermataDistanzaSegmentoContorno {
	@FXML
	private Button closeButton;
	@FXML
	private Stage stage;
	@FXML
	private Label distanzaVMin;
	@FXML
	private Label distanzaVMax;
	public static ArrayList<String> valori = new ArrayList<String>();
	@FXML
	public void initialize() {
		
		valori= RicercaDistanzaVerticiSegmentoContorno.pushValori();
		System.out.println(valori);
		distanzaVMax.setText(valori.get(0));
		distanzaVMin.setText(valori.get(1));
	
		
	}
	

	public void chiudi(ActionEvent event) {
		// implementazione del pulsante per chiudere la finestra attuale
	    Stage stage = (Stage) closeButton.getScene().getWindow();
	    stage.close();
}
}
