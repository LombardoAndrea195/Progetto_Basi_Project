package application.persistence;

//import java.io.File;
import java.sql.*;

import application.bean.UtenteBean;
import application.exception.UtenteEsistenteException;
import application.model.Utente;

public class DaoUtente {
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
	
    public static Utente findUtente(String inputid,String inputpassword) {
    	Utente u=null;
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
		String sql="SELECT * FROM \"utenti\" WHERE \"id_user\"='" +inputid+ "' AND \"password\" ='"+inputpassword+"';";
		ResultSet rs=stm.executeQuery(sql);
		if(rs.next()) {
		
		String Type=rs.getString("Type");
		
		u=new Utente(rs.getString("id_user"),rs.getString("password"),rs.getString("nome"),rs.getString("cognome"),rs.getString("email"),Type);
		}
		if(con != null)
		 con.close();
		if(stm != null)
		 stm.close();
 	
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return u;
    
	
 }
    public static void aggiungiUtente(String nome,String cognome,String Password,String UserId,String Type,String Email) throws UtenteEsistenteException, SQLException {
    	try{
    		Utente u=new Utente(UserId,Password, nome,cognome, Email,Type);
    
    		if (!UtenteDisponibile(u.getUserid(),u.getPassword())) {
    			throw new UtenteEsistenteException();
    		}
    		
    		else {
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
    				String sql="INSERT INTO utenti (id_user, password, nome, cognome, email,type)" + "VALUES ('"+u.getUserid()+"', '"+u.getPassword()+"', '"+u.getNome()+"','"+u.getCognome()+"','"+u.getEmail()+"','"+u.getType()+"')"; 
       				stm.executeUpdate(sql);
    	            
                	stm.close();
                	con.close();
            	} catch (SQLException e) {
            		e.printStackTrace();
            	}
            }
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    public static void deleteUtente(String nome,String cognome,String Password,String UserId,String Type,String Email) throws UtenteEsistenteException, SQLException {
    	try{
    		Utente u=new Utente(UserId,Password, nome,cognome, Email,Type);
    	    
    		if (!UtenteDisponibile(u.getUserid(),u.getPassword())) {
    			throw new UtenteEsistenteException();
    		}
    		
    		else {
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
    				String sql="delete from utenti  where id_user=u.getUserid() and  password=u.getPassword() and nome=u.getNome() and cognome=u.getCognome() and email= u.getEmail() and type=u.getType())"; 
       				stm.executeUpdate(sql);
    	            
                	stm.close();
                	con.close();
            	} catch (SQLException e) {
            		e.printStackTrace();
            	}
            }
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    public static boolean UtenteDisponibile(String inputid,String inputpassword) throws UtenteEsistenteException, SQLException {
    	Utente u=null;
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
		String sql="SELECT * FROM \"utenti\" WHERE \"id_user\"='" +inputid+"';";
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next()) {
		u=new Utente(rs.getString("id_user"),rs.getString("password"));
		if( inputid==u.getUserid()){
			return false;
		}}
	}catch(Exception e) {
		e.printStackTrace();
	}
		if(con != null)
		 con.close();
		if(stm != null)
		 stm.close();
		return true;
		
    
    }
   
    }