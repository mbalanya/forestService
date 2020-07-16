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
    public void Sitings_instantiatesWithAnimalsId_int() {
        Sightings testSightings = new Sightings("Nairobi", 1, "George");
        assertEquals(1, testSightings.getAnimalsId());
    }

    @Test
    public void equals_returnsTrueIfLocationAnimalsIdAndRangerNameAreSame_true() {
        Sightings testSightings = new Sightings("Nairobi", 1, "George");
        Sightings anotherSightings = new Sightings("Nairobi", 1, "George");
        assertTrue(testSightings.equals(anotherSightings));
    }

    @Test
    public void save_returnsTrueIfAretheSame() {
        Sightings testSightings = new Sightings("Nairobi", 1, "George");
        testSightings.save();
        assertTrue(Sightings.all().get(0).equals(testSightings));
    }

    @Test
    public void save_assignsIdToSightings() {
        Sightings testSightings = new Sightings("Nairobi", 1, "George");
        testSightings.save();
        Sightings savedSightings = Sightings.all().get(0);
        assertEquals(savedSightings.getId(), testSightings.getId());
    }

    @Test
    public void all_returnsAllInstancesOfSightings_true() {
        Sightings firstSightings = new Sightings("Nairobi", 1, "George");
        firstSightings.save();
        Sightings secondSightings = new Sightings("Moringa", 1, "Omwami");
        secondSightings.save();
        assertEquals(true, Sightings.all().get(0).equals(firstSightings));
        assertEquals(true, Sightings.all().get(1).equals(secondSightings));
    }

    @Test
    public void find_returnsSightingsWithSameId_secondSightings() {
        Sightings firstSightings = new Sightings("Nairobi", 1, "George");
        firstSightings.save();
        Sightings secondSightings = new Sightings("Moringa", 3, "Omwami");
        secondSightings.save();
        assertEquals(Sightings.find(secondSightings.getId()), secondSightings);
    }

}