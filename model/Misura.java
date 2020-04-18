package application.model;

public class Misura {
	private Strumento Strumento;
	private Satellite  Nome;
	
	public Misura(Strumento  Strumento,Satellite Nome) {
		super();
		Strumento=this.Strumento;
		Nome=this.Nome;
	}
	public Strumento getStrumento() {
		return Strumento;
	}
	public void setStrumento(Strumento Strumento) {
		Strumento=this.Strumento;
	}
	public Satellite getNome() {
		return Nome;
	}
	public void setNome(Satellite nome) {
		Nome = nome;
	}
}
