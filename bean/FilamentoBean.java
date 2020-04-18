package application.bean;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FilamentoBean {

	private String nome;
	private int idFilamento;
	private Double FlussoTotale;
	private Double Ellitticit‡;
	private Double TemperaturaMedia;
	private Double Densit‡Media;
	
	public StringProperty getNomeProperty(){
		StringProperty nome=new SimpleStringProperty(this.nome);
		return nome;
	}
	public StringProperty getIdProperty(){
		StringProperty idFilamento=new SimpleStringProperty(String.valueOf(this.idFilamento));
		return idFilamento;
	}
	public StringProperty getFlussoProperty(){
		StringProperty FlussoTotale=new SimpleStringProperty(String.valueOf(this.FlussoTotale));
		return FlussoTotale ;
	}
	public StringProperty getEllitticit‡Property(){
		StringProperty Ellitticit‡ =new SimpleStringProperty(String.valueOf(this.Ellitticit‡));
		return Ellitticit‡;}
	public StringProperty getTemperaturaProperty(){
		StringProperty TemperaturaMedia=new SimpleStringProperty(String.valueOf(this.TemperaturaMedia));
		return TemperaturaMedia ;}
	public StringProperty getDensit‡Property(){
		StringProperty Densit‡Media=new SimpleStringProperty(String.valueOf((this.Densit‡Media)));
		return Densit‡Media;}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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