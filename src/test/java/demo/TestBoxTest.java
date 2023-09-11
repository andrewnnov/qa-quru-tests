package demo;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.randomEmail;
import static utils.RandomUtils.randomString;

public class TestBoxTest {
    String userName = randomString(10);
    String lastName = randomString(10);
    String email = randomEmail();


    @Test
    void testBoxTest(){
        open("https://demoqa.com/text-box");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $(".main-header").shouldHave(text("Text Box"));
        $("#userName").setValue(userName);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue("Актобе");
        $("#permanentAddress").setValue("Казань");
        $("#submit").click();
        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave(text(userName));
        $("#output").$("#email").shouldHave(text(email));
        $("#output").$("#currentAddress").shouldHave(text("Актобе"));
        $("#output").$("#permanentAddress").shouldHave(text("Казань"));
    }
}
