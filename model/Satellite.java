package application.model;

import java.util.Date;

public class Satellite {
	private String Nome;
	private Date DataInizio;
	private Date DataFine;
	private AgenziaSpaziale NomeAgenzia;
	private String dataFine;
	public Satellite(String nome, Date dataInizio, AgenziaSpaziale nomeAgenzia, String dataFine) {
		super();
		Nome = nome;
		DataInizio = dataInizio;
		NomeAgenzia = nomeAgenzia;
		this.setdataFine(dataFine);
	}
	public Satellite(String nome, Date dataInizio, Date dataFine, AgenziaSpaziale agenziaSpaziale) {
		super();
		Nome = nome;
		DataInizio = dataInizio;
		DataFine = dataFine;
		NomeAgenzia = agenziaSpaziale;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Date getDataInizio() {
		return DataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		DataInizio = dataInizio;
	}
	public Date getDataFine() {
		return DataFine;
	}
	public void setDataFine(Date dataFine) {
		DataFine = dataFine;
	}
	public AgenziaSpaziale getNomeAgenzia() {
		return NomeAgenzia;
	}
	public void setNomeAgenzia(AgenziaSpaziale nomeAgenzia) {
		NomeAgenzia = nomeAgenzia;
	}
	public String getdataFine() {
		return dataFine;
	}
	public void setdataFine(String dataFine) {
		this.dataFine = dataFine;
	}
	
	
}
