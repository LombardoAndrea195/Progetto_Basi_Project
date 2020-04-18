package application;
	
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;


import application.view.Login;
import application.bean.LoginBean;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;



public class Main extends Application {
	
	private Stage primaryStage;
	@Override
	
	public void start(Stage primaryStage) {
		
		this.primaryStage=primaryStage;
		initRootLayout();
	}
	public void initRootLayout() {
		try {
			
			FXMLLoader loader= new FXMLLoader(Main.class.getResource("view/Login.fxml"));
			AnchorPane root=(AnchorPane)loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle("Login");
			primaryStage.setScene(scene);
			
			
			Login controller =loader.getController();
			controller.setMain(this);
			controller.setStage(primaryStage);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void showHomeAmministratore(LoginBean user){
		try {		
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/AccessoAmministratore.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();
			
			primaryStage.setTitle("HomeAmministratore");				
			primaryStage.setScene(new Scene(anchorPane));
			primaryStage.show();
		} catch(IOException e) {
			e.printStackTrace();
}
}
	public void showHomeUtente(LoginBean user){
		try {		
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/AccessoUtente.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();
			
			primaryStage.setTitle("HomeUtente");				
			primaryStage.setScene(new Scene(anchorPane));
		
			primaryStage.show();
		} catch(IOException e) {
			e.printStackTrace();	
}
	}
	public void apriSchermataErrore() {
		try {
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().
					getClassLoader().getResource("view/AccessoNegato.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
