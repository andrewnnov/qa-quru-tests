package selenide;

import com.codeborne.selenide.*;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Snippets {

    void browserCommandExample() {
        Configuration.baseUrl = "https://.....";

        open("https://google.com");
        open("/customer/orders"); //-Dselenide.baseUrl = https://123.23.23.1
        open("/", AuthenticationType.BASIC,
                new BasicAuthCredentials("", "user", "password"));

        Selenide.back();
        Selenide.refresh();

        Selenide.clearBrowserCookies(); //вар разлогин
        Selenide.clearBrowserLocalStorage();
        executeJavaScript("sessionStorage.clear();");

        Selenide.confirm(); //ok in alert dialog
        Selenide.dismiss(); // cancel in alert dialogs

        Selenide.closeWindow(); //close active tab
        Selenide.closeWebDriver(); //close browser completely

        Selenide.switchTo().window("The internet");

        Selenide.switchTo().frame("new");
        Selenide.switchTo().defaultContent(); //return from frame back to the main DOM

        var cookie = new Cookie("foo", "bar");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);

    }

    void selectors_example() {
        $("div").click();
        element("div").click();

        $("div", 2).click(); //third div

        $x("//h1//div").click();
        $(byXpath("//h1//div")).click();

        $(byText("Text")).click();
        $(withText("ul tex")).click(); // поиск по подстроке

        $(byTagAndText("div", "full text")).click();
        $(withTagAndText("div", "ull tex")).click();

        $("").parent();
        $("").sibling(1);
        $("").preceding(1);
        $("").closest("div");
        $("").ancestor("div");
        $("div:last-child");

        $("div").$("h1").find(byText("abc")).click(); //можно использовать find вместо $
        $("div").$("h1").$(byText("abc")).click(); // но с find нельзя начинать

        $(byAttribute("abc", "x")).click();
        $("[abc=x]").click();

        $(byId("myText")).click();
        $("myText").click();

        $(byClassName("red")).click();
        $(".red").click();
    }

    void action_example() {

        $("").click();
        $("").doubleClick();
        $("").contextClick(); //правый клик

        $("").hover();

        $("").setValue("ff");
        $("").append("text"); //добавит текст в конец

        $("").clear();
        $("").setValue(""); //clear

        $("div").sendKeys("c"); //hotkey c on element
        actions().sendKeys("c").perform();
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform(); //ctrl + f
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f"));


        $("").pressEnter();
        $("").pressEscape();
        $("").pressTab();

        //complex actions with keyboard and mouse example
        actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release()
                .perform();

        $("").selectOption("dropdown_option");
        $("").selectRadio("radio_options");
    }

    void assertions_example() {
        //во всех шудах запрогроммирован стандартный таймаут 4 сек
        $("").shouldBe(visible);
        $("").shouldNotBe(visible);
        $("").shouldHave(text("abs"));
        $("").shouldNotHave(text("abs"));
        $("").should(appear);
        $("").shouldNot(appear);

        //longer timeouts
        $("").shouldBe(visible, Duration.ofSeconds(30));
    }

    void condition_example() {
        $("").shouldBe(visible);
        $("").shouldBe(hidden);

        $("").shouldHave(text("abc"));
        $("").shouldHave(exactText("abc"));
        $("").shouldHave(textCaseSensitive("abc"));
        $("").shouldHave(exactTextCaseSensitive("abc"));
        $("").should(matchText("[0-9]abc$"));

        $("").shouldHave(cssClass("red"));
        $("").shouldHave(cssValue("font-size", "12"));


        $("").shouldHave(value("25"));
        $("").shouldHave(exactValue("25"));
        $("").shouldBe(empty);

        $("").shouldHave(attribute("disable"));
        $("").shouldHave(attribute("name", "example"));
        $("").shouldHave(attributeMatching("name", "[0-9]abs$"));

        $("").shouldBe(checked); //for checkbox

        //warning! Only checks if it's in DOM, not if it is visible! You don't need it in most tests!
        $("").should(exist);

        $("").shouldBe(disabled);
        $("").shouldBe(enabled);
    }

    void collections_examples() {
        $$("div"); //does nothing
        $$x("div");

        $$("div").filterBy(text("123")).shouldHave(CollectionCondition.size(1));
        $$("div").excludeWith(text("123")).shouldHave(CollectionCondition.size(1));

        $$("div").first().click();
        elements("div").first().click();

        $$("").last().click();
        $$("").get(1).click();
        $("div", 1).click(); //same as previous
        $$("div").findBy(text("123")).click(); //find first

        //assertions
        $$("").shouldHave(CollectionCondition.size(0));
        $$("").shouldBe(CollectionCondition.empty);

        $$("").shouldHave(texts("Alfa", "Beta", "Gama")); //неточная проверка
        $$("").shouldHave(exactTexts("Alfa", "Beta", "Gama"));

        $$("").shouldHave(textsInAnyOrder("Beta", "Alfa", "Gama"));
        $$("").shouldHave(exactTextsCaseSensitiveInAnyOrder("Beta", "Alfa", "Gama"));

        $$("").shouldHave(itemWithText("Gamma")); //only one text

        $$("").shouldHave(sizeGreaterThan(0));
        $$("").shouldHave(sizeGreaterThanOrEqual(1));
        $$("").shouldHave(sizeLessThan(3));
        $$("").shouldHave(sizeLessThanOrEqual(2));
    }

    void file_operation_examples() throws FileNotFoundException {
        File file1 = $("a.filelink").download(); //works only simple links
        File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER));
        //more common options, but may have problems with Grid/Selenoid

        File file = new File("src/resources/readme.txt");
        $("#file_upload").uploadFile(file);
        $("#file_upload").uploadFromClasspath("readme.txt");
        //don't forget to submit
        $("uploadButton").click();
    }

    void javascript_example() {
        executeJavaScript("alert(selenide)");
        executeJavaScript("alert(arguments[0]+arguments[1];", "abc", 12);
        long fortytwo = executeJavaScript("return arguments[0]+arguments[1];", 6, 7);
    }
}
