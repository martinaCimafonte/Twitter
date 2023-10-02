import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *  Gestisce l'accesso al file contenente l'elenco degli amministratori
 * del sito
 *  @author Martina Cimafonte
 */
public class AdminFileManager {
	// numero dei parametri necessari all'costruttore della classe Admin per autenticare l'amministratore. 
    private final int numInfoAdmin; 
    private String  fileNameAdmin;
    private  List <Admin> admins_list;
   
	public AdminFileManager() {
	    numInfoAdmin=4;
	    fileNameAdmin="Admins.txt";
	    admins_list= new ArrayList<>();
	    read_FileAdmins();
	    }
	
	
	  /**
	   *  legge il file in cui sono memorizzati i dati relativi agli amministratori
	   *  e, per ciascuna admin, si crea un istanza amministatore e lo si aggiunge ad admins_list.
	   * @return admins_list, lista che tiene traccia degli amministratori di Twitter.
	   */
	   private  List <Admin> read_FileAdmins() 
	   {
		   try (BufferedReader reader = new BufferedReader(new FileReader(fileNameAdmin))) {
		       String line;
		       while ((line = reader.readLine()) != null) {
		    	   String[] parts = line.split("\\s+");
		           if (parts.length >= numInfoAdmin) {
		        	  Admin a= new Admin(parts[0],parts[1],parts[2],parts[3]);
		              admins_list.add(a);
		           }
		       }
		   } catch (IOException e) {
		       System.err.println("Errore nella lettura del file: "+fileNameAdmin+" " + e.getMessage());
		   }
		   return admins_list;
	   }
	   
	   public List<Admin> getAdminsList() {
		   return admins_list;
	   }
	   
	   

}
