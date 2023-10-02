/**
 * classe che modella il ruolo  di un amministatore della piattaforma Twitter
 * @author Martina Cimafonte
 */
public class Admin {
	private String username, password,name, surname;
	
	public Admin(String username, String password, String name, String surname ) 
	{
		this.username=username;
		this.password=password;
		this.name=name;
		this.surname=surname;
	}
	
	public String getUsername() {return username;}
	public String getName() {return name;}
	public String getPassword() {return password;}
	public String getSurname() {return surname;}
	
	@Override
	public String toString()
	{
		return this.username+" ";
	}

}
