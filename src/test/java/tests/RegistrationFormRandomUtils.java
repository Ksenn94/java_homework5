package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.RandomStringUtils;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.*;


public class RegistrationFormRandomUtils extends TestBase {
    String firstName;
    String lastName;
    String day;
    String month;
    String year;
    String email;
    String phone;

    @BeforeEach
    void prepareTestData() {
        firstName = getRandomString(10);
        lastName = getRandomString(15);
        email = getRandomEmail(5);
        phone = getRandomPhone();
        day ="30";
        month = "October";
        year = "2002";
    }

    @Test
    void filldata() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        //personal info
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("[for='gender-radio-1']").parent().click();
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(phone);
        //calendar
        $("#dateOfBirthInput").scrollIntoView(true).click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();

        // picture
        //$("#uploadPicture").uploadFile(new File("src/test/resources/DSC07524.JPG"));
        $("#uploadPicture").uploadFromClasspath("DSC07524.JPG");
        //subjects
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();
        //hobbies
        $("[for = hobbies-checkbox-2]").click();
        $("[for = hobbies-checkbox-1]").click();
        //address
        $("#currentAddress").setValue("Country Region City Street house floor 2 apartment 45");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Agra").pressEnter();
        //executeJavaScript("$('footer').remove()");
        $("#submit").scrollTo().pressEnter();

    }

    void checks() {
        $(".modal-dialog").should(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".table-responsive table").$(byText("Student Name"))
                .parent().shouldHave(text(firstName + " " + lastName));


    }


}

