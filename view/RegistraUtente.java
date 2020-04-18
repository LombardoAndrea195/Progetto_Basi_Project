package application.view;


import application.Main;
import application.bean.UtenteBean;
import application.control.Controller;
import application.exception.CampiLoginVuotiException;
import application.model.TipoFileCsv;
import application.model.TipoUtenti;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import application.model.Utente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class RegistraUtente {
	String tipo;
	@FXML
	private TextField user;
	@FXML
	private TextField password;
	@FXML
	private TextField email;
	@FXML
	private TextField nome;
	@FXML
	private TextField cognome;
	@FXML
	private Main main;
	@FXML
	private Button closeButton;
	@FXML
	private Stage stage;
	@FXML
	private ComboBox<TipoUtenti> tipoUt;

	private String tipoUtente;
	@FXML
	private void initialize() {
		ObservableList<TipoUtenti> tipoUt= FXCollections.observableArrayList(TipoUtenti.values());
		this.tipoUt.setItems( tipoUt);
		this.tipoUt.valueProperty().addListener((observable, oldValue, newValue) -> 
		tipoUtente = (newValue.toString()));
	}
	@FXML
	private void handleEsci() {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		System.out.println("Pagina chiusa con successo");
		stage.close();;
	}
	public void setMain(Main main) {
		this.main = main;
	}

	public void setStage(Stage registraStage) {
		this.stage = registraStage;
	}
	
	
	 public void cancella() {
 		// utile per pulire i campi
     	user.setText("");
 		password.setText("");
 		email.setText("");
 		nome.setText("");
 		cognome.setText("");
 		System.out.println("Reset eseguito con successo");
	 }
	
	 
	 public void  registra11(ActionEvent event) {
		 //collegare i bottoni e altre strutture fxml
		 UtenteBean u=new UtenteBean();
		 u.setUserid(user.getText());
		 u.setPassword(password.getText());
		 u.setEmail(email.getText());
		 u.setNome(nome.getText());
		 u.setCognome(cognome.getText());
		 u.setType(tipoUtente);
		
		 if (u.getUserid().length()<6 || u.getPassword().length()<6){
			
		    		String message = "Errore: nome utente o password troppo corti";
					
		    		Alert alert = new Alert(AlertType.ERROR);
		    		alert.setTitle("Errore");
			    alert.setHeaderText("Attenzione: errore credenziali.");
			    alert.setContentText(message);
			    alert.showAndWait();

		    		System.out.println(message);
		    }
		 else  if( user.getText()==null || password.getText().isEmpty()|| email.getText().isEmpty()|| nome.getText().isEmpty()||cognome.getText().isEmpty()) {
					

					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("");
					alert.setHeaderText("Attenzione!");
					alert.setContentText("campi incompleti... inserire tutti i campi.");
					alert.showAndWait();}
	 else {
		try{
			if( u.getUserid().isEmpty() || u.getCognome().isEmpty()||u.getEmail().isEmpty()||u.getPassword().isEmpty()||u.getNome().isEmpty()) {
			throw new CampiLoginVuotiException();
			
			} 
			Controller.InserisciUtente(u.getNome(), u.getCognome(),u.getPassword(),u.getUserid(),u.getType(),u.getEmail(),u.getType());
			Stage stage = (Stage) closeButton.getScene().getWindow();
		    stage.close();
		    
	 }catch(Exception e) 
		{ e.printStackTrace(); }
}}
	 
}
