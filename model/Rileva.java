package application.model;

public class Rileva {
	private Filamento Id;
	private Strumento Nome;
	public Rileva(Filamento id, Strumento nome) {
		super();
		Id = id;
		Nome = nome;
	}
	public Filamento getId() {
		return Id;
	}
	public void setId(Filamento id) {
		Id = id;
	}
	public Strumento getNome() {
		return Nome;
	}
	public void setNome(Strumento nome) {
		Nome = nome;
	}
}