import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalsTest {

    @Rule
    public DatabaseRule databse = new DatabaseRule();

    @Test
    public void animals_instantiatesCorrectly_true() {
        Animals testAnimals = new Animals("Simba");
        assertEquals(true, testAnimals instanceof Animals);
    }

    @Test
    public void getName_animalsInstantiatesWithName_Simba() {
        Animals testAnimals = new Animals("Simba");
        assertEquals("Simba", testAnimals.getName());
    }

    @Test
    public void equals_returnsTrueIfNameAndEmailAreSame_true() {
        Animals firstAnimals = new Animals("Simba");
        Animals anotherAnimals = new Animals("Simba");
        assertTrue(firstAnimals.equals(anotherAnimals));
    }

    @Test
    public void save_insertsObjectIntoDatabase_Animals() {
        Animals testAnimals = new Animals("Simba");
        testAnimals.save();
        assertTrue(Animals.all().get(0).equals(testAnimals));
    }

    @Test
    public void all_returnsAllInstancesOfAnimals_true() {
        Animals firstAnimals = new Animals("Simba");
        firstAnimals.save();
        Animals secondAnimals = new Animals("Arturo");
        secondAnimals.save();
        assertEquals(true, Animals.all().get(0).equals(firstAnimals));
        assertEquals(true, Animals.all().get(1).equals(secondAnimals));
    }

}