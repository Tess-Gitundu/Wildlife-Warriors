import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @AfterEach
    public void clearDown() {
        Animal.clearAll();
    }
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

    @Test
    public void save_insertsObjectIntoDatabase_Animal() {
        Animal testAnimal = new Animal("Gazelle", "North", "Peter");
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
    }

    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
        Animal firstAnimal = new Animal("Gazelle", "South", "Joseph");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Ostrich", "North", "Peter");
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }

    @Test
    public void save_assignsIdToObject() {
        Animal testAnimal = new Animal("Gazelle", "South", "Joseph");
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Animal firstAnimal = new Animal("Gazelle", "South", "Joseph");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Ostrich", "North", "Peter");
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }
}