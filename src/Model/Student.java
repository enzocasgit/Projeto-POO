package Model;

public class Student extends User {
    public String idNumber;
    public String organization;
    public String degree;
    
    public Student(String fullname, String email, String password)
    {
        super(fullname, email, password);
    }
}
