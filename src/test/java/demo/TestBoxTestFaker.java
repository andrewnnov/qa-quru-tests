package demo;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.randomEmail;
import static utils.RandomUtils.randomString;

public class TestBoxTestFaker {

    @Test
    void testBoxTestFaker(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String email = faker.internet().emailAddress();
        //Faker faker1 = new Faker(new Locale("ru"));
        String currentAddress = faker.address().streetAddress();



        open("https://demoqa.com/text-box");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $(".main-header").shouldHave(text("Text Box"));
        $("#userName").setValue(firstName);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue("Казань");
        $("#submit").click();
        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave(text(firstName));
        $("#output").$("#email").shouldHave(text(email));
        $("#output").$("#currentAddress").shouldHave(text(currentAddress));
        $("#output").$("#permanentAddress").shouldHave(text("Казань"));
    }
}
