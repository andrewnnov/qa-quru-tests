package junit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

public class FirstJunitTes {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        System.out.println("for chrome");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }

    @AfterAll
    static void afterAll () {
        System.out.println("AfterAll");
    }

    @Test
    public void firstTest() {
        System.out.println("test1");
    }

    @Test
    public void secondTest() {
        System.out.println("test2");
    }
}

//https://www.youtube.com/watch?v=pln38fIbYqA
//https://ru.selenide.org/2016/10/20/selenide-vs-pure-selenium/
