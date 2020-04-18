package application.model;

public class PuntoDiSegmento {
	private Double Latitudine;
	private Double Longitudine;
	private Segmento segmento;
	private int ordineProgressivo;
	public PuntoDiSegmento(Double latitudine, Double longitudine, Segmento segmento) {
		super();
		Latitudine = latitudine;
		Longitudine = longitudine;
		this.segmento = segmento;
	}
	public int getOrdineProgressivo() {
		return ordineProgressivo;
	}
	public void setOrdineProgressivo(int ordineProgressivo) {
		this.ordineProgressivo = ordineProgressivo;
	}
	public PuntoDiSegmento(Double latitudine, Double longitudine, Segmento segmento, int ordineProgressivo) {
		super();
		Latitudine = latitudine;
		Longitudine = longitudine;
		this.segmento = segmento;
		this.ordineProgressivo = ordineProgressivo;
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
	public Segmento getSegmento() {
		return segmento;
	}
	public void setSegmento(Segmento segmento) {
		this.segmento = segmento;
	}
}