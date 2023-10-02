/**
 *   implementa la richiesta dell'admin relativa alla visualizzazione
 * dei tweet, scritti dagli utenti, contenenti una determinata parola. 
 * @author Martina Cimafonte
 *
 */
public class ShowTweetByKeywordCommand implements Command {
	private Receiver receiver;
	private String input;
	
	public ShowTweetByKeywordCommand(Receiver r, String choice) {
		receiver=r;
		input=choice;
	}

	/** Implementazione del metodo definito nell'interfaccia Command.
	 * il metodo execute() passa la richeista al ricevitore che svolge il lavoro vero e proprio.
	 */
	@Override
	public void execute() {
		receiver.showTweetByKeyword(input);

	}

}
