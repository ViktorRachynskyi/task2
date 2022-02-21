package toolsQA;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
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
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__month-select").selectOption("January");
        $("[aria-label*='17th']").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#subjectsInput").setValue("maths");
        $(byText("Maths")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("picture/test.jpg");
        $("#currentAddress").setValue("Mars str. 447/1");
        $("#state").scrollTo().click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Student Name Elon Mask"), text("Student Email tesla-mail@space.com"),
                text("Gender Female"), text("Mobile 0676767676"), text("Date of Birth 17 January,1998"),
                text("Subjects Physics, Maths"), text("Hobbies Music"), text("Picture test.jpg"),
                text("Address Mars str. 447/1"), text("State and City Haryana Karnal"));
    }
}