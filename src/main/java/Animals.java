import org.sql2o.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Animals {
    public String name;
    public int id;
    public String healthy;
    public String ill;
    public String okay;
    public String newborn;
    public String young;
    public String adult;
    public String type;

    public static final String HEALTHY = "healthy";
    public static final String ILL = "ill";
    public static final String OKAY = "okay";
    public static final String NEWBORN = "newborn";
    public static final String YOUNG = "young";
    public static final String ADULT = "adult";

    public String getName() { return name; }

    public int getId() { return id; }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, type) VALUES (:name, :type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
        }
    }

    public List<Object> getSightings() {
        List<Object> allSightings = new ArrayList<Object>();

        try(Connection con = DB.sql2o.open()) {
            String sqlEndangered = "SELECT * FROM animals where id=:id AND type='endangered';";
            List<EndangeredAnimals> endangeredAnimals = con.createQuery(sqlEndangered)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimals.class);
                    allSightings.addAll(endangeredAnimals);
        }
        return allSightings;
    }

    @Override
    public boolean equals(Object otherAnimals){
        if (!(otherAnimals instanceof Animals)) {
            return false;
        } else {
            Animals newAnimals = (Animals) otherAnimals;
            return this.getName().equals(newAnimals.getName());
        }
    }
}
