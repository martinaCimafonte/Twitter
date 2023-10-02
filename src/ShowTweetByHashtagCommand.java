/**
 * implementa la richiesta dell'admin relativa alla visualizzazione
 * dei tweet categorizzati per hashtag. 
 * @author Martina Cimafonte
 */
public class ShowTweetByHashtagCommand implements Command {
	
	private Receiver receiver;
	  
	  public ShowTweetByHashtagCommand (Receiver r)
	  {
		  receiver=r;
	  }
	  /** Implementazione del metodo definito nell'interfaccia Command.
		 * il metodo execute() passa la richeista al ricevitore che svolge il lavoro vero e proprio.
		 */
		@Override
		public void execute() {

	     receiver.showTweetByHashtag();

		}

}
