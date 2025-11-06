package shoppingsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ShoppingCart {
    static long counter = 0;
    private long id;
    private String creationDate;

    public ShoppingCart() {
        id = counter++;
        this.creationDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
