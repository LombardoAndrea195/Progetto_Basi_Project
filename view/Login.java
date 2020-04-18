package application.view;

//import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import application.Main;
import application.bean.LoginBean;
import application.bean.UtenteBean;
import application.exception.*;
import application.model.Utente;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Login {
	String tipo;
	@FXML
	private TextField user;
	@FXML
	private TextField password;
	@FXML
	private Main main;
	@FXML
	private Stage stage;
	@FXML
	private void handleEsci() {
		System.out.println("Uscito dal sistema con successo");
	System.exit(0);
	}
	
	public void setMain(Main main) {
		this.main = main;
	}

	public void setStage(Stage loginStage) {
		this.stage = loginStage;
	}
	
	
	
	 public void cancella() {
 		// utile per pulire i campi
     	user.setText("");
 		password.setText("");
 		System.out.println("Reset campi avvenuto con successo");
 		
	 }
	 public void accedi(ActionEvent event) throws UtenteNonTrovatoException,NullPointerException {
			//collegare i bottoni e altre strutture fxml
			 String user = this.user.getText();
			String pass = this.password.getText();
		
			if( user.isEmpty() || pass.isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("");
				alert.setHeaderText("Attenzione!");
				alert.setContentText("Per effettuare il login inserire username e password.");
				alert.showAndWait();
				
}
			else {
			LoginBean loginBean=new LoginBean();
			loginBean.setUsername(user);
			loginBean.setPassword(pass);
			System.out.println("Tentativo di accedere con i seguenti dati:");
			System.out.println("ID:"+user+"        "+"password:"+pass);
			try {
			UtenteBean bean=loginBean.validate();

			this.stage.close();
			
				
			tipo=bean.getType();
			
			
			if (tipo.equals("Amministratore")) {
					this.main.showHomeAmministratore(loginBean);
					System.out.println("Loggato come Amministratore");
					}
			else if (tipo.equals("Utente")) {
					this.main.showHomeUtente(loginBean);
					System.out.println("Loggato come Utente");
			} 

				
			}catch(NullPointerException e) {
				
				//e.printStackTrace();
				this.main.apriSchermataErrore();
				System.out.println("Errore nell'accesso ");
			}
				}
 	
	 
}}
	