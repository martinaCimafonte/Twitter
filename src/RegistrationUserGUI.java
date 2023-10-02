import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistrationUserGUI {
    private  boolean registration;
	public RegistrationUserGUI() {
		registration = false;
		JFrame frame = new JFrame("Registrati a Twitter !");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Marti\\OneDrive\\Desktop\\Twitter\\Image\\twitter_icon.png"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10)); // 8 righe, 2 colonne
        panel.setBackground(new Color(14, 153, 226));
        panel.setForeground(Color.white);
        
        JLabel nameLabel = new JLabel("Nome:");
        nameLabel.setForeground(Color.white);
        nameLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
        JTextField nameField = new JTextField(20);
        
        JLabel surnameLabel = new JLabel("Cognome:");
        surnameLabel.setForeground(Color.white);
		surnameLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
        JTextField surnameField = new JTextField(20);
        
        JLabel birthDateLabel = new JLabel("Data di Nascita:");
        birthDateLabel.setForeground(Color.white);
	    birthDateLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
        JTextField birthDateField = new JTextField(20);  
        birthDateField.addFocusListener(new FocusAdapter() {
  			@Override 
  			public void focusGained(FocusEvent e) {birthDateField.setText(""); } });             
        
        JLabel phoneLabel = new JLabel("Telefono:");
        phoneLabel.setForeground(Color.white);
        phoneLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
        JTextField phoneField = new JTextField(20);
        
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.white);
        emailLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
        JTextField emailField = new JTextField(20);
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.white);
        JTextField usernameField = new JTextField(20);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.white);
        passwordLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
        JPasswordField passwordField = new JPasswordField(20);

        JButton registerButton = new JButton("Iscriviti");
        registerButton.setFont(new Font("Century Gothic", Font.BOLD, 12));
        registerButton.setBackground(Color.white);
       
        registerButton.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                // gestisci la registrazione dell'utente con i dati inseriti nei campi
                String name = nameField.getText();
                String surname = surnameField.getText();
                String birthDate = birthDateField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // controlliamo che username sia diverso da altri 
                boolean check =true;
                  for( User user: Twitter.getInstance().getUserFileManager().getListUsers())
                  {   if(username.equals(user.getUsername()))
                  	{ check=false;
                	  JOptionPane.showMessageDialog(frame, "Esiste già un account con username : "+username, "Errore", JOptionPane.ERROR_MESSAGE);
                  	  
                  	}
                 
                  }               
                  
               if(check)
               {        // verifica che i campi siano compilati 	  
            	   if ( nameField.getText().length()>0 && usernameField.getText().length()>0
            			   && surnameField.getText().length()>0 && birthDateField.getText().length()>0
            			   && phoneField.getText().length()>0 && emailField.getText().length()>0
            			   && passwordField.getPassword().length>0 )
            	   {  registration=true; }
            	   
            	   else
            	   {  
            		   JOptionPane.showMessageDialog(frame, " Non hai riempito tutti i campi !", "Errore", JOptionPane.ERROR_MESSAGE);
            	   }
            	   
            	   
            	   if(registration)
                   {   // azioni di registrazione necessarie
                	   User newUser= new User(Twitter.getInstance().getMediator(),name,surname,birthDate,phone,email,username,password);
                       // aggiorna la lista e il file che tengono  traccia degli utenti twitter
                	   Twitter.getInstance().getUserFileManager().updateFileUsers(newUser);
                	   // Esempio di messaggio di conferma
                       JOptionPane.showMessageDialog(frame, "Registrazione completata!");
                       frame.dispose();
                       new ContextStrategyGUI();
                   }           
              }                  
          }               
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(surnameLabel);
        panel.add(surnameField);
        panel.add(birthDateLabel);
        panel.add(birthDateField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Spazio vuoto
        panel.add(registerButton);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centra la finestra
        frame.setVisible(true);
	}

	
}

