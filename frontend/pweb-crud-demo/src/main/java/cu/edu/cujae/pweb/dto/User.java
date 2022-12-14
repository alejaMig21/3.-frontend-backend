package cu.edu.cujae.pweb.dto;

public class User {

    private int idUser;
    private String name;
    private String password;
    
    public User() {
		super();
	}

	public User(int idUser, String name, String password) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.password = password;
	}

	public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
} 