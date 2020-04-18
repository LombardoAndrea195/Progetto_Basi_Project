package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.bean.PuntoContornoBean;
import application.model.PuntoDiContorno;

public class DaoPuntoContorno {
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
	public static void aggiungiPuntoContorno(Double latitudine,Double longitudine) throws  SQLException {
    		PuntoDiContorno Punto=new PuntoDiContorno(latitudine,longitudine);
    		
    		
    		
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
    				String sql="INSERT INTO puntodicontorno(latitudine,longitudine)" + "VALUES ('"+Punto.getLatitudine()+"','"+Punto.getLongitudine()+"'"; 
       				stm.executeUpdate(sql);
    	            
                	stm.close();
                	con.close();
            	} catch (SQLException e) {
            		e.printStackTrace();
            	}
	}
		
	public static boolean verifica(Double longitudine, Double latitudine, Connection conn) {
		// TODO Auto-generated method stub
		
			
			PreparedStatement stmt = null;
		    boolean risultato = false;
		    

		    try {
		    	
		        stmt = conn.prepareStatement("SELECT * FROM puntodicontorno where longitudine = ? AND latitudine = ? ");
		        
		        stmt.setDouble(1, longitudine);
				stmt.setDouble(2, latitudine);
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

	public static void creaPuntoContorno(Double l, Double lat, Connection conn) {
		
		PreparedStatement stmt=null;
	
		
		try {
			
			stmt=conn.prepareStatement("INSERT INTO puntodicontorno(longitudine, latitudine) "+
					                   "VALUES (?,?) ");
			stmt.setDouble(1, l);
			stmt.setDouble(2, lat);
							
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
	



