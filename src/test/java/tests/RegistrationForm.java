package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.RegistrationFormPage;

public class RegistrationForm extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillregistrationformtest() {
        registrationFormPage.openPage()
                .setFirstName("Tommy")
                .setLastName("Shelby")
                .setEmail("Shelby@mail.com")
                .setGender("Male")
                .setNumber("1234567891")
                .setBirthdate("25", "July", "1997")
                .uploadPic("DSC07524.JPG")
                .setSubject("Math")
                .setHobby("Sports")
                .setAddress("Country Region City Street house floor 2 apartment 45")
                .setCityState("NCR", "Delhi")
                .submit();


        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Tommy Shelby")
                .checkResult("Student Email", "Shelby@mail.com")
                .checkResult("Date of Birth", "25 July,1997");



    }
}
