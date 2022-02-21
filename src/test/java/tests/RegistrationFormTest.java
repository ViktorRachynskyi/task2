package tests;

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
        String firstName = "Elon";
        String lastName = "Mask";
        String email = "tesla-mail@space.com";
        String sex = "Female";
        String phone = "0676767676";
        String year = "1998";
        String month = "January";
        String day = "17";
        String subject1 = "Physics";
        String subject2 = "maths"; //use only lower case - need for testing dropdown
        String verifySubject2 = subject2.substring(0, 1).toUpperCase() + subject2.substring(1);
        String hobby = "Music";
        String photo = "test.jpg";
        String address = "Mars str. 447/1";
        String state = "Haryana";
        String city = "Karnal";

        open("/automation-practice-form");

        //fields
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(phone);

        //radio buttons & checkboxes
        $(byText(sex)).click();
        $(byText(hobby)).click();
//        $("#gender-radio-2").selectRadio(sex);    -----    why this code isn't work?

        //calendar
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $("[aria-label*='" + day + "th']").click();

        //dropdowns
        $("#subjectsInput").setValue(subject1).pressEnter();
        $("#subjectsInput").setValue(subject2);
        $(byText(verifySubject2)).click();
        $("#currentAddress").setValue(address);
        $("#state").scrollTo().click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();

        //uploading form
        $("#uploadPicture").uploadFromClasspath("pictures/" + photo);

        $("#submit").click();

        //verifying created person
        $(".table-responsive").shouldHave(
                text("Student Name " + firstName + " " + lastName),
                text("Student Email " + email),
                text("Gender " + sex),
                text("Mobile " + phone),
                text("Date of Birth " + day + " " + month + "," + year),
                text("Subjects " + subject1 + ", " + verifySubject2),
                text("Hobbies " + hobby),
                text("Picture " + photo),
                text("Address " + address),
                text("State and City " + state + " " + city));
    }
}