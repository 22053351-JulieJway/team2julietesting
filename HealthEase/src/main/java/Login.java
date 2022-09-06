
public class Login {
	protected String nric;
	protected String name;
	protected String password;
	public String getNric() {
		return nric;
	}
	public void setNric(String nric) {
		this.nric = nric;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Login(String nric, String name, String password) {
		super();
		this.nric = nric;
		this.name = name;
		this.password = password;
	}

}


