package tools.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class ToolsQATest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1020";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void RegistrationFormTest() {
        open("/automation-practice-form");
    }
}
