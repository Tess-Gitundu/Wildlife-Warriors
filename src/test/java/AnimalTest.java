import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Gazelle", "North", "Peter");
        assertEquals(true, testAnimal instanceof Animal);
    }
    @Test
    public void getName_animalInstantiatesWithName_Gazelle() {
        Animal testAnimal = new Animal("Gazelle", "North", "Peter");
        assertEquals("Gazelle", testAnimal.getName());
    }
    @Test
    public void getLocation_animalInstantiatesWithLocation_North() {
        Animal testAnimal = new Animal("Gazelle", "North", "Peter");
        assertEquals("North", testAnimal.getLocation());
    }
    @Test
    public void getRanger_animalInstantiatesWithRanger_Peter() {
        Animal testAnimal = new Animal("Gazelle", "North", "Peter");
        assertEquals("Peter", testAnimal.getRanger());
    }
}