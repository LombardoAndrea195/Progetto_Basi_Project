package application.bean;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FilamentoBean {

	private String nome;
	private int idFilamento;
	private Double FlussoTotale;
	private Double Ellitticitā;
	private Double TemperaturaMedia;
	private Double DensitāMedia;
	
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
	public StringProperty getEllitticitāProperty(){
		StringProperty Ellitticitā =new SimpleStringProperty(String.valueOf(this.Ellitticitā));
		return Ellitticitā;}
	public StringProperty getTemperaturaProperty(){
		StringProperty TemperaturaMedia=new SimpleStringProperty(String.valueOf(this.TemperaturaMedia));
		return TemperaturaMedia ;}
	public StringProperty getDensitāProperty(){
		StringProperty DensitāMedia=new SimpleStringProperty(String.valueOf((this.DensitāMedia)));
		return DensitāMedia;}
	
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