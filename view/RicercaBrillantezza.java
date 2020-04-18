package application.view;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
import application.bean.ContornoBean;
import application.bean.FilamentoBean;
import application.control.Controller;
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

public class RicercaBrillantezza {

	
	@FXML
	private TextField EllitticitaMin;
	@FXML
	private TextField EllitticitaMax;
	@FXML
	private TextField Brillantezza;
	@FXML
	private Main main;
	@FXML
	private Stage stage;
	
	
	@FXML
	public Button closeButton;
	
	public  static ArrayList<FilamentoBean> valori= new ArrayList<FilamentoBean>();
	
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
	
	public void  ricercaBrillantezza(ActionEvent event) {
		ContornoBean  contorno= new ContornoBean();
		FilamentoBean filamentoMin= new FilamentoBean();
		FilamentoBean filamentoMax= new FilamentoBean();
		try {

			filamentoMin.setEllitticità(Double.parseDouble(EllitticitaMin.getText()));
			filamentoMax.setEllitticità(Double.parseDouble(EllitticitaMax.getText()));
			
			
			double Contrasto=(1+(Double.parseDouble(Brillantezza.getText()))/100);

			
			contorno.setContrasto(Contrasto);
		}catch(Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("Inserire i campi nella maniera adeguata.");
			alert.showAndWait();
			System.out.println("Gli elementi non sono stati inseriti nel modo corretto");
			return;
			}

		
		if ( filamentoMin.getEllitticità()<=(double)1||filamentoMax.getEllitticità()>=(double)10) {
	 System.out.println("Errore nel range dei valori inseriti nell'ellitticità");
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("campi dell'elletticità non adeguati... inserire tutti i campi nel modo corretto.");
			alert.showAndWait();}
		else if( EllitticitaMax.getText()==null || EllitticitaMin.getText().isEmpty()|| Brillantezza.getText().isEmpty()) {
			

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("campi incompleti... inserire tutti i campi.");
			alert.showAndWait();
	}
				else {
			
		
		valori=Controller.RicercaBrillantezza(filamentoMin.getEllitticità(),filamentoMax.getEllitticità(),contorno.getContrasto());
		
				Stage stage = (Stage) closeButton.getScene().getWindow();
	    			stage.close();
	    				AnchorPane root;
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/SchermataRicercaBrillantezza.fxml"));
			Scene scene = new Scene(root);
			Stage stage1 = new Stage();
			stage1.setScene(scene);
			stage1.setTitle("Schermata Ricerca Filamento Per Numero Segmenti");
			stage1.show(); 
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
				}
		
}
	



	public static ArrayList<FilamentoBean> pushValori(){
		return valori;
	}












}
