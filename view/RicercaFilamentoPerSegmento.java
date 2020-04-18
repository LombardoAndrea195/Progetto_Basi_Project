package application.view;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
import application.bean.FilamentoBean;
import application.bean.PuntoSegmentoBean;
//import application.bean.SegmentoBean;
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

public class RicercaFilamentoPerSegmento {

		
		@FXML
		private TextField Min;
		@FXML
		private TextField Max;
		@FXML
		private Main main;
		@FXML
		private Stage stage;
		@FXML
		public Button ok;
		
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
			System.out.println("Pagina chiusa con successo");
		    stage.close();
		}
		
		public void ricercaNumeroSegmentiFilamento(ActionEvent event) {
			try {
				
			
			PuntoSegmentoBean segmentoMin=new PuntoSegmentoBean();
			PuntoSegmentoBean segmentoMax=new PuntoSegmentoBean();

			
			segmentoMin.setOrdineProgressivo((Integer.parseInt(Min.getText())));
			segmentoMax.setOrdineProgressivo((Integer.parseInt(Max.getText())));
			if (segmentoMax.getOrdineProgressivo()-segmentoMin.getOrdineProgressivo()<=2 || segmentoMax.getOrdineProgressivo()<=segmentoMin.getOrdineProgressivo()) {
				Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
				alert.setHeaderText("Attenzione!");
			alert.setContentText("Hai inserito un intervallo troppo basso, deve essere maggiore di 2 ");
			System.out.println("Hai inserito un intervallo troppo basso: deve essere maggiore di 2");
			alert.showAndWait();
			

			}
			else {
				Valori=Controller.PrendiDatiFilamento(segmentoMin.getOrdineProgressivo(),segmentoMax.getOrdineProgressivo());
				Stage stage = (Stage) closeButton.getScene().getWindow();
			    stage.close();
				AnchorPane root;
				try {
					root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/view/SchermataRicercaPerSegmento.fxml"));
					Scene scene = new Scene(root);
					Stage stage1 = new Stage();
					stage1.setScene(scene);
					stage1.setTitle("Schermata Ricerca Filamento Per Numero Segmenti");
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
			}	
				
		}
	 	
			public static ArrayList<FilamentoBean> pushValori(){
				return Valori;
			}
			    
			    

}
