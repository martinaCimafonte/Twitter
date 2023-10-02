import java.io.ByteArrayOutputStream; //implementa Serializable
import java.io.PrintStream;
import javax.swing.JTextArea;

/**
 * ha il ruolo di interfaccia con la console di eclipse in modo da  dirottare le stampe 
 *  in un'interfaccia grafica.
 * @author Martina Cimafonte
 */
public class JConsole extends JTextArea {  

	//Prende in input una stringa(quella del System.out), e tale stringa la trasforma in un qualcosa che sia adattabile a JConsole

	private static final long serialVersionUID = 1L;
	private PrintStream printStream;

	  public JConsole() {
	    printStream = new PrintStream(new ConsolePrintStream()); 
	  }

	  public PrintStream getPrintStream() {
	    return printStream;
	  }

	  /** ConsolePrintStream è una classe interna modellata per poterla collegare direttamente ad un qualsiasi PrintStream
	   *  oltre al System.out. Dunque è possibile collagarla ad un qualsiasi output di dati.
	   */
	  private class ConsolePrintStream extends ByteArrayOutputStream {
		 // ridefinizione del metodo write della superclasse ByteArrayOutputStream.
	    public synchronized void write(byte[] b, int off, int len) {  
	      setCaretPosition(getDocument().getLength());
	      String str = new String(b);
	     //ogni flusso di byte scritto sullo stream lo aggiungiamo alla JTextArea tramite il metodo append().
	      append(str.substring(off, len));
	    }
	  }
}