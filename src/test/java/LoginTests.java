import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests {

    @Disabled
    @Test
    void successfulLoginTest() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "firefox";
        Configuration.timeout = 10000;
        open("https://qa.guru/cms/system/login");
        $(".login-form").shouldHave(text("Войти"));
        $("[name=email]").setValue("qagurubot@gmail.com");
        $("[name=password]").setValue("qagurupassword").pressEnter();
        $(".login-form").setValue("Здравствуйте, QA_GURU_BOT").pressEnter();
    }

    @Test
    void unsuccessfulLoginTest() {

    }

}
