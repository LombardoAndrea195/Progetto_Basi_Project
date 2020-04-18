package application.model;

public class Filamento {

	
	String nome;
	int idFilamento;
	Double FlussoTotale;
	Double Ellitticit‡;
	Double TemperaturaMedia;
	Double Densit‡Media;
	
	public Filamento(String nome, int idFilamento, Double flussoTotale, Double ellitticit‡, Double temperaturaMedia,
			Double densit‡Media) {
		super();
		this.nome = nome;
		this.idFilamento = idFilamento;
		FlussoTotale = flussoTotale;
		Ellitticit‡ = ellitticit‡;
		TemperaturaMedia = temperaturaMedia;
		Densit‡Media = densit‡Media;
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

	public Double getEllitticit‡() {
		return Ellitticit‡;
	}

	public void setEllitticit‡(Double ellitticit‡) {
		Ellitticit‡ = ellitticit‡;
	}

	public Double getTemperaturaMedia() {
		return TemperaturaMedia;
	}

	public void setTemperaturaMedia(Double temperaturaMedia) {
		TemperaturaMedia = temperaturaMedia;
	}

	public Double getDensit‡Media() {
		return Densit‡Media;
	}

	public void setDensit‡Media(Double densit‡Media) {
		Densit‡Media = densit‡Media;
	}
	
}
