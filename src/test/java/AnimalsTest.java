import org.junit.*;
import static org.junit.Assert.*;

public class AnimalsTest {

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

}