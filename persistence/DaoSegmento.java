package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import application.bean.SegmentoBean;
import application.model.Segmento;

public class DaoSegmento {
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
	
    public static Segmento findSegmentoId(int InputId) {
    	Segmento Segmento=new Segmento();
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
		String sql="SELECT * FROM \"segmento\" WHERE \"id\"='" +InputId+ "';";
		ResultSet rs=stm.executeQuery(sql);
		if(rs.next()) {
			Segmento.setIdSegmento(rs.getInt(1));
			Segmento.setTipoSegmento(rs.getString(0));
		
		}
		if(con != null)
		 con.close();
		if(stm != null)
		 stm.close();
 	
	}catch(SQLException e) {
		e.printStackTrace();
	}

	return Segmento;
    
	
    }
	public static boolean verifica(int idSegmento,Connection conn) {
		
		
		PreparedStatement stmt = null;
	    boolean risultato = false;
	    

	    try {
	    	
	        stmt = conn.prepareStatement("SELECT * FROM segmento where id = ? ");
	        
	        stmt.setInt(1, idSegmento);
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
	public static void creaSegmento( int iDSegmento, String tipo,int filamento,double flussoMisurato, Connection conn) {
		
		PreparedStatement stmt=null;
		
		try {
			
			
			stmt=conn.prepareStatement("INSERT INTO segmento( id,tipo,filamento,flussomisurato) "+
					                   "VALUES (?,?,?,?); ");
			
			stmt.setInt(1, iDSegmento);
			stmt.setString(2,tipo);			
			stmt.setInt(3, filamento);
			stmt.setDouble(4, flussoMisurato);
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
	public static ArrayList<ArrayList<Double>> trovaInformazioni(int idFilamento){
		 Connection conn = null;
		   PreparedStatement stmt = null;
		   ResultSet res = null;
		   ArrayList<ArrayList<Double>> puntoSpinaDorsale = new ArrayList<ArrayList<Double>>();
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
				stmt = conn.prepareStatement("select latitudine,longitudine from segmento join puntodisegmento on segmento.id=puntodisegmento.segmento where tipo='S' and segmento.filamento=?");
				stmt.setInt(1, idFilamento);
				res=stmt.executeQuery();
			   while(res.next()) {
				   Double longitudine = res.getDouble("longitudine");
				   Double latitudine = res.getDouble("latitudine");
					 ArrayList<Double> punto = new ArrayList<Double>();
					 punto.add(longitudine);
					 punto.add(latitudine);
					 puntoSpinaDorsale.add(punto);
			   }
			   res.close();
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
			 
			 

	}return puntoSpinaDorsale;
	}
	public static void updateSegmento(int iDSegmento, String tipo, int iDFilamento, double flusso, Connection conn) {
		// TODO Auto-generated method stub
	PreparedStatement stmt=null;
		
		try {
			
			
			stmt=conn.prepareStatement("UPDATE segmento set tipo=?,filamento=?,flussomisurato=? "+
					                   "where id=?; ");
			
			stmt.setInt(4, iDSegmento);
			stmt.setString(1,tipo);			
			stmt.setInt(2, iDFilamento);
			stmt.setDouble(3, flusso);
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
