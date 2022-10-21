package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;


import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Keys;
import ru.netology.data.Data;
import ru.netology.page.DashboardPage;


import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AppTesting {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
   /* @Test
    void test1() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        //$x("//*[@class='button button_size_m button_theme_alfa-on-white']").click();
        $x("//*[@class='button button_view_extra button_size_m button_theme_alfa-on-white']").click();
        $x("//input[@placeholder='0000 0000 0000 0000']").click();
        $x("//input[@placeholder='0000 0000 0000 0000']").setValue("4444 4444 4444 4442");
        $x("//input[@placeholder='08']").click();
        $x("//input[@placeholder='08']").setValue("10");
        $x("//input[@placeholder='22']").click();
        $x("//input[@placeholder='22']").setValue("22");
        $x("//*[@class='form form_size_m form_theme_alfa-on-white']//div[last()-1]/span/span/span/span/span/input").click();
        $x("//*[@class='form form_size_m form_theme_alfa-on-white']//div[last()-1]/span/span/span/span/span/input").setValue("Alex Navalniy");
        $x("//input[@placeholder='999']").click();
        $x("//input[@placeholder='999']").setValue("645");
        $x("//*[@class='form form_size_m form_theme_alfa-on-white']//div[last()]/button").click();


    }

    @Test
    void test2() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        $x("//*[@class='button button_size_m button_theme_alfa-on-white']").click();
        $x("//*[@class='form form_size_m form_theme_alfa-on-white']//div[last()-1]/span/span/span/span/span/input").click();
        $x("//*[@class='form form_size_m form_theme_alfa-on-white']//div[last()-1]/span/span/span/span/span/input").setValue(Data.generateName("en"));
        $x("//input[@placeholder='999']").click();
        $x("//input[@placeholder='999']").setValue(Data.generateCVV());
        $x("//input[@placeholder='08']").click();
        $x("//input[@placeholder='08']").setValue(Data.generateMonth(6));
        $x("//input[@placeholder='22']").click();
        $x("//input[@placeholder='22']").setValue(Data.generateYear(3));
        $x("//input[@placeholder='0000 0000 0000 0000']").click();
        $x("//input[@placeholder='0000 0000 0000 0000']").setValue(Data.getCardNumberSecond());
    }*/

    @Test
    void test1() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        new DashboardPage()
                .firstCardPayment();


    }

    @Test
    void test2() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        new DashboardPage()
                .firstCardCredit();

    }

    @Test
    void test3() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        new DashboardPage()
                .secondCardPayment();

    }

    @Test
    void test4() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        new DashboardPage()
                .secondCardCredit();

    }

    @Test
    void test5() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        new DashboardPage()
                .cardPaymentInvalidCardNumber();
    }

    @Test
    void test6() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        new DashboardPage()
                .cardPaymentExpiredMonth();

    }

    @Test
    void test7() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        new DashboardPage()
                .cardPaymentInvalidCardNumberZero();

    }

    @Test
    void test8() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        new DashboardPage()
                .cardPaymentInvalidCVC();

    }

    @Test
    void test9() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        new DashboardPage()
                .cardCreditExpiredYear();

    }

    @Test
    void test10() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        new DashboardPage()
                .cardCreditInvalidMonthZero();

    }


}

