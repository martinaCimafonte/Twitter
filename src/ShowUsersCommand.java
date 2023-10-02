/**
 *   implementa la richiesta dell'admin relativa alla visualizzazione
 *  del numero di messaggi ricevuti e inviati da ogni utente.
 * @author Martina Cimafonte
 *
 */
public class ShowUsersCommand implements Command {
  private Receiver receiver;
  
  public ShowUsersCommand (Receiver r)
  {
	  receiver=r;
  }
  
   /** Implementazione del metodo definito nell'interfaccia Command.
	 * il metodo execute() passa la richeista al ricevitore che svolge il lavoro vero e proprio.
	 */
  
	@Override
	public void execute() {
     receiver.showUsers();

	}

}
