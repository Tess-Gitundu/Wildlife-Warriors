import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndangeredTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @AfterEach
    public void clearDown() {
        Endangered.clearAll();
    }

    @Test
    public void endangered_instantiatesCorrectly_true() {
        Endangered testEndangered = new Endangered("Gazelle", "North", "Peter", "Okay", 1);
        assertEquals(true, testEndangered instanceof Endangered);
    }
    @Test
    public void Endangered_instantiatesWithName_String() {
        Endangered testEndangered = new Endangered("Gazelle", "North", "Peter", "Okay", 1);
        assertEquals("Gazelle", testEndangered.getName());
    }

    @Test
    public void Endangered_instantiatesWithLocation_String() {
        Endangered testEndangered = new Endangered("Gazelle", "North", "Peter", "Okay", 1);
        assertEquals("North", testEndangered.getLocation());
    }

    @Test
    public void Endangered_instantiatesWithRanger_String() {
        Endangered testEndangered = new Endangered("Gazelle", "North", "Peter", "Okay", 1);
        assertEquals("Peter", testEndangered.getRanger());
    }

    @Test
    public void Endangered_instantiatesWithHealth_String() {
        Endangered testEndangered = new Endangered("Gazelle", "North", "Peter", "Okay", 1);
        assertEquals("Okay", testEndangered.getHealth());
    }

    @Test
    public void Endangered_instantiatesWithAge_int() {
        Endangered testEndangered = new Endangered("Gazelle", "North", "Peter", "Okay", 1);
        assertEquals(1, testEndangered.getAge());
    }

    @Test
    public void equals_returnsTrueIfNameLocationRangerHealthAndAgeAreSame_true() {
        Endangered testEndangered = new Endangered("Gazelle", "North", "Peter", "Okay", 1);
        Endangered anotherEndangered = new Endangered("Gazelle", "North", "Peter", "Okay", 1);
        assertTrue(testEndangered.equals(anotherEndangered));
    }

    @Test
    public void save_returnsTrueIfDescriptionAreTheSame() {
        Endangered testEndangered = new Endangered("Gazelle", "North", "Peter", "Okay", 1);
        testEndangered.save();
        assertTrue(Endangered.all().get(0).equals(testEndangered));
    }

    @Test
    public void save_assignsIdToEndangered() {
        Endangered testEndangered = new Endangered("Gazelle", "North", "Peter", "Okay", 1);
        testEndangered.save();
        Endangered saveEndangered = Endangered.all().get(0);
        assertEquals(saveEndangered.getId(), testEndangered.getId());
    }

    @Test
    public void all_returnsAllInstancesOfEndangered_true() {
        Endangered firstEndangered = new Endangered("Gazelle", "North", "Peter", "Okay", 1);
        firstEndangered.save();
        Endangered secondEndangered = new Endangered("Giraffe", "West", "Francis", "ill", 1);
        secondEndangered.save();
        assertEquals(true, Endangered.all().get(0).equals(firstEndangered));
        assertEquals(true, Endangered.all().get(1).equals(secondEndangered));
    }

    @Test
    public void find_returnsMonsterWithSameId_secondMonster() {
        Endangered firstEndangered = new Endangered("Gazelle", "North", "Peter", "Okay", 1);
        firstEndangered.save();
        Endangered secondEndangered = new Endangered("Giraffe", "West", "Francis", "ill", 5);
        secondEndangered.save();
        assertEquals(Endangered.find(secondEndangered.getId()), secondEndangered);
    }
}