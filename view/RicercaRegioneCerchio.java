package application.view;

import java.util.ArrayList;

import application.bean.FilamentoBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class RicercaRegioneCerchio {
	@FXML
	private Button closeButton;
	   @FXML 
	   private TableView<FilamentoBean> table=new TableView<FilamentoBean>();
	   
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
	    public static ArrayList<FilamentoBean> valori= new ArrayList<FilamentoBean>();
	    RicercaSuRegione Ricerca= new RicercaSuRegione();
	    @FXML
		public void initialize(){
			valori=Ricerca.pushValori();
			listaFilamenti=FXCollections.observableArrayList(valori);
			table.setItems(listaFilamenti);
	        Nome.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
			
	        Id.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());

	        FlussoTotale.setCellValueFactory(cellData -> cellData.getValue().getFlussoProperty());

	        Ellitticita.setCellValueFactory(cellData -> cellData.getValue().getEllitticit‡Property());

	        TemperaturaMedia.setCellValueFactory(cellData -> cellData.getValue().getTemperaturaProperty());

	        DensitaMedia.setCellValueFactory(cellData -> cellData.getValue().getDensit‡Property());

	    }
		@FXML
		private void handleOK() {
			Stage stage = (Stage) closeButton.getScene().getWindow();
		    stage.close();
		}
		
		
	}
