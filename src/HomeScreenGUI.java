import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * fornisce l'interfaccia grafica per il client dando la possibilità di scegliere
 * la modalità di accesso al servizio microblogging.
 * @author Martina Cimafonte
 */
public class HomeScreenGUI  {
	private JFrame f;
	private JButton userModeButton ;
    private JButton adminModeButton;
    
	public HomeScreenGUI()  {
		// imposta titolo della finestra
		 f=new JFrame("Benvenuto su Twitter ! ");
		 f.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Marti\\OneDrive\\Desktop\\Twitter\\Image\\twitter_icon.png"));

        // Crea i bottoni
        userModeButton = new JButton("Modalità Utente");
        adminModeButton = new JButton("Modalità Amministratore");
        
	}
	
	public void launchFrame()
	{   // Imposta il layout
		f.setLayout(new FlowLayout());
		 //setta colore del Frame
		f.getContentPane().setBackground(new Color(14,153,226));
		
		//decora i pulsanti 
         decorate_buttons();
         
	   // Aggiungi gli action listener per i pulsanti
         addActionToButton();
	    
	  // Aggiungi i bottoni al frame
        f.add(userModeButton);
        f.add(adminModeButton);
        
       // imposta logo twitter
       JLabel imageLabel =addLogo();

       // Aggiungi l'etichetta al frame
        
        f.add(imageLabel);
       
         // Imposta le dimensioni e fa apparire il frame
        f.setSize(305, 160);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    
	}
	
	private JLabel addLogo()
	{
		 ImageIcon image= new ImageIcon("Image/Twitter.png");

	        
		// Definisci le dimensioni desiderate per l'immagine ridimensionata
        int newWidth = 110;
        int newHeight = 30;

        // Ridimensiona l'immagine originale alla dimensione desiderata
        Image resizedImage = image.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        // Crea una nuova ImageIcon con l'immagine ridimensionata
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);       
        
        // Crea un'etichetta e assegna l'ImageIcon ad essa
       return new JLabel(resizedImageIcon);
	}
	
    private void decorate_buttons()
    {
    	Dimension buttonSize= new Dimension(195,30);
    	//decora bottone user
		userModeButton.setPreferredSize(buttonSize);
		userModeButton.setFont(new Font("Century Gothic", Font.BOLD,12));
		userModeButton.setBackground(Color.WHITE);
	
		//decora bottone admin
		adminModeButton.setPreferredSize(buttonSize);
		adminModeButton.setFont(new Font("Century Gothic", Font.BOLD,12));
		adminModeButton.setBackground(Color.white);
		
    }
    
    
    private void addActionToButton()
    {
    	 userModeButton.addActionListener(new ActionListener() {
 	        @Override
 	        public void actionPerformed(ActionEvent e) {
 	            // Gestisci il clic sul pulsante "Modalità Utente"
 	        	f.dispose();
 	           SwingUtilities.invokeLater(new Runnable() {
 	              @Override
 	              public void run() {
 	                  new ContextStrategyGUI();
 	              }
 	          });
 	        }
 	} );

 	    adminModeButton.addActionListener(new ActionListener() {
 	        @Override
 	        public void actionPerformed(ActionEvent e) {
 	        f.dispose(); 
 	            // Gestisci il clic sul pulsante "Modalità Amministratore"
 	           SwingUtilities.invokeLater(() -> {  
 	               new AdminLoginGUI().launchFrame();
 	              
 	          });
 	        }
 	    });
    	
    }
	
}
