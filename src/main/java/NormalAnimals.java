import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

public class NormalAnimals extends Animals {

    public static final String DATABASETYPE = "normal";

    public NormalAnimals(String name) {
        this.name = name;
        this.healthy = HEALTHY;
        this.ill = ILL;
        this.okay = OKAY;
        this.newborn = NEWBORN;
        this.young = YOUNG;
        this.adult = ADULT;
        type = DATABASETYPE;

    }

    public String getHealthy() { return healthy; }

    public String getIll() { return ill; }

    public String getOkay() { return okay; }

    public String getNewborn() { return newborn; }

    public String getYoung() { return young; }

    public String getAdult() { return adult; }

    public static List<NormalAnimals> all() {
        String sql = "SELECT * FROM animals WHERE type='normal';";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(NormalAnimals.class);
        }
    }

    public static NormalAnimals find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id;";
            NormalAnimals animals = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(NormalAnimals.class);
            return animals;
        }
    }

    public List<Object> getSightings() {
        List<Object> allSightings = new ArrayList<Object>();

        try(Connection con = DB.sql2o.open()) {
            String sqlNormal= "SELECT * FROM animals where id=:id AND type='normal';";
            List<NormalAnimals> normalAnimals = con.createQuery(sqlNormal)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(NormalAnimals.class);
            allSightings.addAll(normalAnimals);
        }
        return allSightings;
    }
}
