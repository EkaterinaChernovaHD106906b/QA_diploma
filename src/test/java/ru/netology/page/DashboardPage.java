package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import ru.netology.data.Data;
import ru.netology.model.Model;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {
    private SelenideElement buyButton = $x("//*[@class='button button_size_m button_theme_alfa-on-white']");
    private SelenideElement creditButton = $x("//*[@class='button button_view_extra button_size_m button_theme_alfa-on-white']");
    private SelenideElement cardNumber = $x("//input[@placeholder='0000 0000 0000 0000']");
    private SelenideElement month = $x("//input[@placeholder='08']");
    private SelenideElement year = $x("//input[@placeholder='22']");
    private SelenideElement holder = $x("//*[@class='form form_size_m form_theme_alfa-on-white']//div[last()-1]/span/span/span/span/span/input");
    private SelenideElement CVC = $x("//input[@placeholder='999']");
    private SelenideElement proccedButton = $x("//*[@class='form form_size_m form_theme_alfa-on-white']//div[last()]/button");
    private SelenideElement successfullyNotification = $x("//*[@class='notification notification_visible notification_status_ok notification_has-closer notification_stick-to_right notification_theme_alfa-on-white']");
    private SelenideElement error = $x("//*[@class='notification notification_visible notification_status_error notification_has-closer notification_stick-to_right notification_theme_alfa-on-white']");
    private SelenideElement invalidFormat = $x("//*[@class='input__sub']");


    public DashboardPage successfulSending() {
        successfullyNotification.shouldBe(Condition.visible, Duration.ofSeconds(20));
        return new DashboardPage();
    }


    public DashboardPage cardPayment(Model.Card card) {
        cardNumber.setValue(card.getNumber());
        month.setValue(card.getMonth());
        year.setValue(card.getYear());
        holder.setValue(card.getHolder());
        CVC.setValue(card.getCVC());
        proccedButton.click();

        return new DashboardPage();
    }

    public DashboardPage payment() {
        buyButton.click();
        return new DashboardPage();
    }

    public DashboardPage credit() {
        creditButton.click();
        return new DashboardPage();
    }


    public DashboardPage error() {
        error.shouldBe(Condition.visible, Duration.ofSeconds(15));
        return new DashboardPage();
    }


    public DashboardPage invalidFormat() {
        invalidFormat.shouldBe(Condition.visible, Duration.ofSeconds(20));
        return new DashboardPage();
    }
}



