package products;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Product {
    private static long counter = 0;
    private long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String launchDate;

    public Product(String name, String description, double price, int stock, int launchDate) {
        counter++;
        id = counter;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.launchDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }



    public static long getCounter() {
        return counter;
    }

    public static void setCounter(long counter) {
        Product.counter = counter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }
}
