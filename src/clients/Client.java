package clients;

import users.User;
import java.util.ArrayList;

public class Client extends User {
    private String deliveryAddress;
    private long telephoneNumber;
    private ArrayList<PaymentMethod> paymentMethods;

    public Client(String name, String password, String email, String deliveryAddress, long telephoneNumber) {
        super(name, password, email);
        this.deliveryAddress = deliveryAddress;
        this.telephoneNumber = telephoneNumber;
    }
}
