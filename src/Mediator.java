/**
 *  interfaccia che dichiara un metodo di comunicazione dei tweet.
 * La politica di comunicazione della piattaforma stabilisce che ogni tweet postato da un utente
 *  viene ricevuto solo dagli utenti che lo seguono. 
 *  Implementando l'interfaccia mediator si permette di applicare tale politica
 * @author Martina Cimafonte
 *
 */
public interface Mediator {
	public void sendTweet(Tweet tweet, User sender_usr);

}
