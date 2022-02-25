package pages;

import models.User;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage fillRegistrationForm(User user) {

        // fields
        $("#firstName").setValue(user.getFirstName());
        $("#lastName").setValue(user.getLastName());
        $("#userEmail").setValue(user.getEmail());
        $("#userNumber").setValue(user.getPhone());

        // radio buttons & checkboxes
        $(byText(user.getSex())).click();
        $(byText(user.getHobby())).click();

        // calendar form
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(user.getYear());
        $(".react-datepicker__month-select").selectOption(user.getMonth());
        $("[aria-label*='" + user.getDay() + "th']").click();

        // dropdowns
        $("#subjectsInput").setValue(user.getSubject()).pressEnter();
        $("#currentAddress").setValue(user.getAddress());
        $("#state").scrollTo().click();
        $(byText(user.getState())).click();
        $("#city").click();
        $(byText(user.getCity())).click();

        // uploading photo
        $("#uploadPicture").uploadFromClasspath("pictures/" + user.getPhoto());
        return this;
    }


    public RegistrationPage submitForm() {
        $("#submit").click();
        return this;
    }


    public void verifyThatUserCreated(User user) {
        $(".table-responsive").shouldHave(
                text("Student Name " + user.getFirstName() + " " + user.getLastName()),
                text("Student Email " + user.getEmail()),
                text("Gender " + user.getSex()),
                text("Mobile " + user.getPhone()),
                text("Date of Birth " + user.getDay() + " " + user.getMonth() + "," + user.getYear()),
                text("Subjects " + user.getSubject()),
                text("Hobbies " + user.getHobby()),
                text("Picture " + user.getPhoto()),
                text("Address " + user.getAddress()),
                text("State and City " + user.getState() + " " + user.getCity()));
    }
}
