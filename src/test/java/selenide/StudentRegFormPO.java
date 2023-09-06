package selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class StudentRegFormPO extends BaseTest {
    String userName = "Andrew";
    String lastName = "Egorov";
    String email = "test@test.com";
    String gender = "Male";
    String number = "1234567890";
    String subject = "Biology";
    String hobbies = "Sports";
    String nameOfFile = "example.txt";
    String currentAddress = "My address";
    String state = "NCR";
    String city = "Delhi";

    @Test
    public void regStudent() {
        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(number)
                .setBirthDate("11", "May", "1997")
                .setUserSubject(subject)
                .setUserHobbies(hobbies)
                .uploadFile(nameOfFile)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .clickSubmitButton();


        registrationPage.verifyResultsModal()
                .verifyResultOfTable("Student Name", userName + " Egorov")
                .verifyResultOfTable("Student Email", email);
    }
}
