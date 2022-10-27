package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import com.codeborne.selenide.Configuration;


import ru.netology.db.DbInteraction;
import ru.netology.page.DashboardPage;


import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;

public class OnlineServiceTesting {

    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    @Test
    void firstCardPayment() {
        new DashboardPage()
                .cardPayment("4444 4444 4444 4441")
                .successfulSending();


    }

    @Test
    void firstCardCredit() {
        new DashboardPage()
                .cardCredit("4444 4444 4444 4441")
                .successfulSending();


    }

    @Test
    void secondCardPayment() {
        new DashboardPage()
                .cardPayment("4444 4444 4444 4442")
                .successfulSending();


    }

    @Test
    @SneakyThrows
    void secondCardCredit() {
        new DashboardPage()
                .cardCredit("4444 4444 4444 4442")
                .error();


    }


    @Test
    void cardPaymentInvalidCardNumber() {
        new DashboardPage()
                .cardPayment("4444 4444 4444")
                .invalidFormat();
    }

    @Test
    void cardPaymentExpiredMonth() {
        new DashboardPage()
                .cardPaymentExpiredMonth()
                .invalidFormat();

    }

    @Test
    void cardPaymentInvalidCardNumberZero() {
        new DashboardPage()
                .cardPayment("0000 0000 0000 0000")
                .error();

    }

    @Test
    void cardPaymentInvalidCVC() {
        new DashboardPage()
                .cardPaymentInvalidCVC()
                .invalidFormat();

    }

    @Test
    void cardCreditExpiredYear() {
        new DashboardPage()
                .cardCreditExpiredYear()
                .invalidFormat();

    }

    @Test
    void cardCreditInvalidMonthZero() {
        new DashboardPage()
                .cardCreditInvalidMonthZero()
                .invalidFormat();

    }


    @Test
    void SelectTestSecondCardCredit() {


        new DashboardPage()
                .cardCredit("4444 4444 4444 4442");
        DbInteraction db = new DbInteraction();
        db.statusDeclined();


    }

    @Test
    void SelectTestFirstCardCredit() {


        new DashboardPage()
                .cardCredit("4444 4444 4444 4441");
        DbInteraction db = new DbInteraction();
        db.statusApproved();


    }
}



