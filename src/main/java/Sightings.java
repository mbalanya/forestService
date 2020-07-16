public class Sightings {
    private String location;
    private String rangerName;
    private int animalsId;

    public Sightings(String location, int animalsId, String rangerName) {
        this.location = location;
        this.rangerName = rangerName;
    }

    public String getLocation() { return location; }

    public String getRangerName() { return rangerName; }

    public int getAnimalsId() { return animalsId; }
}
