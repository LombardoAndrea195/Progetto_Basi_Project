package application.model;

public class Filamento {

	
	String nome;
	int idFilamento;
	Double FlussoTotale;
	Double Ellitticitā;
	Double TemperaturaMedia;
	Double DensitāMedia;
	
	public Filamento(String nome, int idFilamento, Double flussoTotale, Double ellitticitā, Double temperaturaMedia,
			Double densitāMedia) {
		super();
		this.nome = nome;
		this.idFilamento = idFilamento;
		FlussoTotale = flussoTotale;
		Ellitticitā = ellitticitā;
		TemperaturaMedia = temperaturaMedia;
		DensitāMedia = densitāMedia;
	}

	public Filamento() {
		// TODO Auto-generated constructor stub
	}

	public Filamento(String inputId) {
		this.nome = inputId;
	}
	

	public Filamento(int idFilamento) {
		super();
		this.idFilamento = idFilamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		
	}

	public int getIdFilamento() {
		return idFilamento;
	}

	public void setIdFilamento(int idFilamento) {
		this.idFilamento = idFilamento;
	}

	public Double getFlussoTotale() {
		return FlussoTotale;
	}

	public void setFlussoTotale(Double flussoTotale) {
		FlussoTotale = flussoTotale;
	}

	public Double getEllitticitā() {
		return Ellitticitā;
	}

	public void setEllitticitā(Double ellitticitā) {
		Ellitticitā = ellitticitā;
	}

	public Double getTemperaturaMedia() {
		return TemperaturaMedia;
	}

	public void setTemperaturaMedia(Double temperaturaMedia) {
		TemperaturaMedia = temperaturaMedia;
	}

	public Double getDensitāMedia() {
		return DensitāMedia;
	}

	public void setDensitāMedia(Double densitāMedia) {
		DensitāMedia = densitāMedia;
	}
	
}
