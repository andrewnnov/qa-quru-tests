package selenide;

import com.codeborne.selenide.*;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

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

    }
}
