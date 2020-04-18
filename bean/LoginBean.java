package application.bean;
import java.io.IOException;

import application.Main;
// Bean deve essere collegato con il controller e la view e non deve avere costruttori
import application.control.ControllerLogin;
import application.model.Utente;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginBean {
	private String Type;
	private String username;
	private String password;
	
	public UtenteBean validate() {
		ControllerLogin controller = ControllerLogin.getInstance();
		synchronized(controller) 
		{
			try{
			
		
			UtenteBean found = controller.login(this.username, this.password); 
			this.setType(found.getType());
			System.out.println("Loggato come:");
			System.out.println("ID:"+username+"   "+"password:"+password);
			
			return found;
				}
		catch(NullPointerException e) {
			
			
		
			System.out.println("L'utente selezionato non è presente nella lista del database");
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("");
			alert.setHeaderText("Attenzione!");
			alert.setContentText("ACCESSO NEGATO.");
			alert.showAndWait();
			
			
			
		
		return null;
		}}}
	
	
	public String getType() {
		return Type;
	}
	public void setType(String Type) {
		this.Type = Type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	

}
