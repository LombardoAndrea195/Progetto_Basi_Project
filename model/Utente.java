package application.model;

public class Utente {
		private String userid;
		private String password;
		private String nome;
		private String cognome;
		private String email;
		private String Type;
		
		public Utente(String userid,String password,String Type) {
			this.userid=userid;
			this.password=password;
			this.Type=Type;
		}
		public Utente(String userid,String password){
			this.userid=userid;
			this.password=password;}
		
		
		public Utente(String userid,String password,String nome,String cognome,String email,String Type) {
			this.userid=userid;
			this.password=password;
			this.nome=nome;
			this.cognome=cognome;
			this.email= email;
			this.setType(Type);
		}

		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome= nome;
		}
		public String getCognome() {
			return cognome;
		}
		public void setCognome(String cognome) {
			this.cognome= cognome;
		}	
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

		public String getType() {
			return Type;
		}

		public void setType(String type) {
			Type = type;
		}
}
