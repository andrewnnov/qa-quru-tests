package guru.junit;

import com.codeborne.selenide.Condition;
import guru.junit.data.Locale;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;


@Disabled("дизэбл всего класса с тестами")
public class JunitSimpleTest {

    @BeforeEach
    void setUp() {

    }

    @DisplayName("Демонстрационный тест")
    @Test
    void simpleTest() {

    }

    @Disabled("причина отключения")
    @Test
    @Tag("Блокер")
    void simpleSecondTest() {

    }

    @ValueSource(
            strings = {"one", "two", "three"}
    )
    @ParameterizedTest
    void parametrizeValueTest(String productName) {
        $("").setValue(productName).pressEnter();
    }


    @CsvSource({
            "allure, http://allure.com",
            "Selenide, http://selenide.com"
    })
    //OR
    @CsvFileSource(resources = "/testData.csv")
    @ParameterizedTest(name="Название {1} теста {0}")
    void parametrizeTest(String productName, String productUrl) {
        $("").setValue(productName).pressEnter();
        $("").shouldHave(Condition.text(productUrl));
    }





}
