import java.util.Iterator;
/**
 * Con il pattern mediator incapsuliamo le relazioni di notifica dei tweet.
 * ConcreteMediator fa da mediatore tra un utente e i suoi follower, notificandoli
 * ogni qual volta un tweet viene postato .
 * @author Martina Cimafonte
 *
 */
public class ConcreteMediator implements Mediator {

	/** itera la lista di followers di sender_usr e
	 * notifica, a tutti gli utenti presenti in lista, il tweet pubblicato da sende_usr
	 * @param tweet, messaggio postato da un utente e mandato in input al mediatore concreto
	 * @param sender_usr, utente che ha postato il tweet
	 */
	@Override
	public void sendTweet(Tweet tweet, User sender_usr) {
		Iterator <User> u_iterator= sender_usr.getFollowers().iterator(); 
		while (u_iterator.hasNext())
		{    
		     u_iterator.next().receive_post(tweet, sender_usr);	
		}

	}

}

