package application.view;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
//import application.bean.FilamentoBean;
//import application.bean.StellaBean;
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

public class RicercaStelle {
	//requisito 10
	@FXML
	private TextField Lato1;
	@FXML
	private TextField Lato2;
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
	
	public  static 		ArrayList<Double> stelle = new ArrayList<Double>();

	
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
	
		    
	
	public  void ricercaStelleSuRettangolo(ActionEvent event) throws CampiNonCompilati {
		try {
		
		Double lato1=Double.parseDouble(Lato1.getText());
		Double latitudine=Double.parseDouble(posizioneLat.getText());
		Double longitudine=Double.parseDouble(posizioneLong.getText());
		Double lato2=Double.parseDouble(Lato2.getText());
		if( posizioneLong.getText()==null || posizioneLong.getText().isEmpty()|| Lato1.getText().isEmpty()||Lato2.getText().isEmpty()) {
			

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("campi incompleti... inserire tutti i campi.");
			alert.showAndWait();}
		else if(latitudine-lato1<=0 ||latitudine-lato2<=0 ||longitudine-lato1<=0 ||longitudine-lato2<=0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("I campi inseriti non mi permettono di fare una ricerca adeguata."
					+ "Riprova con i lati del rettangolo più piccoli");
			alert.showAndWait();
			
		}		
		else 
		 {	
		stelle=Controller.RicercaSuRettangolo(lato1,lato2,latitudine,longitudine);
		Stage stage = (Stage) closeButton.getScene().getWindow();
		    stage.close();
			try {			
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/SchermataRicercaStelleRettangolo.fxml"));
				Scene scene = new Scene(root);
				Stage stage1 = new Stage();
				stage1.setScene(scene);
				stage1.setTitle("Schermata Ricerca Stelle");
				stage1.show();
		}catch(IOException e){
			e.printStackTrace();
		}}
		}catch(Exception e2) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("Inserire i campi nella maniera adeguata.");
			alert.showAndWait();
			System.out.println("Gli elementi non sono stati inseriti nel modo corretto");
		}
}
	
	
		 	
		public static ArrayList<Double> pushValori(){
			return stelle;
		}
		    
}		    
		
	
	
	
