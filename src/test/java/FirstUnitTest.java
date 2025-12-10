import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstUnitTest {

    @Test
    public void testAddition() {
        int a = 2;
        int b = 3;
        int sum = a + b;
        assertEquals(5, sum, "2 + 3 should equal 5");
    }
}
