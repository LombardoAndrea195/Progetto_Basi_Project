package application.bean;

import java.util.ArrayList;





public class ContornoBean {

	    private Double Latitudine;
	    private Double Longitudine;
		private ArrayList<PuntoContornoBean>  puntoContorno;
	    private Double contrasto;
		private FilamentoBean filamento;
		
		private Double coordinata;

		public Double getCoordinata() {
			return coordinata;
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

		public void setCoordinata(Double coordinata) {
			this.coordinata = coordinata;
		}

		public Double getContrasto() {
			return contrasto;
		}

		public void setContrasto(Double contrastoFlusso) {
			this.contrasto = contrastoFlusso;
		}

		public FilamentoBean getFilamento() {
			return filamento;
		}

		public void setFilamento(FilamentoBean filamento) {
			this.filamento = filamento;
		}

		public ArrayList<PuntoContornoBean> getPuntoContorno() {
			return puntoContorno;
		}

		public void setPuntoContorno(ArrayList<PuntoContornoBean> puntoContorno) {
			this.puntoContorno = puntoContorno;
		}


		
}
