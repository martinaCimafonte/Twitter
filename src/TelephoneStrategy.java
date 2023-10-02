import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
/**
 * Implementa l'interfaccia IStrategy e definisce la strategia da eseguire
 *  qualora l'utente decidesse di inviare il messaggio tramite sms
 * @author Martina Cimafonte
 *
 */
public class TelephoneStrategy extends JFrame implements IStrategy {

	
	private static final long serialVersionUID = 1L;

	public TelephoneStrategy() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Marti\\OneDrive\\Desktop\\Twitter\\Image\\phoneIcon.png"));
		setTitle(" Posta un tweet tramite SMS !");	
		setSize(400, 200);
	    setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}

	@Override
	public void execute() {		
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(172, 225, 175)); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{31, 147, 71, 95, 0};
		gbl_contentPane.rowHeights = new int[]{20, 19, 0, 58, 23, 0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel labelTelephone = new JLabel("Da :");
		labelTelephone.setFont(new Font("Century Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_labelTelephone = new GridBagConstraints();
		gbc_labelTelephone.anchor = GridBagConstraints.NORTH;
		gbc_labelTelephone.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelTelephone.insets = new Insets(0, 0, 5, 5);
		gbc_labelTelephone.gridx = 0;
		gbc_labelTelephone.gridy = 0;
		contentPane.add( labelTelephone, gbc_labelTelephone);
		
		JTextField telephoneField = new JTextField();			
		telephoneField.setColumns(10);
		GridBagConstraints gbc_telephoneField = new GridBagConstraints();
		gbc_telephoneField.anchor = GridBagConstraints.SOUTHWEST;
		gbc_telephoneField.insets = new Insets(0, 0, 6, 6);
		gbc_telephoneField.gridx = 1;
		gbc_telephoneField.gridy = 0;
		contentPane.add(telephoneField, gbc_telephoneField);	
		
		JLabel hashtagLabel= new JLabel("# :");
		hashtagLabel.setFont(new Font("Century Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_hashtagLabel = new GridBagConstraints();
		gbc_hashtagLabel.anchor = GridBagConstraints.SOUTH;
		gbc_hashtagLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_hashtagLabel.insets = new Insets(0, 0, 6, 6);
		gbc_hashtagLabel.gridx = 0;
		gbc_hashtagLabel.gridy = 1;
		contentPane.add(hashtagLabel,gbc_hashtagLabel);
		
		JTextField hashtagField = new JTextField();	
		hashtagField.setColumns(10);
		GridBagConstraints gbc_hashtagField = new GridBagConstraints();
		gbc_hashtagField.anchor = GridBagConstraints.NORTHWEST;
		gbc_hashtagField.insets = new Insets(0, 0, 5, 5);
		gbc_hashtagField.gridx = 1;
		gbc_hashtagField.gridy = 1;
		contentPane.add(hashtagField, gbc_hashtagField);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 2;
		contentPane.add(separator, gbc_separator);
		
		JTextArea tweetArea = new JTextArea();
		tweetArea.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		JScrollPane scrollPane = new JScrollPane(tweetArea);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		tweetArea.addFocusListener(new FocusAdapter() {
  			@Override 
  			public void focusGained(FocusEvent e) {tweetArea.setText(""); } }); 
	
		tweetArea.setLineWrap(true); // Abilita il wrap automatico delle righe
        tweetArea.setWrapStyleWord(true); // Wrap solo quando necessario per intere parole
		GridBagConstraints gbc_tweetArea = new GridBagConstraints();
		gbc_tweetArea.fill = GridBagConstraints.BOTH;
		gbc_tweetArea.insets = new Insets(0, 0, 5, 5);
		gbc_tweetArea.gridwidth = 2;
		gbc_tweetArea.gridx = 0;
		gbc_tweetArea.gridy = 3;
		contentPane.add(scrollPane,gbc_tweetArea);
		
		JButton button = new JButton("ACCEDI AL SITO");
		button.setBackground(new Color(255, 255, 255));
		button.setFont(new Font("Century Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_button= new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.WEST;
		gbc_button.gridheight = 2;
		gbc_button.gridx = 3;
		gbc_button.gridy = 3;
		button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	dispose();
	               new WebSiteStrategy().execute();
	            }
	        });
		contentPane.add(button, gbc_button);
		
		JButton sendButton = new JButton("INVIA");
		sendButton.setBackground(new Color(255, 255, 255));
		sendButton.setFont(new Font("Century Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_sendButton = new GridBagConstraints();
		gbc_sendButton.anchor = GridBagConstraints.NORTH;
		gbc_sendButton.insets = new Insets(0, 0, 0, 5);
		gbc_sendButton.gridx = 1;
		gbc_sendButton.gridy = 4;
		sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //azioni da svolgere all'invio del messaggio
            	 if(tweetArea.getText().length()>0 && telephoneField.getText().length()>0)
            	 { boolean check=false;
				 
            	 	//controlla che il numero è associato ad un utente twitter
            			for (User user: Twitter.getInstance().getUserFileManager().getListUsers())
    					{
    				        	 if (telephoneField.getText().equals(user.getTel())) 
    				        	 {
    				        	   check=true; 
    				        	   Tweet msg= new Tweet(tweetArea.getText());
    				        	   if(hashtagField.getText().length()>0)
    								   msg.setHashtag(hashtagField.getText());
    				               try {
    				            	   user.write_post(msg);
    				            	   JOptionPane.showMessageDialog(null, "tweet pubblicato ! ");
    				            	   }
    				               catch (MessageTooLongException ex) {
    								JOptionPane.showMessageDialog(TelephoneStrategy.this, "Si è verificata un'eccezione !\n " + ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
    														    
    								}	           
    				    
    				        	 }	           	   
    				     }
            			
            			if(!check)
            			{
            				 JOptionPane.showMessageDialog(TelephoneStrategy.this," Il numero "+ telephoneField.getText()+" non è associato a nessun account Twitter "
    								 + "\n Si prega di riprovare.", "Errore", JOptionPane.ERROR_MESSAGE);
            			}
            	 }
            	 else
            	 {
            		 JOptionPane.showMessageDialog(TelephoneStrategy.this,"Impossibile postare il tuo tweet! "
							 + "\n Riempi tutti i campi richiesti.", "Errore", JOptionPane.ERROR_MESSAGE);
            	 }
				                    	
				} 						
			        
        });
		contentPane.add(sendButton, gbc_sendButton);

	}

}

