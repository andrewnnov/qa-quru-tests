package com.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        //arrange
        //act
        //assert
        open("https://github.com/");

        $("[type=button].flex-1").click();
        $("#query-builder-test").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $$(".hKtuLA").first().$("a").click();
        //перевод строки идентичен пробелу
        $("#repository-container-header").shouldHave(Condition.text("selenide / selenide"));
    }

    @Test
    void solntsevShouldBeOk() {
        open("https://github.com/selenide/selenide");
        $(".BorderGrid").$(Selectors.byText("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();
        sleep(5000);
        //$$(".Truncate a").first().shouldHave(Condition.text("Andrei Solntcev"));
        $(".Truncate-text a").shouldHave(Condition.text("Andrei Solntsev"));
    }
}
