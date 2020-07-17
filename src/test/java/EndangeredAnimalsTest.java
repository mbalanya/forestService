import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

import java.util.Arrays;

public class EndangeredAnimalsTest {

    @Rule
    public DatabaseRule databse = new DatabaseRule();

    @Test
    public void endangeredAnimals_instantiatesCorrectly_true() {
        EndangeredAnimals testEndangeredAnimals = new EndangeredAnimals("Simba");
        assertEquals(true, testEndangeredAnimals instanceof EndangeredAnimals);
    }

    @Test
    public void getName_endangeredAnimalsInstantiatesWithName_Simba() {
        EndangeredAnimals testEndangeredAnimals = new EndangeredAnimals("Simba");
        assertEquals("Simba", testEndangeredAnimals.getName());
    }

    @Test
    public void equals_returnsTrueIfNameAndEmailAreSame_true() {
        EndangeredAnimals firstEndangeredAnimals = new EndangeredAnimals("Simba");
        EndangeredAnimals anotherEndangeredAnimals = new EndangeredAnimals("Simba");
        assertTrue(firstEndangeredAnimals.equals(anotherEndangeredAnimals));
    }

    @Test
    public void save_insertsObjectIntoDatabase_EndangeredAnimals() {
        EndangeredAnimals testEndangeredAnimals = new EndangeredAnimals("Simba");
        testEndangeredAnimals.save();
        assertTrue(EndangeredAnimals.all().get(0).equals(testEndangeredAnimals));
    }

    @Test
    public void all_returnsAllInstancesOfEndangeredAnimals_true() {
        EndangeredAnimals firstEndangeredAnimals = new EndangeredAnimals("Simba");
        firstEndangeredAnimals.save();
        EndangeredAnimals secondEndangeredAnimals = new EndangeredAnimals("Arturo");
        secondEndangeredAnimals.save();
        assertEquals(true, EndangeredAnimals.all().get(0).equals(firstEndangeredAnimals));
        assertEquals(true, EndangeredAnimals.all().get(1).equals(secondEndangeredAnimals));
    }

    @Test
    public void save_assignsIdToObject() {
        EndangeredAnimals testEndangeredAnimals = new EndangeredAnimals("Simba");
        testEndangeredAnimals.save();
        EndangeredAnimals savedEndangeredAnimals = EndangeredAnimals.all().get(0);
        assertEquals(testEndangeredAnimals.getId(), savedEndangeredAnimals.getId());
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        EndangeredAnimals firstEndangeredAnimals = new EndangeredAnimals("Simba");
        firstEndangeredAnimals.save();
        EndangeredAnimals secondEndangeredAnimals = new EndangeredAnimals("Arturo");
        secondEndangeredAnimals.save();
        assertEquals(EndangeredAnimals.find(secondEndangeredAnimals.getId()), secondEndangeredAnimals);
    }

    /*@Test
    public void getSightings_retrievesAllSightingsFromDatabase_sightingsList() {
        EndangeredAnimals testEndangeredAnimals= new EndangeredAnimals("Simba");
        testEndangeredAnimals.save();
        Sightings firstSightings = new Sightings("Nairobi", testEndangeredAnimals.getId(), "George");
        firstSightings.save();
        Sightings secondSightings = new Sightings("Moringa", testEndangeredAnimals.getId(), "Omwami");
        secondSightings.save();
        Object[] sightings = new Object[] { firstSightings, secondSightings };
        assertTrue(testEndangeredAnimals.getSightings().containsAll(Arrays.asList(sightings)));
    }*/

    @Test
    public void endangeredAnimals_instantiatesWhenHealthy(){
        EndangeredAnimals testEndangeredAnimals = new EndangeredAnimals("Simba");
        assertEquals(testEndangeredAnimals.getHealthy(), (EndangeredAnimals.HEALTHY));
    }

    @Test
    public void endangeredAnimals_instantiatesWhenIll(){
        EndangeredAnimals testEndangeredAnimals = new EndangeredAnimals("Simba");
        assertEquals(testEndangeredAnimals.getIll(), (EndangeredAnimals.ILL));
    }

    @Test
    public void endangeredAnimals_instantiatesWhenOkay(){
        EndangeredAnimals testEndangeredAnimals = new EndangeredAnimals("Simba");
        assertEquals(testEndangeredAnimals.getOkay(), (EndangeredAnimals.OKAY));
    }

    @Test
    public void endangeredAnimals_instantiatesWithNewborn(){
        EndangeredAnimals testEndangeredAnimals = new EndangeredAnimals("Simba");
        assertEquals(testEndangeredAnimals.getNewborn(), (EndangeredAnimals.NEWBORN));
    }

    @Test
    public void endangeredAnimals_instantiatesWithYoung(){
        EndangeredAnimals testEndangeredAnimals = new EndangeredAnimals("Simba");
        assertEquals(testEndangeredAnimals.getYoung(), (EndangeredAnimals.YOUNG));
    }

    @Test
    public void endangeredAnimals_instantiatesWithAdult(){
        EndangeredAnimals testEndangeredAnimals = new EndangeredAnimals("Simba");
        assertEquals(testEndangeredAnimals.getAdult(), (EndangeredAnimals.ADULT));
    }

}