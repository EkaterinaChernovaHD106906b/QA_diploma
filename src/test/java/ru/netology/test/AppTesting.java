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

