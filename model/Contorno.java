package application.model;

import java.util.ArrayList;

import application.bean.FilamentoBean;

public class Contorno {
	 private Double Latitudine;
	 private Double Longitudine;
	 private ArrayList<PuntoDiContorno> puntiContorno;
	 private Double contrasto;
	  
	private FilamentoBean Id;
	
	private Double coordinata;
	
	 public Contorno(Double latitudine, Double longitudine, ArrayList<PuntoDiContorno> puntiContorno,
			 Double contrasto, FilamentoBean id, Double coordinata) {
		super();
		Latitudine = latitudine;
		Longitudine = longitudine;
		this.puntiContorno = puntiContorno;
		this.contrasto = contrasto;
		Id = id;
		this.coordinata = coordinata;
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

	

	public Double getCoordinata() {
		return coordinata;
	}

	public void setCoordinata(Double coordinata) {
		this.coordinata = coordinata;
	}
	
	/*
	 * public int aggiorna(ArrayList<PuntoDiContorno> puntoContorno) {
	 *  float vp;
		    int i;
		    for(i=0; i<puntiContorno.size(); i++) 
		      vp=puntoContorno.get(i)}
	 */
		   
		    
		   
		  
	
	
	public Double getContrasto() {
		return contrasto;
	}

	public void setContrasto(Double contrasto) {
		this.contrasto = contrasto;
	}

	

	public ArrayList<PuntoDiContorno> getPuntiContorno() {
		return puntiContorno;
	}

	public void setPuntiContorno(ArrayList<PuntoDiContorno> puntiContorno) {
		this.puntiContorno = puntiContorno;
	}

	public FilamentoBean getId() {
		return Id;
	}

	public Contorno(ArrayList<PuntoDiContorno> puntiContorno, Double contrasto, FilamentoBean id,
			Double coordinata) {
		super();
		this.puntiContorno = puntiContorno;
		this.contrasto = contrasto;
		Id = id;
		this.coordinata = coordinata;
	}

	public void setId(FilamentoBean id) {
		Id = id;
	}



	

}
