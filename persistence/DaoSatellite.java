package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import application.bean.AgenziaSpazialeBean;
import application.bean.SatelliteBean;
import application.model.AgenziaSpaziale;
import application.model.Satellite;
public class DaoSatellite {

	private final  static String driverName="org.postgresql.Driver"; 	//classe del driver
	private final static String  databaseName="stelleBD";
	private final  static String id="postgres";
	private final  static String password="postgres";
	private final  static String url="jdbc:postgresql://localhost:5432/"+databaseName+"";
	public static void aggiungiSatellite( String nomeSatellite, String NomeAgenzia,Date dataInizio,String dataFine) throws  SQLException {
    		
    		AgenziaSpaziale Age=new AgenziaSpaziale(NomeAgenzia);
    		Satellite Sat=new Satellite(nomeSatellite,dataInizio,Age,dataFine);
    		
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
    				String sql="INSERT INTO satellite(datainizio, datafine, nome, agenziaspaziale)" + "VALUES ('"+Sat.getDataInizio()+"', '"+Sat.getDataFine()+"', '"+Sat.getNome()+"','"+Age.getNome()+"')"; 
       				stm.executeUpdate(sql);
    	            
                	stm.close();
                	con.close();
            	} catch (SQLException e) {
            		e.printStackTrace();
            	}
	}
	
	
	
	
	
	
	public static void aggiungiAgenzia(  String NomeAgenzia) throws  SQLException {
		
		AgenziaSpaziale Age=new AgenziaSpaziale(NomeAgenzia);
		
			PreparedStatement stmt = null;
		       boolean risultato = false;
				Connection con=null;
				
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
				
				String sql="INSERT INTO agenziaspaziale(nome)" + "VALUES (?); ";
				stmt=con.prepareStatement(sql);
				stmt.setString(1, Age.getNome());
   				stmt.executeUpdate();
	            
            	stmt.close();
            	con.close();
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
}

	public static void aggiungiSatellite(String nomeSatellite,Date dataInizio,String dataFine,String NomeAgenzia,Connection conn) {
		PreparedStatement stmt=null;
	
		try {
			stmt=conn.prepareStatement("INSERT INTO satellite(datainizio, datafine, nome, agenziaspaziale) "+
				                   "VALUES (?,?,?,?); ");
			stmt.setObject(1, dataInizio);
			stmt.setString(2, dataFine);
			stmt.setString(3, nomeSatellite);
			stmt.setString(4, NomeAgenzia);

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
	
	   

   
   public static void updateDataInizialeSatellite(String Nome,Date data,Connection conn) {
	    PreparedStatement stmt=null;
	
		
		try {
			stmt=conn.prepareStatement("UPDATE satellite SET datainizio = ? "+
					                   "WHERE nome = ? ");
			stmt.setString(1, Nome);
			stmt.setObject(2, data);
		
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
   
   public static void updateDataFineSatellite(String Nome,String data,Connection conn) {
	    PreparedStatement stmt=null;
	
		
		try {
			
			stmt=conn.prepareStatement("UPDATE satellite SET datafine = ? "+
			                           "WHERE nome = ? ");
			stmt.setString(1, Nome);
			stmt.setString(2, data);
		
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
   
   public static void updateAgenziaSatellite(String NomeSatellite,String NomeAgenzia,Connection conn) {
	    PreparedStatement stmt=null;
	
		
		try {
	
			stmt=conn.prepareStatement("UPDATE satellite SET agenziaspaziale = ? "+
					                    "WHERE nome = ? ");
			stmt.setString(1, NomeSatellite);
			stmt.setObject(2, NomeAgenzia);
		
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
   //per controllare l'esistenza di un satellite 
   public static boolean verifica(String Nome,Connection conn) {

   	
   	PreparedStatement stmt = null;
       boolean risultato = false;
       

       try {
       	
           stmt = conn.prepareStatement("SELECT * FROM satellite where nome = ? ");
           
           stmt.setString(1, Nome);
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
   public static boolean verifica(String Nome,Date datainiziale,String Agenzia) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
       boolean risultato = false;
		Connection con=null;
		
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
	           stmt = con.prepareStatement("SELECT * FROM satellite where nome = ? and datainizio=? and agenziaspaziale=? ");
	           
	           stmt.setString(1, Nome);
	           stmt.setDate(2, (java.sql.Date) datainiziale);
	           stmt.setString(3, Agenzia);
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







public static void aggiungiSatellite(String satellite, Connection conn) {
	
	 PreparedStatement stmt=null;
		//Connection conn=null;
		
		try {
			stmt=conn.prepareStatement("INSERT INTO satellite(datainizio, datafine, nome, agenziaspaziale) "+
					                   "VALUES (?,?,?,?); ");
			stmt.setNull(1, java.sql.Types.DATE);
			stmt.setNull(2, java.sql.Types.VARCHAR);
			stmt.setString(3, satellite);
			stmt.setString(4, null);
		
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

}







    

