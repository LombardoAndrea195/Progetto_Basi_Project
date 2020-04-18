package application.bean;

import java.util.Date;

import application.bean.AgenziaSpazialeBean;

public class SatelliteBean {

	private String Nome;
	private Date DataInizio;
	private Date DataFine;
	private AgenziaSpazialeBean NomeAgenzia;
	private String dataString;
	
	
	public String getDataString() {
		return dataString;
	}

	public void setDataString(String dataString) {
		this.dataString = dataString;
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
	public AgenziaSpazialeBean getNomeAgenzia() {
		return NomeAgenzia;
	}
	public void setNomeAgenzia(AgenziaSpazialeBean nomeAgenzia) {
		NomeAgenzia = nomeAgenzia;
	}
	
	
}



