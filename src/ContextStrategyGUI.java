import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *  mantiene un riferimento a una delle strategie concrete e comunica
 * con quest'oggetto solo tramite interfaccia della strategia ( IStrategy).
 * Chiama il metodo di esecuzione sull'oggetto strategia collegato e lo fa ogni volta che l'utente
 * sceglie quale strategia di invio del messaggio intende attuare.
 * @author Martina Cimafonte
 *
 */
public class ContextStrategyGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	JButton twitterButton, smsButton,mailButton;
	IStrategy access_strategy;
	public ContextStrategyGUI() {
		    setTitle("Finestra di Accesso");
	        setSize(300, 160);
	        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Marti\\OneDrive\\Desktop\\Twitter\\Image\\twitter_icon.png"));
	        getContentPane().setBackground(new Color(14,153,226));
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new FlowLayout());
	        setLocationRelativeTo(null);

	        twitterButton = new JButton("Accedi a Twitter");
	        mailButton = new JButton("Accedi alla Posta");
	        smsButton = new JButton("Scrivi un SMS");
            customizeTwitterButton();
            customizeMailButton();
            customizeSmsButton();
                

	        add(twitterButton);
	        add(mailButton);
	        add(smsButton);
	        
	        setVisible(true);
	        
	}

	
	private void customizeTwitterButton()
	{	twitterButton.setPreferredSize(new Dimension(195,30));
		twitterButton.setFont(new Font("Century Gothic", Font.BOLD,12));
		twitterButton.setBackground(Color.WHITE);
		twitterButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                dispose();
	                //  codice per l'accesso al sito Twitter
	                access_strategy=new WebSiteStrategy();
	                access_strategy.execute(); 
	            }
	        });
	}
	
	private void customizeMailButton()
	{   mailButton.setPreferredSize(new Dimension(195,30));
		mailButton.setFont(new Font("Century Gothic", Font.BOLD,12));
		mailButton.setBackground(Color.WHITE);
	   mailButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	dispose();
	                new MailStrategy().execute();
	            }
	        });
	}
	
  private void customizeSmsButton()
  {
	smsButton.setPreferredSize(new Dimension(195,30));
	smsButton.setFont(new Font("Century Gothic", Font.BOLD,12));
	smsButton.setBackground(Color.WHITE);
    smsButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            //  codice per l'accesso tramite SMS
        	  dispose();
        	  new TelephoneStrategy().execute();
          }
      });
  }
}

