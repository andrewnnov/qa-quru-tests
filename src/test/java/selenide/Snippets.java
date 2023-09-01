package selenide;

import com.codeborne.selenide.*;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.Cookie;

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

    }
}
