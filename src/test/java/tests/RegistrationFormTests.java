package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import models.User;
import pages.RegistrationPage;
import tests.config.BaseUITest;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Registration page Tests")
public class RegistrationFormTests extends BaseUITest {

    @Test
    void firstTest() {
        assertTrue(true);
    }

    @Test
    void registrationFormTest() {

        User user = User.builder()
                .firstName("Elon")
                .lastName("Mask")
                .email("tesla-mail@space.com")
                .sex("Female")
                .phone("0676767676")
                .year("1998")
                .month("January")
                .day("17")
                .subject("Physics")
                .hobby("Music")
                .photo("test.jpg") // use file name
                .address("Mars str. 447/1")
                .state("NCR")
                .city("Delhi")
                .build();

        new RegistrationPage()
                .openRegistrationPage()
                .fillRegistrationForm(user)
                .submitForm()
                .verifyThatUserCreated(user);

    }
}