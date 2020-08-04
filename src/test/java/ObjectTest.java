import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Dummy playground class.
 */
@Slf4j
public class ObjectTest extends Object implements Cloneable {

    private ObjectTest object1;

    @BeforeEach
    public void setUp() {
        object1 = new ObjectTest();
    }

    public ObjectTest() {

    }

    private String characters;

    @Test
    public void test() {

        String s = "";

        for (char c = 'a'; c < 'z' + 1; c++) {
            s += c;
        }

        assertEquals("abcdefghijklmnopqrstuvwxyz", object1.setCharacters(s));

        if (object1.characters != s) throw new RuntimeException("Something wrong");

        ObjectTest object2 = copy(object1);

        assertTrue(object1.equals(object2));

        log.info(object2.toString());
    }

    /**
     * Assign a pointer to the field 'characters'.
     * @param characters A reference to a String.
     * @return The saved string.
     */
    private String setCharacters(String characters) {

        this.characters = characters;

        return this.characters;
    }

    /**
     * Make a copy of an ObjectTest.
     * @param input Target to copy.
     * @return A clone of the input.
     */
    public static ObjectTest copy(ObjectTest input) {

        ObjectTest output = new ObjectTest();

        output.characters = input.characters;

        return output;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || !(o instanceof ObjectTest)) return false;

        ObjectTest input = (ObjectTest) o;

        return Objects.equals(characters, input.characters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characters);
    }

    @Override
    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + ", " + characters;
    }

}
