package tests.config;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseUITest {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "CHROME";
        Configuration.browserSize = "1920x1400";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
