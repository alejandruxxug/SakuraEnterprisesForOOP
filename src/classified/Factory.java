package classified;

import enums.AutomationLevel;

public class Factory {
    static long counter = 0;
    private long id;
    private String name;
    private String city;
    private long capacity;
    private AutomationLevel automationLevel;

    public Factory(String name, String city, long capacity, AutomationLevel automationLevel) {
        counter++;
        id = counter;
        this.name = name;
        this.city = city;
        this.capacity = capacity;
        this.automationLevel = automationLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public AutomationLevel getAutomationLevel() {
        return automationLevel;
    }

    public void setAutomationLevel(AutomationLevel automationLevel) {
        this.automationLevel = automationLevel;
    }
}
