package classified;

import enums.SlaveHealth;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnslavedWorker {
    static long counter = 0;
    private long id;
    private String name;
    private String originCountry;
    private int age;
    private String captureDate;
    private SlaveHealth slaveHealth;
    private Factory assignedTo;

    public EnslavedWorker(String name, String originCountry, int age, int captureDate, SlaveHealth slaveHealth, Factory assignedTo) {
        counter++;
        id = counter;
        this.name = name;
        this.originCountry = originCountry;
        this.age = age;
        this.captureDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.slaveHealth = slaveHealth;
        this.assignedTo = assignedTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(String captureDate) {
        this.captureDate = captureDate;
    }

    public SlaveHealth getSlaveHealth() {
        return slaveHealth;
    }

    public void setSlaveHealth(SlaveHealth slaveHealth) {
        this.slaveHealth = slaveHealth;
    }

    public Factory getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Factory assignedTo) {
        this.assignedTo = assignedTo;
    }
}
