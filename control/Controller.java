package application.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.Collections;
//import java.util.Comparator;
import java.util.Date;
//import java.util.List;

import application.bean.AgenziaSpazialeBean;
import application.bean.BandaBean;

//import application.bean.CatturaBean;
//import application.bean.ContornoBean;
import application.bean.FilamentoBean;
import application.bean.SatelliteBean;
import application.bean.StellaBean;
import application.bean.StrumentoBean;
import application.bean.UtenteBean;
import application.exception.CampiNonCompilati;
import application.exception.UtenteEsistenteException;
import application.model.Filamento;
import application.model.Stella;
import application.persistence.DaoFilamento;
import application.persistence.DaoPuntoSegmento;
import application.persistence.DaoSatellite;
//import application.persistence.DaoSegmento;
import application.persistence.DaoStella;
import application.persistence.DaoStrumenti;
import application.persistence.DaoUtente;
//import application.view.SchermataRicercaFilamento;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;

public class Controller {
	private static Controller instance = null;
	public static ArrayList<String> valori= new ArrayList<String>();
	public static ArrayList<Filamento> FilamentiBea= new ArrayList<Filamento>();
	public static ArrayList<Stella> stelle=new ArrayList<Stella>();
	public static  ArrayList<StellaBean> stellaRisultato=new ArrayList<StellaBean>();
	public Controller() {
	}
	
	public static Controller getInstance() {
		if(instance == null) {
			instance = new Controller();
		}
		return instance;
	}
	public static ArrayList<String> pushValori(){
		return valori;
	}
	public static void InserisciUtente(String nome,String cognome,String password,String UserId,String Type,String Email,String Tipo) throws UtenteEsistenteException, SQLException, CampiNonCompilati  {
		UtenteBean u=new UtenteBean();
		u.setCognome(cognome);
		u.setEmail(Email);
		u.setNome(nome);
		u.setPassword(password);
		u.setUserid(UserId);
		u.setType(Tipo);
		if (u.getNome()==null || u.getCognome()==null ||u.getEmail()==null||u.getPassword()==null||u.getUserid()==null || u.getType()==null )
		{
			throw new CampiNonCompilati();
		}
		DaoUtente.aggiungiUtente(u.getNome(),u.getCognome(),u.getPassword(),u.getUserid(),u.getType(),u.getEmail());
		System.out.println("Utente di tipo "+" "+Tipo+" " +" Aggiunto al Database con Successo");
	}

	public static boolean InserisciDati(String nome, Double lunghezzaOnda) throws CampiNonCompilati, Exception {
		StrumentoBean s=new StrumentoBean();
		BandaBean banda=new BandaBean();
		banda.setLunghezzaonda(lunghezzaOnda);
		
		
		s.setNome(nome);
		if(banda.getLunghezzaonda()==null ||s.getNome()==null) {
			throw new CampiNonCompilati();
		}
		DaoStrumenti.aggiungiStrumento(s.getNome());
		DaoStrumenti.aggiungiBanda(banda.getLunghezzaonda());
		DaoStrumenti.aggiungiCattura(s.getNome(), banda.getLunghezzaonda());
		System.out.println("Inserito strumento e banda relativa al database ");
		return true;
		
	}

	public static boolean InserisciDatiSat(Date dataInizio, String dataFine, String nomeSatellite, String AgenziaNome) throws CampiNonCompilati,Exception{

		SatelliteBean sat=new SatelliteBean();
		sat.setDataString(dataFine);
		sat.setDataInizio(dataInizio);
		sat.setNome(nomeSatellite);
		AgenziaSpazialeBean Ag=new AgenziaSpazialeBean();
		Ag.setNome(AgenziaNome);
		sat.setNomeAgenzia(Ag);
		if(sat.getDataInizio()==null || sat.getNome()==null|| Ag.getNome()==null) {
			throw new CampiNonCompilati();
			
		}
		DaoSatellite.aggiungiAgenzia(Ag.getNome());
		DaoSatellite.aggiungiSatellite(sat.getNome(), Ag.getNome(), sat.getDataInizio(), sat.getDataString());
		System.out.println("Inserito satellite al databse con informazioni ad esso relative");
		return true;
	}
	public static ArrayList<String> PrendiDatiFilamentoId(int Id) {
		FilamentoBean filamento =new FilamentoBean();
		filamento.setIdFilamento(Id);
		
		
		
		String risultato=DaoFilamento.findPosizioneId(filamento.getIdFilamento());
		String risultato2=DaoFilamento.findEstensioneId(filamento.getIdFilamento());
		String risultato3=DaoFilamento.findNumeroSegmentiId(filamento.getIdFilamento());
		
	
		valori.clear();
		valori.add(risultato);
		
		valori.add(risultato2);
		valori.add(risultato3);
		System.out.println("Ricerca avvenuta con successo: Attendi i risultati");
		return valori;
	}
	
	public static  ArrayList<String> PrendiDatiFilamentoNome(String Nome) throws CampiNonCompilati {
			FilamentoBean filamento =new FilamentoBean();
			filamento.setNome(Nome);
		if (filamento.getNome()==null){
			throw new CampiNonCompilati();
		}
		String risultato =DaoFilamento.findPosizioneNome(Nome);
		String risultato2=DaoFilamento.findEstensioneNome(filamento.getNome());
		String risultato3=DaoFilamento.findNumeroSegmentiNome(filamento.getNome());
		valori.clear();
		valori.add( risultato);
		valori.add( risultato2);
		valori.add( risultato3);
		System.out.println("Ricerca avvenuta con successo: Attendi i risultati");
		return valori;
	}

	public static ArrayList<FilamentoBean> PrendiDatiFilamento(int ordineProgressivo, int ordineProgressivo2) {
		
		int MIN=ordineProgressivo;
		int MAX=ordineProgressivo2;
		ArrayList<Filamento> value = new ArrayList<Filamento>();
		ArrayList<FilamentoBean> valoriBean = new ArrayList<FilamentoBean>();
		value=DaoFilamento.findFilamentoPerSegmenti(MIN,MAX);
		System.out.println("Ricerca avvenuta con successo: Attendi i risultati");
		for(Filamento f : value)
		

		{
			FilamentoBean filamentoBean= new FilamentoBean();
			filamentoBean.setNome(f.getNome());
			filamentoBean.setDensit‡Media(f.getDensit‡Media());
			filamentoBean.setEllitticit‡(f.getEllitticit‡());
			filamentoBean.setTemperaturaMedia(f.getTemperaturaMedia());
			filamentoBean.setFlussoTotale(f.getFlussoTotale());
			filamentoBean.setIdFilamento(f.getIdFilamento());
		
			valoriBean.add(filamentoBean);
		}
	

		return valoriBean;
		
	}

	public static ArrayList<FilamentoBean> RicercaBrillantezza(Double ellitticit‡, Double ellitticit‡2,
			Double contrastoFlusso) {
		
		Double MIN=ellitticit‡;
		Double MAX=ellitticit‡2;
		Double contrasto=contrastoFlusso;
		
		ArrayList<Filamento> value = new ArrayList<Filamento>();
		value=DaoFilamento.findBrillantezza(MIN,MAX,contrasto);

		
		
		ArrayList<FilamentoBean> valoriBean = new ArrayList<FilamentoBean>();
		System.out.println("Ricerca avvenuta con successo: Attendi i risultati");
		for(Filamento f : value)
		

		{
			FilamentoBean filamentoBean= new FilamentoBean();
			filamentoBean.setNome(f.getNome());
			filamentoBean.setDensit‡Media(f.getDensit‡Media());
			filamentoBean.setEllitticit‡(f.getEllitticit‡());
			filamentoBean.setTemperaturaMedia(f.getTemperaturaMedia());
			filamentoBean.setFlussoTotale(f.getFlussoTotale());
			filamentoBean.setIdFilamento(f.getIdFilamento());
		
			valoriBean.add(filamentoBean);
		}
		
		return valoriBean;
	}

	public static ArrayList<FilamentoBean> RicercaSuCerchio(Double raggio, Double latitudine, Double longitudine) {
		
		ArrayList<Filamento> value = new ArrayList<Filamento>();
		value=DaoFilamento.findFilamentiCerchio(raggio,latitudine,longitudine);
		System.out.println("Ricerca avvenuta con successo: Attendi i risultati");
		ArrayList<FilamentoBean> valoriBean = new ArrayList<FilamentoBean>();
		
		for(Filamento f : value)
		

		{
			FilamentoBean filamentoBean= new FilamentoBean();
			filamentoBean.setNome(f.getNome());
			filamentoBean.setDensit‡Media(f.getDensit‡Media());
			filamentoBean.setEllitticit‡(f.getEllitticit‡());
			filamentoBean.setTemperaturaMedia(f.getTemperaturaMedia());
			filamentoBean.setFlussoTotale(f.getFlussoTotale());
			filamentoBean.setIdFilamento(f.getIdFilamento());
		
			valoriBean.add(filamentoBean);
		}
		return valoriBean;
	}

	public static ArrayList<FilamentoBean> RicercaSuQuadrato(Double lato, Double latitudine, Double longitudine) {
		
		ArrayList<Filamento> value = new ArrayList<Filamento>();
		value=DaoFilamento.findFilamentiQuadrato(lato,latitudine,longitudine);
		System.out.println("Ricerca avvenuta con successo: Attendi i risultati");
		ArrayList<FilamentoBean> valoriBean = new ArrayList<FilamentoBean>();
		
		for(Filamento f : value)
		

		{
			FilamentoBean filamentoBean= new FilamentoBean();
			filamentoBean.setNome(f.getNome());
			filamentoBean.setDensit‡Media(f.getDensit‡Media());
			filamentoBean.setEllitticit‡(f.getEllitticit‡());
			filamentoBean.setTemperaturaMedia(f.getTemperaturaMedia());
			filamentoBean.setFlussoTotale(f.getFlussoTotale());
			filamentoBean.setIdFilamento(f.getIdFilamento());
		
			valoriBean.add(filamentoBean);
		}
		return valoriBean;
	}

	

	 
	public static ArrayList<Double> RicercaStelleInFilamento(int idFilamento) throws ClassNotFoundException {
		/**
		 * REQUISITO 9
		 * 
		 * VALORI RITORNATI: 
		 * 0) il numero di stelle trovate nel contorno del filamento,
		 * 1) la percentuale di prestelle,
		 * 2) la percentuale di protostelle,
		 * 3) la percentuale di stelle formate.
		 */
		ArrayList<Double> valori = new ArrayList<Double>();	

		ArrayList<Stella> stelle = DaoStella.ottieniTutteStelle();//Inserisco tutte le stelle del databse all'interno di un array di oggetti stelle
				ArrayList<Stella> stelleTrovate = DaoStella.trovaStelleInFilamento(idFilamento, stelle);
				float numStelle = (float) stelleTrovate.size();
				System.out.println("Ricerca avvenuta con successo: Attendi i risultati");
				System.out.println(
						"Nel filamento " + idFilamento + " sono state trovate " + numStelle + " stelle.\n");
				valori.add((double) numStelle);
				
				valori.addAll(calcolaPercentualiTipoStella(stelleTrovate));//Inserisce le percentuali in valori un arrayList di double
				return valori;
		
	} 
	
	public static ArrayList<Double> calcolaPercentualiTipoStella(ArrayList<Stella> stelle){
		ArrayList<Double> percentuali = new ArrayList<Double>();
		int size = stelle.size();
		float numProtostelle = 0; 
		float numPrestelle = 0;
		float numStelleFormate = 0;
		for (Stella s : stelle) {
			switch(s.getTipoStella()) {
			case ("PRESTELLAR"):
				numPrestelle++;
				break;
			case ("PROTOSTELLAR"):
				numProtostelle++;
				break;
			case ("UNBOUND"):
				numStelleFormate++;
				break;
			}
		}
		percentuali.add((double)((numPrestelle/size) * 100));
		percentuali.add(((double)(numProtostelle/size)* 100));
		percentuali.add((double)((numStelleFormate/size)* 100));
		return percentuali;
	}
	

	public static ArrayList<Double> RicercaSuRettangolo( Double base, Double altezza, Double latitudineCentroide,Double longitudineCentroide){
		
		ArrayList<Double> valori = new ArrayList<Double>();
		/**
		 * REQUISITO 10
		 * VALORI DI RITORNO:
		 * 
		 * 0) numero di  stelle che si trovano nella regione 
		 * 1) percentuale di prestelle nell'insieme di stelle che non si trovano nei filamenti
		 * 2) percentuale di protostelle nell'insieme di stelle che non si trovano nei filamenti
		 * 3) percentuale di stelle formate nell'insieme di stelle che non si trovano nei filamenti
		 * 4) percentuale di prestelle nell'insieme di stelle che si trovano nei filamenti
		 * 5) percentuale di protostelle nell'insieme di stelle che si trovano nei filamenti
		 * 6) percentuale di stelle formate nell'insieme di stelle che si trovano nei filamenti
		 * 
		 **/
		
		ArrayList<Object> risultatiDallaQuery = DaoStella.trovaStelleInQuadrilatero(base, altezza,latitudineCentroide, longitudineCentroide);
		System.out.println("Ricerca avvenuta con successo: Attendi i risultati");
		int numTotaleStelle = (int) risultatiDallaQuery.get(0);
		
		if(numTotaleStelle==0) {
			System.out.println("Non ci sono stelle nella regione considerata:");
			valori.add((double)0);
			valori.add((double)0);
			valori.add((double)0);
			valori.add((double)0);
			valori.add((double)0);
			valori.add((double)0);
			valori.add((double)0);
			
		}
		else {
		@SuppressWarnings("unchecked")
		ArrayList<Stella> stelleSoltantoNellaRegione =  (ArrayList<Stella>) risultatiDallaQuery.get(1);
		valori.add((double)numTotaleStelle);
		if (!stelleSoltantoNellaRegione.isEmpty()) {
			
	
			
				 
		
			
			ArrayList<Double> percentualiTipiStelleNonInFilamenti = calcolaPercentualiTipoStella(stelleSoltantoNellaRegione);
			double prestelleNonInFilamenti = percentualiTipiStelleNonInFilamenti.get(0);
			double protostelleNonInFilamenti = percentualiTipiStelleNonInFilamenti.get(1);
			double stelleformateNonInFilamenti = percentualiTipiStelleNonInFilamenti.get(2);
			valori.add(prestelleNonInFilamenti); 
			valori.add(protostelleNonInFilamenti); 
			valori.add(stelleformateNonInFilamenti); 
			
		}else {
			valori.add((double)0);
			valori.add((double)0);
			valori.add((double)0);
		}
		@SuppressWarnings("unchecked")
		ArrayList<Stella> stelleNellaRegioneENeiFilamenti = (ArrayList<Stella>) risultatiDallaQuery.get(2);
	
		
		ArrayList<Double> percentualiStelleInFilamenti = calcolaPercentualiTipoStella(stelleNellaRegioneENeiFilamenti);
		double prestelleInFilamenti = percentualiStelleInFilamenti.get(0);
		double protostelleInFilamenti = percentualiStelleInFilamenti.get(1);
		double stelleformateInFilamenti = percentualiStelleInFilamenti.get(2);
		valori.add(prestelleInFilamenti);			
		valori.add(protostelleInFilamenti);			
		valori.add(stelleformateInFilamenti);		
		}
		
		
		return valori;
	}

	public static ArrayList<String> PrendiDatiSegmento(int idSegmento) {
		// REQUISITO 11
		ArrayList<Double> MaxSegmento=new ArrayList<Double>();
		MaxSegmento=DaoPuntoSegmento.findMaxNumProgressivoSegmento(idSegmento);//seleziono max latitudine e longitudine
	System.out.println(MaxSegmento);
		

		String risultato=DaoFilamento.prendiDistanza(MaxSegmento.get(0),MaxSegmento.get(1),idSegmento);//calcolo distanza
		ArrayList<Double> MinSegmento=new ArrayList<Double>();
		System.out.println(MinSegmento);
		MinSegmento=DaoPuntoSegmento.findMinNumProgressivoSegmento(idSegmento);
	String risultato2=DaoFilamento.prendiDistanza(MinSegmento.get(0),MinSegmento.get(1),idSegmento);
	valori.clear();
	valori.add( risultato);// aggiunge max
	valori.add( risultato2);// aggiunge min
	System.out.println("Ricerca avvenuta con successo: Attendi i risultati");
	return valori;
	}
	
	public static ArrayList<StellaBean> RicercaDistanzaStelleSpinaDorsale(int idFilamento) throws ClassNotFoundException {
		
		ArrayList<StellaBean> valori = new ArrayList<StellaBean>();	
		stelle=DaoStella.trovaPosizioneStellaRispettoSpinaDorsale(idFilamento);
		Collections.sort(stelle, new Comparator<Stella>() {
	        

			@Override
			public int compare(Stella arg0, Stella arg1) {
				
				return arg0.getDistanza().compareTo(arg1.getDistanza());
			}
	    });
		for(Stella s : stelle)
			

		{
			StellaBean stellaBean= new StellaBean();
			stellaBean.setNome(s.getNome());
			stellaBean.setId(s.getId());
			stellaBean.setValoreFlusso(s.getValoreFlusso());
			stellaBean.setDistanza(s.getDistanza());
			valori.add(stellaBean);
			
			
}
		
		System.out.println("Ricerca avvenuta con successo: Attendi i risultati");
 return valori;
 }
	


public static ArrayList<StellaBean> RicercaDistanzaStelleSpinaDorsale2(int idFilamento) throws ClassNotFoundException {
		
		ArrayList<StellaBean> valori = new ArrayList<StellaBean>();	
		stelle=DaoStella.trovaPosizioneStellaRispettoSpinaDorsale2(idFilamento);
		for(Stella s : stelle)
			

		{
			StellaBean stellaBean= new StellaBean();
			stellaBean.setNome(s.getNome());
			stellaBean.setId(s.getId());
			stellaBean.setValoreFlusso(s.getValoreFlusso());
			stellaBean.setDistanza(s.getDistanza());
			valori.add(stellaBean);
			
}
		System.out.println("Ricerca avvenuta con successo: Attendi i risultati");
 return valori;
 }
}
	