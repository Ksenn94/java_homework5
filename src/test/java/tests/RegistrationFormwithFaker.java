package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.RegistrationFormPage;
import tests.TestBase;

import java.util.Locale;

public class RegistrationFormwithFaker extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker(new Locale("en"));
    String firstName,
            lastName,
            userEmail,
            userNumber,
            gender,
            userPic,
            day,
            month,
            year,
            userAddress,
            city,
            state,
            subject,
            hobby;

    @BeforeEach
    void prepareTestData() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        gender = "Male";
        userPic = "DSC07524.JPG";
        userNumber = faker.phoneNumber().subscriberNumber(10);
        day = faker.number().numberBetween(1, 28) + "";
        month = "July";
        userAddress = faker.address().fullAddress();
        year = faker.number().numberBetween(2000, 2010) + "";
        city = "NCR";
        state = "Delhi";
        subject = "Math";
        hobby = "Sports";

    }

    @Test
    void fillregistrationformtest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setNumber(userNumber)
                .setBirthdate(day, month, year)
                .uploadPic(userPic)
                .setSubject(subject)
                .setHobby(hobby)
                .setAddress(userAddress)
                .setCityState(city, state)
                .submit();


        registrationFormPage.checkResultsTableVisible()
               .checkResult("Student Name", firstName + " " + lastName)
               .checkResult("Student Email", userEmail)
               .checkResult("Date of Birth", day + " " + month + ","+ year)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", userPic)
                .checkResult("Address", userAddress)
                .checkResult("State and City", city + " " + state);
    }
}
