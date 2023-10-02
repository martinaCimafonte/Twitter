/**
 * definisce il "contratto" che bisogna onorare per essere un utente e dunque
 * i metodi necessari che un utente deve implementare per essere tale.
 * @author Martina Cimafonte
 *
 */

public interface IUser {
	/**
	 *  permette ad un utente di inviare al mediator il tweet che ha postato. 
	 * Sarà il mediator a preoccuparsi di inoltrarlo ai follower di tale utente.
	 * @param msg, tweet pubblicato dall'utente.
	 * @throws MessageTooLongException
	 */
    public void write_post(Tweet msg) throws MessageTooLongException;
    
    /**
     *  consente al utente di essere notificato
     *   dal mediatore riguardo a un tweet postato da un utente che segue. 
     * @param tweet, messaggio che postato da un utente seguito 
     * @param sender_user, mittente del tweet postato
     */
    public void receive_post(Tweet tweet, User sender_user);
    
    /**
     * @param usr, nuovo utente che si intende seguire
     */
    public void follow_user(User usr);

    
    
}
