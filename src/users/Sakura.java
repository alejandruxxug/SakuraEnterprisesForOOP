package users;

import enums.AccessLevel;
import java.time.LocalDate;

public class Sakura extends User{
    //The world IS MINE!!!
    static long masterKey;
    static String crowningDate;
    static AccessLevel accessLevel = AccessLevel.ADMIN;
    private static Sakura instance;

    private Sakura() { //Secret private constructor hehe i want for sakura class to be unique only have 1 instance
        super("Sakura-san", "sakurapetals", "sakura@business.com");
        masterKey = 123345;
        crowningDate = LocalDate.now().toString();
    }

    public static Sakura getInstance() {
        if (instance == null) {
            instance = new Sakura();
        }
        return instance;
    }

    public static long getMasterKey() {
        return masterKey;
    }

    public static void setMasterKey(long masterKey) {
        Sakura.masterKey = masterKey;
    }

    public static String getCrowningDate() {
        return crowningDate;
    }

    public static void setCrowningDate(String crowningDate) {
        Sakura.crowningDate = crowningDate;
    }

    public static AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public static void setAccessLevel(AccessLevel accessLevel) {
        Sakura.accessLevel = accessLevel;
    }
}
