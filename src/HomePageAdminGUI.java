import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;//implementa 
import java.io.IOException;

/**
 * Classe client nel pattern command. 
 * HomePageAdminGUI configura oggetti concreti che implemetano Command,
 * passa a tali oggetti concreti tutti i parametri necessari a evadere la richiesta, 
 * inclusa un'istanza del receiver. Successivamente il comando può essere associato all'invoker.
 * @author Martina Cimafonte
 */
public class HomePageAdminGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private BufferedImage twitterLogo = null;
	private JButton button1,button2,button3, logoutButton;
	private JPanel logoPanel;
	private JPanel mainPanel;
	private Receiver rec;
	private Invoker invoker;
	
	
	
public HomePageAdminGUI( String admin)  {	     
	
		//initializeInvoker();
	    rec =new Receiver();
	    invoker= new Invoker();
	    
		// Imposta il titolo della finestra
	    setTitle("Ciao, "+admin+" !");
	    
	    //Imposta icona 
	    setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Marti\\OneDrive\\Desktop\\Twitter\\Image\\twitter_icon.png"));
	    
	    // Imposta le dimensioni della finestra
	    setSize(650, 300);
	    
	    // Chiude l'applicazione quando si clicca sulla "X" in alto a destra
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		 // Crea un pannello per il menu di selezione
	    mainPanel = new JPanel();
	    mainPanel.setLayout(new GridLayout(6, 1)); // Numero di righe e colonne
	    mainPanel.setBackground(new Color(14,153,226)); 
	    
	    // Crea i bottoni del menu di selezione
	    button1 = new JButton("Mostra l'elenco degli utenti in base al numero di messaggi ricevuti/inviati");
	    button2 = new JButton("Visualizza i messaggi divisi in categorie in base agli hashtag");
	    button3 = new JButton("Cerca tutti i messaggi dei diversi utenti che contengono una parola");
	    
	    // Crea il bottone di logout
        logoutButton = new JButton("LOGOUT");
	    addActionToButtons();
	    addImages();
	    // Aggiungi i pannelli alla finestra
	       add(mainPanel, BorderLayout.WEST);
	       add(logoPanel, BorderLayout.CENTER); 
	        
	     // Mostra la finestra
	      setVisible(true);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setLocationRelativeTo(null);
	       
	    decorate_button();
	    
	    // Aggiungi i bottoni al pannello del menu di selezione
	   JLabel jlabel= new JLabel("Che operazione desideri effettuare ? ");
	   jlabel.setFont(new Font("Century Gothic", Font.BOLD,13));
	   jlabel.setForeground(Color.white);
	    mainPanel.add(jlabel);
	    mainPanel.add(button1);
	    mainPanel.add(button2); 
	    mainPanel.add(button3);
	  
	   // Aggiungi il bottone di logout in basso a sinistra (sesta riga)
	   mainPanel.add(new JLabel("")); 
       mainPanel.add(logoutButton);
           
}


		
private void addActionToButtons() {
    // Aggiungi un listener per ciascun pulsante
      actionToButton1(); 
      actionToButton2();
      actionToButton3();
      actionToButtonLogin();            
    }
    
   
private void decorate_button()
  {
	  Dimension buttonSize= new Dimension(450,60);
		//decora bottone1
		button1.setPreferredSize(buttonSize);
		button1.setFont(new Font("Century Gothic", Font.BOLD,11));
		button1.setBackground(Color.WHITE);
		
		//decora bottone2
		button2.setPreferredSize(buttonSize);
		button2.setFont(new Font("Century Gothic", Font.BOLD,11));
		button2.setBackground(Color.WHITE);
		
		//decora bottone3
		button3.setPreferredSize(buttonSize);
		button3.setFont(new Font("Century Gothic", Font.BOLD,11));
		button3.setBackground(Color.WHITE);
		
		//decora bottone di Login
		logoutButton.setFont(new Font("Century Gothic", Font.BOLD,11));
		logoutButton.setBackground(Color.WHITE);
  }
   
    
 private void addImages()
 {
	  // Carica l'immagine del logo Twitter  
	  try {
		    FileInputStream fis = new FileInputStream("Image/twitter_icon.png");
		    twitterLogo = ImageIO.read(fis);
		    fis.close();
		} catch (IOException ex) { ex.printStackTrace();}
	  
	    // Crea un pannello per l'immagine del logo Twitter
	     logoPanel = new JPanel() {
	    private static final long serialVersionUID = 1L;

			@Override
	        protected void paintComponent(Graphics g) {
	        	
	            super.paintComponent(g);
	            if (twitterLogo != null) {
	                g.drawImage(twitterLogo, 0, 0, getWidth(), getHeight(), this);
	            }
	            g.setColor(new Color(29,161,242));
	        }
	    };
	    
	    logoPanel.setBackground(new Color(14,153,226));	    	 
 }

 private void actionToButton1()
  {
	 	button1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              // Azione quando si clicca su Opzione 1
        	    ShowUsersCommand command= new ShowUsersCommand(rec);
				invoker.placeCommand(command, 1);
								
          }
      });
  }
    
  
private void actionToButton2()
  {
	  button2.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              // Azione quando si clicca su Opzione 2
        	 ShowTweetByHashtagCommand command= new ShowTweetByHashtagCommand(rec);
              invoker.placeCommand(command, 2);
          }
      });
  }
  
 private void actionToButton3()
  {
	  button3.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              // Azione quando si clicca su Opzione 3
        	  
        	  // Mostra una finestra di input stringa
         	  UIManager.put("OptionPane.background", Color.white); // Imposta il colore di sfondo
              UIManager.put("Panel.background", new Color(14,153,226)); // Imposta il colore di sfondo del pannello interno
        	  
              String inputWord = JOptionPane.showInputDialog("Che parola cerchi ?");  
              // Controlla se l'utente ha premuto "Cancel" o ha inserito una stringa vuota
              if (inputWord == null || inputWord.trim().isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Nessuna parola  inserita.");            
              } else {
            	  ShowTweetByKeywordCommand command= new ShowTweetByKeywordCommand(rec,inputWord);
                  invoker.placeCommand(command, 3);
              }
        	 
          }
      });
  }
  
private void actionToButtonLogin()
{
	  logoutButton.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  dispose();
	          // Azione quando si clicca sul bottone di logout
	         HomeScreenGUI h= new HomeScreenGUI();
	         h.launchFrame();
	      }
	  });
}
  
}



    
