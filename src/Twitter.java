/**
 *  gestisce  l'accesso di login generale del servizio microblogging.
 * E' implementata con il pattern singleton. In questo modo  Twitter è una singola 
 *  istanza disponibile per tutti i client.
 *
 */
public class Twitter  { 
	
	private Mediator mediator;
	private  UserFileManager userFileManager; 
	private static final Twitter twitter_instance = new Twitter();
	
	private Twitter() 
	{ 
	}
	
	public void setInfo(Mediator m, UserFileManager manager)
	{
		mediator=m;
		userFileManager=manager;
	}
	
  /**
   * fornisce il punto globale di accesso a Twitter.
   * @return twitter_instance, unica istanza della classe Twitter
   */
	
   public static Twitter getInstance()
   { 
	   return twitter_instance;
   }
  
  
   public void load_users() throws MessageTooLongException
   {   
	
		User u1= new User(mediator,"Mauro", "Lucci"," 03/12/2000", "3663456065", "muccimauro@gmail.com", "mauro", "azzurri26");
        User u2= new User(mediator,"Elisabetta","Inno", "31/08/1999", "3661626645", "inno_elisa1@live.it", "Elisa99", "saintBarth");
		User u3= new User(mediator,"Marcella", "Manfredi", "24/03/1994", "3337989067", "manfredi_m@live.it", "blacksoul_94", "michaelJackson94");
		User u4= new User(mediator,"Lorenzo", "De Taola", "05/06/1971", "3271653911", "lorenzo_dt@live.it", "lory_dt", "summerParadise71");
		u1.follow_user(u4);
		u1.follow_user(u2);
		u2.follow_user(u1);
		u4.follow_user(u1);
		u4.follow_user(u2);
		u3.follow_user(u1);
		userFileManager.updateFileUsers(u1);
		userFileManager.updateFileUsers(u2);
		userFileManager.updateFileUsers(u3);
		userFileManager.updateFileUsers(u4);
		Tweet msg= new Tweet(" Anche quest'estate è terminata... Si ritorna a lavoro!");
		msg.setHashtag("summer23");
        u1.write_post(msg);
        Tweet msg1= new Tweet("aspettando le vacanze di natale...");
        msg1.setHashtag("christmasMood");
        u2.write_post(msg1);
        Tweet msg3= new Tweet("Non c'è cosa più bella di lavorare da casa quando piove");
        msg3.setHashtag("HomeSweetHome");
        u1.write_post(msg3);  
        Tweet msg4= new Tweet("Dopo un mese di vacanze.. si ritorna a casa !");
        msg4.setHashtag("summer23");
        u4.write_post(msg4);
		 
   }
   
   /**
    *   permette di avviare l'interfaccia grafica dell'applicazione
    */  
   public void accessPoint()
   {
	   HomeScreenGUI h= new HomeScreenGUI();
	   h.launchFrame();
   }
   
   public UserFileManager getUserFileManager()
   {
	   return userFileManager;
   }
   
   public Mediator getMediator()
   {
	   return mediator;
   }
	
}
   
