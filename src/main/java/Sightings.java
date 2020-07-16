public class Sightings {
    private String location;
    private String rangerName;
    private int animalsId;

    public Sightings(String location, int animalsId, String rangerName) {
        this.location = location;
        this.rangerName = rangerName;
        this.animalsId = animalsId;
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

    public String getLocation() { return location; }

    public String getRangerName() { return rangerName; }

    public int getAnimalsId() { return animalsId; }
}
