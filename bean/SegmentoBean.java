package application.bean;

public class SegmentoBean {
	private String tipoSegmento;
	private int idSegmento;
	private double flussomisurato;
	
	public double getFlussomisurato() {
		return flussomisurato;
	}
	public void setFlussomisurato(double flussomisurato) {
		this.flussomisurato = flussomisurato;
	}

	private FilamentoBean filamento;
	
	public FilamentoBean getFilamento() {
		return filamento;
	}
	public void setFilamento(FilamentoBean filamento) {
		this.filamento = filamento;
	}
	public String getTipoSegmento() {
		return tipoSegmento;
	}
	public void setTipoSegmento(String tipoSegmento) {
		this.tipoSegmento = tipoSegmento;
	}
	public int getIdSegmento() {
		return idSegmento;
	}
	
	public void setIdSegmento(int idSegmento) {
		this.idSegmento = idSegmento;
	}
	
}
