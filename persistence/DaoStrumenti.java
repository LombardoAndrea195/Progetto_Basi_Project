package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.bean.BandaBean;

import application.bean.StrumentoBean;
import application.model.Banda;
import application.model.Strumento;

public class DaoStrumenti {

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
	public static boolean aggiungiCattura( String nomeStrumento, Double lunghezzaOnda) throws  SQLException {{
    		Strumento Str=new Strumento(nomeStrumento);
    		
    		Banda banda=new Banda(lunghezzaOnda);
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
    				String sql="INSERT INTO cattura(nome,lunghezzaonda)" + "VALUES ('"+Str.getNome()+"', '"+banda.getLunghezzaonda()+"')"; 
       				stm.executeUpdate(sql);
    	            
                	stm.close();
                	con.close();
            	} catch (SQLException e) {
            		e.printStackTrace();
            	}
	}
	return true;
}
	
	public static boolean aggiungiStrumento( String nomeStrumento) throws  SQLException {{
		Strumento Str=new Strumento(nomeStrumento);
		
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
				String sql="INSERT INTO strumento(nome)" + "VALUES ('"+Str.getNome()+"')"; 
   				stm.executeUpdate(sql);
	            
            	stm.close();
            	con.close();
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
}
	return true;
}
	

	public static boolean aggiungiBanda( Double lunghezzaonda) throws  SQLException {
		Banda banda=new Banda(lunghezzaonda);
		
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
				String sql="INSERT INTO banda(lunghezzaonda)" + "VALUES ('"+banda.getLunghezzaonda()+"')"; 
   				stm.executeUpdate(sql);
	            
            	stm.close();
            	con.close();
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
		    
return true;
	
}
	public static void inserisciMisura(String nomestrumento, String satellite,Connection conn) {
		PreparedStatement stmt=null;
		
		try {
		
			stmt=conn.prepareStatement("INSERT INTO misura(strumento, satellite) " +
			                           "VALUES (?, ?) ");
			stmt.setString(1, nomestrumento);
			stmt.setString(2, satellite);

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
	
	public static void inserisciBanda(Double banda,Connection conn) {
		PreparedStatement stmt=null;
		
		try {
		
			stmt=conn.prepareStatement("INSERT INTO banda(lunghezzaonda) " +
			                           "VALUES (?) ");
			stmt.setDouble(1, banda);
		

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
	public static void inserisciCattura(String nome, Double lunghezzaonda,Connection conn) {
		PreparedStatement stmt=null;
		
		try {
		
			stmt=conn.prepareStatement("INSERT INTO cattura(strumento, banda) " +
			                           "VALUES (?, ?) ");
			stmt.setString(1, nome);
			stmt.setDouble(2, lunghezzaonda);

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
	public static void inseriscistrumento(String nome,Connection conn) {
		PreparedStatement stmt=null;
		
		try {
		
			stmt=conn.prepareStatement("INSERT INTO strumento(nome) " +
			                           "VALUES (?) ");
			stmt.setString(1, nome);
			

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
	public static void inserisciIndividua(String strumento, int IDFilamento,Connection conn) {
		PreparedStatement stmt=null;
				try {
			
			stmt=conn.prepareStatement("INSERT INTO rileva(strumento, filamento) " +
			                           "VALUES (?,?) ");
			stmt.setString(1, strumento);
			stmt.setInt(2, IDFilamento);

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
	
	public static boolean verifica(String strumento, Connection conn) {
		// TODO Auto-generated method stub

    	
    	PreparedStatement stmt = null;
        boolean risultato = false;
        

        try {
        	
            stmt = conn.prepareStatement("SELECT * FROM strumento where nome = ? ");
            
            stmt.setString(1, strumento);
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

	public static boolean verifica(String strumento) {
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
            stmt = con.prepareStatement("SELECT * FROM strumento where nome = ? ");
            
            stmt.setString(1, strumento);
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
	public static boolean verifica(Double banda) {
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
            stmt = con.prepareStatement("SELECT * FROM banda where  lunghezzaonda= ? ");
            
            stmt.setDouble(1, banda);
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

	

	}
    

