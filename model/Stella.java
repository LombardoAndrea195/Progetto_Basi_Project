package application.model;

public class Stella {
	private String TipoStella;
	private int Id;
	private String Nome;
	private Double ValoreFlusso;
	private Double Latitudine;
	private Double Longitudine;
	
	private Double distanza;
	
	public Double getDistanza() {
		return distanza;
	}
	public void setDistanza(Double distanza) {
		this.distanza = distanza;
	}
	
	public Stella(int id, Double valoreFlusso, Double distanza) {
		super();
		Id = id;
		ValoreFlusso = valoreFlusso;
		this.distanza = distanza;
	}
	public Stella(String tipoStella, int id, String nome, Double valoreFlusso, Double latitudine, Double longitudine) {
		super();
		TipoStella = tipoStella;
		Id = id;
		Nome = nome;
		ValoreFlusso = valoreFlusso;
		Latitudine = latitudine;
		Longitudine = longitudine;
		
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