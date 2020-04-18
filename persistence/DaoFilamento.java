package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;


import application.model.Filamento;

public class DaoFilamento {
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
	

    public static Filamento findFilamentoId(int InputId) {
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
		String sql="SELECT * FROM \"filamento\" WHERE \"id\"='" +InputId+ "';";
		ResultSet rs=stm.executeQuery(sql);
		if(rs.next()) {

	   Filamento filamento=new Filamento(rs.getString(1), rs.getInt(0), rs.getDouble(2),rs.getDouble(5),rs.getDouble(4),rs.getDouble(3));
		

	   return filamento;
		}
		if(con != null)
		 con.close();
		if(stm != null)
		 stm.close();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return null;
	
    
	
    }
    public static String findPosizioneNome(String InputId) {
    	Filamento filamento =new Filamento(InputId);
		
		String risultato = null;
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
		String sql="SELECT avg(longitudine) ,avg(latitudine) FROM contorno join filamento on (contorno.filamento=filamento.id) WHERE filamento.nome=? ";

		stm=con.prepareStatement(sql);
		stm.setString(1, filamento.getNome());

			ResultSet res = stm.executeQuery();
			while (res.next()) 
			risultato=""+res.getDouble(1)+","+res.getDouble(2)+"";
			
				res.close();
				con.close();
				
		}catch(SQLException SQLex) {
				SQLex.printStackTrace();
				
			}

		
		
	return risultato;
    
	
    }

public static String findEstensioneNome(String InputId) {
	Filamento filamento =new Filamento(InputId);
	
	String risultato = null;
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
	String sql="SELECT  ((max(latitudine)-min(latitudine)),(max(longitudine)-min(longitudine)))  FROM contorno join filamento on (contorno.filamento=filamento.id) WHERE filamento.nome = ? ";

	stm=con.prepareStatement(sql);
	stm.setString(1, filamento.getNome());

		ResultSet res = stm.executeQuery();
		while (res.next()) 
		
		risultato=""+res.getDouble(1)+","+res.getDouble(2)+"";
			res.close();
			con.close();
			
	}catch(SQLException SQLex) {
			SQLex.printStackTrace();
			
		}

	
	
return risultato;


}
public static String findNumeroSegmentiId(int idFilamento) {
	// TODO Auto-generated method stub

	Filamento filamento =new Filamento(idFilamento);
	
		String risultato = null;
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
		String sql="SELECT  count(filamento.id) FROM segmento join filamento on (segmento.filamento=filamento.id) WHERE segmento.filamento=? ";

		stm=con.prepareStatement(sql);
		stm.setInt(1, filamento.getIdFilamento());

			ResultSet res = stm.executeQuery();
			while (res.next()) 
			
			risultato=""+res.getInt(1);
				res.close();
				con.close();
				
		}catch(SQLException SQLex) {
				SQLex.printStackTrace();
				
			}

		
		
	return risultato;


	

}

public static String findNumeroSegmentiNome(String Nome) {
	// TODO Auto-generated method stub
	   	Filamento filamento =new Filamento(Nome);
		String risultato = null;
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
		String sql="SELECT  count(filamento.id) FROM segmento join filamento on (segmento.filamento=filamento.id) WHERE filamento.nome =? ";

		stm=con.prepareStatement(sql);
		stm.setString(1, filamento.getNome());

			ResultSet res = stm.executeQuery();
			while (res.next()) 
			
			risultato=""+res.getInt(1);
				res.close();
				con.close();
				
		}catch(SQLException SQLex) {
				SQLex.printStackTrace();
				
			}

		
		
	return risultato;


	

}
public static String findPosizioneId(int InputId) {

	Filamento filamento =new Filamento(InputId);
		String risultato = null;
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
		String sql="SELECT avg(longitudine) ,avg(latitudine) FROM contorno join filamento on (contorno.filamento=filamento.id) WHERE contorno.filamento =? ";

		stm=con.prepareStatement(sql);
		stm.setInt(1, filamento.getIdFilamento());
	
		ResultSet res = stm.executeQuery();
			while (res.next()) 
			risultato=""+res.getDouble(1)+","+res.getDouble(2)+"";
			
				res.close();
				con.close();
				
		}catch(SQLException SQLex) {
				SQLex.printStackTrace();
				
			}

		
		
	return risultato;
    
	
    }

public static String findEstensioneId(int InputId) {
   	Filamento filamento =new Filamento(InputId);
	
	String risultato = null;
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
	String sql="SELECT  max(latitudine)-min(latitudine),max(longitudine)-min(longitudine)  FROM contorno join filamento on (contorno.filamento=filamento.id) WHERE contorno.filamento = ?";

	stm=con.prepareStatement(sql);
		stm.setInt(1, filamento.getIdFilamento());
		ResultSet res = stm.executeQuery();
	while (res.next()) 
		
		risultato=""+res.getDouble(1)+","+res.getDouble(2)+"";
			res.close();
			con.close();
	
	}catch(SQLException SQLex) {
			SQLex.printStackTrace();
			
		}
	

	
	
return risultato;


}

public static boolean verifica(int idFilamento,Connection conn) {
	
	
	PreparedStatement stmt = null;
    boolean risultato = false;
    

    try {
    	
        stmt = conn.prepareStatement("SELECT * FROM filamento where id =? ");
        
        stmt.setInt(1, idFilamento);
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



public static void creaFilamento(int id,String nome, Double flusso, Double dens, Double temp, Double ell, Connection conn) { 
    PreparedStatement stmt=null;
	
	
	try {
		
		
		stmt=conn.prepareStatement("INSERT INTO filamento(id, nome, flussototale, densitamedia, temperaturamedia, ellitticita) "+
				                   "VALUES (?,?,?,?,?,?); ");
		stmt.setInt(1, id);
		stmt.setString(2, nome);
		stmt.setDouble(3, flusso);
		stmt.setDouble(4, dens);
		stmt.setDouble(5, temp);
		stmt.setDouble(6, ell);
		
		
		
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
public static void creaFilamento(int id, Double flusso,String nome, Connection conn) { 
    PreparedStatement stmt=null;
	
	
	try {
		
		
		stmt=conn.prepareStatement("INSERT INTO filamento(id, nome, flussototale, densitamedia, temperaturamedia, ellitticita) "+
				                   "VALUES (?,?,?,?,?,?); ");
		stmt.setInt(1, id);
		stmt.setString(2, nome);
		stmt.setDouble(3, flusso);
		stmt.setNull(4, java.sql.Types.FLOAT);
		stmt.setNull(5, java.sql.Types.FLOAT);
		stmt.setNull(6, java.sql.Types.FLOAT);
		
		
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
public static void creaFilamento(int id, Double flusso ,Connection conn) { 
    PreparedStatement stmt=null;
	
	
	try {
		
		
		stmt=conn.prepareStatement("INSERT INTO filamento(id, nome, flussototale, densitamedia, temperaturamedia, ellitticita) "+
				                   "VALUES (?,?,?,?,?,?); ");
		stmt.setInt(1, id);
		stmt.setNull(2, java.sql.Types.VARCHAR);
		stmt.setDouble(3, flusso);
		stmt.setNull(4, java.sql.Types.FLOAT);
		stmt.setNull(5, java.sql.Types.FLOAT);
		stmt.setNull(6, java.sql.Types.FLOAT);
		
		
		
		
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
public static void updateFilamento(int id, Double flusso,Connection conn) {
    PreparedStatement stmt=null;
	
	
	try {
		
		stmt=conn.prepareStatement("UPDATE filamento "+
		                           "SET  flussototale = ? "+
				                   "WHERE id = ? ");
		
		//stmt.setNull(1, java.sql.Types.LONGVARCHAR);
		stmt.setDouble(1, flusso);
		//stmt.setNull(3, java.sql.Types.FLOAT);
		//stmt.setNull(4, java.sql.Types.FLOAT);
		//stmt.setNull(5, java.sql.Types.FLOAT);
		stmt.setInt(2,id);
		

		
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

public static void updateFilamento(int id, String nome, Double flusso, Double dens, Double temp, Double ell, Connection conn) {
    PreparedStatement stmt=null;
	
	
	try {
		
		stmt=conn.prepareStatement("UPDATE filamento "+
		                           "SET nome = ?, flussototale = ?, densitamedia = ?, temperaturamedia = ?, "+
		                           "ellitticita = ? "+
				                   "WHERE id = ? ");
		
		stmt.setString(1, nome);
		stmt.setDouble(2, flusso);
		stmt.setDouble(3, dens);
		stmt.setDouble(4, temp);
		stmt.setDouble(5, ell);
		stmt.setInt(6,id);
		

		
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
public static void updateFilamento(int id,  Connection conn) {
    PreparedStatement stmt=null;
	
	
	try {
		
		stmt=conn.prepareStatement("UPDATE filamento "+
		                           "SET nome = ?, flussototale = ?, densitamedia = ?, temperaturamedia = ?, "+
		                           "ellitticita = ? "+
				                   "WHERE id = ? ");
		
		
		stmt.setNull(1, java.sql.Types.LONGVARCHAR);
		stmt.setNull(2, java.sql.Types.FLOAT);
		stmt.setNull(3, java.sql.Types.FLOAT);
		stmt.setNull(4, java.sql.Types.FLOAT);
		stmt.setNull(5, java.sql.Types.FLOAT);
		stmt.setInt(6,id);
		

		
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
public static void updateContorno(int id, Double lon, Double lat,Double contrasto,Connection conn) {
   PreparedStatement stmt=null;
  
   try {
	  
	   stmt=conn.prepareStatement("UPDATE contorno"+
			   						"SET longitudine= ?, latitudine = ? ,contrasto=?" + "WHERE filamento=?");
	   stmt.setInt(4,id);
	   stmt.setDouble(3,contrasto);
	   stmt.setDouble(1, lon);
	   stmt.setDouble(2, lat);
	   
	   stmt.executeUpdate();
	   
    }catch (SQLException se) {  
        System.out.println("Rilevato un valore ridondante: [" + id + " ," + lon + " ," + lat + "]");
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
}
public static void updatecontorno(int id, Double contrasto,Connection conn) {
	   PreparedStatement stmt=null;
	  
	   try {
		  
		   stmt=conn.prepareStatement("UPDATE contorno SET contrasto=? WHERE filamento=?");
		   stmt.setInt(2,id);
		   stmt.setDouble(1,contrasto);
		 
		   
		   stmt.executeUpdate();
		   
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
	}
public static void creaContorno(int id, Double lon, Double lat,Connection conn) {
	   PreparedStatement stmt=null;
	  
	   try {
		  
		   stmt=conn.prepareStatement("Insert into contorno ( longitudine,latitudine,contrasto,filamento) Values (?,?,?,?);");
		   	stmt.setInt(4,id);	
		   	stmt.setDouble(2,lat);
		   	stmt.setDouble(1, lon);
		   	stmt.setNull(3,java.sql.Types.FLOAT);
	   			stmt.executeUpdate();
		   
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
	}
  
public static void creaContorno(int id,Double contrasto ,Connection conn) {
	   PreparedStatement stmt=null;
	  
	   try {
		  
		   stmt=conn.prepareStatement("INSERT INTO contorno(latitudine, longitudine,filamento, contrasto)"+
				   					" Values(?,?,?,?)");
		   stmt.setInt(3,id);
		   stmt.setNull(1, java.sql.Types.FLOAT);
		   stmt.setNull(2, java.sql.Types.FLOAT);
		   stmt.setDouble(4, contrasto);
		   stmt.executeUpdate();
		   
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
	}
public static void creaFilamento(int id,Connection conn) { 
    PreparedStatement stmt=null;
	
	
	try {
			stmt=conn.prepareStatement("INSERT INTO filamento(id, nome, flussototale, densitàmedia, temperaturamedia, ellitticità) "+
				                   "VALUES (?,?,?,?,?,?) ");
		stmt.setInt(1, id);
		stmt.setString(2, null);
		stmt.setNull(3, java.sql.Types.FLOAT);
		stmt.setNull(4, java.sql.Types.FLOAT);
		stmt.setNull(5, java.sql.Types.FLOAT);
		stmt.setNull(6, java.sql.Types.FLOAT);


		
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
 
public static boolean verificaComposizioneContorno(int id, Double l, Double lat, Connection conn) {
	PreparedStatement stmt = null;
    
    boolean risultato = false;
    

    try {
    	
        stmt = conn.prepareStatement("SELECT * FROM contorno where filamento = ? AND longitudine = ? AND latitudine = ? ");
        
        stmt.setInt(1, id);
        stmt.setDouble(2, l);
        stmt.setDouble(3, lat);
        ResultSet rs=stmt.executeQuery();
        
        risultato = (rs.next());
        
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
public static  ArrayList<Filamento> findFilamentoPerSegmenti(int min, int max) {
	Connection con=null;
    PreparedStatement stm=null;
    ArrayList<Filamento> FilamentiBea= new ArrayList<Filamento>();
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
	String sql="select distinct filamento.id,filamento.nome,filamento.flussototale,filamento.densitamedia,filamento.temperaturamedia,filamento.ellitticita" + 
			" from  filamento join segmento  on(filamento.id=segmento.filamento)  group by filamento.id having count(filamento.id)<?  and count(filamento.id)>?";
	stm=con.prepareStatement(sql);
	stm.setInt(2, min);
	stm.setInt(1, max);

		ResultSet res = stm.executeQuery();
		while (res.next()) {
	 

			 Filamento Filamento =new Filamento(res.getString("nome"), res.getInt("id"), res.getDouble("flussototale"), res.getDouble("ellitticita"), res.getDouble("temperaturamedia"),
					 res.getDouble("densitamedia"));
			
			 FilamentiBea.add((Filamento));
		}res.close();
			con.close();
	}catch(SQLException SQLex) {
			SQLex.printStackTrace();
			
		}
return FilamentiBea;

}
public static ArrayList<Filamento> findBrillantezza(Double min, Double max, Double contrastoFlusso) {
	Connection con=null;
    PreparedStatement stm=null;
    ArrayList<Filamento> FilamentiBea= new ArrayList<Filamento>();
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
	String sql="select filamento.nome,filamento.id,filamento.flussototale,filamento.ellitticita,filamento.temperaturamedia,filamento.densitamedia from  filamento join contorno  on(filamento.id=contorno.filamento) where contorno.contrasto>=? and filamento.ellitticita>=? and filamento.ellitticita<=? group by id order by filamento.id ";
	stm=con.prepareStatement(sql);
	stm.setDouble(2, min);
	stm.setDouble(3, max);
	stm.setDouble(1, contrastoFlusso);
		ResultSet res = stm.executeQuery();
		while (res.next()) {
	 

			 Filamento Filamento =new Filamento(res.getString("nome"), res.getInt("id"), res.getDouble("flussototale"), res.getDouble("ellitticita"), res.getDouble("temperaturamedia"),
					 res.getDouble("densitamedia"));
			
			 FilamentiBea.add((Filamento));
		}res.close();
			con.close();
	}catch(SQLException SQLex) {
			SQLex.printStackTrace();
			
		}
return FilamentiBea;

}
public static ArrayList<Filamento> findFilamentiQuadrato(Double lato, Double latitudine, Double longitudine) {
	
	Connection con=null;
    PreparedStatement stm=null;
    ArrayList<Filamento> FilamentiBea= new ArrayList<Filamento>();
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
	String sql="select filamento.nome,filamento.id,filamento.ellitticita,filamento.temperaturamedia,filamento.flussototale,filamento.densitamedia from  filamento join contorno on(filamento.id=contorno.filamento) where contorno.latitudine<? and contorno.latitudine>? and contorno.longitudine>? and contorno.longitudine<? group by filamento.id";
	stm=con.prepareStatement(sql);
	
	stm.setDouble(1, latitudine+ lato/2);
	stm.setDouble(2, latitudine- lato/2);
	stm.setDouble(3, longitudine- lato/2);
	stm.setDouble(4, longitudine+ lato/2);

	
		ResultSet res = stm.executeQuery();
		while (res.next()) {
	 

			 Filamento Filamento =new Filamento(res.getString(1), res.getInt(2), res.getDouble(5), res.getDouble(3), res.getDouble(4),
					 res.getDouble(6));
			 
			 FilamentiBea.add((Filamento));
		}res.close();
			con.close();
	}catch(SQLException SQLex) {
			SQLex.printStackTrace();
			
		}

return FilamentiBea;
}
public static ArrayList<Filamento> findFilamentiCerchio(Double raggio, Double latitudine, Double longitudine) {
	
	ArrayList<Filamento> FilamentiBea= new ArrayList<Filamento>();
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
	String sql="select filamento.nome,filamento.id,filamento.ellitticita,filamento.temperaturamedia,filamento.flussototale,filamento.densitamedia from  filamento join contorno  on(filamento.id=contorno.filamento) where SQRT((longitudine - ?*(longitudine-?)) + ((latitudine - ?)*(latitudine-?))) < ?"+ "GROUP BY filamento.id"; 
	stm=con.prepareStatement(sql);
	stm.setDouble(5, raggio);
	stm.setDouble(4, latitudine);
	stm.setDouble(3, latitudine);
	stm.setDouble(1, longitudine);
	stm.setDouble(2, longitudine);
		ResultSet res = stm.executeQuery();
		while (res.next()) {
	 
			 Filamento Filamento =new Filamento(res.getString(1), res.getInt(2), res.getDouble(5), res.getDouble(3), res.getDouble(4),
					 res.getDouble(6));
			
			 FilamentiBea.add((Filamento));
		}res.close();
			con.close();
	}catch(SQLException SQLex) {
			SQLex.printStackTrace();
			
		}
return FilamentiBea;
}
public static ArrayList<Filamento> trovaFilamentiInQuadrilatero(Double longitudineCentroide,
		Double latitudineCentroide, Double base, Double altezza) throws ClassNotFoundException {
	
		   ArrayList<Filamento> FilamentiBea2 = new ArrayList<Filamento>();

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
			String sql="select filamento.nome,filamento.id,filamento.flussototale,filamento.ellitticita,filamento.temperaturamedia,filamento.densitamedia from  filamento join contorno  on(filamento.id=contorno.filamento) where contorno.latitudine<? and contorno.latitudine>? and contorno.longitudine>? and contorno.longitudine<? group by filamento.id";
			stm=con.prepareStatement(sql);;
			 stm.setDouble(1, longitudineCentroide + base/2);
			 stm.setDouble(2, longitudineCentroide - base/2);
			 stm.setDouble(3, latitudineCentroide - altezza/2);
			 stm.setDouble(4, latitudineCentroide + altezza/2);
			
			 ResultSet rs = stm.executeQuery();
			 while (rs.next()) {
			 Filamento Filamento =new Filamento(rs.getString("nome"), rs.getInt("id"), rs.getDouble("flussototale"), rs.getDouble("ellitticita"), rs.getDouble("temperaturamedia"),
					 rs.getDouble("densitamedia"));
			
			 FilamentiBea2.add((Filamento));
		}rs.close();
			con.close();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		 return FilamentiBea2;
	   }
public static String prendiDistanza(Double latitudine, Double longitudine, int idsegmento) {
	String risultato = null;
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
	String sql="select min (sqrt((?-contorno.latitudine)*(?-contorno.latitudine)+(?-contorno.longitudine)*(?-contorno.longitudine)))as distanza\r\n" + 
			"from segmento join filamento on segmento.filamento=filamento.id join contorno on filamento.id=contorno.filamento\r\n" + 
			"where segmento.id=?"
			+ "order by distanza;";
	stm=con.prepareStatement(sql);
		stm.setDouble(1,latitudine);
		stm.setDouble(2,latitudine);
		stm.setDouble(3,longitudine);
		stm.setDouble(4,longitudine);
		stm.setDouble(5,idsegmento);

		ResultSet res = stm.executeQuery();
		while (res.next()) 
		
		risultato=""+res.getDouble(1);
			res.close();
			con.close();
			
	}catch(SQLException SQLex) {
			SQLex.printStackTrace();
			
		}

	
	
return risultato;


}
}














