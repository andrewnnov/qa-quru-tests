package guru.junit;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import guru.junit.data.Locale;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$$;

public class SelenideTest {

    static Stream<Arguments> selenideSiteShouldContainAllButtonsForGivenLocale() {
        return Stream.of(
                Arguments.of(Locale.EN, List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users",  "Quotes")),
                Arguments.of(Locale.RU, List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи",  "Отзывы"))
        );
    }

    @MethodSource("selenideSiteShouldContainAllButtonsForGivenLocale")
    @ParameterizedTest(name="Для локали {0} отображаются кнопки {1}")
    @Tag("Blocker")
    void selenideSiteShouldContainAllButtonsForGivenLocale(
            Locale locale,
            List<String> buttons) {
        Selenide.open("https://selenide.org/");
        $$("#languages a").find(Condition.text(locale.name())).click();
        $$(".main-menu-pages a")
                .filter(Condition.visible)
                .shouldHave(CollectionCondition.texts(buttons));



    }
}
