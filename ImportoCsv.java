package application;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;

//import application.bean.ContornoBean;
//import application.bean.PuntoContornoBean;
import application.persistence.*;

public class ImportoCsv {
	
	private  String path;
	private final  static String driverName="org.postgresql.Driver"; 	//classe del driver
	private final static String  databaseName="stelleBD";
	private final  static String id="postgres";
	private final  static String password="postgres";
	private final  static String url="jdbc:postgresql://localhost:5432/"+databaseName+"";

	
	
      public Connection getConn() {
      Connection conn=null;
			try {
				Class.forName(driverName);
				
				try {
					conn=DriverManager.getConnection(url,id,password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
		        
      }catch (ClassNotFoundException e) {
    	  e.printStackTrace();
      } 
		return conn;
      }
      
      
      public String getPath() {
    	  return path;
      }
      public String setPath(String path) {
    	  return path;
      }
      public void closeConn(Connection conn){
    	  try {
    		  if (conn != null)
    			  conn.close();
    	  }catch (SQLException se) {
    		  se.printStackTrace();
    	  }
      }
      
	public void scanCsv(String type, String path) throws SQLException {
    	  Connection conn=getConn();
    	  setPath(path);
    	  BufferedReader br = null;
    	  try {
    		  br = new BufferedReader(new FileReader(path));
    		  String line;
    		  @SuppressWarnings("unused")
			  String headerLine = br.readLine();
    		  while((line = br.readLine()) != null) {
    
                  String[] l = line.split(",");
                  switch(type) {
                  case "CONTORNI_HERSCHEL":
                	  insertContorni(l,conn);
                	  break;
                  case "CONTORNI_SPITZER":
                	                 	  
                	  insertContorni(l,conn);
                	  break;
                  case "FILAMENTI_HERSCHEL":
                	  
                	  insertFilamenti(l,conn);
                	  break;
                  case "FILAMENTI_SPITZER" :
                	  
                	  insertFilamenti(l,conn);
                	  break;
                  case "SCHELETRO_HERSCHEL" : 
                	  insertScheletro(l,conn);
                	  break;
                  case "SCHELETRO_SPITZER" :
        
                	  insertScheletro(l,conn);
                	  break;
                  case "STELLE_HERSCHEL" :
                	 
                	  insertStelle(l,conn);
                	  break;
                  }
    		  }
    		  }catch (IOException e) {
    			  e.printStackTrace();
    		  }finally {
    			  try {
    				  if(br != null) {
    					  br.close();
    				  }
    			  }catch(IOException e) {
    				  e.printStackTrace();
    			  }
    		  }
    	  System.out.print("Finito di importare il file " + path + ".");
      }
      
        
      


	private void insertContorni(String[] inputList,Connection conn) {
  	  	int ID = Integer.parseInt(inputList[0].trim());
    	  double Long = Double.parseDouble(inputList[1].trim());
    	  double Lat = Double.parseDouble(inputList[2].trim());   	  
    	  ;
    	  if(DaoFilamento.verifica(ID,conn) && DaoPuntoContorno.verifica(Long,Lat,conn) )//controllo se esistono sia filamento che i punti di contorno 
    		  {
    		  if(!DaoFilamento.verificaComposizioneContorno(ID, Long, Lat,conn))// se esiste salta la riga sucessiva
    			  DaoFilamento.creaContorno(ID,Long,Lat,conn);
    		  
    	  }else if (!DaoFilamento.verifica(ID,conn) && DaoPuntoContorno.verifica(Long,Lat,conn))
    		  {
    		  DaoFilamento.creaFilamento(ID,conn);//caso in cui manca l'id del filamento
    			  if(!DaoFilamento.verificaComposizioneContorno(ID, Long, Lat,conn))
    				  DaoFilamento.creaContorno(ID,Long,Lat,conn);
    		  }
    	  else if(DaoFilamento.verifica(ID,conn) && !DaoPuntoContorno.verifica(Long,Lat,conn)){
    		  DaoPuntoContorno.creaPuntoContorno(Long,Lat,conn);// caso in cui non c'è alcun punto con tale coordinate
    		  if(!DaoFilamento.verificaComposizioneContorno(ID, Long, Lat,conn))
    			  DaoFilamento.creaContorno(ID,Long,Lat,conn);
    	  }
    	  else {
    		  DaoFilamento.updateFilamento(ID,conn);
    		  DaoPuntoContorno.creaPuntoContorno(Long,Lat,conn);
    		  DaoFilamento.creaContorno(ID,Long,Lat,conn);
    	  }

		  System.out.println("Aggiornato il contorno il cui filamento ha un numero "+" "+ID+" ");
      }
      
      private void insertFilamenti(String[] inputList,Connection conn) {
    	  int ID = Integer.parseInt(inputList[0].trim());
    	  String nome = inputList[1].trim();
    	  double flusso = Double.parseDouble(inputList[2].trim());
    	  double dens = Double.parseDouble(inputList[3].trim());
    	  double temp = Double.parseDouble(inputList[4].trim());
    	  double ell = Double.parseDouble(inputList[5].trim());
    	  double contrast=Double.parseDouble(inputList[6].trim());
    	  String satellite = inputList[7].trim();
    	  String strumento = inputList[8].trim();
    	  if(DaoFilamento.verifica(ID,conn)) {
    		  if(!DaoStrumenti.verifica(strumento,conn) && !DaoSatellite.verifica(satellite,conn)) {
    			  DaoStrumenti.inseriscistrumento(strumento,conn);
    			  DaoSatellite.aggiungiSatellite(satellite,conn);
    			
    		  }else if(DaoStrumenti.verifica(strumento,conn) && !DaoSatellite.verifica (satellite,conn)){
    			  DaoSatellite.aggiungiSatellite(satellite,conn);
    			  
    		  }else if(!DaoStrumenti.verifica(strumento,conn) && DaoSatellite.verifica(satellite,conn))
    		  {
    			  DaoStrumenti.inseriscistrumento(strumento,conn);

        		  //DaoFilamento.updatecontorno(ID, contrast, conn);
    			
    		  }
    		  DaoFilamento.updateFilamento(ID,nome,flusso,dens,temp,ell,conn);
    		  DaoStrumenti.inserisciMisura(strumento, satellite, conn);

    		  DaoFilamento.updatecontorno(ID, contrast, conn);
    		     
    	  }
    	  else {
    		  if(!DaoStrumenti.verifica(strumento,conn) && !DaoSatellite.verifica(satellite,conn)) {
    			  DaoStrumenti.inseriscistrumento(strumento,conn);
    			  DaoSatellite.aggiungiSatellite(satellite,conn);
        		  DaoStrumenti.inserisciMisura(strumento, satellite, conn);

    			  
    		  }else if(DaoStrumenti.verifica(strumento,conn) && !DaoSatellite.verifica(satellite,conn)){
    			  DaoSatellite.aggiungiSatellite(satellite,conn);
        		  DaoStrumenti.inserisciMisura(strumento, satellite, conn);

    			
    		  }else if(!DaoStrumenti.verifica(strumento,conn) && DaoSatellite.verifica(satellite,conn))
    		  {
    			  DaoStrumenti.inseriscistrumento(strumento,conn);
        		  DaoStrumenti.inserisciMisura(strumento, satellite, conn);

    			
    		  }
    		  DaoFilamento.creaFilamento(ID,nome,flusso,dens,temp,ell,conn);
    		  DaoFilamento.updatecontorno(ID, contrast, conn);
    		  DaoStrumenti.inserisciMisura(strumento, satellite, conn);
    		  DaoStrumenti.inserisciIndividua(strumento,ID,conn);
    	  }

		  System.out.println("Aggiornato il filamento numero "+" "+ID+" ");
      }
      
      private void insertScheletro(String[] inputList,Connection conn) {
    	  int IDFilamento = Integer.parseInt(inputList[0].trim());
    	  int IDSegmento = Integer.parseInt(inputList[1].trim());
    	  String tipo = (inputList[2].trim());
    	  double Long = Double.parseDouble(inputList[3].trim());
    	  double Lat = Double.parseDouble(inputList[4].trim());
    	  int ordineProgressivo = Integer.parseInt(inputList[5]);
    	  double flusso = Double.parseDouble(inputList[6].trim());
    	  if(!DaoFilamento.verifica(IDFilamento,conn)) {
    		  
    		  if (!DaoSegmento.verifica(IDSegmento,conn))
    			//  DaoSegmento.creaSegmento(IDSegmento,tipo,IDFilamento ,flusso,conn);
    			    
    			  DaoSegmento.updateSegmento(IDSegmento,tipo,IDFilamento,flusso,conn);
    		  if(!DaoPuntoSegmento.verifica(Long,Lat,conn))
    			  DaoPuntoSegmento.creaPuntoSegmento(Long,Lat,IDSegmento,ordineProgressivo,conn);
    	  }
    	  else if(!DaoSegmento.verifica(IDSegmento,conn)) {
    		//  DaoSegmento.creaSegmento(IDSegmento,tipo,IDFilamento ,flusso,conn);
    		  DaoSegmento.updateSegmento(IDSegmento,tipo,IDFilamento ,flusso,conn);

    		  if(!DaoPuntoSegmento.verifica(Long,Lat,conn))
    			  DaoPuntoSegmento.creaPuntoSegmento(Long,Lat,IDSegmento,ordineProgressivo,conn);
  	  			

    	  }
    	  		
    	  else {
    		  if(!DaoPuntoSegmento.verifica(Long,Lat,conn))
    			  DaoPuntoSegmento.creaPuntoSegmento(Long,Lat,IDSegmento,ordineProgressivo,conn);
    		  //DaoSegmento.creaSegmento(IDSegmento,tipo,IDFilamento ,flusso,conn);
    		  DaoSegmento.updateSegmento(IDSegmento,tipo,IDFilamento ,flusso,conn);
  	  			//DaoSegmento.creaSegmento(ordineProgressivo,IDSegmento,tipo,IDFilamento,conn);
    	  }

		  System.out.println("Aggiornati il segmento e le relazioni ad esso connesso numero "+" "+IDSegmento+" ");
      }
      private void insertStelle(String[] inputList,Connection conn) throws SQLException {
    	  int ID = Integer.parseInt(inputList[0].trim());
    	  String NomeSorgente= inputList[1].trim();
    	  double Long = Double.parseDouble(inputList[2].trim()); 
    	  double Lat = Double.parseDouble(inputList[3].trim()); 
    	  double flusso = Double.parseDouble(inputList[4].trim()); 
    	  String tipologia = inputList[5].trim();
    	  if (DaoStella.verifica(ID,conn)) { 
    		  //DaoStella.creaStella(ID, NomeSorgente, Long, Lat, flusso, tipologia, conn);
    		  DaoStella.updateStella(ID, NomeSorgente, Long, Lat, flusso, tipologia, conn);
    		  
    	  }
    	  //DaoStella.updateRileva(ID,tipologia,conn);
    	  //DaoStella.inserisciRileva(ID,tipologia,conn);
		  System.out.println("Aggiornata la stella numero "+" "+ID+" ");
}}
	
	
