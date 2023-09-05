package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class StudentRegistrationForm {

    public String firstName = "Ivan";
    public String lastName = "Ivanov";

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "maximize";
    }

    @Test
    public void fillStudentForm() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        $("h5").shouldHave(Condition.text("Student Registration Form"));
        $("#firstName").sendKeys(firstName);
        $("#lastName").sendKeys(lastName);
        $("#userEmail").sendKeys("test@test.com");
        $(byText("Male")).click();
        $("#userNumber").sendKeys("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__week", 2).click();

        $("#subjectsWrapper input").sendKeys("Biology");
        $("#subjectsWrapper input").pressEnter();

        $(byText("Sports")).click();
        File file = new File("/Users/andrey/IdeaProjects/qa-quru-tests/src/test/resources/example.txt");
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress-wrapper .form-control").sendKeys("Address");
        $("#state").click();
        //$("#state").click();
        sleep(1000);
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi"));
        $("#submit").click();
        sleep(2000);

        String textExpected = $(".h4").getText();
        System.out.println(textExpected);
        Assertions.assertEquals("Thanks for submitting the form", textExpected);

        $(".table-responsive").shouldHave(Condition.text("Student name " +  firstName + " " + lastName));
    }
}
