package application;

import java.sql.SQLException;

import application.ImportoCsv;

public class UploadFiles {

	

   
	public static void main(String[] args) throws SQLException {
		ImportoCsv csvInputManager = new ImportoCsv();
		csvInputManager.scanCsv("STELLE_HERSCHEL", "./BasiDati()/FILECSV/stelle_Herschel.csv");
		csvInputManager.scanCsv("SCHELETRO_HERSCHEL", "./BasiDati()/FILECSV/scheletro_filamenti_Herschel.csv");
		
//	csvInputManager.scanCsv("FILAMENTI_HERSCHEL", "./BasiDati()/FILECSV/filamenti_Herschel.csv");
	//csvInputManager.scanCsv("FILAMENTI_SPITZER", "./BasiDati()/FILECSV/filamenti_Spitzer.csv");
			   

	 //csvInputManager.scanCsv("SCHELETRO_SPITZER", "./BasiDati()/FILECSV/scheletro_filamenti_Spitzer.csv");

	 //csvInputManager.scanCsv("CONTORNI_SPITZER", "./BasiDati()/FILECSV/contorni_filamenti_Spitzer.csv");
		//csvInputManager.scanCsv("CONTORNI_HERSCHEL", "./BasiDati()/FILECSV/contorni_filamenti_Herschel.csv");

		
	
	
  
	}
}
