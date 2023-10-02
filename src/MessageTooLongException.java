/**
 *rappresenta un'eccezione personalizzata che viene lanciata 
 * quando un messaggio supera  una determinata lunghezza massima (140 caratteri )
 * @author Martina Cimafonte
 *
 */
public class MessageTooLongException extends Exception {

	private static final long serialVersionUID = 1L;

	public MessageTooLongException()
	{
		super("Il messaggio pu� avere una lunghezza massima di 140 caratteri. ");
	}
	

}
