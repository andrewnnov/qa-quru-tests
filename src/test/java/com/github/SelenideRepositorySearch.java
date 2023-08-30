package com.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        //arrange
        //act
        //assert
        Selenide.open("https://github.com/");

        $("[type=button].flex-1").click();
        $("#query-builder-test").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $$(".hKtuLA").first().$("a").click();
        //перевод строки идентичен пробелу
        $("#repository-container-header").shouldHave(Condition.text("selenide / selenide"));





    }
}
