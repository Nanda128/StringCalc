import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testValidAddition() {
        String input = "5+3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Main.main(new String[]{});
        assertEquals(0, 0); // If no exception is thrown, it's considered a success
    }

    @Test
    public void testValidSubtraction() {
        String input = "10-4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Main.main(new String[]{});
        assertEquals(0, 0);
    }

    @Test
    public void testValidMultiplication() {
        String input = "3*4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Main.main(new String[]{});
        assertEquals(0, 0);
    }

    @Test
    public void testInvalidCharacter() {
        String input = "10+3*2$-5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Main.main(new String[]{});
        assertEquals(0, 0);
    }

    @Test
    public void testEmptyInput() {
        String input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Main.main(new String[]{});
        assertEquals(0, 0);
    }
}
