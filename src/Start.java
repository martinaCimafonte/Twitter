/**
 * classe nella quale si avvia l'applicazione Twitter.
 * @author Martina Cimafonte
 *
 */
public class Start {
 
	public static void main(String[] args) throws MessageTooLongException {
		Twitter twitter= Twitter.getInstance();
		Mediator m= new ConcreteMediator();
		UserFileManager usr= new UserFileManager();
		twitter.setInfo(m, usr);
		
		// carica utenti e informazioni associate per inizializzare l'ambiente
	 	twitter.load_users();
	 	
		// lancia il programma
		twitter.accessPoint();
	    
        }
       
}
	

 

