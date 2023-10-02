import java.util.List;
import java.util.Map;

/**
 * si occupa di implementare effettivamente le operazioni richieste dall'admin.
 * @author Martina Cimafonte
 *
 */
public class Receiver {
	private  List<User> users_list;
	
	public Receiver( )
	{
		users_list=Twitter.getInstance().getUserFileManager().getListUsers();
	}
	
	/**
	 * scorre la lista degli utenti e per ciascuno di essi visualizza l'informazione
	 * relativa al numero di tweet ricevuti e inviati. 
	 */
	public void showUsers()
	{      
		 for ( User u: Twitter.getInstance().getUserFileManager().getListUsers())
	        {
	         System.out.println();	
	         System.out.println(" - Username: "+u.getUsername());
	         System.out.println("Ha ricevuto "+u.getNumTweetReceived()+ " tweet ed ha mandato "+ u.getNumTweetSent()+" tweet");
	         System.out.println();	
	        }	
		
	}	
	
	/**
	 *  Mostra i tweet in base agli hashtag.
	 * Si esegue la stampa della mappa presente nella classe Tweet, in modo da poter
	 * stampare, per ogni chiave, i valori associati a una tale chiave.
	 *  Dove per chiavi intendiamo gli hashtag e per lista di valori associati alla chiave intendiamo
	 *  la lista di messaggi contenenti quell'hashtag.
	 */
	public void showTweetByHashtag()
	{  
		 System.out.println();
		for (Map.Entry<String, List<String>> entry :Tweet.hashtags_map.entrySet()) {
            String chiave = entry.getKey();
            List<String> valori = entry.getValue();
            
            System.out.println("Tweet contenenti  " + chiave+ " : ");

            for (String valore : valori) {
                System.out.println("- " +chiave+" "+ valore);
            }
            System.out.println(); // Riga vuota tra le chiavi
            System.out.println();
        }
		
    }
	  
	/** analizza, per ogni utente, la lista dei messaggi che ha scritto e verifica
	 *  se vi sono messaggi contenenti una determinata parola chiave.
	 * @param keyword stringa data in input al metodo per verificare se esistono tweet che la contengono. 
	 */
	public void showTweetByKeyword(String keyword)
	{  boolean keyCheck=false;
		   System.out.println();
		    for( User u: users_list)
		    {
		    	for( Tweet t: u.getTweetsList())
		    	{
		    		if (t.getTweet().contains(keyword))
		    		{   keyCheck=true;
		    			System.out.println(" "+u.getUsername()+" : "+t);
		    			System.out.println();
		    		}
		    	}
		    							
		    }
		    
		    if(!keyCheck)
		    {
		    	System.out.println(" la parola  "+keyword +" non è presente in nessun tweet!");
		    }
	}
}
