package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;
import pages.components.UploadFiles;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement dateOfBirth = $("#dateOfBirthInput");
    private SelenideElement userNumber = $("#userNumber");
    private SelenideElement userSubject = $("#subjectsWrapper input");
    private SelenideElement currentAddress = $("#currentAddress-wrapper .form-control");
    private SelenideElement submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();
    UploadFiles uploadFiles = new UploadFiles();


    public RegistrationPage openPage() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        $("h5").shouldHave(Condition.text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.sendKeys(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.sendKeys(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.sendKeys(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumber.sendKeys(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirth.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setUserSubject(String value) {
        userSubject.sendKeys(value);
        userSubject.pressEnter();
        return this;
    }

    public RegistrationPage setUserHobbies(String value) {
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadFile(String value) {
        uploadFiles.uploadPicture(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.sendKeys(value);
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city));
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationPage verifyResultsModal() {
        registrationResultModal.verifyModalAppear();
        return this;
    }

    public RegistrationPage verifyResultOfTable(String key, String value) {
        registrationResultModal.verifyResult(key, value);
        return this;
    }
}
