import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** gestisce la lettura/scrittura  del file contenente gli utenti iscritti a twitter.
 * @author Martina Cimafonte
 */
public class UserFileManager {
	    private final int numInfoUser; //// numero di campi che stanno  nel costruttore User 
	    private String fileNameUser;
	    List<User> users_list;
	    
	public UserFileManager() {
		numInfoUser=7;
	    fileNameUser="Users.txt";
	    users_list=new ArrayList<>();
	    read_FileUsers();
	}

	  /**legge il file in cui sono memorizzati i dati degli utenti e contestualmente 
	   * crea l'istanza utente passandogli al costruttore le credenziali lette dal file.
	   * @return users_list, lista degli utenti iscritti al servizio di microblogging
	   */
	 private List<User> read_FileUsers()
	   {  
		 // try-with-resource chiusura automatica del file
	   try (BufferedReader reader = new BufferedReader(new FileReader(fileNameUser))) {
	       String line;
	       while ((line = reader.readLine()) != null) {
	    	   String[] parts = line.split("\\s+");
	           if (parts.length >= numInfoUser) {
	        	   User usr=new User(Twitter.getInstance().getMediator(),parts[0],parts[1],parts[2],parts[3],parts[4],parts[5],parts[6]);
	        	   users_list.add(usr);
	           }
	       }
	   } catch (IOException e) {
	       System.err.println("Errore nella lettura del file: " +fileNameUser+" "+ e.getMessage());
	   }
		
	   return users_list;
	   }
	   
	 /** gestisce l'aggiornamento dei dati quando un nuovo utente si iscrive.
	  *  Aggiorna il file scrivendo le informazioni del nuovo utente e aggiunge l'utente in users_list,
	  *   gestendo eventuali errori di scrittura nel processo
	  * @param user nuovo utente registro a twitter.
	  */
	   public void updateFileUsers(User user)
	   {   
		   try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameUser,true))) {
	          writer.write("\n"+user.getName()+" "+user.getSurname()+" "+user.getDataOfBirth()+
	        		       " "+user.getUsername()+" "+user.getPassword()+ " "+user.getTel()+" "+
	        		        user.getEmail());   
	          
	          users_list.add(user);
	            
	       } catch (IOException e) { 
	    	   System.err.println("Errore nella scrittura sul file: " +fileNameUser+" "+ e.getMessage()); }
	   }
	   
	   
       public List<User> getListUsers()
	   {
	  	 return users_list;
	   } 
	   
}