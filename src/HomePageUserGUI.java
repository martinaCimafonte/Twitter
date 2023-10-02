import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;
import java.util.Map;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
/**
 * fornisce all'utente l'interfaccia grafica per visualizzare la home page di Twitter
 * e svolgere le varie operazioni possibili.
 * @author Martina Cimafonte
 *
 */
public class HomePageUserGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField hashtagField, textField;
	private JLabel userLabel, followerLabel,followingLabel, hashtagLabel,imageLabel;
	private JButton logoutButton,postButton,addUserButton,viewMessageButton;
	private JTextArea writeArea;
    private JComboBox<String> comboBoxFollowers;
    private JComboBox<String> comboBoxFollowing;
    private User userAccount; 
    private JScrollPane scrollPane;
	
   	public HomePageUserGUI(User userAccount) 
	{   this.userAccount=userAccount;
		UIManager.put("ComboBox.selectionBackground", Color.white);
		
		customizeComboBoxFollowers();
		customizeComboBoxFollowing();		
		setTitle("Home Page");		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Marti\\OneDrive\\Desktop\\Twitter\\Image\\twitter_icon.png"));
		setBounds(100, 100, 670, 430);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(14, 153, 226));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		customizeLabel();
		userLabel = new JLabel("Ciao "+userAccount.getUsername()+"!");  // eventualmente metti anche queste in customizeLabel();
		userLabel.setForeground(new Color(255, 255, 255));
		userLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));	
		
		customizeTextField();		
		writeArea = new JTextArea(10,30);
		writeArea.setLineWrap(true); // Abilita il wrap automatico delle righe
        writeArea.setWrapStyleWord(true); // Wrap solo quando necessario per intere parole
		writeArea.setFont(new Font("Century Gothic", Font.PLAIN, 11));	
	  
	     scrollPane = new JScrollPane(writeArea);
	     scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        
		
		writeArea.addFocusListener(new FocusAdapter() {
			@Override 
			public void focusGained(FocusEvent e) {
				writeArea.setText(""); } });
			
	    imageLabel = new JLabel("");
		imageLabel.setIcon(new ImageIcon("C:\\Users\\Marti\\OneDrive\\Desktop\\Twitter\\Image\\iconTwitter.png"));
	
		
		customizeLogoutButton();
		customizePostButton();
		customizeViewMessageButton();
		customizeAddUserButton();
		setGroupLayout();
		
	}
	
	private void customizeComboBoxFollowers()
	{
		comboBoxFollowers=new JComboBox<String>();
		for(User usr: userAccount.getFollowers())
		{
			comboBoxFollowers.addItem(usr.getUsername());
		}
	
		
		comboBoxFollowers.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		comboBoxFollowers.setBackground(new Color(14, 153, 226));
		comboBoxFollowers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedUser = (String) comboBoxFollowers.getSelectedItem();
                JOptionPane.showMessageDialog(null, "Selected User: " + selectedUser);
            }
        });
		
	}
	

	private void customizeComboBoxFollowing()
	{
		comboBoxFollowing=new JComboBox<String>();
		for(User usr: userAccount.getFollowing())
		{	   
			comboBoxFollowing.addItem(usr.getUsername());
		}
	
		
		comboBoxFollowing.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		comboBoxFollowing.setBackground(new Color(14, 153, 226));
		comboBoxFollowing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedUser = (String) comboBoxFollowing.getSelectedItem();
                JOptionPane.showMessageDialog(null, "Selected User: " + selectedUser);
            }
        });
		
	}
	
	private void customizeTextField()
	{
		hashtagField = new JTextField();
		hashtagField.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		hashtagField.setColumns(10);
		hashtagField.addFocusListener(new FocusAdapter() {
			@Override 
			public void focusGained(FocusEvent e) {
				hashtagField.setText(""); } });
			
		textField = new JTextField("Aggiungi user...");
		textField.setColumns(10);
		textField.addFocusListener(new FocusAdapter() {
			@Override 
			public void focusGained(FocusEvent e) {
				textField.setText(""); } });	
	}
	
	private void customizeLabel()
	{
	    followerLabel = new JLabel("Follower");
		followerLabel.setForeground(new Color(255, 255, 255));
		followerLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		
		followingLabel = new JLabel(" Seguiti");
		followingLabel.setForeground(Color.WHITE);
		followingLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		
	    hashtagLabel = new JLabel("#");
		hashtagLabel.setFont(new Font("Century Gothic", Font.BOLD, 13));
		
	
	}
	private void customizeViewMessageButton()
	{   
		viewMessageButton= new JButton("TWEET POSTATI DAI TUOI AMICI");
		viewMessageButton.setFont(new Font("Century Gothic", Font.BOLD, 11));
			
		viewMessageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 //Interfaccia grafica
				 JConsole console = new JConsole();
				 console.setEditable(false);
				 //Collegamento del System.out alla JConsole
				 System.setOut(console.getPrintStream());  //metodi che  ci permettono di dirottare il System.out sull'output implementato 
				 System.setErr(console.getPrintStream());
				 
			   JFrame frame = new JFrame("Twitter Console ");
			   TitledBorder t= new TitledBorder("ELENCO TWEETS POSTATI DAI TUOI AMICI :");
			   t.setTitleColor(Color.white);
			   console.setBorder(t);
			   frame.getContentPane().add(new JScrollPane(console));
			   frame.setSize(530,300);
			   frame.setVisible(true);
			   frame.setLocationRelativeTo(null);
			   console.setBackground(new Color(14,153,226)); 
			   console.setFont(new Font("Century Gothic", Font.BOLD,12));
			   console.setForeground(Color.white); 
			   

				 System.out.println();
				for (Map.Entry<User, List<Tweet>> entry :userAccount.getTweetsReceivedMap().entrySet()) {
		            User senderUser = entry.getKey();
		            List<Tweet> msg = entry.getValue();
		            
		            System.out.println("Tweet pubblicati da " + senderUser + " : ");

		            for (Tweet tweet : msg) {
		            	System.out.println();
		                System.out.println("- " + tweet);
		            }
		            System.out.println(); // Riga vuota tra le chiavi
		            System.out.println();
		        }
				
			   
			}});
		
			
	}
	
	private void customizeLogoutButton()
	{
		logoutButton = new JButton("LOGOUT");
		logoutButton.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new HomeScreenGUI().launchFrame();
			}});
			
	}
	
	private void customizePostButton()
	{	
		postButton = new JButton("POSTA TWEET");
		postButton.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		postButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newMessage = writeArea.getText();
				//String newHashtag= hashtagField.getText();
				
				if ( newMessage.length()>0)
				{  Tweet newTweet=new Tweet(newMessage);
				 if(hashtagField.getText().length()>0)
				   newTweet.setHashtag(hashtagField.getText());
					try {
						userAccount.write_post(newTweet);	
						JOptionPane.showMessageDialog(null, ""+" tweet pubblicato !  ");
					}
					catch (MessageTooLongException ex) {
		                // Mostriamo una finestra di dialogo con il messaggio di errore
		             JOptionPane.showMessageDialog(HomePageUserGUI.this, "Si è verificata un'eccezione !\n " + 
		                ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
		            }
					
				}
				
				else
				{
					 JOptionPane.showMessageDialog(HomePageUserGUI.this, " Non è stato possibile pubblicare il tuo tweet."
							 +" \n Assicurati di aver inserito il messaggio", "Errore", JOptionPane.ERROR_MESSAGE);
				}
									
			}});
		
					
	}
	
	private void customizeAddUserButton()
	{
		addUserButton = new JButton("AGGIUNGI");
			addUserButton.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
		addUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newFollowing = textField.getText();
				boolean check=false;
				for (User user: Twitter.getInstance().getUserFileManager().getListUsers())
		         {   // controlla che l'utente sia registrato alla piattaforma, non presente nella lista dei seguiti e che non sia l'utente stesso a seguirsi da solo
		        	 if (newFollowing.equals(user.getUsername()) && !(userAccount.getFollowing().contains(user)) && user.getUsername()!=userAccount.getUsername()) 
		        	 {
		        	   check=true; 
		        	   JOptionPane.showMessageDialog(null, ""+newFollowing+" è stato aggiunto correttamente ");
		           	   userAccount.follow_user(user);
		           	   comboBoxFollowing.addItem(newFollowing);
		           	   textField.addFocusListener(new FocusAdapter() {
		      			@Override 
		      			public void focusGained(FocusEvent e) {textField.setText(""); } });
		        	 }	   
		        	   
		         }
				
				if(!check)
			 JOptionPane.showMessageDialog(HomePageUserGUI.this, " Attenzione !  \n Assicurati che "+ newFollowing+" sia un account esistente e non presente nella tua lista di seguiti. \n"
					 +" Si ricorda di non inserire il proprio username ", "Errore !", JOptionPane.ERROR_MESSAGE);
	        
				
			}});
	}
	/**
	 * setGroupLayout() organizza i vari componenti all'interno del contentPane
	 *  utilizzando  il layout manager GroupLayout. 
	 */
	private void setGroupLayout()
	{
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(logoutButton, GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(userLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
											.addGap(56)
											.addComponent(followerLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(comboBoxFollowers, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
											.addGap(18))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(hashtagLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(hashtagField, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
											.addGap(194)))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(postButton, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
										.addGap(184)))
								.addGroup(gl_contentPane.createSequentialGroup()
										
									.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(viewMessageButton, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
												.addGap(184)))
										.addGroup(gl_contentPane.createSequentialGroup()
												
										
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(followingLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBoxFollowing, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
									.addGap(8))
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(addUserButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap()));
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxFollowers, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(followerLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(followingLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxFollowing, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(hashtagLabel)
							.addComponent(hashtagField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(postButton))
						    
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(addUserButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
					.addComponent(viewMessageButton)
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addComponent(logoutButton)));
		contentPane.setLayout(gl_contentPane);
	}

}


