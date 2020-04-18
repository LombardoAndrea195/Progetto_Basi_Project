package application.control;

import application.persistence.DaoUtente;
import application.bean.UtenteBean;
//import application.bean.UtenteBean;
import application.model.Utente;



public class ControllerLogin {
			
public static ControllerLogin instance = null;
	
	public ControllerLogin() {
	}
	
	public static ControllerLogin getInstance() {
		if(instance == null) {
			instance = new ControllerLogin();
		}
		return instance;
	}
	public UtenteBean login(String username, String password) {
		Utente u= DaoUtente.findUtente(username, password);
		UtenteBean Bean=new UtenteBean();
		Bean.setCognome(u.getCognome());
		Bean.setEmail(u.getEmail());
		Bean.setNome(u.getNome());
		Bean.setPassword(u.getPassword());
		Bean.setUserid(u.getUserid());
		Bean.setType(u.getType());
		return Bean;
		
		
	}
	
		
	
	}

