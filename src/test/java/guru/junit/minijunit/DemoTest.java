package guru.junit.minijunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DemoTest {

    @Test
    void demo() {
        System.out.println("Demo test!");
        Assertions.assertTrue(3 < 2);
    }
}
