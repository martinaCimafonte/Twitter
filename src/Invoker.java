
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Responsabile dell'avvio delle richieste dell'amministratore .
 * Fornisce un interfaccia al client per poter visualizzare i risultati delle richieste
 * @author Martina Cimafonte
 */
public class Invoker  {
   private  Command command;
	
/**
 *  permette di attivare un comando invece di inviare la richiesta direttamente al receiver
 * @param cmd memorizza il riferimento all'oggetto command.
 * @param choice intero passato in input al metodo. Permette di settare la console appropriata, 
 * mostrando graficamente il risultato al client.
 */
public void placeCommand(Command cmd, int choice)
{
    switch (choice) {
        case 1:
        	this.command=cmd;
            setConsole1();
            break;
            
        case 2:
        	this.command=cmd;
            setConsole2();
            break;
            
        case 3:     	
            this.command=cmd;
            setConsole3();        
            break;    
    }
    
    command.execute();

}
  
private void setConsole1()
{    
	 //Interfaccia grafica
	 JConsole console = new JConsole();
	 console.setEditable(false);
	 //Collegamento del System.out alla JConsole
	 System.setOut(console.getPrintStream());  //metodi che  ci permettono di dirottare il System.out sull'output implementato 
	 System.setErr(console.getPrintStream());
	 
    JFrame frame = new JFrame("Twitter Console ");
    TitledBorder t= new TitledBorder("Elenco utenti in base ai messaggi ricevuti e inviati");
    t.setTitleColor(Color.white);
    console.setBorder(t);
    frame.getContentPane().add(new JScrollPane(console));
    frame.setSize(500,400);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    console.setBackground(new Color(14,153,226)); 
    console.setFont(new Font("Century Gothic", Font.BOLD,12));
    console.setForeground(Color.white);       
}

private void setConsole2()
{   
	 //Interfaccia grafica
	 JConsole console = new JConsole();
	 console.setEditable(false);
	 //Collegamento del System.out alla JConsole
	 System.setOut(console.getPrintStream());  //metodi che  ci permettono di dirottare il System.out sull'output implementato 
	 System.setErr(console.getPrintStream());
	 
   JFrame frame = new JFrame("Twitter Console ");
   TitledBorder t= new TitledBorder("Messaggi divisi in categorie in base agli hashtag");
   t.setTitleColor(Color.white);
   console.setBorder(t);
   frame.getContentPane().add(new JScrollPane(console));
   frame.setSize(500,400);
   frame.setVisible(true);
   frame.setLocationRelativeTo(null);
   console.setBackground(new Color(14,153,226)); 
   console.setFont(new Font("Century Gothic", Font.BOLD,12));
   console.setForeground(Color.white);    
	
}


private void setConsole3()
{ 	
	//Interfaccia grafica
	 JConsole console = new JConsole();
	 console.setEditable(false);
	 //Collegamento del System.out alla JConsole
	 System.setOut(console.getPrintStream());  //metodi che  ci permettono di dirottare il System.out sull'output implementato 
	 System.setErr(console.getPrintStream());
	 
    JFrame frame = new JFrame("Twitter Console ");
    TitledBorder t= new TitledBorder("Messaggi che contengono la parola inserita ");
    t.setTitleColor(Color.white);
    console.setBorder(t);
    frame.getContentPane().add(new JScrollPane(console));
    frame.setSize(550,400);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    console.setBackground(new Color(14,153,226)); 
    console.setFont(new Font("Century Gothic", Font.BOLD,12));
    console.setForeground(Color.white);  
	
}

}
