package application.model;

public class PuntoDiContorno {

	private Double Latitudine;
	private Double Longitudine;
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
	public PuntoDiContorno(Double latitudine, Double longitudine) {
		super();
		Latitudine = latitudine;
		Longitudine = longitudine;
	}
	
	
}