import org.sql2o.*;

import java.util.List;

public class Sightings {
    private String location;
    private String rangerName;
    private int animalsId;
    private int id;

    public Sightings(String location, int animalsId, String rangerName) {
        this.location = location;
        this.rangerName = rangerName;
        this.animalsId = animalsId;
    }

    public String getLocation() { return location; }

    public String getRangerName() { return rangerName; }

    public int getAnimalsId() { return animalsId; }

    public int getId() { return id; }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (location, animalsId, rangerName) VALUES (:location, :animalsId, :rangerName)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("location", this.location)
                    .addParameter("animalsId", this.animalsId)
                    .addParameter("rangerName", this.rangerName)
                    .executeUpdate()
                    .getKey();
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
