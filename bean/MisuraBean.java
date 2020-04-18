package application.bean;

import application.model.Satellite;
import application.model.Strumento;

public class MisuraBean {
	private Strumento Id;
	private Satellite  Nome;
	
	
	public Strumento getId() {
		return Id;
	}
	public void setId(Strumento id) {
		Id = id;
	}
	public Satellite getNome() {
		return Nome;
	}
	public void setNome(Satellite nome) {
		Nome = nome;
	}
}


