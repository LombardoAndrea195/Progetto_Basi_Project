package application.bean;


import application.model.Segmento;

public class PuntoSegmentoBean {

	private int ordineProgressivo;
	private Double Latitudine;
	private Double  Longitudine;
	private Segmento segmento;
	public Double getLatitudine() {
		return Latitudine;
	}
	public int getOrdineProgressivo() {
		return ordineProgressivo;
	}
	public void setOrdineProgressivo(int ordineProgressivo) {
		this.ordineProgressivo = ordineProgressivo;
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
	public Segmento getSegmento() {
		return segmento;
	}
	public void setSegmento(Segmento segmento) {
		this.segmento = segmento;
	}
	
}