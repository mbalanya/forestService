import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

import java.util.Arrays;

public class NormalAnimalsTest {

    @Rule
    public DatabaseRule databse = new DatabaseRule();

    @Test
    public void normalAnimals_instantiatesCorrectly_true() {
        NormalAnimals testNormalAnimals = new NormalAnimals("Simba");
        assertEquals(true, testNormalAnimals instanceof NormalAnimals);
    }

    @Test
    public void getName_normalAnimalsInstantiatesWithName_Simba() {
        NormalAnimals testNormalAnimals = new NormalAnimals("Simba");
        assertEquals("Simba", testNormalAnimals.getName());
    }

    @Test
    public void equals_returnsTrueIfNameAndEmailAreSame_true() {
        NormalAnimals firstNormalAnimals = new NormalAnimals("Simba");
        NormalAnimals anotherNormalAnimals = new NormalAnimals("Simba");
        assertTrue(firstNormalAnimals.equals(anotherNormalAnimals));
    }

    @Test
    public void save_insertsObjectIntoDatabase_NormalAnimals() {
        NormalAnimals testNormalAnimals = new NormalAnimals("Simba");
        testNormalAnimals.save();
        assertTrue(NormalAnimals.all().get(0).equals(testNormalAnimals));
    }

    @Test
    public void all_returnsAllInstancesOfNormalAnimals_true() {
        NormalAnimals firstNormalAnimals = new NormalAnimals("Simba");
        firstNormalAnimals.save();
        NormalAnimals secondNormalAnimals = new NormalAnimals("Arturo");
        secondNormalAnimals.save();
        assertEquals(true, NormalAnimals.all().get(0).equals(firstNormalAnimals));
        assertEquals(true, NormalAnimals.all().get(1).equals(secondNormalAnimals));
    }

    @Test
    public void save_assignsIdToObject() {
        NormalAnimals testNormalAnimals = new NormalAnimals("Simba");
        testNormalAnimals.save();
        NormalAnimals savedNormalAnimals = NormalAnimals.all().get(0);
        assertEquals(testNormalAnimals.getId(), savedNormalAnimals.getId());
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        NormalAnimals firstNormalAnimals = new NormalAnimals("Simba");
        firstNormalAnimals.save();
        NormalAnimals secondNormalAnimals = new NormalAnimals("Arturo");
        secondNormalAnimals.save();
        assertEquals(NormalAnimals.find(secondNormalAnimals.getId()), secondNormalAnimals);
    }

    /*@Test
    public void getSightings_retrievesAllSightingsFromDatabase_sightingsList() {
        NormalAnimals testNormalAnimals= new NormalAnimals("Simba");
        testNormalAnimals.save();
        Sightings firstSightings = new Sightings("Nairobi", testNormalAnimals.getId(), "George");
        firstSightings.save();
        Sightings secondSightings = new Sightings("Moringa", testNormalAnimals.getId(), "Omwami");
        secondSightings.save();
        Object[] sightings = new Object[] { firstSightings, secondSightings };
        assertTrue(testNormalAnimals.getSightings().containsAll(Arrays.asList(sightings)));
    }*/

    @Test
    public void normalAnimals_instantiatesWhenHealthy(){
        NormalAnimals testNormalAnimals = new NormalAnimals("Simba");
        assertEquals(testNormalAnimals.getHealthy(), (NormalAnimals.HEALTHY));
    }

    @Test
    public void normalAnimals_instantiatesWhenIll(){
        NormalAnimals testNormalAnimals = new NormalAnimals("Simba");
        assertEquals(testNormalAnimals.getIll(), (NormalAnimals.ILL));
    }

    @Test
    public void normalAnimals_instantiatesWhenOkay(){
        NormalAnimals testNormalAnimals = new NormalAnimals("Simba");
        assertEquals(testNormalAnimals.getOkay(), (NormalAnimals.OKAY));
    }

    @Test
    public void normalAnimals_instantiatesWithNewborn(){
        NormalAnimals testNormalAnimals = new NormalAnimals("Simba");
        assertEquals(testNormalAnimals.getNewborn(), (NormalAnimals.NEWBORN));
    }

    @Test
    public void normalAnimals_instantiatesWithYoung(){
        NormalAnimals testNormalAnimals = new NormalAnimals("Simba");
        assertEquals(testNormalAnimals.getYoung(), (NormalAnimals.YOUNG));
    }

    @Test
    public void normalAnimals_instantiatesWithAdult(){
        NormalAnimals testNormalAnimals = new NormalAnimals("Simba");
        assertEquals(testNormalAnimals.getAdult(), (NormalAnimals.ADULT));
    }

}