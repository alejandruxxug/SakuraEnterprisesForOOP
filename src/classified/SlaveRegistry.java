package classified;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SlaveRegistry {
    private String lastAccessed;
    private String CypherLevel;
    private ArrayList<EnslavedWorker>  enslavedWorkers = new ArrayList<>();

    public SlaveRegistry(String cypherLevel, String lastAccessed) {
        CypherLevel = cypherLevel;
        this.lastAccessed = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(String lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public String getCypherLevel() {
        return CypherLevel;
    }

    public void setCypherLevel(String cypherLevel) {
        CypherLevel = cypherLevel;
    }

    public ArrayList<EnslavedWorker> getEnslavedWorkers() {
        return enslavedWorkers;
    }

    public void setEnslavedWorkers(ArrayList<EnslavedWorker> enslavedWorkers) {
        this.enslavedWorkers = enslavedWorkers;
    }
}
