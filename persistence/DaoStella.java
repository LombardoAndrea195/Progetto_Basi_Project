package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
import java.util.ListIterator;

import application.bean.FilamentoBean;
import application.bean.StellaBean;
import application.model.Filamento;
import application.model.Stella;

public class DaoStella {
/*
 * 1) Caricare il Driver
 * 2) Aprire una Connessione al Database
 * 3) Creare un Oggetto Statement
 * 4) Interagire con il Database
 * 5) Gestire e visualizzare i risultati ottenuti dalle ResultSet.
 */
	
	private final  static String driverName="org.postgresql.Driver"; 	//classe del driver
	private final static String  databaseName="stelleBD";
	private final  static String id="postgres";
	private final  static String password="postgres";
	private final  static String url="jdbc:postgresql://localhost:5432/"+databaseName+"";
	public static void aggiungiStella( String tipoStella, int idFilamento,int IdStella,String nome, Double ValoreFlusso ,Double latitudine,Double longitudine) throws  SQLException {
    		Stella Stella=new Stella(tipoStella, IdStella, nome,  ValoreFlusso,latitudine,longitudine );
    		
    		Connection con=null;
    		Statement stm=null;
    		    try {
    				Class.forName(driverName);
    			}
    				catch (ClassNotFoundException e) 
    				{
    				    // gestione dell'eccezione 
    					e.printStackTrace();
    				}
    		    try {
    				con=DriverManager.getConnection(url,id,password);
    				stm=con.createStatement();
    				String sql="INSERT INTO stella(tipo,id,nome,flusso,latitudine,longitudine)" + "VALUES ('"+Stella.getTipoStella()+"', '"+Stella.getId()+"', '"+Stella.getNome()+"','"+Stella.getValoreFlusso()+"','"+Stella.getLatitudine()+"','"+Stella.getLongitudine()+"''"; 
       				stm.executeUpdate(sql);
    	            
                	stm.close();
                	con.close();
            	} catch (SQLException e) {
            		e.printStackTrace();
            	}
	}
	 public static void updateStella(int id, String nome, Double longitudine, Double latitudine, Double flusso, String tipo,Connection conn) {
		    PreparedStatement stmt=null;
	
			
			try {
				
				stmt=conn.prepareStatement("UPDATE stella "+
				                           "SET nome = ?,longitudine = ?, latitudine = ?, flusso = ?, "+
				                           "tipo = ? "+
						                   "WHERE id = ? ");
				
				stmt.setString(1, nome);
				stmt.setDouble(2, longitudine);
				stmt.setDouble(3, latitudine);
				stmt.setDouble(4, flusso);
				stmt.setString(5,tipo);
				
				stmt.setInt(6, id);
				
				stmt.executeUpdate();

	            stmt.close();
	       

			}catch(SQLException se){
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
	            try {
	                if (stmt != null)
	                    stmt.close();
	                
	            } catch (SQLException se2) {
	            	se2.printStackTrace();
	            }
			}
	   }
	 public static ArrayList<Stella> findStelleSuRettangolo(Double lato1, Double lato2, Double latitudine,
			 Double longitudine) {
		 ArrayList<Stella> stelle = new ArrayList<Stella>();
			// TODO Auto-generated method stub
			

			Connection con=null;
		    PreparedStatement stm=null;

		try {
			
			Class.forName(driverName);
		}
			catch (ClassNotFoundException e) 
			{
			    // gestione dell'eccezione 
				e.printStackTrace();
			}
		try {
			con=DriverManager.getConnection(url,id,password);
			String sql="select * from  stella ";
			stm=con.prepareStatement(sql);
			stm.setDouble(1, lato1);
			stm.setDouble(2, lato2);

			stm.setDouble(3, latitudine);
			stm.setDouble(4, longitudine);
				ResultSet res = stm.executeQuery();
				while (res.next()) {
			 
					 Stella Stella =new Stella(res.getString("tipo"), res.getInt("id"), res.getString("nome"), res.getDouble("flusso"), res.getDouble("latitudine"), res.getDouble("longitudine"));
					 
					 stelle.add((Stella));
				}res.close();
					con.close();
			}catch(SQLException SQLex) {
					SQLex.printStackTrace();
					
				}
		return stelle;
		}
	 //REQUISITO 10
	 public static  ArrayList<Object> trovaStelleInQuadrilatero(Double longitudineCentroide, Double latitudineCentroide, Double base, Double altezza){
		   ArrayList<Stella> stelleNellaRegioneEsterneAlFilamento = new ArrayList<Stella>();
		   ArrayList<Stella> stelleNellaRegioneInterneAlFilamento = new ArrayList<Stella>();
		   ArrayList<Object> valori = new ArrayList<Object>();
		   ArrayList<Stella> stelleNellaRegione = new ArrayList<Stella>();


			Connection con=null;
		    PreparedStatement stm=null;

		try {
			
			Class.forName(driverName);
		}
			catch (ClassNotFoundException e) 
			{
			    // gestione dell'eccezione 
				e.printStackTrace();
			}
		try {
			con=DriverManager.getConnection(url,id,password);
			
			//Attraverso la query ricerco una stella che si trova in un certo range(base,altezza)
			 String sql=("SELECT * FROM stella " + 
			 		"WHERE longitudine < ? AND longitudine > ? AND latitudine <? AND latitudine > ?");
			 stm=con.prepareStatement(sql);
			 stm.setDouble(1, longitudineCentroide + base/2);
				stm.setDouble(2, longitudineCentroide - base/2);

				stm.setDouble(3, latitudineCentroide + altezza/2);
				stm.setDouble(4, latitudineCentroide - altezza/2);
			 ResultSet rs = stm.executeQuery();
			 
			 while(rs.next()) {
				 Stella Stella =new Stella(rs.getString("tipo"), rs.getInt("id"), rs.getString("nome"), rs.getDouble("flusso"), rs.getDouble("latitudine"), rs.getDouble("longitudine"));
				 
				 stelleNellaRegione.add((Stella));
			 }
	        int numTotaleStelleNellaRegione = stelleNellaRegione.size();

			 System.out.println("trovate " + stelleNellaRegione.size() + " stelle nella regione.");
			 rs.close();
			 stm.close();
			 con.close();
			 if (stelleNellaRegione.size()==0) {
				valori.add((double)0); 
				valori.add((double)0); 
				valori.add((double)0);
				valori.add((double)0); 
				valori.add((double)0); 
				valori.add((double)0); 
			 }
			 else {
		     ArrayList<Filamento> filamentiNellaRegione = DaoFilamento.trovaFilamentiInQuadrilatero(longitudineCentroide, latitudineCentroide, base, altezza);
		     //In questo modo mi calcolo quali filamenti ho nella regione considerata 
		

		     for (Filamento f : filamentiNellaRegione) {
		    	 
		    	 ArrayList<Stella> stelleNelFilamento = trovaStelleInFilamento(f.getIdFilamento(), stelleNellaRegione);
		    	 //requisito 9 sfrutto per conoscere quali  stelle sono all'interno del filamento
		    	 for (Stella stellaTrovata : stelleNelFilamento) {
		    		 if (!(stelleNellaRegioneInterneAlFilamento.contains(stellaTrovata)) ){
		    			 
		    			 stelleNellaRegioneInterneAlFilamento.add(stellaTrovata);// inizializza tale arraylist con le stelle che si trovano nella regione considerata
		    		 }
		    		
		    	 }
		     }
		     
		     
		     
		    	 for (Stella s2 : stelleNellaRegione) {
		    		 if (!stelleNellaRegioneInterneAlFilamento.contains(s2)) {
		    				 stelleNellaRegioneEsterneAlFilamento.add(s2);
		    		 }
		    	 }
		     //setting dei valori di output
		     valori.add(numTotaleStelleNellaRegione);
		     valori.add(stelleNellaRegioneEsterneAlFilamento);//ma non nel filamento
		     
		     valori.add(stelleNellaRegioneInterneAlFilamento);
		    
			 }} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return valori;
	   }
	public static void creaStella(int id, String nome, Double longitudine, Double latitudine, Double flusso, String tipo,Connection conn) {
	    PreparedStatement stmt=null;
	
		
		try {
			
			stmt=conn.prepareStatement("INSERT INTO stella(id, nome, longitudine, latitudine, flusso, tipo) "+
					                   "VALUES (?,?,?,?,?,?); ");
			stmt.setInt(1, id);
			stmt.setString(2, nome);
			stmt.setDouble(3, longitudine);
			stmt.setDouble(4, latitudine);
			stmt.setDouble(5, flusso);
			
			stmt.setString(6, tipo);

			stmt.executeUpdate();

            stmt.close();
          
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
            try {
                if (stmt != null)
                    stmt.close();
              
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
	
		}}
	public static boolean verifica(int idStella,Connection conn) {
		
		
		PreparedStatement stmt = null;
	    boolean risultato = false;
	    

	    try {
	    	
	        stmt = conn.prepareStatement("SELECT * FROM filamento where id = ? ");
	        
	        stmt.setInt(1, idStella);
	        ResultSet rs=stmt.executeQuery();
	        
	        risultato= (rs.next());
	     
	        rs.close();
	        
	    }catch (SQLException se) {
	        se.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }  finally {
	        try {
	            if (stmt != null)
	                stmt.close();
	          
	        } catch (SQLException se2) {
	        	se2.printStackTrace();
	        }
	    }     

	    return risultato;
	}
	  public static ArrayList<Stella> ottieniTutteStelle() throws ClassNotFoundException{
		   ArrayList<Stella> stelle = new ArrayList<Stella>();
		   Connection conn = null;
		   PreparedStatement statement1 = null;
		   ResultSet rs = null;
		   try {

				Class.forName(driverName);
			}
				catch (ClassNotFoundException e) 
				{
				     
					e.printStackTrace();
				}
			try {
				conn=DriverManager.getConnection(url,id,password);
			   statement1 = conn.prepareStatement("SELECT * from stella");
				 //inizializzo l'array dei punti di contorno appartenenti al filamento di input
				 rs = statement1.executeQuery();
		   
			   while(rs.next()) {
				   Stella Stella =new Stella(rs.getString("tipo"), rs.getInt("id"), rs.getString("nome"), rs.getDouble("flusso"), rs.getDouble("latitudine"), rs.getDouble("longitudine"));
					 
					 stelle.add((Stella));
					 
			   }
		 }catch (SQLException se) {
			   se.printStackTrace();
		   } finally {
	     	   try {     		  
				   if (conn!=null)
					   conn.close();
			   }catch(SQLException se2) {
				   se2.printStackTrace();
			   }}
	     	   return stelle;
	  }
	  	
	  public static ArrayList<Stella> ottieniTutteStelleflusso() throws ClassNotFoundException{
		   ArrayList<Stella> stelle = new ArrayList<Stella>();
		   Connection conn = null;
		   PreparedStatement statement1 = null;
		   ResultSet rs = null;
		   try {

				Class.forName(driverName);
			}
				catch (ClassNotFoundException e) 
				{
				     
					e.printStackTrace();
				}
			try {
				conn=DriverManager.getConnection(url,id,password);
			   statement1 = conn.prepareStatement("SELECT * from stella order by flusso DESC");
				 //inizializzo l'array dei punti di contorno appartenenti al filamento di input
				 rs = statement1.executeQuery();
		   
			   while(rs.next()) {
				   Stella Stella =new Stella(rs.getString("tipo"), rs.getInt("id"), rs.getString("nome"), rs.getDouble("flusso"), rs.getDouble("latitudine"), rs.getDouble("longitudine"));
					 
					 stelle.add((Stella));
					 
			   }
		 }catch (SQLException se) {
			   se.printStackTrace();
		   } finally {
	     	   try {     		  
				   if (conn!=null)
					   conn.close();
			   }catch(SQLException se2) {
				   se2.printStackTrace();
			   }}
	     	   return stelle;
	  }
	   //metodo per salvarmi tutte le stelle del database in un arraylist
public static ArrayList<Stella> trovaStelleInFilamento(Integer idFilamento, ArrayList<Stella> stelle) throws ClassNotFoundException{
	   /** REQUISITO 9 **/
	   ArrayList<Stella> stelleTrovate = new ArrayList<Stella>();//array in cui inseriso tutte le stelle che si trovano nel contorno dell'id dato in input
	   ArrayList<ArrayList<Double>> puntiContorno = new ArrayList<ArrayList<Double>>();//array di punti i contorno
	   
	   Connection conn = null;
	   PreparedStatement statement1 = null;
	   ResultSet rs = null;
	   try {

			Class.forName(driverName);
		}
			catch (ClassNotFoundException e) 
			{
			    // gestione dell'eccezione 
				e.printStackTrace();
			}
		try {
			conn=DriverManager.getConnection(url,id,password);
			statement1 = conn.prepareStatement("SELECT longitudine, latitudine FROM contorno WHERE filamento = ?");
		 statement1.setInt(1, idFilamento);
		 //inizializzo l'array dei punti di contorno appartenenti al filamento di input
		 rs = statement1.executeQuery();
		 while (rs.next()) {
			 Double longitudine = rs.getDouble("longitudine");
			 Double latitudine = rs.getDouble("latitudine");
			 ArrayList<Double> punto = new ArrayList<Double>();
			 punto.add(longitudine);
			 punto.add(latitudine);
			 puntiContorno.add(punto);
		 }
		 ListIterator<Stella> stellaIterator = stelle.listIterator();
		 	 //attraverso l'iterator prendo due array e li confronto uno ad uno..(i due array sono tra puntidicontorno e stellebean)
		 
		 while (stellaIterator.hasNext()) {
     			 ListIterator<ArrayList<Double>> puntoContornoIterator = puntiContorno.listIterator();
				 double somma = 0;
			 	 Stella stellaCorrente = stellaIterator.next();
				 while (puntoContornoIterator.hasNext()) {
						 ArrayList<Double> puntoCorrente = puntoContornoIterator.next();
						 int indiceSuccessivo = puntoContornoIterator.nextIndex();
						 if (indiceSuccessivo == puntiContorno.size())
							 break;
						 ArrayList<Double> puntoSuccessivo = puntiContorno.get(indiceSuccessivo);

						 double numeratore = (((puntoCorrente.get(1)-stellaCorrente.getLongitudine())*(puntoSuccessivo.get(0)-stellaCorrente.getLatitudine())))-
								 				(((puntoCorrente.get(0)-stellaCorrente.getLatitudine())*(puntoSuccessivo.get(1)-stellaCorrente.getLatitudine())));
						 double denominatore = (((puntoCorrente.get(1)-stellaCorrente.getLongitudine())*(puntoSuccessivo.get(1)-stellaCorrente.getLongitudine())))
								 					+ (((puntoCorrente.get(0) - stellaCorrente.getLatitudine())*(puntoSuccessivo.get(0)*stellaCorrente.getLatitudine())));
						 double valore = numeratore/denominatore;
						 somma = somma +  Math.toRadians(Math.atan(valore));
				 }
			 if(Math.abs(somma) >= 0.01) {
					 	stelleTrovate.add(stellaCorrente);
			 }
		 }
		 rs.close();
		 statement1.close();
		 conn.close();
	 
   }catch (SQLException se) {
	   se.printStackTrace();
   } finally {
 	   try {     		  
		   if (conn!=null)
			   conn.close();
	   }catch(SQLException se2) {
		   se2.printStackTrace();
	   }
   }
   return stelleTrovate;  
}

public static ArrayList<Stella> trovaPosizioneStellaRispettoSpinaDorsale(Integer idFilamento) throws ClassNotFoundException{
	   /** REQUISITO 12 **/
	
		ArrayList<Stella> risultato= new ArrayList<Stella>();
		   ArrayList<Stella> stelleTrovate = new ArrayList<Stella>();//array in cui inseriso tutte le stelle che si trovano nel contorno dell'id dato in input
		   ArrayList<ArrayList<Double>> puntiSpinaDorsale = new  ArrayList<ArrayList<Double>>();
		   ArrayList<Stella> stelle= new ArrayList<Stella>();
		   stelle=DaoStella.ottieniTutteStelleflusso();
		   stelleTrovate=trovaStelleInFilamento(idFilamento,stelle);
		   puntiSpinaDorsale=DaoSegmento.trovaInformazioni(idFilamento);
		  
			try {
			
						ListIterator<Stella> stellaIterator = stelleTrovate.listIterator();
			 	 //attraverso l'iterator prendo due array e li confronto uno ad uno..(i due array sono tra puntidicontorno e stellebean)
			 
			 while (stellaIterator.hasNext()) {
	 			 ListIterator<ArrayList<Double>> puntoSpinaIterator = puntiSpinaDorsale.listIterator();
	 
	 			 Stella stellaCorrente = stellaIterator.next();
	 			 
					 while (puntoSpinaIterator.hasNext()) {
							 ArrayList<Double> puntoCorrente = puntoSpinaIterator.next();
							 
							 Double DistanzaMin = (Math.sqrt((double)(((puntoCorrente.get(1)- stellaCorrente.getLongitudine()))*(puntoCorrente.get(1)- stellaCorrente.getLongitudine())+((puntoCorrente.get(0)- stellaCorrente.getLatitudine()))*(puntoCorrente.get(0)- stellaCorrente.getLatitudine()))));;
							 Integer Id=stellaCorrente.getId();
							 Double Flusso=stellaCorrente.getValoreFlusso();
							 
							 int indiceSuccessivo = puntoSpinaIterator.nextIndex();
							 if (indiceSuccessivo == puntiSpinaDorsale.size()) {
								 Stella stella=new Stella(Id,Flusso,DistanzaMin);
								 risultato.add(0, stella);
								 break;}
							 ArrayList<Double> puntoSuccessivo = puntiSpinaDorsale.get(indiceSuccessivo);
							 
							 Double Distanza2 =(Math.sqrt((double)(((puntoSuccessivo.get(1)- stellaCorrente.getLongitudine()))*(puntoSuccessivo.get(1)- stellaCorrente.getLongitudine())+((puntoSuccessivo.get(0)- stellaCorrente.getLatitudine()))*(puntoSuccessivo.get(0)- stellaCorrente.getLatitudine()))));
							 Integer Id2=stellaCorrente.getId();
							 Double Flusso2=stellaCorrente.getValoreFlusso();
							 if(DistanzaMin>Distanza2) {
								 DistanzaMin=Distanza2;
								 Id=Id2;
								 Flusso=Flusso2;
							 }
							 
					 }}}catch (Exception se) {
						   se.printStackTrace();}
			 return risultato;

	}

public static ArrayList<Stella> trovaPosizioneStellaRispettoSpinaDorsale2(Integer idFilamento) throws ClassNotFoundException{
	   /** REQUISITO 12 **/
	ArrayList<Stella> risultato= new ArrayList<Stella>();
	   ArrayList<Stella> stelleTrovate = new ArrayList<Stella>();//array in cui inseriso tutte le stelle che si trovano nel contorno dell'id dato in input
	   ArrayList<ArrayList<Double>> puntiSpinaDorsale = new  ArrayList<ArrayList<Double>>();
	   ArrayList<Stella> stelle= new ArrayList<Stella>();
	   stelle=DaoStella.ottieniTutteStelleflusso();
	   stelleTrovate=trovaStelleInFilamento(idFilamento,stelle);
	   puntiSpinaDorsale=DaoSegmento.trovaInformazioni(idFilamento);
	  
		try {
		
					ListIterator<Stella> stellaIterator = stelleTrovate.listIterator();
		 	 //attraverso l'iterator prendo due array e li confronto uno ad uno..(i due array sono tra puntidicontorno e stellebean)
		 
		 while (stellaIterator.hasNext()) {
 			 ListIterator<ArrayList<Double>> puntoSpinaIterator = puntiSpinaDorsale.listIterator();
 
 			 Stella stellaCorrente = stellaIterator.next();
 			 
				 while (puntoSpinaIterator.hasNext()) {
						 ArrayList<Double> puntoCorrente = puntoSpinaIterator.next();
						 
						 Double DistanzaMin = (Math.sqrt((double)(((puntoCorrente.get(1)- stellaCorrente.getLongitudine()))*(puntoCorrente.get(1)- stellaCorrente.getLongitudine())+((puntoCorrente.get(0)- stellaCorrente.getLatitudine()))*(puntoCorrente.get(0)- stellaCorrente.getLatitudine()))));;
						 Integer Id=stellaCorrente.getId();
						 Double Flusso=stellaCorrente.getValoreFlusso();
						 
						 int indiceSuccessivo = puntoSpinaIterator.nextIndex();
						 if (indiceSuccessivo == puntiSpinaDorsale.size()) {
							 Stella stella=new Stella(Id,Flusso,DistanzaMin);
							 risultato.add(0, stella);
							 break;}
						 ArrayList<Double> puntoSuccessivo = puntiSpinaDorsale.get(indiceSuccessivo);
						 
						 Double Distanza2 =(Math.sqrt((double)(((puntoSuccessivo.get(1)- stellaCorrente.getLongitudine()))*(puntoSuccessivo.get(1)- stellaCorrente.getLongitudine())+((puntoSuccessivo.get(0)- stellaCorrente.getLatitudine()))*(puntoSuccessivo.get(0)- stellaCorrente.getLatitudine()))));
						 Integer Id2=stellaCorrente.getId();
						 Double Flusso2=stellaCorrente.getValoreFlusso();
						 if(DistanzaMin>Distanza2) {
							 DistanzaMin=Distanza2;
							 Id=Id2;
							 Flusso=Flusso2;
						 }
						 
				 }}}catch (Exception se) {
					   se.printStackTrace();}
		 return risultato;

}
public static void inserisciRileva(int iD2,String Tipologia,Connection conn) throws SQLException {
	ArrayList<Integer> Prestelle=new ArrayList<Integer>();
	ArrayList<Integer> Prostelle=new ArrayList<Integer>();
	ArrayList<Integer> Unbound=new ArrayList<Integer>();
	PreparedStatement stmt=null;
	
	switch(Tipologia) {
	
	case ("PRESTELLAR"):
	Prestelle.add(iD2);
	String	strumento="SPIRE";
	stmt=conn.prepareStatement("INSERT INTO rilevastella(stella,strumento) "+
            "VALUES (?,?); ");
	stmt.setInt(1, iD2);
	stmt.setString(2,strumento );

	stmt.executeUpdate();

	stmt.close();
	break;
	case ("PROTOSTELLAR"):
Prostelle.add(iD2);
	String	strumento1="PACS";	
	stmt=conn.prepareStatement("INSERT INTO rilevastella(stella,strumento) "+
            "VALUES (?,?); ");
	stmt.setInt(1, iD2);
	stmt.setString(2,strumento1 );

	stmt.executeUpdate();

	stmt.close();
	break;
	case ("UNBOUND"):
		Unbound.add(iD2);
	String	strumento2="IRAC";
	stmt=conn.prepareStatement("INSERT INTO rilevastella(stella,strumento) "+
            "VALUES (?,?); ");
		stmt.setInt(1, iD2);
		stmt.setString(2,strumento2 );

		stmt.executeUpdate();

		stmt.close();
		break;
	}
}
	
public static void updateRileva(int iD2,String Tipologia,Connection conn) throws SQLException {
	ArrayList<Integer> Prestelle=new ArrayList<Integer>();
	ArrayList<Integer> Prostelle=new ArrayList<Integer>();
	ArrayList<Integer> Unbound=new ArrayList<Integer>();
	PreparedStatement stmt=null;
	
	switch(Tipologia) {
	
	case ("PRESTELLAR"):
	Prestelle.add(iD2);
	String	strumento="SPIRE";
	stmt=conn.prepareStatement("update rilevastella set stella=? strumento=?  ;");
	stmt.setInt(1, iD2);
	stmt.setString(2,strumento );
	
	stmt.executeUpdate();

	stmt.close();
	break;
	case ("PROTOSTELLAR"):
Prostelle.add(iD2);
	String	strumento1="PACS";	
	stmt=conn.prepareStatement("update rilevastella set stella=? strumento=? ; ");
	stmt.setInt(1, iD2);
	stmt.setString(2,strumento1 );
	
	stmt.executeUpdate();

	stmt.close();
	break;
	case ("UNBOUND"):
		Unbound.add(iD2);
	String	strumento2="IRAC";
	stmt=conn.prepareStatement("update rilevastella set stella=? strumento=? ; ");
		stmt.setInt(1, iD2);
		stmt.setString(2,strumento2 );
		
		stmt.executeUpdate();

		stmt.close();
		break;
	}
}}	
		
		/*
		 *}catch(SQLException se){
		se.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
        try {
            if (stmt != null)
                stmt.close();
          
        } catch (SQLException se2) {
        	se2.printStackTrace();
        }

	}}
} 
		 */
	
