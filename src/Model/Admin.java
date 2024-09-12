package Model;

public class Admin extends User {
    public String siape;
    public String role;
    public String organization;
    public String degree;

    public Admin(String fullname, String email, String password)
    {
        super(fullname, email, password);
    }
}
