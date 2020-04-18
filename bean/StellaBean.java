package application.bean;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StellaBean {

	private String TipoStella;
	private int Id;
	private String Nome;
	private Double ValoreFlusso;
	private Double Latitudine;
	private Double Longitudine;
	
	private Double Distanza;
	public StringProperty getIdProperty(){
		StringProperty Id=new SimpleStringProperty(String.valueOf(this.Id));
		return Id;
	}
	public StringProperty getFlussoProperty(){
		StringProperty ValoreFlusso=new SimpleStringProperty(String.valueOf(this.ValoreFlusso));
		return ValoreFlusso;
	}
	public DoubleProperty getDistanzaProperty(){
		DoubleProperty Distanza=new SimpleDoubleProperty(Double.valueOf(this.Distanza));
		return Distanza;
	}
	public Double getDistanza() {
		return Distanza;
	}
	public void setDistanza(Double distanza) {
		Distanza = distanza;
	}
	public String getTipoStella() {
		return TipoStella;
	}
	public void setTipoStella(String tipoStella) {
		TipoStella = tipoStella;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public Double getValoreFlusso() {
		return ValoreFlusso;
	}
	public void setValoreFlusso(Double valoreFlusso) {
		ValoreFlusso = valoreFlusso;
	}
	public Double getLatitudine() {
		return Latitudine;
	}
	public void setLatitudine(Double latitudine) {
		Latitudine = latitudine;
	}
	public Double getLongitudine() {
		return Longitudine;
	}
	public void setLongitudine(Double longitudine) {
		Longitudine = longitudine;
	}
	
	
}
