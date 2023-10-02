
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Interfaccia grafica per l'accesso in modalità amministratore
 * @author Martina Cimafonte
 *
 */
public class AdminLoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
 
	 
	 public AdminLoginGUI() {
		
		 initializeComponents();	
		}
	 
	 private void initializeComponents() {
		 setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Marti\\OneDrive\\Desktop\\Twitter\\Image\\twitter_icon.png"));
	     usernameField = new JTextField(10);
	     passwordField = new JPasswordField(15);
	     loginButton = new JButton("Accedi"); 
	     //  verificare le credenziali e gestire l'accesso
	     addActionToButton();
	 
	    }
	 
	 
	 
	 public void launchFrame() {
		 
		    getContentPane().setBackground(new Color(14,153,226)); 
		    setLayout(new GridLayout(3,2));  //3 righe e 2 colonne
		        
		     //aggiungi etichette 
		     addLabel();
		       
		     //decora e aggiungi pulsante di login
			loginButton.setBackground(Color.WHITE);
			loginButton.setFont(new Font("Century Gothic", Font.BOLD,12));
			add(loginButton);
		
		    pack();
		    setLocationRelativeTo(null);
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setVisible(true);
		    }
	 
	  private void addLabel()
	   {
	     JLabel usernameLabel=new JLabel("Username:");
	     usernameLabel.setForeground(Color.white);
		 usernameLabel.setFont(new Font("Century Gothic", Font.BOLD,12));
		 add(usernameLabel);
	   	 add(usernameField);
		     
		 JLabel passwordLabel=new JLabel("Password:");
		 passwordLabel.setForeground(Color.white);
		 passwordLabel.setFont(new Font("Century Gothic", Font.BOLD,12));
		 add(passwordLabel);
		 add(passwordField);
		 add(new JLabel(""));
	   }
	    
    /** implementa l'azione al bottone di login.
     * Esamina la lista degli amministratori per verificare che le credenziali inserite
     * siano corrette. Se l'autenticazione va a buon fine viene mostrata la HomePage dell'admin, altrimenti
     * viene visualizzata una finestra con  messaggio di errore.
     * 
     */
	private void addActionToButton() {
		
			    loginButton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {	
		            	String username = usernameField.getText();
		                char[] password = passwordField.getPassword();
		                List<Admin> admin_list=new AdminFileManager().getAdminsList();
	                   boolean check=false;                            
		            
	                 for (Admin admin: admin_list)
	                 {
	                	 if (username.equals(admin.getUsername()) && Arrays.equals(password, admin.getPassword().toCharArray())) 
	 	                    check=true; 
	                 }
	                 
	                 if (check) 
	                 { 	 dispose();
	                	 SwingUtilities.invokeLater(new Runnable() {
	                         public void run() { new HomePageAdminGUI(username);}
	                     });
	                 }
			          else {
			        	  JOptionPane.showMessageDialog(AdminLoginGUI.this, " Accesso negato!\n Si prega di riprovare", "Errore", JOptionPane.ERROR_MESSAGE);
	 	                   
	 	                }
		               
		        }});
		  
	} }
	
	
