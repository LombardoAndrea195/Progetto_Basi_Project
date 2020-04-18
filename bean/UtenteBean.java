package application.bean;

//import java.sql.SQLException;

//import application.control.Controller;
//import application.control.ControllerLogin;
//import application.exception.CampiNonCompilati;
//import application.exception.UtenteEsistenteException;
//import application.model.Utente;



public class UtenteBean {
	private String userid;
	private String password;
	private String nome;
	private String cognome;
	private String email;
	private String Type;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}

}
