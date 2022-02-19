package toolsQA;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1020";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void registrationFormTest() {

        open("/automation-practice-form");

        $(".main-header").should(matchText("Practice Form"));

        $("#firstName").setValue("Elon");
        $("#lastName").setValue("Mask");
        $("#userEmail").setValue("tesla-mail@space.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("0676767676");
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#subjectsInput").setValue("maths");
        $(byText("Maths")).click();
        $(byText("Music")).click();
        $("#currentAddress").setValue("Mars str. 447/1");
        $("#state").scrollTo().click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();
        sleep(3000);
    }
}
