import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *  modella il ruolo dell'utente iscritto a Twitter.
 * L'utente fa riferimento ad un Mediator per poter ricevere  i messaggi scritti dagli utenti che segue 
 * e per poter comunicare ai suoi follower i tweet che scrive.
 * @author Martina Cimafonte
 */
public class User implements IUser{
 private int num_tweet_received,num_tweet_sent;
 private String name, surname, date_of_birth,username,password,tel,email;
 private List<User> following= new ArrayList<>();
 private List<User> followers= new ArrayList<>();
 private List<Tweet> tweets_list= new ArrayList<>(); 
 private Map<User,List<Tweet>> receivedTweetMap= new HashMap<>();
 private  Mediator mediator;

 
 public User(Mediator mediator,String name, String surname, String date_of_birth, String tel, String email, String username, String password)
 {
	 this.mediator=mediator;
	 num_tweet_received=0;
	 num_tweet_sent=0;
	 this.name=name;
	 this.surname=surname;
	 this.username=username;
	 this.password=password;
	 this.date_of_birth=date_of_birth;
	 this.email=email;
	 this.tel=tel;
 }


/**
 *  Prima di notificare il mediatore si effettuano opportuni controlli e eventuali aggiornamenti dati. 
 */
@Override
public void write_post(Tweet msg) throws MessageTooLongException  {
	
  //controlla che il tweet non super il limite di caratteri prestabilito (140 )
   msg.checkTweet(); 
   
   /*Verifica se il messaggio abbia o meno hashtag per poter,eventualemnte, aggiornare
    *  la mappa che gestisce i messaggi categorizzati per hashtag. 
    */
   msg.checkHashtag(); 
   
    //aggiorna il contatore che tiene traccia del numero di tweet che l'utente ha postat  
	num_tweet_sent++;
	
	//aggiungi il tweet postato alla lista che tiene traccia di tutti i messaggi postati dall'utente
	tweets_list.add(msg);
	
	//invia al mediator il tweet creato passando come parametro il messaggio scritto e l'istanza
	//dell'utente che ha creato il messaggio ossia l'istanza stessa della classe
	mediator.sendTweet(msg, this);
	
}

/**
 *  Aggiorna  receivedTweetMap, mappa che memorizza tweet ricevuti, dove la chiave è il mittente (sender_user)
 *  e il valore associato è una lista di tweet inviati da quel mittente
 */

@Override
public void receive_post(Tweet tweet, User sender_user) {
	// aggiorna contatore che tiene traccia del numero di tweet ricevuti
	num_tweet_received++;
	//aggiorna la mappa che tiene traccia, per ogni utente seguito, la lista contenente
	// i messaggi postati
	receivedTweetMap.computeIfAbsent(sender_user, k -> new ArrayList<>()).add(tweet);	
}

/**  aggiunge un follower alla lista che tiene traccia degli utenti seguiti
 */
@Override
public void follow_user(User usr) {
	
	following.add(usr); //aggiorno la lista degli utenti seguiti
	usr.getFollowers().add(this); // aggiorno la lista follower dell'utente che ho iniziato a seguire
	
}

 public List<User> getFollowers()
 {
	 return followers;
 }
 
 public List<User> getFollowing()
 {
	 return following;
 }
 
 public List<Tweet> getTweetsList()
 {
	 return tweets_list;
 }
 
 
 public Map<User,List<Tweet>> getTweetsReceivedMap()
 {
	 return receivedTweetMap;
 }
 
 public String getName() { return name;}
 public String getSurname() { return surname;}
 public String getEmail() { return email;}
 public String getTel() { return tel;}
 public String getUsername() { return username;}
 public String getPassword() { return password;}
 public String getDataOfBirth() { return date_of_birth;}
 public int getNumTweetReceived() { return num_tweet_received;}
 public int getNumTweetSent() { return num_tweet_sent;}
 
 @Override
	public String toString()
	{
		return this.username+" ";
	}

}
