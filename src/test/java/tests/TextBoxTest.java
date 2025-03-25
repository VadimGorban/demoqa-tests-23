package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {

    @BeforeAll
    static void beforeALL() {
                Configuration.browserSize = "1920x1080";
                Configuration.pageLoadStrategy = "eager";
    }
    
    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Vadim");
        $("#lastName").setValue("Gorban");
        $("#userEmail").setValue("vgorban00@mail.ru");
        $("[for = gender-radio-1]").click();
        $("#userNumber").setValue("8914351160");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day--030").click();
        $(".subjects-auto-complete__value-container--is-multi").click();
        $("#subjectsInput").setValue("E");
        $("input#subjectsInput").setValue("English").pressEnter();
        $("[for = hobbies-checkbox-1]").click();
        $("[for = hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFromClasspath("blue-paint-textured-background-aesthetic-diy-experimental-art (1).jpg");
        $("#currentAddress").setValue("Chita, 1 mkr., 24, 26");
        $("#react-select-3-input").setValue("n");
        $("#react-select-3-option-0").click();
        $("#react-select-4-input").setValue("d");
        $("#react-select-4-option-0").click();
        $("#submit").click();

        $(".table tbody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Vadim Gorban"));
        $(".table tbody tr:nth-child(2) td:nth-child(2)").shouldHave(text("vgorban00@mail.ru"));
        $(".table tbody tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $(".table tbody tr:nth-child(4) td:nth-child(2)").shouldHave(text("8914351160"));
        $(".table tbody tr:nth-child(5) td:nth-child(2)").shouldHave(text("30 March,1999"));
        $(".table tbody tr:nth-child(6) td:nth-child(2)").shouldHave(text("English"));
        $(".table tbody tr:nth-child(7) td:nth-child(2)").shouldHave(text("Sports, Music"));
        $(".table tbody tr:nth-child(8) td:nth-child(2)").shouldHave(text("blue-paint-textured-background-aesthetic-diy-experimental-art (1).jpg"));
        $(".table tbody tr:nth-child(9) td:nth-child(2)").shouldHave(text("Chita, 1 mkr., 24, 26"));
        $(".table tbody tr:nth-child(10) td:nth-child(2)").shouldHave(text("NCR Delhi"));

        sleep(4000);
    }
}