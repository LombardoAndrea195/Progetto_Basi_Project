package application.view;

import java.util.ArrayList;


import application.bean.FilamentoBean;
import application.bean.StellaBean;
//import application.control.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SchermataRicercaBrillantezza {
	@FXML
	private Button closeButton;
	   @FXML 
	   private TableView<FilamentoBean> table=new TableView<FilamentoBean>();
	   private Stage stage;
	    @FXML
	    private TableColumn<FilamentoBean, String> Id=new TableColumn<FilamentoBean, String>();
	    @FXML
	    private TableColumn<FilamentoBean, String> Nome=new TableColumn<FilamentoBean, String>();
	    @FXML
	    private TableColumn<FilamentoBean,String> FlussoTotale=new TableColumn<FilamentoBean, String>();
	    @FXML
	    private TableColumn<FilamentoBean,String> Ellitticita=new TableColumn<FilamentoBean, String>();
	    @FXML
	    private TableColumn<FilamentoBean,String>  TemperaturaMedia=new TableColumn<FilamentoBean, String>();
	    @FXML
	    private TableColumn<FilamentoBean,String> DensitaMedia=new TableColumn<FilamentoBean, String>();
	    public static  ObservableList<FilamentoBean> listaFilamenti =FXCollections.observableArrayList();
	    public static int i=0;
	    public static ArrayList<FilamentoBean> valori2=new ArrayList<FilamentoBean>();
	    public static ArrayList<FilamentoBean> valori= new ArrayList<FilamentoBean>();
	    RicercaBrillantezza Ricerca= new RicercaBrillantezza();
	    @FXML
		public void initialize(){
	    	try {
	    	i=0;
			valori=RicercaBrillantezza.pushValori();
			valori2.clear();
			for (i=0;i<20;i++) {
				valori2.add(valori.get(i));
			}
			listaFilamenti=FXCollections.observableArrayList(valori2);
			table.setItems(listaFilamenti);
	        Nome.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
			
	        Id.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());

	        FlussoTotale.setCellValueFactory(cellData -> cellData.getValue().getFlussoProperty());

	        Ellitticita.setCellValueFactory(cellData -> cellData.getValue().getEllitticit‡Property());

	        TemperaturaMedia.setCellValueFactory(cellData -> cellData.getValue().getTemperaturaProperty());

	        DensitaMedia.setCellValueFactory(cellData -> cellData.getValue().getDensit‡Property());
	    	}catch(Exception e) {
	    		Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("");
				alert.setHeaderText("Attenzione!");
				alert.setContentText("IL VALORE INSERITO HA 0 RISULTATI");
				alert.showAndWait();
	    	}
	    } public void next() {
	    	System.out.println("Pagina aggiornata:Attendi i risultati");
			valori=RicercaBrillantezza.pushValori();
			valori2.clear();
			int s=i;
			int q=i;
			for ( int x=q;x<s+20;x++) {
				if(i==valori.size()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("");
					alert.setHeaderText("Attenzione!");
					alert.setContentText("MI DISPIACE PUOI SOLO TORNARE INDIETRO PERCHE' NON CI SONO PIU ELEMENTI NELLA LISTA");
					alert.showAndWait();
					break;
				}
				valori2.add(valori.get(i));
				i++;
				if(i-valori.size()==0) {
				
		    		Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("");
					alert.setHeaderText("Attenzione!");
					alert.setContentText("IL VALORE INSERITO HA 0 RISULTATI");
					alert.showAndWait();
					break;
				}
			}
			listaFilamenti=FXCollections.observableArrayList(valori2);
			table.setItems(listaFilamenti);
	     
			  Nome.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
				
		        Id.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());

		        FlussoTotale.setCellValueFactory(cellData -> cellData.getValue().getFlussoProperty());

		        Ellitticita.setCellValueFactory(cellData -> cellData.getValue().getEllitticit‡Property());

		        TemperaturaMedia.setCellValueFactory(cellData -> cellData.getValue().getTemperaturaProperty());

		        DensitaMedia.setCellValueFactory(cellData -> cellData.getValue().getDensit‡Property());
	    }
	    @FXML
	    public void previous() {
	    	System.out.println("Pagina aggiornata con successo:Attendi i risultati");
			valori=RicercaBrillantezza.pushValori();
			valori2.clear();
			int s=i;//i=80
			if(s-20>=20) {
				
			
			int q=i-20;
			for (int x=q;x<s;x++) {
				valori2.add(valori.get(x));
				i--;
			}
			listaFilamenti=FXCollections.observableArrayList(valori2);
			table.setItems(listaFilamenti);
	     
			
			  Nome.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
				
		        Id.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());

		        FlussoTotale.setCellValueFactory(cellData -> cellData.getValue().getFlussoProperty());

		        Ellitticita.setCellValueFactory(cellData -> cellData.getValue().getEllitticit‡Property());

		        TemperaturaMedia.setCellValueFactory(cellData -> cellData.getValue().getTemperaturaProperty());

		        DensitaMedia.setCellValueFactory(cellData -> cellData.getValue().getDensit‡Property());
	    }
	    
	    else {
	    	Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("SARANNO INSERITI MENO DI 20 ELEMENTI");
			alert.showAndWait();
			valori=RicercaBrillantezza.pushValori();
			valori2.clear();
			int p=i;//i=80
			if(p-20<20) {
				initialize();
			}
			else if(p-20>=20) {
				
			
			int q=i-20;
			for (int x=q;x<p;x++) {
				valori2.add(valori.get(x));
				i--;
			}
			listaFilamenti=FXCollections.observableArrayList(valori2);
			table.setItems(listaFilamenti);
	     
			  Nome.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
				
		        Id.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());

		        FlussoTotale.setCellValueFactory(cellData -> cellData.getValue().getFlussoProperty());

		        Ellitticita.setCellValueFactory(cellData -> cellData.getValue().getEllitticit‡Property());

		        TemperaturaMedia.setCellValueFactory(cellData -> cellData.getValue().getTemperaturaProperty());

		        DensitaMedia.setCellValueFactory(cellData -> cellData.getValue().getDensit‡Property());
	    
			}}
			}
	    
		@FXML
		private void handleOK() {
			Stage stage = (Stage) closeButton.getScene().getWindow();
			System.out.println("Chiusa pagina con successo");
			stage.close();
		}
		
		public void setStage(Stage stage) {
			this.stage = stage;
		}
		
		
	}

