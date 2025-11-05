package users;

public class ProductDeveloper extends User{
    private String specialty;

    public ProductDeveloper(String name, String password, String email,String specialty) {
        super(name, password, email);
        this.specialty = specialty;

    }
}
