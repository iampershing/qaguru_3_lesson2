import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQAFormFillingTests {

    String firstname = "Sergei",
            lastname = "Pershin",
            email = "sergei@sergei.test",
            gender = "Male",
            number = "1234567890",
            month = "March",
            year = "1985",
            day = "01",
            subject = "English",
            hobby = "Sport",
            address = "Test Text",
            state = "NCR",
            city = "Noida",
            success = "Thanks for submitting the form",
            invalidemail = "this is not email";

    File file = new File("src/test/resources/test.jpg");

    @Test
    public void userCanFillTheForm() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").val(firstname);
        $("#lastName").val(lastname);
        $("#userEmail").val(email);
        $x("//label[contains(text(),'Male')]").click();
        $("#userNumber").val(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $x("//label[contains(text(),'Sports')]").click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        $(byText(success)).shouldBe(Condition.visible);
        $("tr:nth-child(1)>td:nth-child(2)").shouldHave(Condition.text(firstname + " " + lastname));
        $("tr:nth-child(2)>td:nth-child(2)").shouldHave(Condition.text(email));
        $("tr:nth-child(3)>td:nth-child(2)").shouldHave(Condition.text(gender));
        $("tr:nth-child(4)>td:nth-child(2)").shouldHave(Condition.text(number));
        $("tr:nth-child(5)>td:nth-child(2)").shouldHave(Condition.text(day + " " + month + "," + year));
        $("tr:nth-child(6)>td:nth-child(2)").shouldHave(Condition.text(subject));
        $("tr:nth-child(7)>td:nth-child(2)").shouldHave(Condition.text(hobby));
        $("tr:nth-child(9)>td:nth-child(2)").shouldHave(Condition.text(address));
        $("tr:nth-child(10)>td:nth-child(2)").shouldHave(Condition.text(state + " " + city));
    }

    @Test
    public void userCanNotFillTheFormWithEmptyFirstName() {
        open("https://demoqa.com/automation-practice-form");
        $("#lastName").val(lastname);
        $("#userEmail").val(email);
        $x("//label[contains(text(),'Male')]").click();
        $("#userNumber").val(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $x("//label[contains(text(),'Sports')]").click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        $(byText(success)).shouldNotBe(Condition.visible);
    }

    @Test
    public void userCanNotFillTheFormWithEmptyLastName() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").val(firstname);
        $("#userEmail").val(email);
        $x("//label[contains(text(),'Male')]").click();
        $("#userNumber").val(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $x("//label[contains(text(),'Sports')]").click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        $(byText(success)).shouldNotBe(Condition.visible);
    }

    @Test
    public void userCanNotFillTheFormWithInvalidEmail() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").val(firstname);
        $("#lastName").val(lastname);
        $("#userEmail").val(invalidemail);
        $x("//label[contains(text(),'Male')]").click();
        $("#userNumber").val(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $x("//label[contains(text(),'Sports')]").click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        $(byText(success)).shouldNotBe(Condition.visible);
    }

    @Test
    public void userCanNotFillTheFormWithNotSelectedGender() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").val(firstname);
        $("#lastName").val(lastname);
        $("#userEmail").val(invalidemail);
        $("#userNumber").val(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $x("//label[contains(text(),'Sports')]").click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        $(byText(success)).shouldNotBe(Condition.visible);
    }


}
