import org.sql2o.*;

import java.sql.Timestamp;
import java.util.List;

public class Sightings {
    private String location;
    private String rangerName;
    private int animalsId;
    private int id;
    private String healthy;
    private String ill;
    private String okay;
    private Timestamp sightingsTime;

    public static final String HEALTHY = "healthy";
    public static final String ILL = "ill";
    public static final String OKAY = "okay";

    public Sightings(String location, int animalsId, String rangerName) {
        this.location = location;
        this.rangerName = rangerName;
        this.animalsId = animalsId;
        this.healthy = HEALTHY;
        this.ill = ILL;
        this.okay = OKAY;
    }

    public String getLocation() { return location; }

    public String getRangerName() { return rangerName; }

    public int getAnimalsId() { return animalsId; }

    public int getId() { return id; }

    public String getHealthy() { return healthy; }

    public String getIll() { return ill; }

    public String getOkay() { return okay; }

    public Timestamp getSightingsTime() { return sightingsTime; }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (location, animalsId, rangerName, sightingsTime) VALUES (:location, :animalsId, :rangerName, now())";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("location", this.location)
                    .addParameter("animalsId", this.animalsId)
                    .addParameter("rangerName", this.rangerName)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static Sightings find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where id=:id";
            Sightings sightings = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sightings.class);
            return sightings;
        }
    }

    public static List<Sightings> all() {
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sightings.class);
        }
    }

    @Override
    public boolean equals(Object otherSightings){
        if (!(otherSightings instanceof Sightings)) {
            return false;
        } else {
            Sightings newSightings = (Sightings) otherSightings;
            return this.getLocation().equals(newSightings.getLocation()) &&
                    this.getAnimalsId() == newSightings.getAnimalsId() &&
                    this.getRangerName().equals(newSightings.getRangerName());
        }
    }

}
