package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultModal {

    public void verifyModalAppear() {
        $(".modal-dialog").should(Condition.appear);
        //Assertions.assertEquals("Thanks for submitting the form", value);
    }

    public void verifyResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }
}
