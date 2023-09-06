package pages.components;

import java.io.File;
import static com.codeborne.selenide.Selenide.$;

public class UploadFiles {

    public void uploadPicture(String value) {
        File file = new File("/Users/andrey/IdeaProjects/qa-quru-tests/src/test/resources/" + value);
        $("#uploadPicture").uploadFile(file);
    }
}
