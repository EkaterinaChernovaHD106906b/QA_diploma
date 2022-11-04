package ru.netology.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.SneakyThrows;
import lombok.Value;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Data;
import ru.netology.db.DbInteraction;
import ru.netology.model.Model;
import ru.netology.page.DashboardPage;

import static com.codeborne.selenide.Selenide.open;

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
        Model.Card card = new Model.Card("4444 4444 4444 4441", Data.generateMonth(2), Data.generateYear(3), Data.generateName("en"), Data.generateCVV());
        new DashboardPage()
                .payment()
                .cardPayment(card)
                .successfulSending();
    }

    @Test
    void firstCardCredit() {
        Model.Card card = new Model.Card("4444 4444 4444 4441", Data.generateMonth(1), Data.generateYear(1), Data.generateName("en"), Data.generateCVV());
        new DashboardPage()
                .credit()
                .cardPayment(card)
                .successfulSending();
    }

    @Test
    void secondCardPayment() {
        Model.Card card = new Model.Card("4444 4444 4444 4442", Data.generateMonth(1), Data.generateYear(1), Data.generateName("en"), Data.generateCVV());
        new DashboardPage()
                .payment()
                .cardPayment(card)
                .successfulSending();
    }

    @Test
    @SneakyThrows
    void secondCardCredit() {
        Model.Card card = new Model.Card("4444 4444 4444 4442", Data.generateMonth(5), Data.generateYear(3), Data.generateName("en"), Data.generateCVV());
        new DashboardPage()
                .credit()
                .cardPayment(card)
                .error();
    }


    @Test
    void cardPaymentInvalidCardNumber() {
        Model.Card card = new Model.Card("4444 4444 4444", Data.generateMonth(4), Data.generateYear(2), Data.generateName("en"), Data.generateCVV());
        new DashboardPage()
                .payment()
                .cardPayment(card)
                .invalidFormat();
    }

    @Test
    void cardPaymentExpiredMonth() {
        Model.Card card = new Model.Card("4444 4444 4444 4442", Data.generateMonth(-2), Data.generateYear(0), Data.generateName("en"), Data.generateCVV());
        new DashboardPage()
                .payment()
                .cardPayment(card)
                .invalidFormat();
    }

    @Test
    void cardPaymentInvalidCardNumberZero() {
        Model.Card card = new Model.Card("0000 0000 0000 0000", Data.generateMonth(3), Data.generateYear(1), Data.generateName("en"), Data.generateCVV());
        new DashboardPage()
                .payment()
                .cardPayment(card)
                .error();
    }

    @Test
    void cardPaymentInvalidCVC() {
        Model.Card card = new Model.Card("4444 4444 4444 4442", Data.generateMonth(4), Data.generateYear(2), Data.generateName("en"), Data.generateInvalidCVV());
        new DashboardPage()
                .payment()
                .cardPayment(card)
                .invalidFormat();
    }

    @Test
    void cardCreditExpiredYear() {
        Model.Card card = new Model.Card("4444 4444 4444 4441", Data.generateMonth(4), Data.generateYear(-2), Data.generateName("en"), Data.generateCVV());
        new DashboardPage()
                .credit()
                .cardPayment(card)
                .invalidFormat();
    }

    @Test
    void cardCreditInvalidMonthZero() {
        Model.Card card = new Model.Card("4444 4444 4444 4441", "00", Data.generateYear(1), Data.generateName("en"), Data.generateCVV());
        new DashboardPage()
                .credit()
                .cardPayment(card)
                .invalidFormat();
    }
    @Test
    void cardPaymentInvalidName(){
        Model.Card card = new Model.Card("4444 4444 4444 4441", Data.generateMonth(4),Data.generateYear(2),"S",Data.generateCVV());
        new DashboardPage()
                .payment()
                .cardPayment(card)
                .invalidFormat();
    }
    @Test
    void cardPaymentInvalidNameHyphen(){
        Model.Card card = new Model.Card("4444 4444 4444 4441", Data.generateMonth(4),Data.generateYear(2),"-",Data.generateCVV());
        new DashboardPage()
                .payment()
                .cardPayment(card)
                .invalidFormat();
    }
    @Test
    void cardPaymentInvalidNameNumbers(){
        Model.Card card = new Model.Card("4444 4444 4444 4441", Data.generateMonth(4),Data.generateYear(2),"5578687",Data.generateCVV());
        new DashboardPage()
                .payment()
                .cardPayment(card)
                .invalidFormat();
    }


    @Test
    void SelectTestSecondCardCredit() {
        Model.Card card = new Model.Card("4444 4444 4444 4442", Data.generateMonth(1), Data.generateYear(4), Data.generateName("en"), Data.generateCVV());
        new DashboardPage()
                .credit()
                .cardPayment(card);
        DbInteraction db = new DbInteraction();
        db.statusDeclined();
    }

    @Test
    void SelectTestFirstCardCredit() {
        Model.Card card = new Model.Card("4444 4444 4444 4441", Data.generateMonth(4), Data.generateYear(1), Data.generateName("en"), Data.generateCVV());
        new DashboardPage()
                .credit()
                .cardPayment(card);
        DbInteraction db = new DbInteraction();
        db.statusApproved();
    }
}



