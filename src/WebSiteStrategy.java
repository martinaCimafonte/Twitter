import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
/**
 * Implementa l'interfaccia IStrategy e definisce la strategia da eseguire
 *  qualora l'utente decidesse di inviare il messaggio tramite sito web.
 * @author Martina Cimafonte
 *
 */
public class WebSiteStrategy extends JFrame implements IStrategy {
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton signUpButton;
	private JButton loginButton;
 	User userAccount;

	public WebSiteStrategy() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Marti\\OneDrive\\Desktop\\Twitter\\Image\\twitter_icon.png"));
		setTitle("Accedi a Twitter!");	
		setBounds(100,100,300,150);
	    setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void execute() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(14, 153, 226));
		contentPane.setForeground(new Color(14, 153, 226));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setForeground(new Color(255, 255, 255));
		usernameLabel.setFont(new Font("Century Gothic", Font.BOLD, 13));
		contentPane.add(usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		contentPane.add(usernameField);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(new Color(255, 255, 255));
		passwordLabel.setFont(new Font("Century Gothic", Font.BOLD, 13));
		contentPane.add(passwordLabel);
		
		passwordField = new JPasswordField ();
		passwordField.setColumns(8);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("Non hai un account?");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Century Gothic", Font.BOLD, 12));
		contentPane.add(label);
		
		JSeparator separator = new JSeparator();
		contentPane.add(separator);
		
		signUpButton = new JButton("Iscriviti");	 
		signUpButton.setFont(new Font("Century Gothic", Font.BOLD, 12));
		addActionToSignUpButton();
		contentPane.add(signUpButton); 
		
		loginButton = new JButton("Accedi");
		loginButton.setFont(new Font("Century Gothic", Font.BOLD, 12));
		addActionToLoginButton();
		contentPane.add(loginButton);
		
	}
	
	private void addActionToSignUpButton()
	{
		signUpButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new RegistrationUserGUI();
		}});		
	}	
	
	private void addActionToLoginButton()
	{
		loginButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String username = usernameField.getText();
            char[] password = passwordField.getPassword();
            List<User>users_list= new ArrayList<>();
          
           boolean check=false;
           
           users_list = Twitter.getInstance().getUserFileManager().getListUsers();
        
         for (User user: users_list)
         {
        	 if (username.equals(user.getUsername()) && Arrays.equals(password, user.getPassword().toCharArray())) 
        	 { check=true; 
           	  userAccount=user;
        	 }
        	      	   
         }
         
         if (check) 
         {
          dispose();
          new HomePageUserGUI(userAccount);       
         }
          else {
        	  JOptionPane.showMessageDialog(WebSiteStrategy.this, " Accesso negato!\n Si prega di riprovare", "Errore", JOptionPane.ERROR_MESSAGE);              
              }
			
		}});		
	}

}




