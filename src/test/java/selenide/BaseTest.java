package selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

public class BaseTest {

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "maximize";
    }

    RegistrationPage registrationPage = new RegistrationPage();
}
