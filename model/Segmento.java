package application.model;

public class Segmento {

		private String tipoSegmento;
		private int idSegmento;
		private double flussomisurato;
	
		
		public double getFlussomisurato() {
			return flussomisurato;
		}
		public void setFlussomisurato(double flussomisurato) {
			this.flussomisurato = flussomisurato;
		}
		public Segmento(String tipoSegmento, int idSegmento, double flussomisurato) {
			super();
			this.tipoSegmento = tipoSegmento;
			this.idSegmento = idSegmento;
			this.flussomisurato = flussomisurato;
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
		public Segmento(String tipoSegmento, int idSegmento) {
			super();
			this.tipoSegmento = tipoSegmento;
			this.idSegmento = idSegmento;
		}
		public Segmento() {
			// TODO Auto-generated constructor stub
		}
		public Segmento(int idsegmento2) {
			// TODO Auto-generated constructor stub
			this.idSegmento = idsegmento2;
		}
}
