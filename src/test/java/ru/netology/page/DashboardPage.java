package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.Data;

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

    public DashboardPage firstCardPayment() {
        buyButton.click();
        cardNumber.setValue(Data.getCardNumberFirst());
        month.setValue(Data.generateMonth(6));
        year.setValue(Data.generateYear(3));
        holder.setValue(Data.generateName("en"));
        CVC.setValue(Data.generateCVV());
        proccedButton.click();
        successfullyNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
        return new DashboardPage();


    }

    public DashboardPage firstCardCredit() {
        creditButton.click();
        cardNumber.setValue(Data.getCardNumberFirst());
        month.setValue(Data.generateMonth(6));
        year.setValue(Data.generateYear(3));
        holder.setValue(Data.generateName("en"));
        CVC.setValue(Data.generateCVV());
        proccedButton.click();
        successfullyNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
        return new DashboardPage();

    }

    public DashboardPage secondCardPayment() {
        buyButton.click();
        cardNumber.setValue(Data.getCardNumberSecond());
        month.setValue(Data.generateMonth(6));
        year.setValue(Data.generateYear(3));
        holder.setValue(Data.generateName("en"));
        CVC.setValue(Data.generateCVV());
        proccedButton.click();
        successfullyNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
        return new DashboardPage();
    }

    public DashboardPage secondCardCredit() {
        creditButton.click();
        cardNumber.setValue(Data.getCardNumberSecond());
        month.setValue(Data.generateMonth(6));
        year.setValue(Data.generateYear(3));
        holder.setValue(Data.generateName("en"));
        CVC.setValue(Data.generateCVV());
        proccedButton.click();
        error.shouldBe(Condition.visible, Duration.ofSeconds(15));
        return new DashboardPage();
    }

    public DashboardPage cardPaymentInvalidCardNumber() {
        buyButton.click();
        cardNumber.setValue("4444 4444 4444");
        month.setValue(Data.generateMonth(6));
        year.setValue(Data.generateYear(3));
        holder.setValue(Data.generateName("en"));
        CVC.setValue(Data.generateCVV());
        proccedButton.click();
        invalidFormat.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return new DashboardPage();

    }

    public DashboardPage cardPaymentExpiredMonth() {
        buyButton.click();
        cardNumber.setValue("4444 4444 4444 4441");
        month.setValue(Data.generateExpiredMonth(3));
        year.setValue(Data.generateThisYear());
        holder.setValue(Data.generateName("en"));
        CVC.setValue(Data.generateCVV());
        proccedButton.click();
        invalidFormat.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return new DashboardPage();


    }

    public DashboardPage cardPaymentInvalidCardNumberZero() {
        buyButton.click();
        cardNumber.setValue("0000 0000 0000 0000");
        month.setValue(Data.generateMonth(6));
        year.setValue(Data.generateYear(3));
        holder.setValue(Data.generateName("en"));
        CVC.setValue(Data.generateCVV());
        proccedButton.click();
        error.shouldBe(Condition.visible, Duration.ofSeconds(15));
        return new DashboardPage();

    }

    public DashboardPage cardPaymentInvalidCVC() {
        buyButton.click();
        cardNumber.setValue("4444 4444 4444 4442");
        month.setValue(Data.generateMonth(6));
        year.setValue(Data.generateYear(3));
        holder.setValue(Data.generateName("en"));
        CVC.setValue(Data.generateInvalidCVV());
        proccedButton.click();
        invalidFormat.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return new DashboardPage();


    }

    public DashboardPage cardCreditExpiredYear() {
        creditButton.click();
        cardNumber.setValue(Data.getCardNumberSecond());
        month.setValue(Data.generateMonth(6));
        year.setValue(Data.generateExpiredYear(2));
        holder.setValue(Data.generateName("en"));
        CVC.setValue(Data.generateCVV());
        proccedButton.click();
        invalidFormat.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return new DashboardPage();
    }

    public DashboardPage cardCreditInvalidMonthZero() {
        creditButton.click();
        cardNumber.setValue(Data.getCardNumberSecond());
        month.setValue("00");
        year.setValue(Data.generateYear(3));
        holder.setValue(Data.generateName("en"));
        CVC.setValue(Data.generateCVV());
        proccedButton.click();
        invalidFormat.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return new DashboardPage();

    }
    public DashboardPage secondCardCreditSelect() {
        creditButton.click();
        cardNumber.setValue(Data.getCardNumberSecond());
        month.setValue(Data.generateMonth(6));
        year.setValue(Data.generateYear(3));
        holder.setValue(Data.generateName("en"));
        CVC.setValue(Data.generateCVV());
        proccedButton.click();
        return new DashboardPage();
    }

}



