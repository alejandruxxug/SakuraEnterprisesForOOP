package clients;

import users.User;
import java.util.ArrayList;

public class Client extends User {
    private String deliveryAddress;
    private long telephoneNumber;
    private ArrayList<PaymentMethod> paymentMethods;
}
