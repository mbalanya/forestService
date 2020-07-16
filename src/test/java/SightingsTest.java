import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class SightingsTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void Sightings_instantiatesCorrectly_true() {
        Sightings testSightings = new Sightings("Nairobi", 1, "George");
        assertEquals(true, testSightings instanceof Sightings);
    }

    @Test
    public void Sightings_instantiatesWithLocationAndRangerName_String() {
        Sightings testSightings = new Sightings("Nairobi", 1, "George");
        assertEquals("Nairobi", testSightings.getLocation());
        assertEquals("George", testSightings.getRangerName());
    }

    @Test
    public void Sitings_instantiatesWithAnimalsnId_int() {
        Sightings testSightings = new Sightings("Nairobi", 1, "George");
        assertEquals(1, testSightings.getAnimalsId());
    }

}