package products;

import exceptions.DuplicateCategory;

public class Category {
    private long counter = 0;
    private long id;
    private String name;
    private String description;

    public Category(String name, String description) {
        counter++;
        this.id = counter;
        this.name = name.toLowerCase();
        this.description = description;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
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
}
