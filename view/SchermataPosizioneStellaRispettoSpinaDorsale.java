package application.view;

import java.util.ArrayList;

//import application.bean.FilamentoBean;
import application.bean.StellaBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SchermataPosizioneStellaRispettoSpinaDorsale {
	@FXML
	private Button closeButton;
	   @FXML 
	   private TableView<StellaBean> table=new TableView<StellaBean>();
	   private Stage stage;
	    @FXML
	    private TableColumn<StellaBean, String> Id=new TableColumn<StellaBean, String>();
	    
	    @FXML
	    private TableColumn<StellaBean,String> FlussoTotale=new TableColumn<StellaBean, String>();
	    @FXML
	    private TableColumn<StellaBean,Double> Distanza=new TableColumn<StellaBean, Double>();
	    
	    public static  ObservableList<StellaBean> listaStelle =FXCollections.observableArrayList();
	    public static  int i=0;
	    public static ArrayList<StellaBean> valori= new ArrayList<StellaBean>();
	    public static ArrayList<StellaBean> valori2=new ArrayList<StellaBean>();
	    PosizioneStellaRispettoSpinaDorsale Ricerca= new PosizioneStellaRispettoSpinaDorsale();
	    @FXML
		public void initialize(){
	    	try {
	    	
	    	i=0;
			valori=PosizioneStellaRispettoSpinaDorsale.pushValori();
			valori2.clear();
			System.out.println(valori.size());
			for (i=0;i<20;i++) {
				valori2.add(valori.get(i));
			}
			listaStelle=FXCollections.observableArrayList(valori2);
			table.setItems(listaStelle);
	     
			
	        Id.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());

	        FlussoTotale.setCellValueFactory(cellData -> cellData.getValue().getFlussoProperty());

	       Distanza.setCellValueFactory(cellData -> cellData.getValue().getDistanzaProperty().asObject());

	        
	    	}catch(Exception e) {
	    		Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("");
				alert.setHeaderText("Attenzione!");
				alert.setContentText("IL VALORE INSERITO HA 0 RISULTATI");
				alert.showAndWait();
	    	}
	    }
	    @FXML
	    public void next() {
	    	
			valori=PosizioneStellaRispettoSpinaDorsale.pushValori();
			
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
					alert.setContentText("Sei arrivato alla fine della lista..puoi tornare solo indietro");
					alert.showAndWait();
					break;}
				
			}
			listaStelle=FXCollections.observableArrayList(valori2);
			table.setItems(listaStelle);
	     
			
	        Id.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());

	        FlussoTotale.setCellValueFactory(cellData -> cellData.getValue().getFlussoProperty());

	       Distanza.setCellValueFactory(cellData -> cellData.getValue().getDistanzaProperty().asObject());
	    }
	    @FXML
	    public void previous() {
	    	
			valori=PosizioneStellaRispettoSpinaDorsale.pushValori();
			System.out.println("Pagina Aggiornata: Attendi i risultati");
			valori2.clear();
			int s=i;//i=80
			if(s-20>=20) {
				
			
			int q=i-20;
			for (int x=q;x<s;x++) {
				valori2.add(valori.get(x));
				i--;
			}
			listaStelle=FXCollections.observableArrayList(valori2);
			table.setItems(listaStelle);
	     
			
	        Id.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());

	        FlussoTotale.setCellValueFactory(cellData -> cellData.getValue().getFlussoProperty());

	       Distanza.setCellValueFactory(cellData -> cellData.getValue().getDistanzaProperty().asObject());
	    }
	    
	    else {
	    	Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("POTREBBERO ESSERCI MENO DI 20 ELEMENTI");
			alert.showAndWait();
			valori=PosizioneStellaRispettoSpinaDorsale.pushValori();
			valori2.clear();
			int p=i;//i=80
			if(p-20<20) {
				initialize();
			}
			else if(p-20>=20) {
				
			System.out.println(i);
			int q=i-20;
			for (int x=q;x<p;x++) {
				valori2.add(valori.get(x));
				i--;
			}
			listaStelle=FXCollections.observableArrayList(valori2);
			table.setItems(listaStelle);
	     
			
			
	        Id.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());

	        FlussoTotale.setCellValueFactory(cellData -> cellData.getValue().getFlussoProperty());

	       Distanza.setCellValueFactory(cellData -> cellData.getValue().getDistanzaProperty().asObject());
	    
			}}
			}
	    
		@FXML
		private void handleOK() {
			Stage stage = (Stage) closeButton.getScene().getWindow();
		    System.out.println("Pagina Chiusa con successo!");
			stage.close();
		}
		
		public void setStage(Stage stage) {
			this.stage = stage;
		}
		
		
	}


