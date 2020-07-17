import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimals extends Animals {

    public EndangeredAnimals(String name) {
        this.name = name;
        this.healthy = HEALTHY;
        this.ill = ILL;
        this.okay = OKAY;
    }

    public String getHealthy() { return healthy; }

    public String getIll() { return ill; }

    public String getOkay() { return okay; }

    public static List<EndangeredAnimals> all() {
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(EndangeredAnimals.class);
        }
    }

    public static EndangeredAnimals find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            EndangeredAnimals animals = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EndangeredAnimals.class);
            return animals;
        }
    }
}
