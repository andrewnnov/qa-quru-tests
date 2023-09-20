package simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("simple")
public class SkippedTests {

    @Test
    @Disabled
    public void test6() {
        System.out.println("Test6");
    }

    @Test
    @Disabled
    public void test7() {
        System.out.println("Test7");
    }

}
