package dungeon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;


class DungeonTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testchooseHeroCorrect() {
        provideInput("4");

        assertEquals(4, DungeonAdventure.chooseHero());
    }
    
    @Test
    public void testchooseHeroBadInt() {
        provideInput("10");
        
        assertEquals(4, DungeonAdventure.chooseHero());
    }
    
    @Test
    public void testchooseHeroString() {
        provideInput("hello");

        assertEquals(4, DungeonAdventure.chooseHero());
    }
}
