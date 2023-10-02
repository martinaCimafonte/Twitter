import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *  rappresenta il messaggio che un
 * utente può scrivere all'interno dell'applicazione Twitter
 * @author Martina Cimafonte
 *
 */
public class Tweet {
 private String msg;
 private String hashtag="";
 private boolean checkHashtag=false;
 public static final int  MAX_LENGTH=140;
 public static Map<String,List<String>> hashtags_map= new HashMap<>();
 
 public Tweet(String tweet)
 {
	  this.msg=tweet;
	  
 }
  
 /**
  *  effettua controlli sul tweet scritto da un utente.
  * @return true se il messaggio non supera il limite dei 140 caratteri possibili .
  * @throws MessageTooLongException eccezione personalizzata lanciata nel caso si superi il limite 
  * dei caratteri possibili nella pubblicazione di un messaggio .
  */
 public boolean checkTweet() throws MessageTooLongException
 {
	 if (msg.length()> MAX_LENGTH )
	 {
		 throw new MessageTooLongException();
	 }
	 
	 return true;
 }
 
 /** controlla se il messaggio contiene un hashtag, in caso affermativo  inserisce il tweet nella hashtags_map,
  *  mappa che associa gli hashtag (come chiave) a una lista di messaggi correlati (come valore). 
  */
 public void checkHashtag()
 {
	 if (checkHashtag)
	 {
		 hashtags_map.computeIfAbsent(hashtag, k -> new ArrayList<>()).add(msg);
	 }
 }
 
 public void setHashtag(String hashtag)
 {
	 this.hashtag="#"+hashtag;
	 checkHashtag=true;
 }
 
 public String getHashtag() {
	 return hashtag;
 }
 
 public boolean getCheckHashtag() {
	 return checkHashtag;
 }

 public String getTweet() {return msg;}
 
 @Override
 public String toString()
 {
	 return this.hashtag+" "+this.msg; 
 }  
}
