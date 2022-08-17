package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class RegistrationFormWithTestData extends TestBase {

    @Test
    static void filldata() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        //personal info
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("Shelby@mail.com");
        //$("[for='gender-radio-1']").parent().click();
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567891");
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

    static void checks() {
        $(".modal-dialog").should(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".table-responsive table").$(byText("Student name"))
                .parent().shouldHave(text(firstName + " " + lastName));


    }


}
