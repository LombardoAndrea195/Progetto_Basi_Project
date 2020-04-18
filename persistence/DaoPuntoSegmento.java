package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.bean.PuntoSegmentoBean;

import application.bean.SegmentoBean;
import application.model.PuntoDiSegmento;
import application.model.Segmento;


public class DaoPuntoSegmento {

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
	public static void aggiungiPuntoSegmento(Double latitudine,Double longitudine,int idsegmento,int ordineprogressivo) throws  SQLException {
    	 		Segmento segmento=new Segmento(idsegmento);
    	 		PuntoDiSegmento Punto=new PuntoDiSegmento(latitudine,longitudine,segmento,ordineprogressivo);
    	 	   
    		
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
    				String sql="INSERT INTO puntodisegmento(latitudine,longitudine,segmento,ordineprogressivo)" + "VALUES ('"+Punto.getLatitudine()+"','"+Punto.getLongitudine()+"','"+segmento.getIdSegmento()+"','"+Punto.getOrdineProgressivo()+"'"; 
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
		    	
		        stmt = conn.prepareStatement("SELECT * FROM puntodisegmento where longitudine = ? AND latitudine = ? ");
		        
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
	public static void creaPuntoSegmento(Double longitudine, Double latitudine, int segmento,int ordineprogressivo, Connection conn) {
		
		PreparedStatement stmt=null;
		try {
			stmt=conn.prepareStatement("INSERT INTO puntodisegmento(longitudine, latitudine, segmento,numeroprogressivo) "+
					                   "VALUES (?,?,?,?); ");
			stmt.setDouble(1, longitudine);
			stmt.setDouble(2, latitudine);
			stmt.setInt(3, segmento);
			stmt.setInt(4,ordineprogressivo);
			
		
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
	
public static void creaPuntoSegmento(Double longitudine, Double latitudine,  Connection conn) {
		
		PreparedStatement stmt=null;
		try {
			stmt=conn.prepareStatement("INSERT INTO puntodisegmento(longitudine, latitudine, segmento,numeroprogressivo) "+
					                   "VALUES (?,?,?,?); ");
			stmt.setDouble(1, longitudine);
			stmt.setDouble(2, latitudine);
			stmt.setNull(3,java.sql.Types.FLOAT );
			stmt.setNull(4,java.sql.Types.INTEGER);
		
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
public static ArrayList<Double> findMinNumProgressivoSegmento(int idSegmento) {
	Double risultato = null;
	Connection con=null;
    PreparedStatement stm=null;
    ArrayList<Double> Array=new ArrayList<Double>();
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
	String sql="(select latitudine,longitudine from puntodisegmento where segmento=? and numeroprogressivo=(select min(numeroprogressivo) from puntodisegmento where segmento=?))";

	stm=con.prepareStatement(sql);
		stm.setInt(1, idSegmento);
		stm.setInt(2, idSegmento);
		ResultSet res = stm.executeQuery();
		
        
        
		while (res.next()) { 
		risultato=res.getDouble(1);// gli passo la latitudine
	Array.add(risultato);
	risultato=res.getDouble(2);// gli passo la longitudine
	Array.add(risultato);}
	// il mio array di float è composto da 2 float (che identificano latitudine e longitudine del vertice max)
			res.close();
			con.close();
			
	}catch(SQLException SQLex) {
			SQLex.printStackTrace();
			
		}

	
	
return Array;


}
public static ArrayList<Double> findMaxNumProgressivoSegmento(int idSegmento) {
	Double risultato = null;
	Connection con=null;
    PreparedStatement stm=null;
    ArrayList<Double> Array=new ArrayList<Double>();
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
	String sql=("(select latitudine,longitudine from puntodisegmento where segmento=? and numeroprogressivo=(select max(numeroprogressivo) from puntodisegmento where segmento=?))");

	stm=con.prepareStatement(sql);
	stm.setInt(1, idSegmento);
	stm.setInt(2, idSegmento);
		ResultSet res = stm.executeQuery();
		
		while (res.next()) {
		risultato=res.getDouble("latitudine");// gli passo la latitudine
		
	Array.add(risultato);
	risultato=res.getDouble("longitudine");// gli passo la longitudine
	Array.add(risultato);}
	// il mio array di float è composto da 2 float (che identificano latitudine e longitudine del vertice max)
			res.close();
			con.close();
			
	}catch(SQLException SQLex) {
			SQLex.printStackTrace();
			
		}

	
	
return Array;


}

	}